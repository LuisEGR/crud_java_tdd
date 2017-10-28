/*
 * EstadosDao.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Estado;
import main.dao.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstadosDao extends Dao implements EstadosDaoI {

		static final String TABLA = "Estados";

		/**
		 * Constructor que crea la conexción con la Base de Datos (BD).
		 */
		public EstadosDao() {
				super("Biblioteca_Personas", "ISCuenta", "Escom_17");
		}

		/**
		 * Método para obtener todos los estados del catálogo de la BD.
		 *
		 * @return arreglo de objetos tipo Estado.
		 *
		 * @author Aidee
		 */
		@Override
		public ArrayList<Estado> obtenerEstados() {
				ArrayList<Estado> estados = new ArrayList<>();
				Estado estado = new Estado();
				try {

						String query = "select * from Estados";
						PreparedStatement ps = super.conexion.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								estados.add(new Estado(rs.getInt("id_estado"), rs.getString("estado")));
						}
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
				return estados;
		}

}
