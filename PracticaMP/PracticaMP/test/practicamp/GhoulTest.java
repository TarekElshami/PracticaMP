/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class GhoulTest {

    private Ghoul ghoul1;
    
    public GhoulTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ghoul1 = new Ghoul("testGhoul", 5, 5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDependencia method, of class Ghoul.
     */
    @Test
    public void testGetDependencia() {
        System.out.println("getDependencia");
        Ghoul instance = ghoul1;
        int expResult = 5;
        int result = instance.getDependencia();
        assertEquals("Los valores de dependencia no coinciden", expResult, result);
    }

    /**
     * Test of setDependencia method, of class Ghoul.
     */
    @Test
    public void testSetDependencia() {
        System.out.println("setDependencia");
        int dependencia = 0;
        Ghoul instance = ghoul1;
        instance.setDependencia(dependencia);
        assertEquals("Los valores de dependencia no coinciden", dependencia, ghoul1.getDependencia());

    }
    
}
