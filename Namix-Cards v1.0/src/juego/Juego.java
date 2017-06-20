/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controlador.ControladorPantalla;
import datos.Datos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    private Jugador jugadorPasivo;
    private InfoVisualJuego infoVisual;
    private ControladorPantalla contPant;
    private Carta cartaCriaturaActiva = null;
    private Carta cartaHechizoActiva = null;
    private AI ai;

    //TEST
    private ControlVistaPrincipal contVistaPPL;

    public Juego() {
        infoVisual = new InfoVisualJuego();
        //OJO! COMENTADO PARA PRUEBAS NO COMMITEAR

        //ESTO ES PARA PROBAR VISTA JOSE
        //contVistaPPL = new ControlVistaPrincipal(this);
        contPant = new ControladorPantalla(this);
        nuevoJuego();
    }

    public void cartaClickeda(Carta carta) {

        if (carta.isEnJuego()) {
            if (carta.getJugador().equals(jugadorActivo)) {
                desactivarHechizo();
                if (!carta.isAtaco()) {
                    cartaCriaturaActiva = carta;
                    cartaCriaturaActiva.setActiva(true);
                }
            } else if (carta.getJugador().equals(jugadorPasivo)) {
                if (cartaCriaturaActiva != null) {
                    atacarCarta(carta);
                } else if (cartaHechizoActiva != null) {
                    dañarCarta(carta);
                }
            }
        } else if (carta.getJugador().equals(jugadorActivo)) {

            if (carta.getTipo() == Carta.Tipo.criatura) {
                jugarCarta(carta);
            } else if (carta.getCoste() <= jugadorActivo.getManaDisponible()) {

                if (cartaHechizoActiva == null) {
                    desactivarCriatura();
                    cartaHechizoActiva = carta;
                    cartaHechizoActiva.setActiva(true);
                } else {

                }
            }
        }
        actualizarPantalla();
    }

    public void oponenteClickeado(Jugador oponente) {
        if (oponente.equals(jugadorPasivo)) {
            if (cartaHechizoActiva != null) {
                dañarOponente(cartaHechizoActiva, oponente);
                jugadorActivo.getCartasEnMano().remove(cartaHechizoActiva);
                jugadorActivo.setManaDisponible(jugadorActivo.getManaDisponible() - cartaHechizoActiva.getCoste());
                cartaHechizoActiva.setActiva(false);
                cartaHechizoActiva = null;
            }
            if (cartaCriaturaActiva != null) {
                dañarOponente(cartaCriaturaActiva, oponente);
                cartaCriaturaActiva.setAtaco(true);
                cartaCriaturaActiva.setActiva(false);
                cartaCriaturaActiva = null;

            }
        }
        actualizarPantalla();
    }

    public void terminarTurno() {
        
        System.out.println("<<< TURNO DE: " + jugadorPasivo.getNombre().toUpperCase() + " >>>");
        desactivarCartasActivas();

        if (jugadorActivo == jugador1) {
            jugadorActivo = jugador2;
            jugadorPasivo = jugador1;
            jugador1.setActivo(false);
            jugador2.setActivo(true);
        } else {
            jugadorActivo = jugador1;
            jugadorPasivo = jugador2;
            jugador1.setActivo(true);
            jugador2.setActivo(false);
        }
        resetarCartas(jugadorActivo);

        //Incrementar y resetear el mana
        jugadorActivo.setManaTotal(jugadorActivo.getManaTotal() + 1);
        jugadorActivo.setManaDisponible(jugadorActivo.getManaTotal());
        jugadorActivo.robarCarta();

        actualizarPantalla();
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
        jugador1.setNombre("Humano");
        jugadorActivo = jugador1;

        //Ordenador
        jugador2 = new Jugador(mazoJugador2, false);
        jugador2.setTipoJugador(Jugador.TipoJugador.pc);
        jugador2.setNombre("Ordenador");
        jugadorPasivo = jugador2;
        ai = new AI(this, jugador2);

        System.out.println("<<< TURNO DE: " + jugadorActivo.getNombre().toUpperCase() + " >>>");
    }

    private void actualizarPantalla() {

        infoVisual.actualizarInfo(jugador1, jugador2);

        contPant.ActualizarPantalla(infoVisual);
        //OJO! PARA PRUEBAS NO COMMITEAR
        //contVistaPPL.actualizarPantalla(infoVisual);
    }

    //Metodos de juego
    private void jugarCarta(Carta carta) {

        if (jugadorActivo.getManaDisponible() >= carta.getCoste()) {
            if (jugadorActivo.getCartasEnJuego().size() <= 8) {
                carta.setEnJuego(true);
                jugadorActivo.getCartasEnMano().remove(carta);
                jugadorActivo.getCartasEnJuego().add(carta);
                //restar el mana disponible
                jugadorActivo.setManaDisponible(jugadorActivo.getManaDisponible() - carta.getCoste());
                System.out.println("Jugar Carta: " + carta.getNombre());
            }else{
                System.out.println("Intento de jugar nueva criatura negado: no se pueden tener mas de 8 cartas en juego");
                JOptionPane.showMessageDialog(null, "No se pueden jugar mas cartas, 8 es el máximo");
            }
        }
        actualizarPantalla();
    }

    private void atacarCarta(Carta cartaAtacada) {

        if (cartaCriaturaActiva == null) {
            return;
        }
        System.out.println("Atacando: " + cartaCriaturaActiva.getNombre() + " ataca a " + cartaAtacada.getNombre());
        //Se hacen daño (debemos guardar el poder para poder usarlo luego de cambiarlo)
        int poderCriaturaAtacada = cartaAtacada.getPoder();
        cartaAtacada.setPoder(cartaAtacada.getPoder() - cartaCriaturaActiva.getPoder());
        cartaCriaturaActiva.setPoder(cartaCriaturaActiva.getPoder() - poderCriaturaAtacada);
        cartaCriaturaActiva.setAtaco(true);
        cartaCriaturaActiva.setActiva(false);
        //Resolucion
        if (cartaAtacada.getPoder() <= 0) {
            System.out.println("Muere " + cartaAtacada.getNombre() + " de " + cartaAtacada.getJugador().getNombre());
            jugadorPasivo.getCartasEnJuego().remove(cartaAtacada);

        }

        if (cartaCriaturaActiva.getPoder() <= 0) {
            System.out.println("Muere " + cartaCriaturaActiva.getNombre() + " de " + cartaCriaturaActiva.getJugador().getNombre());
            jugadorActivo.getCartasEnJuego().remove(cartaCriaturaActiva);
            cartaCriaturaActiva = null;
        }
        actualizarPantalla();
    }

    private void dañarCarta(Carta carta) {
        if (cartaHechizoActiva == null) {
            return;
        }
        System.out.println("Hechizo: " + cartaHechizoActiva.getNombre() + " daña a " + carta.getNombre());
        carta.setPoder(carta.getPoder() - cartaHechizoActiva.getPoder());
        jugadorActivo.setManaDisponible(jugadorActivo.getManaDisponible() - carta.getCoste());
        if (carta.getPoder() <= 0) {
            System.out.println("Muere " + carta.getNombre() + " de " + carta.getJugador().getNombre());
            jugadorPasivo.getCartasEnJuego().remove(carta);
            jugadorActivo.getCartasEnMano().remove(cartaHechizoActiva);
            cartaHechizoActiva = null;
        }
        actualizarPantalla();

    }

    private void dañarOponente(Carta cartaAgresora, Jugador oponente) {

        oponente.setVidas(oponente.getVidas() - cartaAgresora.getPoder());
        String dañado;
        System.out.println(cartaAgresora.getNombre() + " hace " + cartaAgresora.getPoder() + " daños a " + jugadorPasivo.getNombre());
        actualizarPantalla();
        if (oponente.getVidas() <= 0) {
            //Juego terminado
            JOptionPane.showMessageDialog(null, "Juego Terminado! A ganado el" + jugadorActivo.getNombre());
            //TODO: mejorar salida de el programa
            System.exit(0);
        }

    }

    //metodos de mantenimiento
    private void resetarCartas(Jugador jugadorActivo) {
        for (Carta c : jugadorActivo.getCartasEnJuego()) {
            c.setAtaco(false);
            c.setActiva(false);
        }
    }

    private void desactivarCartasActivas() {
        desactivarCriatura();
        desactivarHechizo();
    }

    private void desactivarHechizo() {
        if (cartaHechizoActiva != null) {
            cartaHechizoActiva.setActiva(false);
            cartaHechizoActiva = null;
        }
    }

    private void desactivarCriatura() {
        if (cartaCriaturaActiva != null) {
            cartaCriaturaActiva.setActiva(false);
            cartaCriaturaActiva = null;
        }
    }

    //GETERS
    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public Jugador getJugadorPasivo() {
        return jugadorPasivo;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

}
