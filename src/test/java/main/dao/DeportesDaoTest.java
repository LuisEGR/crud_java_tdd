/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;


import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import main.dao.DeportesDao;
import main.datos.Deporte;

/**
 *
 * @author Luis
 */
@DisplayName("Test DAO - Deportes")
public class DeportesDaoTest {

		/**
		 * Test of obtenerDeportes method, of class DeportesDao.
		 */
		@Test
		public void testObtenerDeportes() {
				DeportesDao instance = new DeportesDao();
				ArrayList<Deporte> result = instance.obtenerDeportes();
				// El primer elemento es de tipo Deporte
				assertEquals(Deporte.class, result.get(0).getClass(), "El primer elemento debería ser de tipo Deporte");
				// Hay 12 deportes
				assertEquals(12, result.size(), "El arreglo debería contener 12 elementos");
		}
}
