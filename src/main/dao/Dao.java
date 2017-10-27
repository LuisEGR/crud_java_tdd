/*
 * Dao.java
 * Este archivo es parte del módulo de clases genéricas, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */

package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

  protected Connection conexion = null;

  /**
   * Constructor que crea la conexción con la Base de Datos (BD).
   */

  public Dao(String baseDeDatos, String usuario, String contrasenia) {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      conexion = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/" + baseDeDatos, usuario, contrasenia);
    } catch (InstantiationException | IllegalAccessException
            | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Termina conexión en la BD.
   */

  public void cerrarConexion() {
    try {
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}

