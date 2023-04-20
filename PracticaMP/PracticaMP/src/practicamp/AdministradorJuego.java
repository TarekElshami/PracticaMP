package practicamp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdministradorJuego {

    private Almacen almacen;
    private static final Color FONDO = Color.WHITE;
    private static final Color VERDE = Color.GREEN;
    private static final Color AZUL = Color.BLUE;
    private static final Color ROJO = Color.RED;
    private static final Font TITULO_FONT = new Font("Arial", Font.BOLD, 24);
    private static final Font BOTON_FONT = new Font("Arial", Font.PLAIN, 16);

    public AdministradorJuego() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.almacen = new Almacen();
    }

    public void show() {
        JPanel panel = crearPanel();
        mostrarPanel(panel);
    }

    private JPanel crearPanel() {
        JLabel titulo = crearTitulo();
        JButton registrarse = crearBoton("Registrarse", VERDE, e -> registrarse());
        JButton iniciarSesion = crearBoton("Iniciar sesión", AZUL, e -> iniciar_sesion());
        JButton salir = crearBoton("Cerrar sistema", ROJO, e -> salir());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(FONDO);
        panel.add(crearTituloPanel(titulo));
        panel.add(registrarse);
        panel.add(iniciarSesion);
        panel.add(salir);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        panel.setPreferredSize(screenSize);

        return panel;
    }

    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("Bienvenido al juego");
        titulo.setForeground(Color.BLACK);
        titulo.setFont(TITULO_FONT);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        return titulo;
    }

    private JPanel crearTituloPanel(JLabel titulo) {
        JPanel tituloPanel = new JPanel(new GridLayout(1, 1));
        tituloPanel.setBackground(Color.LIGHT_GRAY);
        tituloPanel.add(titulo);
        return tituloPanel;
    }

    private JButton crearBoton(String texto, Color color, ActionListener listener) {
        JButton boton = new JButton(texto);
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFont(BOTON_FONT);
        boton.setPreferredSize(new Dimension(200, 50));
        boton.addActionListener(listener);
        return boton;
    }

    private void mostrarPanel(JPanel panel) {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        JOptionPane.showOptionDialog(
                null,
                panel,
                "Administrador de Juego",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{},
                null
        );
    }

    public void registrarse() {
        Registro registro = new Registro();
        registro.show();
    }

    public void iniciar_sesion() {
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.show();
    }

    public void salir() {
        System.exit(0);
    }

}
