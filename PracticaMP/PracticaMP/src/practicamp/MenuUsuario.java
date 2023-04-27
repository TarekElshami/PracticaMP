/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicamp;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aserr
 */
public class MenuUsuario extends javax.swing.JPanel {
    private Notificaciones notificaciones;
    private Almacen almacen;
    private EleccionEquipo eleccionEquipo;
    /**
     * Creates new form MenuUsuario
     * @param notificaciones
     */
    public MenuUsuario(Notificaciones notificaciones, Almacen almacen, EleccionEquipo eleccionEquipo) {
        this.notificaciones = notificaciones;
        this.almacen = almacen;
        this.eleccionEquipo = eleccionEquipo;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConultarOro = new javax.swing.JButton();
        btnElegirArmas = new javax.swing.JButton();
        btnElegirArmaduras = new javax.swing.JButton();
        btnDesafiar = new javax.swing.JButton();
        btnNotificaciones = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnCrearPersonaje = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        btnConultarOro.setText("Consultar oro");
        btnConultarOro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConultarOroActionPerformed(evt);
            }
        });

        btnElegirArmas.setText("Elegir armas");
        btnElegirArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArmasActionPerformed(evt);
            }
        });

        btnElegirArmaduras.setText("Elegir armaduras");
        btnElegirArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArmadurasActionPerformed(evt);
            }
        });

        btnDesafiar.setText("Desafiar");
        btnDesafiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesafiarActionPerformed(evt);
            }
        });

        btnNotificaciones.setText("Ver notificaciones");
        btnNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacionesActionPerformed(evt);
            }
        });

        jButton6.setText("Historial");

        jButton7.setText("Ranking");

        btnCrearPersonaje.setText("Crear personaje");
        btnCrearPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPersonajeActionPerformed(evt);
            }
        });

        jButton10.setText("Dar de baja personaje");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesafiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnElegirArmaduras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnElegirArmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConultarOro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnConultarOro, btnCrearPersonaje, btnDesafiar, btnElegirArmaduras, btnElegirArmas, btnNotificaciones, btnSalir, jButton10, jButton6, jButton7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnConultarOro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnElegirArmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearPersonaje, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnElegirArmaduras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesafiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnConultarOro, btnCrearPersonaje, btnDesafiar, btnElegirArmaduras, btnElegirArmas, btnNotificaciones, btnSalir, jButton10, jButton6, jButton7});

    }// </editor-fold>//GEN-END:initComponents

    private void btnDesafiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesafiarActionPerformed
        //if (this.almacen.getUsuarioActivo().getTipoPersonaje()!= null){
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "desafios");
//        } else {
//            javax.swing.JOptionPane.showMessageDialog(this, "Necesitas tener un personaje para acceder a esta opción");
//        }
    }//GEN-LAST:event_btnDesafiarActionPerformed

    private void btnNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacionesActionPerformed
        boolean vacio = this.notificaciones.actualizarLista();// si no hay notificaciones que no entre en la pantalla 
        if (!vacio && Almacen.getUsuarioActivo().getTipoPersonaje()!= null){
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "notificaciones");
        } else if(vacio){
            javax.swing.JOptionPane.showMessageDialog(this, "No tiene notificaciones");
        } else if(Almacen.getUsuarioActivo().getTipoPersonaje()== null){
            javax.swing.JOptionPane.showMessageDialog(this, "Necesitas tener un personaje para acceder a esta opción");
        }
        
    }//GEN-LAST:event_btnNotificacionesActionPerformed

    private void btnConultarOroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConultarOroActionPerformed
        int goldAmmount = Almacen.getUsuarioActivo().getOro();
        JOptionPane.showMessageDialog(null, "Oro: " + goldAmmount, "Consultor de oro", JOptionPane.INFORMATION_MESSAGE);// TODO add your handling code here:
    }//GEN-LAST:event_btnConultarOroActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            this.almacen.updateFiles();
        } catch (IOException ex) {
            Logger.getLogger(MenuUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCrearPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPersonajeActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "creacionPersonaje");
    }//GEN-LAST:event_btnCrearPersonajeActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       System.out.println(Almacen.getUsuarioActivo().getTipoPersonaje());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnElegirArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArmasActionPerformed
        if (Almacen.getUsuarioActivo().getTipoPersonaje()!= null){
            this.eleccionEquipo.actualizarLista(Almacen.getUsuarioActivo().getTipoPersonaje(), true);
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "eleccionEquipo");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Necesitas tener un personaje para acceder a esta opción");
        }
    }//GEN-LAST:event_btnElegirArmasActionPerformed

    private void btnElegirArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArmadurasActionPerformed
        if (Almacen.getUsuarioActivo().getTipoPersonaje()!= null){
            this.eleccionEquipo.actualizarLista(Almacen.getUsuarioActivo().getTipoPersonaje(), false);
            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "eleccionEquipo");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Necesitas tener un personaje para acceder a esta opción");
        }
    }//GEN-LAST:event_btnElegirArmadurasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConultarOro;
    private javax.swing.JButton btnCrearPersonaje;
    private javax.swing.JButton btnDesafiar;
    private javax.swing.JButton btnElegirArmaduras;
    private javax.swing.JButton btnElegirArmas;
    private javax.swing.JButton btnNotificaciones;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    // End of variables declaration//GEN-END:variables
}
