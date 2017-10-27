/*
 * DeportesDao.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */

package main.dao;

import main.datos.Deporte;
import main.dao.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeportesDao extends Dao implements DeportesDaoI {

  static final String TABLA = "Deportes";

  /**
   * Constructor que crea la conexción con la Base de Datos (BD).
   */

  public DeportesDao() {
    super("Biblioteca_Personas", "ISCuenta", "Escom_17");
  }

  /**
   * Método para obtener todos los deportes del catálogo de la BD.
   * @return arreglo de objetos tipo Deporte.
   *
   * @author Daniel Ayala Zamorano
   */

  @Override
  public ArrayList<Deporte> obtenerDeportes() {
    ArrayList<Deporte> deportes = new ArrayList<Deporte>();
    String sql = "SELECT * FROM " + TABLA;
    PreparedStatement ps = null;
    Deporte deporte;
    String nombre;
    int id;
    try{
      ps = conexion.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        id = rs.getInt("id_deporte");
        nombre = rs.getString("deporte");
        deporte = new Deporte(id,nombre);
        deportes.add(deporte);
      }
    }catch(SQLException e){
      e.getMessage();
    }
    return deportes;
  }

}
