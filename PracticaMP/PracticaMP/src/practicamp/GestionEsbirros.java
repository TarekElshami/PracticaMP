package practicamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class GestionEsbirros extends javax.swing.JPanel {
    private List<Esbirro> esbirros;
    private Stack<String> padre = new Stack<>();
    private Map<String, List<Esbirro>> subEsbirros;
    private String nombrePersonaje;
                        
    public GestionEsbirros(String nombrePersonaje) {
        initComponents();
        this.nombrePersonaje = nombrePersonaje;
        
        Lealdad[] lealdad = Lealdad.values();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); // Crear un modelo para el jComboBox1

        for (Lealdad opcion : lealdad) { // Agregar cada opción del enumerado al modelo
            modelo.addElement(opcion);
        }
        jComboBox1.setModel(modelo); // Asi

        Integer[] numeros = {1, 2, 3, 4, 5}; // Crear un arreglo de enteros con los valores del 1 al 5
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(); // Crear un modelo para el jComboBox2

        for (Integer numero : numeros) { // Agregar cada valor del arreglo al modelo
            modelo2.addElement(numero);
        }
        jComboBox2.setModel(modelo2);
        
        this.subEsbirros = new HashMap<>();
        this.esbirros = new ArrayList<>();
        for (Personaje p : Almacen.getPersonajes()){
            if (p.getNombre().equals(nombrePersonaje)) {
                jList1.setModel(this.actualizarLista(p.getEsbirros()));
                this.esbirros = p.getEsbirros();
                this.subEsbirros.put(nombrePersonaje, esbirros);
                this.padre.add(nombrePersonaje);
            }
        }
        jComboBox2.setVisible(false);
        jComboBox1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        pacto.setVisible(false);
        regresar.setVisible(false);
        jTextField1.setText(nombrePersonaje);
    }
               
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        pacto = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel1.setLayout(null);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(6, 453, 72, 22);

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

        jButton3.setText("Agregar esbirro");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(6, 384, 120, 22);

        btnEliminar.setText("Eliminar esbirro");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(213, 384, 120, 22);

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
        jPanel1.add(jTextField2);
        jTextField2.setBounds(454, 34, 150, 22);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        jPanel1.add(regresar);
        regresar.setBounds(500, 320, 100, 22);

        jLabel3.setText("Salud esbirro:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(344, 77, 86, 16);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(454, 74, 150, 22);

        jLabel4.setText("Lealdad ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(344, 117, 104, 16);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(454, 114, 150, 22);

        jLabel5.setText("Dependencia");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(344, 157, 69, 16);

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(454, 154, 150, 22);

        pacto.setText("Pacto");
        jPanel1.add(pacto);
        pacto.setBounds(344, 194, 50, 16);

        jTextField4.setText("jTextField4");
        jPanel1.add(jTextField4);
        jTextField4.setBounds(340, 220, 260, 90);

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
            List<Esbirro> esbirro = this.subEsbirros.get(padre.peek());
            esbirro.remove(index);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {
            int index = jList1.getSelectedIndex();
            Esbirro esbirroSeleccionado = subEsbirros.get(padre.peek()).get(index);
            if (esbirroSeleccionado instanceof Demonio){
                Demonio demonio = (Demonio) esbirroSeleccionado;
                padre.push(demonio.getNombre());
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
            jTextField3.setVisible(true);
            int salud = esbirroSeleccionado.getSalud(); // obtiene el valor entero de la función getSalud()
            String saludStr = Integer.toString(salud); // convierte el valor entero a una cadena de texto
            jTextField3.setText(saludStr);
            
            regresar.setVisible(true);
        }        
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        if (!padre.isEmpty()) { // Verificar si la pila no está vacía
            String x = padre.peek(); // Obtener el último elemento de la pila
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
                jTextField3.setVisible(false);
                jTextField4.setVisible(false);
                pacto.setVisible(false);
                jList1.setModel(this.actualizarLista(this.esbirros));
            } else {
                String j = padre.pop();
                String l = padre.peek();
                for (Esbirro esbirro : subEsbirros.get(l)){
                    if (j.equals(esbirro.getNombre())){
                        regresar.setVisible(true);
                        jLabel2.setVisible(true);
                        jLabel3.setVisible(true);
                        jTextField2.setVisible(true);
                        jTextField2.setText(j);
                        jTextField3.setVisible(true);
                        int salud = esbirro.getSalud(); // obtiene el valor entero de la función getSalud()
                        String saludStr = Integer.toString(salud); // convierte el valor entero a una cadena de texto
                        jTextField3.setText(saludStr);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JTextField jTextField3;
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
                    itemsVector.addElement(ghoul.getNombre() + ": salud = " + ghoul.getSalud() + "/ tipo = Ghoul / Dependencia ");
                }
            }
        }
        return itemsVector;
    }

    public List<Esbirro> getEsbirros() {
        return this.subEsbirros.get(this.nombrePersonaje);
    }

}

