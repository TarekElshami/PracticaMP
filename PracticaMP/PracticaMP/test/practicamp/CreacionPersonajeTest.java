/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CreacionPersonajeTest {

    private Almacen a;
    private JFrame f;
    private CreacionPersonaje window;
    private Usuario usuario;
    private Robot robot;
    private ArrayList<ArrayList<String>> personajes;

    public CreacionPersonajeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {

        // Inicializacion (ventana y clases)
        a = new Almacen();
        f = new JFrame();
        f.setSize(640, 480);
        window = new CreacionPersonaje();
        f.add(window);
        f.setVisible(true);
        robot = new Robot();

        // Creacion de usuario temporal
        usuario = new Usuario("Test", "test");
        a.addUsuario(usuario);
        int idx = a.buscarUsuario(usuario);
        a.setUsuarioActivo(idx);

        // Probaremos a crear 3 personajes
        personajes = new ArrayList<>();

        ArrayList<String> p1 = new ArrayList<>();
        p1.add("Chris");
        p1.add("Vampiro");

        ArrayList<String> p2 = new ArrayList<>();
        p2.add("Lauren");
        p2.add("Cazador");

        ArrayList<String> p3 = new ArrayList<>();
        p3.add("Ganon");
        p3.add("Licantropo");

        personajes.add(p1);
        personajes.add(p2);
        personajes.add(p3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class CreacionPersonaje.
     */
    @Test
    public void testSetNombre() throws AWTException {
        System.out.println("setNombre");
        String nombre = "TestName";
        robot.delay(200);
        CreacionPersonaje instance = window;
        String expResult = nombre;
        instance.setNombre(nombre);
        assertEquals(expResult, instance.getNombre());
    }

    /**
     * Test of getTipo method, of class CreacionPersonaje.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        CreacionPersonaje instance = new CreacionPersonaje();
        String expResult = "Vampiro";
        robot.delay(500);

        robot.mouseMove(320, 240); // apuntamos a la combobox
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(200);

        // Seleccionamos la raza Vampiro
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(500);

        String result = instance.getTipo();

        assertEquals("El tipo coincide", expResult, result);
    }

    /**
     * Test of setNombre method, of class CreacionPersonaje.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        String nombre = "TestName";
        CreacionPersonaje instance = new CreacionPersonaje();
        instance.setNombre(nombre);
        assertEquals("El nombre coincide", nombre, instance.getNombre());
    }

    /**
     * Test of GUI, of class CreacionPersonaje.
     */
    @Test
    public void testGUIInput() throws AWTException {
        System.out.println("GUI");
        CreacionPersonaje instance = window;

        for (ArrayList<String> personaje : personajes) {
            String pNombre = personaje.get(0);
            String pRaza = personaje.get(1);

            // ponemos el nombre del personaje en el campo de la ventana
            instance.setNombre(pNombre);
            robot.delay(200);
            robot.mouseMove(320, 240); // apuntamos a la combobox
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            robot.delay(200);

            // Seleccionamos la raza correspondiente
            if ("Cazador".equals(pRaza)) {
                robot.keyPress(KeyEvent.VK_DOWN);

            } else if ("Licantropo".equals(pRaza)) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyPress(KeyEvent.VK_DOWN);
            }
            robot.keyPress(KeyEvent.VK_ENTER);

            //Confirmamos selección y comprobamos que ha cambiado el atributo en el usuario
            robot.mouseMove(580, 430); // confirmar
            robot.delay(200);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.delay(200);

            String expNombre = pNombre;
            String expRaza = pRaza;

            assertEquals("El nombre de personaje no coincide con el introducido", expNombre, usuario.getNombre());
            assertEquals("La raza del personaje no coincide con la seleccionada", expRaza, usuario.getTipoPersonaje());

        }
    }

}
