/* Reemplazo de Crud.java */
package main.service;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import main.dao.DeportesDao;
import main.dao.DeportesDaoI;
import main.dao.EstadosDao;
import main.dao.EstadosDaoI;
import main.dao.MunicipiosDao;
import main.dao.MunicipiosDaoI;
import main.dao.PersonasDao;
import main.dao.PersonasDaoI;
import main.dao.SexosDao;
import main.dao.SexosDaoI;
import main.dao.excepciones.RegistroExistenteException;
import main.datos.Deporte;
import main.datos.Estado;
import main.datos.Municipio;
import main.datos.Persona;
import main.datos.Sexo;
import main.modelo.Validaciones;
import main.modelo.excepciones.ApellidoIncorrectoException;
import main.modelo.excepciones.CamposIncompletosException;
import main.modelo.excepciones.DeportesVaciosException;
import main.modelo.excepciones.NombreIncorrectoException;
import main.utilidades.Par;

import main.api.CrudService;

/**
 * Servlet de ejercicio de Crud.
 *
 * <p>
 * Clase controlador que liga las operaciones del usuario en las vistas (*.jsp y *.html) con las
 * clases internas del modelo.
 *
 * <p>
 * Operaciones disponibles:
 * <ol>
 * <li>GET /crud </li>
 * <li>POST /crud/obtenerMunicipios </li>
 * <li>POST /crud/colocarPersona </li>
 * <li>POST /crud/actualizarPersona </li>
 * <li>POST /crud/borrarPersona </li>
 * <li>POST /crud/obtenerNumeroPersonas </li>
 * <li>POST /crud/obtenerPersonas </li>
 * <li>POST /crud/obtenerPersona </li>
 * </ol>
 *
 * <p>
 * Cada una de estas operaciones se abstrae en un método privado distinto de esta clase. Para más
 * información sobre los propios métodos, ver los javadocs de cada método.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)

public class CrudServiceImpl implements CrudService {

  @Context
  private UriInfo uri;

  /* DAOs */
  private final EstadosDaoI estadosDao = new EstadosDao();
  private final DeportesDaoI deportesDao = new DeportesDao();
  private final MunicipiosDaoI municipiosDao = new MunicipiosDao();
  private final PersonasDaoI personasDao = new PersonasDao();
  private final SexosDaoI sexosDao = new SexosDao();
  
  @Override
  public void finalize() {
    estadosDao.cerrarConexion();
    deportesDao.cerrarConexion();
    municipiosDao.cerrarConexion();
    personasDao.cerrarConexion();
    sexosDao.cerrarConexion();
  }

  @Override
  @GET
  @Path("/obtenerEstados")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerEstados() {
    
    Response.ResponseBuilder responseBuilder = null;
    ArrayList<Estado> catalogoEstados = estadosDao.obtenerEstados();
    responseBuilder = Response.ok(catalogoEstados, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }
  
  @Override
  @GET
  @Path("/obtenerSexos")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerSexos() {
    
    Response.ResponseBuilder responseBuilder = null;
    ArrayList<Sexo> catalogoSexos = sexosDao.obtenerSexos();
    responseBuilder = Response.ok(catalogoSexos, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }
  
  @Override
  @GET
  @Path("/obtenerDeportes")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerDeportes() {
    
    Response.ResponseBuilder responseBuilder = null;
    ArrayList<Deporte> catalogoDeportes = deportesDao.obtenerDeportes();
    responseBuilder = Response.ok(catalogoDeportes, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }
  
  @Override
  @GET
  @Path("/obtenerMunicipios/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerMunicipios(@PathParam("id") int idEstado) {
    	
    Response.ResponseBuilder responseBuilder = null;
    Estado estado = new Estado();
    estado.setIdEstado(idEstado);
    ArrayList<Municipio> catalogoMunicipios = municipiosDao.obtenerMunicipios(estado);
    responseBuilder = Response.ok(catalogoMunicipios, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }

  @Override
  @PUT
  @Path("/colocarPersona")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response colocarPersona(Persona persona) {
    System.out.println("DEBUG: " + persona);
    Response.ResponseBuilder responseBuilder = null;
    int codigo;
    try {
      Validaciones.validarPersona(persona);
      personasDao.insertarPersona(persona);
      codigo = 1;
    } catch (NombreIncorrectoException e) {
      codigo = 2;
    } catch (ApellidoIncorrectoException e) {
      codigo = 3;
    } catch (CamposIncompletosException e) {
      codigo = 4;
    } catch (RegistroExistenteException e) {
      codigo = 5;
    } catch (DeportesVaciosException e) {
      codigo = 4;
    } catch (Exception e) {
      codigo = 6;
    }
    responseBuilder = Response.ok("" + codigo, "text/plain;charset=UTF-8");
    return responseBuilder.build();
  }

  @Override
  @POST
  @Path("/actualizarPersona")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizarPersona(Persona persona) {
    Response.ResponseBuilder responseBuilder;
    int codigo;
    try {
      Validaciones.validarPersona(persona);
      personasDao.actualizarPersona(persona);
      codigo = 1;
    } catch (NombreIncorrectoException e) {
      codigo = 2;
    } catch (ApellidoIncorrectoException e) {
      codigo = 3;
    } catch (CamposIncompletosException e) {
      codigo = 4;
    } catch (DeportesVaciosException e) {
      codigo = 4;
    } catch (Exception e) {
      codigo = 6;
    }
    responseBuilder = Response.ok("" + codigo, "text/plain;charset=UTF-8");
    return responseBuilder.build();
  }

  @Override
  @DELETE
  @Path("/borrarPersona/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public Response borrarPersona(@PathParam("id") int idUsuario) {
    
    Response.ResponseBuilder responseBuilder = null;
    Persona persona = new Persona();
    persona.setIdPersona(idUsuario);
    personasDao.borrarPersona(persona);
    responseBuilder = Response.ok("Borrado exitoso", "text/plain;charset=UTF-8");
    return responseBuilder.build();
    
  }

  @Override
  @GET
  @Path("/obtenerPersonas/{min}/{max}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerPersonas(@PathParam("min") int minimo, 
      @PathParam("max") int maximo, @QueryParam("query") String consulta) {
    
    consulta = (consulta == null) ? "" : consulta;
    Response.ResponseBuilder responseBuilder = null;
    Par<Integer, ArrayList<Persona>> personas
        = personasDao.obtenerPersonas(minimo, maximo, consulta);
    responseBuilder = Response.ok(personas, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }

  @Override
  @GET
  @Path("/obtenerPersona/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtenerPersona(@PathParam("id") int idUsuario) {
    
    Response.ResponseBuilder responseBuilder = null;
    Persona persona = personasDao.obtenerPersona(idUsuario);
    responseBuilder = Response.ok(persona, "application/json;charset=UTF-8");
    return responseBuilder.build();
    
  }

}
