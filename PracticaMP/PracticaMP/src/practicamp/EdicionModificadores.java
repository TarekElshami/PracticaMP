package practicamp;

import java.awt.CardLayout;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EdicionModificadores extends javax.swing.JPanel {

    private List<Modificador> modificadores;
    private Map<String, Integer> debilidades;
    private Map<String, Integer> fortalezas;
    private Personaje personaje;

    public EdicionModificadores() {
        initComponents();
        modificadores = Almacen.getModificadores();
        
    }
    public void cargarPersonaje(String nombrePersonaje){
        for (Personaje p : Almacen.getPersonajes()) {
            if (p.getNombre().equals(nombrePersonaje)) {
                debilidades = p.getFortalezas();
                fortalezas = p.getDebilidades();
                jComboBox1.setSelectedItem(p.getSalud());
                jComboBox1.setSelectedItem(p.getPoder());
                personaje = p;
            }
        }
        actualizarListas();
    }
    private void actualizarListas() {
        DefaultListModel<String> itemsVector1 = new DefaultListModel<>();
        DefaultListModel<String> itemsVector2 = new DefaultListModel<>();
        for (Modificador modificador : modificadores) {
            if (debilidades.containsKey(modificador.getNombre())) {
                itemsVector1.addElement("<html><font color='green'>" + modificador.getNombre() + " " +debilidades.get(modificador.getNombre()) + "</font></html>");
                itemsVector2.addElement("<html><font color='red'>" + modificador.getNombre() + "</font></html>");
            }
            else if (fortalezas.containsKey(modificador.getNombre())) {
                itemsVector1.addElement("<html><font color='red'>" + modificador.getNombre() + "</font></html>");
                itemsVector2.addElement("<html><font color='green'>" + modificador.getNombre() + " " +fortalezas.get(modificador.getNombre()) +"</font></html>");
            } else {
                itemsVector1.addElement(modificador.getNombre());
                itemsVector2.addElement(modificador.getNombre());
            }            
        }
        jList1.setModel(itemsVector1);
        jList2.setModel(itemsVector2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setLayout(null);

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(17, 57, 306, 326);

        jLabel1.setText("Debilidades");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(17, 35, 306, 16);

        jLabel2.setText("Fortalezas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(323, 35, 306, 16);

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(323, 57, 306, 326);

        jLabel3.setText("Salud");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(23, 414, 29, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(59, 411, 72, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(243, 411, 72, 22);

        jLabel4.setText("Poder");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(206, 414, 31, 16);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(363, 411, 64, 22);

        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(327, 414, 29, 16);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(6, 445, 100, 23);

        jButton2.setText("Confirmar");
        jPanel1.add(jButton2);
        jButton2.setBounds(530, 445, 100, 23);

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

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String valorSeleccionado = (String) jComboBox1.getSelectedItem();
        int valorNumerico = Integer.parseInt(valorSeleccionado);
        personaje.setPoder(valorNumerico);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String valorSeleccionado = (String) jComboBox1.getSelectedItem();
        int valorNumerico = Integer.parseInt(valorSeleccionado);
        personaje.setSalud(valorNumerico);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String elementoSeleccionado = (String) jList1.getSelectedValue();
        if (elementoSeleccionado.contains("red")) {
            JOptionPane.showMessageDialog(null, "Este elemento ya está seleccionado");
        } else {
            String valorIntroducido = null;
            int valorNumerico = 0;
            boolean quitarModificador = false;

            if (elementoSeleccionado.contains("green")) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea quitar el modificador?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    quitarModificador = true;
                } else {
                    valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado.replace("<html><font color='green'>", "").replace("</font></html>", ""));
                    try {
                        int numero = Integer.parseInt(valorIntroducido);
                        valorNumerico = numero; // asignar el valor numérico a la variable
                        System.out.println("El número introducido es: " + numero);
                    } catch (NumberFormatException e) {
                        System.out.println("La entrada no es un número entero válido.");
                    }
                }
            } else {
                valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado);
                try {
                    int numero = Integer.parseInt(valorIntroducido);
                    valorNumerico = numero; // asignar el valor numérico a la variable
                    System.out.println("El número introducido es: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("La entrada no es un número entero válido.");
                }
            }

            if (quitarModificador) {
                int indiceSeleccionado = jList1.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                debilidades.remove(nombreModificador);
            } else if (valorNumerico >= 1 && valorNumerico <= 5) {
                int indiceSeleccionado = jList1.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                debilidades.put(nombreModificador, valorNumerico);
            } else {
                JOptionPane.showMessageDialog(null, "El valor introducido debe estar entre 1 y 5");
            }

            this.actualizarListas();
        }
    
    }//GEN-LAST:event_jList1MouseClicked

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        String elementoSeleccionado = (String) jList2.getSelectedValue();
        if (elementoSeleccionado.contains("red")) {
            JOptionPane.showMessageDialog(null, "Este elemento ya está seleccionado");
        } else {
            String valorIntroducido = null;
            int valorNumerico = 0;
            boolean quitarModificador = false;

            if (elementoSeleccionado.contains("green")) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea quitar el modificador?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    quitarModificador = true;
                } else {
                    valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado.replace("<html><font color='green'>", "").replace("</font></html>", ""));
                    try {
                        int numero = Integer.parseInt(valorIntroducido);
                        valorNumerico = numero; // asignar el valor numérico a la variable
                        System.out.println("El número introducido es: " + numero);
                    } catch (NumberFormatException e) {
                        System.out.println("La entrada no es un número entero válido.");
                    }
                }
            } else {
                valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado);
                try {
                    int numero = Integer.parseInt(valorIntroducido);
                    valorNumerico = numero; // asignar el valor numérico a la variable
                    System.out.println("El número introducido es: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("La entrada no es un número entero válido.");
                }
            }

            if (quitarModificador) {
                int indiceSeleccionado = jList2.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                fortalezas.remove(nombreModificador);
            } else if (valorNumerico >= 1 && valorNumerico <= 5) {
                int indiceSeleccionado = jList2.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                fortalezas.put(nombreModificador, valorNumerico);
            } else {
                JOptionPane.showMessageDialog(null, "El valor introducido debe estar entre 1 y 5");
            }

            this.actualizarListas();
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
