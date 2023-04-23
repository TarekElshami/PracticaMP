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
    
    private String usuarioActivo;
    private List<Usuario> usuarios;
    private List<Desafio> desafiosSinValidar;
    private Ranking ranking;
    private List<Personaje> personajes;
    private List<Armadura> armaduras;
    private List<Arma> armas;
    private List<Modificador> modificadores;

    public Almacen() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.cargarDatos();
    }

    private void cargarDatos() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.cargarModificadores();
        this.cargarArmaduras();
        this.cargarArmas();
        this.cargarPersonajes();
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
     
     private void cargarPersonajes(){
        try{
            FileInputStream fis = new FileInputStream("personajes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Personaje> personajes = (List<Personaje>) ois.readObject();
            ois.close();
            fis.close();
            this.personajes = personajes;
        } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
        }  
     }

    public List<Modificador> getModificadores() {
        return modificadores;
    }

    public List<Desafio> getDesafiosSinValidar() {
        return desafiosSinValidar;
    }
    
    public void agregarDesafioAValidacion(Desafio desafio) {
        this.desafiosSinValidar.add(desafio);
    }

    public void mostrarRanking() {
    }

    public Usuario getContrincante() {
        return null;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Armadura> getArmaduras() {
        return armaduras;
    }

    public List<Arma> getArmas() {
        return armas;
    }
    
    public List<Usuario> getUsuarios(){
        return this.usuarios;
    }
    
    public void setUsuarioActivo(String Nick){
        this.usuarioActivo = Nick;
    }

    

    
}