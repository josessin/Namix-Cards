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
import juego.Juego;
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
    private Juego juego;
    private final PantallaPrincipal pp;
    private ArrayList<CartaVisual> cartasParaMostrar;
    private InfoVisualJuego inf;

    public ControladorPantalla(Juego juego){
        this.juego = juego;
        pp = new PantallaPrincipal(this);
        cartasParaMostrar = new ArrayList<>();
        
    }
    public void StartPantalla() {

        PanelPantallaPrin fondo = new PanelPantallaPrin();
        Dimension tam = Toolkit.getDefaultToolkit().getScreenSize();
        pp.setSize(tam);
        
        pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        pp.setVisible(true);
       

    }

    public void ActualizarPantalla(InfoVisualJuego inf) {
        if (inf == null) {
            return;
        }
         DestruirCartasViejas();
        //Se inicializa la pantalla
        StartPantalla();
        
        this.inf = inf;
        
        //SE ENVIA LA INFORAMCION A PANTALLA PRINCIPAL
        pp.CargaInfoJuego(inf.getVidasJugador(), inf.getVidasPC(), inf.getManaTotalJugador(), inf.getManaTotalPC(),
                inf.getManaDispJugador(), inf.getManaDispPC(), inf.getCartasJugadorMano(),
                inf.getCartasJugadorTablero(), inf.getCartasPCTablero(), inf.getCartasPCMano());
        
        //SE LLAMAN A LOS METODOS PARA CREAR LAS CARTAS DE LOS JUGADORES
        
        CargarCartas(inf.getCartasJugadorMano(),pp.getHeight()/15.0F, false);
        CargarCartas(inf.getCartasJugadorTablero(), pp.getHeight()/4.5F, false);
        CargarCartas(inf.getCartasPCTablero(),( pp.getHeight() - pp.getHeight() / 2.5f), false);
        CargarCartas(inf.getCartasPCMano(), ( pp.getHeight() - pp.getHeight() / 9.0f), false);
    }

    //METODO CARGA CARTAS JUGADOR
    public void CargarCartas(ArrayList<Carta> InfoCartas, float posicionY, boolean escondido) {
        ControladorCartaVisual ccv = new ControladorCartaVisual(juego);
        for (int i = 0; i < InfoCartas.size(); i++) {
            CartaVisual cv = new CartaVisual(juego);
            cartasParaMostrar.add(cv);
            int aux = InfoCartas.size();
            if(aux<5){
                cv.setSize(pp.getWidth() / 6, pp.getHeight() / 5);
            Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) - (cv.getWidth()*inf.getCartasJugadorMano().size())/2+(i*(cv.getWidth()+10));
                    p.y = pp.getHeight() - (int) posicionY - cv.getSize().height;
            pp.getContentPane().add(cv);
            
             if (!escondido) {
                ccv.AgregarCarta(cv, InfoCartas.get(i), juego);
            } else {
                //TODO: mostrar parte de atras
            }
            cv.setLocation(p);
            cv.setVisible(true);
            
            }else{
            
            cv.setSize(pp.getWidth() / (InfoCartas.size()*2), pp.getHeight() / 5);
            Point p = new Point();
                    p.x = (pp.getWidth()/2 - cv.getWidth()/2) - (cv.getWidth()*inf.getCartasJugadorMano().size())/2+(i*(cv.getWidth()+10));
                    p.y = pp.getHeight() - (int) posicionY - cv.getSize().height;
            pp.getContentPane().add(cv);
            
             if (!escondido) {
                ccv.AgregarCarta(cv, InfoCartas.get(i), juego);
            } else {
                //TODO: mostrar parte de atras
            }
            cv.setLocation(p);
            cv.setVisible(true);
            }
        }
    }
     private void DestruirCartasViejas() {

        for (int i = 0; i < cartasParaMostrar.size(); i++) {
            pp.remove(cartasParaMostrar.get(i));
        }
        //Actualizar VistaPrincipal para vizualisar cambios
        pp.revalidate();
        pp.repaint();

        cartasParaMostrar.clear();
    }
    public Juego getJuego() {
        return juego;
    }

}