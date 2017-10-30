# CRUD - RESTFul 
[![Build Status](https://travis-ci.org/LuisEGR/crud_java_tdd.svg?branch=master)](https://travis-ci.org/LuisEGR/crud_java_tdd) :octocat: 

---
Ejemplo de CRUD en JAVA usando TDD con Travis CI 

### Flujo de trabajo ###

1. Un programador realiza sus actualizaciones y hace un *push* a *github* con
   sus cambios.
2. *Github* se comunica con *Travis* para la ejecución de las pruebas.
3. En caso de que las pruebas sean negativas el programador debe corregir (el
   ícono de abajo del título de este README indica el estado del proyecto).
4. Sí las pruebas fueron positivas, *Travis* despliega la aplicación en
   *Heroku*, para que todos puedan ver los últimos avances sin necesidad de
   correr el proyecto en sus máquinas.

[Esta es la liga](https://ejercicio-crud.herokuapp.com/) de *Heroku*. Se trata
de una cuenta gratis, por lo que el número de hilos se limita a 1; es por esto
que en ocasiones puede ser lento o puede no estar disponible.

PD: La conexión con base de datos en *heroku* aún no funciona.


Métodos disponibles:
- :heavy_check_mark: **POST** `colocarPersona` : Agregar una persona nueva
- :heavy_check_mark: **GET** `obtenerPersonas` : Obtener un arreglo de personas
- :heavy_check_mark: **PUT** `actualizarPersona` : Actualizar información de una persona
- :heavy_check_mark: **DELETE** `borrarPersona` : Eliminar una persona
- :heavy_check_mark: **GET** `obtenerEstados` : Obtener todos los estados registrados
- :heavy_check_mark: **GET** `obtenerMunicipios`: Obtener todos los municipios de un estado
- :heavy_check_mark: **GET** `obtenerDeportes`: Obtener todos los deportes registrados
- :heavy_check_mark: **GET** `obtenerSexos`: Obtener todos los sexos registrados

Documentación completa con API Blueprint:
[https://luisegr.github.io/crud_java_tdd/](https://luisegr.github.io/crud_java_tdd/)


----
----
Aplicaciones / Librerias / Framerowks utilizados:

- [NetBeans IDE](https://netbeans.org/) 
- [Tomcat 8](http://tomcat.apache.org/)
- [(Maven) - Software project management and comprehension tool](https://maven.apache.org/)
- [Jersey - RESTful Web Services in Java](https://jersey.github.io/) 
- [mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java) 
- [Jackson formerly known as the standard JSON library for Java](https://github.com/FasterXML/jackson) 
- [JUnit - programmer-friendly testing framework for Java 8](http://junit.org/)
- [JUnit5 - programmer-friendly testing framework for Java 8](http://junit.org/)
- [Heroku - Para desplegar aplicaciones web](https://dashboard.heroku.com/apps)

[![Travis CI](https://workablehr.s3.amazonaws.com/uploads/account/logo/11901/large_Mascot-fullcolor-png.png)](https://travis-ci.org/)
