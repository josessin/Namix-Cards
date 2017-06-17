/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Collections;
import juego.Juego;

/**
 *
 * @author Jose
 */
public class Jugador {
    
    public enum TipoJugador{
        pc,
        humano
    }

    private ArrayList<Carta> mazo;
    private ArrayList<Carta> cartasEnMano;
    private ArrayList<Carta> cartasEnJuego;
    //private boolean juegaPrimero;
    private int vidas;
    private int manaTotal;
    private int manaDisponible;
    
    private TipoJugador tipoJugador;
    
    public Jugador(ArrayList<Carta> mazo, boolean juegaPrimero){
        this.mazo = mazo;
        this.vidas = 20;
        
        if(juegaPrimero){
            this.manaDisponible = 1;
            this.manaTotal = 1;
        }else{
            this.manaDisponible = 2;
            this.manaTotal = 2;
        }
        mezclar();
        manoInicial();
        
    }
    
    
    private void mezclar(){
        Collections.shuffle(mazo);
    }
    
    private void manoInicial(){
        
        for (int i = 0; i < Juego.MANO_INICIAL; i++) {
            cartasEnMano.add(mazo.get(mazo.size()-1));
            mazo.remove(mazo.size()-1);
        }
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Carta> getCartasEnMano() {
        return cartasEnMano;
    }

    public void setCartasEnMano(ArrayList<Carta> cartasEnMano) {
        this.cartasEnMano = cartasEnMano;
    }

    public ArrayList<Carta> getCartasEnJuego() {
        return cartasEnJuego;
    }

    public void setCartasEnJuego(ArrayList<Carta> cartasEnJuego) {
        this.cartasEnJuego = cartasEnJuego;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getManaTotal() {
        return manaTotal;
    }

    public void setManaTotal(int manaTotal) {
        this.manaTotal = manaTotal;
    }

    public int getManaDisponible() {
        return manaDisponible;
    }

    public void setManaDisponible(int manaDisponible) {
        this.manaDisponible = manaDisponible;
    }

    public TipoJugador getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(TipoJugador tipoJugador) {
        this.tipoJugador = tipoJugador;
    }
    
    
    
}
