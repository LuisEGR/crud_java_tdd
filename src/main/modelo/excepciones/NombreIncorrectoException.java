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
public class NombreIncorrectoException extends Exception{
     public NombreIncorrectoException() {
    super();
  }
  
  public NombreIncorrectoException(String mensajeError) {
    super(mensajeError);
  }
}
