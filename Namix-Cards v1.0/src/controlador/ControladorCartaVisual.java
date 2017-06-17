/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import modelos.Carta;
import vistaImagenes.PanelCartaVisual;
import vistas.CartaVisual;

/**
 *
 * @author jeron
 */
public class ControladorCartaVisual {

    CartaVisual cv;
    Carta carta;
    PanelCartaVisual Pcv;
    Graphics g;

    public ControladorCartaVisual(CartaVisual cv, Carta carta) {
        this.cv = cv;
        this.carta = carta;
        Pcv = new PanelCartaVisual();
        if (carta.getTipo() == Carta.Tipo.criatura) {
            Pcv.paintmonstruo(g);
            cv.add(Pcv, BorderLayout.CENTER);
            cv.repaint();
        } else {
            Pcv.painthechizo(g);
            cv.add(Pcv, BorderLayout.CENTER);
            cv.repaint();
        }        
        
        String nombre = carta.getNombre();
        
        cv.pintarCriatura(g, nombre);
        

    }

}
