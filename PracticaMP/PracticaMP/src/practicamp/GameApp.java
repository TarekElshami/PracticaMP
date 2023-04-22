package practicamp;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Blas
 */
public class GameApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        AdministradorJuego admin = new AdministradorJuego();
        admin.showGame();
    }
    
}
