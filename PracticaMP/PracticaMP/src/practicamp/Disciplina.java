package practicamp;

public class Disciplina extends Habilidad {
    private int costeSangre;
    
    public Disciplina(String nombre, int ataque, int defensa, int costeSangre){
        super(nombre, ataque, defensa);
        this.costeSangre = costeSangre;
    }

    public int getCosteSangre() {
        return costeSangre;
    }
    
    

}