/*
 * DeportesDaoI.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 13/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Deporte;

import java.util.ArrayList;

/**
 * Interfaz de DeportesDao.
 *
 * @author stefan.
 */
public interface DeportesDaoI {

		/**
		 * Obtiene todos los deportes del catálogo en la BD.
		 *
		 * @return ArrayList de objetos tipo Deporte.
		 */
		public ArrayList<Deporte> obtenerDeportes();

		/**
		 * Termina conexión con BD.
		 */
		public void cerrarConexion();

}
