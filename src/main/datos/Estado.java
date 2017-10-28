/*
 * Deporte.java
 * Este archivo es parte del módulo de prueba Crud, Beans de datos.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.datos;

public class Estado {

		private int idEstado;
		private String estado;

		public Estado() {
		}

		/**
		 * Construye un nuevo objeto estado con los parámetros dados.
		 */
		public Estado(int idEstado, String estado) {
				this.idEstado = idEstado;
				this.estado = estado;
		}

		public int getIdEstado() {
				return idEstado;
		}

		public String getEstado() {
				return estado;
		}

		public void setIdEstado(int idEstado) {
				this.idEstado = idEstado;
		}

		public void setEstado(String estado) {
				this.estado = estado;
		}

		@Override
		public String toString() {
				return "Estado [idEstado=" + idEstado + ",estado=" + estado + "]";
		}
}
