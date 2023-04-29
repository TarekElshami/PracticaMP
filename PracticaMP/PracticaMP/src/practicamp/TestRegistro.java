package practicamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class TestRegistro {
    public void testUsuario() throws AWTException, IOException, FileNotFoundException, ClassNotFoundException {
        Almacen a = new Almacen();
        Ranking r = new Ranking();
        JFrame f= new JFrame();
        f.setSize(640,480);
        Registro interfaz = new Registro(a, r);
        Robot robot = new Robot();
        f.add(interfaz);
        f.setVisible(true);
        robot.delay(1000);
        
        String nombre = "Juan";
        String nick = "Juan";
        String password = "juan";
        
        interfaz.setNombre(nombre);
        interfaz.setNick(nick);
        interfaz.setContraseña (password);
        
        robot.mouseMove(330, 230);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        robot.mouseMove(605, 435);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        /*
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
        */
        robot.delay(1000);

        Usuario u = interfaz.getUsuario();

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
    public void testAdmin() throws AWTException, IOException, FileNotFoundException, ClassNotFoundException {
        Almacen a = new Almacen();
        Ranking r = new Ranking();
        JFrame f= new JFrame();
        f.setSize(640,480);
        Registro interfaz = new Registro(a, r);
        Robot robot = new Robot();
        f.add(interfaz);
        f.setVisible(true);
        robot.delay(1000);
        
        String nombre = "admin";
        String nick = "admin";
        String password = "admin";
        
        interfaz.setNombre(nombre);
        interfaz.setNick(nick);
        interfaz.setContraseña (password);
        
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
        
        robot.mouseMove(605, 435);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón


        Usuario u = interfaz.getUsuario();

        // Verificar que los atributos tengan los valores correctos 
        assert u.getNombre().equals(nombre) : "El nombre del usuario no coincide";
        assert u.getNick().equals(nick) : "El nick del usuario no coincide";
        assert u.getContrasena().equals(password) : "La contraseña del usuario no coincide";
        assert u.getRol() == Rol.admin : "El rol del usuario no es el correcto";

        // Verificar que el de admin es null
        assert u.getId() == null : "El admin tiene ID";
    }

    public static void main(String[] args) throws AWTException, IOException, FileNotFoundException, ClassNotFoundException {
            TestRegistro t = new TestRegistro();
            t.testUsuario();
            t.testAdmin();
            System.out.println("Todo correcto");
    }
}

