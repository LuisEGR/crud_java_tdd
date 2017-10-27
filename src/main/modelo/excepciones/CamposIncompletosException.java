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
public class CamposIncompletosException extends Exception {
   public CamposIncompletosException() {
    super();
  }
  
  public CamposIncompletosException(String mensajeError) {
    super(mensajeError);
  }
 }
