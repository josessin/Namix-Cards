/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Carta;
import modelos.Jugador;

/**
 *
 * @author Usuario
 */
class AI {

    private Jugador yo;
    private Juego juego;
    private boolean mueroEnProxTurno;
    private int dañoExtraParaGanar;
    private int poderDisponible;
    private int dañoMaximoPosible;
    private ArrayList<Carta> combinacionMaxima;
    private float chanceDePerder;
    private float poderOponente;

    public AI(Juego juego, Jugador jugador) {

        this.yo = jugador;
        this.juego = juego;
        combinacionMaxima = new ArrayList<>();
    }

    public void play() {

        //Actuar
        evalVictoria();
        evalDerrota();
        jugar();
        juego.terminarTurno();
    }

    private void evalVictoria() {
        //Resetar valores
        poderDisponible = 0;
        combinacionMaxima.clear();

        dañoExtraParaGanar = calcDañoNesesario();
        dañoMaximoPosible = calcDañoMaximo();

    }

    private void evalDerrota() {

        chanceDePerder = 0;

        poderOponente = 0;
        for (Carta c : juego.getJugadorPasivo().getCartasEnJuego()) {
            poderOponente += c.getPoder();
        }
        if (poderOponente >= yo.getVidas()) {
            mueroEnProxTurno = true;
        } else {
            chanceDePerder = calcChanceDePerder();
        }

    }

    private void jugar() {
        //Matar oponenete si es posible
        if (dañoMaximoPosible >= dañoExtraParaGanar) {
            jugarCartas(combinacionMaxima);
            attacarJugador(yo.getCartasEnJuego());
            return;
        }
        if (mueroEnProxTurno) {
           hechizosACriaturas();

        }
    }

    private ArrayList<Carta> getCartasJugables() {
        //Seleccionas entre todas las cartas disponibles las jugables con el mana
        ArrayList<Carta> cartasJugables = new ArrayList<>();
        for (Carta c : yo.getCartasEnMano()) {
            if (c.getCoste() < yo.getManaDisponible()) {
                cartasJugables.add(c);
            }
        }
        return cartasJugables;

    }

    private int calcDañoMaximo() {
        int max = poderDisponible;
        max += cambinacionMaxima(getCartasJugables());
        return max;
    }

    private int cambinacionMaxima(ArrayList<Carta> cartasJugables) {

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
                combinacionMaxima = combActual;
            }

        }

        return mejorSumPoder;
    }

    private int calcDañoNesesario() {

        for (Carta c : yo.getCartasEnJuego()) {
            poderDisponible += c.getPoder();
        }
        return juego.getJugadorPasivo().getVidas() - poderDisponible;
    }

    private void jugarCartas(ArrayList<Carta> cartas) {
        for (Carta c : cartas) {
            if (c.getTipo() == Carta.Tipo.criatura) {
                juego.cartaClickeda(c);
            } else {
                juego.cartaClickeda(c);
                juego.oponenteClickeado(yo);
            }
            pause(500);
        }
    }

    private void attacarJugador(ArrayList<Carta> cartas) {
        for (Carta c : cartas) {
            juego.cartaClickeda(c);
            pause(500);
        }
    }

    private void pause(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private float calcChanceDePerder() {
        float vidasRestantes = (float) (yo.getVidas() - poderOponente) / 20;
        int cartasManoOp = juego.getJugadorPasivo().getCartasEnMano().size();
        int manaOp = juego.getJugadorPasivo().getManaTotal();
        //A mayot vidas restantes, menor es el total
        int peorCaso = 75;
        return ((20 - vidasRestantes) * 3 + cartasManoOp + manaOp) / peorCaso;

    }

    private void hechizosACriaturas() {

        for (Carta hechizo : yo.getCartasEnMano()) {
            if (hechizo.getTipo() == Carta.Tipo.hechizo && hechizo.getCoste() <= yo.getManaDisponible()) {
                Carta cartaADañar = encontrarMejorObjetivo(hechizo);
                if(cartaADañar != null){
                    juego.cartaClickeda(hechizo);
                    juego.cartaClickeda(cartaADañar);
                    
                }
            }
        }
    }

    private Carta encontrarMejorObjetivo(Carta hechizo) {
        //buscar carta de igual poder
        for (Carta cObj : juego.getJugadorPasivo().getCartasEnJuego()) {
            if (cObj.getPoder() == hechizo.getPoder()) {
                return cObj;
            }
        }
        
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
        
        if(selIndex > -1){
            return juego.getJugadorActivo().getCartasEnJuego().get(selIndex);
        }
        //si no podemos matar devolvemos null
        return null;
    }

    //Crea un nuevo array de cartas basado en poder 
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

}
