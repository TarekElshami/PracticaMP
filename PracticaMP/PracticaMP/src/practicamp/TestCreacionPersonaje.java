/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;


/**
 *
 * @author Etheko
 */
public class TestCreacionPersonaje {

    public void setNombre(String nombre) throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {
        Almacen a = new Almacen();
        JFrame f = new JFrame();
        f.setSize(640, 480);
        CreacionPersonaje interfaz = new CreacionPersonaje();
        Robot robot = new Robot();
        f.add(interfaz);
        f.setVisible(true);
        robot.delay(1000);
        interfaz.setNombre(nombre);
    }

    private void iniciarTest(String nombre, String raza) throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {
        // inicializacion de componentes necesarios
        Almacen a = new Almacen();
        JFrame f = new JFrame();
        f.setSize(640, 480);
        CreacionPersonaje interfaz = new CreacionPersonaje();
        Robot robot = new Robot();
        f.add(interfaz);
        f.setVisible(true);
        robot.delay(1000);

        // creacion de usuario temporal
        Usuario u = new Usuario("Test", "test");
        a.addUsuario(u);
        int idx = a.buscarUsuario(u);
        a.setUsuarioActivo(idx);

        // ponemos el nombre del personaje en el campo de la ventana
        interfaz.setNombre(nombre);

        robot.mouseMove(320, 240); // apuntamos a la combobox
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(1000);

        //Seleccionamos la raza correspondiente
        if ("Cazador".equals(raza)) {
            robot.keyPress(KeyEvent.VK_DOWN);

        } else if ("Licantropo".equals(raza)) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
        }

        robot.keyPress(KeyEvent.VK_ENTER);

        //Confirmamos selección y comprobamos que ha cambiado el atributo en el usuario
        robot.mouseMove(580, 430); // confirmar
        robot.delay(1000);

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000);

        assert raza.equals(u.getTipoPersonaje()) : "La raza no coincide";

    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {
        TestCreacionPersonaje tcp = new TestCreacionPersonaje();

        // Comprobamos que se asigna el personaje correctamente al usuario (cambia su atributo tipoPersonaje)
        tcp.iniciarTest("Chris", "Vampiro");
        tcp.iniciarTest("Lauren", "Cazador");
        tcp.iniciarTest("Ganon", "Licantropo");
        
    }
}
