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
import java.util.Random;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Addy
 */
public class RegistroTest {
    
    private Almacen a;
    private JFrame f;
    private Registro window;
    private Usuario usuario;
    private Robot robot;
    private Ranking r;
    
    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {
        // Inicializacion (ventana y clases)
        a = new Almacen();
        f = new JFrame();
        f.setSize(640, 480);
        r = new Ranking();
        window = new Registro(a, r);
        f.add(window);
        f.setVisible(true);
        robot = new Robot();
    }
    

    @Test
    public void testGenerarId() {
        String idGenerado = window.generarId(); // genera un nuevo ID
        String patron = "[A-Z]\\d{2}[A-Z]{2}"; // define la expresión regular del patrón esperado
        boolean cumplePatron = idGenerado.matches(patron); // verifica si el ID generado cumple con el patrón
        assertTrue(cumplePatron); // verifica que el ID generado cumple con el patrón
    }

    @Test
    public void registroJugador(){
        String nombre = "Juan";
        int longitud = 6;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            char c = caracteres.charAt(index);
            sb.append(c);
        }
        String nick = sb.toString();
        String password = "juan";
        
        window.setNombre(nombre);
        window.setNick(nick);
        window.setContraseña(password);
        
        robot.delay(1000);
        robot.mouseMove(330, 230);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        robot.delay(1000);

        robot.mouseMove(605, 435);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        robot.delay(1000);

        Usuario u = window.getUsuario();

        // Verificar que los atributos tengan los valores correctos 
        assert u.getNombre().equals(nombre) : "El nombre del usuario no coincide";
        assert u.getNick().equals(nick) : "El nick del usuario no coincide";
        assert u.getContrasena().equals(password) : "La contraseña del usuario no coincide";
        assert u.getRol() == Rol.jugador : "El rol del usuario no es el correcto";

        // Verificar que el ID del usuario tenga el formato correcto
        String id = u.getId();
        assert id.length() == 5 : "La longitud del ID no es correcta";
        assert Character.isLetter(id.charAt(0)) : "El primer caracter del ID no es una letra";
        assert Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)) : "Los caracteres 2 y 3 del ID no son números";
        assert Character.isLetter(id.charAt(3)) && Character.isLetter(id.charAt(4)) : "Los caracteres 4 y 5 del ID no son letras";
    }
    
    @Test
    public void registroAdmin(){
        String nombre = "admin";
        int longitud = 6;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            char c = caracteres.charAt(index);
            sb.append(c);
        }
        String nick = sb.toString();
        String password = "admin";
        
        window.setNombre(nombre);
        window.setNick(nick);
        window.setContraseña (password);
        
        robot.mouseMove(330, 230);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        // Hacer clic en el combobox
        robot.mouseMove(320, 300); // Mover el ratón a la posición del combobox
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        // Esperar a que se muestre la lista desplegable
        robot.delay(1000);
        
        // Seleccionar la opción 2
        robot.keyPress(KeyEvent.VK_DOWN); // Mover hacia abajo en la lista
        robot.keyPress(KeyEvent.VK_DOWN); // Mover hacia abajo en la lista
        robot.keyPress(KeyEvent.VK_ENTER); // Seleccionar la opción
        robot.delay(1000);

        robot.mouseMove(605, 435);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón

        robot.delay(1000);

        Usuario u = window.getUsuario();

        // Verificar que los atributos tengan los valores correctos 
        assert u.getNombre().equals(nombre) : "El nombre del usuario no coincide";
        assert u.getNick().equals(nick) : "El nick del usuario no coincide";
        assert u.getContrasena().equals(password) : "La contraseña del usuario no coincide";
        assert u.getRol() == Rol.admin : "El rol del usuario no es el correcto";

        // Verificar que el de admin es null
        assert u.getId() == null : "El admin tiene ID";
    }
}
