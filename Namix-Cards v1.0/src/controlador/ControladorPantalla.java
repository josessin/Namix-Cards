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
import modelos.Jugador;
import vistaImagenes.CartaVisual;
import vistaImagenes.PanelFinal;
import vistaImagenes.PanelPantallaPrin;
import vistas.FinDelJuego;
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
    private Dimension tam;
    PanelPantallaPrin fondo = new PanelPantallaPrin();

    public ControladorPantalla(Juego juego) {
        this.juego = juego;
        pp = new PantallaPrincipal(this);
        cartasParaMostrar = new ArrayList<>();

    }

    public PantallaPrincipal getPp() {
        return pp;
    }
    

    public void StartPantalla() {

        Dimension tam = Toolkit.getDefaultToolkit().getScreenSize();
        //pp.setSize(tam);

        pp.setVisible(true);
    }

    public void PonerFondoAPantallaP() {

        pp.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
    }

    public void ActualizarPantalla(InfoVisualJuego inf) {
        if (inf == null) {
            return;
        }

        DestruirCartasViejas();
        //Se inicializa la pantalla
        
        StartPantalla();
        tam = pp.getSize();

        this.inf = inf;

        //SE ENVIA LA INFORAMCION A PANTALLA PRINCIPAL
        pp.CargaInfoJuego(inf);

        //SE LLAMAN A LOS METODOS PARA CREAR LAS CARTAS DE LOS JUGADORES
        CargarCartas(inf.getCartasJugadorMano(), tam.height / 7.0F, false);
        CargarCartas(inf.getCartasPCMano(), (tam.height - tam.height / 90.0f), false);
        CargarCartas(inf.getCartasJugadorTablero(), (int) (tam.height / 2.7F), false);
        CargarCartas(inf.getCartasPCTablero(), (int) (tam.height - tam.height / 3.7f), false);

        PonerFondoAPantallaP();

    }

    public InfoVisualJuego getIvj() {
        return inf;
    }

    //METODO CARGA CARTAS JUGADOR
    public void CargarCartas(ArrayList<Carta> InfoCartas, float posicionY, boolean escondido) {
        ControladorCartaVisual ccv = new ControladorCartaVisual(juego);
        for (int i = 0; i < InfoCartas.size(); i++) {
            CartaVisual cv = new CartaVisual(juego);
            cartasParaMostrar.add(cv);

            int aux = InfoCartas.size();
            cv.setSize((int) tam.getWidth() / 12, (int) tam.getHeight() / 5);

            pp.getContentPane().add(cv);

            ccv.AgregarCarta(cv, InfoCartas.get(i), juego, escondido);

            Point p = new Point();
            p.x = (pp.getWidth() / 2 - cv.getWidth() / 2) - cv.getWidth()
                    * InfoCartas.size() / 2 + i * (cv.getWidth() + 10);
            p.y = (int) (tam.height - posicionY - cv.getSize().height / 2);
            cv.setLocation(p);

            cv.setVisible(true);

        }

    }

    private void DestruirCartasViejas() {

        for (int i = 0; i < cartasParaMostrar.size(); i++) {
            pp.remove(cartasParaMostrar.get(i));
        }
        //Actualizar VistaPrincipal para vizualisar cambios
        pp.revalidate();
        pp.remove(fondo);
        cartasParaMostrar.clear();

    }

    public Juego getJuego() {
        return juego;
    }
    
    public void PantallaFinal(Jugador Ganador){
        FinDelJuego pantalla = new FinDelJuego();
        PanelFinal fondo = new PanelFinal();
        
        
        if(Ganador.getTipoJugador().equals(Jugador.TipoJugador.humano)){
            
          /*  String[] nombreFondo = new String[5];
            for (int i = 0; i < nombreFondo.length; i++) {
                String nombreArchivo = "Victoria" + (i + 1);
                nombreFondo[i] = nombreArchivo;
            }
            int numRandom = (int) Math.round(Math.random()*4);
            
            String nombreDeArchivoSelec = nombreFondo[numRandom];*/
            fondo.setSize(pantalla.getSize());
            fondo.setNombre("Victoria");
            
            pantalla.add(fondo,BorderLayout.CENTER);
            
            fondo.repaint();
            
            pp.invisible();
            pantalla.setVisible(true);            
        }else{
            
 /*           String[] nombreFondo = new String[5];
            for (int i = 0; i < nombreFondo.length; i++) {
                String nombreArchivo = "HasPerdido" + (i + 1);
                nombreFondo[i] = nombreArchivo;
            }
            int numRandom = (int) Math.round(Math.random()*4);
            
            String nombreDeArchivoSelec = nombreFondo[numRandom];*/
            fondo.setSize(pantalla.getSize());
            fondo.setNombre("Derrota");
            
            pantalla.add(fondo,BorderLayout.CENTER);
            
            fondo.repaint();
            
            pp.invisible();
            pantalla.setVisible(true);
        
        
        }
    
    }

}
