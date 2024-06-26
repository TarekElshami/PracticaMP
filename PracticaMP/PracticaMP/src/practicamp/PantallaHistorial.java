/*
 */
package practicamp;

import java.awt.CardLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author blase
 */
public class PantallaHistorial extends javax.swing.JPanel {

    /**
     * Creates new form PantallaHistorial
     */
    public PantallaHistorial() {
        initComponents();
        areaTextoHistorial.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        area = new javax.swing.JScrollPane();
        areaTextoHistorial = new javax.swing.JTextArea();
        botonVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaHistoriales = new javax.swing.JList<>();

        setPreferredSize(new java.awt.Dimension(640, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        areaTextoHistorial.setEditable(false);
        areaTextoHistorial.setColumns(20);
        areaTextoHistorial.setRows(5);
        area.setViewportView(areaTextoHistorial);

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        listaHistoriales.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaHistorialesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaHistoriales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonVolver)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(botonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        AdministradorJuego admin = (AdministradorJuego) getParent().getParent().getParent().getParent();
        Almacen almacen = admin.getAlmacen();
        try {
            almacen.updateUsers();
        } catch (IOException ex) {
            Logger.getLogger(PantallaHistorial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PantallaHistorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario currentUser = almacen.getUsuarioActivo();
        List<Desafio> historiales = currentUser.getHistorial();
        DefaultListModel dlm = new DefaultListModel();
        Iterator it = historiales.iterator();
        while (it.hasNext()) {
            Desafio desafio = (Desafio) it.next();
            dlm.addElement(desafio.getDesafiante().getNick() + " ( " + desafio.getDesafiante().getTipoPersonaje() + " ) -> " + desafio.getDesafiado().getNick() +" ( " + desafio.getDesafiado().getTipoPersonaje() + " )");
        }
        listaHistoriales.setSelectedIndex(0);
        listaHistoriales.setModel(dlm);
    }//GEN-LAST:event_formComponentShown

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuUsuario");
    }//GEN-LAST:event_botonVolverActionPerformed

    private void listaHistorialesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaHistorialesValueChanged
        areaTextoHistorial.setText("");
        if (!listaHistoriales.isSelectionEmpty()) {
            AdministradorJuego admin = (AdministradorJuego) getParent().getParent().getParent().getParent();
            Almacen almacen = admin.getAlmacen();
            Usuario currentUser = Almacen.getUsuarioActivo();
            List<Desafio> historiales = currentUser.getHistorial();
            List<String> currentHistory = historiales.get(listaHistoriales.getSelectedIndex()).getHistorial();
            Iterator it = currentHistory.iterator();
            while (it.hasNext()) {
                String textoHistorial = (String) it.next();
                areaTextoHistorial.append(textoHistorial);
            }
        }
    }//GEN-LAST:event_listaHistorialesValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JScrollPane area;
    javax.swing.JTextArea areaTextoHistorial;
    javax.swing.JButton botonVolver;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JList<String> listaHistoriales;
    // End of variables declaration//GEN-END:variables
}
