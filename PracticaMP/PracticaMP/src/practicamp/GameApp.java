package practicamp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameApp {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        AdministradorJuego admin = new AdministradorJuego();
        admin.show();
        /*List<Modificador> modificadores = new ArrayList<>();
        modificadores.add(new Modificador("Plata"));
        modificadores.add(new Modificador("Control mental"));
        modificadores.add(new Modificador("Fuego"));
        modificadores.add(new Modificador("Ausencia de luna llena"));
        modificadores.add(new Modificador("Transformacion en lobo"));
        modificadores.add(new Modificador("Fuerza sobrehumana"));
        modificadores.add(new Modificador("Agilidad"));
        modificadores.add(new Modificador("Sentidos agudizados"));
        modificadores.add(new Modificador("Noche"));
        modificadores.add(new Modificador("Habilidad con armas"));
        modificadores.add(new Modificador("Entrenamiento en combate"));
        modificadores.add(new Modificador("Conocimiento de ocultismo"));
        modificadores.add(new Modificador("Sigilo"));
        modificadores.add(new Modificador("Resistencia fisica"));
        modificadores.add(new Modificador("La luz solar"));
        modificadores.add(new Modificador("Estacas de madera"));
        modificadores.add(new Modificador("Falta de sangre"));
        modificadores.add(new Modificador("Velocidad"));
        modificadores.add(new Modificador("Regeneracion rapida"));
        modificadores.add(new Modificador("Sentidos agudizados"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("modificadores.dat"));
        for (Modificador m : modificadores) {
            oos.writeObject(m);
        }
        oos.close();
        Almacen a = new Almacen();
        List<Modificador> m = a.getModificadores();
        for (Modificador mod : m) {
            System.out.println(mod.getNombre());
        }
        */
    }
}
