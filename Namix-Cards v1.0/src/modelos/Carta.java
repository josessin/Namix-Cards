/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Usuario
 */
public class Carta {
    
    protected String nombre;
    public enum Tipo{
        hechizo,
        criatura
    }
    protected Tipo tipo;
    protected Integer coste;
    protected boolean enJuego;
    protected Jugador jugador;
    
    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Integer getCoste() {
        return coste;
    }
    
    
    
}
