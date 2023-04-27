/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicamp;

import java.awt.CardLayout;
import javax.swing.JPanel;
import practicamp.*;

/**
 *
 * @author aserr
 */
public class MenuEditarPersonaje extends javax.swing.JPanel {
    private GestionEsbirros gEsbirros;
    private String nombrePeronaje;
    private EdicionModificadores edHabilidades;
    private EdicionEquipo edEquipo;

    /**
     * Creates new form MenuCambioPersonaje
     */
    public MenuEditarPersonaje(GestionEsbirros gEsbirros, EdicionModificadores edHabilidades, EdicionEquipo edEquipo) {
        this.gEsbirros = gEsbirros;
        this.edHabilidades = edHabilidades;
        this.edEquipo = edEquipo;
        initComponents();
    }
    
    public void setTipo(String nombre){
        tipoPersonaje.setText(nombre);
        this.nombrePeronaje = nombre;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btmModificadores = new javax.swing.JButton();
        btnEquipo = new javax.swing.JButton();
        btnEsbirro = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        tipoPersonaje = new javax.swing.JLabel();

        btmModificadores.setText("Modificadores");
        btmModificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmModificadoresActionPerformed(evt);
            }
        });

        btnEquipo.setText("Equipo");
        btnEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipoActionPerformed(evt);
            }
        });

        btnEsbirro.setText("Esbirro");
        btnEsbirro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsbirroActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tipoPersonaje.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        tipoPersonaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoPersonaje.setText("Tipo\n");
        tipoPersonaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEsbirro, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btmModificadores, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(tipoPersonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmModificadores, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEsbirro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btmModificadores, btnEquipo, btnEsbirro});

    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuSeleccionPersonaje");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEsbirroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsbirroActionPerformed
        JPanel parent = (JPanel) getParent();
        gEsbirros.añadirInfo(this.nombrePeronaje);
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "gestionEsbirros");
    }//GEN-LAST:event_btnEsbirroActionPerformed

    private void btmModificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmModificadoresActionPerformed
        JPanel parent = (JPanel) getParent();
        edHabilidades.cargarPersonaje(this.nombrePeronaje);
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "edicionModificadores");
    }//GEN-LAST:event_btmModificadoresActionPerformed

    private void btnEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipoActionPerformed
        JPanel parent = (JPanel) getParent();
        edEquipo.actualizarListas(this.nombrePeronaje);
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "edicionEquipo");
    }//GEN-LAST:event_btnEquipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmModificadores;
    private javax.swing.JButton btnEquipo;
    private javax.swing.JButton btnEsbirro;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel tipoPersonaje;
    // End of variables declaration//GEN-END:variables
}
