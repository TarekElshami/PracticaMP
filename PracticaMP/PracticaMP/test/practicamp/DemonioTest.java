/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
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
public class DemonioTest {

    private Demonio demonio1;
    private List<Esbirro> esbirros;
    
    public DemonioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        esbirros = new ArrayList<>();
        Demonio subDemonio = new Demonio("subTestDemonio", 5, esbirros, "testPacto");
        Ghoul subGhoul = new Ghoul("subTestGhoul", 5, 2);
        Humano subHumano = new Humano("subTestHumano", 5, Lealtad.alta);
        esbirros.add(subDemonio);
        esbirros.add(subGhoul);
        esbirros.add(subHumano);
        demonio1 = new Demonio("testDemonio", 5, esbirros, "testPacto");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEsbirros method, of class Demonio.
     */
    @Test
    public void testGetEsbirros() {
        System.out.println("getEsbirros");
        Demonio instance = demonio1;
        List<Esbirro> expResult = esbirros;
        List<Esbirro> result = instance.getEsbirros();
        assertEquals("Las listas no coinciden", expResult, result);

    }

    /**
     * Test of getPacto method, of class Demonio.
     */
    @Test
    public void testGetPacto() {
        System.out.println("getPacto");
        Demonio instance = demonio1;
        String expResult = "testPacto";
        String result = instance.getPacto();
        assertEquals("Los pactos no coinciden", expResult, result);
    }

    /**
     * Test of setPacto method, of class Demonio.
     */
    @Test
    public void testSetPacto() {
        System.out.println("setPacto");
        String pacto = "test2";
        Demonio instance = demonio1;
        instance.setPacto(pacto);
        assertEquals("Los pactos no coinciden", pacto, demonio1.getPacto());
    }

    /**
     * Test of addEsbirro method, of class Demonio.
     */
    @Test
    public void testAddEsbirro() {
        System.out.println("addEsbirro");
        Esbirro esbirro = new Esbirro("testA", 4);
        Demonio instance = demonio1;
        instance.addEsbirro(esbirro);
        assertEquals("Los esbirros no coinciden", esbirro, demonio1.getEsbirros().get(demonio1.getEsbirros().size() - 1));
    }
    
}
