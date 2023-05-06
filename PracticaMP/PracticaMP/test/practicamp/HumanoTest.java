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
public class HumanoTest {

    private Humano humano1;

    public HumanoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        humano1 = new Humano("testHumano", 5, Lealtad.alta);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLealdad method, of class Humano.
     */
    @Test
    public void testGetLealdad() {
        System.out.println("getLealdad");
        Humano instance = humano1;
        Lealtad expResult = Lealtad.alta;
        Lealtad result = instance.getLealdad();
        assertEquals("Los valores de lealtad no coinciden", expResult, result);
    }

    /**
     * Test of setLealdad method, of class Humano.
     */
    @Test
    public void testSetLealdad() {
        System.out.println("setLealdad");
        Lealtad lealtad = Lealtad.baja;
        Humano instance = humano1;
        instance.setLealdad(lealtad);
        assertEquals("Los valores de lealtad no coinciden", lealtad, humano1.getLealdad());
    }

}
