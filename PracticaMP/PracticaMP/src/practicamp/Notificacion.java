package practicamp;

import java.io.Serializable;

public class Notificacion implements Serializable {

    private Desafio desafio;

    
    public Notificacion(Desafio desafio) {
        this.desafio = desafio;
    }
    
    public String getRival(){
        return this.desafio.getDesafiante().getNick();
    }
    
    public Desafio obtenerDesafio() {
        return desafio;
    }
    
    
    public double getOroApostado(){
        return this.desafio.getOro();
    }
    

}