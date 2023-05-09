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
public class DonTest {
    
    private Don don = new Don("Don 1", 0, 1, 7);
    
    public DonTest() {
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
    public void testGetCosteRabia() {
        System.out.println("getCosteRabia");
        int expResult = 7;
        int result = don.getCosteRabia();
        assertEquals(expResult, result);
    }
    
}
