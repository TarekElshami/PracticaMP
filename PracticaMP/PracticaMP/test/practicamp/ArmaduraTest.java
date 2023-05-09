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
public class ArmaduraTest {
    
    private Armadura armaduraDefensa;
    private Armadura armaduraAtaque;
    
    public ArmaduraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        armaduraDefensa = new Armadura("Chaleco de cuero", 2, 0);
        armaduraAtaque = new Armadura("Armadura de las sombras", 0, 2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNombre() {
        String expResult = "Chaleco de cuero";
        String result = armaduraDefensa.getNombre();
        assertEquals(expResult, result);

        expResult = "Armadura de las sombras";
        result = armaduraAtaque.getNombre();
        assertEquals(expResult, result);
    }
    
}
