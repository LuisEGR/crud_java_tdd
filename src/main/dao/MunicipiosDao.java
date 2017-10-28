/*
 * MunicipiosDao.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Estado;
import main.datos.Municipio;
import main.dao.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MunicipiosDao extends Dao implements MunicipiosDaoI {

		static final String TABLA = "Municipios";

		/**
		 * Constructor que crea la conexción con la Base de Datos (BD).
		 */
		public MunicipiosDao() {
				super("Biblioteca_Personas", "ISCuenta", "Escom_17");
		}

		/**
		 * Método para obtener todos los Municipios que pertenecen a un estado del
		 * catálogo de la BD.
		 *
		 * @return arreglo de objetos tipo Municipio.
		 *
		 * @author
		 */
		@Override
		public ArrayList<Municipio> obtenerMunicipios(Estado estado) {
				ArrayList<Municipio> municipios = new ArrayList<>();
				try {
						String query = "select * from Municipios where id_estado = ?";
						PreparedStatement ps = super.conexion.prepareStatement(query);
						ps.setInt(1, estado.getIdEstado());
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								municipios.add(new Municipio(rs.getInt("id_municipio"), rs.getString("municipio"), estado));
						}
				} catch (Exception e) {
						System.out.println(e.getMessage());
				}
				return municipios;
		}
}
