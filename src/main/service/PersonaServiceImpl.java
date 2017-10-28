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
 * Clase controlador que liga las operaciones del usuario en las vistas (*.jsp y
 * *.html) con las clases internas del modelo.
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
 * Cada una de estas operaciones se abstrae en un método privado distinto de
 * esta clase. Para más información sobre los propios métodos, ver los javadocs
 * de cada método.
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)

public class PersonaServiceImpl implements CrudService {

		@Context
		private UriInfo uri;

		/* ---- Book API ---- */

 /* DAOs */
		private EstadosDaoI estadosDao;
		private DeportesDaoI deportesDao;
		private MunicipiosDaoI municipiosDao = new MunicipiosDao();
		private PersonasDaoI personasDao;
		private SexosDaoI sexosDao;

		@Override
		@GET
		@Path("/obtenerMunicipios/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response obtenerMunicipios(@PathParam("id") int idEstado) {
				//return getMunicipios(idEstado);	
				Response.ResponseBuilder responseBuilder = null;

				// Get lista de estados
				Estado estado = new Estado();
				estado.setIdEstado(idEstado);
				ArrayList<Municipio> catalogoMunicipios = municipiosDao.obtenerMunicipios(estado);
				responseBuilder = Response.ok(catalogoMunicipios, "application/json;charset=UTF-8");

				return responseBuilder.build();
		}

		@Override
		@POST
		@Path("/colocarPersona")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response colocarPersona(Persona persona) {
				Response.ResponseBuilder responseBuilder = null;
				//responseBuilder = Response.ok(persona, "application/json;charset=UTF-8");
				//responseBuilder = Response.ok("Ok", "application/json;charset=UTF-8");
				return responseBuilder.build();
		}

		@Override
		@PUT
		@Path("/crud/actualizarPersona")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response actualizarPersona(Persona persona) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		@DELETE
		@Path("/borrarPersona/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response borrarPersona(@PathParam("id") int idUsuario) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		@GET
		@Path("/obtenerNumeroPersonas")
		@Produces(MediaType.APPLICATION_JSON)
		public Response obtenerNumeroPersonas() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		@GET
		@Path("/obtenerPersonas")
		@Produces(MediaType.APPLICATION_JSON)
		public Response obtenerPersonas() {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		@GET
		@Path("/obtenerPersona/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response obtenerPersona(@PathParam("id") int idUsuario) {
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

}
