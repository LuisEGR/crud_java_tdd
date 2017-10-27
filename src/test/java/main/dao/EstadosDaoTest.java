/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.EstadosDao;
import main.datos.Estado;
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
public class EstadosDaoTest {
    
    public EstadosDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerEstados method, of class EstadosDao.
     */
    @Test
    public void testObtenerEstados() {
        System.out.println("obtenerEstados");
        EstadosDao instance = new EstadosDao();
        ArrayList<Estado> expResult = null;
        ArrayList<Estado> result = instance.obtenerEstados();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
