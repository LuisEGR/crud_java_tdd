/*
 * EstadosDaoI.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 13/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Estado;

import java.util.ArrayList;

/**
 * Interfaz de EstadosDao.
 *
 * @author stefan.
 */
public interface EstadosDaoI {

		/**
		 * Obtiene todos los estados del catálogo en la BD.
		 *
		 * <p>
		 * Solicitud: crud/01_estado_obtener_estados.pdf
		 *
		 * @return ArrayList de objetos tipo Estado.
		 */
		public ArrayList<Estado> obtenerEstados();

		/**
		 * Termina conexión con BD.
		 */
		public void cerrarConexion();

}
