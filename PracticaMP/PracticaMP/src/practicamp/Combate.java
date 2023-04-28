package practicamp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Combate {

    private Almacen almacen;

    public Combate(Almacen almacen) {
        this.almacen = almacen;
    }

    public void DEBUG_Initialize_Players(Desafio desafio) { //Esto es porque cuando se programó el combate los jugadores aun no podían escoger personaje y tuve que inicializar los personajes aqui

        // Instanciamos listas de armas
        List<Arma> listaArmasj1 = new ArrayList<>();
        List<Arma> listaArmasj2 = new ArrayList<>();
        //----

        //Instanciamos armas y armaduras para cada jugador 
        Arma armaj1 = new Arma("Garras", 1, 3, 2);
        Arma armaj2 = new Arma("Cetro", 2, 2, 1);

        listaArmasj1.add(armaj1);
        listaArmasj2.add(armaj2);

        Armadura armaduraj1 = new Armadura("Armadura Celestial", 3, 1);
        Armadura armaduraj2 = new Armadura("Armadura de Mago", 3, 2);

        // Cargar jugadores
        Usuario jugador1 = desafio.getDesafiado();
        Usuario jugador2 = desafio.getDesafiante();

        // Asignar personaje a cada jugador
        jugador1.setTipoPersonaje("Vampiro");
        jugador2.setTipoPersonaje("Licantropo");

        // Asignar armas y armaduras a cada jugador
        jugador1.setArmasActivas(listaArmasj1);
        jugador2.setArmasActivas(listaArmasj2);

        jugador1.setArmaduraActiva(armaduraj1);
        jugador2.setArmaduraActiva(armaduraj2);

        //Carga de personajes de cada jugador
        Personaje personaje1 = null;
        Personaje personaje2 = null;

        // Obtencion de cada personaje
        for (Personaje pj1 : almacen.getPersonajes()) {
            if (pj1.getNombre().equals(jugador1.getTipoPersonaje())) {
                personaje1 = pj1;
            }
        }

        for (Personaje pj2 : almacen.getPersonajes()) {
            if (pj2.getNombre().equals(jugador2.getTipoPersonaje())) {
                personaje2 = pj2;
            }
        }

        //Asignar fortalezas admitidas
        //Asignar debilidades admitidas
    }

    private int comprobarTipo(Usuario usuario, String nombreMod) {
        int valor = 0; // es 1 si es una debilidad, 2 si es una fortaleza y 0 si no está
        String persUsuario = usuario.getTipoPersonaje();
        if (persUsuario != null) {
            List<Personaje> personajes = almacen.getPersonajes();
            int i = 0;
            while (!personajes.get(i).getNombre().equals(persUsuario)) {
                i += 1;
            }
            Map<String, Integer> debilidades = personajes.get(i).getDebilidades();
            Map<String, Integer> fortalezas = personajes.get(i).getFortalezas();
            if (debilidades.containsKey(nombreMod)) {
                valor = 1;
            } else if (fortalezas.containsKey(nombreMod)) {
                valor = 2;
            } else {
                valor = 0;
            }
        }
        return valor;
    }

    private int calcularPotencialPersonaje(Personaje personaje, Usuario jugador, boolean modo, Desafio desafio) {
        // modo = true : calculo del potencial de ataque
        // modo = false : calculo del potencial de defensa (es para optimizar lineas)

        int potencial = 0;

        int poder = personaje.getPoder();

        Habilidad habilidad = personaje.getHabilidad();

        // Como se pueden tener mas de un arma en ciertos casos, para calcular el valor de ataque total de las armas de un personaje se tiene que recorrer la lista de armas activas
        int valorEquipoActivo = 0;

        if (modo == true) { //SI ESTAMOS CALCULANDO POTENCIAL DE ATAQUE
            List<Arma> equipoActivo = jugador.getArmasActivas();
            Armadura armaduraActiva = jugador.getArmaduraActiva();

            for (Arma a : equipoActivo) {
                valorEquipoActivo += a.getAtaque();
            }

            // La armadura tambien puede aportar ataque
            valorEquipoActivo += armaduraActiva.getAtaque();

            // En el caso de vampiros y licantropos, solo en condiciones especiales se podran aprovechar sus habilidades 
            if (habilidad instanceof Disciplina disciplina) {
                int sangreActual = ((Vampiro) personaje).getSangre();
                int costeDisciplina = ((Disciplina) habilidad).getCosteSangre();

                if (personaje instanceof Vampiro && sangreActual >= costeDisciplina) {
                    potencial += habilidad.getAtaque();
                }

            } else if (habilidad instanceof Don don) {
                int rabiaActual = ((Licantropo) personaje).getRabia();
                int costeDon = ((Don) habilidad).getCosteRabia();

                if (personaje instanceof Licantropo && rabiaActual >= costeDon) {
                    potencial += habilidad.getAtaque();
                }
            } else { // Para los cazadores no hay que hacer comprobaciones
                potencial += habilidad.getAtaque();
            }

        } else { // SI ESTAMOS CALCULANDO POTENCIAL DE DEFENSA
            List<Arma> equipoActivo = jugador.getArmasActivas();
            Armadura armaduraActiva = jugador.getArmaduraActiva();

            // Las armas tambien pueden aportar defensa
            for (Arma a : equipoActivo) {
                valorEquipoActivo += a.getDefensa();
            }

            valorEquipoActivo += armaduraActiva.getDefensa();

            // En el caso de vampiros y licantropos, solo en condiciones especiales se podran aprovechar sus habilidades 
            if (habilidad instanceof Disciplina disciplina) {
                int sangreActual = ((Vampiro) personaje).getSangre();
                int costeDisciplina = ((Disciplina) habilidad).getCosteSangre();

                if (personaje instanceof Vampiro && sangreActual >= costeDisciplina) {
                    potencial += habilidad.getDefensa();
                }

            } else if (habilidad instanceof Don don) {
                int rabiaActual = ((Licantropo) personaje).getRabia();
                int costeDon = ((Don) habilidad).getCosteRabia();

                if (personaje instanceof Licantropo licantropo && rabiaActual >= costeDon) {
                    potencial += habilidad.getDefensa();
                }
            } else { // Para los cazadores no hay que hacer comprobaciones
                potencial += habilidad.getDefensa();
            }
        }

        // ----
        potencial += poder + valorEquipoActivo;

        if (personaje instanceof Vampiro vampiro && vampiro.getSangre() >= 5) {
            potencial += 2;
        } else if (personaje instanceof Licantropo licantropo) {
            potencial += licantropo.getRabia();
        } else if (personaje instanceof Cazador cazador) {
            potencial += cazador.getVoluntad();
        }

        //CALCULO DE FORTALEZAS
        for (Modificador mod : desafio.getFortalezasAdmitidas()) {
            String modName = mod.getNombre();
            int type = this.comprobarTipo(jugador, modName);
            if (type == 2) {
                int valor = personaje.getValorFortalezaODebilidad(modName, true);
                potencial += valor;

            }
        }

        //CALCULO DE DEBILIDADES
        for (Modificador mod : desafio.getDebilidadesAdmitidas()) {
            String modName = mod.getNombre();
            int type = this.comprobarTipo(jugador, modName);
            if (type == 1) {
                int valor = personaje.getValorFortalezaODebilidad(modName, false);
                potencial -= valor;

            }
        }

        return potencial;
    }

    private int calcularAtaqueODefensa(int potencial, Random random) {

        int valor = 0;

        for (int i = 0; i < potencial; i++) { // por cada valor del potencial...
            int randInt = random.nextInt(6) + 1; // ... genero un valor aleatorio del 1 al 6
            if (randInt >= 5) { // ... si dicho valor es >= 5, entonces tenemos 1 exito de ataque o defensa que se van acumulando
                valor += 1;
            }
        }
        return valor;
    }

    private void atacarEsbirro(List<Esbirro> listaEsbirros, int startPoint, Desafio desafio) {
        Esbirro candidato = listaEsbirros.get(startPoint); //cojo el ultimo esbirro de la lista de esbirros que me pasen

        if (candidato instanceof Demonio demonio) { //si es un demonio...
            if (demonio.getEsbirros().isEmpty()) { // ...pero no tiene esbirros, le pego
                candidato.setSalud(candidato.getSalud() - 1); //PEGAR

                desafio.setAHistorial("   |---> Se ataca al esbirro DEMONIO " + candidato.getNombre() + " SIN ESBIRROS ASOCIADOS\n");

                if (demonio.getSalud() < 1) { // si el esbirro en cuestión ya no tiene vida...
                    listaEsbirros.remove(candidato); // ...entonces lo eliminamos de la lista

                    desafio.setAHistorial("  [!] El esbirro " + candidato.getNombre() + " ha muerto\n");
                }
            } else { // Si tiene lista de esbirros, vuelvo a entrar aqui (CASO RECURSIVO)
                List<Esbirro> esbirrosDemonio = demonio.getEsbirros(); // obtengo su lista de esbirros

                desafio.setAHistorial("  [?] El esbirro " + candidato.getNombre() + " es un DEMONIO CON ESBIRROS ASOCIADOS: \n");
                desafio.setAHistorial("   |- ESBIRROS DEL DEMONIO " + candidato.getNombre() + ": " + printEsbirros(esbirrosDemonio, desafio) + "\n");

                atacarEsbirro(esbirrosDemonio, esbirrosDemonio.size() - 1, desafio); // ataco al esbirro que toque
            }
        } else { // Si no es un demonio (CASO BASE)
            candidato.setSalud(candidato.getSalud() - 1); //PEGAR

            desafio.setAHistorial("      |---> Se ataca al esbirro " + candidato.getNombre() + "\n");

            if (candidato.getSalud() < 1) { // si el esbirro en cuestión ya no tiene vida...
                listaEsbirros.remove(candidato); // ...entonces lo eliminamos de la lista

                desafio.setAHistorial("  [!] El esbirro " + candidato.getNombre() + " ha muerto\n");
            }
        }

    }

    public void iniciarCombate(Desafio desafio) throws IOException, CloneNotSupportedException {

        Random random = new Random();

        Usuario jugador1 = desafio.getDesafiado();
        Usuario jugador2 = desafio.getDesafiante();

        Personaje personaje1 = null;
        Personaje personaje2 = null;

        // Obtencion de cada personaje
        for (Personaje pj1 : almacen.getPersonajes()) {
            if (pj1.getNombre().equals(jugador1.getTipoPersonaje())) {
                personaje1 = pj1.clone();
            }
        }

        for (Personaje pj2 : almacen.getPersonajes()) {
            if (pj2.getNombre().equals(jugador2.getTipoPersonaje())) {
                personaje2 = pj2.clone();
            }
        }

        List<Esbirro> esbirrosP1 = personaje1.getEsbirros();
        List<Esbirro> esbirrosP2 = personaje2.getEsbirros();

        int ronda = 0;

        desafio.setAHistorial("-]--> COMBATE - (" + jugador1.getNick() + " vs. " + jugador2.getNick() + ") -> (" + personaje1.getNombre() + " vs. " + personaje2.getNombre() + ") <--[-\n");
        desafio.setAHistorial("");
        // el bucle de cálculo de potenciales de ataque y defensa se repetira hasta que alguno de los dos jugadores quede con 0 de vida
        while (personaje1.getSalud() > 0 && personaje2.getSalud() > 0) {

            //curso del combate
            desafio.setAHistorial("+ RONDA " + (ronda + 1) + " -------------------------------------------------------------+\n");
            desafio.setAHistorial("");
            desafio.setAHistorial("  -) Vida jugador " + jugador1.getNick() + ": " + personaje1.getSalud() + "\n");
            desafio.setAHistorial("  -) Vida jugador " + jugador2.getNick() + ": " + personaje2.getSalud() + "\n");

            desafio.setAHistorial("");
            desafio.setAHistorial("  -----------------------------------------\n");

            // Calculo del potencial de ataque
            int potAtaqueJ1 = this.calcularPotencialPersonaje(personaje1, jugador1, true, desafio);
            desafio.setAHistorial("  - Potencial de ataque de " + jugador1.getNick() + ": " + potAtaqueJ1 + "\n");
            int potAtaqueJ2 = this.calcularPotencialPersonaje(personaje2, jugador2, true, desafio);
            desafio.setAHistorial("  - Potencial de ataque de " + jugador2.getNick() + ": " + potAtaqueJ2 + "\n");

            desafio.setAHistorial("  -----------------------------------------\n");

            // Calculo del potencial de defensa
            int potDefensaJ1 = this.calcularPotencialPersonaje(personaje1, jugador1, false, desafio);
            desafio.setAHistorial("  - Potencial de defensa de " + jugador1.getNick() + ": " + potDefensaJ1 + "\n");
            int potDefensaJ2 = this.calcularPotencialPersonaje(personaje2, jugador2, false, desafio);
            desafio.setAHistorial("  - Potencial de defensa de " + jugador2.getNick() + ": " + potDefensaJ2 + "\n");

            desafio.setAHistorial("  -----------------------------------------\n");

            // Calculo del valor de ataque
            int ataqueJ1 = this.calcularAtaqueODefensa(potAtaqueJ1, random);
            desafio.setAHistorial("  - ATAQUE de " + jugador1.getNick() + ": " + ataqueJ1 + "\n");
            int ataqueJ2 = this.calcularAtaqueODefensa(potAtaqueJ2, random);
            desafio.setAHistorial("  - ATAQUE de " + jugador2.getNick() + ": " + ataqueJ2 + "\n");

            desafio.setAHistorial("  -----------------------------------------\n");

            //Calculo del valor de defensa
            int defensaJ1 = this.calcularAtaqueODefensa(potDefensaJ1, random);
            desafio.setAHistorial("  - DEFENSA de " + jugador1.getNick() + ": " + defensaJ1 + "\n");
            int defensaJ2 = this.calcularAtaqueODefensa(potDefensaJ2, random);
            desafio.setAHistorial("  - DEFENSA de " + jugador2.getNick() + ": " + defensaJ2 + "\n");

            desafio.setAHistorial("  -----------------------------------------\n");

            if (ataqueJ1 >= defensaJ2) {
                desafio.setAHistorial("\n");
                desafio.setAHistorial("  +--------\n");
                desafio.setAHistorial("  -]-> El jugador " + jugador1.getNick() + " ataca al jugador " + jugador2.getNick() + " en la ronda " + (ronda + 1) + "\n");
                desafio.setAHistorial("\n");
                //si el personaje2 tiene esbirros, se les pega primero
                if (!esbirrosP2.isEmpty()) {
                    desafio.setAHistorial("  [*] ESBIRROS DEL JUGADOR " + jugador2.getNick() + ": " + printEsbirros(esbirrosP2, desafio) + "\n");
                    atacarEsbirro(esbirrosP2, esbirrosP2.size() - 1, desafio);

                } //si el personaje ya no tiene esbirros, pegar al personaje
                else {
                    desafio.setAHistorial("  [!] EL JUGADOR " + jugador2.getNick() + " NO TIENE ESBIRROS" + "\n");
                    desafio.setAHistorial("   |---> Se asesta un golpe al jugador " + jugador2.getNick() + "\n");

                    if (personaje2 instanceof Licantropo licantropo) { // si el personaje es un licantropo, al recibir un golpe aumenta su rabia
                        if (licantropo.getRabia() < 3) {
                            desafio.setAHistorial("\n");
                            desafio.setAHistorial("  - El jugador " + jugador2.getNick() + " es un Licántropo y ha aumentado su Rabia con el golpe recibido\n");
                            licantropo.setRabia(licantropo.getRabia() + 1);
                        }
                    } else if (personaje2 instanceof Cazador cazador) { // si el personaje es un cazador, su voluntad disminuye
                        if (cazador.getVoluntad() > 0) {
                            desafio.setAHistorial("\n");
                            desafio.setAHistorial("  - El jugador " + jugador2.getNick() + " es un Cazador y ha disminuido su Voluntad con el ataque\n");
                            cazador.setVoluntad(cazador.getVoluntad() - 1);
                        }
                    }

                    personaje2.setSalud(personaje2.getSalud() - 1);

                    desafio.setAHistorial("\n");
                    desafio.setAHistorial("  [!] Salud del jugador " + jugador2.getNick() + ": " + personaje2.getSalud() + "\n");

                }

                if (personaje1 instanceof Vampiro vampiro) { // si el personaje del jugador 1 es un vampiro y ha asestado un golpe, recupera sangre
                    if (vampiro.getSangre() < 10) {
                        desafio.setAHistorial("\n");
                        desafio.setAHistorial("  - El jugador " + jugador1.getNick() + " es un Vampiro y ha aumentado su Sangre con el ataque\n");
                        vampiro.setSangre(vampiro.getSangre() + 1);
                    }
                }

            }
            if (ataqueJ2 >= defensaJ1) {
                desafio.setAHistorial("\n");
                desafio.setAHistorial("  +--------\n");
                desafio.setAHistorial("  -]-> El jugador " + jugador2.getNick() + " ataca al jugador " + jugador1.getNick() + " en la ronda " + (ronda + 1) + "\n");
                desafio.setAHistorial("\n");

                //si el personaje1 tiene esbirros, se les pega primero
                if (!esbirrosP1.isEmpty()) {
                    desafio.setAHistorial("  [*] ESBIRROS DEL JUGADOR " + jugador1.getNick() + ": " + printEsbirros(esbirrosP1, desafio) + "\n");
                    atacarEsbirro(esbirrosP1, esbirrosP1.size() - 1, desafio);

                } //si el personaje ya no tiene esbirros, pegar al personaje
                else {
                    desafio.setAHistorial("  [!] EL JUGADOR " + jugador1.getNick() + " NO TIENE ESBIRROS" + "\n");
                    desafio.setAHistorial("   |---> Se asesta un golpe al jugador " + jugador1.getNick() + "\n");

                    if (personaje1 instanceof Licantropo licantropo) { // si el personaje es un licantropo, al recibir un golpe aumenta su rabia
                        if (licantropo.getRabia() < 3) {
                            desafio.setAHistorial("\n");
                            desafio.setAHistorial("  - El jugador " + jugador1.getNick() + " es un Licántropo y ha aumentado su Rabia con el ataque\n");
                            licantropo.setRabia(licantropo.getRabia() + 1);
                        }
                    } else if (personaje1 instanceof Cazador cazador) { // si el personaje es un cazador, su voluntad disminuye
                        if (cazador.getVoluntad() > 0) {
                            desafio.setAHistorial("\n");
                            desafio.setAHistorial("  - El jugador " + jugador2.getNick() + " es un Cazador y ha disminuido su Voluntad con el ataque\n");
                            cazador.setVoluntad(cazador.getVoluntad() - 1);
                        }
                    }

                    personaje1.setSalud(personaje1.getSalud() - 1);

                    desafio.setAHistorial("\n");
                    desafio.setAHistorial("  [!] Salud del jugador " + jugador1.getNick() + ": " + personaje1.getSalud() + "\n");

                }

                if (personaje2 instanceof Vampiro vampiro) { // si el personaje del jugador 1 es un vampiro y ha asestado un golpe, recupera sangre
                    if (vampiro.getSangre() < 10) {
                        desafio.setAHistorial("\n");
                        desafio.setAHistorial("  - El jugador " + jugador2.getNick() + " es un Vampiro y ha aumentado su Sangre con el ataque\n");
                        vampiro.setSangre(vampiro.getSangre() + 1);
                    }
                }
            }
            if (ataqueJ1 < defensaJ2 && ataqueJ2 < defensaJ1) { // puede darse el caso de que en una ronda los dos jugadores no puedan atacarse si el ataque de uno no supera la defensa del otro simultáneamente
                desafio.setAHistorial("\n");
                desafio.setAHistorial("  -]-> [!] NO SE ATACA NADIE\n");

            }
            ronda += 1;
            desafio.setAHistorial("\n");
            desafio.setAHistorial("\n");
        } // Si se detiene el bucle es que alguno de los dos personajes han alcanzado 0 de vida, comprobaremos si es empate o veremos quien ganó

        desafio.setAHistorial("+----------------------------------------------------------------------+\n");

        desafio.setEstado(EstadoDesafio.acabado);

        if (personaje1.getSalud() == personaje2.getSalud()) { // si ambos valores de salud son iguales = EMPATE
            desafio.setAHistorial("[!] EMPATE\n");
            desafio.setGanador(null);
            //No se modifica el atributo ganador de desafio al empatar. En el historial se accederá al desafiante y desafiado
        } else if (personaje1.getSalud() > personaje2.getSalud()) {
            desafio.setAHistorial("[!] GANA EL JUGADOR " + jugador1.getNick() + " con personaje : " + personaje1.getNombre() + "\n");
            desafio.setGanador(jugador1);
            jugador1.setVictorias(1);
            //Ranking.agregarJugador(jugador1);
        } else if (personaje1.getSalud() < personaje2.getSalud()) {
            desafio.setAHistorial("[!] GANA EL JUGADOR " + jugador2.getNick() + " con personaje : " + personaje2.getNombre() + "\n");
            desafio.setGanador(jugador2);
            jugador2.setVictorias(1);
            //Ranking.agregarJugador(jugador2);
        }

        desafio.setAHistorial("[!] => TOTAL RONDAS: " + ronda + "\n");

        //Guardamos en la clase local los nuevos estados de los usuarios batidos en combate
        Almacen.setUsuario(jugador1);
        Almacen.setUsuario(jugador2);

        //Almacenaje del desafio finalizado en el historial de cada jugador
        jugador1.addToHistorial(desafio);
        jugador2.addToHistorial(desafio);

        //Actualizacion del fichero de desafios
        almacen.actualizarFicheroDesafios();
        almacen.updateFiles();

        //Restablecimiento de personajes
        almacen.cargarPersonajes(); //Tenemos que recargar los personajes desde el fichero donde se encuentran con sus variables por defecto

    }

    private String printEsbirros(List<Esbirro> esbirrosP2, Desafio desafio) {
        List<String> toPrint = new ArrayList<>();

        for (Esbirro esbirro : esbirrosP2) {
            toPrint.add((esbirro.getNombre()) + " (" + "Tipo: " + esbirro.getClass().getSimpleName() + ", Salud: " + esbirro.getSalud() + ")");
        }

        return (toPrint.toString());
    }

}
