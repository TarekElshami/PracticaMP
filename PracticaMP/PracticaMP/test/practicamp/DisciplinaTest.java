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
public class DisciplinaTest {
    
    private Disciplina disc = new Disciplina("Disciplina 1", 0, 1, 2);
    
    public DisciplinaTest() {
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
    public void testGetCosteSangre() {
        System.out.println("getCosteSangre");
        int expResult = 2;
        int result = disc.getCosteSangre();
        assertEquals(expResult, result);
    }
    
}
