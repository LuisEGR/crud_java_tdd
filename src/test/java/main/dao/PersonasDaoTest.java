/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.PersonasDao;
import main.dao.excepciones.RegistroExistenteException;
import main.datos.Estado;
import main.datos.Persona;
import main.utilidades.Par;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Luis
 */
@DisplayName("Test DAO - Personas")
public class PersonasDaoTest {
		PersonasDao personasDao = new PersonasDao();
		/*
				Guardo la primer persona para hacer cambios sobre esta y regresarla a 
				la normalidad terminando el tes
		*/
		Persona personaBckp = personasDao.obtenerPersona(1);
		int totalPersonasBckp = personasDao.obtenerNumeroPersonas();
		
		@BeforeAll
		
		
		
		/**
		 * Test of borrarPersona method, of class PersonasDao.
		 */
		@Test
		public void testBorrarPersona() {
				/*
				Persona persona = personasDao.obtenerPersona(1);
				personasDao.borrarPersona(persona);
				int totalPersonas = personasDao.obtenerNumeroPersonas();
				// El primer elemento es de tipo Estado
				assertEquals(totalPersonas, (totalPersonasBckp - 1), "Debería existir una persona menos");
				
				Persona persona1 = personasDao.obtenerPersona(1);
				assertNull(persona1.getNombre(), "La persona con id_persona=1 no debería existir");				
				*/
		}

		/**
		 * Test of obtenerNumeroPersonas method, of class PersonasDao.
		 */
		@Test
		public void testObtenerNumeroPersonas() {
				int totalPersonas = personasDao.obtenerNumeroPersonas();
				assertTrue(totalPersonas > 0, "Debería de haber más de 0 personas");
		}

		/**
		 * Test of obtenerPersonas method, of class PersonasDao.
		 */
		@Test
		public void testObtenerPersonas() {
				int min = 0;
				int max = 10;
				String q = "";
				Par result = personasDao.obtenerPersonas(min, max, q);
				int obtenidos = (int)result.getPrimero();
				//System.out.println("Se obtuvieron "+ obtenidos+ " personas");
				assertTrue(obtenidos > 0, "Debería de haber un total de más de 0 personas");				
				ArrayList<Persona> pers = (ArrayList<Persona>)result.getSegundo();
				assertEquals(10, pers.size(), "Debería de haber 10 elementos en el ArrayList");
				assertEquals(Persona.class, pers.get(0).getClass(), "El primer elemento debería ser de tipo Persona");
		}

		/**
		 * Test of obtenerPersona method, of class PersonasDao.
		 */
		@Test
		public void testObtenerPersona() {
				System.out.println("obtenerPersona");
				Persona p = personasDao.obtenerPersona(2);
        assertEquals("Bianca Yeseniañez", p.getNombre(), "El nombre de la persona no coincide");
        assertEquals("Martínez", p.getApMaterno(), "El apellido materno no coincide ");
        assertEquals("Aguilar", p.getApPaterno(), "El apellido paterno no coincide");
        assertEquals("Femenino", p.getSexo().getSexo(), "El sexo no coincide");
        assertEquals("Calvillo", p.getMunicipio().getMunicipio(), "El municipio no coincide");
        assertEquals("Aguascalientes", p.getMunicipio().getEstado().getEstado(), "El estado no coincide");
        assertEquals(3, p.getDeportes().size(), "El número de deportes no coincide");
		}

		/**
		 * Test of insertarPersona method, of class PersonasDao.
		 */
		@Test
		public void testInsertarPersona() throws Exception {
				System.out.println("insertarPersona");
				Persona persona = null;
				PersonasDao instance = new PersonasDao();
				//instance.insertarPersona(persona);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/**
		 * Test of actualizarPersona method, of class PersonasDao.
		 */
		@Test
		public void testActualizarPersona() {
				System.out.println("actualizarPersona");
				Persona persona = null;
				PersonasDao instance = new PersonasDao();
				//instance.actualizarPersona(persona);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/**
		 * Test of obtenerEstadisticasEstados method, of class PersonasDao.
		 */
		@Test
		public void testObtenerEstadisticasEstados() {
				//ArrayList<Par> result = personasDao.obtenerEstadisticasEstados();
        //int total = (int) result.getPrimero();
        //ArrayList<Estado> estados = (ArrayList<Estado>) result.getSegundo();
				//assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/**
		 * Test of obtenerEstadisticasMunicipios method, of class PersonasDao.
		 */
		@Test
		public void testObtenerEstadisticasMunicipios() {
				System.out.println("obtenerEstadisticasMunicipios");
				Estado estado = null;
				PersonasDao instance = new PersonasDao();
				ArrayList<Par> expResult = null;
				ArrayList<Par> result = instance.obtenerEstadisticasMunicipios(estado);
				//assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/**
		 * Test of obtenerEstadisticasSexos method, of class PersonasDao.
		 */
		@Test
		public void testObtenerEstadisticasSexos() {
				System.out.println("obtenerEstadisticasSexos");
				PersonasDao instance = new PersonasDao();
				ArrayList<Par> expResult = null;
				ArrayList<Par> result = instance.obtenerEstadisticasSexos();
				//assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/**
		 * Test of obtenerEstadisticasAnios method, of class PersonasDao.
		 */
		@Test
		public void testObtenerEstadisticasAnios() {
				System.out.println("obtenerEstadisticasAnios");
				PersonasDao instance = new PersonasDao();
				ArrayList<Par> expResult = null;
				ArrayList<Par> result = instance.obtenerEstadisticasAnios();
				//assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				//fail("The test case is a prototype.");
		}

		/*
				Restauro todos los cambios hechos en la base de datos
		*/
		@AfterAll
		private static void restoreAll() {
			
    }
}
