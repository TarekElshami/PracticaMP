/*
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
 * @author blase
 */
public class HabilidadTest {
    
    private Habilidad hab1;
    private Habilidad hab2;
    
    public HabilidadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hab1 = new Habilidad("Habilidad 1", 1, 2);
        hab2 = new Habilidad("Habilidad 2", 3, 4);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResult = "Habilidad 1";
        String result = hab1.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Habilidad nueva 1";
        hab1.setNombre("Habilidad nueva 1");
        assertEquals(hab1.getNombre(), "Habilidad nueva 1");
    }

    @Test
    public void testGetAtaque() {
        System.out.println("getAtaque");
        int expResult = 3;
        int result = hab2.getAtaque();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAtaque() {
        System.out.println("setAtaque");
        int ataque = 0;
        hab1.setAtaque(0);
        assertEquals(hab1.getAtaque(), 0);
    }

    @Test
    public void testGetDefensa() {
        System.out.println("getDefensa");
        Habilidad instance = null;
        int expResult = 2;
        int result = hab1.getDefensa();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDefensa() {
        System.out.println("setDefensa");
        int defensa = 5;
        hab2.setDefensa(defensa);
        assertEquals(hab2.getDefensa(), 5);
    }
    
}
