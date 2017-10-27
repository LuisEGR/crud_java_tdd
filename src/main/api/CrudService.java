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

	public Response obtenerMunicipios(int idEstado);	
        public Response colocarPersona(Persona persona);
        public Response actualizarPersona(Persona persona);	
        public Response borrarPersona(int idUsuario);
        public Response obtenerNumeroPersonas();	
        public Response obtenerPersonas();
        public Response obtenerPersona(int idUsuario);
        
}