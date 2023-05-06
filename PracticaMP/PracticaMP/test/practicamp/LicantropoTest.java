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
public class LicantropoTest {

    private Licantropo licantropo1;

    public LicantropoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        licantropo1 = new Licantropo("licantropoTest");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRabia method, of class Licantropo.
     */
    @Test
    public void testGetRabia() {
        System.out.println("getRabia");
        Licantropo instance = licantropo1;
        int expResult = 0; // Por defecto es 0 en los Licántropos
        int result = instance.getRabia();
        assertEquals("Los valores no coinciden", expResult, result);
    }

    /**
     * Test of setRabia method, of class Licantropo.
     */
    @Test
    public void testSetRabia() {
        System.out.println("setRabia");
        int rabia = 5;
        Licantropo instance = licantropo1;
        instance.setRabia(rabia);
        assertEquals("Los valores no coinciden", rabia, licantropo1.getRabia());

    }

}
