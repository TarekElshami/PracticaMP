package practicamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Desafio implements Serializable {

    private Usuario desafiante;
    private Usuario desafiado;
    private EstadoDesafio estado;
    private Usuario ganador;
    private double oro;
    private List<Modificador> fortalezasAdmitidas;
    private List<Modificador> debilidadesAdmitidas;
    private List<String> historial; // ESTO ES UN ARRAY DE STRINGS QUE CONTIENE LO QUE HA OCURRIDO EN EL TRASCURSO DEL COMBATE (imprimir con un for cada linea de este arrayList)

    public Desafio(Usuario desafiante, Usuario desafiado, double oroApostado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.oro = oroApostado;
        this.debilidadesAdmitidas = new ArrayList<>();
        this.fortalezasAdmitidas = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.estado = EstadoDesafio.pendiente; // cuando se crea un desafio inicialmente esta pendiente
    }

    public void validarDesafio(List<Debilidad> debilidades, List<Fortaleza> fortalezas) {

    }

    public void establecerGanador(Usuario ganador) {
        this.ganador = ganador;
    }

    public Usuario getDesafiante() {
        return desafiante;
    }

    public Usuario getDesafiado() {
        return desafiado;
    }

    public double getOro() {
        return this.oro;
    }

    public void addFortaleza(Modificador mod) {
        this.fortalezasAdmitidas.add(mod);
    }

    public void addDebilidad(Modificador mod) {
        this.debilidadesAdmitidas.add(mod);
    }

    public List<Modificador> getFortalezasAdmitidas() {
        return fortalezasAdmitidas;
    }

    public List<Modificador> getDebilidadesAdmitidas() {
        return debilidadesAdmitidas;
    }

    public void setEstado(EstadoDesafio estado) {
        this.estado = estado;
    }

    public void setAHistorial(String texto) {
        this.historial.add(texto);
    }

    public List<String> getHistorial() {
        return historial;
    }
    
    
    
    
}
