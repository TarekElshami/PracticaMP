package practicamp;

import java.io.Serializable;

public class Modificador implements Serializable {
    private String nombre;

    public Modificador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}