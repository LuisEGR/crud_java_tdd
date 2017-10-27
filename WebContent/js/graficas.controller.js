crudExample.controller("graficasController", ['$scope', 'API_catalogos', 'API_statistics', function ($scope, API_catalogos, API_statistics) {
    $scope.estadoS = "";
    $scope.dataGraficaPorEstadosBarras = {};
    $scope.dataGraficaPorEstados = {//columnas
        chart: { type: 'column' },
        title: { text: 'Personas registradas por estado' },
        subtitle: { text: 'Hasta el día de hoy' },
        xAxis: {
            categories: [],
            crosshair: true,
            title: {
                text: 'Estado'
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Número de personas'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
            pointFormat: '<tr><td style="padding:0"><b>{point.y}</b></td>' +
            '<td style="color:{series.color};padding:0">{series.name} </td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: []
    };
    
    $scope.dataGraficaPorMunicipiosBarras = {
      chart: { type: 'bar' },
      title: { text: 'Personas registradas por Municipio' },
      subtitle: { text: 'Hasta el día de hoy' },
      xAxis: {
          categories: [],
          crosshair: true,
          title: {
              text: 'Municipio'
          }
      },
      yAxis: {
          min: 0,
          title: {
              text: 'Número de personas'
          }
      },
      tooltip: {
          headerFormat: '<span style="font-size:15px">{point.key}</span><table>',
          pointFormat: '<tr><td style="padding:0"><b>{point.y}</b></td>' +
          '<td style="color:{series.color};padding:0">{series.name} </td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
      },
      plotOptions: {
          column: {
              pointPadding: 0.2,
              borderWidth: 0
          }
      },
      series: []
    }
    
    $scope.dataGraficaPorSexos = {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Sexos de personas registradas'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: []
    }

    API_catalogos.getEstados().then(function(usrs){
      $scope.estados = usrs.data;
    });

    API_statistics.getPorEstados().then(function (res) {
        console.log(res);
        let estados = res.data.map(function (estado) {
            return estado.primero.estado;
        })
        // estados => ["México", "Jalisco", "Tlaxcala", "Yucatán", "Durango"]

        let numsPersonas = res.data.map(function(estado){
            return estado.segundo;
        })
        // numsPersonas => [100, 50, 1, 20, 5]

        $scope.dataGraficaPorEstados.xAxis.categories = estados;
        $scope.dataGraficaPorEstados.series = [{
            name: "Personas registradas",
            data: numsPersonas
        }];

        Highcharts.chart('containerPorEstadosColumnas', $scope.dataGraficaPorEstados);//columnas

        angular.copy($scope.dataGraficaPorEstados, $scope.dataGraficaPorEstadosBarras);
        console.log($scope.dataGraficaPorEstadosBarras)
        $scope.dataGraficaPorEstadosBarras.chart.type = "bar";
        Highcharts.chart('containerPorEstadosBarras', $scope.dataGraficaPorEstadosBarras);//barras
        
    });
    
    $scope.changeEstado = function(){
      API_statistics.getPorMunicipios($scope.estadoS).then(function(res){
      
        let municipios = res.data.map(function (municipio) {
          return municipio.primero.municipio;
        });
        console.log(municipios,"municipios");
        let numsPersonas = res.data.map(function(municipio){
          return municipio.segundo;
        });
        console.log(numsPersonas, "numPersonas");
        $scope.dataGraficaPorMunicipiosBarras.xAxis.categories = municipios;
        $scope.dataGraficaPorMunicipiosBarras.series = [{
          name: "Personas registradas",
          data: numsPersonas
        }];
        Highcharts.chart('containerPorMunicipiosBarras', $scope.dataGraficaPorMunicipiosBarras);//columnas
      });
    };

    API_statistics.getPorSexos().then(function(res){
        let sexos = res.data.map(function (sexo) {
          var data = {
            name : sexo.primero.sexo,
            y : sexo.segundo
          }
          return data;
        });
        console.log(sexos,"sexos");
        $scope.dataGraficaPorSexos.series = [{
          name: "Personas registradas",
          data: sexos
        }];
        console.log(sexos, "sexos");
        Highcharts.chart('containerPorSexos', $scope.dataGraficaPorSexos);
    });

}]);
