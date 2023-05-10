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
public class NotificacionTest {
    
    private Desafio desafio;
    private Usuario desafiante;
    private Usuario desafiado;
    private int oro;
    private Notificacion notificacion;

    public NotificacionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        desafiante = new Usuario("U1", "test1");
        desafiado = new Usuario("U2", "test2");
        oro = 100;
        desafio = new Desafio(desafiante, desafiado, oro);
        notificacion = new Notificacion(desafio);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRival method, of class Notificacion.
     */
    @Test
    public void testGetRival() {
        // El rival siempre será el desafiante, pues la notificación la recibe el desafiado
        System.out.println("getRival");
        Notificacion instance = notificacion;
        String expResult = "U1";
        String result = instance.getRival();
        assertEquals("No se obtiene correctamente el rival desde la notificacion", expResult, result);
    }


    /**
     * Test of obtenerDesafio method, of class Notificacion.
     */
    @Test
    public void testObtenerDesafio() {
        System.out.println("obtenerDesafio");
        Notificacion instance = notificacion;
        Desafio expResult = desafio;
        Desafio result = instance.obtenerDesafio();
        assertEquals("El desafío almacenado en la notificación no coincide con el establecido aquí", expResult, result);
    }

    /**
     * Test of getOroApostado method, of class Notificacion.
     */
    @Test
    public void testGetOroApostado() {
        System.out.println("getOroApostado");
        Notificacion instance = notificacion;
        double expResult = 100;
        double result = instance.getOroApostado();
        assertEquals("No se obtiene correctamente el oro", expResult, result, 0);
    }

}
