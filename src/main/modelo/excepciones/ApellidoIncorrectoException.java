/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelo.excepciones;

/**
 *
 * @author Paula
 */
public class ApellidoIncorrectoException extends Exception {
  public ApellidoIncorrectoException() {
    super();
  }
  
  public ApellidoIncorrectoException(String mensajeError) {
    super(mensajeError);
  }
}
