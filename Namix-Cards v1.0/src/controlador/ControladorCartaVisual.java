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
        //Vistas
        private CartaVisual cv = new CartaVisual();
        private PantallaPrincipal pp;
        //Paneles
        PanelFondoCartaC fondoC = new PanelFondoCartaC();
        PanelFondoCartaH fondoH = new PanelFondoCartaH();
        PanelImagenCarta imaCart = new PanelImagenCarta();
        public ControladorCartaVisual(PantallaPrincipal datos){
            
        this.pp = datos;
       
        }
    //METODO
    public void AgregarFondoCarta(Carta.Tipo tipo) {
        ControladorPantalla conp = new ControladorPantalla();
        if (tipo == Carta.Tipo.criatura) {
            
            cv.add(fondoC, BorderLayout.CENTER);
            fondoC.repaint();
            conp.AgregarCartaATablero(cv);
            
        } else {
            cv.add(fondoH, BorderLayout.CENTER);
            fondoH.repaint();
            conp.AgregarCartaATablero(cv);

        }

    }
    //METODO PARA IMAGEN DEL MONSTRUO EN EL CENTRO DE LA CARTA
    public void AgregarImagenCarta(String nombre) {
        
        imaCart.setNombre(nombre);
        imaCart.repaint();
        cv.setImagen(imaCart);
        
    }
    
    public void AgregarCoste(Integer coste){
        
        cv.setLblMana(coste);
        
    }
    
    public void AgregarPoder(Integer poder){
    
        cv.setLblPoder(poder);
    
    }
    
    public void AgregarEfecto(Integer efecto){
    
        cv.setLblPoder(efecto);
    
    }
    
    public void AgregarNombre(String nombre){
    
        cv.setLblNombre(nombre);
    
    }

    
}
