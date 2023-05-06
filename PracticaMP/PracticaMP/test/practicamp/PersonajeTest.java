/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class PersonajeTest {

    private Personaje personaje1;

    public PersonajeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        personaje1 = new Personaje("Test1", 5);
        Talento t = new Talento("Talento", 1, 1);
        personaje1.setHabilidad(t);
        personaje1.agregarFortaleza("fortaleza", 3);
        personaje1.agregarDebilidad("debilidad", 4);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getHabilidad method, of class Personaje.
     */
    @Test
    public void testGetHabilidad() {
        System.out.println("getHabilidad");
        Personaje instance = personaje1;
        Habilidad result = instance.getHabilidad();
        assertNotNull(result);
        assertTrue(result instanceof Habilidad);

    }

    /**
     * Test of setHabilidad method, of class Personaje.
     */
    @Test
    public void testSetHabilidad() {
        System.out.println("setHabilidad");
        Habilidad habilidad = new Habilidad("Test", 1, 1);
        Personaje instance = personaje1;
        instance.setHabilidad(habilidad);
        assertEquals("No coincide habilidad", habilidad, personaje1.getHabilidad());
    }

    /**
     * Test of setSalud method, of class Personaje.
     */
    @Test
    public void testSetSalud() {
        System.out.println("setSalud");
        int salud = 5;
        Personaje instance = personaje1;
        instance.setSalud(salud);
        assertEquals("No coincide salud", salud, personaje1.getSalud());
    }

    /**
     * Test of agregarArma method, of class Personaje.
     */
    @Test
    public void testAgregarArma() {
        System.out.println("agregarArma");
        Arma arma = new Arma("test", 1, 1, 1);
        Personaje instance = personaje1;
        instance.agregarArma(arma);
        assertEquals("Las armas no coinciden", arma, personaje1.getArmas().get(0));
    }

    /**
     * Test of eliminarArma method, of class Personaje.
     */
    @Test
    public void testEliminarArma() {
        System.out.println("eliminarArma");
        Arma arma = new Arma("test", 1, 1, 1);
        Personaje instance = personaje1;
        instance.agregarArma(arma);
        instance.eliminarArma(arma);
        for (Arma a : personaje1.getArmas()) {
            if (a.equals(arma)) {
                fail("Se ha encontrado el arma, no se ha borrado correctamente");
            }
        }
    }

    /**
     * Test of clone method, of class Personaje.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testClone() throws Exception {  //TODO
        System.out.println("clone");
        // Personaje instance = personaje1;
        Personaje result = personaje1.clone();
        System.out.println(result.getNombre());
        assertTrue("No se clona correctamente", result instanceof Personaje);
    }

    /**
     * Test of activarArma method, of class Personaje.
     */
    @Test
    public void testActivarArma() {
        System.out.println("activarArma");
        Arma arma = new Arma("test1", 1, 1, 1);
        Arma arma2 = new Arma("test2", 1, 1, 2);
        List<Arma> armaActiva = new ArrayList<>();
        Personaje instance = personaje1;
        boolean expResult = false;
        boolean expResult1 = true;
        boolean result = instance.activarArma(arma, armaActiva);
        assertEquals(expResult1, result);

        boolean result2 = instance.activarArma(arma, armaActiva);
        assertEquals(expResult1, result2);

        boolean result3 = instance.activarArma(arma, armaActiva);
        assertEquals(expResult, result3);

        armaActiva.clear();

        boolean result4 = instance.activarArma(arma2, armaActiva);
        assertEquals(expResult1, result4);

        boolean result5 = instance.activarArma(arma2, armaActiva);
        assertEquals(expResult, result5);

        boolean result6 = instance.activarArma(arma, armaActiva);
        assertEquals(expResult, result6);

    }

    /**
     * Test of agregarArmadura method, of class Personaje.
     */
    @Test
    public void testAgregarArmadura() {
        System.out.println("agregarArmadura");
        Armadura armadura = new Armadura("armaduraTest", 1, 1);
        Personaje instance = personaje1;
        instance.agregarArmadura(armadura);
        assertEquals("No coinciden las armaduras", armadura, personaje1.getArmaduras().get(0));
    }

    /**
     * Test of eliminarArmadura method, of class Personaje.
     */
    @Test
    public void testEliminarArmadura() {
        System.out.println("eliminarArmadura");
        Armadura armadura = new Armadura("armaduraTest", 1, 1);
        Personaje instance = personaje1;
        instance.agregarArmadura(armadura);
        instance.eliminarArmadura(armadura);
        for (Armadura a : personaje1.getArmaduras()) {
            if (a.equals(armadura)) {
                fail("Se ha encontrado el armadura, no se ha borrado correctamente");
            }
        }
    }

    /**
     * Test of activarArmadura method, of class Personaje.
     */
    @Test
    public void testActivarArmadura() {
        System.out.println("activarArmadura");
        Armadura armadura = new Armadura("armaduraTest", 1, 1);
        Personaje instance = personaje1;
        instance.activarArmadura(armadura);
        assertEquals("La armadura activa no coincide con la que se ha equipado", armadura, personaje1.getArmaduraActiva());
    }

    /**
     * Test of agregarEsbirro method, of class Personaje.
     */
    @Test
    public void testAgregarEsbirro() {
        System.out.println("agregarEsbirro");
        Esbirro esbirro = new Esbirro("test", 1);
        Personaje instance = personaje1;
        instance.agregarEsbirro(esbirro);
        assertEquals("No coinciden los esbirros", esbirro, personaje1.getEsbirros().get(0));
    }

    /**
     * Test of eliminarEsbirro method, of class Personaje.
     */
    @Test
    public void testEliminarEsbirro() {
        System.out.println("eliminarEsbirro");
        Esbirro esbirro = new Esbirro("test", 1);
        Personaje instance = personaje1;
        instance.agregarEsbirro(esbirro);
        instance.eliminarEsbirro(esbirro);
        for (Esbirro a : personaje1.getEsbirros()) {
            if (a.equals(esbirro)) {
                fail("Se ha encontrado el esbirro, no se ha borrado correctamente");
            }
        }
    }

    /**
     * Test of agregarDebilidad method, of class Personaje.
     */
    @Test
    public void testAgregarDebilidad() {
        System.out.println("agregarDebilidad");
        String debilidad = "test";
        Integer valor = 1;
        Personaje instance = personaje1;
        instance.agregarDebilidad(debilidad, valor);
        assertEquals("No se ha establecido correctamente el valor de la debilidad", valor, personaje1.getDebilidades().get("test"));
    }

    /**
     * Test of eliminarDebilidad method, of class Personaje.
     */
    @Test
    public void testEliminarDebilidad() {
        System.out.println("eliminarDebilidad");
        String debilidad = "test";
        Integer valor = 1;
        Personaje instance = personaje1;
        instance.agregarDebilidad(debilidad, valor);
        instance.eliminarDebilidad(debilidad);
        if (personaje1.getDebilidades().containsKey("test")) {
            fail("No se ha borrado la debilidad correctamente del mapa de debilidades");
        }
    }

    /**
     * Test of agregarFortaleza method, of class Personaje.
     */
    @Test
    public void testAgregarFortaleza() {
        System.out.println("agregarFortaleza");
        String fortaleza = "testFortaleza";
        Integer valor = 1;
        Personaje instance = personaje1;
        instance.agregarFortaleza(fortaleza, valor);
        assertEquals("La fortaleza no se ha agregado correctamente", valor, personaje1.getFortalezas().get("testFortaleza"));
    }

    /**
     * Test of eliminarFortaleza method, of class Personaje.
     */
    @Test
    public void testEliminarFortaleza() {
        System.out.println("eliminarFortaleza");
        String fortaleza = "testFortaleza";
        Integer valor = 1;
        Personaje instance = personaje1;
        instance.agregarFortaleza(fortaleza, valor);

        instance.eliminarFortaleza(fortaleza);
        if (personaje1.getFortalezas().containsKey("testFortaleza")) {
            fail("No se ha borrado la fortaleza correctamente del mapa de debilidades");
        }
    }

    /**
     * Test of setPoder method, of class Personaje.
     */
    @Test
    public void testSetPoder() {
        System.out.println("setPoder");
        int poder = 1;
        Personaje instance = personaje1;
        instance.setPoder(poder);
        assertEquals("El poder no coincide", poder, personaje1.getPoder());
    }

    /**
     * Test of getNombre method, of class Personaje.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Personaje instance = personaje1;
        String expResult = "Test1";
        String result = instance.getNombre();
        assertEquals("Los nombres no coinciden", expResult, result);
    }

    /**
     * Test of getArmas method, of class Personaje.
     */
    @Test
    public void testGetArmas() {
        System.out.println("getArmas");
        Personaje instance = personaje1;
        List<Arma> expResult = new ArrayList<>();
        personaje1.setArmas(expResult);
        List<Arma> result = instance.getArmas();
        assertEquals("Las referencias a los dos arrayList no coinciden", expResult, result);
    }

    /**
     * Test of getArmaduras method, of class Personaje.
     */
    @Test
    public void testGetArmaduras() {
        System.out.println("getArmaduras");
        Personaje instance = personaje1;
        List<Armadura> expResult = new ArrayList<>();
        personaje1.setArmaduras(expResult);
        List<Armadura> result = instance.getArmaduras();
        assertEquals("Las referencias a los dos arrayList no coinciden", expResult, result);

    }

    /**
     * Test of getEsbirros method, of class Personaje.
     */
    @Test
    public void testGetEsbirros() {
        System.out.println("getEsbirros");
        Personaje instance = personaje1;
        List<Esbirro> expResult = new ArrayList<>();
        personaje1.setEsbirros(expResult);
        List<Esbirro> result = instance.getEsbirros();
        assertEquals("Las referencias a las listas no coinciden", expResult, result);
    }

    /**
     * Test of getSalud method, of class Personaje.
     */
    @Test
    public void testGetSalud() {
        System.out.println("getSalud");
        Personaje instance = personaje1;
        int expResult = 5;
        int result = instance.getSalud();
        assertEquals("La salud no coincide con la salud por defecto: 5 (la máxima)", expResult, result);
    }

    /**
     * Test of getPoder method, of class Personaje.
     */
    @Test
    public void testGetPoder() {
        System.out.println("getPoder");
        Personaje instance = personaje1;
        int expResult = 5;
        personaje1.setPoder(expResult);
        int result = instance.getPoder();
        assertEquals("No coinciden los valores", expResult, result);
    }

    /**
     * Test of getDebilidades method, of class Personaje.
     */
    @Test
    public void testGetDebilidades() {
        System.out.println("getDebilidades");
        Personaje instance = personaje1;
        Map<String, Integer> expResult = new HashMap<>();
        expResult.put("testDeb", 1);
        personaje1.setDebilidades(expResult);
        Map<String, Integer> result = instance.getDebilidades();
        assertEquals("Las referencias no coinciden", expResult, result);

    }

    /**
     * Test of getFortalezas method, of class Personaje.
     */
    @Test
    public void testGetFortalezas() {
        System.out.println("getFortalezas");
        Personaje instance = personaje1;
        Map<String, Integer> expResult = new HashMap<>();
        personaje1.setFortalezas(expResult);
        Map<String, Integer> result = instance.getFortalezas();
        assertEquals("Las referencias no coinciden", expResult, result);
    }

    /**
     * Test of getValorFortalezaODebilidad method, of class Personaje.
     */
    @Test
    public void testGetValorFortalezaODebilidad() {
        System.out.println("getValorFortalezaODebilidad");
        String nombre = "fortaleza";
        boolean fortaleza = true;
        Personaje instance = personaje1;
        int expResult = 3;
        int result = instance.getValorFortalezaODebilidad(nombre, fortaleza);
        assertEquals("La fortaleza no coincide", expResult, result);

        nombre = "debilidad";
        fortaleza = false;
        expResult = 4;
        result = instance.getValorFortalezaODebilidad(nombre, fortaleza);
        assertEquals("La debilidad no coincide", expResult, result);
    }

    /**
     * Test of getArmaActiva method, of class Personaje.
     */
    @Test
    public void testGetArmaActiva() {
        System.out.println("getArmaActiva");
        Personaje instance = personaje1;
        List<Arma> armaActiva = new ArrayList<>();
        personaje1.setArmaActiva(armaActiva);
        List<Arma> expResult = armaActiva;
        List<Arma> result = instance.getArmaActiva();
        assertEquals("Las referencias no coinciden", expResult, result);

    }

    /**
     * Test of getArmaduraActiva method, of class Personaje.
     */
    @Test
    public void testGetArmaduraActiva() {
        System.out.println("getArmaduraActiva");
        Personaje instance = personaje1;
        Armadura expResult = new Armadura("test", 1, 1);
        personaje1.setArmaduraActiva(expResult);
        Armadura result = instance.getArmaduraActiva();
        assertEquals("Las armaduras coinciden", expResult, result);
    }

    /**
     * Test of setArmas method, of class Personaje.
     */
    @Test
    public void testSetArmas() {
        System.out.println("setArmas");
        List<Arma> armas = new ArrayList<>();
        Personaje instance = personaje1;
        instance.setArmas(armas);
        assertEquals(armas, personaje1.getArmas());
    }

    /**
     * Test of setArmaActiva method, of class Personaje.
     */
    @Test
    public void testSetArmaActiva() {
        System.out.println("setArmaActiva");
        List<Arma> armaActiva = new ArrayList<>();
        Personaje instance = personaje1;
        instance.setArmaActiva(armaActiva);
        assertEquals("Las armas activas no coinciden", armaActiva, personaje1.getArmaActiva());
    }

    /**
     * Test of setArmaduras method, of class Personaje.
     */
    @Test
    public void testSetArmaduras() {
        System.out.println("setArmaduras");
        List<Armadura> armaduras = new ArrayList<>();
        Personaje instance = personaje1;
        instance.setArmaduras(armaduras);
        assertEquals("Las armaduras no coinciden", armaduras, personaje1.getArmaduras());
    }

    /**
     * Test of setArmaduraActiva method, of class Personaje.
     */
    @Test
    public void testSetArmaduraActiva() {
        System.out.println("setArmaduraActiva");
        Armadura armaduraActiva = new Armadura("test", 1, 1);
        Personaje instance = personaje1;
        instance.setArmaduraActiva(armaduraActiva);
        assertEquals("Las armaduras activas no coinciden", armaduraActiva, personaje1.getArmaduraActiva());
    }

    /**
     * Test of setDebilidades method, of class Personaje.
     */
    @Test
    public void testSetDebilidades() {
        System.out.println("setDebilidades");
        Map<String, Integer> debilidades = new HashMap<>();
        Personaje instance = personaje1;
        instance.setDebilidades(debilidades);
        assertEquals("La referencias no coinciden", debilidades, personaje1.getDebilidades());

    }

    /**
     * Test of setFortalezas method, of class Personaje.
     */
    @Test
    public void testSetFortalezas() {
        System.out.println("setFortalezas");
        Map<String, Integer> fortalezas = new HashMap<>();
        Personaje instance = personaje1;
        instance.setFortalezas(fortalezas);
        assertEquals("La referencias no coinciden", fortalezas, personaje1.getFortalezas());

    }

    /**
     * Test of setEsbirros method, of class Personaje.
     */
    @Test
    public void testSetEsbirros() {
        System.out.println("setEsbirros");
        List<Esbirro> esbirros = new ArrayList<>();
        Personaje instance = personaje1;
        instance.setEsbirros(esbirros);
        assertEquals("No coinciden las referencias", esbirros, personaje1.getEsbirros());
    }

}
