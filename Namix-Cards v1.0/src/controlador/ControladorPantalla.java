/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.util.ArrayList;
import modelos.Carta;
import modelos.Criatura;
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
    Criatura carta = new Criatura("asesino", 50, 50);
    Criatura carta1 = new Criatura("elfo", 5, 5);
    Criatura carta2 = new Criatura("golem", 10, 10);
    
    
    
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
    ControladorCartaVisual ccv = new ControladorCartaVisual();
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

        //SE CREA VARIABLES NECESARIA
        int vidaJ, vidaPc, manaJ, manaPc, manaDisJ, manaDisPc;
        //SE CARGAN LAS VARIABLES CON LOS VALORES RECIBIDOS
        //<JOSE> si estas variables no se van a usar en otro lado, esto es inesecario
        //se pueden pasar los parametros directamente (inf.geVidasJugador), sin guardar los datos previamente en una variable
        vidaJ = inf.getVidasJugador();
        vidaPc = inf.getVidasPC();
        manaJ = inf.getManaTotalJugador();
        manaPc = inf.getManaTotalPC();
        manaDisJ = inf.getManaDispJugador();
        manaDisPc = inf.getManaDispPC();
        //SE ENVIA LA INFORAMCION A PANTALLA PRINCIPAL
        pp.CargaInfoJuego(vidaJ, vidaPc, manaJ, manaPc, manaDisJ, manaDisPc, inf.getCartasJugadorMano(), inf.getCartasJugadorTablero(), inf.getCartasPCTablero());
        //SE LLAMAN A LOS METODOS PARA CREAR LAS CARTAS DE LOS JUGADORES
        CargarCartasManoJugador(inf.getCartasJugadorMano());
        CargarCartasTableroJugador(inf.getCartasJugadorTablero());
        CargarCartasTableroPc(inf.getCartasPCTablero());
    }
    //METODO CARGA CARTAS JUGADOR
    public void CargarCartasManoJugador(ArrayList<Carta> CartasManoJ) {
        
        for (int i = 0; i < CartasManoJ.size(); i++) {
            //SE LLAMAN A LOS METODOS DEL CONTROLADOR DE CARTA VISUAL
            ccv.AgregarImagenCarta(CartasManoJ.get(i).getNombre());
            ccv.AgregarNombre(CartasManoJ.get(i).getNombre());
            ccv.AgregarCoste(CartasManoJ.get(i).getCoste());
            if (CartasManoJ.get(i).getTipo() == Carta.Tipo.criatura) {

                // ccv.AgregarPoder();
            } else {

                // ccv.AgregarEfecto();
            }
            ccv.AgregarFondoCarta(CartasManoJ.get(i).getTipo());

        }

    }

    public void CargarCartasTableroJugador(ArrayList<Carta> CartasTableroJ) {

        for (int i = 0; i < CartasTableroJ.size(); i++) {
            ccv.AgregarImagenCarta(CartasTableroJ.get(i).getNombre());
            ccv.AgregarNombre(CartasTableroJ.get(i).getNombre());
            ccv.AgregarCoste(CartasTableroJ.get(i).getCoste());
            if (CartasTableroJ.get(i).getTipo() == Carta.Tipo.criatura) {

                // ccv.AgregarPoder();
            } else {

                // ccv.AgregarEfecto();
            }
            ccv.AgregarFondoCarta(CartasTableroJ.get(i).getTipo());
        }

    }

    public void CargarCartasTableroPc(ArrayList<Carta> CartasTableroPc) {

        for (int i = 0; i < CartasTableroPc.size(); i++) {
            ccv.AgregarImagenCarta(CartasTableroPc.get(i).getNombre());
            ccv.AgregarNombre(CartasTableroPc.get(i).getNombre());
            ccv.AgregarCoste(CartasTableroPc.get(i).getCoste());
            if (CartasTableroPc.get(i).getTipo() == Carta.Tipo.criatura) {

                // ccv.AgregarPoder();
            } else {

                // ccv.AgregarEfecto();
            }
            ccv.AgregarFondoCarta(CartasTableroPc.get(i).getTipo());
        }

    }
    //SE COLOCA LA CARTA EN PANTALLA PRINCIPAL
    //<JOSE> Este metodo nunca se llama?? 
    public void AgregarCartaATablero(CartaVisual cv) {

        pp.add(cv);

    }
}
