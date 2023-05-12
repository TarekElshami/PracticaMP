package practicamp;

import java.awt.CardLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        // Crear un arreglo de números del 1 al 5
        Integer[] numeros = {1, 2, 3, 4, 5};

        opSalud.addItem(0);
        // Agregar los números al JComboBox opSalud
        for (Integer num : numeros) {
            opSalud.addItem(num);
        }

        // Agregar los números al JComboBox opPoder
        for (Integer num : numeros) {
            opPoder.addItem(num);
        }

    }
    public void cargarPersonaje(String nombrePersonaje){
        for (Personaje p : Almacen.getPersonajes()) {
            if (p.getNombre().equals(nombrePersonaje)) {
                debilidades = p.getFortalezas();
                fortalezas = p.getDebilidades();
                personaje = p;
                opSalud.setSelectedItem(Integer.valueOf(personaje.getSalud()));
                opPoder.setSelectedItem(Integer.valueOf(personaje.getPoder()));
                if (!p.getNombre().equals("Vampiro")){
                    textEdad.setVisible(false);
                    etiqEdad.setVisible(false);
                } else {
                    if (p instanceof Vampiro) {
                        Vampiro vampiro = (Vampiro) p;
                        int edad = vampiro.getEdad();
                        textEdad.setText(String.valueOf(edad));
                    }
                            
                }
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
        jLabel4 = new javax.swing.JLabel();
        textEdad = new javax.swing.JTextField();
        etiqEdad = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        opSalud = new javax.swing.JComboBox<>();
        opPoder = new javax.swing.JComboBox<>();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        debilidadesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                debilidadesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(debilidadesList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 57, 306, 326));

        jLabel1.setText("Debilidades");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 35, 306, -1));

        jLabel2.setText("Fortalezas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 35, 306, -1));

        fortalezasList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fortalezasListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(fortalezasList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 57, 306, 326));

        jLabel3.setText("Salud:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 48, 22));

        jLabel4.setText("Poder:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 40, 22));

        textEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEdadActionPerformed(evt);
            }
        });
        jPanel1.add(textEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 110, -1));

        etiqEdad.setText("Edad:");
        jPanel1.add(etiqEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 50, 22));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 445, 100, -1));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 445, 100, -1));

        jPanel1.add(opSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 90, -1));

        opPoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opPoderActionPerformed(evt);
            }
        });
        jPanel1.add(opPoder, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 90, -1));

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
                    } catch (NumberFormatException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "La entrada no es un número entero válido.");
                    }
                }
            } else {
                valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado);
                try {
                    int numero = Integer.parseInt(valorIntroducido);
                    valorNumerico = numero; // asignar el valor numérico a la variable
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La entrada no es un número entero válido.");
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
                    } catch (NumberFormatException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "La entrada no es un número entero válido.");
                    }
                }
            } else {
                valorIntroducido = JOptionPane.showInputDialog("Introduce un valor para " + elementoSeleccionado);
                try {
                    int numero = Integer.parseInt(valorIntroducido);
                    valorNumerico = numero; // asignar el valor numérico a la variable
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La entrada no es un número entero válido.");
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

    private void textEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEdadActionPerformed
        
    }//GEN-LAST:event_textEdadActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int i = 0;
        while (i < Almacen.getPersonajes().size() && !Almacen.getPersonajes().get(i).equals(this.personaje)) {
            i++;
        }
        if (i < Almacen.getPersonajes().size()) {
            // Se encontró el personaje en la lista, actualizarlo
            Personaje pers = Almacen.getPersonajes().get(i);
            pers.setSalud(Integer.parseInt(opSalud.getSelectedItem().toString()));
            pers.setPoder(Integer.parseInt(opPoder.getSelectedItem().toString()));
            pers.setFortalezas(fortalezas);
            pers.setDebilidades(debilidades);

            if (!textEdad.getText().equals("")) {
                try {
                    int nuevaEdad = Integer.parseInt(textEdad.getText());
                    if (pers instanceof Vampiro) {
                        ((Vampiro) pers).setEdad(nuevaEdad);
                    }
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "La edad tiene que ser un número entero");
                }
            }
        } else {
            // No se encontró el personaje en la lista
            System.err.println("No se encontró el personaje en la lista");
        }

// Código adicional para guardar los cambios en el archivo
// (sin eliminar el archivo existente)
        try {
            FileOutputStream fileOut = new FileOutputStream("personajes.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(Almacen.getPersonajes());
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

// Código adicional para cambiar al panel de edición del menú principal
        JPanel parent = (JPanel) getParent();
        CardLayout cl = (CardLayout) parent.getLayout();
        cl.show(parent, "menuEditarPersonaje");

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void opPoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opPoderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opPoderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JList<String> debilidadesList;
    private javax.swing.JLabel etiqEdad;
    private javax.swing.JList<String> fortalezasList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<Integer> opPoder;
    private javax.swing.JComboBox<Integer> opSalud;
    private javax.swing.JTextField textEdad;
    // End of variables declaration//GEN-END:variables
    
}
