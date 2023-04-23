/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicamp;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Addy
 */
public class EdicionEquipo extends javax.swing.JPanel {

    List<Armadura> armadurasPersonaje;
    List<Arma> armasPersonaje;
    List<Arma> armas;
    List<Armadura> armaduras;
    
    public EdicionEquipo(String nombrePersonaje) {
        initComponents();
        this.armadurasPersonaje = new ArrayList<>();
        this.armasPersonaje = new ArrayList<>();
        // Obtener todas las armas
        List<Arma> armas = Almacen.getArmas();
        List<Armadura> armaduras = Almacen.getArmaduras();
        this.armas = armas;
        this.armaduras = armaduras;

        // Obtener las armas y armaduras del personaje
        List<String> armasPersonaje = new ArrayList<>();
        List<String> armadurasPersonaje = new ArrayList<>();
        for (Personaje personaje : Almacen.getPersonajes()) {
            if (personaje.getNombre().equals(nombrePersonaje)) {
                for (Arma arma : personaje.getArmas()) {
                    armasPersonaje.add(arma.getNombre());
                    this.armasPersonaje.add(arma);
                }
                for (Armadura armadura : personaje.getArmaduras()) {
                    armadurasPersonaje.add(armadura.getNombre());
                    this.armadurasPersonaje.add(armadura);
                }    
            }
        }

        // Crear los modelos de las listas
        DefaultListModel<String> modeloArmas = new DefaultListModel<>();
        for (Arma arma : armas) {
            String nombreArma = arma.getNombre() + ": Atq = " + arma.getAtaque() + "/ Def = " + arma.getDefensa();
            if (armasPersonaje.contains(arma.getNombre())) {
                modeloArmas.addElement("<html><font color='green'>" + nombreArma + "</font></html>");
            } else {
                modeloArmas.addElement(nombreArma);
            }
        }

        DefaultListModel<String> modeloArmaduras = new DefaultListModel<>();
        for (Armadura armadura : armaduras) {
            String nombreArmadura = armadura.getNombre() + ": Atq = " + armadura.getAtaque() + "/ Def = " + armadura.getDefensa();
            if (armadurasPersonaje.contains(armadura.getNombre())) {
                modeloArmaduras.addElement("<html><font color='green'>" + nombreArmadura + "</font></html>");
            } else {
                modeloArmaduras.addElement(nombreArmadura);
            }
        }

        jList1.setModel(modeloArmas);

        jList2.setModel(modeloArmaduras);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("Editar equipo");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 1) { // asegurarse de que se hizo un solo clic
            JList<String> list = (JList<String>) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());
            String item = list.getModel().getElementAt(index);
            Arma armaEscogida = this.armas.get(index);
            // si el elemento está en verde, cambiarlo a negro, y viceversa
            if (item.contains("<font color='green'>")) {
                item = item.replace("<font color='green'>", "");
                item = item.replace("</font>", "");
                this.armasPersonaje.remove(armaEscogida);
                /*for (Arma objeto : armasPersonaje) {
                    System.out.println(objeto.getNombre());
                }*/
            } else {
                item = "<html><font color='green'>" + item + "</font></html>";
                this.armasPersonaje.add(armaEscogida);
                /*for (Arma objeto : armasPersonaje) {
                    System.out.println(objeto.getNombre());
                }*/
            }
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.setElementAt(item, index);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        if (evt.getClickCount() == 1) { // asegurarse de que se hizo un solo clic
            JList<String> list = (JList<String>) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());
            String item = list.getModel().getElementAt(index);
            Armadura armaduraEscogida = this.armaduras.get(index);
            // si el elemento está en verde, cambiarlo a negro, y viceversa
            if (item.contains("<font color='green'>")) {
                item = item.replace("<font color='green'>", "");
                item = item.replace("</font>", "");
                this.armadurasPersonaje.remove(armaduraEscogida);
                /*for (Armadura objeto : armadurasPersonaje) {
                    System.out.println(objeto.getNombre());
                }*/
            } else {
                item = "<html><font color='green'>" + item + "</font></html>";
                this.armadurasPersonaje.add(armaduraEscogida);
                /*for (Armadura objeto : armadurasPersonaje) {
                    System.out.println(objeto.getNombre());
                }*/
            }
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.setElementAt(item, index);
        }
    }//GEN-LAST:event_jList2MouseClicked

    public List<Armadura> getArmadurasPersonaje() {
        return armadurasPersonaje;
    }

    public List<Arma> getArmasPersonaje() {
        return armasPersonaje;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
