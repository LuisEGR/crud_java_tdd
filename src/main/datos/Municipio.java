/*
 * Deporte.java
 * Este archivo es parte del módulo de prueba Crud, Beans de datos.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.datos;

public class Municipio {

		private int idMunicipio;
		private String municipio;
		private Estado estado;

		public Municipio() {
		}

		/**
		 * Construye un nuevo objeto municipio a apartir de los argumentos.
		 */
		public Municipio(int idMunicipio, String municipio, Estado estado) {
				this.idMunicipio = idMunicipio;
				this.municipio = municipio;
				this.estado = estado;
		}

		public int getIdMunicipio() {
				return idMunicipio;
		}

		public String getMunicipio() {
				return municipio;
		}

		public Estado getEstado() {
				return this.estado;
		}

		public void setIdMunicipio(int idMunicipio) {
				this.idMunicipio = idMunicipio;
		}

		public void setMunicipio(String municipio) {
				this.municipio = municipio;
		}

		public void setEstado(Estado estado) {
				this.estado = estado;
		}

		@Override
		public String toString() {
				return "Municipio [idMunicipio=" + idMunicipio + ",municipio=" + municipio + ", estado=" + estado + "]";
		}

}
