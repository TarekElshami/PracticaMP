package practicamp;

public class Arma extends Equipo {
    private int manos;

    public Arma(String nombre, int defensa, int ataque, int manos) {
        super(nombre, defensa, ataque);
        this.manos = manos;
    }

    public int getManos() {
        return manos;
    }
}
