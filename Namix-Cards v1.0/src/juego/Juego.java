/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controlador.ControladorPantalla;
import datos.Datos;
import java.util.ArrayList;
import jose.ControlVistaPrincipal;
import modelos.Carta;
import modelos.InfoVisualJuego;
import modelos.Jugador;

/**
 *
 * @author Jose
 */
public class Juego {

    //VARIABLES GLOBALES ESTATICAS
    public static final int VIDAS = 20;
    public static final int MANO_INICIAL = 5;
    public static final boolean HOMBRE_VS_PC = true;

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActivo;
    private InfoVisualJuego infoVisual;
    private ControladorPantalla contPant;
    private Carta cartaActiva = null;
    private AI ai;
    
    //TEST
    private ControlVistaPrincipal contVistaPPL;

    public Juego() {
        infoVisual = new InfoVisualJuego();
        //OJO! COMENTADO PARA PRUEBAS NO COMMITEAR
        //contPant = new ControladorPantalla();

        //ESTO ES PARA PROBAR VISTA JOSE
        contVistaPPL = new ControlVistaPrincipal(this);

        nuevoJuego();
    }

    public void cartaClickeda(Carta carta) {
        //Si el click se realiza por el jugador cuando no esta activo, y se esta jugando contra la pc, se sale inmediatamente
        if (!carta.getJugador().isActivo() && jugador2.getTipoJugador() == Jugador.TipoJugador.pc) {
            return;
        }

        if (carta.isEnJuego()) {
            //TODO;
        } else {
            jugarCarta(carta);
        }

        actualizarPantalla();
    }

    public void terminarTurno() {

        if (jugadorActivo == jugador1) {
            jugadorActivo = jugador2;
            jugador1.setActivo(false);
            jugador2.setActivo(true);
        } else {
            jugadorActivo = jugador1;
            jugador1.setActivo(true);
            jugador2.setActivo(false);
        }

        //Incrementar y resetear el mana
        jugadorActivo.setManaTotal(jugadorActivo.getManaTotal() + 1);
        jugadorActivo.setManaDisponible(jugadorActivo.getManaTotal());
        jugadorActivo.robarCarta();

        if (jugadorActivo.getTipoJugador() == Jugador.TipoJugador.pc) {
            ai.play();
        }
        actualizarPantalla();
    }

    private void nuevoJuego() {
        crearJugagores();
        actualizarPantalla();
    }

    private void crearJugagores() {

        Datos d = new Datos();
        //Cargar el mazo de el archivo .csv
        ArrayList<Carta> mazoJugador1 = d.cargarDatos("src/csv/mazo1v2.csv");
        ArrayList<Carta> mazoJugador2 = d.cargarDatos("src/csv/mazo1v2.csv");
        //Humano
        jugador1 = new Jugador(mazoJugador1, true);
        jugador1.setTipoJugador(Jugador.TipoJugador.humano);
        jugadorActivo = jugador1;
        //PC
        jugador2 = new Jugador(mazoJugador2, false);
        jugador2.setTipoJugador(Jugador.TipoJugador.pc);
        ai = new AI(this,jugador2);
        
    }

    private void actualizarPantalla() {

        infoVisual.actualizarInfo(jugador1, jugador2);

        //OJO! COMENTADO PARA PRUEBAS NO COMMITEAR
        //contPant.ActualizarPantalla(infoVisual);
        contVistaPPL.actualizarPantalla(infoVisual);
    }

    private void jugarCarta(Carta carta) {

        if (jugadorActivo.getManaDisponible() >= carta.getCoste()) {
            carta.setEnJuego(true);
            jugadorActivo.getCartasEnMano().remove(carta);
            jugadorActivo.getCartasEnJuego().add(carta);
            //restar el mana disponible
            jugadorActivo.setManaDisponible(jugadorActivo.getManaDisponible() - carta.getCoste());
        }

    }

}
