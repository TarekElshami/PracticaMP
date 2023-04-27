package practicamp;

public class Vampiro extends Personaje {
    private int sangre;
    private int edad;
    
    public Vampiro(String nombre) {
        super(nombre, 5);
        this.edad = 711;
        this.sangre = 0;
    }
        
    public int getSangre(){
        return this.sangre;
    }

    public void setSangre(int sangre) {
        this.sangre = sangre;
    }
    
    
}