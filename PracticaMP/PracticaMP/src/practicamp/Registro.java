/*
 */
package practicamp;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.util.LinkedList;

/**
 *
 * @author blase
 */
public class Registro extends javax.swing.JPanel implements Serializable {

    private List<Usuario> usuarios;
    private Almacen almacen;
    private Ranking ranking;

    
    public Registro(Almacen almacen, Ranking ranking) throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        this.usuarios = new ArrayList<>();
        this.almacen = almacen;
        loadUsers();
        labelEstadoNick.setVisible(false);
        String[] opciones = Arrays.stream(Rol.values()).map(Enum::name).toArray(String[]::new);
        jComboBox1.setModel(new DefaultComboBoxModel<>(opciones));
    }

    private void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        this.usuarios = Almacen.getUsuarios();
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
    public String generarId() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int contador = 1;
        String id;
        boolean idExistente;

        do {
            // Generar el número natural
            String numero = String.format("%02d", contador);

            // Generar la primera letra
            int indice1 = (contador - 1) % letras.length();
            String letra1 = Character.toString(letras.charAt(indice1));

            // Generar la segunda letra
            int indice2 = ((contador - 1) / letras.length()) % letras.length();
            String letra2 = Character.toString(letras.charAt(indice2));

            // Generar la tercera letra
            int indice3 = ((contador - 1) / (letras.length() * letras.length())) % letras.length();
            String letra3 = Character.toString(letras.charAt(indice3));

            // Crear el ID
            id = letra1 + numero + letra2 + letra3;

            // Verificar si el ID ya existe
            idExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getRol() == Rol.jugador && usuario.getId().equals(id)) {
                    idExistente = true;
                    break;
                }
            }

            contador++;
        } while (idExistente);

        return id;
    }
    

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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

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

        botonMostrarContrasena.setBackground(new java.awt.Color(204, 204, 204));
        botonMostrarContrasena.setText("ver contraseña");
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

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rol");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jLabel2.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelInputContrasena)
                                    .addComponent(labelInputNick)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldNick)
                                    .addComponent(fieldContrasena)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonMostrarContrasena)
                                    .addComponent(labelEstadoNick))))
                        .addGap(0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInputNick)
                    .addComponent(labelEstadoNick))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(labelInputContrasena)
                    .addComponent(botonMostrarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVolver)
                    .addComponent(botonRegistro))
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

    }//GEN-LAST:event_botonMostrarContrasenaActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed
        Usuario nuevoUsuario = new Usuario(fieldNick.getText(), String.valueOf(fieldContrasena.getPassword()));
        nuevoUsuario.setNombre(jTextField1.getText());
        int selectedIndex = jComboBox1.getSelectedIndex();
        Rol rolSeleccionado = Rol.values()[selectedIndex];
        nuevoUsuario.setRol(rolSeleccionado);
        if(rolSeleccionado == Rol.jugador){
            String id = generarId();
            System.out.println(id);
            nuevoUsuario.setId(id);
            Jugador nuevoJugador  = new Jugador(fieldNick.getText(),0);
            try {
                Ranking.agregarJugador(nuevoJugador);
            } catch (IOException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        String fieldText = fieldNick.getText();
        boolean res = verificarNick(fieldText);

        if (!fieldText.equals("")) {
            labelEstadoNick.setVisible(true);

            if (res) {
                labelEstadoNick.setText("✗ El nick ya está en uso");
                labelEstadoNick.setForeground(Color.red);
            } else {
                labelEstadoNick.setText("✓ El nick está disponible");
                labelEstadoNick.setForeground(Color.green);
            }
        } else {
            // Ocultar el label si el campo de texto está vacío
            labelEstadoNick.setVisible(false);
        }

        if ((fieldContrasena.getPassword().length > 0) && (fieldText.length() > 0) && !res) {
            botonRegistro.setEnabled(true);
        } else {
            botonRegistro.setEnabled(false);
        }
    }//GEN-LAST:event_fieldNickCaretUpdate

    private void fieldContrasenaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fieldContrasenaCaretUpdate
        if ((jTextField1.getText().length() >0 ) && (fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0)) {
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
        jTextField1.setText("");
        labelEstadoNick.setVisible(false);
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_formComponentHidden

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        if ((jTextField1.getText().length() > 0) && (fieldContrasena.getPassword().length > 0) && (fieldNick.getText().length() > 0)) {
            botonRegistro.setEnabled(true);
        } else {
            botonRegistro.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMostrarContrasena;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JButton botonVolver;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JTextField fieldNick;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelEstadoNick;
    private javax.swing.JLabel labelInputContrasena;
    private javax.swing.JLabel labelInputNick;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
