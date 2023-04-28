package practicamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private Rol rol;
    private String nombre;
    private String nick;
    private String contrasena;
    private String id;
    private boolean baneado;
    private List<Desafio> historiales;
    private List<Notificacion> notificaciones;
    private double oro;
    private int victorias;
    private String personaje;
    private List<Arma> armasActivas;
    private Armadura armaduraActiva;
    private String tipoPersonaje;
    
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
        this.historiales = new ArrayList<>();
        this.notificaciones =  new ArrayList<>();
    }
    
    public void restarOro(double cantidad){
        this.oro -= cantidad;
    }
    
    public void sumarOro(double cantidad){
        this.oro += cantidad;
    }
    
    public void addNotificacion(Notificacion noti) {
        this.notificaciones.add(noti);
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    

    public void setTipoPersonaje(String tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
   
    public void setArmasActivas(List<Arma> armasActivas) {
        this.armasActivas = armasActivas;
    }

    public void setArmaduraActiva(Armadura armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    public void setOro(double ammount) {
        this.oro = ammount;
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

    public void addToHistorial(Desafio desafio) {
        this.historiales.add(desafio);
    }

    public String getId() {
        return id;
    }

    public List<Notificacion> getNotificaciones() {
        return this.notificaciones;
    }

    public String getNick() {
        return nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public double getOro() {
        return this.oro;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }

    public Rol getRol() {
        return rol;
    }

    public List<Arma> getArmasActivas() {
        return armasActivas;
    }

    public Armadura getArmaduraActiva() {
        return armaduraActiva;
    }

    public List<Desafio> getHistorial() {
        return historiales;
    }

    public boolean isBaneado() {
        return baneado;
    }

    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }

    public int getVictorias() {
        return victorias;
    }
    
    public void sumarVictoria(){
        this.victorias = this.victorias + 1;
    }
    
}
