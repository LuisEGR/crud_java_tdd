# CRUD - RESTFul
[![Build Status](https://travis-ci.com/LuisEGR/crud_java_tdd.svg?token=akpzpzvQ2pdKfMYRzfGn&branch=master)](https://travis-ci.com/LuisEGR/crud_java_tdd)

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
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 2,
        "municipio": "San Francisco de los Romo"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 3,
        "municipio": "El Llano"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 4,
        "municipio": "Rincón de Romos"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 5,
        "municipio": "Cosío"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 6,
        "municipio": "San José de Gracia"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 7,
        "municipio": "Tepezalá"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 8,
        "municipio": "Pabellón de Arteaga"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 9,
        "municipio": "Asientos"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 10,
        "municipio": "Calvillo"
    },
    {
        "estado": {
            "estado": null,
            "idEstado": 1
        },
        "idMunicipio": 11,
        "municipio": "Jesús María"
    }
]
````


Aplicaciones / Librerias / Framerowks utilizados:

- [https://netbeans.org/] (NetBeans IDE) 
- [http://tomcat.apache.org/] (Tomcat 8)
- [https://maven.apache.org/] (Maven) - Software project management and comprehension tool
- [https://jersey.github.io/] (Jersey) - RESTful Web Services in Java
- [https://mvnrepository.com/artifact/mysql/mysql-connector-java] (mysql-connector-java) <- desde maven
- [https://github.com/FasterXML/jackson] (Jackson) - formerly known as the standard JSON library for Java
- [http://junit.org/](JUnit) - programmer-friendly testing framework for Java 8
