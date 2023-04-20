package practicamp;

import java.util.List;
import javax.swing.JOptionPane;

public class Personaje {
    
    private String nombre;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private List<Arma> armas;
    private List<Arma> armaActiva;
    private List<Armadura> armaduras;
    private Armadura armaduraActiva;
    private List<Esbirro> esbirros;
    private List<Debilidad> debilidades;
    private List<Fortaleza> fortalezas;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.salud = 5;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    
    public void show() {
        
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }


    public void agregarArma(Arma arma) {
        this.armas.add(arma);
    }

    public void eliminarArma(Arma arma) {
        this.armas.remove(arma);
    }

    public void activarArma(Arma arma) {
        if (armaActiva.size() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes dos armas de una mano, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de dos manos, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de una manos, no puedes equipar uno de dos manos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el segunda arma", "Exito", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 2) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado un arma de dos manos", "Exito", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el primera arma", "Exito", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarArmadura(Armadura armadura) {
        this.armaduras.add(armadura);
    }

    public void eliminarArmadura(Armadura armadura) {
        this.armaduras.remove(armadura);
    }

    public void activarArmadura(Armadura armadura) {
        this.armaduraActiva = armadura;
    }

    public void agregarEsbirro(Esbirro esbirro) {
        this.esbirros.add(esbirro);
    }

    public void eliminarEsbirro(Esbirro esbirro) {
        this.esbirros.remove(esbirro);
    }

    public void agregarDebilidad(Debilidad debilidad) {
        this.debilidades.add(debilidad);
    }

    public void eliminarDebilidad(Debilidad debilidad) {
        this.debilidades.remove(debilidad);
    }

    public void agregarFortaleza(Fortaleza fortaleza) {
        this.fortalezas.add(fortaleza);
    }

    public void eliminarFortaleza(Fortaleza fortaleza) {
        this.fortalezas.remove(fortaleza);
    }
}