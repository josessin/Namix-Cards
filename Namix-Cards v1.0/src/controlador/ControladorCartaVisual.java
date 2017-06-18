/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import modelos.Carta;
import vistaImagenes.CartaVisual;
import vistaImagenes.PanelFondoCartaC;
import vistaImagenes.PanelFondoCartaH;
import vistaImagenes.PanelImagenCarta;
import vistas.PantallaPrincipal;

/**
 *
 * @author jeron
 */
public class ControladorCartaVisual {
    //Controladores
        ControladorPantalla conp = new ControladorPantalla();
        //Paneles
        PanelFondoCartaC fondoC = new PanelFondoCartaC();
        PanelFondoCartaH fondoH = new PanelFondoCartaH();
        PanelImagenCarta imaCart = new PanelImagenCarta();
        //Vistas
        PantallaPrincipal pp = new PantallaPrincipal();
        CartaVisual cv = new CartaVisual();
    
    public void AgregarFondoCarta(Carta.Tipo tipo) {
        
        if (tipo == Carta.Tipo.criatura) {
            
            cv.add(fondoC, BorderLayout.CENTER);
            fondoC.repaint();
            cv.setSize(pp.getWidth()/9, pp.getHeight()/4);
            cv.setLocation(pp.getWidth() - (cv.getWidth() + cv.getWidth()), pp.getHeight() - (cv.getHeight() + cv.getHeight()));
            conp.AgregarCartaATablero(cv);
            
        } else {
            cv.add(fondoH, BorderLayout.CENTER);
            fondoH.repaint();
            cv.setSize(pp.getWidth()/9, pp.getHeight()/4);
            cv.setLocation(pp.getWidth() - (cv.getWidth() + cv.getWidth()), pp.getHeight() - (cv.getHeight() + cv.getHeight()));
            conp.AgregarCartaATablero(cv);

        }

    }
    public void AgregarImagenCarta(String nombre) {
        
        imaCart.setNombre(nombre);
        imaCart.repaint();
        cv.setIma(imaCart);
        
    }
    
}
