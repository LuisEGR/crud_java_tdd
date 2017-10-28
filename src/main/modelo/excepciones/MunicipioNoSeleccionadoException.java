/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo.excepciones;

/**
 *
 * @author Luis
 */
public class MunicipioNoSeleccionadoException extends Exception {

		public MunicipioNoSeleccionadoException() {
				super();
		}

		public MunicipioNoSeleccionadoException(String mensajeError) {
				super(mensajeError);
		}
}
