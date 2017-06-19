/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import controlador.ControladorPantalla;
import datos.Datos;
import java.util.ArrayList;
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

    private Jugador Jugador1;
    private Jugador Jugador2;
    private InfoVisualJuego infoVisual;
    private ControladorPantalla contPant;
    
    public Juego() {
        infoVisual = new InfoVisualJuego();
        contPant = new ControladorPantalla();
        contPant.StartPantalla();
        nuevoJuego();
    }

    private void nuevoJuego() {
        crearJugagores();
       //actualizarPantallas inicial
        actualizarPantalla();
    }

    private void crearJugagores() {

        if (HOMBRE_VS_PC) {
            Datos d = new Datos();
            //Cargar el mazo de el archivo .csv
            ArrayList<Carta> mazoJugador1 = d.cargarDatos("csv/mazo1v2.csv");
             ArrayList<Carta> mazoJugador2 = d.cargarDatos("csv/mazo1v2.csv");
            //Humano
            Jugador1 = new Jugador(mazoJugador1, true);
            Jugador1.setTipoJugador(Jugador.TipoJugador.humano);
            //PC
            Jugador2 = new Jugador(mazoJugador2, false);
            Jugador2.setTipoJugador(Jugador.TipoJugador.pc);
            
        } else {
            //TODO: hombre vs hombre
        }
    }

    private void actualizarPantalla() {
        
        infoVisual.actualizarInfo(Jugador1, Jugador1);
        contPant.ActualizarPantalla(infoVisual);
    }


}
