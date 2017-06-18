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
        
        
        ArrayList<Carta> lista2 =  new ArrayList<Carta>();
        lista2.add(carta);
        lista2.add(carta1);
        lista2.add(carta2);
        info.setCartasJugadorMano(lista2);
    
    }
    //************************************************

    PantallaPrincipal pp = new PantallaPrincipal();
    ControladorCartaVisual ccv = new ControladorCartaVisual();
    private ArrayList<Carta> CartasManoJ;
    private ArrayList<Carta> CartasTableroPc;
    private ArrayList<Carta> CartasTableroJ;

    public ArrayList<Carta> getCartasManoJ() {
        return CartasManoJ;
    }

    public void setCartasManoJ(ArrayList<Carta> CartasManoJ) {
        this.CartasManoJ = CartasManoJ;
    }

    public ArrayList<Carta> getCartasTableroPc() {
        return CartasTableroPc;
    }

    public void setCartasTableroPc(ArrayList<Carta> CartasTableroPc) {
        this.CartasTableroPc = CartasTableroPc;
    }

    public ArrayList<Carta> getCartasTableroJ() {
        return CartasTableroJ;
    }

    public void setCartasTableroJ(ArrayList<Carta> CartasTableroJ) {
        this.CartasTableroJ = CartasTableroJ;
    }

    public void StartPantalla() {

        PanelPantallaPrin fondo = new PanelPantallaPrin();
        pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        pp.setVisible(true);
        //************************************
        ActualizarPantalla(info);
        //***********************************
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {

        //Se inicializa la pantalla
        //StartPantalla();


        setCartasManoJ(inf.getCartasJugadorMano());
        setCartasTableroPc(inf.getCartasPCTablero());
        setCartasTableroJ(inf.getCartasJugadorTablero());
        int vidaJ, vidaPc, manaJ, manaPc, manaDisJ, manaDisPc;

        vidaJ = inf.getVidasJugador();
        vidaPc = inf.getVidasPC();
        manaJ = inf.getManaTotalJugador();
        manaPc = inf.getManaTotalPC();
        manaDisJ = inf.getManaDispJugador();
        manaDisPc = inf.getManaDispPC();

        pp.CargaInfoJuego(vidaJ, vidaPc, manaJ, manaPc, manaDisJ, manaDisPc, CartasManoJ, CartasTableroJ, CartasTableroPc);

        CargarCartasManoJugador(CartasManoJ);
        CargarCartasTableroJugador(CartasTableroJ);
        CargarCartasTableroPc(CartasTableroPc);
    }

    public void CargarCartasManoJugador(ArrayList<Carta> CartasManoJ) {

        for (int i = 0; i < CartasManoJ.size(); i++) {
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

    public void AgregarCartaATablero(CartaVisual cv) {

        pp.add(cv);

    }
}
