/*
 * Deporte.java
 * Este archivo es parte del módulo de prueba Crud, Beans de datos.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.datos;

public class Deporte {

		private int idDeporte;
		private String deporte;

		public Deporte() {
		}

		/**
		 * Construye un nuevo objeto deporte con los prámetros dados.
		 */
		public Deporte(int idDeporte, String deporte) {
				this.idDeporte = idDeporte;
				this.deporte = deporte;
		}

		public int getIdDeporte() {
				return idDeporte;
		}

		public String getDeporte() {
				return deporte;
		}

		public void setIdDeporte(int idDeporte) {
				this.idDeporte = idDeporte;
		}

		public void setDeporte(String deporte) {
				this.deporte = deporte;
		}

		@Override
		public String toString() {
				return idDeporte + "-" + deporte;
		}

}
