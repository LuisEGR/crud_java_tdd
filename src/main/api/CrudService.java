package main.api;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import main.datos.Persona;

/**
 * Operaciones para el CRUD
 *
 * @author "Luis"
 *
 */
public interface CrudService {

  public Response obtenerEstados();
  
  public Response obtenerDeportes();
  
  public Response obtenerSexos();

  public Response obtenerMunicipios(int idEstado);

  public Response colocarPersona(Persona persona);

  public Response actualizarPersona(Persona persona);

  public Response borrarPersona(int idUsuario);

  public Response obtenerPersonas(int minimo, int maximo, String consulta);

  public Response obtenerPersona(int idUsuario);

}
