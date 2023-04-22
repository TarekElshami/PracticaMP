package practicamp;

import java.io.Serializable;

public class Habilidad implements Serializable{

    private String nombre;
    private int ataque;
    private int defensa;

    public Habilidad(String nombre, int ataque, int defensa) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
    }
}