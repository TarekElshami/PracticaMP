package practicamp;

import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author blase
 */
public class AdministradorJuego extends javax.swing.JFrame {
    
    private Almacen almacen;
    private Ranking ranking;
    
    /**
     * Creates new form gui
     *
     */
    public AdministradorJuego() throws IOException, FileNotFoundException, ClassNotFoundException {
        almacen = new Almacen();
        this.ranking = new Ranking();
        initComponents();
        this.setLayout(new CardLayout());
        add(menuPrincipal, "menuPrincipal");
        add(inicioSesion, "inicioSesion");
        add(registro, "registro");
        add(menuUsuario, "menuUsuario");
        add(desafios, "desafios");
        add(notificaciones, "notificaciones");
        add(menuOperador, "menuOperador");
        add(validarDesafios, "validarDesafios");
        add(menuSeleccionPersonaje, "menuSeleccionPersonaje");
        add(menuEditarPersonaje, "menuEditarPersonaje");
        add(gestionEsbirros, "gestionEsbirros");
        add(nuevoEsbirro, "nuevoEsbirro");
        add(creacionPersonaje, "creacionPersonaje");
        add(eleccionEquipo, "eleccionEquipo");
        add(edicionModificadores, "edicionModificadores");
        add(edicionEquipo, "edicionEquipo");
        add(pantallaRanking, "pantallaRanking");
        add(pantallaBaneo, "pantallaBaneo");
    }
    
    public void showGame() {
        this.setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipal = new practicamp.MenuInicial();
        try {
            desafios = new practicamp.Desafios(almacen);
            notificaciones = new practicamp.Notificaciones(almacen);
            eleccionEquipo = new practicamp.EleccionEquipo();
            pantallaRanking = new practicamp.PantallaRanking();
            pantallaBaneo = new practicamp.PantallaBaneo(almacen);
            inicioSesion = new practicamp.InicioSesion(almacen,desafios);
            edicionModificadores = new practicamp.EdicionModificadores();
            edicionEquipo = new practicamp.EdicionEquipo();
            menuUsuario = new practicamp.MenuUsuario(notificaciones, almacen, eleccionEquipo, pantallaRanking);
            validarDesafios = new practicamp.ValidarDesafios(almacen);
            creacionPersonaje = new practicamp.CreacionPersonaje();
            gestionEsbirros = new practicamp.GestionEsbirros();
            nuevoEsbirro = new practicamp.NuevoEsbirro(gestionEsbirros);
            menuEditarPersonaje = new practicamp.MenuEditarPersonaje(gestionEsbirros, edicionModificadores, edicionEquipo);
            menuSeleccionPersonaje = new practicamp.MenuSeleccionPersonaje(menuEditarPersonaje);
            menuOperador = new practicamp.MenuOperador(validarDesafios);
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            registro = new practicamp.Registro(almacen, this.ranking);
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.CardLayout());

        menuPrincipal.setName("menuPrincipal"); // NOI18N
        getContentPane().add(menuPrincipal, "card2");

        inicioSesion.setName("inicioSesion"); // NOI18N
        getContentPane().add(inicioSesion, "card4");

        registro.setName("registro"); // NOI18N
        getContentPane().add(registro, "card4");
        
        menuUsuario.setName("menuUsuario");
        getContentPane().add(menuUsuario, "card5");

        desafios.setName("desafios");
        getContentPane().add(desafios, "card6");

        notificaciones.setName("notificaciones");
        getContentPane().add(notificaciones,"card7");

        menuOperador.setName("menuOperador");
        getContentPane().add(menuOperador, "card8");

        validarDesafios.setName("validarDesafios");
        getContentPane().add(validarDesafios, "card9");

        menuSeleccionPersonaje.setName("menuSeleccionPersonaje");
        getContentPane().add(menuSeleccionPersonaje, "card10");

        menuEditarPersonaje.setName("menuEditarPersonaje");
        getContentPane().add(menuEditarPersonaje, "card11");

        gestionEsbirros.setName("gestionEsbirros");
        getContentPane().add(gestionEsbirros, "card12");

        nuevoEsbirro.setName("nuevoEsbirro");
        getContentPane().add(nuevoEsbirro, "card13");

        creacionPersonaje.setName("creacionPersonaje");
        getContentPane().add(nuevoEsbirro, "card14");

        eleccionEquipo.setName("eleccionEquipo");
        getContentPane().add(eleccionEquipo, "card15");

        edicionModificadores.setName("edicionHabilidades");
        getContentPane().add(edicionModificadores, "card16");

        edicionEquipo.setName("edicionEquipo");
        getContentPane().add(edicionEquipo, "card17");

        pantallaRanking.setName("pantallaRanking");
        getContentPane().add(pantallaRanking, "card18");

        pantallaBaneo.setName("pantallaBaneo");
        getContentPane().add(pantallaBaneo, "card19");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private practicamp.InicioSesion inicioSesion;
    private practicamp.MenuInicial menuPrincipal;
    private practicamp.Registro registro;
    private practicamp.MenuUsuario menuUsuario;
    private practicamp.Desafios desafios;
    private practicamp.Notificaciones notificaciones;
    private practicamp.MenuOperador menuOperador;
    private practicamp.ValidarDesafios validarDesafios;
    private practicamp.MenuSeleccionPersonaje menuSeleccionPersonaje;
    private practicamp.MenuEditarPersonaje menuEditarPersonaje;
    private practicamp.GestionEsbirros gestionEsbirros;
    private practicamp.NuevoEsbirro nuevoEsbirro;
    private practicamp.CreacionPersonaje creacionPersonaje;
    private practicamp.EleccionEquipo eleccionEquipo;
    private practicamp.EdicionModificadores edicionModificadores;
    private practicamp.EdicionEquipo edicionEquipo;
    private practicamp.PantallaRanking pantallaRanking;
    private practicamp.PantallaBaneo pantallaBaneo;
    // End of variables declaration//GEN-END:variables
}
