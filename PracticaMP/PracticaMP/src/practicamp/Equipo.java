package practicamp;

import java.io.Serializable;

public class Equipo implements Serializable{
    private String nombre;
    private int defensa;
    private int ataque;

    public Equipo(String nombre, int defensa, int ataque) {
        this.nombre = nombre;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }
    
    
    
}