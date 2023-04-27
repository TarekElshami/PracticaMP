package practicamp;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EleccionEquipo extends javax.swing.JPanel {
    private List<Arma> armas;
    private List<Armadura> armaduras;
    private List<Arma> armasSeleccionadas;
    private Armadura armadura;
    private boolean esArma;
    private int manosDisponibles;

    
    public EleccionEquipo() {
        initComponents();
        
    }
    
    public void actualizarLista(String nombrePersonaje, boolean esArma){
        this.esArma = esArma;
        if (esArma) {
            this.armasSeleccionadas = new ArrayList<>();
            this.manosDisponibles = 2;
            List<Arma> armasActivas = Almacen.getUsuarioActivo().getArmasActivas();
            List<Arma> armas = new ArrayList<>();
            List<Personaje> personajes = Almacen.getPersonajes(); 
            DefaultListModel<String> itemsVector = new DefaultListModel<>(); 
            for (Personaje personaje : personajes) {
                if (personaje.getNombre().equals(nombrePersonaje)) {
                    for (Arma arma : personaje.getArmas()) {
                        String text = arma.getNombre() + ": Atq = " + arma.getAtaque() + "/ Def = " + arma.getDefensa();
                        if (armasActivas.contains(arma)){
                            this.manosDisponibles -= arma.getManos();
                            this.armasSeleccionadas.add(arma);
                            text = "<html><font color='green'>" + text + "</font></html>";
                        }
                        itemsVector.addElement(text);
                        armas.add(arma);
                    }
                }
            }
            armasList.setModel(itemsVector);
            this.armas = armas;
            armasList.setVisible(true);
            armadurasList.setVisible(false);
            etiqArmas.setVisible(true);
            etiqArmaduras.setVisible(false);

        } else {
            List<Armadura> armaduras = new ArrayList<>();
            Armadura armaduraActiva = Almacen.getUsuarioActivo().getArmaduraActiva();
            List<Personaje> personajes = Almacen.getPersonajes(); 
            DefaultListModel<String> itemsVector = new DefaultListModel<>(); 
            for (Personaje personaje : personajes) {
                if (personaje.getNombre().equals(nombrePersonaje)) {
                    for (Armadura armadura : personaje.getArmaduras()) {
                        String text = armadura.getNombre() + ": Atq = " + armadura.getAtaque() + "/ Def = " + armadura.getDefensa();
                        if (armaduraActiva == armadura){
                            this.armadura = armadura;
                            text = "<html><font color='green'>" + text + "</font></html>";
                        }
                        itemsVector.addElement(text);
                        armaduras.add(armadura);
                    }
                }
            }
            armadurasList.setModel(itemsVector);
            this.armaduras = armaduras;
            armadurasList.setVisible(true);
            armasList.setVisible(false);
            etiqArmas.setVisible(false);
            etiqArmaduras.setVisible(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiqArmas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        armasList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        armadurasList = new javax.swing.JList<>();
        btnVolver = new javax.swing.JButton();
        btnConfiramar = new javax.swing.JButton();
        etiqArmaduras = new javax.swing.JLabel();

        etiqArmas.setText("Eleccion Armas");

        armasList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        armasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                armasListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(armasList);

        armadurasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                armadurasListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(armadurasList);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnConfiramar.setText("Confirmar");
        btnConfiramar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiramarActionPerformed(evt);
            }
        });

        etiqArmaduras.setText("Eleccion Armadura");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfiramar)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(etiqArmas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiqArmaduras)
                .addGap(148, 148, 148))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqArmas)
                    .addComponent(etiqArmaduras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnConfiramar))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuUsuario");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfiramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiramarActionPerformed
        if (!this.armasSeleccionadas.isEmpty() && esArma){
            Almacen.getUsuarioActivo().setArmasActivas(this.armasSeleccionadas);
        } else if(this.armadura != null && !esArma){
            Almacen.getUsuarioActivo().setArmaduraActiva(this.armadura);
        } 
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuUsuario");
    }//GEN-LAST:event_btnConfiramarActionPerformed

   
    
    private void armasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armasListMouseClicked
        if (evt.getClickCount() == 1) { // Verifica que se haya hecho un solo click
            JList<String> list = (JList<String>) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());
            String item = list.getModel().getElementAt(index);
            Arma armaSeleccionada = this.armas.get(index);
            if (item.contains("<font color='green'>")) {
                item = item.replace("<font color='green'>", "");
                item = item.replace("</font>", "");
                this.armasSeleccionadas.remove(armaSeleccionada);
                this.manosDisponibles += armaSeleccionada.getManos();
                JOptionPane.showMessageDialog(null, "Tienes " + this.manosDisponibles + " mano(s) disponibles.");
            } else if (armaSeleccionada.getManos()<= this.manosDisponibles) {
                item = "<html><font color='green'>" + item + "</font></html>";
                this.armasSeleccionadas.add(armaSeleccionada);
                this.manosDisponibles -= armaSeleccionada.getManos();
                JOptionPane.showMessageDialog(null, "Tienes " + this.manosDisponibles + " mano(s) disponibles.");
            } else {
                JOptionPane.showMessageDialog(null, "No tienes suficientes manos");
            }
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.setElementAt(item, index);
            //this.arma = armaSeleccionada;
        }
    }//GEN-LAST:event_armasListMouseClicked

    private void armadurasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_armadurasListMouseClicked
        if (evt.getClickCount() == 1) { // Verifica que se haya hecho un solo click
            JList<String> list = (JList<String>) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());    // TODO add your handling code here:
            String item = list.getModel().getElementAt(index);
            Armadura armaduraSeleccionada = this.armaduras.get(index);
            if (item.contains("<font color='green'>")) {
                item = item.replace("<font color='green'>", "");
                item = item.replace("</font>", "");
                this.armadura = null;
                JOptionPane.showMessageDialog(null, "Te has quitado la armadura");
            } else if (this.armadura == null) {
                item = "<html><font color='green'>" + item + "</font></html>";
                this.armadura = armaduraSeleccionada;
                JOptionPane.showMessageDialog(null, "Te has equipado " + this.armadura.getNombre()+".");
            } else {
                JOptionPane.showMessageDialog(null, "No puedes llevar más de una armadura a la vez");
            }
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.setElementAt(item, index);
        }
    }//GEN-LAST:event_armadurasListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> armadurasList;
    private javax.swing.JList<String> armasList;
    private javax.swing.JButton btnConfiramar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel etiqArmaduras;
    private javax.swing.JLabel etiqArmas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
