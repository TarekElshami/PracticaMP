package practicamp;

public class Ghoul extends Esbirro {

    private int dependencia;

    public Ghoul(String nombre, int salud, int dependencia) {
        super(nombre, salud);
        this.dependencia = dependencia;
    }


}