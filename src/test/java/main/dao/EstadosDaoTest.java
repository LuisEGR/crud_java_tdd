/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.EstadosDao;
import main.datos.Estado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Luis
 */
@DisplayName("Test DAO - Estados")
public class EstadosDaoTest {

		public EstadosDaoTest() {
		}

		/**
		 * Test of obtenerEstados method, of class EstadosDao.
		 */
		@Test
		public void testObtenerEstados() {
				EstadosDao instance = new EstadosDao();
				ArrayList<Estado> result = instance.obtenerEstados();
				// El primer elemento es de tipo Estado
				assertEquals(Estado.class, result.get(0).getClass(), "El primer elemento debería ser de tipo Estado");
				// Hay 32 Estados
				assertEquals(32, result.size(), "El arreglo debería contener 32 elementos");
		}

}
