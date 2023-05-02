package practicamp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class EquipoTest {

    private Equipo arma1Mano;
    private Equipo arma2Manos;
    private Equipo armaduraDefensa;
    private Equipo armaduraAtaque;


    @Before
    public void setUp() {
        arma1Mano = new Arma("Cuchillo de caza", 0, 2, 1);
        arma2Manos = new Arma("Martillo de hueso", 3, 1, 2);
        armaduraDefensa = new Armadura("Chaleco de cuero", 2, 0);
        armaduraAtaque = new Armadura("Armadura de las sombras", 0, 2);
    }


    /**
    Test de getNombre.
    */

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String expResult = "Cuchillo de caza";
        String result = arma1Mano.getNombre();
        assertEquals(expResult, result);

        expResult = "Martillo de hueso";
        result = arma2Manos.getNombre();
        assertEquals(expResult, result);

        expResult = "Chaleco de cuero";
        result = armaduraDefensa.getNombre();
        assertEquals(expResult, result);

        expResult = "Armadura de las sombras";
        result = armaduraAtaque.getNombre();
        assertEquals(expResult, result);
    }

    /**
    Test de getDefensa.
    */
    @Test
    public void testGetDefensa() {
        System.out.println("getDefensa");
        int expResult = 2;
        int result = armaduraDefensa.getDefensa();
        assertEquals(expResult, result);

        expResult = 0;
        result = arma1Mano.getDefensa();
        assertEquals(expResult, result);

        expResult = 3;
        result = arma2Manos.getDefensa();
        assertEquals(expResult, result);

        expResult = 0;
        result = armaduraAtaque.getDefensa();
        assertEquals(expResult, result);
    }

    /**
    Test de getAtaque.
    */
    @Test
    public void testGetAtaque() {
        System.out.println("getAtaque");
        int expResult = 0;
        int result = armaduraDefensa.getAtaque();
        assertEquals(expResult, result);

        expResult = 2;
        result = armaduraAtaque.getAtaque();
        assertEquals(expResult, result);

        expResult = 2;
        result = arma1Mano.getAtaque();
        assertEquals(expResult, result);

        expResult = 1;
        result = arma2Manos.getAtaque();
        assertEquals(expResult, result);
    }

}