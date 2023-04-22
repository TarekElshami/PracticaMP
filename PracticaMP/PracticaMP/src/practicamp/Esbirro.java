package practicamp;

import java.io.Serializable;

public class Esbirro implements Serializable{
    private String nombre;
    private int salud;

    public Esbirro(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

}