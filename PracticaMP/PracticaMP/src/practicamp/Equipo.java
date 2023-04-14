package practicamp;

public class Equipo {
    private String nombre;
    private int defensa;
    private int ataque;

    public Equipo(String nombre, int defensa, int ataque) {
        this.nombre = nombre;
        this.defensa = defensa;
        this.ataque = ataque;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAtaque(int ataque) {
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