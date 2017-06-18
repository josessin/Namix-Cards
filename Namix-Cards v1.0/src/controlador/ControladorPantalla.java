/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import modelos.Carta;
import modelos.InfoVisualJuego;
import vistaImagenes.CartaVisual;
import vistaImagenes.PanelFondoCartaC;
import vistaImagenes.PanelFondoCartaH;
import vistaImagenes.PanelImagenCarta;
import vistaImagenes.PanelPantallaPrin;
import vistas.PantallaPrincipal;

/**
 *
 * @author jeron
 */
public class ControladorPantalla {

    InfoVisualJuego inf = new InfoVisualJuego();
    PantallaPrincipal pp = new PantallaPrincipal();
    
 
    /*PantallaPrincipal pp = new PantallaPrincipal();
    PanelImagenCarta pima = new PanelImagenCarta();
    PanelFondoCartaC fondoC = new PanelFondoCartaC();
    PanelFondoCartaH fondoH = new PanelFondoCartaH();
    CartaVisual cv = new CartaVisual();*/
    

    public void StartPantalla() {
        PantallaPrincipal pp = new PantallaPrincipal();
        PanelPantallaPrin fondo = new PanelPantallaPrin();
        pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        pp.setVisible(true);
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {
        ControladorCartaVisual ccv = new ControladorCartaVisual();
        
        ArrayList<Carta> cjugador = inf.getCartasJugadorMano();
        ArrayList<Carta> cPcT = inf.getCartasPCTablero();
        ArrayList<Carta> cjugadorT = inf.getCartasJugadorTablero();

        for (int i = 0; i < cjugador.size(); i++) {
            ccv.AgregarImagenCarta(cjugador.get(i).getNombre());
            ccv.AgregarFondoCarta(cjugador.get(i).getTipo());

        }
        for (int i = 0; i < cPcT.size(); i++) {
            ccv.AgregarImagenCarta(cPcT.get(i).getNombre());
            ccv.AgregarFondoCarta(cPcT.get(i).getTipo());
        }
        for (int i = 0; i < cjugadorT.size(); i++) {
            ccv.AgregarImagenCarta(cjugadorT.get(i).getNombre());
            ccv.AgregarFondoCarta(cjugadorT.get(i).getTipo());
            
        }

    }

    
    public void AgregarCartaATablero(CartaVisual cv){
        pp.add(cv);
        
    
    }
}