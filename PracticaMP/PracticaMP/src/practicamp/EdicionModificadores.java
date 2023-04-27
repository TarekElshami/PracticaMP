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
                opSalud.setSelectedItem(p.getSalud());
                opSalud.setSelectedItem(p.getPoder());
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
        debilidadesList.setModel(itemsVector1);
        fortalezasList.setModel(itemsVector2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        debilidadesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        fortalezasList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        opSalud = new javax.swing.JComboBox<>();
        opPoder = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        opEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        jPanel1.setLayout(null);

        debilidadesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                debilidadesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(debilidadesList);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(17, 57, 306, 326);

        jLabel1.setText("Debilidades");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(17, 35, 306, 16);

        jLabel2.setText("Fortalezas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(323, 35, 306, 16);

        fortalezasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fortalezasListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(fortalezasList);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(323, 57, 306, 326);

        jLabel3.setText("Salud:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(23, 414, 60, 16);

        opSalud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        opSalud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opSaludActionPerformed(evt);
            }
        });
        jPanel1.add(opSalud);
        opSalud.setBounds(90, 410, 72, 22);

        opPoder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        opPoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opPoderActionPerformed(evt);
            }
        });
        jPanel1.add(opPoder);
        opPoder.setBounds(243, 411, 72, 22);

        jLabel4.setText("Poder:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(197, 414, 40, 16);

        opEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opEdadActionPerformed(evt);
            }
        });
        jPanel1.add(opEdad);
        opEdad.setBounds(390, 410, 64, 22);

        jLabel5.setText("Edad:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 420, 50, 16);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(6, 445, 100, 23);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(530, 445, 100, 23);

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

    private void opPoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opPoderActionPerformed
        String valorSeleccionado = (String) opSalud.getSelectedItem();
        int valorNumerico = Integer.parseInt(valorSeleccionado);
        personaje.setPoder(valorNumerico);
    }//GEN-LAST:event_opPoderActionPerformed

    private void opSaludActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opSaludActionPerformed
        String valorSeleccionado = (String) opSalud.getSelectedItem();
        int valorNumerico = Integer.parseInt(valorSeleccionado);
        personaje.setSalud(valorNumerico);
    }//GEN-LAST:event_opSaludActionPerformed

    private void debilidadesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_debilidadesListMouseClicked
        String elementoSeleccionado = (String) debilidadesList.getSelectedValue();
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
                int indiceSeleccionado = debilidadesList.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                debilidades.remove(nombreModificador);
            } else if (valorNumerico >= 1 && valorNumerico <= 5) {
                int indiceSeleccionado = debilidadesList.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                debilidades.put(nombreModificador, valorNumerico);
            } else {
                JOptionPane.showMessageDialog(null, "El valor introducido debe estar entre 1 y 5");
            }

            this.actualizarListas();
        }
    
    }//GEN-LAST:event_debilidadesListMouseClicked

    private void fortalezasListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fortalezasListMouseClicked
        String elementoSeleccionado = (String) fortalezasList.getSelectedValue();
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
                int indiceSeleccionado = fortalezasList.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                fortalezas.remove(nombreModificador);
            } else if (valorNumerico >= 1 && valorNumerico <= 5) {
                int indiceSeleccionado = fortalezasList.getSelectedIndex();
                Modificador modificador = modificadores.get(indiceSeleccionado);
                String nombreModificador = modificador.getNombre();
                fortalezas.put(nombreModificador, valorNumerico);
            } else {
                JOptionPane.showMessageDialog(null, "El valor introducido debe estar entre 1 y 5");
            }

            this.actualizarListas();
        }
    }//GEN-LAST:event_fortalezasListMouseClicked

    private void opEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opEdadActionPerformed
        
    }//GEN-LAST:event_opEdadActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int i = 0;
        while (i < Almacen.getPersonajes().size() && Almacen.getPersonajes().get(i).getNombre().equals(this.personaje.getNombre())){
            i += 1;
        }
        Almacen.getPersonajes().get(i).setDebilidades(this.debilidades);
        Almacen.getPersonajes().get(i).setFortalezas(this.fortalezas);
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JList<String> debilidadesList;
    private javax.swing.JList<String> fortalezasList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField opEdad;
    private javax.swing.JComboBox<String> opPoder;
    private javax.swing.JComboBox<String> opSalud;
    // End of variables declaration//GEN-END:variables
    
}
