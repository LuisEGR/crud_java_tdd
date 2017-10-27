/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.PersonasDao;
import main.datos.Estado;
import main.datos.Persona;
import main.utilidades.Par;
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
public class PersonasDaoTest {
    

    /**
     * Test of borrarPersona method, of class PersonasDao.
     */
    @Test
    public void testBorrarPersona() {
        System.out.println("borrarPersona");
        Persona persona = null;
        PersonasDao instance = new PersonasDao();
        //instance.borrarPersona(persona);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNumeroPersonas method, of class PersonasDao.
     */
    @Test
    public void testObtenerNumeroPersonas() {
        System.out.println("obtenerNumeroPersonas");
        PersonasDao instance = new PersonasDao();
        int expResult = 0;
        int result = instance.obtenerNumeroPersonas();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPersonas method, of class PersonasDao.
     */
    @Test
    public void testObtenerPersonas() {
        System.out.println("obtenerPersonas");
        int min = 0;
        int max = 0;
        String q = "";
        PersonasDao instance = new PersonasDao();
        Par expResult = null;
        Par result = instance.obtenerPersonas(min, max, q);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPersona method, of class PersonasDao.
     */
    @Test
    public void testObtenerPersona() {
        System.out.println("obtenerPersona");
        int id = 0;
        PersonasDao instance = new PersonasDao();
        Persona expResult = null;
        Persona result = instance.obtenerPersona(id);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        System.out.println("obtenerEstadisticasEstados");
        PersonasDao instance = new PersonasDao();
        ArrayList<Par> expResult = null;
        ArrayList<Par> result = instance.obtenerEstadisticasEstados();
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
    
}
