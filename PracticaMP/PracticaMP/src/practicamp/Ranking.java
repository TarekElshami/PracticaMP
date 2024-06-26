package practicamp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;



public class Ranking {
    private static LinkedList<Jugador> listaJugadores;
    
    public Ranking() throws IOException, FileNotFoundException, ClassNotFoundException {
        this.loadUsers();
    }
    
    private void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        File rankingDB = new File("src/files/db/ranking.db");
        if (!rankingDB.exists()) {
            updateFiles();
        } else {
            updateRanking();
        }
    }

    private static void updateFiles() throws FileNotFoundException, IOException {
        FileOutputStream usersFile = new FileOutputStream("src/files/db/ranking.db");
        ObjectOutputStream output = new ObjectOutputStream(usersFile);

        output.writeObject(Ranking.listaJugadores);
        output.close();
        if (Ranking.listaJugadores == null) {
            Ranking.listaJugadores = new LinkedList<>();
        }
    }

    private void updateRanking() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream usersFile = new FileInputStream("src/files/db/ranking.db");
        ObjectInputStream input = new ObjectInputStream(usersFile);
        Ranking.listaJugadores = (LinkedList<Jugador>) input.readObject();
        if (Ranking.listaJugadores == null) {
            Ranking.listaJugadores = new LinkedList<>();
        }
        input.close();
    }
    public static void agregarJugador(Jugador jugador) throws IOException {
        int index = 0;
        int indexPos = 0;
        for (Jugador j : listaJugadores) {
            if(j.getNombre().equals(jugador.getNombre())){
                listaJugadores.remove(index);
            }
            if (jugador.getVictorias() < j.getVictorias()) {
                indexPos++;
            }
            index++;
        }
        listaJugadores.add(indexPos, jugador);
        if (listaJugadores.size() > 10) {
            listaJugadores.removeLast();
        }
        Ranking.updateFiles();
    }
    
    public static LinkedList<Jugador> getRanking(){
        return Ranking.listaJugadores;
    }

    public static void setListaJugadores(LinkedList<Jugador> listaJugadores) {
        Ranking.listaJugadores = listaJugadores;
    }

}