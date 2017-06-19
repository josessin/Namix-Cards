/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import modelos.Jugador;

/**
 *
 * @author Usuario
 */
class AI {

    private Jugador jugador;
    private Juego juego;
    
    public AI(Juego juego, Jugador jugador) {

        this.jugador = jugador;
        this.juego = juego;
    }

    public void play() {
        juego.terminarTurno();
    }

}
