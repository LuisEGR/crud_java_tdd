# Group Personas
APIs para la gestión de Personas

## Agregar Persona [/colocarPersona]
### colocarPersona [POST]
Agrega una persona a la base de datos

+ Request Agregar una persona (application/json)
{
    "sexo": {
    "sexo": "Femenino",
    "idSexo": 2
    },
    "nombre": "Bianca Yeseniañez",
    "apPaterno": "Aguilar",
    "deportes": [
    {
    "idDeporte": 1,
    "deporte": "Futbol"
    },
    {
    "idDeporte": 7,
    "deporte": "Natación"
    },
    {
    "idDeporte": 9,
    "deporte": "Yoga"
    }
    ],
    "municipio": {
    "municipio": "Calvillo",
    "idMunicipio": 10,
    "estado": {
    "idEstado": 1,
    "estado": "Aguascalientes"
    }
    },
    "apMaterno": "Martínez"
}
+ Response 200


<!-- INICIO obtenerPersonas/ -->
## Obtener Personas [/obtenerPersonas/{min}/{max}/{?query}]
### obtenerPersonas [GET]
Obtiene un objeto que contiene un arreglo de personas, de tamaño max-min, iniciando por el elemento **min** y hasta el elemento número **max**, si el parámetro *query* es enviado, se aplica primero el filtro y después se toma la cantidad de personas deseadas que cumplan con ese filtro. El parámetro *query* es convertido en el servidor a mayúscula, así que buscar *Luis* y *luis* retornará el mismo resultado.
::: warning
#### <i class="fa fa-warning"></i> Precaución
Si el valor de **min <= 0** la consulta no será exitosa ya que el conteo comienza desde *min = 1*
:::

+ Parameters
    + min: 1 (required, number) - Número del elemento inicial 
    + max: 5 (required, number) - Número del elemento final
    + query: `luis` (optional, string) - Persona a buscar, el nombre o algún apellido.

+ Response 200 (application/json)
    + Body
{
    "segundo": [
    {
    "sexo": null,
    "idPersona": 104,
    "nombre": "José Luis",
    "apPaterno": "Juarez",
    "deportes": null,
    "municipio": null,
    "apMaterno": "Baltazar"
    },
    {
    "sexo": null,
    "idPersona": 49,
    "nombre": "Luis Enrique",
    "apPaterno": "Romero",
    "deportes": null,
    "municipio": null,
    "apMaterno": "Santacruz"
    },
    {
    "sexo": null,
    "idPersona": 149,
    "nombre": "Luis Alberto)",
    "apPaterno": "Zumano",
    "deportes": null,
    "municipio": null,
    "apMaterno": "Rojas"
    }
    ],
    "primero": 3
}


<!-- FIN obtenerPersonas/ -->


## Actualizar Persona [/actualizarPersona]
### actualizarPersona [PUT]
Modifica la información de una persona

::: warning
#### <i class="fa fa-warning"></i> Precaución
Si falta algún campo del objeto Persona en el cuerpo del mensaje la actualización no se llevará a cabo
:::

+ Request Actualizar una persona (application/json)
{
    "idPersona": 2,
    "sexo": {
    "sexo": "Femenino",
    "idSexo": 2
    },
    "nombre": "Bianca Yeseniañez",
    "apPaterno": "Aguilar",
    "deportes": [
    {
    "idDeporte": 1,
    "deporte": "Futbol"
    },
    {
    "idDeporte": 7,
    "deporte": "Natación"
    },
    {
    "idDeporte": 9,
    "deporte": "Yoga"
    }
    ],
    "municipio": {
    "municipio": "Calvillo",
    "idMunicipio": 10,
    "estado": {
    "idEstado": 1,
    "estado": "Aguascalientes"
    }
    },
    "apMaterno": "Martínez"
}

+ Response 200


## Borrar persona [/borrarPersona/{id}]
### borrarPersona [DELETE]
Borrar una persona por su ID

+ Parameters
    + id: 1 (required, number) - Identificador único de la persona a eliminar

+ Response 204
+ Response 404 (application/json)
    + Headers
        X-Request-ID: f72fc914
        X-Response-Time: 4ms
    + Body
        {
            "error": "Note not found"
        }
