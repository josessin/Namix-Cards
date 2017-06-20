/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.util.ArrayList;
import juego.Juego;
import modelos.Carta;
import vistaImagenes.CartaVisual;
import vistaImagenes.PanelCartaFondo;
import vistaImagenes.PanelFondoCartaC;
import vistaImagenes.PanelFondoCartaH;
import vistaImagenes.PanelImagenCarta;

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
    PanelFondoCartaH fondoH = new PanelFondoCartaH();
    PanelFondoCartaC fondoC = new PanelFondoCartaC();
    PanelCartaFondo fondoPC = new PanelCartaFondo();

    public ControladorCartaVisual(Juego juego) {

        this.juego = juego;
        listadoCartas = new ArrayList<>();
    }
    //METODO

    //METODO PARA IMAGEN DEL MONSTRUO EN EL CENTRO DE LA CARTA
    public void AgregarImagenCarta(String nombre, CartaVisual cv) {
        this.cv = cv;
        PanelImagenCarta imaCart = new PanelImagenCarta();
        imaCart.setNombre(nombre);

        //imaCart.setBackground(Color.BLUE);
        imaCart.setSize(cv.getWidth() - 10, cv.getHeight() -15);
        javax.swing.GroupLayout ImagenLayout = new javax.swing.GroupLayout(imaCart);
        imaCart.setLayout(ImagenLayout);
        ImagenLayout.setHorizontalGroup(
                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        ImagenLayout.setVerticalGroup(
                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        imaCart.setLocation(cv.getWidth() / 22, cv.getHeight() / 32);
        imaCart.repaint();
        cv.add(imaCart);

    }

    public void AgregarCarta(CartaVisual cv, Carta carta, Juego juego, boolean escondido) {

        this.cv = cv;
        if (escondido == false) {
            cv.setValores(carta);

        } else {

            cv.setValores(carta, escondido);

        }
    }

    public void AgregarFondoManoPc(CartaVisual cv) {
        this.cv = cv;
        
        
        fondoPC.setSize(cv.getWidth(), cv.getHeight());  
        cv.add(fondoPC, BorderLayout.CENTER);
        fondoPC.repaint();

    }

    public void AgregarFondoCarta(Carta.Tipo tipo, CartaVisual cv) {
        this.cv = cv;
        
        
        /*cv.add(fondoC,BorderLayout.CENTER);
            fondoC.repaint();*/
            
            
        if (tipo.equals(Carta.Tipo.criatura)) {
            
            fondoC.setSize(cv.getWidth(), cv.getHeight());
            cv.add(fondoC, BorderLayout.CENTER);
            //cv.repaint();
            fondoC.repaint();    

        } else {
            
            fondoH.setSize(cv.getWidth(), cv.getHeight());
            cv.add(fondoH, BorderLayout.CENTER);
            //cv.repaint();
            fondoH.repaint();


        }

    }
    //Metodo para cambiar el fondo a las cartas
    /*public void RemueveDespuesDeAtaque(Carta.Tipo tipo, CartaVisual cv){
    
        if (tipo.equals(Carta.Tipo.criatura)) {
            
            cv.remove(fondoC);
            AgregarFondoManoPc(cv);

        } else {
            
            cv.remove(fondoH);
            AgregarFondoManoPc(cv);
        }
    
    }*/
}
