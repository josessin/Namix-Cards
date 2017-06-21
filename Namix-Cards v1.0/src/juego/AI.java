/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import modelos.Carta;
import modelos.Jugador;

/**
 *
 * @author Usuario
 */
class AI {

    private final Jugador yo;
    private final Juego juego;
    private boolean mueroEnProxTurno;
    private int dañoExtraParaGanar;
    private int poderDisponible;
    private int dañoMaximoPosible;
    private ArrayList<Carta> combinacionDañoMaxima, mejorCombinacionCriaturas, cartasJugables;
    private float chanceDePerder;
    private float poderOponente;
    private final ArrayList<Par> parCriaturas;
    private final ArrayList<Par> parHechizos;

    public AI(Juego juego, Jugador jugador) {

        this.yo = jugador;
        this.juego = juego;
        combinacionDañoMaxima = new ArrayList<>();
        mejorCombinacionCriaturas = new ArrayList<>();
        parCriaturas = new ArrayList<>();
        parHechizos = new ArrayList<>();
        cartasJugables = new ArrayList<>();
    }

    public void play() {

        //Actuar
        evalVictoria();
        evalDerrota();
        jugar();
        parCriaturas.clear();
        parHechizos.clear();
        juego.terminarTurno();
    }

    private void evalVictoria() {
        //Resetar valores
        poderDisponible = 0;
        combinacionDañoMaxima.clear();
        mejorCombinacionCriaturas.clear();
        cartasJugables.clear();

        dañoExtraParaGanar = calcDañoNesesario();
        dañoMaximoPosible = calcDañoMaximo();
        mejorCombinacioCriaturas(cartasJugables);

    }

    private void evalDerrota() {

        chanceDePerder = 0;

        poderOponente = 0;
        for (Carta c : juego.getJugadorPasivo().getCartasEnJuego()) {
            poderOponente += c.getPoder();
        }
        if (poderOponente >= yo.getVidas()) {
            juego.logger.log("--Estoy en el horno, muero en proximo turno si no hago algo");
            mueroEnProxTurno = true;
        } else {
            chanceDePerder = calcChanceDePerder();
            juego.logger.log("--Mis chances de perder son: " + chanceDePerder);
        }

    }

    private void jugar() {
        //Matar oponenete si es posible
        if (dañoMaximoPosible >= dañoExtraParaGanar) {
            juego.logger.log("--Voy con todo al jugador");
            juego.logger.log("--Plan ofensivo");
            jugarCartas(combinacionDañoMaxima, true);
            attacarJugador(yo.getCartasEnJuego());
        } else if (mueroEnProxTurno || chanceDePerder > 0.7) {

            juego.logger.log("--Plan defensivo");
            jugarCartas(mejorCombinacionCriaturas, false);
            ataqueDefensivo(yo.getCartasEnJuego());
            hechizosACriaturas(false);
        } else {
            juego.logger.log("--Plan seguro");
            jugarCartas(mejorCombinacionCriaturas, false);
            ataqueSeguro(yo.getCartasEnJuego());
            hechizosACriaturas(true);
        }
    }

    private void ataqueDefensivo(ArrayList<Carta> cartasEnJuego) {

        //Attacar criaturas
        for (Carta c : cartasEnJuego) {
            atacarCriatura(c, mejorObjectivoCriatura(c, false));
        }
        ejecutarPares(parCriaturas);
        //atacar jugador
        for (Carta c : cartasEnJuego) {
            if (!c.isAtaco()) {
                attacarJugador(c);
            }
        }
    }

    private void ataqueOfensivo(ArrayList<Carta> cartasEnJuego) {

        for (Carta c : cartasEnJuego) {
            atacarCriatura(c, mejorObjectivoCriatura(c, true));
        }
        ejecutarPares(parCriaturas);
        //atacar jugador
        for (Carta c : cartasEnJuego) {
            if (!c.isAtaco()) {
                attacarJugador(c);
            }
        }
    }

    private void ataqueSeguro(ArrayList<Carta> cartasEnJuego) {

        for (Carta c : cartasEnJuego) {
            atacarCriatura(c, objectivoCriaturaSeguro(c));
        }
        ejecutarPares(parCriaturas);
        //atacar jugador
        for (Carta c : cartasEnJuego) {
            if (!c.isAtaco()) {
                attacarJugador(c);
            }
        }
    }

    private ArrayList<Carta> getCartasJugables() {
        //Seleccionas entre todas las cartas disponibles las jugables con el mana
        for (Carta c : yo.getCartasEnMano()) {
            if (c.getCoste() < yo.getManaDisponible()) {
                cartasJugables.add(c);
            }
        }
        return cartasJugables;

    }

    private int calcDañoMaximo() {
        int max = poderDisponible;
        max += cambinacionDañoMaxima(getCartasJugables());
        return max;
    }

    private int cambinacionDañoMaxima(ArrayList<Carta> cartasJugables) {

        int mejorSumPoder = 0;

        for (Carta c : cartasJugables) {

            int mana = yo.getManaDisponible();
            int poder = 0;
            ArrayList<Carta> combActual = new ArrayList<>();
            combActual.add(c);
            poder += c.getPoder();
            mana -= c.getCoste();

            for (Carta e : cartasJugables) {
                if (combActual.contains(e)) {
                    continue;
                }
                if (e.getCoste() > mana) {
                    continue;
                }
                combActual.add(e);
                mana -= e.getCoste();
                poder += e.getPoder();
            }

            if (poder > mejorSumPoder) {
                mejorSumPoder = poder;
                combinacionDañoMaxima = combActual;
            }

        }

        juego.logger.log("MEJOR COMBO DAÑO:");
        for (Carta c : combinacionDañoMaxima) {
            juego.logger.log(c.getNombre());
        }

        return mejorSumPoder;
    }

    private void mejorCombinacioCriaturas(ArrayList<Carta> cartasJugables) {

        int mejorSumPoder = 0;

        for (Carta c : cartasJugables) {

            if (c.getTipo() == Carta.Tipo.hechizo) {
                continue;
            }

            int mana = yo.getManaDisponible();
            int poder = 0;
            ArrayList<Carta> combActual = new ArrayList<>();
            combActual.add(c);
            poder += c.getPoder();
            mana -= c.getCoste();

            for (Carta e : cartasJugables) {
                if (e.getTipo() == Carta.Tipo.hechizo) {
                    continue;
                }
                if (combActual.contains(e)) {
                    continue;
                }

                if (e.getCoste() > mana) {
                    continue;
                }
                combActual.add(e);
                mana -= e.getCoste();
                poder += e.getPoder();
            }

            if (poder > mejorSumPoder) {
                mejorSumPoder = poder;
                mejorCombinacionCriaturas = combActual;
            }

        }

        juego.logger.log("MEJOR COMBO CRIATURAS:");
        for (Carta c : mejorCombinacionCriaturas) {
            juego.logger.log(c.getNombre());
        }

    }

    private int calcDañoNesesario() {

        for (Carta c : yo.getCartasEnJuego()) {
            poderDisponible += c.getPoder();
        }
        return juego.getJugadorPasivo().getVidas() - poderDisponible;
    }

    private void jugarCartas(ArrayList<Carta> cartas, boolean conHechizos) {
        for (Carta c : cartas) {
            if (c.getTipo() == Carta.Tipo.criatura) {
                juego.cartaClickeda(c);
            } else if (conHechizos) {
                juego.cartaClickeda(c);
                juego.oponenteClickeado(juego.getJugadorPasivo());
            }

        }
    }

    private void attacarJugador(Carta carta) {

        juego.cartaClickeda(carta);
        juego.oponenteClickeado(juego.getJugadorPasivo());

    }

    private void attacarJugador(ArrayList<Carta> cartas) {
        for (Carta c : cartas) {
            juego.cartaClickeda(c);
            juego.oponenteClickeado(juego.getJugadorPasivo());
        }
    }

    private void hechizosACriaturas(boolean optimo) {

        for (Carta hechizo : yo.getCartasEnMano()) {
            if (hechizo.getTipo() == Carta.Tipo.hechizo && hechizo.getCoste() <= yo.getManaDisponible()) {
                Carta cartaADañar = mejorObjetivoHechizo(hechizo, optimo);
                if (cartaADañar != null) {

                    parHechizos.add(new Par(hechizo, cartaADañar));

                }
            }
        }

        ejecutarPares(parHechizos);
    }

    private void ejecutarPares(ArrayList<Par> pares) {
        for (Par p : pares) {
            juego.cartaClickeda(p.atacante);
            juego.cartaClickeda(p.objetivo);
        }
    }

    private void atacarCriatura(Carta cartaAtacante, Carta mejorObjetivo) {
        if (cartaAtacante == null || mejorObjetivo == null) {
            return;
        }

        parCriaturas.add(new Par(cartaAtacante, mejorObjetivo));

    }

    private Carta mejorObjetivoHechizo(Carta hechizo, boolean optimo) {
        //buscar carta de igual poder
        for (Carta cObj : juego.getJugadorPasivo().getCartasEnJuego()) {
            if (Objects.equals(cObj.getPoder(), hechizo.getPoder())) {
                return cObj;
            }
        }
        if (!optimo) {
            //Buscar la mas grande que podamos matar
            int selIndex = -1;
            int maxPoder = 0;
            int i = 0;
            for (Carta cOrd : juego.getJugadorActivo().getCartasEnJuego()) {
                if (cOrd.getPoder() < hechizo.getPoder()) {
                    if (cOrd.getPoder() > maxPoder) {
                        selIndex = i;
                        maxPoder = cOrd.getPoder();
                    }
                }
                i++;
            }

            if (selIndex > -1) {
                return juego.getJugadorActivo().getCartasEnJuego().get(selIndex);
            }
        }
        //si no podemos matar devolvemos null
        return null;
    }

    private Carta mejorObjectivoCriatura(Carta criatura, boolean optimo) {

        for (Carta c : juego.getJugadorPasivo().getCartasEnJuego()) {
            if (Objects.equals(c.getPoder(), criatura.getPoder())) {
                return c;
            }
        }

        if (!optimo) {
            //Buscar la mas grande de todas
            int selIndex = -1;
            int maxPoder = 0;
            int i = 0;
            for (Carta cFuerta : juego.getJugadorActivo().getCartasEnJuego()) {
                if (cFuerta.getPoder() > criatura.getPoder()) {
                    if (cFuerta.getPoder() > maxPoder) {
                        selIndex = i;
                        maxPoder = cFuerta.getPoder();
                    }
                }
                i++;
            }

            if (selIndex > -1) {
                return juego.getJugadorActivo().getCartasEnJuego().get(selIndex);
            }
        }
        //si no podemos matar devolvemos null
        return null;
    }

    private Carta objectivoCriaturaSeguro(Carta criatura) {

        //Buscar la mas grande de todas las que podamos matar sin morir
        int selIndex = -1;
        int maxPoder = 0;
        int i = 0;
        for (Carta cFuerta : juego.getJugadorActivo().getCartasEnJuego()) {
            if (cFuerta.getPoder() < criatura.getPoder()) {
                if (cFuerta.getPoder() > maxPoder) {
                    selIndex = i;
                    maxPoder = cFuerta.getPoder();
                }
            }
            i++;
        }

        if (selIndex > -1) {
            return juego.getJugadorActivo().getCartasEnJuego().get(selIndex);
        }

        //si no podemos matar devolvemos null
        return null;
    }

    private float calcChanceDePerder() {
        float vidasRestantes = (float) (yo.getVidas() - poderOponente);
        int cartasManoOp = juego.getJugadorPasivo().getCartasEnMano().size();
        int manaOp = juego.getJugadorPasivo().getManaTotal();
        //A mayot vidas restantes, menor es el total
        int peorCaso = 55;
        return ((20 - vidasRestantes) * 2 + cartasManoOp + manaOp) / peorCaso;

    }

    //Ordena basado en poder 
    private ArrayList<Carta> ordenar(ArrayList<Carta> cartas) {

        //Ordenar
        Collections.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                return o1.getPoder().compareTo(o2.getPoder());
            }
        });

        return cartas;
    }

    private class Par {

        Carta atacante;
        Carta objetivo;

        public Par(Carta atacante, Carta objetivo) {
            this.atacante = atacante;
            this.objetivo = objetivo;
        }
    }

}
