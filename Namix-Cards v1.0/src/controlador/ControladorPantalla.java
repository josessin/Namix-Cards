/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
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
    InfoVisualJuego info = new InfoVisualJuego();
    Carta carta = new Carta("asesino", 50, 50,Carta.Tipo.criatura);
    Carta carta1 = new Carta("elfo", 5, 5,Carta.Tipo.criatura);
    Carta carta2 = new Carta("golem", 10, 10,Carta.Tipo.criatura);
    
    
    
    public ControladorPantalla(){
        
        
        ArrayList<Carta> listaJM =  new ArrayList<Carta>();
        listaJM.add(carta);
        listaJM.add(carta1);
        listaJM.add(carta2);
        info.setCartasJugadorMano(listaJM);
        //<JOSE> Agregue estas dos listas (con las mismas cartas) para q funcione la prueba
        info.setCartasJugadorTablero(listaJM);
        info.setCartasPCTablero(listaJM);
        //<JOSE>ATENCION!! esto es nuevo en InfoVisualJugador, pero es para que tengas tb esta info!!!!!!!! 
        //(podes mostrar la cantidad correcta de cartas para dadas vuelta)
        info.setCartasPCMano(listaJM);
        
    }
    //************************************************
    //VISTAS 
    PantallaPrincipal pp = new PantallaPrincipal();
    //CONTROLADOR
    ControladorCartaVisual ccv = new ControladorCartaVisual(pp);
    //VARIABLES
    //<JOSE> Borre las variables, es mas facil de ver y seguir el rastro asi
    //simplemente se usa info.getCartasJugadorMano(), etc
    

    public void StartPantalla() {

        PanelPantallaPrin fondo = new PanelPantallaPrin();
        pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        pp.setVisible(true);
        //************************************
        ActualizarPantalla(info); //PARA PRUEBA
        //***********************************
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {

        //Se inicializa la pantalla
        //StartPantalla();

        //SE ENVIA LA INFORAMCION A PANTALLA PRINCIPAL
        pp.CargaInfoJuego(inf.getVidasJugador(), inf.getVidasPC(), inf.getManaTotalJugador(), inf.getManaTotalPC(),
                inf.getManaDispJugador(), inf.getManaDispPC(), inf.getCartasJugadorMano(),
                inf.getCartasJugadorTablero(), inf.getCartasPCTablero(), inf.getCartasPCMano());
        //SE LLAMAN A LOS METODOS PARA CREAR LAS CARTAS DE LOS JUGADORES
        CargarCartas(inf.getCartasJugadorMano());
        CargarCartas(inf.getCartasJugadorTablero());
        CargarCartas(inf.getCartasPCTablero());
    }
    //METODO CARGA CARTAS JUGADOR
    
    public void CargarCartas(ArrayList<Carta> InfoCartas) {
        
        for (int i = 0; i < InfoCartas.size(); i++) {
            //SE LLAMAN A LOS METODOS DEL CONTROLADOR DE CARTA VISUAL
            ccv.AgregarImagenCarta(InfoCartas.get(i).getNombre());
            ccv.AgregarNombre(InfoCartas.get(i).getNombre());
            ccv.AgregarCoste(InfoCartas.get(i).getCoste());
            if (InfoCartas.get(i).getTipo() == Carta.Tipo.criatura) {

                // ccv.AgregarPoder();
            } else {

                // ccv.AgregarEfecto();
            }
            ccv.AgregarFondoCarta(InfoCartas.get(i).getTipo());

        }

    }
     //SE COLOCA LA CARTA EN PANTALLA PRINCIPAL
    public void AgregarCartaATablero(CartaVisual cv) {
        
        cv.setSize(pp.getWidth()/9, pp.getHeight()/4);
        cv.setLocation(pp.getWidth() - (cv.getWidth() + cv.getWidth()), pp.getHeight() - (cv.getHeight() + cv.getHeight()));
        pp.add(cv);

    }
}
