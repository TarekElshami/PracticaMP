package practicamp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArmaTest {

    @Test
    public void testGetManos() {
        Arma arma1Mano = new Arma("Cuchillo de caza", 0, 2, 1);
        Arma arma2Manos = new Arma("Martillo de hueso", 3, 1, 2);

        assertEquals(1, arma1Mano.getManos());
        assertEquals(2, arma2Manos.getManos());
    }
}