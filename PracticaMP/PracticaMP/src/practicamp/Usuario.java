package practicamp;

import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario implements Serializable {

    private Rol rol;
    private String nombre;
    private String nick;
    private String contrasena;
    private String id;    
    private String personaje;
    private List<Arma> armasActivas;
    private List<Armadura> armaduraActiva;
    private String tipoPersonaje;    
    private boolean baneado;
    private List<Desafio> historial;
    private List<Notificacion> notificaciones;
    private int oro;
    private Almacen almacen;
    
    public Usuario(String nick, String contrasena) {
        this.nick = nick;
        this.contrasena = contrasena;
    }

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
        //Hace falta llamar a CreacionPersonaje y obtener los datos con los getters y asignarlos a los atributos
    }

    /**
     * 
     */
    public void elegirArmas() {
        //Hace falta verificar que tiene personaje
        // se llama a eleccionEquipo y con el getArma se intenta insertar en el personaje y sino se puede pues no se cambia en el usuario
    }

    /**
     * 
     */
    public void elegirArmaduras() {
        //Hace falta verificar que tiene personaje
        // se llama a eleccionEquipo y con el getArmadura y se cambia en el usuario.
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

    public String getNick() {
        return nick;
    }

    public String getContrasena() {
        return contrasena;
    }
}