package practicamp;

public class Don extends Habilidad {
    private int costeRabia;
    

    public Don(String nombre, int ataque, int defensa, int costeRabia) {
        super(nombre, ataque, defensa);
        this.costeRabia = costeRabia;
    }
    
}