/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicamp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author aserr
 */
public class TestDesafios {
    
    public TestDesafios() throws IOException, FileNotFoundException, ClassNotFoundException, AWTException{
        Almacen a = new Almacen();
        JFrame f = new JFrame();
        f.setSize(640,480);
        Desafios interfaz = new Desafios(a);
        Robot robot = new Robot();
        f.add(interfaz);
//        f.setVisible(true);
        robot.delay(1000);
        
        // personaje desafiante 
        String nombre = "Juan";
        String nick = "Juan";
        String password = "juan";
        String personaje = Almacen.getPersonajes().get(0).getNombre();
        Armadura armadura = Almacen.getPersonajes().get(0).getArmaduras().get(0);
        System.out.println("hola");
        List<Arma> armas = (List<Arma>) Almacen.getPersonajes().get(0).getArmas();
        List<Arma> armasActivas = new ArrayList<>();
        armasActivas.add(armas.get(0));
        System.out.println("hola2");
        Usuario Desafiante = new Usuario(nick, password);
        Desafiante.setNombre(nombre);
        Desafiante.setRol(Rol.jugador);
        Desafiante.setTipoPersonaje(personaje);
        Desafiante.setArmaduraActiva(armadura);
        Desafiante.setArmasActivas(armasActivas);
        a.addUsuario(Desafiante);
        System.out.println(Almacen.getUsuarios().size()-1);
        System.out.println(Almacen.getUsuarios().get(Almacen.getUsuarios().size()-1).getNick());
        Almacen.setUsuarioActivo(Almacen.getUsuarios().size()-1);
        
        //personaje desafiado 
        String nombre2 = "Luis";
        String nick2 = "Luis";
        String password2 = "Luis";
        String personaje2 = Almacen.getPersonajes().get(1).getNombre();
        Armadura armadura2 = Almacen.getPersonajes().get(1).getArmaduras().get(0);
        List<Arma> armas2 = (List<Arma>) Almacen.getPersonajes().get(1).getArmas();
        List<Arma> armasActivas2 = new ArrayList<>();
        armasActivas2.add(armas.get(0));
        Usuario Desafiado = new Usuario(nick2, password2);
        Desafiado.setNombre(nombre2);
        Desafiado.setRol(Rol.jugador);
        Desafiado.setTipoPersonaje(personaje2);
        Desafiado.setArmaduraActiva(armadura2);
        Desafiado.setArmasActivas(armasActivas2);
        a.addUsuario(Desafiado);
        System.out.println(Almacen.getUsuarios().size()-1);
        System.out.println(Almacen.getUsuarios().get(Almacen.getUsuarios().size()-1).getNick());
        
        
        
        interfaz.actualizarList();
        f.setVisible(true);
        String oroApostado = "100"; // cantidad de oro que se desea apostar 
        
        interfaz.setOroApostado(oroApostado);
        int pos = interfaz.getPosUsurioList(Desafiado.getNick());// busaca la posición del usuario que hemos creado para que sea desafiado
        interfaz.setUsuarioList(pos);
        
        robot.mouseMove(530, 240);
        robot.mousePress(InputEvent.BUTTON1_MASK); // Presionar el botón izquierdo del ratón
        robot.mouseRelease(InputEvent.BUTTON1_MASK); // Soltar el botón izquierdo del ratón
        
        robot.delay(1000);
        
        List<Desafio> desafios = a.getDesafiosSinValidar();
        Desafio desafio = desafios.get(desafios.size()-1);// cogemos el último desafio
        
        // Verificar que el desafio se guarde correctamente en la clase Almacen
        assert desafio.getDesafiante().getNick().equals(Desafiante.getNick()): "El nombre del desafiante no coincide";
        assert desafio.getDesafiado().getNick().equals(Desafiado.getNick()): "El nombre del desafiado no coincide";
        assert desafio.getOro() == Float.parseFloat(oroApostado): "El oro apostado no coincide";
    }
}// creo que la propiedad personaje de la clase Usuario no sirva para nada(la que se usa es tipoPersonaje)
