var crudExample = angular.module("EjemploCRUD", ['ngMaterial', 'md.data.table', 'ngMdIcons'])

        .service("GLOBALS", function () {
          return {
            URL_API: "/crud/api"
          }
        })
        .service("CRUD_API", ['$http', 'GLOBALS', function ($http, GLOBALS) {
            return {
              getUsers: function (from, to) {
                return $http.get(GLOBALS.URL_API + "/obtenerPersona");
              },

              getUsersRange: function (from, to, query) {
                var q = angular.isUndefined(query) || query == '' ? "" : "&q=" + query;
                return $http.get(GLOBALS.URL_API + "/obtenerPersonasRango?min=" + from + "&max=" + to + q);
              },

              getEstados: function () {
                return $http.get(GLOBALS.URL_API + "/obtenerEstados");
              },

              getSexos: function () {
                return $http.get(GLOBALS.URL_API + "/obtenerSexos");
              },

              getDeportes: function () {
                return $http.get(GLOBALS.URL_API + "/obtenerDeportes");
              },

              getMunicipios: function (idEstado) {
                return $http.get(GLOBALS.URL_API + "/obtenerMunicipios?idEstado=" + idEstado);
              },
              agregarUsuario: function (data) {
                return $http.post(GLOBALS.URL_API + "/colocarPersona", data);
              },

              editarUsuario: function (data) {
                return $http.post(GLOBALS.URL_API + "/actualizarPersona", data);
              },

              eliminarUsuario: function (idUser) {
                return $http.get(GLOBALS.URL_API + "/borrarPersona?idUser=" + idUser);
              },

              getUser: function (idUser) {
                return $http.get(GLOBALS.URL_API + "/obtenerPersona?idUser=" + idUser);
              },

            }
          }])

        .service("API_statistics", ['$http', 'GLOBALS', function ($http, GLOBALS) {
            return {
              getPorEstados: function () {
                // return $http.get("https://api.myjson.com/bins/ufc5j");
                return $http.get(GLOBALS.URL_API + "/graficacion/obtenerEstadisticasEstados");
              },
              getPorMunicipios: function (idEstado) {
                //return $http.get("http://jsonbin.io/b/59ee8f604fc5fd7592dc19bd");
                return $http.get(GLOBALS.URL_API + "/graficacion/obtenerEstadisticasMunicipios?idEstado=" + idEstado);
              },
              getPorSexos: function () {
                return $http.get(GLOBALS.URL_API + "/graficacion/obtenerEstadisticasSexos");
              }
            }
          }])

        .service("API_catalogos", ['$http', 'GLOBALS', function ($http, GLOBALS) {
            return {
              getEstados: function () {
                return $http.get(GLOBALS.URL_API + "/obtenerEstados");
              }
            }
          }])
