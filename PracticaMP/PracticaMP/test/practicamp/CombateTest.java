/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class CombateTest {

    private Desafio desafio;
    private Usuario desafiante;
    private Usuario desafiado;
    private int oro;

    private Combate combate;
    private ArrayList<ArrayList<String>> personajes;

    public CombateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException {
        desafiante = new Usuario("U1", "test1");
        desafiado = new Usuario("U2", "test2");
        oro = 100;
        desafio = new Desafio(desafiante, desafiado, oro);
        Almacen almacen = new Almacen();
        almacen.addUsuario(desafiante);
        almacen.addUsuario(desafiado);

        combate = new Combate(almacen);

        // Instanciamos listas de armas
        List<Arma> listaArmasj1 = new ArrayList<>();
        List<Arma> listaArmasj2 = new ArrayList<>();
        //----

        //Instanciamos armas y armaduras para cada jugador 
        Arma armaj1 = new Arma("Garras", 1, 3, 2);
        Arma armaj2 = new Arma("Cetro", 2, 2, 1);

        listaArmasj1.add(armaj1);
        listaArmasj2.add(armaj2);

        Armadura armaduraj1 = new Armadura("Armadura Celestial", 3, 1);
        Armadura armaduraj2 = new Armadura("Armadura de Mago", 3, 2);

        // Cargar jugadores
        Usuario jugador1 = desafio.getDesafiado();
        Usuario jugador2 = desafio.getDesafiante();

        // Asignar personaje a cada jugador
        jugador1.setTipoPersonaje("Vampiro");
        jugador2.setTipoPersonaje("Licantropo");

        // Asignar armas y armaduras a cada jugador
        jugador1.setArmasActivas(listaArmasj1);
        jugador2.setArmasActivas(listaArmasj2);

        jugador1.setArmaduraActiva(armaduraj1);
        jugador2.setArmaduraActiva(armaduraj2);

        //Carga de personajes de cada jugador
        Personaje personaje1 = null;
        Personaje personaje2 = null;

        // Obtencion de cada personaje
        for (Personaje pj1 : almacen.getPersonajes()) {
            if (pj1.getNombre().equals(jugador1.getTipoPersonaje())) {
                personaje1 = pj1;
            }
        }

        for (Personaje pj2 : almacen.getPersonajes()) {
            if (pj2.getNombre().equals(jugador2.getTipoPersonaje())) {
                personaje2 = pj2;
            }
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of iniciarCombate method, of class Combate.
     */
    @Test
    public void testIniciarCombate() throws Exception {
        System.out.println("iniciarCombate");
        Desafio desafio = this.desafio;
        Combate instance = this.combate;
        instance.iniciarCombate(desafio);
        
        if (this.desafio.getGanador() != null) {
            assert (this.desafio.getGanador().equals(desafiante) || this.desafio.getGanador().equals(desafiado)) : "No se ha establecido correctamente ganador";
            if (this.desafio.getGanador().equals(desafiante)) {
                assert (this.desafio.getDesafiante().getOro() == 500 + this.oro) : "No se ha sumado correctamente el oro al ganador";
                assert (this.desafio.getDesafiado().getOro() == 500 - this.oro) : "No se ha restado correctamente el oro al perdedor";

            } else if (this.desafio.getGanador().equals(desafiado)) {
                assert (this.desafio.getDesafiante().getOro() == 500 - this.oro) : "No se ha sumado correctamente el oro al ganador";
                assert (this.desafio.getDesafiado().getOro() == 500 + this.oro) : "No se ha restado correctamente el oro al perdedor";

            }
        } else {
            assert (this.desafio.getDesafiante().getOro() == 500) : "No se mantiene el oro en caso de empate";
            assert (this.desafio.getDesafiado().getOro() == 500) : "No se mantiene el oro en caso de empate";

        }

    }

}
