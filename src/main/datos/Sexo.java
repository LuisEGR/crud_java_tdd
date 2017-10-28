/*
 * Deporte.java
 * Este archivo es parte del módulo de prueba Crud, Beans de datos.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.datos;

public class Sexo {

		private int idSexo;
		private String sexo;

		public Sexo() {
		}

		/**
		 * Construye un objeto sexo a partir de los parámetros dados.
		 */
		public Sexo(int idSexo, String sexo) {
				this.idSexo = idSexo;
				this.sexo = sexo;
		}

		public int getIdSexo() {
				return idSexo;
		}

		public String getSexo() {
				return sexo;
		}

		public void setIdSexo(int idSexo) {
				this.idSexo = idSexo;
		}

		public void setSexo(String sexo) {
				this.sexo = sexo;
		}

		@Override
		public String toString() {
				return idSexo + "-" + sexo;
		}

}
