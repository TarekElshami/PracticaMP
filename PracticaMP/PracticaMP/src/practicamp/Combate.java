package practicamp;

public class Combate {

    private Almacen almacen;

    public Combate(Almacen almacen) {
        this.almacen = almacen;
    }

    public void iniciarCombate(Desafio desafio) {
        Usuario jugador1 = desafio.getDesafiado();
        Usuario jugador2 = desafio.getDesafiante();

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

        // el bucle de cálculo de potenciales de ataque y defensa se repetira hasta que alguno de los dos jugadores quede con 0 de vida
        while (personaje1.getSalud() > 0 && personaje2.getSalud() > 0) {
            //curso del combate
            
        }
    }

}
