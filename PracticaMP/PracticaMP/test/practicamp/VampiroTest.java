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
public class VampiroTest {

    private Vampiro vampiro1;

    public VampiroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        vampiro1 = new Vampiro("vampiroTest");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSangre method, of class Vampiro.
     */
    @Test
    public void testGetSangre() {
        System.out.println("getSangre");
        Vampiro instance = vampiro1;
        int expResult = 0; //Por defecto es 0
        int result = instance.getSangre();
        assertEquals("Los valores no coinciden", expResult, result);
    }

    /**
     * Test of setSangre method, of class Vampiro.
     */
    @Test
    public void testSetSangre() {
        System.out.println("setSangre");
        int sangre = 10;
        Vampiro instance = vampiro1;
        instance.setSangre(sangre);
        assertEquals("Los valores no coinciden", sangre, vampiro1.getSangre());
    }

    /**
     * Test of setEdad method, of class Vampiro.
     */
    @Test
    public void testSetEdad() {
        System.out.println("setEdad");
        int edad = 444;
        Vampiro instance = vampiro1;
        instance.setEdad(edad);
        assertEquals("Los valores no coinciden", edad, vampiro1.getEdad());

    }

    /**
     * Test of getEdad method, of class Vampiro.
     */
    @Test
    public void testGetEdad() {
        System.out.println("getEdad");
        Vampiro instance = vampiro1;
        int expResult = 711; // Por defecto es 711 en los Vampiros
        int result = instance.getEdad();
        assertEquals("Los valores no coinciden", expResult, result);
    }

}
