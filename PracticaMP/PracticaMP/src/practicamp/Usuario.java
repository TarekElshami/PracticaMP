package practicamp;

import java.io.Serializable;
import java.util.ArrayList;
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
    private int victorias;
    private Almacen almacen;

    public Usuario(String nick, String contrasena) {
        this.nick = nick;
        this.contrasena = contrasena;
        this.personaje = null;
        this.tipoPersonaje = null;
        this.armasActivas = new ArrayList<>();
        this.armaduraActiva = null;
        this.baneado = false;
        this.victorias = 0;
        this.oro = 500;
        this.historial = new ArrayList<>();
        this.notificaciones =  new ArrayList<>();
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

    public void elegirArmas() {
        //Hace falta verificar que tiene personaje
        // se llama a eleccionEquipo y con el getArma se intenta insertar en el personaje y sino se puede pues no se cambia en el usuario
    }

    public void elegirArmaduras() {
        //Hace falta verificar que tiene personaje
        // se llama a eleccionEquipo y con el getArmadura y se cambia en el usuario.
    }

    public void desafiarJugadores() {

    }

    public void verNotificaciones() {

    /**
     *
     */
    }
    /**
     *
     * @return
     */
    public List<Notificacion> getNotificaciones() {
        return this.notificaciones;
    }

    public void historial() {

    }

    public void añadirDesafioAHistorial(Desafio desafio) {

    }

    public void añadirNotificaciones(Notificacion notificacion) {
        
    }

    private void showDesafios() {

    }

    private void showUsuarios() {

    }


    public void sendNotification(Usuario contrincante, Desafio desafío) {

    }

    public void aceptarDesafio() {
        
    }

    public void rechazarDesafio() {

    }

    public void showPersonajes() {

    }

    public void salirDelSistema() {

    }

    public String getNick() {
        return nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getOro() {
        return this.oro;
    }

    public void setOro(int ammount) {
        this.oro = ammount;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }
    
    public void addNotificacion(Notificacion noti){
        this.notificaciones.add(noti);
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }
    
}
