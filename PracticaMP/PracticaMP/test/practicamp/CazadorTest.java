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
public class CazadorTest {

    private Cazador cazador1;

    public CazadorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cazador1 = new Cazador("cazadorTest");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setVoluntad method, of class Cazador.
     */
    @Test
    public void testSetVoluntad() {
        System.out.println("setVoluntad");
        int voluntad = 4;
        Cazador instance = cazador1;
        instance.setVoluntad(voluntad);
        assertEquals("Los valores no coinciden", voluntad, cazador1.getVoluntad());
    }

    /**
     * Test of getVoluntad method, of class Cazador.
     */
    @Test
    public void testGetVoluntad() {
        System.out.println("getVoluntad");
        Cazador instance = cazador1;
        int expResult = 3; // Por defecto es 3 en los cazadores
        int result = instance.getVoluntad();
        assertEquals("Los valores no coinciden", expResult, result);
    }

}
