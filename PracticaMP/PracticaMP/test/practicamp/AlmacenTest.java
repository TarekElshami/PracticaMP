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
import static org.junit.Assert.*;

/**
 *
 * @author aserr
 */
public class AlmacenTest {
    
    public AlmacenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException, FileNotFoundException, ClassNotFoundException {

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateFiles method, of class Almacen.
     */
    @Test
    public void testUpdateFiles() throws Exception {
        System.out.println("updateFiles");
        Almacen.updateFiles();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUsers method, of class Almacen.
     */
    @Test
    public void testUpdateUsers() throws Exception {
        System.out.println("updateUsers");
        Almacen instance = new Almacen();
        instance.updateUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarFicheroDesafios method, of class Almacen.
     */
    @Test
    public void testActualizarFicheroDesafios() throws Exception {
        System.out.println("actualizarFicheroDesafios");
        Almacen instance = new Almacen();
        instance.actualizarFicheroDesafios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarPersonajes method, of class Almacen.
     */
    @Test
    public void testCargarPersonajes() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("cargarPersonajes");
        Almacen instance = new Almacen();
        instance.cargarPersonajes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarDesafioAValidacion method, of class Almacen.
     */
    @Test
    public void testAgregarDesafioAValidacion() throws Exception {
        System.out.println("agregarDesafioAValidacion");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        Usuario desafiante2 = new Usuario("Lucas", "Lucas");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Desafio desafio2 = new Desafio(desafiante2, desafiado, 200.0); 
        Almacen a = new Almacen();
        a.agregarDesafioAValidacion(desafio);
        a.agregarDesafioAValidacion(desafio2);
        List<Desafio> expResult = new ArrayList();
        expResult.add(desafio);
        expResult.add(desafio2);
        List<Desafio> result = a.getDesafiosSinValidar();
        int aux = result.size();
        
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult.get(0).getDesafiado().getNick(), result.get(aux-2).getDesafiado().getNick());
        assertEquals(expResult.get(1).getDesafiado().getNick(), result.get(aux-1).getDesafiado().getNick());
        assertEquals(expResult.get(0).getDesafiante().getNick(), result.get(aux-2).getDesafiante().getNick());
        assertEquals(expResult.get(0).getOro(), result.get(aux-2).getOro(),0);
        assertEquals(expResult.get(1).getDesafiante().getNick(), result.get(aux-1).getDesafiante().getNick());
        assertEquals(expResult.get(1).getOro(), result.get(aux-1).getOro(),0);
    }

    /**
     * Test of mostrarRanking method, of class Almacen.
     */
    @Test
    public void testMostrarRanking() throws IOException, FileNotFoundException, ClassNotFoundException{
        System.out.println("mostrarRanking");
        Almacen instance = new Almacen();
        instance.mostrarRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUsuario method, of class Almacen.
     */
    @Test
    public void testAddUsuario() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("addUsuario");
        Usuario usu = new Usuario("Lucas", "Lucas");
        Usuario usu2 = new Usuario("Pedro", "Pedro");
        Almacen instance = new Almacen();
        instance.addUsuario(usu);
        instance.addUsuario(usu2);
        int aux = instance.getUsuarios().size();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El nick del usuario 1 no coincide" , usu.getNick(), instance.getUsuarios().get(aux-2).getNick());
        assertEquals("El nick del usuario 2 no coincide" , usu2.getNick(), instance.getUsuarios().get(aux-1).getNick());
        assertEquals("La contraseña del usuario 1 no coincide" , usu.getContrasena(), instance.getUsuarios().get(aux-2).getContrasena());
        assertEquals("La contraseña del usuario 2 no coincide" , usu2.getContrasena(), instance.getUsuarios().get(aux-1).getContrasena());
    }

    /**
     * Test of setUsuarioActivo method, of class Almacen.
     */
    @Test
    public void testSetUsuarioActivo() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("setUsuarioActivo");
        Usuario usuario = new Usuario("Pedro", "Pedro");
        Almacen instance = new Almacen();
        instance.addUsuario(usuario);
        int aux = instance.getUsuarios().size();
        Almacen.setUsuarioActivo(aux-1);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El usuarioActivo no coincide" , usuario.getNick(), instance.getUsuarioActivo().getNick());
        assertEquals("El usuarioActivo no coincide" , usuario.getContrasena(), instance.getUsuarioActivo().getContrasena());
    }

    /**
     * Test of setUsuario method, of class Almacen.
     */
    @Test
    public void testSetUsuario() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("setUsuario");
        
        // si un usario ya está en almacen y le intentamos volver a añadir con setUsuario, la nuava info se sustituye por la anterior manteniendo la posición en el array
        Usuario usuario = new Usuario("Pedro", "Pedro");
        Usuario usuario2 = new Usuario("Juan", "Juan");
        Almacen instance = new Almacen();
        instance.addUsuario(usuario);
        instance.addUsuario(usuario2);
        instance.setUsuario(usuario);
        int aux = instance.getUsuarios().size();
        // TODO review the generated test code and remove the default call to fail.
        assertNotEquals("hay un problema" , usuario.getNick(), instance.getUsuarios().get(aux-1).getNick());
        assertNotEquals("hay un problema" , usuario.getContrasena(), instance.getUsuarios().get(aux-1).getContrasena());
        
        // en caso de que este usuario no esté en almacen, este se añade al final de array 
        int longitud = 6;
        StringBuilder sb = new StringBuilder(longitud);
        String nick = sb.toString();
        Usuario usuario3 = new Usuario(nick, nick);
        System.out.println(aux);
        int aux2 = instance.getUsuarios().size();
        assertEquals("El usuario no coincide" , usuario3.getNick(), instance.getUsuarios().get(aux).getNick());
        assertEquals("El usuario no coincide" , usuario3.getContrasena(), instance.getUsuarios().get(aux).getContrasena());
    
    }

    /**
     * Test of getUsuarioActivo method, of class Almacen.
     */
    @Test
    public void testGetUsuarioActivo() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("getUsuarioActivo");
        Usuario usuario = new Usuario("Juan", "Juan");
        Almacen instance = new Almacen();
        instance.addUsuario(usuario);
        int aux = instance.getUsuarios().size();
        Almacen.setUsuarioActivo(aux-1);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("El usuarioActivo no coincide" , usuario.getNick(), instance.getUsuarioActivo().getNick());
        assertEquals("El usuarioActivo no coincide" , usuario.getContrasena(), instance.getUsuarioActivo().getContrasena());
    }

    /**
     * Test of getEsbirros method, of class Almacen.
     */
    @Test
    public void testGetEsbirros() {
        System.out.println("getEsbirros");
        List<Esbirro> expResult = null;
        List<Esbirro> result = Almacen.getEsbirros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModificadores method, of class Almacen.
     */
    @Test
    public void testGetModificadores() {
        System.out.println("getModificadores");
        List<Modificador> expResult = null;
        List<Modificador> result = Almacen.getModificadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesafiosSinValidar method, of class Almacen.
     */
    @Test
    public void testGetDesafiosSinValidar() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("getDesafiosSinValidar");
        Usuario desafiante = new Usuario("Juan", "Juan");
        Usuario desafiado = new Usuario("Luis", "Luis");
        Usuario desafiante2 = new Usuario("Lucas", "Lucas");
        
        Desafio desafio = new Desafio(desafiante, desafiado, 100.0);
        Desafio desafio2 = new Desafio(desafiante2, desafiado, 200.0); 
        Almacen a = new Almacen();
        a.agregarDesafioAValidacion(desafio);
        a.agregarDesafioAValidacion(desafio2);
        List<Desafio> expResult = new ArrayList();
        expResult.add(desafio);
        expResult.add(desafio2);
        List<Desafio> result = a.getDesafiosSinValidar();
        int aux = result.size();
        
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult.get(0).getDesafiado().getNick(), result.get(aux-2).getDesafiado().getNick());
        assertEquals(expResult.get(1).getDesafiado().getNick(), result.get(aux-1).getDesafiado().getNick());
        assertEquals(expResult.get(0).getDesafiante().getNick(), result.get(aux-2).getDesafiante().getNick());
        assertEquals(expResult.get(0).getOro(), result.get(aux-2).getOro(),0);
        assertEquals(expResult.get(1).getDesafiante().getNick(), result.get(aux-1).getDesafiante().getNick());
        assertEquals(expResult.get(1).getOro(), result.get(aux-1).getOro(),0);
        
        
    }

    /**
     * Test of getArmas method, of class Almacen.
     */
    @Test
    public void testGetArmas() {
        System.out.println("getArmas");
        List<Arma> expResult = null;
        List<Arma> result = Almacen.getArmas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarios method, of class Almacen.
     */
    @Test
    public void testGetUsuarios() {
        System.out.println("getUsuarios");
        List<Usuario> expResult = null;
        List<Usuario> result = Almacen.getUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonajes method, of class Almacen.
     */
    @Test
    public void testGetPersonajes() {
        System.out.println("getPersonajes");
        List<Personaje> expResult = null;
        List<Personaje> result = Almacen.getPersonajes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArmaduras method, of class Almacen.
     */
    @Test
    public void testGetArmaduras() {
        System.out.println("getArmaduras");
        List<Armadura> expResult = null;
        List<Armadura> result = Almacen.getArmaduras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrincante method, of class Almacen.
     */
    @Test
    public void testGetContrincante() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("getContrincante");
        String contrincante = "";

        Almacen instance = new Almacen();
        Usuario expResult = null;
        Usuario result = instance.getContrincante(contrincante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexUsuarioActivo method, of class Almacen.
     */
    @Test
    public void testGetIndexUsuarioActivo() {
        System.out.println("getIndexUsuarioActivo");
        int expResult = 0;
        int result = Almacen.getIndexUsuarioActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInNot method, of class Almacen.
     */
    @Test
    public void testIsInNot() {
        System.out.println("isInNot");
        boolean expResult = false;
        boolean result = Almacen.isInNot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInNot method, of class Almacen.
     */
    @Test
    public void testSetInNot() {
        System.out.println("setInNot");
        boolean inNot = false;
        Almacen.setInNot(inNot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuario method, of class Almacen.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        Usuario usuarioBusc = null;
        int expResult = 0;
        int result = Almacen.buscarUsuario(usuarioBusc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
