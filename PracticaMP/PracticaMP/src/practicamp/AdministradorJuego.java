package practicamp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
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

    public void show() {
        JLabel titulo = new JLabel("Bienvenido al juego");
        titulo.setForeground(Color.BLACK);
        titulo.setFont(TITULO_FONT);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        JButton registrarse = new JButton("Registrarse");
        registrarse.setForeground(Color.WHITE);
        registrarse.setBackground(new Color(34, 139, 34));
        registrarse.setFont(BOTON_FONT);
        registrarse.setPreferredSize(new Dimension(200, 50));
        registrarse.addActionListener(e -> {
            Registro registro = new Registro();
            registro.show();
        });
        
        JButton iniciarSesion = new JButton("Iniciar sesión");
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setBackground(new Color(30, 144, 255));
        iniciarSesion.setFont(BOTON_FONT);
        iniciarSesion.setPreferredSize(new Dimension(200, 50));
        iniciarSesion.addActionListener(e -> {
            InicioSesion inicioSesion = new InicioSesion();
            inicioSesion.show();
        });

        JButton salir = new JButton("Cerrar sistema");
        salir.setForeground(Color.WHITE);
        salir.setBackground(new Color(220, 20, 60));
        salir.setFont(BOTON_FONT);
        salir.setPreferredSize(new Dimension(200, 50));
        salir.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(FONDO);

        JPanel tituloPanel = new JPanel(new GridLayout(1, 1));
        tituloPanel.setBackground(Color.LIGHT_GRAY);
        tituloPanel.add(titulo);

        panel.add(tituloPanel);
        panel.add(registrarse);
        panel.add(iniciarSesion);
        panel.add(salir);
        
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        panel.setPreferredSize(new Dimension(bounds.width, bounds.height));

        JOptionPane.showOptionDialog(null, panel, "Administrador de Juego", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    }

    public void registrarse() {
        // TODO implement here
    }


    public void iniciar_sesion() {
        // TODO implement here
    }


    public void salir() {
        // TODO implement here
    }

}
