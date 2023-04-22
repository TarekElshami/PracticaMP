package practicamp;

import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blase
 */
public class AdministradorJuego extends javax.swing.JFrame {
    
    private Almacen almacen;
    
    /**
     * Creates new form gui
     *
     */
    public AdministradorJuego() throws IOException, FileNotFoundException, ClassNotFoundException {
        almacen = new Almacen();
        initComponents();
        this.setLayout(new CardLayout());
        add(menuPrincipal, "menuPrincipal");
        add(inicioSesion, "inicioSesion");
        add(registro, "registro");
    }
    
    public void showGame() {
        this.setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void registrarse() throws IOException, FileNotFoundException, ClassNotFoundException {
        
    }

    public void iniciar_sesion() throws IOException, FileNotFoundException, ClassNotFoundException {
        
    }

    public void salir() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPrincipal = new practicamp.MenuPrincipal();
        try {
            inicioSesion = new practicamp.InicioSesion();
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        } catch (java.lang.ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            registro = new practicamp.Registro();
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

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private practicamp.InicioSesion inicioSesion;
    private practicamp.MenuPrincipal menuPrincipal;
    private practicamp.Registro registro;
    // End of variables declaration//GEN-END:variables
}
