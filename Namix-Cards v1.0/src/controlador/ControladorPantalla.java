/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
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

    //Para Prueba -------------------------------------------------
    /*InfoVisualJuego info = new InfoVisualJuego();
    Carta carta = new Carta("asesino", 50, 50, Carta.Tipo.criatura);
    Carta carta1 = new Carta("elfo", 5, 5, Carta.Tipo.criatura);
    Carta carta2 = new Carta("golem", 10, 10, Carta.Tipo.criatura);

    public ControladorPantalla() {

        ArrayList<Carta> listaJM = new ArrayList<Carta>();
        listaJM.add(carta);
        listaJM.add(carta1);
        listaJM.add(carta2);
        info.setCartasJugadorMano(listaJM);
        info.setCartasJugadorTablero(listaJM);
        info.setCartasPCTablero(listaJM);
        info.setCartasPCMano(listaJM);

    }*/
    //************************************************
    //VISTAS 
    PantallaPrincipal pp = new PantallaPrincipal();
    //CONTROLADOR

    public void StartPantalla() {

        PanelPantallaPrin fondo = new PanelPantallaPrin();
        Dimension tam = Toolkit.getDefaultToolkit().getScreenSize();
        pp.setSize(tam);
        
        /*pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();*/
        pp.setVisible(true);
        //************************************
        // ActualizarPantalla(info); //PARA PRUEBA
        //***********************************
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {
        //Se inicializa la pantalla
        StartPantalla();//SE TIENE Q COMENTAR PARA PRUEBA
        //SE ENVIA LA INFORAMCION A PANTALLA PRINCIPAL
        pp.CargaInfoJuego(inf.getVidasJugador(), inf.getVidasPC(), inf.getManaTotalJugador(), inf.getManaTotalPC(),
                inf.getManaDispJugador(), inf.getManaDispPC(), inf.getCartasJugadorMano(),
                inf.getCartasJugadorTablero(), inf.getCartasPCTablero(), inf.getCartasPCMano());
        //SE LLAMAN A LOS METODOS PARA CREAR LAS CARTAS DE LOS JUGADORES
        int aux = 1;
        CargarCartas(inf.getCartasJugadorMano(), aux, inf);
        aux = 2;
        CargarCartas(inf.getCartasJugadorTablero(), aux, inf);
        aux = 3;
        CargarCartas(inf.getCartasPCTablero(), aux, inf);
        aux = 4;
        CargarCartas(inf.getCartasPCMano(), aux, inf);
    }

    //METODO CARGA CARTAS JUGADOR
    public void CargarCartas(ArrayList<Carta> InfoCartas, int aux, InfoVisualJuego inf) {
        ControladorCartaVisual ccv = new ControladorCartaVisual(pp);
        for (int i = 0; i < InfoCartas.size(); i++) {

            //SE LLAMAN A LOS METODOS DEL CONTROLADOR DE CARTA VISUAL
            ccv.AgregarImagenCarta(InfoCartas.get(i).getNombre());
            ccv.AgregarNombre(InfoCartas.get(i).getNombre());
            ccv.AgregarCoste(InfoCartas.get(i).getCoste());
            if (InfoCartas.get(i).getTipo().equals(Carta.Tipo.criatura)) {
                ccv.AgregarTipo(Carta.Tipo.criatura);
                ccv.AgregarPoder(InfoCartas.get(i).getPoder());
            } else {
                ccv.AgregarTipo(Carta.Tipo.hechizo);
                ccv.AgregarEfecto(InfoCartas.get(i).getPoder());
            }
            ccv.AgregarFondoCarta(InfoCartas.get(i).getTipo(), aux, inf);

        }

    }
    //SE COLOCA LA CARTA EN PANTALLA PRINCIPAL

    public void AgregarCartaATablero(CartaVisual cv, PantallaPrincipal pp, int aux, InfoVisualJuego inf) {

        if (aux == 1) {
            for (int i = 0; i < inf.getCartasJugadorMano().size(); i++) {
                cv.setSize(pp.getWidth() / 10, pp.getHeight() / 4);
                    pp.getContentPane().add(cv);
                    Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) -  cv.getWidth()*inf.getCartasJugadorMano().size()/2+i*(cv.getWidth()+ 20);
                    p.y = pp.getHeight() - 100 - cv.getSize().height;
                    cv.setLocation(p);
                    cv.setVisible(true);
                    pp.pack();

            }
        } else {
            /*if (aux == 2) {
                for (int i = 0; i < inf.getCartasJugadorTablero().size(); i++) {
                    cv.setSize(pp.getWidth() / 10, pp.getHeight() / 4);
                    pp.getContentPane().add(cv);
                    Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) -  cv.getWidth()*inf.getCartasJugadorTablero().size()/2+i*(cv.getWidth()+ 20);
                    p.y = pp.getHeight() - 100 - cv.getSize().height;
                    cv.setLocation(p);
                    cv.setVisible(true);
                    pp.pack();
                }
            } else {
                if (aux == 3) {
                    for (int i = 0; i < inf.getCartasPCTablero().size(); i++) {
                        cv.setSize(pp.getWidth() / 10, pp.getHeight() / 4);
                    pp.getContentPane().add(cv);
                    Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) -  cv.getWidth()*inf.getCartasPCTablero().size()/2+i*(cv.getWidth()+ 20);
                    p.y = pp.getHeight() - 100 - cv.getSize().height;
                    cv.setLocation(p);
                    cv.setVisible(true);
                    pp.pack();                    }

                } else {
                    for (int i = 0; i < inf.getCartasPCMano().size(); i++) {
                        cv.setSize(pp.getWidth() / 10, pp.getHeight() / 4);
                    pp.getContentPane().add(cv);
                    Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) -  cv.getWidth()*inf.getCartasPCMano().size()/2+i*(cv.getWidth()+ 20);
                    p.y = pp.getHeight() - 100 - cv.getSize().height;
                    cv.setLocation(p);
                    cv.setVisible(true);
                    pp.pack();
                    }
                }
            }*/
        }
        cv.getNombre();
        cv.getMana();
        cv.getPoder();
        cv.getTipo();

        //pp.add(cv);

    }
}
