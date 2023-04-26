package practicamp;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class GestionEsbirros extends javax.swing.JPanel {
    private List<Esbirro> esbirros;
    private Stack<String> padres = new Stack<>();
    private Map<String, List<Esbirro>> subEsbirros;
    private String nombrePersonaje;
    private int nivel;
    private Esbirro esbirroSeleccionado;
                        
    public GestionEsbirros() {
        initComponents();
        
    }
    
    public void añadirInfo(String nombrePersonaje){
        this.nombrePersonaje = nombrePersonaje;
        this.nivel = 0;
        Lealdad[] lealdad = Lealdad.values();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); // Crear un modelo para el jComboBox1

        for (Lealdad opcion : lealdad) { // Agregar cada opción del enumerado al modelo
            modelo.addElement(opcion);
        }
        jComboBox1.setModel(modelo); // Asi
        
        this.subEsbirros = new HashMap<>();
        this.esbirros = new ArrayList<>();
        for (Personaje p : Almacen.getPersonajes()){
            if (p.getNombre().equals(nombrePersonaje)) {
                jList1.setModel(this.actualizarLista(p.getEsbirros()));
                this.esbirros = p.getEsbirros();
                this.subEsbirros.put(nombrePersonaje, esbirros);
                this.padres.add(nombrePersonaje);
            }
        }
        jComboBox2.setVisible(false);
        jComboBox1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField2.setVisible(false);
        jComboBox3.setVisible(false);
        jTextField4.setVisible(false);
        pacto.setVisible(false);
        regresar.setVisible(false);
        jTextField1.setText(nombrePersonaje);
        jTextField1.setEnabled(false);
    }
               
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        bntAgregarEsbirro = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        pacto = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();

        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel1.setLayout(null);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(6, 453, 72, 23);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(510, 450, 84, 20);

        jLabel1.setText("Gestion esbirros de");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 10, 110, 16);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(6, 34, 320, 332);

        bntAgregarEsbirro.setText("Agregar esbirro");
        bntAgregarEsbirro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarEsbirroActionPerformed(evt);
            }
        });
        jPanel1.add(bntAgregarEsbirro);
        bntAgregarEsbirro.setBounds(6, 384, 120, 23);

        btnEliminar.setText("Eliminar esbirro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(213, 384, 120, 23);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(331, 6, 206, 22);

        jLabel2.setText("Nombre esbirro:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(344, 37, 110, 16);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(450, 40, 150, 22);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel1.add(regresar);
        regresar.setBounds(500, 320, 100, 23);

        jLabel3.setText("Salud esbirro:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(344, 77, 86, 16);

        jLabel4.setText("Lealdad:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(344, 117, 104, 16);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(450, 110, 150, 22);

        jLabel5.setText("Dependencia:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(344, 157, 72, 16);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(450, 160, 150, 22);

        pacto.setText("Pacto:");
        jPanel1.add(pacto);
        pacto.setBounds(344, 194, 50, 16);

        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(340, 220, 260, 90);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(450, 70, 150, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        int index = jList1.getSelectedIndex();
        if (index != -1) {
            model.remove(index);
            List<Esbirro> esbirro = this.subEsbirros.get(padres.peek());
            esbirro.remove(index);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void bntAgregarEsbirroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarEsbirroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAgregarEsbirroActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {
            int index = jList1.getSelectedIndex();
            Esbirro esbirroSeleccionado = subEsbirros.get(padres.peek()).get(index);
            this.esbirroSeleccionado = esbirroSeleccionado;
            this.nivel +=1;
            if (esbirroSeleccionado instanceof Demonio){
                Demonio demonio = (Demonio) esbirroSeleccionado;
                padres.push(demonio.getNombre());
                jList1.setModel(this.actualizarLista(demonio.getEsbirros()));
                subEsbirros.put(demonio.getNombre(), demonio.getEsbirros());
                pacto.setVisible(true);
                jTextField4.setVisible(true);
                jTextField4.setText(demonio.getPacto());
            } else {
                jList1.setVisible(false);
                if (esbirroSeleccionado instanceof Humano){
                    Humano humano = (Humano) esbirroSeleccionado;
                    jComboBox1.setVisible(true);
                    jComboBox1.setSelectedItem(humano.getLealdad());
                    jLabel4.setVisible(true);
                } else {
                    Ghoul ghoul = (Ghoul) esbirroSeleccionado;
                    jComboBox2.setVisible(true);
                    jComboBox2.setSelectedItem(ghoul.getDependencia());
                    jLabel5.setVisible(true);
                }
            }
            jLabel2.setVisible(true);
            jTextField2.setVisible(true);
            jTextField2.setText(esbirroSeleccionado.getNombre());
            
            jLabel3.setVisible(true);
            jComboBox3.setVisible(true);
            int salud = esbirroSeleccionado.getSalud(); // obtiene el valor entero de la función getSalud()
            String saludStr = Integer.toString(salud); // convierte el valor entero a una cadena de texto
            jComboBox3.setSelectedItem(saludStr);
            
            regresar.setVisible(true);
        }        
    }//GEN-LAST:event_jList1MouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        if (!padres.isEmpty()) { // Verificar si la pila no está vacía
            String x = padres.peek(); // Obtener el último elemento de la pila
            this.actualizarLista(this.subEsbirros.get(x));
            jComboBox2.setVisible(false);
            jComboBox1.setVisible(false);
            jList1.setVisible(true);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            if (x.equals(this.nombrePersonaje)){
                regresar.setVisible(false);                
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jTextField2.setVisible(false);
                jComboBox3.setVisible(false);
                jTextField4.setVisible(false);
                pacto.setVisible(false);
                jList1.setModel(this.actualizarLista(this.esbirros));
            } else {
                this.nivel -=1;
                String j = padres.pop();
                String l = padres.peek();
                for (Esbirro esbirro : subEsbirros.get(l)){
                    if (j.equals(esbirro.getNombre())){
                        this.esbirroSeleccionado = esbirro;
                        regresar.setVisible(true);
                        jLabel2.setVisible(true);
                        jLabel3.setVisible(true);
                        jTextField2.setVisible(true);
                        jTextField2.setText(j);
                        jComboBox3.setVisible(true);
                        int salud = esbirro.getSalud(); // obtiene el valor entero de la función getSalud()
                        String saludStr = Integer.toString(salud); // convierte el valor entero a una cadena de texto
                        jComboBox3.setSelectedItem(saludStr);
                        Demonio demonio = (Demonio) esbirro;
                        jTextField4.setVisible(true);
                        jTextField4.setText(demonio.getPacto());
                        pacto.setVisible(true);
                        jList1.setModel(this.actualizarLista(demonio.getEsbirros()));
                    }
                
                
                }
            }        
        }
    }//GEN-LAST:event_regresarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Humano h = (Humano)this.esbirroSeleccionado;
        h.setLealdad((Lealdad) jComboBox1.getSelectedItem());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String seleccionStr = jComboBox3.getSelectedItem().toString();
        int seleccionNum = Integer.parseInt(seleccionStr);
        esbirroSeleccionado.setSalud(seleccionNum);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Ghoul g = (Ghoul) esbirroSeleccionado;
        String seleccionStr = jComboBox2.getSelectedItem().toString();
        int seleccionNum = Integer.parseInt(seleccionStr);
        g.setDependencia(seleccionNum);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        Demonio d = (Demonio) esbirroSeleccionado;
        d.setPacto(jTextField4.getText()); 
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        esbirroSeleccionado.setNombre(jTextField2.getText());
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregarEsbirro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel pacto;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel<String> actualizarLista(List<Esbirro> esbirros) {
        DefaultListModel<String> itemsVector = new DefaultListModel<>();
        if(esbirros != null && !esbirros.isEmpty()){
            for (Esbirro esbirro : esbirros) {
                if (esbirro instanceof Humano) {
                    Humano humano = (Humano) esbirro;
                    itemsVector.addElement(humano.getNombre() + ": salud = " + humano.getSalud() + "/ tipo = Humano");
                } else if (esbirro instanceof Demonio) {
                    Demonio demonio = (Demonio) esbirro;
                    itemsVector.addElement(demonio.getNombre() + ": salud = " + demonio.getSalud() + "/ tipo = Demonio");
                } else {
                    Ghoul ghoul = (Ghoul) esbirro;
                    itemsVector.addElement(ghoul.getNombre() + ": salud = " + ghoul.getSalud() + "/ tipo = Ghoul");
                }
            }
        }
        return itemsVector;
    }

    public List<Esbirro> getEsbirros() {
        return this.subEsbirros.get(this.nombrePersonaje);
    }
}