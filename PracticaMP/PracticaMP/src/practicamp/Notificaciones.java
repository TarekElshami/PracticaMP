/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicamp;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aserr
 */
public class Notificaciones extends javax.swing.JPanel {

    private Almacen almacen;
    private List<Notificacion> notificaciones;
    private EleccionEquipo eleccionEquipo;

    public Notificaciones(Almacen almacen, EleccionEquipo eleccionEquipo) {
        this.almacen = almacen;
        this.eleccionEquipo = eleccionEquipo;
        initComponents();
    }

    DefaultListModel mod = new DefaultListModel();

    public boolean actualizarLista() {
        mod.clear();
        int i = 0;
        Usuario usuario = Almacen.getUsuarioActivo();
        boolean vacio = true;
        if (!usuario.getNotificaciones().isEmpty()) {
            List<Notificacion> notificaciones = usuario.getNotificaciones();
            this.notificaciones = notificaciones;
            notificationList.setModel(mod); // para añadir los elementos a la lista
            vacio = false;
            mod.clear();
            while (i < notificaciones.size()) {
                String texto = "¡¡" + notificaciones.get(i).getRival() + " te ha desafiado";
                texto += " apostando " + notificaciones.get(i).getOroApostado() + " de oro!!";
                mod.addElement(texto);
                i = i + 1;

            }
        }
        return vacio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        notificationList = new javax.swing.JList<>();
        btnVolver = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        btnElegirArmaduras = new javax.swing.JButton();
        btnElegirArmas = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        notificationList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(notificationList);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnElegirArmaduras.setText("Elegir armaduras");
        btnElegirArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArmadurasActionPerformed(evt);
            }
        });

        btnElegirArmas.setText("Elegir armas");
        btnElegirArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRechazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnElegirArmaduras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnElegirArmas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRechazar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnElegirArmas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnElegirArmaduras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (notificationList.getSelectedIndex() != -1) {
            Notificacion notificacionSeleccionado = this.notificaciones.get(notificationList.getSelectedIndex());
            Desafio desafioSeleccionado = notificacionSeleccionado.obtenerDesafio();
//            Usuario u = Almacen.getUsuarioActivo();
//            u.restarOro(desafioSeleccionado.getOro());
            Combate newCombate = new Combate(almacen);
            try {
                newCombate.iniciarCombate(desafioSeleccionado);
            } catch (IOException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(desafioSeleccionado.getGanador());
            if (desafioSeleccionado.getGanador() != null) {
                int index = Almacen.buscarUsuario(desafioSeleccionado.getGanador());
                System.out.println(desafioSeleccionado.getOro());
                Almacen.getUsuarios().get(index).setOro(Almacen.getUsuarios().get(index).getOro() + desafioSeleccionado.getOro() * 2);
                Almacen.getUsuarios().get(index).sumarVictoria();
                Jugador nuevoJugador = new Jugador(desafioSeleccionado.getGanador().getNick(), Almacen.getUsuarios().get(index).getVictorias());
                try {
                    Ranking.agregarJugador(nuevoJugador);
                } catch (IOException ex) {
                    System.out.println("hola");
                    Logger.getLogger(Notificaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                int indexAdo = Almacen.buscarUsuario(desafioSeleccionado.getDesafiado());
                int indexAnte = Almacen.buscarUsuario(desafioSeleccionado.getDesafiante());
                Almacen.getUsuarios().get(indexAdo).sumarOro(desafioSeleccionado.getOro());
                Almacen.getUsuarios().get(indexAnte).sumarOro(desafioSeleccionado.getOro());
            }

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una notificación");
        }
        Usuario usuario = Almacen.getUsuarioActivo();
        this.notificaciones.remove(notificationList.getSelectedIndex());
        usuario.setNotificaciones(this.notificaciones);

        boolean vacio = this.actualizarLista();
        if (vacio) {
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "menuUsuario");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuUsuario");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        if (notificationList.getSelectedIndex() != -1) {
            Notificacion notificacionSeleccionado = this.notificaciones.get(notificationList.getSelectedIndex());
            double oroPerdido = notificacionSeleccionado.getOroApostado() * 0.1;
            Usuario usuario = Almacen.getUsuarioActivo();
            usuario.restarOro(oroPerdido);
            this.notificaciones.remove(notificationList.getSelectedIndex());
            usuario.setNotificaciones(this.notificaciones);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una notificación");
        }
        boolean vacio = this.actualizarLista();
        if (vacio) {
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "menuUsuario");
        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    private void btnElegirArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArmadurasActionPerformed

        this.eleccionEquipo.actualizarLista(Almacen.getUsuarioActivo().getTipoPersonaje(), false);
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "eleccionEquipo");
    }//GEN-LAST:event_btnElegirArmadurasActionPerformed

    private void btnElegirArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArmasActionPerformed
        this.eleccionEquipo.actualizarLista(Almacen.getUsuarioActivo().getTipoPersonaje(), true);
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "eleccionEquipo");

    }//GEN-LAST:event_btnElegirArmasActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Almacen.setInNot(true);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnElegirArmaduras;
    private javax.swing.JButton btnElegirArmas;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> notificationList;
    // End of variables declaration//GEN-END:variables
}
