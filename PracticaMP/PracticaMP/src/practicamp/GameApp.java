package practicamp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GameApp {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        AdministradorJuego admin = new AdministradorJuego();
        admin.showGame();
        
        /*
        //Esbirros cazador
        List<Esbirro> esbirros = new ArrayList<>();
        Humano h1 = new Humano("Elena", 1, Lealdad.alta);
        List<Esbirro> esbirrosD1 = new ArrayList<>();
        esbirrosD1.add(h1);
        Demonio d1 = new Demonio("Leviatán", 3, esbirrosD1, "El demonio otorga poderes sobrenaturales al amo, pero a cambio, debe ofrecerle una ofrenda de sangre cada día.");
        
        //Esbirros Licantropos 
        List<Esbirro> esbirrosD2 = new ArrayList<>();

        Ghoul g1 = new Ghoul ("Aisha", 2, 1);
        esbirrosD2.add(g1);
        Demonio d2 = new Demonio("Mefistófeles", 2, esbirrosD2, "El demonio otorga habilidades de lucha y defensa al amo, pero a cambio, debe ofrecerle una ofrenda de su propia vida cada mes.");
        
        //Esbirros Vampiro
        Demonio d3 = new Demonio("Asmodeo", 3, null, "El demonio otorga el conocimiento de la magia oscura al amo, pero a cambio, debe ofrecerle una ofrenda de una parte de su cuerpo cada año.");
        Demonio d4 = new Demonio("Astaroth", 1, null, "El demonio otorga la habilidad de controlar la mente de otros al amo, pero a cambio, debe ofrecerle una ofrenda de una persona inocente cada semana.");

        esbirros.add(h1);
        esbirros.add(g1);
        esbirros.add(d1);
        esbirros.add(d2);
        esbirros.add(d3);
        esbirros.add(d4);
        
        List<Arma> armas = new ArrayList<>();

        // Creación de objetos Arma
        Arma cuchilloDeCaza = new Arma("Cuchillo de caza", 0, 2, 1);
        Arma pistolaConBalasDePlata = new Arma("Pistola con balas de plata", 1, 1, 1);
        Arma estacaDeMadera = new Arma("Estaca de madera", 1, 2, 1);
        Arma garras = new Arma("Garras", 0, 2, 1);
        Arma dagaDeObsidiana = new Arma("Daga de obsidiana", 1, 1, 1);
        Arma espadaDeSangre = new Arma("Espada de sangre", 1, 2, 1);
        Arma cuchilloDePlata = new Arma("Cuchillo de plata", 1, 1, 1);
        Arma latigoDeHueso = new Arma("Látigo de hueso", 1, 2, 1);
        Arma ballestaConFlechasDePlata = new Arma("Ballesta con flechas de plata", 2, 2, 2);
        Arma escopetaConBalasDePlata = new Arma("Escopeta con balas de plata", 3, 1, 2);
        Arma hachaDeCazador = new Arma("Hacha de cazador", 3, 1, 2);
        Arma guadaña = new Arma("Guadaña", 2, 2, 2);
        Arma lanzaDePlata = new Arma("Lanza de plata", 3, 1, 2);
        Arma martilloDeHueso = new Arma("Martillo de hueso", 3, 1, 2);
        Arma garroteDePlata = new Arma("Garrote de plata", 2, 2, 2);
        Arma espadaDeLobo = new Arma("Espada de lobo", 3, 1, 2);
        Arma mazaDeHueso = new Arma("Maza de hueso", 3, 1, 2);

        // Inserción en la lista de objetos Arma
        armas.add(cuchilloDeCaza);
        armas.add(pistolaConBalasDePlata);
        armas.add(estacaDeMadera);
        armas.add(garras);
        armas.add(dagaDeObsidiana);
        armas.add(espadaDeSangre);
        armas.add(cuchilloDePlata);
        armas.add(latigoDeHueso);
        armas.add(ballestaConFlechasDePlata);
        armas.add(escopetaConBalasDePlata);
        armas.add(hachaDeCazador);
        armas.add(guadaña);
        armas.add(lanzaDePlata);
        armas.add(martilloDeHueso);
        armas.add(garroteDePlata);
        armas.add(espadaDeLobo);
        armas.add(mazaDeHueso);


        List<Armadura> armaduras = new ArrayList<>();

        // Creación de objetos Armadura
        Armadura chalecoDeCuero = new Armadura("Chaleco de cuero", 1, 0);
        Armadura armaduraDeMalla = new Armadura("Armadura de malla", 2, 0);
        Armadura armaduraDePlaca = new Armadura("Armadura de placa", 3, 0);
        Armadura armaduraDeCazador = new Armadura("Armadura de cazador", 2, 1);
        Armadura armaduraDeCueroReforzado = new Armadura("Armadura de cuero reforzado", 2, 0);

        Armadura tunicaDeCueroOscuro = new Armadura("Tunica de cuero oscuro", 1, 0);
        Armadura armaduraDePielDeMurcielago = new Armadura("Armadura de piel de murcielago", 3, 0);
        Armadura armaduraDeCueroEndurecido = new Armadura("Armadura de cuero endurecido", 2, 0);
        Armadura armaduraDeLasSombras = new Armadura("Armadura de las sombras", 2, 1);
        Armadura armaduraDeHueso = new Armadura("Armadura de hueso", 2, 0);

        Armadura pielDeLobo = new Armadura("Piel de lobo", 1, 0);
        Armadura armaduraDePlacasDeAcero = new Armadura("Armadura de placas de acero", 3, 0);
        Armadura armaduraDeCazadorDeLycanthropos = new Armadura("Armadura de cazador de licantropos", 2, 1);
        Armadura armaduraDeEscamasDeDragon = new Armadura("Armadura de escamas de dragon", 2, 0);

        // Inserción de objetos Armadura en la lista
        armaduras.add(chalecoDeCuero);
        armaduras.add(armaduraDeMalla);
        armaduras.add(armaduraDePlaca);
        armaduras.add(armaduraDeCazador);
        armaduras.add(armaduraDeCueroReforzado);

        armaduras.add(tunicaDeCueroOscuro);
        armaduras.add(armaduraDePielDeMurcielago);
        armaduras.add(armaduraDeCueroEndurecido);
        armaduras.add(armaduraDeLasSombras);
        armaduras.add(armaduraDeHueso);

        armaduras.add(pielDeLobo);
        armaduras.add(armaduraDePlacasDeAcero);
        armaduras.add(armaduraDeCazadorDeLycanthropos);
        armaduras.add(armaduraDeEscamasDeDragon);


        List<Modificador> modificadores = new ArrayList<>();        
        Modificador plata = new Modificador("Plata");
        modificadores.add(plata);
        Modificador controlMental = new Modificador("Control mental");
        modificadores.add(controlMental);
        Modificador fuego = new Modificador("Fuego");
        modificadores.add(fuego);
        Modificador ausencia = new Modificador("Ausencia de luna llena");
        modificadores.add(ausencia);

        Modificador lobo = new Modificador("Transformacion en lobo");
        modificadores.add(lobo);
        Modificador fuerzaSobrehumana = new Modificador("Fuerza sobrehumana");
        modificadores.add(fuerzaSobrehumana);
        Modificador agilidad = new Modificador("Agilidad");
        modificadores.add(agilidad);
        Modificador sentidos = new Modificador("Sentidos agudizados");
        modificadores.add(sentidos);

        Modificador noche = new Modificador("Noche");
        modificadores.add(noche);
        //Modificador fuego = new Modificador("Fuego");

        Modificador habilidad = new Modificador("Habilidad con armas");
        modificadores.add(habilidad);
        Modificador combate = new Modificador("Entrenamiento en combate");
        modificadores.add(combate);
        Modificador conocimiento = new Modificador("Conocimiento de ocultismo");
        modificadores.add(conocimiento);
        Modificador sigilo = new Modificador("Sigilo");
        modificadores.add(sigilo);
        Modificador resistencia = new Modificador("Resistencia fisica");
        modificadores.add(resistencia);

        Modificador luzSol = new Modificador ("La luz solar");
        modificadores.add(luzSol);
        Modificador estaca = new Modificador("Estacas de madera");
        modificadores.add(estaca);
        Modificador faltaSangre = new Modificador("Falta de sangre");
        modificadores.add(faltaSangre);

        Modificador Velocidad = new Modificador("Velocidad");
        modificadores.add(Velocidad);
        Modificador regeneracion = new Modificador("Regeneracion rapida");
        modificadores.add(regeneracion);
        Modificador agudizados = new Modificador("Sentidos agudizados");
        modificadores.add(agudizados);


        Vampiro v = new Vampiro("Vampiro");
        Disciplina d = new Disciplina("Disciplina", 3, 3, 3);
        v.setHabilidad(d);
        v.agregarDebilidad(luzSol, 5);
        v.agregarDebilidad(estaca, 4);
        v.agregarDebilidad(faltaSangre, 2);

        v.agregarFortaleza(Velocidad, 4);
        v.agregarFortaleza(regeneracion, 3);
        v.agregarFortaleza(agudizados, 3);
        
        v.agregarArmadura(chalecoDeCuero);
        v.agregarArmadura(armaduraDeMalla);
        v.agregarArmadura(armaduraDePlaca);
        v.agregarArmadura(armaduraDeCazador);
        v.agregarArmadura(armaduraDeCueroReforzado);
        
        v.agregarArma(garras);
        v.agregarArma(dagaDeObsidiana);
        v.agregarArma(espadaDeSangre);
        v.agregarArma(guadaña);
        v.agregarArma(lanzaDePlata);
        v.agregarArma(martilloDeHueso);
        
        v.agregarEsbirro(d3);
        v.agregarEsbirro(d4);

        Licantropo l = new Licantropo ("Licantropo");
        Don don = new Don("Don", 2, 2, 0);
        l.setHabilidad(don);
        l.agregarDebilidad(plata, 5);
        l.agregarDebilidad(controlMental, 3);
        l.agregarDebilidad(fuego, 2);
        l.agregarDebilidad(ausencia, 1);

        l.agregarFortaleza(lobo, 5);
        l.agregarFortaleza(fuerzaSobrehumana, 4);
        l.agregarFortaleza(agilidad, 3);
        l.agregarFortaleza(sentidos, 3);
        
        l.agregarArmadura(tunicaDeCueroOscuro);
        l.agregarArmadura(armaduraDePielDeMurcielago);
        l.agregarArmadura(armaduraDeCueroEndurecido);
        l.agregarArmadura(armaduraDeLasSombras);
        l.agregarArmadura(armaduraDeHueso);
        
        l.agregarArma(garras);
        l.agregarArma(cuchilloDePlata);
        l.agregarArma(latigoDeHueso);
        l.agregarArma(garroteDePlata);
        l.agregarArma(espadaDeLobo);
        l.agregarArma(mazaDeHueso);
        
        l.agregarEsbirro(d2);
        
        Cazador c = new Cazador("Cazador");
        Talento t = new Talento("Talento",1,1);
        c.setHabilidad(t);

        c.agregarDebilidad(noche,3);
        c.agregarDebilidad(fuego,4);

        c.agregarFortaleza(habilidad,5);
        c.agregarFortaleza(combate,4);
        c.agregarFortaleza(conocimiento,3);
        c.agregarFortaleza(resistencia,2);
        c.agregarFortaleza(sigilo,3);
        
        c.agregarArmadura(pielDeLobo);
        c.agregarArmadura(armaduraDeCueroEndurecido);
        c.agregarArmadura(armaduraDePlacasDeAcero);
        c.agregarArmadura(armaduraDeCazadorDeLycanthropos);
        c.agregarArmadura(armaduraDeEscamasDeDragon);
        
        c.agregarArma(cuchilloDeCaza);
        c.agregarArma(pistolaConBalasDePlata);
        c.agregarArma(estacaDeMadera);
        c.agregarArma(ballestaConFlechasDePlata);
        c.agregarArma(escopetaConBalasDePlata);
        c.agregarArma(hachaDeCazador);

        c.agregarEsbirro(d1);
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(c);
        personajes.add(v);
        personajes.add(l);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("esbirros.dat"));
            oos.writeObject(esbirros);
            oos.close();
            System.out.println("Esbirros guardados en el archivo esbirros.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("modificadores.dat"));
            oos.writeObject(modificadores);
            oos.close();
            System.out.println("Modificadores guardados en el archivo modificadores.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

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
        
        try {
            FileOutputStream fos = new FileOutputStream("armas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(armas);
            oos.close();
            fos.close();
            System.out.println("Armas guardadas en el archivo armas.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        try {
            FileOutputStream fos = new FileOutputStream("personajes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personajes);
            oos.close();
            fos.close();
            System.out.println("personajes guardados en el archivo personajes.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        Almacen a = new Almacen();*/
    }
}
    

