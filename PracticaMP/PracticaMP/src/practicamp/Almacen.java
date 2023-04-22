package practicamp;

import java.util.*;

public class Almacen {

    private List<Usuario> usuarios;
    private List<Desafio> desafiosSinValidar;
    private Ranking ranking;
    private List<Personaje> personajes;
    private List<Armadura> armaduras;
    private List<Arma> armas;

    public void cargarDatos() {
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