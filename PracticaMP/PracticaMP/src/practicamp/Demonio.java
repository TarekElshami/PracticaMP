package practicamp;

import java.util.List;

public class Demonio extends Esbirro {

    private List<Esbirro> esbirros;
    private String pacto;
    
    public Demonio(String nombre, int salud, List<Esbirro> esbirros, String pacto) {
        super(nombre, salud);
        this.esbirros = esbirros;
        this.pacto = pacto;
    }
}