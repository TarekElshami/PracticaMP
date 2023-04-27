package practicamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Personaje implements Serializable {
    

    private String nombre;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private List<Arma> armas;
    private List<Arma> armaActiva;
    private List<Armadura> armaduras;
    private Armadura armaduraActiva;
    private List<Esbirro> esbirros;
    private Map<String, Integer> debilidades;
    private Map<String, Integer> fortalezas;

    public Personaje(String nombre, int poder) {
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
        this.poder = poder;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
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

    public void agregarDebilidad(String debilidad, int valor) {
        this.debilidades.put(debilidad, valor);
    }

    public void eliminarDebilidad(String debilidad) {
        this.debilidades.remove(debilidad);
    }

    public void agregarFortaleza(String fortaleza, int valor) {
        this.fortalezas.put(fortaleza, valor);
    }

    public void eliminarFortaleza(String fortaleza) {
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

    public Map<String, Integer> getDebilidades() {
        return debilidades;
    }

    public Map<String, Integer> getFortalezas() {
        return fortalezas;
    }    
    
    public int getValorFortalezaODebilidad(String nombre, boolean fortaleza){
        if (fortaleza){
            return this.fortalezas.get(nombre);
        }
        else{
            return this.debilidades.get(nombre);
        }
    }

    public List<Arma> getArmaActiva() {
        return armaActiva;
    }

    public Armadura getArmaduraActiva() {
        return armaduraActiva;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public void setArmaActiva(List<Arma> armaActiva) {
        this.armaActiva = armaActiva;
    }

    public void setArmaduras(List<Armadura> armaduras) {
        this.armaduras = armaduras;
    }

    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }
        
}