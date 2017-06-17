/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

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
    private InfoVisualJuego ivj;

    public Juego() {
        ivj = new InfoVisualJuego();
        nuevoJuego();
    }

    private void nuevoJuego() {
        CrearJugagores();

        //Actualizar Pantallas
    }

    private void CrearJugagores() {

        if (HOMBRE_VS_PC) {
            Datos d = new Datos();
            //Cargar el mazo de el archivo .csv
            ArrayList<Carta> mazo = d.cargarDatos("csv/mazo1v2.csv");
            //Humano
            Jugador1 = new Jugador(mazo, true);
            Jugador1.setTipoJugador(Jugador.TipoJugador.humano);
            //PC
            Jugador2 = new Jugador(mazo, false);
            Jugador2.setTipoJugador(Jugador.TipoJugador.pc);
            
        } else {
            //TODO: hombre vs hombre
        }
    }

    private void actualizarPantalla() {

    }

}
