package practicamp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameApp {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        /*AdministradorJuego admin = new AdministradorJuego();
        admin.show();*/
        
        
        List<Modificador> modificadores = new ArrayList<>();
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
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("modificadores.dat"));
            oos.writeObject(modificadores);
            oos.close();
            System.out.println("Modificadores guardados en el archivo modificadores.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Almacen a = new Almacen();
        List<Modificador> m = a.getModificadores();
        for (Modificador mod : m) {
            System.out.println(mod.getNombre());
        }
        
        
        /*List<Armadura> armaduras = new ArrayList<>();

        armaduras.add(new Armadura("Chaleco de cuero", 1, 0));
        armaduras.add(new Armadura("Armadura de malla", 2, 0));
        armaduras.add(new Armadura("Armadura de placa", 3, 0));
        armaduras.add(new Armadura("Armadura de cazador", 2, 1));
        armaduras.add(new Armadura("Armadura de cuero reforzado", 2, 0));
        
        armaduras.add(new Armadura("Tunica de cuero oscuro", 1, 0));
        armaduras.add(new Armadura("Armadura de piel de murcielago", 2, 0));
        armaduras.add(new Armadura("Armadura de cuero endurecido", 3, 0));
        armaduras.add(new Armadura("Armadura de las sombras", 2, 1));
        armaduras.add(new Armadura("Armadura de hueso", 2, 0));
        
        armaduras.add(new Armadura("Piel de lobo", 1, 0));
        armaduras.add(new Armadura("Armadura de cuero endurecido", 2, 0));
        armaduras.add(new Armadura("Armadura de placas de acero", 3, 0));
        armaduras.add(new Armadura("Armadura de cazador de licantropos", 2, 1));
        armaduras.add(new Armadura("Armadura de escamas de dragon", 2, 0));

        try {
            FileOutputStream fos = new FileOutputStream("armaduras.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(armaduras);
            oos.close();
            fos.close();
            System.out.println("Armaduras guardadas en el archivo armaduras.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Almacen a = new Almacen();
        List<Armadura> x = a.getArmaduras();
        for (Armadura armadura : x) {
            System.out.println(armadura.getNombre());
        }*/
    }
}
    

