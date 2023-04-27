package practicamp;

public class Licantropo extends Personaje {

    private int rabia;

    public Licantropo(String nombre) {
        super(nombre, 4);
        this.rabia = 0;
    }

    public int getRabia() {
        return rabia;
    }

    public void setRabia(int rabia) {
        this.rabia = rabia;
    }
        
}