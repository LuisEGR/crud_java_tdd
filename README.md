# CRUD - RESTFul
[![Build Status](https://travis-ci.org/LuisEGR/crud_java_tdd.svg?branch=master)](https://travis-ci.org/LuisEGR/crud_java_tdd)

---
Ejemplo de CRUD en JAVA usando TDD con Travis CI 



### /crud/obtenerMunicipios/{id_estado}

> Retorna los municipios que están dentro de ese estado.

Ejemplo:

> GET  
> http://localhost:8084/crud/obtenerMunicipios/1

Respuesta:

````json
[
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 1,
        "municipio": "Aguascalientes"
    }
]
````


Aplicaciones / Librerias / Framerowks utilizados:

- [NetBeans IDE](https://netbeans.org/) 
- [Tomcat 8](http://tomcat.apache.org/)
- [(Maven) - Software project management and comprehension tool](https://maven.apache.org/)
- [Jersey - RESTful Web Services in Java](https://jersey.github.io/) 
- [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
- [Jackson formerly known as the standard JSON library for Java](https://github.com/FasterXML/jackson) 
- [JUnit - programmer-friendly testing framework for Java 8](http://junit.org/)


[![Travis CI](https://workablehr.s3.amazonaws.com/uploads/account/logo/11901/large_Mascot-fullcolor-png.png)](https://travis-ci.org/)