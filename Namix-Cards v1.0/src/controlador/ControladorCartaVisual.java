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
    private PanelFondoCartaC fondoC;
    private PanelFondoCartaH fondoH;
    private PanelCartaFondo fondoPC;
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
        imaCart.setLocation(cv.getWidth() / 4, cv.getHeight() / 4);
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
        fondoPC = new PanelCartaFondo(cv);
        cv.add(fondoPC, BorderLayout.CENTER);
        fondoPC.repaint();

    }

    public void AgregarFondoCarta(Carta.Tipo tipo, CartaVisual cv) {
        this.cv = cv;
        System.out.println("Estot en Agregar FondoCarta");
        fondoC = new PanelFondoCartaC(cv);
        fondoH = new PanelFondoCartaH();
        cv.add(fondoC);
        fondoC.repaint();
        /*cv.add(fondoC,BorderLayout.CENTER);
            fondoC.repaint();
            
            
        /*if (tipo.equals(Carta.Tipo.criatura)) {
            fondoC.setSize(cv.getWidth(), cv.getHeight());
            cv.add(fondoC, BorderLayout.CENTER);
            fondoC.repaint();


        } else {
            fondoH.setSize(cv.getWidth(), cv.getHeight());
            cv.add(fondoH, BorderLayout.CENTER);
            fondoH.repaint();


        }*/

    }
}
