package practicamp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Personaje implements Serializable, ActionListener {
    
    JButton btnPersonaje, btnArmas, btnArmadura, btnInventario, btnEsbirro;

    private String nombre;
    private int salud;
    private int poder;
    private Habilidad habilidad;
    private List<Arma> armas;
    private List<Arma> armaActiva;
    private List<Armadura> armaduras;
    private Armadura armaduraActiva;
    private List<Esbirro> esbirros;
    private List<Modificador> debilidades;
    private List<Modificador> fortalezas;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.salud = 5;
        this.armaActiva = new ArrayList<>();
        this.armaduraActiva = null;
        this.armas = new ArrayList<>();
        this.armaduras = new ArrayList<>();
        this.habilidad = null;
        this.esbirros = new ArrayList<>();
        this.debilidades = new ArrayList<>();
        this.fortalezas = new ArrayList<>();
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    
    public void show(Rol rol) {
        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null); // Desactivar el layout manager
        panelBotones.setOpaque(false); // Hacer el panel transparente
        panelBotones.setBounds(0, 0, 640, 480); // Establecer las dimensiones y la posición del panel de botones

        btnArmas = new JButton("Armas");
        btnArmas.addActionListener(this);
        btnArmas.setBounds(282, 305, 100, 30); // Establecer las dimensiones y la posición del botón de "Armas"
        panelBotones.add(btnArmas);

        btnArmadura = new JButton("Armadura");
        btnArmadura.addActionListener(this);
        btnArmadura.setBounds(126, 293, 100, 30); // Establecer las dimensiones y la posición del botón de "Armadura"
        panelBotones.add(btnArmadura);
        
        if (rol == Rol.admin){
            // Crear botones y añadirlos al panel
            btnPersonaje = new JButton("Personaje");
            btnPersonaje.addActionListener(this);
            btnPersonaje.setBounds(212, 214, 100, 30); // Establecer las dimensiones y la posición del botón de "Personaje"
            panelBotones.add(btnPersonaje);

            btnInventario = new JButton("Inventario");
            btnInventario.addActionListener(this);
            btnInventario.setBounds(112, 256, 100, 30); // Establecer las dimensiones y la posición del botón de "Inventario"
            panelBotones.add(btnInventario);

            btnEsbirro = new JButton("Esbirro");
            btnEsbirro.addActionListener(this);
            btnEsbirro.setBounds(438, 387, 100, 30); // Establecer las dimensiones y la posición del botón de "Esbirro"
            panelBotones.add(btnEsbirro);
        }
        // Añadir panel de botones a un contenedor
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);
        contentPane.add(panelBotones);

        // Añadir imagen de fondo al contenedor
        ImageIcon imagenFondo = new ImageIcon("personaje3.png");
        JLabel etiquetaFondo = new JLabel(imagenFondo);
        etiquetaFondo.setBounds(0, 0, 640, 480); // Establecer las dimensiones y la posición de la imagen de fondo
        contentPane.add(etiquetaFondo, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void agregarArma(Arma arma) {
        this.armas.add(arma);
    }

    public void eliminarArma(Arma arma) {
        this.armas.remove(arma);
    }

    public void activarArma(Arma arma) {
        if (armaActiva.size() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes dos armas de una mano, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de dos manos, no puedes equipar más armas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 2) {
            JOptionPane.showMessageDialog(null, "Ya tienes equipada un arma de una manos, no puedes equipar uno de dos manos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (armaActiva.size() == 1 && armaActiva.get(0).getManos() == 1 && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el segunda arma", "Exito", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 2) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado un arma de dos manos", "Exito", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (armaActiva.isEmpty() && arma.getManos() == 1) {
            armaActiva.add(arma);
            JOptionPane.showMessageDialog(null, "Has equipado el primera arma", "Exito", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarArmadura(Armadura armadura) {
        this.armaduras.add(armadura);
    }

    public void eliminarArmadura(Armadura armadura) {
        this.armaduras.remove(armadura);
    }

    public void activarArmadura(Armadura armadura) {
        this.armaduraActiva = armadura;
    }

    public void agregarEsbirro(Esbirro esbirro) {
        this.esbirros.add(esbirro);
    }

    public void eliminarEsbirro(Esbirro esbirro) {
        this.esbirros.remove(esbirro);
    }

    public void agregarDebilidad(Modificador debilidad) {
        this.debilidades.add(debilidad);
    }

    public void eliminarDebilidad(Modificador debilidad) {
        this.debilidades.remove(debilidad);
    }

    public void agregarFortaleza(Modificador fortaleza) {
        this.fortalezas.add(fortaleza);
    }

    public void eliminarFortaleza(Modificador fortaleza) {
        this.fortalezas.remove(fortaleza);
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    
}