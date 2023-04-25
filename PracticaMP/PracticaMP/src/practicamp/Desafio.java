package practicamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Desafio implements Serializable {    
    private Usuario desafiante;
    private Usuario desafiado;
    private EstadoDesafio estado;
    private Usuario ganador;
    private int oro;
    private List<Modificador> fortalezasAdmitidas;
    private List<Modificador> debilidadesAdmitidas;


    public Desafio(Usuario desafiante,Usuario desafiado, int oroApostado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.oro = oroApostado;
        this.debilidadesAdmitidas = new ArrayList<>();
        this.fortalezasAdmitidas = new ArrayList<>();
        this.estado = EstadoDesafio.pendiente; // cuando se crea un desafio inicialmente esta pendiente
    }

    public void validarDesafio(List<Debilidad> debilidades, List<Fortaleza> fortalezas) {
        
    }

    public void establecerGanador(Usuario ganador) {

    }
    
    public Usuario getDesafiante(){
        return desafiante;
    }
    
    public Usuario getDesafiado(){
        return desafiado;
    }
    
    public int getOro(){
        return this.oro;
    }
    
    public void addFortaleza(Modificador mod){
        this.fortalezasAdmitidas.add(mod);
    }
    
    public void addDebilidad(Modificador mod){
        this.debilidadesAdmitidas.add(mod);
    }


}