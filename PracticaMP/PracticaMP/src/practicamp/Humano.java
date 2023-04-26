package practicamp;

public class Humano extends Esbirro {
    private Lealtad lealtad;

    public Humano(String nombre, int salud, Lealtad lealtad) {
        super(nombre, salud);
        this.lealtad = lealtad;
    }

    public Lealtad getLealdad() {
        return lealtad;
    }

    public void setLealdad(Lealtad lealtad) {
        this.lealtad = lealtad;
    }
    
    
}