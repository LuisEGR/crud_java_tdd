/*
 * MunicipiosDaoI.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 13/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Estado;
import main.datos.Municipio;

import java.util.ArrayList;

/**
 * Interfaz de MunicipiosDao.
 *
 * @author stefan.
 */
public interface MunicipiosDaoI {

		/**
		 * Obtiene los municipios del catálogo de la BD.
		 *
		 * <p>
		 * Solicitud: crud/02_municipio_obtener_municipios.pdf
		 *
		 * @param estado objeto tipo Estado que define los municipios a obtener.
		 * @return ArrayListe de objetos tipo Municipio.
		 */
		public ArrayList<Municipio> obtenerMunicipios(Estado estado);

		/**
		 * Termina conexión con BD.
		 */
		public void cerrarConexion();

}
