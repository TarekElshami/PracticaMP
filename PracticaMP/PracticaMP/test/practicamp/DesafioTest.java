/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.util.List;
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
public class DesafioTest {

    private Usuario desafiante;
    private Usuario desafiado;
    private int oro;
    private Desafio desafio;

    public DesafioTest() {
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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of establecerGanador method, of class Desafio.
     */
    @Test
    public void testEstablecerGanador() {
        System.out.println("establecerGanador");
        Usuario ganador = desafiante;
        Desafio instance = desafio;
        instance.establecerGanador(ganador);
        assertEquals("No se establece correctamente el ganador", ganador, instance.getGanador());
    }

    /**
     * Test of getDesafiante method, of class Desafio.
     */
    @Test
    public void testGetDesafiante() {
        System.out.println("getDesafiante");
        Desafio instance = desafio;
        Usuario expResult = desafiante;
        Usuario result = instance.getDesafiante();
        assertEquals("No se obtiene correctamente el desafiante", expResult, result);
    }

    /**
     * Test of getDesafiado method, of class Desafio.
     */
    @Test
    public void testGetDesafiado() {
        System.out.println("getDesafiado");
        Desafio instance = desafio;
        Usuario expResult = desafiado;
        Usuario result = instance.getDesafiado();
        assertEquals("No se obtiene correctamente el desafiado", expResult, result);
    }

    /**
     * Test of getOro method, of class Desafio.
     */
    @Test
    public void testGetOro() {
        System.out.println("getOro");
        Desafio instance = desafio;
        double expResult = 100;
        double result = instance.getOro();
        assertEquals("No se obtiene correctamente el oro apostado", expResult, result, 0);
    }

    /**
     * Test of addFortaleza method, of class Desafio.
     */
    @Test
    public void testAddFortaleza() {
        System.out.println("addFortaleza");
        Modificador mod = new Modificador("testMod");

        Desafio instance = desafio;
        instance.addFortaleza(mod);
        assert instance.getFortalezasAdmitidas().contains(mod) : "No se establece correctamente la oro fortaleza";

    }

    /**
     * Test of addDebilidad method, of class Desafio.
     */
    @Test
    public void testAddDebilidad() {
        System.out.println("addDebilidad");
        Modificador mod = new Modificador("testMod");

        Desafio instance = desafio;
        instance.addDebilidad(mod);
        assert instance.getDebilidadesAdmitidas().contains(mod) : "No se establece correctamente la oro fortaleza";
    }

    /**
     * Test of getFortalezasAdmitidas method, of class Desafio.
     */
    @Test
    public void testGetFortalezasAdmitidas() {
        System.out.println("getFortalezasAdmitidas");
        Modificador mod2 = new Modificador("testModFor");
        Desafio instance = desafio;
        instance.addFortaleza(mod2);
        assert instance.getFortalezasAdmitidas().contains(mod2) : "No se ha agregado/obtenido la fortaleza";

    }

    /**
     * Test of getDebilidadesAdmitidas method, of class Desafio.
     */
    @Test
    public void testGetDebilidadesAdmitidas() {
        System.out.println("getDebilidadesAdmitidas");
        Modificador mod2 = new Modificador("testModDeb");
        Desafio instance = desafio;
        instance.addDebilidad(mod2);
        assert instance.getDebilidadesAdmitidas().contains(mod2) : "No se ha agregado/obtenido la debilidad";
    }

    /**
     * Test of setEstado method, of class Desafio.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoDesafio estado = EstadoDesafio.acabado;
        Desafio instance = desafio;
        instance.setEstado(estado);
        assertEquals("No se ha establecido correctamente el estado", estado, instance.getEstado());
    }

    /**
     * Test of setAHistorial method, of class Desafio.
     */
    @Test
    public void testSetAHistorial() {
        System.out.println("setAHistorial");
        String texto = "testString";
        Desafio instance = desafio;
        instance.setAHistorial(texto);
        assert instance.getHistorial().contains(texto) : "No se agrega correctamente texto al historial del desafio (curso de la batalla)";
    }

    /**
     * Test of getHistorial method, of class Desafio.
     */
    @Test
    public void testGetHistorial() {
        System.out.println("getHistorial");
        Desafio instance = desafio;
        String texto = "testString2";
        String texto2 = "testString4";
        instance.setAHistorial(texto);
        instance.setAHistorial(texto2);
        List<String> result = instance.getHistorial();
        assert result.contains(texto) && result.contains(texto2) : "No se obtiene correctamente el historial";
    }

    /**
     * Test of getGanador method, of class Desafio.
     */
    @Test
    public void testGetGanador() {
        System.out.println("getGanador");
        Desafio instance = desafio;
        desafio.setGanador(desafiado);
        Usuario expResult = desafiado;
        Usuario result = instance.getGanador();
        assertEquals("No se obtiene correctamente el ganador", expResult, result);
    }

    /**
     * Test of setGanador method, of class Desafio.
     */
    @Test
    public void testSetGanador() {
        System.out.println("setGanador");
        Usuario ganador = desafiante;
        Desafio instance = desafio;
        instance.setGanador(ganador);
        assertEquals("No se establece correctamente el ganador", ganador, instance.getGanador());
    }

    /**
     * Test of getEstado method, of class Desafio.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Desafio instance = desafio;
        EstadoDesafio expResult = EstadoDesafio.acabado;
        instance.setEstado(expResult);
        EstadoDesafio result = instance.getEstado();
        assertEquals("No se obtiene correctamente el estado del desafio", expResult, result);
    }

}
