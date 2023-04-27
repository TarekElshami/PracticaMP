package practicamp;

public class Cazador extends Personaje {

    private int voluntad;
    
    public Cazador(String nombre) {
        super(nombre, 3);
        this.voluntad = 3;
    }

    public int getVoluntad() {
        return voluntad;
    }

    public void setVoluntad(int voluntad) {
        this.voluntad = voluntad;
    }
    

}