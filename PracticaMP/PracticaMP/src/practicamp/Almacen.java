package practicamp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Almacen {

    private static int usuarioActivo;
    private static List<Usuario> usuarios;
    private static List<Desafio> desafiosSinValidar;
    private Ranking ranking;
    private static List<Esbirro> esbirros;
    private static List<Personaje> personajes;
    private static List<Armadura> armaduras;
    private static List<Arma> armas;
    private static List<Modificador> modificadores;

    public Almacen() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.cargarDatos();
    }

    private void cargarDatos() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.cargarEsbirros();
        this.cargarModificadores();
        this.cargarArmaduras();
        this.cargarArmas();
        this.cargarPersonajes();
        this.inicializarDesafios(); // comprobar si existe fichero, si no se crea uno nuevo
        this.loadUsers();
    }

    private void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        File usersDB = new File("src/files/db/users.db");
        if (!usersDB.exists()) {
            updateFiles();
        } else {
            updateUsers();
        }
    }

    public void updateFiles() throws FileNotFoundException, IOException {
        FileOutputStream usersFile = new FileOutputStream("src/files/db/users.db");
        ObjectOutputStream output = new ObjectOutputStream(usersFile);

        output.writeObject(this.usuarios);
        output.close();
        if (this.usuarios == null) {
            this.usuarios = new ArrayList<>();
        }
    }

    public void updateUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream usersFile = new FileInputStream("src/files/db/users.db");
        ObjectInputStream input = new ObjectInputStream(usersFile);
        this.usuarios = (List<Usuario>) input.readObject();
        if (this.usuarios == null) {
            this.usuarios = new ArrayList<>();
        }
        input.close();
    }
    
    private void cargarEsbirros() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("esbirros.dat"));
            List<Esbirro> esbirros = (List<Esbirro>) ois.readObject();
            ois.close();
            this.esbirros = esbirros;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void cargarModificadores() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("modificadores.dat"));
            List<Modificador> modificadores = (List<Modificador>) ois.readObject();
            ois.close();
            this.modificadores = modificadores;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarArmaduras() {
        try {
            FileInputStream fis = new FileInputStream("armaduras.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Armadura> armaduras = (List<Armadura>) ois.readObject();
            ois.close();
            fis.close();
            this.armaduras = armaduras;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarArmas() {
        try {
            FileInputStream fis = new FileInputStream("armas.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Arma> armas = (List<Arma>) ois.readObject();
            ois.close();
            fis.close();
            this.armas = armas;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void actualizarFicheroDesafios() throws FileNotFoundException, IOException {
        FileOutputStream ficheroDesafios = new FileOutputStream("src/files/db/desafios.db"); // ruta
        ObjectOutputStream output = new ObjectOutputStream(ficheroDesafios); // output stream
        
        if (this.desafiosSinValidar == null) { // si no existe la estructura de la lista de desafios...
            this.desafiosSinValidar = new ArrayList<>(); // se crea una vacia ya que se usará a lo largo del programa
        }
        
        output.writeObject(this.desafiosSinValidar); // escritura del objeto a serializar
        output.close(); // cerramos stream

    }

    private void inicializarDesafios() throws IOException, FileNotFoundException, ClassNotFoundException {
        File desafiosDB = new File("src/files/db/desafios.db");
        if (!desafiosDB.exists()) { // si no existe el fichero de los desafios
            this.actualizarFicheroDesafios(); // se crea uno
        } else {
            this.cargarDesafios();  // si ya existe, se vuelca el contenido de ese fichero al atributo de la lista de desafios
        }
    }

    private void cargarDesafios() {
        try {
            FileInputStream fis = new FileInputStream("src/files/db/desafios.db");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.desafiosSinValidar = (List<Desafio>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarPersonajes() {
        try {
            FileInputStream fis = new FileInputStream("personajes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Personaje> personajes = (List<Personaje>) ois.readObject();
            ois.close();
            fis.close();
            Almacen.personajes = personajes;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Modificador> getModificadores() {
        return modificadores;
    }

    public List<Desafio> getDesafiosSinValidar() {
        return desafiosSinValidar;
    }

    public void agregarDesafioAValidacion(Desafio desafio) throws IOException {
        Almacen.desafiosSinValidar.add(desafio);
        this.actualizarFicheroDesafios();
    }

    public void mostrarRanking() {
    }

    public Usuario getContrincante(String contrincante) {
        for (Usuario usuario : Almacen.usuarios) {
            if (usuario.getNick().equals(contrincante)){
                return usuario;
            }
        }
        return null;
    }

    public static List<Personaje> getPersonajes() {
        return personajes;
    }

    public static List<Armadura> getArmaduras() {
        return armaduras;
    }

    public static List<Arma> getArmas() {
        return armas;
    }
    
    public static List<Usuario> getUsuarios() {
        return Almacen.usuarios;
    }

    public static void setUsuarioActivo(int index) {
        Almacen.usuarioActivo = index;
    }

    public void addUsuario(Usuario nuevoUsuario) {
        Almacen.usuarios.add(nuevoUsuario);
    }

    public static Usuario getUsuarioActivo() {
        return Almacen.usuarios.get(Almacen.usuarioActivo);
    }

    public static List<Esbirro> getEsbirros() {
        return esbirros;
    }
    
}
