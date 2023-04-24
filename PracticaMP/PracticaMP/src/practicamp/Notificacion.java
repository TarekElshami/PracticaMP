package practicamp;

public class Notificacion {

    private Desafio desafio;
    private Usuario rival;

    
    public void Notificacion(Desafio desafio, Usuario rival) {
        this.desafio = desafio;
        this.rival = rival;
    }

    public void notificar() {
    
    }

    public Desafio obtenerDesafio() {
        // TODO implement here
        return null;
    }
    
    public Usuario getRival(){
        return this.rival;
    }
    
    public int getOroApostado(){
        int oro = this.desafio.getOro();
        return oro;
    }
    

}