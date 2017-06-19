/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import modelos.Carta;
import modelos.Carta.Tipo;
import modelos.InfoVisualJuego;
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

    public ControladorCartaVisual(PantallaPrincipal datos) {

        this.pp = datos;

    }
    //METODO

    //METODO PARA IMAGEN DEL MONSTRUO EN EL CENTRO DE LA CARTA
    public void AgregarImagenCarta(String nombre) {
        //imaCart.setNombre(nombre);
        imaCart.repaint();
        //imaCart.setBackground(Color.BLUE);
        imaCart.setSize(cv.getWidth() / 2, cv.getHeight() / 2);
        javax.swing.GroupLayout ImagenLayout = new javax.swing.GroupLayout(imaCart);
        imaCart.setLayout(ImagenLayout);
        ImagenLayout.setHorizontalGroup(
                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        ImagenLayout.setVerticalGroup(
                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        imaCart.setLocation(cv.getWidth(), cv.getHeight());

        cv.add(imaCart);

    }

    public void AgregarNombre(String nombre) {

        cv.setNombre(nombre);

    }

    public void AgregarCoste(Integer coste) {

        cv.setMana(coste);

    }

    public void AgregarTipo(Carta.Tipo tipo) {

        cv.setTipo(String.valueOf(tipo));

    }

    public void AgregarPoder(Integer poder) {

        cv.setPoder(poder);

    }

    public void AgregarEfecto(Integer efecto) {

        cv.setPoder(efecto);

    }

    public void AgregarFondoCarta(Carta.Tipo tipo, int aux, InfoVisualJuego inf) {
        ControladorPantalla conp = new ControladorPantalla();
        if (tipo.equals(Carta.Tipo.criatura)) {
            cv.add(fondoC, BorderLayout.CENTER);
            fondoC.repaint();
            conp.AgregarCartaATablero(cv, pp, aux, inf);

        } else {
            cv.add(fondoH, BorderLayout.CENTER);
            fondoH.repaint();
            conp.AgregarCartaATablero(cv, pp, aux, inf);

        }

    }
}
