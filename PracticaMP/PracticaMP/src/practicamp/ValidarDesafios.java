/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package practicamp;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author aserr
 */
public class ValidarDesafios extends javax.swing.JPanel {

    private Almacen almacen;
    private List<Modificador> modificadoresSelec;

    /**
     * Creates new form ValidarDesafios
     */
    public ValidarDesafios(Almacen almacen) {
        this.almacen = almacen;
        this.modificadoresSelec = new ArrayList<>();
        initComponents();
    }
    DefaultListModel mod = new DefaultListModel();
    DefaultListModel mod2 = new DefaultListModel();

    public void actualizarInfo() {
        desafiosList.setModel(mod);
        mod.clear();
        modificadoresList.setModel(mod2);
        mod2.clear();
        List<Desafio> desafios = this.almacen.getDesafiosSinValidar();
        int i = 0;
        while (i < desafios.size()) {
            Desafio element = desafios.get(i);
            String aux = element.getDesafiante().getNick();
            aux = aux + " -> " + element.getDesafiado().getNick();
            mod.addElement(aux);
            i += 1;
        }
        i = 0;
        List<Modificador> modificadores = this.almacen.getModificadores();
        while (i < modificadores.size()) {

            Modificador element = modificadores.get(i);
            String aux = element.getNombre();
            mod2.addElement(aux);
            i += 1;
        }
    }

    public int comprobarTipo(Usuario usuario, String nombreMod) {
        int valor = 0; // es 1 si es una debilidad, 2 si es una fortaleza y 0 si no está
        String persUsuario = usuario.getTipoPersonaje();
        if (persUsuario != null) {
            List<Personaje> personajes = almacen.getPersonajes();

            int i = 0;
            while (!personajes.get(i).getNombre().equals(persUsuario)) {
                i += 1;
            }
            Map<String, Integer> debilidades = personajes.get(i).getDebilidades();
            Map<String, Integer> fortalezas = personajes.get(i).getFortalezas();
            if (debilidades.containsKey(nombreMod)) {
                valor = 1;
            } else if (fortalezas.containsKey(nombreMod)) {
                valor = 2;
            } else {
                valor = 0;
            }
        }
        return valor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        desafiosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        modificadoresList = new javax.swing.JList<>();
        btnAñadirMod = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnValidar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(desafiosList);

        jScrollPane2.setViewportView(modificadoresList);

        btnAñadirMod.setText("Añadir");
        btnAñadirMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirModActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnValidar.setText("Validar");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista  modificadores");

        jLabel2.setText("Lista desafios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAñadirMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(221, Short.MAX_VALUE)
                        .addComponent(btnAñadirMod, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuOperador");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAñadirModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirModActionPerformed
        int ind = modificadoresList.getSelectedIndex();
        if (ind != -1) {
            mod2.remove(ind);// esto no se si funciona 
            this.modificadoresSelec.add(this.almacen.getModificadores().get(ind));

        } else {

            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un modificador");
        }
    }//GEN-LAST:event_btnAñadirModActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        int desafioIndex = desafiosList.getSelectedIndex();
        if (desafioIndex != -1) {
            //this.desafios.remove(this.desafioIndex);// esto tengo que comprovar que lo quita de todas las listas
            Desafio selected = this.almacen.getDesafiosSinValidar().get(desafioIndex);
            int i = 0;
            while (!this.modificadoresSelec.isEmpty()) {//para comprobar si se ha seleccionado algún modificador 
                Modificador modif = modificadoresSelec.get(i);
                int j = comprobarTipo(selected.getDesafiante(), modif.getNombre());
                if (j == 0) {
                    j = comprobarTipo(selected.getDesafiado(), modif.getNombre());
                }
                if (j == 1) {
                    selected.addDebilidad(modif);
                } else if (j == 2) {
                    selected.addFortaleza(modif);
                }
                modificadoresSelec.remove(i);
            }
            Notificacion noti = new Notificacion(selected);
            List<Usuario> usuarios = Almacen.getUsuarios();
            int locLista = buscarDesafiado(usuarios, selected.getDesafiado().getNick());
            if (locLista >= 0) {
                this.almacen.getUsuarios().get(locLista).addNotificacion(noti);
            } else {

                javax.swing.JOptionPane.showMessageDialog(this, "El desafiado ha borrado la cuenta");
            }
            this.almacen.getDesafiosSinValidar().remove(desafioIndex);

            //Actualizar ficheros
            try {
                this.almacen.updateFiles();
            } catch (IOException ex) {
                Logger.getLogger(ValidarDesafios.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.almacen.actualizarFicheroDesafios();
            } catch (IOException ex) {
                Logger.getLogger(ValidarDesafios.class.getName()).log(Level.SEVERE, null, ex);
            }
            //----------

            JPanel parent = (JPanel) getParent();
            CardLayout cl = (CardLayout) parent.getLayout();
            cl.show(parent, "menuOperador");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un desafio para validar");
        }
    }//GEN-LAST:event_btnValidarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirMod;
    private javax.swing.JButton btnValidar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JList<String> desafiosList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> modificadoresList;
    // End of variables declaration//GEN-END:variables

    private int buscarDesafiado(List<Usuario> usuarios, String nick) {
        int i = 0;
        while ((i < usuarios.size()) && (!nick.equals(usuarios.get(i).getNick()))) {
            i += 1;
        }
        if (i == usuarios.size()) {// en caso de que se haya borrado el usuario
            return -1;
        } else {
            return i;
        }
    }
}
