package practicamp;

public class Humano extends Esbirro {
    private Lealdad lealdad;

    public Humano(String nombre, int salud, Lealdad lealdad) {
        super(nombre, salud);
        this.lealdad = lealdad;
    }

    public Lealdad getLealdad() {
        return lealdad;
    }
    
    
}