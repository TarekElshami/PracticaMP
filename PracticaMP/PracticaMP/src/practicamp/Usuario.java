package practicamp;

import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {

    private Rol rol;
    private String nombre;
    private String nick;
    private String contraseña;
    private String id;
    private Personaje personaje;
    private boolean baneado;
    private List<Desafio> historial;
    private List<Notificacion> notificaciones;
    private int oro;
    private Almacen almacen;

    public void show() {

    }

    public void validarDesafio() {
    
    }

    public void banDesbanUsuario() {
    
    }

    public void editarPersonaje() {
    
    }

    
    public void darDeBajaCuenta() {
    
    }

    public void consultarOro() {
        JOptionPane.showMessageDialog(null, this.oro, "Cantidad de oro:", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getId() {
        return id;
    }

    

    public void ban() {
        
    }

    public void desBan() {
    
    }

    public void crearPersonaje() {
        // TODO implement here
    }

    /**
     * 
     */
    public void elegirArmas() {
        // TODO implement here
    }

    /**
     * 
     */
    public void elegirArmaduras() {
        // TODO implement here
    }

    /**
     * 
     */
    public void desafiarJugadores() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verNotificaciones() {
        // TODO implement here
    }

    /**
     * 
     */
    public void historial() {
        // TODO implement here
    }

    /**
     * @param Desafio
     */
    public void añadirDesafioAHistorial(Desafio desafio) {
        // TODO implement here
    }

    /**
     * @param Notificacion
     */
    public void añadirNotificaciones(Notificacion notificacion) {
        // TODO implement here
    }

    /**
     * 
     */
    private void showDesafios() {
        // TODO implement here
    }

    /**
     * 
     */
    private void showUsuarios() {
        // TODO implement here
    }

    /**
     * @param contrincante 
     * @param desafío
     */
    public void sendNotification(Usuario contrincante, Desafio desafío) {
        // TODO implement here
    }

    /**
     * 
     */
    public void aceptarDesafio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void rechazarDesafio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void showPersonajes() {
        // TODO implement here
    }

    public void salirDelSistema() {
    
    }
}