/*
 * PersonasDaoI.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 13/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */

package main.dao;

import main.datos.Persona;
import main.dao.excepciones.RegistroExistenteException;
import main.datos.Estado;
import main.utilidades.Par;

import java.util.ArrayList;

/**
 * Interfaz de PersonasDao.
 * @author stefan.
 */

public interface PersonasDaoI {

  /**
   * Crea un nuevo registro en la BD.
   *
   * <p>Solicitud: crud/06_persona_insertar_persona.pdf
   *
   * @param persona objeto tipo PersonaJson con los datos a insertar.
   */

  public void insertarPersona(Persona persona) throws RegistroExistenteException;

  /**
   * Modifica los datos de una persona en la BD.
   *
   * <p>Solicitud: crud/07_persona_actualizar_persona.pdf
   *
   * @param persona objeto tipo Persona con los datos a modificar.
   */

  public void actualizarPersona(Persona persona);

  /**
   * Elimina el registro especificado en la BD.
   * @param persona objeto de tipo Persona con los datos a eliminar.
   */

  public void borrarPersona(Persona persona);

  /**
   * Obtiene el número de personas registradas en la BD.
   * @return número de registros.
   */

  public int obtenerNumeroPersonas();

  /**
   * Consulta las personas dentro del rango de registros especificado.
   *
   * <p>Solicitud: crud/03_persona_obtener_personas.pdf
   *
   * @param idMin id mínimo a consultar.
   * @param idMax id mácimo a consultar.
   * @return ArrayList de objetos tipo Persona únicamente con los datos id, nombre y apellidos,
    dentro del rango especificado (idMin - idMax).
   */

  public Par obtenerPersonas(int min, int max, String consulta);

  /**
   * Obtiene el registro correspondiente en la BD.
   *
   * <p>Solicitud: crud/04_persona_obtener_persona.pdf
   *
   * @param id indica el identificador de la persona a obtener.
   * @return objeto de tpo Persona con todos los datos llenos.
   */

  public Persona obtenerPersona(int id);

  /**
   * Termina conexión con BD.
   */

  public void cerrarConexion();

  /**
   * Obtiene el número de personas registradas por estado.
   * @return ArrayList de objetos de tipo Par que contienen a su vez un objeto de tipo Estado
    además de un entero con el número de personas registradas en dicho estado.
   */

  public ArrayList <Par> obtenerEstadisticasEstados();

  /**
   * Obtiene el número de personas registradas por municipio.
   * @param estado objeto de tipo Estado para ubicar los municipios a tomar en cuenta.
   * @return ArrayList de objetos de tipo Par que contienen a su vez un objeto de tipo Municipio
    además de un entero con el número de personas registradas en dicho municipio.
   */

  public ArrayList <Par> obtenerEstadisticasMunicipios(Estado estado);

  /**
   * Obtiene el número de mujeres y hombres registrados en la BD.
   * @return objeto de tipo Par que contiene dos enteros para el número de mujeres y hombres
    registrados.
   */

  public ArrayList <Par> obtenerEstadisticasSexos();

  /**
   * Obtiene el número de personas registradas por año.
   * @return objeto de tipo Par que contiene dos enteros: el primero para el año y el segundo
   * para el número de personas registradas en él.
   */

  public ArrayList<Par> obtenerEstadisticasAnios();

}
