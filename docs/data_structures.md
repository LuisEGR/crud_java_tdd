# Data Structures

## Estado
+ idEstado: 1 (required, number) - Identificador único
+ estado: Aguascalientes (string)

## ListaEstados (array)
+ (Estado)

## Municipio
+ idMunicipio: 1 (required, number) - Identificador único
+ municipio: El Llano (string)
+ estado: (Estado)

## Deporte
+ idDeporte : 1 (required, number) - Identificador único
+ deporte: Futbol (required, string) - Nombre del deporte

## Persona
+ idPersona: 1 (required, number) - Identificador único
+ nombre: Luis Enrique (required, string) - Nombre(s)
+ apPaterno: González (required, string) - Apellido Paterno
+ apMaterno: Rodríguez (required, string) - Apellido Materno
+ deportes: (Deporte)
+ municipio: Municipio

## ListaDeportes (array)
+ (Deporte)

## Sexo
+ idSexo: 1 (required, number) - Identificador único
+ sexo: Masculino (required, string) - Sexo

## ListaSexos (array)
+ (Sexo)


## ListaMunicipios (array)
+ (Municipio)