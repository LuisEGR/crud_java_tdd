# Group Catálogos
> APIs para obtener datos de los catálogos de `Municipios`, `Estados`, `Deportes` y `Sexos`



<!-- INICIO obtenerEstados/ -->

## Obtener Estados [/obtenerEstados]
### obtenerEstados [GET]
Obtiene una lista de Estados
+ Response 200 (application/json)
    + Attributes (ListaEstados)
     
<!-- FIN obtenerEstados/ -->

<!-- INICIO ObtenerMunicipios/ -->

## Obtener Municipios [/obtenerMunicipios/{idEstado}]
+ Parameters
    + idEstado: 1 (required, number) - El id del estado
### obtenerMunicipios [GET]
Obtiene una lista de municipios
+ Response 200 (application/json)
    + Attributes (ListaMunicipios)
     
<!-- FIN ObtenerMunicipios/ -->


<!-- INICIO obtenerDeportes/ -->

## Obtener Deportes [/obtenerDeportes/]
Obtiene una lista de los deportes registrados en la base de datos
### obtenerDeportes [GET]
+ Response 200 (application/json)
    + Attributes (ListaDeportes)

<!-- FIN obtenerDeportes/ -->



<!-- INICIO obtenerSexos/ -->

## Obtener Sexos [/obtenerSexos/]
Obtiene una lista de los Sexos registrados en la base de datos
### obtenerSexos [GET]
+ Response 200 (application/json)
    + Attributes (ListaSexos)

<!-- FIN obtenerSexos/ -->