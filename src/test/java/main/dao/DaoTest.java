/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.dao;

import main.dao.Dao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luis
 */
public class DaoTest {
     /**
     * Test of cerrarConexion method, of class Dao.
     */
    @Test
    public void testCerrarConexion() {
        System.out.println("cerrarConexion");
        Dao instance = null;
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
