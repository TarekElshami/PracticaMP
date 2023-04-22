package practicamp;

import java.awt.CardLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Blas
 */
public class InicioSesion extends javax.swing.JPanel implements Serializable {

    private List<Usuario> usuarios;

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        loadUsers();
    }

    private void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        File usersDB = new File("src/files/db/users.db");
        if (!usersDB.exists()) {
            updateFiles();
        } else {
            updateUsers();
        }
    }

    public void updateFiles() throws FileNotFoundException, IOException {
        FileOutputStream usersFile = new FileOutputStream("src/files/db/users.db");
        ObjectOutputStream output = new ObjectOutputStream(usersFile);

        output.writeObject(this.usuarios);
        output.close();
    }

    private void updateUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream usersFile = new FileInputStream("src/files/db/users.db");
        ObjectInputStream input = new ObjectInputStream(usersFile);
        this.usuarios = (List<Usuario>) input.readObject();
        if (this.usuarios == null) {
            this.usuarios = new ArrayList<>();
        }
        input.close();
    }

    /**
     * @return
     */
    public Usuario showLogin() {
        // TODO implement here
        return null;
    }

    /**
     * @param nombre
     * @param password
     * @return
     */
    private boolean[] verificarDatos(String nombre, String password) {
        boolean[] values = new boolean[]{false, false};
        Iterator it = this.usuarios.iterator();
        boolean found = false;
        while (it.hasNext() && (!found)) {
            Usuario usuario = (Usuario) it.next();
            if (usuario.getNick().equals(nombre) && usuario.getContrasena().equals(password)) {
                values = new boolean[]{true, true};
                found = true;
            } else if (usuario.getNick().equals(nombre)) {
                values = new boolean[]{true, false};
                found = true;
            } else {
                values = new boolean[]{false, false};
            }
        }
        return values;
    }

    /**
     * @return
     */
    private void mostrarMensaje(boolean[] res) {
        if (!res[0]) {
            JOptionPane errorPane = new JOptionPane();
            errorPane.showMessageDialog(this, "No existe ningún usuario con ese nick", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            errorPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane errorPane = new JOptionPane();
            errorPane.showMessageDialog(this, "Su contraseña es incorrecta", "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
            errorPane.setOptionType(JOptionPane.DEFAULT_OPTION);
        }
    }

    /**
     * @param usuarios
     */
    public void IniciarSesion(List<Usuario> usuarios) {
        // TODO implement here
    }

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
        botonInicio = new javax.swing.JButton();
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
        labelTitulo.setText("Introduzca sus credenciales");

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

        botonInicio.setText("Entrar");
        botonInicio.setEnabled(false);
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioActionPerformed(evt);
            }
        });

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
                .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(labelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelInputContrasena)
                            .addComponent(labelInputNick))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldNick, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(fieldContrasena))
                        .addGap(10, 10, 10)
                        .addComponent(botonMostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonVolver)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelTitulo)
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInputNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(labelInputContrasena)
                    .addComponent(botonMostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContrasena))
                .addGap(79, 79, 79)
                .addComponent(botonInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(botonVolver)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonMostrarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMostrarContrasenaActionPerformed

    private void botonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioActionPerformed
        boolean[] res = verificarDatos(fieldNick.getText(), String.valueOf(fieldContrasena.getPassword()));
        if (res[0] && res[1]) {
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "menuPrincipal");
        } else {
            mostrarMensaje(res);
        }
    }//GEN-LAST:event_botonInicioActionPerformed

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

    private void fieldContrasenaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldContrasenaCaretUpdate
        if ((fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0)) {
            botonInicio.setEnabled(true);
        } else {
            botonInicio.setEnabled(false);
        }
    }//GEN-LAST:event_fieldContrasenaCaretUpdate

    private void fieldNickCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldNickCaretUpdate
        if ((fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0)) {
            botonInicio.setEnabled(true);
        } else {
            botonInicio.setEnabled(false);
        }
    }//GEN-LAST:event_fieldNickCaretUpdate

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuPrincipal");
    }//GEN-LAST:event_botonVolverActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            updateUsers();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        fieldNick.setText("");
        fieldContrasena.setText("");
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInicio;
    private javax.swing.JButton botonMostrarContrasena;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JTextField fieldNick;
    private javax.swing.JLabel labelInputContrasena;
    private javax.swing.JLabel labelInputNick;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
