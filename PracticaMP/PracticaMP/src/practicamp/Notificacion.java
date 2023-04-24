package practicamp;

public class Notificacion {

    private Desafio desafio;

    
    public void Notificacion(Desafio desafio) {
        this.desafio = desafio;
    }

    public void notificar() {
    
    }

    public Desafio obtenerDesafio() {
        // TODO implement here
        return null;
    }
    
    public String getRival(){
        return this.desafio.getDesafiante();
    }
    
    public int getOroApostado(){
        int oro = this.desafio.getOro();
        return oro;
    }
    

}