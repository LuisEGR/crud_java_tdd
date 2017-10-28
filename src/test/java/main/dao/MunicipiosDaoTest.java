/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.MunicipiosDao;
import main.datos.Estado;
import main.datos.Municipio;
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
public class MunicipiosDaoTest {

		/**
		 * Test of obtenerMunicipios method, of class MunicipiosDao.
		 */
		@Test
		public void testObtenerMunicipios() {
				System.out.println("obtenerMunicipios");
				Estado estado = new Estado();
				estado.setIdEstado(1);
				MunicipiosDao instance = new MunicipiosDao();
				ArrayList<Municipio> result = instance.obtenerMunicipios(estado);

				// El estado 1 tiene 11 municipios
				assertEquals(11, result.size());
				// El primer elemento es de clase Municipio
				assertEquals(Municipio.class, result.get(1).getClass());
		}

}
