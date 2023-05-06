/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.util.ArrayList;
import java.util.List;
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
public class UsuarioTest {
    
    public UsuarioTest() {
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

    /**
     * Test of restarOro method, of class Usuario.
     */
    @Test
    public void testRestarOro() {
        System.out.println("restarOro");
        double cantidad = 100.0;
        Usuario instance = new Usuario("Pedro", "Pedro");
        instance.restarOro(cantidad); // Restar 100 de oro
        assertEquals(400.0, instance.getOro(), 0);
    }

    /**
     * Test of sumarOro method, of class Usuario.
     */
    @Test
    public void testSumarOro() {
        System.out.println("sumarOro");
        double cantidad = 100.0;
        Usuario instance = new Usuario("Pedro", "Pedro");
        instance.sumarOro(cantidad);
        assertEquals(600.0, instance.getOro(), 0);
    }

    /**
     * Test of addNotificacion method, of class Usuario.
     */
    @Test
    public void testAddNotificacion() {
        System.out.println("addNotificacion");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Notificacion noti = new Notificacion(desafio);
        Usuario instance = desafiado;
        instance.addNotificacion(noti);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El nick del desafiante no coincide" , desafiante.getNick(), instance.getNotificaciones().get(0).getRival());
        assertEquals(100.0 , instance.getNotificaciones().get(0).getOroApostado(), 0);
        
    }

    /**
     * Test of setNotificaciones method, of class Usuario.
     */
    @Test
    public void testSetNotificaciones() {
        System.out.println("setNotificaciones");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        Usuario desafiante2 = new Usuario("Lucas", "Lucas");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Desafio desafio2 = new Desafio(desafiante2, desafiado, 200.0);
        
        List<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion(desafio));
        notificaciones.add(new Notificacion(desafio2));
        Usuario instance = desafiado;
        instance.setNotificaciones(notificaciones);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El nick del desafiante no coincide" , desafiante.getNick(), instance.getNotificaciones().get(0).getRival());
        assertEquals(100.0 , instance.getNotificaciones().get(0).getOroApostado(), 0);
        assertEquals("El nick del desafiante no coincide" , desafiante2.getNick(), instance.getNotificaciones().get(1).getRival());
        assertEquals(200.0 , instance.getNotificaciones().get(1).getOroApostado(), 0);
    }

    /**
     * Test of setTipoPersonaje method, of class Usuario.
     */
    @Test
    public void testSetTipoPersonaje() {
        System.out.println("setTipoPersonaje");
        String tipoPersonaje = "Vampiro";
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setTipoPersonaje(tipoPersonaje);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El personaje no coincide" , "Vampiro", instance.getTipoPersonaje());
    }

    /**
     * Test of setPersonaje method, of class Usuario.
     */
    @Test
    public void testSetPersonaje() {
        System.out.println("setPersonaje");
        String personaje = "ChupaSangre.Jr";
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setPersonaje(personaje);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El personaje no coincide" , personaje, instance.getPersonaje());
    }

    /**
     * Test of setArmasActivas method, of class Usuario.
     */
    @Test
    public void testSetArmasActivas() {
        System.out.println("setArmasActivas");
        List<Arma> armasActivas = new ArrayList<>();
        Arma cuchilloDeCaza = new Arma("Cuchillo de caza", 0, 2, 1);
        Arma pistolaConBalasDePlata = new Arma("Pistola con balas de plata", 1, 1, 1);
        armasActivas.add(cuchilloDeCaza);
        armasActivas.add(pistolaConBalasDePlata);
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setArmasActivas(armasActivas);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El arma 1 no coincide" , armasActivas.get(0), instance.getArmasActivas().get(0));
        assertEquals("El arma 2 no coincide" , armasActivas.get(1), instance.getArmasActivas().get(1));
    }

    /**
     * Test of setArmaduraActiva method, of class Usuario.
     */
    @Test
    public void testSetArmaduraActiva() {
        System.out.println("setArmaduraActiva");
        Armadura armaduraActiva = new Armadura("Chaleco de cuero", 1, 0);
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setArmaduraActiva(armaduraActiva);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("La armadura no coincide" , armaduraActiva, instance.getArmaduraActiva());
    }

    /**
     * Test of setOro method, of class Usuario.
     */
    @Test
    public void testSetOro() {
        System.out.println("setOro");
        double ammount = 100.0;
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setOro(ammount);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(ammount , instance.getOro(), 0);
    }

    /**
     * Test of setRol method, of class Usuario.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Rol rol = Rol.admin;
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to fail.
         assertEquals("El rol no coincide" , rol, instance.getRol());
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Pedro";
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El nombre no coincide" , nombre, instance.getNombre());
    }

    /**
     * Test of setId method, of class Usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "AAA4";
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("La id no coincide" , id, instance.getId());
    }

    /**
     * Test of addToHistorial method, of class Usuario.
     */
    @Test
    public void testAddToHistorial() {
        System.out.println("addToHistorial");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Usuario instance = desafiado;
        instance.addToHistorial(desafio);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El nick del desafiante no coincide" , desafiante.getNick(), instance.getHistorial().get(0).getDesafiante().getNick());
        assertEquals(100.0 , instance.getHistorial().get(0).getOro(), 0);
    }

    /**
     * Test of getId method, of class Usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String id = "AAA4";
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("La id no coincide" , id, instance.getId());
    }

    /**
     * Test of getNotificaciones method, of class Usuario.
     */
    @Test
    public void testGetNotificaciones() {
        System.out.println("getNotificaciones");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        Usuario desafiante2 = new Usuario("Lucas", "Lucas");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Desafio desafio2 = new Desafio(desafiante2, desafiado, 200.0);
        
        List<Notificacion> expResult = new ArrayList<>();
        expResult.add(new Notificacion(desafio));
        expResult.add(new Notificacion(desafio2));
        Usuario instance = desafiado;
        instance.setNotificaciones(expResult);
        List<Notificacion> result = instance.getNotificaciones();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getNick method, of class Usuario.
     */
    @Test
    public void testGetNick() {
        System.out.println("getNick");
        Usuario instance = new Usuario("Juan", "Juan");
        String expResult = "Juan";
        String result = instance.getNick();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getContrasena method, of class Usuario.
     */
    @Test
    public void testGetContrasena() {
        System.out.println("getContrasena");
        Usuario instance = new Usuario("Juan", "Juan");
        String expResult = "Juan";
        String result = instance.getContrasena();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getOro method, of class Usuario.
     */
    @Test
    public void testGetOro() {
        System.out.println("getOro");
        Usuario instance = new Usuario("Juan", "Juan");
        double expResult = 500.0;
        double result = instance.getOro();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getTipoPersonaje method, of class Usuario.
     */
    @Test
    public void testGetTipoPersonaje() {
        System.out.println("getTipoPersonaje");
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setTipoPersonaje("Vampiro");
        String expResult = "Vampiro";
        String result = instance.getTipoPersonaje();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getRol method, of class Usuario.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setRol(Rol.admin);
        Rol expResult = Rol.admin;
        Rol result = instance.getRol();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getArmasActivas method, of class Usuario.
     */
    @Test
    public void testGetArmasActivas() {
        System.out.println("getArmasActivas");
        List<Arma> expResult = new ArrayList<>();
        Arma cuchilloDeCaza = new Arma("Cuchillo de caza", 0, 2, 1);
        Arma pistolaConBalasDePlata = new Arma("Pistola con balas de plata", 1, 1, 1);
        expResult.add(cuchilloDeCaza);
        expResult.add(pistolaConBalasDePlata);
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setArmasActivas(expResult);
        List<Arma> result = instance.getArmasActivas();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getArmaduraActiva method, of class Usuario.
     */
    @Test
    public void testGetArmaduraActiva() {
        System.out.println("getArmaduraActiva");
        Armadura expResult = new Armadura("Chaleco de cuero", 1, 0);
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setArmaduraActiva(expResult);
        Armadura result = instance.getArmaduraActiva();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getHistorial method, of class Usuario.
     */
    @Test
    public void testGetHistorial() {
        System.out.println("getHistorial");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Usuario instance = desafiado;
        instance.addToHistorial(desafio);
        List<Desafio> expResult = new ArrayList<>();
        expResult.add(desafio);
        List<Desafio> result = instance.getHistorial();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of isBaneado method, of class Usuario.
     */
    @Test
    public void testIsBaneado() {
        System.out.println("isBaneado");
        Usuario instance = new Usuario("Juan", "Juan");
        boolean expResult = false;
        boolean result = instance.isBaneado();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of setBaneado method, of class Usuario.
     */
    @Test
    public void testSetBaneado() {
        System.out.println("setBaneado");
        Usuario instance = new Usuario("Juan", "Juan");
        boolean baneado = true;
        instance.setBaneado(baneado);
        // TODO review the generated test code and remove the default call to fail
        assertTrue(instance.isBaneado());
    }

    /**
     * Test of getVictorias method, of class Usuario.
     */
    @Test
    public void testGetVictorias() {
        System.out.println("getVictorias");
        Usuario instance = new Usuario("Juan", "Juan");
        int expResult = 0;
        int result = instance.getVictorias();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of sumarVictoria method, of class Usuario.
     */
    @Test
    public void testSumarVictoria() {
        System.out.println("sumarVictoria");
        Usuario instance = new Usuario("Juan", "Juan");
        instance.sumarVictoria();
        int expResult = 1;
        int result = instance.getVictorias();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setNombre("ElMajo");
        String expResult = "ElMajo";
        String result = instance.getNombre();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPersonaje() {
        System.out.println("getPersonaje");
        Usuario instance = new Usuario("Juan", "Juan");
        instance.setPersonaje("CupaSangre.Jr");
        String expResult = "CupaSangre.Jr";
        String result = instance.getPersonaje();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
    
}
