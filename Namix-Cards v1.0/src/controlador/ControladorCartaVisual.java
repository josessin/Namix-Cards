/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import modelos.Carta;
import vistas.CartaVisual;

/**
 *
 * @author jeron
 */
public class ControladorCartaVisual {
    
    CartaVisual cv;
    Carta carta;

    public ControladorCartaVisual(CartaVisual cv, Carta carta) {
        this.cv = cv;
        this.carta = carta;
        if (carta.getTipo() == Carta.Tipo.criatura) {
                

        }
        

    }
}
