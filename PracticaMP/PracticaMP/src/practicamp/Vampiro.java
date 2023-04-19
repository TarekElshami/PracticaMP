package practicamp;

import javax.swing.JOptionPane;

public class Vampiro extends Personaje {
    private int sangre;
    
    public Vampiro() {
    
    }
    
    @Override
    public void agregarEsbirro(Esbirro esbirro) {
        if (esbirro instanceof Humano) {
            JOptionPane.showMessageDialog(null, "Los vampiros no pueden tener esbirro humanos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            super.agregarEsbirro(esbirro);
        }
    }
}