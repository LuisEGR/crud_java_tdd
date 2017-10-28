/*
 * Persona.java
 * Este archivo es parte del módulo de prueba Crud, Beans de datos.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.datos;

import java.util.ArrayList;

public class Persona {

		private int idPersona;
		private String nombre;
		private String apPaterno;
		private String apMaterno;
		private Sexo sexo;
		private Municipio municipio;
		private ArrayList<Deporte> deportes;

		public Persona() {
		}

		/**
		 * Construye un nuevo objedo Persona según los parámetros dados.
		 */
		public Persona(int idPersona, String nombre, String apPaterno, String apMaterno,
						Sexo sexo, Municipio municipio, ArrayList<Deporte> deportes) {
				this.idPersona = idPersona;
				this.nombre = nombre;
				this.apPaterno = apPaterno;
				this.apMaterno = apMaterno;
				this.sexo = sexo;
				this.municipio = municipio;
				this.deportes = deportes;
		}

		public int getIdPersona() {
				return idPersona;
		}

		public void setIdPersona(int idPersona) {
				this.idPersona = idPersona;
		}

		public String getNombre() {
				return nombre;
		}

		public void setNombre(String nombre) {
				this.nombre = nombre;
		}

		public String getApPaterno() {
				return apPaterno;
		}

		public void setApPaterno(String apPaterno) {
				this.apPaterno = apPaterno;
		}

		public String getApMaterno() {
				return apMaterno;
		}

		public void setApMaterno(String apMaterno) {
				this.apMaterno = apMaterno;
		}

		public Sexo getSexo() {
				return sexo;
		}

		public void setSexo(Sexo sexo) {
				this.sexo = sexo;
		}

		public Municipio getMunicipio() {
				return municipio;
		}

		public void setMunicipio(Municipio municipio) {
				this.municipio = municipio;
		}

		public ArrayList<Deporte> getDeportes() {
				return deportes;
		}

		public void setDeportes(ArrayList<Deporte> deportes) {
				this.deportes = deportes;
		}

		@Override
		public String toString() {
				String resultado = "ID: " + idPersona + "\n"
								+ "Nombre: " + nombre + " " + apPaterno + " " + apMaterno + "\n"
								+ "Localidad: " + municipio + "\n"
								+ "Sexo: " + sexo + "\n"
								+ "Deportes: ";

				for (Deporte d : deportes) {
						resultado += d + " ";
				}
				return resultado;
		}

}
