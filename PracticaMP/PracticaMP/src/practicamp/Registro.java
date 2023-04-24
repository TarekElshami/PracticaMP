/*
 */
package practicamp;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author blase
 */
public class Registro extends javax.swing.JPanel implements Serializable {

    private List<Usuario> usuarios;
    private Almacen almacen;

    /**
     * Creates new form Registro
     */
    public Registro(Almacen almacen) throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        this.usuarios = new ArrayList<>();
        this.almacen = almacen;
        loadUsers();
        labelEstadoNick.setVisible(false);
    }

    private void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        this.usuarios = this.almacen.getUsuarios();
    }

    

    /**
     * @return
     */
    public Usuario showRegistro() {
        // TODO implement here
        return null;
    }

    /**
     * @param nick
     * @return
     */
    private boolean verificarNick(String nick) {
        Boolean found = false;
        if (!this.usuarios.isEmpty()){
            Iterator it = usuarios.iterator();

            while (it.hasNext() && !found) {
                Usuario usuario = (Usuario) it.next();
                found = (usuario.getNick().equals(nick));
            }
        }
        return found;
    }

    /**
     * @return
     */
    private String crearID() {
        // TODO implement here
        return "";
    }

    /**
     *
     */
    private void mostrarMensaje() {
        // TODO implement here
    }

    /**
     * @param usuarios
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelInputNick = new javax.swing.JLabel();
        fieldNick = new javax.swing.JTextField();
        labelInputContrasena = new javax.swing.JLabel();
        fieldContrasena = new javax.swing.JPasswordField();
        botonMostrarContrasena = new javax.swing.JButton();
        botonRegistro = new javax.swing.JButton();
        labelEstadoNick = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        labelTitulo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        labelTitulo.setText("Introduzca sus datos de registro");

        labelInputNick.setText("Nick");

        fieldNick.setToolTipText("Su nick único de identificación");
        fieldNick.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fieldNickCaretUpdate(evt);
            }
        });
        fieldNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNickKeyTyped(evt);
            }
        });

        labelInputContrasena.setText("Contraseña");

        fieldContrasena.setName("inicioSesion"); // NOI18N
        fieldContrasena.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fieldContrasenaCaretUpdate(evt);
            }
        });
        fieldContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldContrasenaKeyTyped(evt);
            }
        });

        botonMostrarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonMostrarContrasenaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonMostrarContrasenaMouseReleased(evt);
            }
        });
        botonMostrarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarContrasenaActionPerformed(evt);
            }
        });

        botonRegistro.setText("Registrar");
        botonRegistro.setEnabled(false);
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        labelEstadoNick.setForeground(new java.awt.Color(255, 51, 51));
        labelEstadoNick.setText("✗ El nick ya está en uso");

        botonVolver.setText("Volver");
        botonVolver.setToolTipText("Volver al menú");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelInputContrasena)
                            .addComponent(labelInputNick))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldNick)
                            .addComponent(fieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botonMostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelEstadoNick))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonVolver)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInputNick)
                    .addComponent(labelEstadoNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(labelInputContrasena)
                    .addComponent(botonMostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContrasena))
                .addGap(77, 77, 77)
                .addComponent(botonRegistro)
                .addGap(59, 59, 59)
                .addComponent(botonVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void fieldNickKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNickKeyTyped

    }//GEN-LAST:event_fieldNickKeyTyped

    private void fieldContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldContrasenaKeyTyped

    }//GEN-LAST:event_fieldContrasenaKeyTyped

    private void botonMostrarContrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMostrarContrasenaMousePressed
        fieldContrasena.setEchoChar((char) 0);
    }//GEN-LAST:event_botonMostrarContrasenaMousePressed

    private void botonMostrarContrasenaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMostrarContrasenaMouseReleased
        fieldContrasena.setEchoChar("\u2022".toCharArray()[0]);
    }//GEN-LAST:event_botonMostrarContrasenaMouseReleased

    private void botonMostrarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMostrarContrasenaActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        crearID();
        Usuario nuevoUsuario = new Usuario(fieldNick.getText(), String.valueOf(fieldContrasena.getPassword()));
        this.usuarios.add(nuevoUsuario);
        this.almacen.addUsuario(nuevoUsuario);

        try {
            this.almacen.updateFiles();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuPrincipal");


    }//GEN-LAST:event_botonRegistroActionPerformed

    private void fieldNickCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldNickCaretUpdate
        if (!fieldNick.getText().equals("")) {
            labelEstadoNick.setVisible(true);
        }
        boolean res = verificarNick(fieldNick.getText());
        if (res) {
            labelEstadoNick.setText("✗ El nick ya está en uso");
            labelEstadoNick.setForeground(Color.red);
        } else {
            labelEstadoNick.setText("✓ El nick está disponible");
            labelEstadoNick.setForeground(Color.green);
        }

        if ((fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0) && !res) {
            botonRegistro.setEnabled(true);
        } else {
            botonRegistro.setEnabled(false);
        }
    }//GEN-LAST:event_fieldNickCaretUpdate

    private void fieldContrasenaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldContrasenaCaretUpdate
        if ((fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0)) {
            botonRegistro.setEnabled(true);
        } else {
            botonRegistro.setEnabled(false);
        }
    }//GEN-LAST:event_fieldContrasenaCaretUpdate

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuPrincipal");
    }//GEN-LAST:event_botonVolverActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            this.almacen.updateUsers();
        } catch (IOException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        fieldNick.setText("");
        fieldContrasena.setText("");
        labelEstadoNick.setVisible(false);
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarContrasena;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JTextField fieldNick;
    private javax.swing.JLabel labelEstadoNick;
    private javax.swing.JLabel labelInputContrasena;
    private javax.swing.JLabel labelInputNick;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
