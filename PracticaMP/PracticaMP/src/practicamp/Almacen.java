package practicamp;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Almacen {

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
        return null;
    }

    public List<Armadura> getArmaduras() {
        return armaduras;
    }

    public void agregarPersonaje(Personaje personaje) {

    }

    

    
}