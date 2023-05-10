package practicamp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RankingTest {

    private Ranking r;
    
    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException {
        r = new Ranking();
    }
    
    @Test
    public void testAgregarJugador() throws Exception {
        LinkedList<Jugador> rankingOriginal = Ranking.getRanking();

        Jugador jugador = new Jugador("Test", 5);
        Ranking.agregarJugador(jugador);
        LinkedList<Jugador> ranking = Ranking.getRanking();
        boolean found = false;
        for (Jugador j : ranking) {
            if (j.getNombre().equals(jugador.getNombre()) && j.getVictorias() == jugador.getVictorias()) {
                found = true;
            }
        }
        assertTrue(found);
        Ranking.setListaJugadores(rankingOriginal);
    }
    
    
    @Test
    public void testGetRanking() {
        LinkedList<Jugador> ranking = Ranking.getRanking();
        assertNotNull(ranking);
    }
    
    @Test
    public void testSetListaJugadores() throws Exception {
        LinkedList<Jugador> jugadoresPrueba = new LinkedList<>();
        jugadoresPrueba.add(new Jugador("Jugador1", 10));
        jugadoresPrueba.add(new Jugador("Jugador2", 5));

        Ranking.setListaJugadores(jugadoresPrueba);

        LinkedList<Jugador> ranking = Ranking.getRanking();
        assertEquals(jugadoresPrueba, ranking);
    }
}