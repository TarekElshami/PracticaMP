/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

import java.io.Serializable;


/**
 *
 * @author aserr
 */
public class Jugador implements Serializable{
    private String nick;
    private int victorias;
    
    public Jugador(String nick, int victorias) {
        this.nick = nick;
        this.victorias = victorias;
    }
    
    public String getNombre() {
        return nick;
    }
    
    public int getVictorias() {
        return victorias;
    }
}

