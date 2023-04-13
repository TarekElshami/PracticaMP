package practicamp;


import java.util.*;

/**
 * 
 */
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
        // TODO implement here
    }

    /**
     * 
     */
    public void validarDesafio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void banDesbanUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void editarPersonaje() {
        // TODO implement here
    }

    /**
     * 
     */
    public void salirDelSistema() {
        // TODO implement here
    }

    /**
     * 
     */
    public void darDeBajaCuenta() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int consultarOro() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getID() {
        // TODO implement here
        return "";
    }

    /**
     * 
     */
    public void ban() {
        // TODO implement here
    }

    /**
     * 
     */
    public void desBan() {
        // TODO implement here
    }

    /**
     * 
     */
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

}