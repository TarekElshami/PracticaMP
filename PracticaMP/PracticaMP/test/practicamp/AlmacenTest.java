/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicamp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlmacenTest {

    private Almacen a;
    private static final String FILE_PATH = "src/files/db/users.db";
    private List<Usuario> usuariosOriginales;

    public AlmacenTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        a = new Almacen();
        usuariosOriginales = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            // Crea el archivo si no existe
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        usuariosOriginales = (List<Usuario>) ois.readObject();
        ois.close();
    }

    /**
     * Test of updateFiles method, of class Almacen.
     */
    @Test
    public void testUpdateFiles() throws Exception {
        // Crea un objeto de prueba de Almacen con algunos usuarios nuevos
        Almacen almacen = new Almacen();
        almacen.setUsuario(new Usuario("usuario3", "contraseña3"));
        almacen.setUsuario(new Usuario("usuario4", "contraseña4"));

        //Obtenemos del almacén la lista de usuarios que contiene para compararla con los leídos
        List<Usuario> listaUsuarios = Almacen.getUsuarios();

        // Llama al método updateFiles() para guardar todos los usuarios
        almacen.updateFiles();

        // Lee el archivo generado y verifica que contiene todos los usuarios
        FileInputStream fis = new FileInputStream(FILE_PATH);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Usuario> usuariosLeidos = (List<Usuario>) ois.readObject();
        ois.close();

        assertNotNull(usuariosLeidos);
        assertEquals(listaUsuarios.size(), usuariosLeidos.size());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            assertEquals(listaUsuarios.get(i).getNombre(), usuariosLeidos.get(i).getNombre());
            assertEquals(listaUsuarios.get(i).getContrasena(), usuariosLeidos.get(i).getContrasena());
        }
    }

    // Restaura los usuarios originales después de la prueba
    public void tearDown() throws Exception {
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(usuariosOriginales);
        oos.close();
    }

    /**
     * Test of updateUsers method, of class Almacen.
     */
    @Test
    public void testUpdateUsers() throws Exception {
        System.out.println("getUsuarios");

        // La lista de armas que debería devolver el objeto Almacén es la que se lee desde el fichero armas.dat
        FileInputStream fis = new FileInputStream("src/files/db/users.db");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Usuario> expResult = (List<Usuario>) ois.readObject();
        ois.close();
        fis.close();

        List<Usuario> result = Almacen.getUsuarios();

        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("Fallo de coincidencias por rol", expResult.get(i).getRol(), result.get(i).getRol());
            assertEquals("Fallo de coincidencias por nombre", expResult.get(i).getNombre(), result.get(i).getNombre());
            assertEquals("Fallo de coincidencias por nick", expResult.get(i).getNick(), result.get(i).getNick());
            assertEquals("Fallo de coincidencias por id", expResult.get(i).getId(), result.get(i).getId());
            assertEquals("Fallo de coincidencias por baneado", expResult.get(i).isBaneado(), result.get(i).isBaneado());
            assertEquals("Fallo de coincidencias por historiales", expResult.get(i).getHistorial(), result.get(i).getHistorial());
            assertEquals("Fallo de coincidencias por notificaciones", expResult.get(i).getNotificaciones(), result.get(i).getNotificaciones());
            assertEquals("Fallo de coincidencias por oro", expResult.get(i).getOro(), result.get(i).getOro(), 0);
            assertEquals("Fallo de coincidencias por victorias", expResult.get(i).getVictorias(), result.get(i).getVictorias());
            assertEquals("Fallo de coincidencias por personaje", expResult.get(i).getPersonaje(), result.get(i).getPersonaje());
            assertEquals("Fallo de coincidencias por armas activas", expResult.get(i).getArmasActivas(), result.get(i).getArmasActivas());
            assertEquals("Fallo de coincidencias por armadura activa", expResult.get(i).getArmaduraActiva(), result.get(i).getArmaduraActiva());
            assertEquals("Fallo de coincidencias por tipo personaje", expResult.get(i).getTipoPersonaje(), result.get(i).getTipoPersonaje());
            assertEquals("Fallo de coincidencias por cerrada", expResult.get(i).isCerrada(), result.get(i).isCerrada());
        }
    }

    /**
     * Test of getArmas method, of class Almacen.
     */
    @Test
    public void testGetArmas() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getArmas");

        // La lista de armas que debería devolver el objeto Almacén es la que se lee desde el fichero armas.dat
        FileInputStream fis = new FileInputStream("armas.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Arma> expResult = (List<Arma>) ois.readObject();
        ois.close();
        fis.close();

        List<Arma> result = Almacen.getArmas();

        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("Fallo de coincidencias por nombre", expResult.get(i).getNombre(), result.get(i).getNombre());
            assertEquals("Fallo de coincidencias por ataque", expResult.get(i).getAtaque(), result.get(i).getAtaque());
            assertEquals("Fallo de coincidencias por defensa", expResult.get(i).getDefensa(), result.get(i).getDefensa());
            assertEquals("Fallo de coincidencias por manos", expResult.get(i).getManos(), result.get(i).getManos());

        }
    }

    /**
     * Test of getUsuarios method, of class Almacen.
     */
    @Test
    public void testGetUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getUsuarios");

        // La lista de armas que debería devolver el objeto Almacén es la que se lee desde el fichero armas.dat
        FileInputStream fis = new FileInputStream("src/files/db/users.db");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Usuario> expResult = (List<Usuario>) ois.readObject();
        ois.close();
        fis.close();

        List<Usuario> result = Almacen.getUsuarios();

        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("Fallo de coincidencias por rol", expResult.get(i).getRol(), result.get(i).getRol());
            assertEquals("Fallo de coincidencias por nombre", expResult.get(i).getNombre(), result.get(i).getNombre());
            assertEquals("Fallo de coincidencias por nick", expResult.get(i).getNick(), result.get(i).getNick());
            assertEquals("Fallo de coincidencias por id", expResult.get(i).getId(), result.get(i).getId());
            assertEquals("Fallo de coincidencias por baneado", expResult.get(i).isBaneado(), result.get(i).isBaneado());
            assertEquals("Fallo de coincidencias por historiales", expResult.get(i).getHistorial(), result.get(i).getHistorial());
            assertEquals("Fallo de coincidencias por notificaciones", expResult.get(i).getNotificaciones(), result.get(i).getNotificaciones());
            assertEquals("Fallo de coincidencias por oro", expResult.get(i).getOro(), result.get(i).getOro(), 0);
            assertEquals("Fallo de coincidencias por victorias", expResult.get(i).getVictorias(), result.get(i).getVictorias());
            assertEquals("Fallo de coincidencias por personaje", expResult.get(i).getPersonaje(), result.get(i).getPersonaje());
            assertEquals("Fallo de coincidencias por armas activas", expResult.get(i).getArmasActivas(), result.get(i).getArmasActivas());
            assertEquals("Fallo de coincidencias por armadura activa", expResult.get(i).getArmaduraActiva(), result.get(i).getArmaduraActiva());
            assertEquals("Fallo de coincidencias por tipo personaje", expResult.get(i).getTipoPersonaje(), result.get(i).getTipoPersonaje());
            assertEquals("Fallo de coincidencias por cerrada", expResult.get(i).isCerrada(), result.get(i).isCerrada());

        }
    }

    /**
     * Test of getPersonajes method, of class Almacen.
     */
    @Test
    public void testGetPersonajes() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getPersonajes");

        // La lista de armas que debería devolver el objeto Almacén es la que se lee desde el fichero armas.dat
        FileInputStream fis = new FileInputStream("personajes.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Personaje> expResult = (List<Personaje>) ois.readObject();
        ois.close();
        fis.close();

        List<Personaje> result = Almacen.getPersonajes();

        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("Fallo de coincidencias por nombre", expResult.get(i).getNombre(), result.get(i).getNombre());
            assertEquals("Fallo de coincidencias por salud", expResult.get(i).getSalud(), result.get(i).getSalud());
            assertEquals("Fallo de coincidencias por poder", expResult.get(i).getPoder(), result.get(i).getPoder());
            assertEquals("No coinciden las habilidades", expResult.get(i).getHabilidad().getAtaque(), result.get(i).getHabilidad().getAtaque());
            assertEquals("No coinciden las habilidades", expResult.get(i).getHabilidad().getDefensa(), result.get(i).getHabilidad().getDefensa());
            assertEquals("No coinciden las habilidades", expResult.get(i).getHabilidad().getNombre(), result.get(i).getHabilidad().getNombre());
            for (int j = 0; j < expResult.get(i).getArmas().size(); j++) {
                assertEquals("No coinciden las armas", expResult.get(i).getArmas().get(j).getNombre(), result.get(i).getArmas().get(j).getNombre());
                assertEquals("No coinciden las armas", expResult.get(i).getArmas().get(j).getDefensa(), result.get(i).getArmas().get(j).getDefensa());
                assertEquals("No coinciden las armas", expResult.get(i).getArmas().get(j).getAtaque(), result.get(i).getArmas().get(j).getAtaque());
                assertEquals("No coinciden las armas", expResult.get(i).getArmas().get(j).getManos(), result.get(i).getArmas().get(j).getManos());
            }
            assertEquals("Fallo de coincidencias por arma activa", expResult.get(i).getArmaActiva(), result.get(i).getArmaActiva());
            for (int j = 0; j < expResult.get(i).getArmaduras().size(); j++) {
                assertEquals("No coinciden las armaduras", expResult.get(i).getArmaduras().get(j).getNombre(), result.get(i).getArmaduras().get(j).getNombre());
                assertEquals("No coinciden las armaduras", expResult.get(i).getArmaduras().get(j).getDefensa(), result.get(i).getArmaduras().get(j).getDefensa());
                assertEquals("No coinciden las armaduras", expResult.get(i).getArmaduras().get(j).getAtaque(), result.get(i).getArmaduras().get(j).getAtaque());
            }
            assertEquals("Fallo de coincidencias por armadura activa", expResult.get(i).getArmaduraActiva(), result.get(i).getArmaduraActiva());
            for (int j = 0; j < expResult.get(i).getEsbirros().size(); j++) {
                assertEquals("No coinciden los esbirros", expResult.get(i).getEsbirros().get(j).getNombre(), result.get(i).getEsbirros().get(j).getNombre());
                assertEquals("No coinciden los esbirros", expResult.get(i).getEsbirros().get(j).getSalud(), result.get(i).getEsbirros().get(j).getSalud());
                if (expResult.get(i).getEsbirros().get(j) instanceof Demonio demonio) {
                    assertEquals("No coinciden los esbirros", demonio.getPacto(), ((Demonio) result.get(i).getEsbirros().get(j)).getPacto());
                } else if (expResult.get(i).getEsbirros().get(j) instanceof Ghoul ghoul) {
                    assertEquals("No coinciden los esbirros", ghoul.getDependencia(), ((Ghoul) result.get(i).getEsbirros().get(j)).getDependencia());
                } else if (expResult.get(i).getEsbirros().get(j) instanceof Humano humano) {
                    assertEquals("No coinciden los esbirros", humano.getLealdad(), ((Humano) result.get(i).getEsbirros().get(j)).getLealdad());
                }
                for (Map.Entry<String, Integer> debilidades : expResult.get(i).getDebilidades().entrySet()) {
                    String key = debilidades.getKey();
                    Integer val = debilidades.getValue();

                    assertEquals("No coinciden las debilidades", result.get(i).getDebilidades().get(key), val);

                }

                for (Map.Entry<String, Integer> fortalezas : expResult.get(i).getFortalezas().entrySet()) {
                    String key = fortalezas.getKey();
                    Integer val = fortalezas.getValue();

                    assertEquals("No coinciden las fortalezas", result.get(i).getFortalezas().get(key), val);

                }
            }
        }
    }

    /**
     * Test of getArmaduras method, of class Almacen.
     */
    @Test
    public void testGetArmaduras() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getArmaduras");

        // La lista de armas que debería devolver el objeto Almacén es la que se lee desde el fichero armas.dat
        FileInputStream fis = new FileInputStream("armaduras.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Armadura> expResult = (List<Armadura>) ois.readObject();
        ois.close();
        fis.close();

        List<Armadura> result = Almacen.getArmaduras();

        for (int i = 0; i < expResult.size(); i++) {
            assertEquals("Fallo de coincidencias por nombre", expResult.get(i).getNombre(), result.get(i).getNombre());
            assertEquals("Fallo de coincidencias por ataque", expResult.get(i).getAtaque(), result.get(i).getAtaque());
            assertEquals("Fallo de coincidencias por defensa", expResult.get(i).getDefensa(), result.get(i).getDefensa());

        }
    }

    /**
     * Test of getContrincante method, of class Almacen.
     */
    @Test
    public void testGetContrincante() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("getContrincante");

        Almacen instance = a;

        // Usuario existente
        Usuario test = new Usuario("test", "test1");
        instance.addUsuario(test);

        String contrincante = "test";

        Usuario expResult = test;
        Usuario result = instance.getContrincante(contrincante);
        assertEquals("No se devuelve correctamente el contrincante", expResult, result);

        // Usuario no existente (debería devolver null)
        String contrincante2 = "nonExistant";

        Usuario expResult2 = null;
        Usuario result2 = instance.getContrincante(contrincante2);
        assertEquals("No se devuelve null", expResult2, result2);
    }

    /**
     * Test of getIndexUsuarioActivo method, of class Almacen.
     */
    @Test
    public void testGetIndexUsuarioActivo() {
        System.out.println("getIndexUsuarioActivo");

        // Si no hay usuario activo
        Almacen.setUsuarioActivo(0);
        int expResult = 0;
        int result = Almacen.getIndexUsuarioActivo();
        assertEquals("No se devuelve 0 si no hay usuario activo", expResult, result);

        // Si hay usuario activo
        Usuario testActivo = new Usuario("testAct", "test12");
        a.addUsuario(testActivo);
        int idx = Almacen.buscarUsuario(testActivo);
        Almacen.setUsuarioActivo(idx);
        int result1 = Almacen.getIndexUsuarioActivo();
        assertEquals("No se devuelve correctamente el índice del usuario activo", idx, result1);

    }

    /**
     * Test of isInNot method, of class Almacen.
     */
    @Test
    public void testIsInNot() {
        boolean inNot = false;
        assertEquals(Almacen.isInNot(), inNot);
    }

    /**
     * Test of setInNot method, of class Almacen.
     */
    @Test
    public void testSetInNot() {
        Almacen.setInNot(true);
        boolean inNot = true;
        assertEquals(Almacen.isInNot(), inNot);
        Almacen.setInNot(false);
    }

    /**
     * Test of cargarPersonajes method, of class Almacen.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testCargarPersonajes() throws IOException, FileNotFoundException, ClassNotFoundException {
        System.out.println("cargarPersonajes");

        FileInputStream fis = new FileInputStream("personajes.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Personaje> personajes = (List<Personaje>) ois.readObject();
        ois.close();
        fis.close();

        Almacen instance = new Almacen();
        instance.cargarPersonajes();
        List<Personaje> attr = Almacen.getPersonajes();

        for (int i = 0; i < attr.size(); i++) {
            assertEquals("No coinciden los nombres", attr.get(i).getNombre(), personajes.get(i).getNombre());
            assertEquals("No coinciden las armas activas", attr.get(i).getArmaActiva(), personajes.get(i).getArmaActiva());
            assertEquals("No coinciden las habilidades", attr.get(i).getHabilidad().getAtaque(), personajes.get(i).getHabilidad().getAtaque());
            assertEquals("No coinciden las habilidades", attr.get(i).getHabilidad().getDefensa(), personajes.get(i).getHabilidad().getDefensa());
            assertEquals("No coinciden las habilidades", attr.get(i).getHabilidad().getNombre(), personajes.get(i).getHabilidad().getNombre());
            assertEquals("No coinciden las armaduras activas", attr.get(i).getArmaduraActiva(), personajes.get(i).getArmaduraActiva());
            assertEquals("No coinciden los poderes", attr.get(i).getPoder(), personajes.get(i).getPoder());
            assertEquals("No coinciden los puntos de salud", attr.get(i).getSalud(), personajes.get(i).getSalud());

            for (int j = 0; j < attr.get(i).getArmaduras().size(); j++) {
                assertEquals("No coinciden las armaduras", attr.get(i).getArmaduras().get(j).getNombre(), personajes.get(i).getArmaduras().get(j).getNombre());
                assertEquals("No coinciden las armaduras", attr.get(i).getArmaduras().get(j).getDefensa(), personajes.get(i).getArmaduras().get(j).getDefensa());
                assertEquals("No coinciden las armaduras", attr.get(i).getArmaduras().get(j).getAtaque(), personajes.get(i).getArmaduras().get(j).getAtaque());

            }

            for (int j = 0; j < attr.get(i).getArmas().size(); j++) {
                assertEquals("No coinciden las armas", attr.get(i).getArmas().get(j).getNombre(), personajes.get(i).getArmas().get(j).getNombre());
                assertEquals("No coinciden las armas", attr.get(i).getArmas().get(j).getDefensa(), personajes.get(i).getArmas().get(j).getDefensa());
                assertEquals("No coinciden las armas", attr.get(i).getArmas().get(j).getAtaque(), personajes.get(i).getArmas().get(j).getAtaque());
                assertEquals("No coinciden las armas", attr.get(i).getArmas().get(j).getManos(), personajes.get(i).getArmas().get(j).getManos());

            }

            for (Map.Entry<String, Integer> fortalezas : attr.get(i).getFortalezas().entrySet()) {
                String key = fortalezas.getKey();
                Integer val = fortalezas.getValue();

                assertEquals("No coinciden las fortalezas", personajes.get(i).getFortalezas().get(key), val);

            }

            for (Map.Entry<String, Integer> debilidades : attr.get(i).getDebilidades().entrySet()) {
                String key = debilidades.getKey();
                Integer val = debilidades.getValue();

                assertEquals("No coinciden las debilidades", personajes.get(i).getDebilidades().get(key), val);

            }

            for (int j = 0; j < attr.get(i).getEsbirros().size(); j++) {
                assertEquals("No coinciden los esbirros", attr.get(i).getEsbirros().get(j).getNombre(), personajes.get(i).getEsbirros().get(j).getNombre());
                assertEquals("No coinciden los esbirros", attr.get(i).getEsbirros().get(j).getSalud(), personajes.get(i).getEsbirros().get(j).getSalud());
                if (attr.get(i).getEsbirros().get(j) instanceof Demonio demonio) {
                    assertEquals("No coinciden los esbirros", demonio.getPacto(), ((Demonio) personajes.get(i).getEsbirros().get(j)).getPacto());
                } else if (attr.get(i).getEsbirros().get(j) instanceof Ghoul ghoul) {
                    assertEquals("No coinciden los esbirros", ghoul.getDependencia(), ((Ghoul) personajes.get(i).getEsbirros().get(j)).getDependencia());
                } else if (attr.get(i).getEsbirros().get(j) instanceof Humano humano) {
                    assertEquals("No coinciden los esbirros", humano.getLealdad(), ((Humano) personajes.get(i).getEsbirros().get(j)).getLealdad());
                }
            }
        }
    }

    /**
     * Test of getEsbirros method, of class Almacen.
     */
    @Test
    public void testGetEsbirros() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getEsbirros");

        FileInputStream fis = new FileInputStream("esbirros.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Esbirro> personajes = (List<Esbirro>) ois.readObject();
        ois.close();
        fis.close();

        List<Esbirro> attr = Almacen.getEsbirros();

        for (int j = 0; j < attr.size(); j++) {
            assertEquals("No coinciden los esbirros", attr.get(j).getNombre(), personajes.get(j).getNombre());
            assertEquals("No coinciden los esbirros", attr.get(j).getSalud(), personajes.get(j).getSalud());
            if (attr.get(j) instanceof Demonio demonio) {
                assertEquals("No coinciden los esbirros", demonio.getPacto(), ((Demonio) personajes.get(j)).getPacto());
            } else if (attr.get(j) instanceof Ghoul ghoul) {
                assertEquals("No coinciden los esbirros", ghoul.getDependencia(), ((Ghoul) personajes.get(j)).getDependencia());
            } else if (attr.get(j) instanceof Humano humano) {
                assertEquals("No coinciden los esbirros", humano.getLealdad(), ((Humano) personajes.get(j)).getLealdad());
            }
        }
    }

    /**
     * Test of getModificadores method, of class Almacen.
     */
    @Test
    public void testGetModificadores() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("getModificadores");
        FileInputStream fis = new FileInputStream("modificadores.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Modificador> modif = (List<Modificador>) ois.readObject();
        ois.close();
        fis.close();

        List<Modificador> attr = Almacen.getModificadores();

        for (int i = 0; i < attr.size(); i++) {
            assertEquals("No coinciden los nombres de los modificadores", attr.get(i).getNombre(), modif.get(i).getNombre());
        }
    }

    /**
     * Test of actualizarFicheroDesafios method, of class Almacen.
     */
    @Test
    public void testActualizarFicheroDesafios() throws FileNotFoundException, IOException, ClassNotFoundException {
        Almacen almacen = new Almacen(); // Asumiendo que existe una clase AlmacenDesafios
        Usuario desafiante1 = new Usuario("desafiante1", "contrasena1");
        Usuario desafiado1 = new Usuario("desafiado1", "contrasena3");
        double oroApostado1 = 50.0;

        // Añadir desafíos sin validar al almacen
        almacen.agregarDesafioAValidacion(new Desafio(desafiante1, desafiado1, oroApostado1));

        // Comprobar que el archivo se ha actualizado correctamente
        List<Desafio> desafiosLeidos = almacen.getDesafiosSinValidar();

        List<Desafio> listaDesafios = new ArrayList<>();
        listaDesafios.add(new Desafio(desafiante1, desafiado1, oroApostado1));

        //assertEquals("El tamaño de la lista de desafíos leídos es incorrecto", listaDesafios.size(), desafiosLeidos.size());
        System.out.println();
        assertEquals("Fallo de coincidencias en desafiante por rol", desafiante1.getRol(), desafiosLeidos.get(0).getDesafiante().getRol());
        assertEquals("Fallo de coincidencias en desafiante por nombre", desafiante1.getNombre(), desafiosLeidos.get(0).getDesafiante().getNombre());
        assertEquals("Fallo de coincidencias en desafiante por nick", desafiante1.getNick(), desafiosLeidos.get(0).getDesafiante().getNick());
        assertEquals("Fallo de coincidencias en desafiante por id", desafiante1.getId(), desafiosLeidos.get(0).getDesafiante().getId());
        assertEquals("Fallo de coincidencias en desafiante por baneado", desafiante1.isBaneado(), desafiosLeidos.get(0).getDesafiante().isBaneado());
        assertEquals("Fallo de coincidencias en desafiante por historiales", desafiante1.getHistorial(), desafiosLeidos.get(0).getDesafiante().getHistorial());
        assertEquals("Fallo de coincidencias en desafiante por notificaciones", desafiante1.getNotificaciones(), desafiosLeidos.get(0).getDesafiante().getNotificaciones());
        assertEquals("Fallo de coincidencias en desafiante por oro", desafiante1.getOro(), desafiosLeidos.get(0).getDesafiante().getOro(), 0);
        assertEquals("Fallo de coincidencias en desafiante por victorias", desafiante1.getVictorias(), desafiosLeidos.get(0).getDesafiante().getVictorias());
        assertEquals("Fallo de coincidencias en desafiante por personaje", desafiante1.getPersonaje(), desafiosLeidos.get(0).getDesafiante().getPersonaje());
        assertEquals("Fallo de coincidencias en desafiante por armas activas", desafiante1.getArmasActivas(), desafiosLeidos.get(0).getDesafiante().getArmasActivas());
        assertEquals("Fallo de coincidencias en desafiante por armadura activa", desafiante1.getArmaduraActiva(), desafiosLeidos.get(0).getDesafiante().getArmaduraActiva());
        assertEquals("Fallo de coincidencias en desafiante por tipo personaje", desafiante1.getTipoPersonaje(), desafiosLeidos.get(0).getDesafiante().getTipoPersonaje());
        assertEquals("Fallo de coincidencias en desafiante por cerrada", desafiante1.isCerrada(), desafiosLeidos.get(0).getDesafiante().isCerrada());
        assertEquals("Fallo de coincidencias en desafiado por rol", desafiado1.getRol(), desafiosLeidos.get(0).getDesafiado().getRol());
        assertEquals("Fallo de coincidencias en desafiado por nombre", desafiado1.getNombre(), desafiosLeidos.get(0).getDesafiado().getNombre());
        assertEquals("Fallo de coincidencias en desafiado por nick", desafiado1.getNick(), desafiosLeidos.get(0).getDesafiado().getNick());
        assertEquals("Fallo de coincidencias en desafiado por id", desafiado1.getId(), desafiosLeidos.get(0).getDesafiado().getId());
        assertEquals("Fallo de coincidencias en desafiado por baneado", desafiado1.isBaneado(), desafiosLeidos.get(0).getDesafiado().isBaneado());
        assertEquals("Fallo de coincidencias en desafiado por historiales", desafiado1.getHistorial(), desafiosLeidos.get(0).getDesafiado().getHistorial());
        assertEquals("Fallo de coincidencias en desafiado por notificaciones", desafiado1.getNotificaciones(), desafiosLeidos.get(0).getDesafiado().getNotificaciones());
        assertEquals("Fallo de coincidencias en desafiado por oro", desafiado1.getOro(), desafiosLeidos.get(0).getDesafiado().getOro(), 0);
        assertEquals("Fallo de coincidencias en desafiado por victorias", desafiado1.getVictorias(), desafiosLeidos.get(0).getDesafiado().getVictorias());
        assertEquals("Fallo de coincidencias en desafiado por personaje", desafiado1.getPersonaje(), desafiosLeidos.get(0).getDesafiado().getPersonaje());
        assertEquals("Fallo de coincidencias en desafiado por armas activas", desafiado1.getArmasActivas(), desafiosLeidos.get(0).getDesafiado().getArmasActivas());
        assertEquals("Fallo de coincidencias en desafiado por armadura activa", desafiado1.getArmaduraActiva(), desafiosLeidos.get(0).getDesafiado().getArmaduraActiva());
        assertEquals("Fallo de coincidencias en desafiado por tipo personaje", desafiado1.getTipoPersonaje(), desafiosLeidos.get(0).getDesafiado().getTipoPersonaje());
        assertEquals("Fallo de coincidencias en desafiado por cerrada", desafiado1.isCerrada(), desafiosLeidos.get(0).getDesafiado().isCerrada());
        assertEquals("El oro apostado no coincide", oroApostado1, desafiosLeidos.get(0).getOro(), 0.001);
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
        assertEquals(expResult.get(0).getDesafiado().getNick(), result.get(aux - 2).getDesafiado().getNick());
        assertEquals(expResult.get(1).getDesafiado().getNick(), result.get(aux - 1).getDesafiado().getNick());
        assertEquals(expResult.get(0).getDesafiante().getNick(), result.get(aux - 2).getDesafiante().getNick());
        assertEquals(expResult.get(0).getOro(), result.get(aux - 2).getOro(), 0);
        assertEquals(expResult.get(1).getDesafiante().getNick(), result.get(aux - 1).getDesafiante().getNick());
        assertEquals(expResult.get(1).getOro(), result.get(aux - 1).getOro(), 0);
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
        assertEquals("El nick del usuario 1 no coincide", usu.getNick(), instance.getUsuarios().get(aux - 2).getNick());
        assertEquals("El nick del usuario 2 no coincide", usu2.getNick(), instance.getUsuarios().get(aux - 1).getNick());
        assertEquals("La contraseña del usuario 1 no coincide", usu.getContrasena(), instance.getUsuarios().get(aux - 2).getContrasena());
        assertEquals("La contraseña del usuario 2 no coincide", usu2.getContrasena(), instance.getUsuarios().get(aux - 1).getContrasena());
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
        Almacen.setUsuarioActivo(aux - 1);
        assertEquals("El usuarioActivo no coincide", usuario.getNick(), instance.getUsuarioActivo().getNick());
        assertEquals("El usuarioActivo no coincide", usuario.getContrasena(), instance.getUsuarioActivo().getContrasena());
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
        assertNotEquals("hay un problema", usuario.getNick(), instance.getUsuarios().get(aux - 1).getNick());
        assertNotEquals("hay un problema", usuario.getContrasena(), instance.getUsuarios().get(aux - 1).getContrasena());

        // en caso de que este usuario no esté en almacen, este se añade al final de array 
        int longitud = 6;
        StringBuilder sb = new StringBuilder(longitud);
        String nick = sb.toString();
        Usuario usuario3 = new Usuario(nick, nick);
        instance.setUsuario(usuario3);

        System.out.println(aux);
        int aux2 = instance.getUsuarios().size();
        assertEquals("El usuario no coincide", usuario3.getNick(), instance.getUsuarios().get(aux2 - 1).getNick());
        assertEquals("El usuario no coincide", usuario3.getContrasena(), instance.getUsuarios().get(aux2 - 1).getContrasena());
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
        Almacen.setUsuarioActivo(aux - 1);
        assertEquals("El usuarioActivo no coincide", usuario.getNick(), instance.getUsuarioActivo().getNick());
        assertEquals("El usuarioActivo no coincide", usuario.getContrasena(), instance.getUsuarioActivo().getContrasena());
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

        assertEquals(expResult.get(0).getDesafiado().getNick(), result.get(aux - 2).getDesafiado().getNick());
        assertEquals(expResult.get(1).getDesafiado().getNick(), result.get(aux - 1).getDesafiado().getNick());
        assertEquals(expResult.get(0).getDesafiante().getNick(), result.get(aux - 2).getDesafiante().getNick());
        assertEquals(expResult.get(0).getOro(), result.get(aux - 2).getOro(), 0);
        assertEquals(expResult.get(1).getDesafiante().getNick(), result.get(aux - 1).getDesafiante().getNick());
        assertEquals(expResult.get(1).getOro(), result.get(aux - 1).getOro(), 0);

    }

    /**
     * Test of buscarUsuario method, of class Almacen.
     */
    @Test
    public void testBuscarUsuario() { // el método que se prueba aquí devuelve la posición en el array de Usuarios en la que se almacena 
        System.out.println("buscarUsuario");
        // Probaremos a buscar un usuario existente y a un usuario que no existe.

        // Usuario EXISTENTE
        Usuario usuarioBusc = new Usuario("Wally", "findWally");
        a.addUsuario(usuarioBusc);
        int index = Almacen.buscarUsuario(usuarioBusc);
        Usuario result = Almacen.getUsuarios().get(index);
        assertEquals("No se devuelve correctamente el índice", usuarioBusc, result);

        // Usuario NO EXISTENTE: debería devolver -1
        Usuario usuarioBusc2 = new Usuario("Wally2", "findWally");
        int index2 = Almacen.buscarUsuario(usuarioBusc2);
        int result2 = -1;
        assertEquals("Problemas con la búsqueda de usuarios no existentes", index2, result2);

    }

}
