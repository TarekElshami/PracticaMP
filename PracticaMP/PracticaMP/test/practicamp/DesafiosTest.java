/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aserr
 */
public class DesafiosTest {
    
    private Almacen a;
    private JFrame f;
    private Desafios window;
    private Usuario usuario;
    private Robot robot;
    
    public DesafiosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException, AWTException {
        a = new Almacen();
        f = new JFrame();
        f.setSize(640, 480);
        window = new Desafios(a);
        f.add(window);
        f.setVisible(true);
        robot = new Robot();
        
        // Creacion de usuario temporal
        usuario = new Usuario("Test", "test");
        a.addUsuario(usuario);
        int idx = Almacen.buscarUsuario(usuario);
        Almacen.setUsuarioActivo(idx);
        
        Usuario us = new Usuario("Juan", "Juan");
        us.setTipoPersonaje("Vampiro");
        a.addUsuario(us);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actualizarList method, of class Desafios.
     */
    @Test
    public void testActualizarList() {
        System.out.println("actualizarList");
        Usuario us1 = new Usuario("Pedro", "Pedro");
        us1.setTipoPersonaje("Vampiro");
        a.addUsuario(us1);
        Desafios instance = window;
        instance.actualizarList();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("La tabla no se actualiza correctamente", "Pedro", instance.getLastUsuarioList());
    }

    /**
     * Test of setOroApostado method, of class Desafios.
     */
    @Test
    public void testDesafiarActionPerformed() {
        System.out.println("desafiarActionPerformed");
        String apuesta = "100";
        Desafios instance = window;
        instance.actualizarList();
        instance.setOroApostado(apuesta);
        instance.setUsuarioList(0);
        instance.desafiarActionPerformed();
        // TODO review the generated test code and remove the default call to fail.
        Desafio desafio = a.getDesafiosSinValidar().get(0);   
        assertEquals("No coincide el desafiante", "Test", desafio.getDesafiante().getNick());
        assertEquals("No coincide el desafiado", "Juan", desafio.getDesafiado().getNick());
        assertEquals("No coincide el oro apostado", Integer.parseInt(apuesta), desafio.getOro(),0);
    }

    
}
