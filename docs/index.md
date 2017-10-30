FORMAT: 1A
HOST: http://localhost:8084/crud/api

# CRUD 

::: note
## Configuración inicial
Antes de poder tener acceso a estas APIs, se debe de ejecutar el proyecto crud_java_tdd en el servidor Tomcat 8, por defecto está en el puerto **8084**, en caso de ejecutarse en GlassFish el puerto a utilizar en las urls aquí presentadas deberá ser cambiado a **8080**
:::

## Códigos de respuesta
Se recomienda hacer uso de los códigos de respuesta del [estándar HTTP](https://tools.ietf.org/html/rfc7231) correspondientes:

**2×× Success**
- 200 OK  
- 201 Created  
- 202 Accepted  
- 204 No Content  

**Client Error**
- 400 Bad Request  
- 401 Unauthorized  
- 404 Not Found  
- 405 Method Not Allowed  
- 408 Request Timeout  
- 422 Unprocessable Entity  
- 428 Precondition Required  
- 429 Too Many Requests  

**5×× Server Error**
- 500 Internal Server Error  
- 501 Not Implemented  
- 503 Service Unavailable  
- 599 Network Connect Timeout Error  

<!-- include(data_structures.md) -->

<!-- include(personas.md) -->

<!-- include(catalogos.md) -->
