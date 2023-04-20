package practicamp;

import javax.swing.JOptionPane;

public class Vampiro extends Personaje {
    private int sangre;
    private int edad;
    
    public Vampiro(String nombre) {
        super(nombre);
        /*disciplina = new Disciplina();
        super.setHabilidad(disciplina);*/
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