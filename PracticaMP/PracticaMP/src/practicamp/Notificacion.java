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
    public void notificar() {
    
    }

    public Desafio obtenerDesafio() {
        // TODO implement here
        return null;
    }
    
    
    public int getOroApostado(){
        int oro = this.desafio.getOro();
        return oro;
    }
    

}