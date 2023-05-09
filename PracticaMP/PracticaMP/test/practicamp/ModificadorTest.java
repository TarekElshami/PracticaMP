package practicamp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class ModificadorTest {
    
    public ModificadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetNombre() {
        Modificador mod1 = new Modificador("mod1");
        Modificador mod2 = new Modificador("mod2");

        assertEquals("mod1", mod1.getNombre());
        assertEquals("mod2", mod2.getNombre());
    }  
}
