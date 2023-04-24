package practicamp;

import java.util.List;

public class Desafio {    
    private String desafiante;
    private String desafiado;
    private EstadoDesafio estado;
    private Usuario ganador;
    private int oro;
    private List<Fortaleza> fortalezasAdmitidas;
    private List<Debilidad> debilidadesAdmitidas;


    public Desafio(String desafiante,String desafiado, int oroApostado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.oro = oroApostado;
    }

    public void validarDesafio(List<Debilidad> debilidades, List<Fortaleza> fortalezas) {
        
    }

    public void establecerGanador(Usuario ganador) {

    }
    
    public String getDesafiante(){
        return desafiante;
    }
    
    public String getDesafiado(){
        return desafiado;
    }



}