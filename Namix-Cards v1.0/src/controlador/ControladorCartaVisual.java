/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import juego.Juego;
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

 

    private Juego juego;
    private ArrayList<CartaVisual> listadoCartas;
    private CartaVisual cv;
    //Paneles


    public ControladorCartaVisual(Juego juego) {

        
        this.juego = juego;
        listadoCartas = new ArrayList<>();
    }
    //METODO

    //METODO PARA IMAGEN DEL MONSTRUO EN EL CENTRO DE LA CARTA
    public void AgregarImagenCarta(String nombre, CartaVisual cv) {
        this.cv = cv;
        System.out.println("Estoy en agregar imagen de carta");
        PanelImagenCarta imaCart = new PanelImagenCarta();
        imaCart.setNombre(nombre);
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
        imaCart.setLocation(cv.getWidth()/2, cv.getHeight()/2);

        cv.add(imaCart);

    }
    
    public void AgregarCarta(CartaVisual cv, Carta carta, Juego juego){
            this.cv=cv;
            System.out.println("Estoy en agregar carta");
            cv.setValores(carta);
        }
        
    
    

    public void AgregarFondoCarta(Carta.Tipo tipo, CartaVisual cv) {
        this.cv=cv;
        System.out.println("Estot en Agregar FondoCarta");
        PanelFondoCartaC fondoC = new PanelFondoCartaC();
        PanelFondoCartaH fondoH = new PanelFondoCartaH();
        
        if (tipo.equals(Carta.Tipo.criatura)) {
            cv.add(fondoC, BorderLayout.CENTER);
            fondoC.repaint();


        } else {
            cv.add(fondoH, BorderLayout.CENTER);
            fondoH.repaint();


        }

    }
}
