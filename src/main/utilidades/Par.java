/*
 * Par.java
 * Este archivo es parte del módulo de clases genéricas, utilidades.
 * Proyecto para biblioteca central - ingeniería de software.
 * Fecha de creación: 11/10/17.
 * vim: set softtabstop=2 shiftwidth=2 expandtab cc=100:
 */
package main.utilidades;

/**
 * Clase utilizada para almacenar pares de objetos. Se utiliza principalmente
 * como método de comunicación entre el controlador y la capa de acceso a base
 * de datos.
 *
 * <p>
 * Hacer esto no es una práctica común en java (de hecho, la idea viene
 * importada directo de la biblioteca estándar de C++); sin embargo, para
 * ciertos casos en los que se necesitan regresar dos objetos en lugar de uno,
 * esta clase sirve para agruparlos.
 *
 * @author Ricardo Quezada.
 */
public class Par<T1, T2> {

		private T1 primero;
		private T2 segundo;

		public Par(T1 primero, T2 segundo) {
				this.primero = primero;
				this.segundo = segundo;
		}

		public T1 obtenerPrimero() {
				return primero;
		}

		public T2 obtenerSegundo() {
				return segundo;
		}

}
