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
public class EsbirroTest {

    private Esbirro esbirro1;

    public EsbirroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        esbirro1 = new Esbirro("esbirroTest", 5);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Esbirro.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Esbirro instance = esbirro1;
        String expResult = "esbirroTest";
        String result = instance.getNombre();
        assertEquals("El nombre no coincide", expResult, result);
    }

    /**
     * Test of getSalud method, of class Esbirro.
     */
    @Test
    public void testGetSalud() {
        System.out.println("getSalud");
        Esbirro instance = esbirro1;
        int expResult = 5; // La hemos puesto a 5 en @before
        int result = instance.getSalud();
        assertEquals("Los puntos de salud no coinciden", expResult, result);
    }

    /**
     * Test of setNombre method, of class Esbirro.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "test2";
        Esbirro instance = esbirro1;
        instance.setNombre(nombre);
        assertEquals("Los nombres no coinciden", nombre, esbirro1.getNombre());
    }

    /**
     * Test of setSalud method, of class Esbirro.
     */
    @Test
    public void testSetSalud() {
        System.out.println("setSalud");
        int salud = 1;
        Esbirro instance = esbirro1;
        instance.setSalud(salud);
        assertEquals("Los puntos de salud no coinciden", salud, esbirro1.getSalud());

    }

}
