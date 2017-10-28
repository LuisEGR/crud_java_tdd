/*
 * SexosDao.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.datos.Sexo;
import main.dao.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SexosDao extends Dao implements SexosDaoI {

		static final String TABLA = "Sexos";

		/**
		 * Constructor que crea la conexción con la Base de Datos (BD).
		 */
		public SexosDao() {
				super("Biblioteca_Personas", "ISCuenta", "Escom_17");
		}

		/**
		 * Método para obtener todos los sexos del catálogo de la BD.
		 *
		 * @return arreglo de objetos tipo Sexo.
		 *
		 * @author
		 */
		@Override
		public ArrayList<Sexo> obtenerSexos() {
				ArrayList<Sexo> sexos = new ArrayList<Sexo>();
				Sexo sexo;
				String Consulta;

				try {
						Consulta = "select * from Sexos";
						PreparedStatement st = super.conexion.prepareStatement(Consulta);
						ResultSet rs = st.executeQuery();

						while (rs.next()) {

								sexo = new Sexo(rs.getInt("id_sexo"), (String) rs.getString("sexo"));
								sexos.add(sexo);

						}
						rs.close();
						st.close();

				} catch (SQLException ex) {
						ex.printStackTrace();

				}
				return sexos;
		}
}
