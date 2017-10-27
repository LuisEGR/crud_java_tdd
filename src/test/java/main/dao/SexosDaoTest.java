/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import java.util.ArrayList;
import main.dao.SexosDao;
import main.datos.Sexo;
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
public class SexosDaoTest {
    


    /**
     * Test of obtenerSexos method, of class SexosDao.
     */
    @Test
    public void testObtenerSexos() {
        System.out.println("obtenerSexos");
        SexosDao instance = new SexosDao();
        ArrayList<Sexo> expResult = null;
        ArrayList<Sexo> result = instance.obtenerSexos();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
