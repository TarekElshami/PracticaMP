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
    }
    
    private void cargarModificadores() throws FileNotFoundException, IOException, ClassNotFoundException {
    List<Modificador> listaModificadores = new ArrayList<>();
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("modificadores.dat"));

    try {
        while (true) {
            Modificador m = (Modificador) ois.readObject();
            listaModificadores.add(m);
        }
        
    } catch (EOFException e) {
            // Se llegó al final del archivo, no hay más objetos que leer
        }

        ois.close();
        this.modificadores = listaModificadores;
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

    public void agregarPersonaje(Personaje personaje) {

    }

    
}