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
public class JugadorTest {
    
    private Jugador j1;
    private Jugador j2;
    
    public JugadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        j1 = new Jugador("Pepe", 0);
        j2 = new Jugador("José", 2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResult = "Pepe";
        String result = j1.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetVictorias() {
        System.out.println("getVictorias");
        int expResult = 2;
        int result = j2.getVictorias();
        assertEquals(expResult, result);
    }
    
}
