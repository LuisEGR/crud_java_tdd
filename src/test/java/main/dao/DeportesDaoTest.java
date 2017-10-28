/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.DeportesDao;
import main.datos.Deporte;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis
 */
public class DeportesDaoTest {

		/**
		 * Test of obtenerDeportes method, of class DeportesDao.
		 */
		@Test
		public void testObtenerDeportes() {
				System.out.println("obtenerDeportes");
				DeportesDao instance = new DeportesDao();
				ArrayList<Deporte> result = instance.obtenerDeportes();
				// El primer elemento es de tipo Deporte
				assertEquals(Deporte.class, result.get(0).getClass());
				// Hay 12 deportes
				assertEquals(12, result.size());
		}
}
