package practicamp;

import java.util.ArrayList;
import java.util.List;

public class Demonio extends Esbirro {

    private List<Esbirro> esbirros;
    private String pacto;
    
    public Demonio(String nombre, int salud, List<Esbirro> esbirros, String pacto) {
        super(nombre, salud);
        if (esbirros == null){
            this.esbirros = new ArrayList<>();
        } else {
            this.esbirros = esbirros;
        }
        this.pacto = pacto;
    }

    public List<Esbirro> getEsbirros() {
        return esbirros;
    }

    public String getPacto() {
        return pacto;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
    
    public void addEsbirro(Esbirro esbirro){
        this.esbirros.add(esbirro);
    }
    
    
    
}