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
import vistaImagenes.PanelPantallaPrin;
import vistas.PantallaPrincipal;

/**
 *
 * @author jeron
 */
public class ControladorPantalla {

    InfoVisualJuego inf = new InfoVisualJuego();
    Graphics g;

    public void StartPantalla() {

        PanelPantallaPrin fondo = new PanelPantallaPrin();
        PantallaPrincipal ventana = new PantallaPrincipal();
        ventana.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        ventana.setVisible(true);
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {

        ArrayList<Carta> cjugador = inf.getCartasJugadorMano();
        ArrayList<Carta> cPcT = inf.getCartasPCTablero();
        ArrayList<Carta> cjugadorT = inf.getCartasJugadorTablero();

        for (int i = 0; i < cjugador.size(); i++) {
            AgregarImagenCarta(cjugador.get(i).getNombre());
            AgregarFondoCarta(cjugador.get(i).getTipo());

        }
        for (int i = 0; i < cPcT.size(); i++) {
            AgregarImagenCarta(cPcT.get(i).getNombre());
            AgregarFondoCarta(cPcT.get(i).getTipo());
        }

    }

    public void AgregarImagenCarta(String nombre) {
        

    }

    public void AgregarFondoCarta(Carta.Tipo tipo) {

        if (tipo == Carta.Tipo.criatura) {
            CartaVisual cv = new CartaVisual();

            cv.paintC(g);
        } else {
            CartaVisual cv = new CartaVisual();

            cv.paintH(g);
            PantallaPrincipal pp = new PantallaPrincipal();
            pp.add(cv);

        }

    }

}
