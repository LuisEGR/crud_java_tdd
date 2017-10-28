/*
 * SexosDaoI.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 13/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Sexo;

import java.util.ArrayList;

/**
 * Interfaz de SexosDao.
 *
 * @author stefan.
 */
public interface SexosDaoI {

		/**
		 * Obtiene todos los sexos del catálogo de la BD.
		 *
		 * <p>
		 * Solicitud: crud/05_sexo_obtener_sexos.pdf
		 *
		 * @return ArrayList de objetos de tipo Sexo.
		 */
		public ArrayList<Sexo> obtenerSexos();

		/**
		 * Termina conexión con BD.
		 */
		public void cerrarConexion();

}
