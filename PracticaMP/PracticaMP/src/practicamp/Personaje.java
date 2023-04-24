package practicamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Personaje implements Serializable, ActionListener {
    
    JButton btnPersonaje, btnArmas, btnArmadura, btnInventario, btnEsbirro;

    private String nombre;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private List<Arma> armas;
    private List<Arma> armaActiva;
    private List<Armadura> armaduras;
    private Armadura armaduraActiva;
    private List<Esbirro> esbirros;
    private Map<Modificador, Integer> debilidades;
    private Map<Modificador, Integer> fortalezas;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.salud = 5;
        this.armaActiva = new ArrayList<>();
        this.armaduraActiva = null;
        this.armas = new ArrayList<>();
        this.armaduras = new ArrayList<>();
        this.habilidad = null;
        this.esbirros = new ArrayList<>();
        this.debilidades = new HashMap<>();
        this.fortalezas = new HashMap<>();
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
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

    public boolean activarArma(Arma arma, List<Arma> armaActiva) {
        if (armaActiva.size() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes dos armas de una mano, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de dos manos, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de una manos, no puedes equipar uno de dos manos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el segunda arma", "Exito", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 2) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado un arma de dos manos", "Exito", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el primera arma", "Exito", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
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

    public void agregarDebilidad(Modificador debilidad, int valor) {
        this.debilidades.put(debilidad, valor);
    }

    public void eliminarDebilidad(Modificador debilidad) {
        this.debilidades.remove(debilidad);
    }

    public void agregarFortaleza(Modificador fortaleza, int valor) {
        this.fortalezas.put(fortaleza, valor);
    }

    public void eliminarFortaleza(Modificador fortaleza) {
        this.fortalezas.remove(fortaleza);
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public List<Armadura> getArmaduras() {
        return armaduras;
    }

    public List<Esbirro> getEsbirros() {
        return this.esbirros;
    }    
    
    public int getSalud() {
        return salud;
    }

    public int getPoder() {
        return poder;
    }

    public Map<Modificador, Integer> getDebilidades() {
        return debilidades;
    }

    public Map<Modificador, Integer> getFortalezas() {
        return fortalezas;
    }
 
}