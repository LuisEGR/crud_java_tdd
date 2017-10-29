/*
 * PersonasDao.java
 * Este archivo es parte del módulo de prueba Crud, Capa de acceso a BD.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.dao;

import main.dao.excepciones.RegistroExistenteException;
import main.datos.Deporte;
import main.datos.Estado;
import main.datos.Municipio;
import main.datos.Persona;
import main.datos.Sexo;
import main.dao.Dao;
import main.utilidades.Par;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonasDao extends Dao implements PersonasDaoI {

		static final String TABLA = "Personas";

		/**
		 * Establece conexión con la base de datos del ejercicio del CRUD.
		 */
		public PersonasDao() {
				super("Biblioteca_Personas", "ISCuenta", "Escom_17");
		}

		/**
		 * Eliminar los registros de tipo Entero pedidos a través de los parámetros.
		 *
		 * @param persona registro que se eliminará de la BD.
		 *
		 * @return true si se eliminó el registro de la BD, false de lo contrario.
		 *
		 * @author Daniel Ayala Zamorano
		 *				 Luis Enrique González Rodríguez
		 */
		@Override
		public void borrarPersona(Persona persona) {
				String sql = "DELETE FROM " + TABLA + " WHERE id_persona = ? ";
				int id = persona.getIdPersona();
				PreparedStatement ps = null;
				boolean result = false;
				try {
						ps = conexion.prepareStatement(sql);
						ps.setInt(1, id);
						result = ps.execute();
				} catch (SQLException e) {
						System.out.println("borrarPersona - MySQL Error:" + e.getMessage());
				}
		}

		/**
		 * Consulta el número de personas registradas en la BD.
		 *
		 * @return contador con número de personas registradas.
		 *
		 * @author Daniel Ayala Zamorano
		 */
		@Override
		public int obtenerNumeroPersonas() {
				String sql = "SELECT COUNT(id_persona) AS num FROM " + TABLA;
				PreparedStatement ps = null;
				boolean result = false;
				int numeroPersonas = 0;
				try {
						ps = conexion.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						rs.next();
						numeroPersonas = rs.getInt("num");
				} catch (SQLException e) {
						System.out.println("obtenerNumeroPersonas - MySQL Error:" + e.getMessage());
				}
				return numeroPersonas;
		}

		/**
		 * Consulta el nombre y apellidos de los registros en el rango especificado
		 * en la BD.
		 *
		 * @idMin id mínimo a consultar.
		 * @idMax id máximo a consultar.
		 * @return arreglo de registros con nombre y apellidos.
		 *
		 * @author Daniel Ayala Zamorano
		 */
		@Override
		public Par obtenerPersonas(int min, int max, String q) {
				ArrayList<Persona> personas = new ArrayList<Persona>();
				PreparedStatement ps = null;
				Persona persona;
				int idP, count = 0;
				String nombre, apP, apM;
				String query = "%" + q + "%";

				String sql1 = "SELECT * FROM View_Personas_Info "
								+ "WHERE UPPER(nombre) like UPPER(?) "
								+ "OR UPPER(apellido_paterno) like UPPER(?) "
								+ "OR UPPER(apellido_materno) like UPPER(?) "
								+ "ORDER BY apellido_paterno LIMIT ? OFFSET ?";

				String sql2 = "SELECT COUNT(id_persona) AS C "
								+ "FROM View_Personas_Info "
								+ "WHERE UPPER(nombre) like UPPER(?) "
								+ "OR UPPER(apellido_paterno) like UPPER(?) "
								+ "OR UPPER(apellido_materno) like UPPER(?) "
								+ "ORDER BY apellido_paterno";

				try {
						ps = conexion.prepareStatement(sql1);
						ps.setString(1, query);
						ps.setString(2, query);
						ps.setString(3, query);
						ps.setInt(4, max - min + 1);
						ps.setInt(5, min - 1);
						ResultSet rs1 = ps.executeQuery();
						while (rs1.next()) {
								persona = new Persona();
								idP = rs1.getInt("id_persona");
								nombre = rs1.getString("nombre");
								apP = rs1.getString("apellido_paterno");
								apM = rs1.getString("apellido_materno");
								persona.setIdPersona(idP);
								persona.setNombre(nombre);
								persona.setApPaterno(apP);
								persona.setApMaterno(apM);
								personas.add(persona);
						}
						ps.clearParameters();
						ps = conexion.prepareStatement(sql2);
						ps.setString(1, query);
						ps.setString(2, query);
						ps.setString(3, query);
						ResultSet rs2 = ps.executeQuery();
						rs2.next();
						count = rs2.getInt("C");
				} catch (SQLException e) {
						System.out.println("obtenerPersonas - MySQL Error:" + e.getMessage());
				}
				return new Par(count, personas);
		}

		/**
		 * Obtiene la persona registrada con el id especificado en la BD.
		 *
		 * @id Registro a obtener de la BD.
		 * @return objeto de la clase Persona.
		 *
		 * @author
		 */
		@Override
		public Persona obtenerPersona(int id) {
				Persona persona = new Persona();
				try {
						String nombre = "";
						String apPaterno = "";
						String apMaterno = "";
						String descmunicipio = "";
						int id_sexo = 0;
						int id_municipio = 0;
						int id_estado = 0;
						Sexo sexo = null;
						Municipio municipio = null;
						Estado estado = null;
						ArrayList<Deporte> deportes = new ArrayList<Deporte>();
						String personas = "select * from Personas where id_persona = ?";
						PreparedStatement ps = super.conexion.prepareStatement(personas);
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								nombre = rs.getString("nombre");
								apPaterno = rs.getString("apellido_paterno");
								apMaterno = rs.getString("apellido_materno");
								id_sexo = rs.getInt("id_sexo");
								id_municipio = rs.getInt("id_municipio");
						}
						String obtenersexo = "select * from Sexos where id_sexo = ?";
						ps = super.conexion.prepareStatement(obtenersexo);
						ps.setInt(1, id_sexo);
						rs = ps.executeQuery();
						while (rs.next()) {
								String descsexo = rs.getString("sexo");
								sexo = new Sexo(id, descsexo);
						}
						String obtenermunicipio = "select * from Municipios where id_municipio = ?";
						ps = super.conexion.prepareStatement(obtenermunicipio);
						ps.setInt(1, id_municipio);
						rs = ps.executeQuery();
						while (rs.next()) {
								descmunicipio = rs.getString("municipio");
								id_estado = rs.getInt("id_estado");
						}
						String obtenerestado = "select * from Estados where id_estado = ?";
						ps = super.conexion.prepareStatement(obtenerestado);
						ps.setInt(1, id_estado);
						rs = ps.executeQuery();
						while (rs.next()) {
								estado = new Estado(id_estado, rs.getString("estado"));
						}
						municipio = new Municipio(id_municipio, descmunicipio, estado);
						String obtenerdeportes = "select * from View_Personas_Deportes where id_persona = ?";
						ps = super.conexion.prepareStatement(obtenerdeportes);
						ps.setInt(1, id);
						rs = ps.executeQuery();
						while (rs.next()) {
								String desc = rs.getString("deporte");
								int iddep = rs.getInt("id_deporte");
								deportes.add(new Deporte(iddep, desc));
						}
						persona = new Persona(id, nombre, apPaterno, apMaterno, sexo, municipio, deportes);
				} catch (Exception e) {
						System.out.println("obtenerPersona - MySQL Error:" + e.getMessage());
				}
				return persona;
		}

		/**
		 * Inserción en la BD.
		 *
		 * @param persona Objeto de PersonaJson a insertar en la base.
		 *
		 * @author
		 */
		@Override
		public void insertarPersona(Persona persona) throws RegistroExistenteException {
				try {
						String insertPersonas = "insert into " + TABLA + "(nombre, apellido_paterno, "
										+ "apellido_materno, id_sexo, id_municipio) values(?,?,?,?,?)";
						PreparedStatement ps = super.conexion.prepareStatement(insertPersonas);
						ps.setString(1, persona.getNombre());
						ps.setString(2, persona.getApPaterno());
						ps.setString(3, persona.getApMaterno());
						ps.setInt(4, persona.getSexo().getIdSexo());
						ps.setInt(5, persona.getMunicipio().getIdMunicipio());
						ps.execute();

						String cultimoID = "select LAST_INSERT_ID()";
						ps = super.conexion.prepareStatement(cultimoID);
						ResultSet rs = ps.executeQuery();
						rs.next();
						int ultimoID = rs.getInt("LAST_INSERT_ID()");

						String InsertPersonas_Deportes = "insert into Personas_Deportes (id_persona, id_deporte) "
										+ "values(?, ?)";
						ps = super.conexion.prepareStatement(InsertPersonas_Deportes);
						for (Deporte i : persona.getDeportes()) {
								ps.clearParameters();
								ps.setInt(1, ultimoID);
								ps.setInt(2, i.getIdDeporte());
								ps.execute();
						}

				} catch (SQLException e) {
						throw new RegistroExistenteException("El registro ya está en la base de datos");
				}
		}

		/**
		 * Cambios de tipo Entero en la BD.
		 *
		 * @param persona persona que se actualizará.
		 *
		 * @author
		 */
		@Override
		public void actualizarPersona(Persona persona) {
				try {
						String UpdatePersonas = "Update " + TABLA + " set nombre = ?, apellido_paterno = ?, "
										+ "apellido_materno = ?, id_sexo = ?, id_municipio = ? where"
										+ " id_persona = ?;";
						PreparedStatement ps = super.conexion.prepareStatement(UpdatePersonas);
						ps.setString(1, persona.getNombre());
						ps.setString(2, persona.getApPaterno());
						ps.setString(3, persona.getApMaterno());
						ps.setInt(4, persona.getSexo().getIdSexo());
						ps.setInt(5, persona.getMunicipio().getIdMunicipio());
						ps.setInt(6, persona.getIdPersona());
						ps.execute();

						String DeletePersonas_Deportes = "delete from Personas_Deportes where id_persona = ? ";
						ps = super.conexion.prepareStatement(DeletePersonas_Deportes);
						ps.setInt(1, persona.getIdPersona());
						ps.execute();

						String InsertPersonas_Deportes = "insert into Personas_Deportes (id, id_persona, id_deporte)"
										+ " values(0, ?, ?)";
						ps = super.conexion.prepareStatement(InsertPersonas_Deportes);
						for (Deporte i : persona.getDeportes()) {
								ps.clearParameters();
								ps.setInt(1, persona.getIdPersona());
								ps.setInt(2, i.getIdDeporte());
								ps.execute();
						}
				} catch (Exception e) {
						System.out.println("actualizarPersona - MySQL Error:" + e.getMessage());
				}
		}

		/**
		 * Obtiene el número de personas registradas por estado.
		 *
		 * @return ArrayList de objetos de tipo Par que contienen a su vez un objeto
		 * de tipo Estado además de un entero con el número de personas registradas
		 * en dicho estado.
		 */
		@Override
		public ArrayList<Par> obtenerEstadisticasEstados() {
				ArrayList<Par> lista = new ArrayList<Par>();
				ArrayList<Estado> estado = new ArrayList<Estado>();
				try {
						String obtenerestados = "select * from Estados";
						PreparedStatement ps = super.conexion.prepareStatement(obtenerestados);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								estado.add(new Estado(rs.getInt("id_estado"), rs.getString("estado")));
						}
						for (int i = 0; i < estado.size(); i++) {
								String obtenerpersonas = "select count(*) as personas from view_Personas_Info where estado = ?;";
								ps = super.conexion.prepareStatement(obtenerpersonas);
								ps.setString(1, estado.get(i).getEstado());
								rs = ps.executeQuery();
								while (rs.next()) {
										lista.add(new Par(estado.get(i), rs.getInt("personas")));
								}
						}
				} catch (Exception e) {
						System.out.println("obtenerEstadisticasEstados - MySQL Error:" + e.getMessage());
				}
				Estado e = new Estado();
				return lista;
		}

		/**
		 * Obtiene el número de personas registradas por municipio.
		 *
		 * @param estado objeto de tipo Estado para ubicar los municipios a tomar en
		 * cuenta.
		 *
		 * @return ArrayList de objetos de tipo Par que contienen a su vez un objeto
		 * de tipo Municipio además de un entero con el número de personas
		 * registradas en dicho municipio.
		 */
		@Override
		public ArrayList<Par> obtenerEstadisticasMunicipios(Estado estado) {
				ArrayList<Par> lista = new ArrayList<Par>();
				ArrayList<Municipio> municipio = new ArrayList<Municipio>();
				try {
						String obtenermunicipios = "select * from Municipios where id_estado = ?";
						PreparedStatement ps = super.conexion.prepareStatement(obtenermunicipios);
						ps.setInt(1, estado.getIdEstado());
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								municipio.add(new Municipio(rs.getInt("id_municipio"), rs.getString("municipio"), estado));
						}
						for (int i = 0; i < municipio.size(); i++) {
								String obtenerpersonas = "select count(*) as personas from view_Personas_Info where municipio = ?;";
								ps = super.conexion.prepareStatement(obtenerpersonas);
								ps.setString(1, municipio.get(i).getMunicipio());
								rs = ps.executeQuery();
								while (rs.next()) {
										lista.add(new Par(municipio.get(i), rs.getInt("personas")));
								}
						}
				} catch (Exception e) {
						System.out.println("obtenerEstadisticasMunicipios - MySQL Error:" + e.getMessage());
				}
				return lista;
		}

		/**
		 * Obtiene el número de mujeres y hombres registrados en la BD.
		 *
		 * @return objeto de tipo Par que contiene dos enteros para el número de
		 * mujeres y hombres registrados.
		 */
		@Override
		public ArrayList<Par> obtenerEstadisticasSexos() {
				ArrayList<Par> lista = new ArrayList<Par>();
				ArrayList<Sexo> sexo = new ArrayList<Sexo>();
				try {
						String obtenersexos = "select * from sexos";
						PreparedStatement ps = super.conexion.prepareStatement(obtenersexos);
						ResultSet rs = ps.executeQuery();
						while (rs.next()) {
								sexo.add(new Sexo(rs.getInt("id_sexo"), rs.getString("sexo")));
						}
						for (int i = 0; i < sexo.size(); i++) {
								String obtenerpersonas = "select count(*) as personas from view_Personas_Info where sexo = ?;";
								ps = super.conexion.prepareStatement(obtenerpersonas);
								ps.setString(1, sexo.get(i).getSexo());
								rs = ps.executeQuery();
								while (rs.next()) {
										lista.add(new Par(sexo.get(i), rs.getInt("personas")));
								}
						}
				} catch (Exception e) {
						System.out.println("obtenerEstadisticasSexos - MySQL Error:" + e.getMessage());
				}
				return lista;
		}

		/**
		 * Obtiene el número de personas registradas por año.
		 *
		 * @return objeto de tipo Par que contiene dos enteros: el primero para el
		 * año y el segundo para el número de personas registradas en él.
		 */
		@Override
		public ArrayList<Par> obtenerEstadisticasAnios() {
				ArrayList<Par> resultado = new ArrayList<Par>();
				resultado.add(new Par(1995, 12));
				resultado.add(new Par(1996, 8));
				resultado.add(new Par(1999, 15));
				return resultado;
		}

}
