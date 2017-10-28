crudExample.controller("crudController", ['$scope', 'CRUD_API', '$mdDialog', function ($scope, CRUD_API, $mdDialog) {
    $scope.numeroPersonas;
    $scope.user = {};
    $scope.form = {};
    $scope.deporteTmp = {};
    $scope.selected = [];
    $scope.search;
    $scope.label = {
      page: 'Página:',
      rowsPerPage: 'Filas por página:',
      of: 'de'
    };
    $scope.query = {
      limit: 5,
      page: 1
    };
    var min = ($scope.query.page - 1) * $scope.query.limit + 1;
    var max = $scope.query.page * $scope.query.limit;

    CRUD_API.getUsersRange(min, max).then(function (res) {
      $scope.users = res.data.personas;
      $scope.numeroPersonas = res.data.resultados;
    });

    CRUD_API.getEstados().then(function (usrs) {
      $scope.estados = usrs.data;
    });

    CRUD_API.getSexos().then(function (usrs) {
      $scope.sexos = usrs.data;
    });

    CRUD_API.getDeportes().then(function (usrs) {
      $scope.deportes = usrs.data;
      console.log($scope.deportes);
    });

    $scope.getData = function (page, limit) {
      console.log("Obtener usuarios...");
      var min = (page - 1) * limit + 1;
      var max = page * limit;
      $scope.promise = CRUD_API.getUsersRange(min, max, $scope.search).then(function (res) {
        $scope.users = res.data.personas;
        $scope.numeroPersonas = res.data.resultados;
      });
    };

    $scope.getMunicipios = function () {
      var estado = $scope.user.municipio.estado.idEstado;
      CRUD_API.getMunicipios(estado).then(function (res) {
        $scope.municipios = res.data;
      });
    };

    $scope.setDeportesAsArray = function () {
      console.log($scope.deporteTmp);
      var tmp = Object.values($scope.deporteTmp).filter(function (e) {
        return e !== false
      });
      $scope.user.deportes = [];
      for (var i = 0; i < tmp.length; i++) {
        $scope.user.deportes[i] = {'idDeporte': tmp[i]};
      }
    };

    /* Se llama al presionar el botón de «Agregar». Permite limpiar los datos de formularios
     * anteriores. */
    $scope.agregarUsuario = function (ev) {
      $scope.deporteTmp = {};
      $scope.user = {};
      /*$scope.user.nombre="";
       $scope.user.apPaterno="";
       $scope.user.apMaterno="";*/
      $scope.addUser(ev);
    };

    $scope.addUser = function (ev) {
      $mdDialog.show({
        contentElement: '#modalAgregarUsuario',
        parent: angular.element(document.body),
        targetEvent: ev,
        clickOutsideToClose: true
      });
    };

    $scope.sendFormAddUser = function (ev) {
      $scope.setDeportesAsArray();
      CRUD_API.agregarUsuario($scope.user).then(function (msg) {
        $scope.totalusers += 1;
        $scope.getData($scope.query.page, $scope.query.limit);
        $scope.deporteTmp = {};
        $scope.user = {};
        $mdDialog.show(
                $mdDialog.alert()
                .clickOutsideToClose(true)
                .title('Respuesta del servidor')
                .textContent(msg.data)
                .ok('Ok!')
                .targetEvent(ev)
                );
        $scope.user = {};
      });
    };


    $scope.eliminarUsuario = function (ev, uid) {
      var confirm = $mdDialog.confirm()
              .title('¿Estás seguro de que quieres eliminar este usuario?')
              .textContent('Esta acción no se puede deshacer.')
              .targetEvent(ev)
              .ok('Eliminar!')
              .cancel('Cancelar');

      $mdDialog.show(confirm).then(function () {
        CRUD_API.eliminarUsuario(uid).then(function (msg) {
          $scope.totalusers += 1;
          $scope.getData($scope.query.page, $scope.query.limit);
          $mdDialog.show(
                  $mdDialog.alert()
                  .clickOutsideToClose(true)
                  .title('Respuesta del servidor')
                  .textContent(msg.data)
                  .ok('Ok!')
                  .targetEvent(ev)
                  );
        });
      }, function () {
        console.log("Acción cancelada");
      });
    };

    $scope.editarUsuario = function (ev, uid) {
      CRUD_API.getUser(uid).then(function (res) {
        $scope.user = res.data;
        for (var i = 0; i < res.data.deportes.length; i++) {
          var deporte = res.data.deportes[i].idDeporte - 1;
          $scope.deporteTmp[deporte] = deporte + 1;
        }
        $scope.addUser(ev);
        $scope.getMunicipios();
      });
    };

    $scope.sendFormEditUser = function (ev, data) {
      $scope.setDeportesAsArray();
      CRUD_API.editarUsuario($scope.user).then(function (msg) {
        $scope.getData($scope.query.page, $scope.query.limit);
        $scope.deporteTmp = {};
        $scope.user = {};
        $mdDialog.show(
                $mdDialog.alert()
                .clickOutsideToClose(true)
                .title('Respuesta del servidor')
                .textContent(msg.data)
                .ok('Ok!')
                .targetEvent(ev)
                );
      });
    };

  }]);
