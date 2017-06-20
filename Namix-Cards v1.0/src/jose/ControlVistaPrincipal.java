/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import juego.Juego;
import modelos.Carta;
import modelos.InfoVisualJuego;

/**
 *
 * @author Usuario
 */
public class ControlVistaPrincipal {

    private final VistaPrincipal vppl;
    private final int paddingHor = 20;
    private Dimension tam;
    private InfoVisualJuego ivj;
    private ArrayList<CartaVisualBasica> cartasMostradas;
    private Juego juego;

    public ControlVistaPrincipal(Juego juego) {

        vppl = new VistaPrincipal(this);
        cartasMostradas = new ArrayList<>();
        this.juego = juego;

    }

    public void actualizarPantalla(InfoVisualJuego ivj) {
        if (ivj == null) {
            return;
        }

        tam = vppl.getSize();
        DestruirCartasViejas();
        this.ivj = ivj;
        generarCartas(ivj.getCartasJugadorMano(), tam.height / 6, false);
        generarCartas(ivj.getCartasJugadorTablero(), (int) (tam.height / 2.5f), false);
        generarCartas(ivj.getCartasPCTablero(), (int) (tam.height - tam.height / 3.5f), false);
        generarCartas(ivj.getCartasPCMano(), tam.height - tam.height / 7, false);

        vppl.cargarValores(ivj);

    }

    private void generarCartas(ArrayList<Carta> cartas, int posicionY, boolean hidden) {

        for (int i = 0; i < cartas.size(); i++) {
            CartaVisualBasica cvb = new CartaVisualBasica(juego);
            cartasMostradas.add(cvb);
            //cvb.setLayout(null);

            cvb.setSize((int) tam.getWidth() / 12, (int) tam.getHeight() / 7);

            vppl.getContentPane().add(cvb);

            Point p = new Point();

            //Punto donde la carta sera posicionada relativo a la VistaPrincipal
            p.x = (vppl.getWidth() / 2 - cvb.getWidth() / 2) - cvb.getWidth()
                    * cartas.size() / 2 + i * (cvb.getWidth() + paddingHor);
            p.y = tam.height - posicionY - cvb.getSize().height / 2;

            cvb.setLocation(p);
            cvb.setVisible(true);
            
            if (!hidden) {
                cvb.setValores(cartas.get(i));
            } else {
                //TODO: mostrar parte de atras
            }
        }
    }

    public InfoVisualJuego getIvj() {
        return ivj;
    }

    private void DestruirCartasViejas() {

        for (int i = 0; i < cartasMostradas.size(); i++) {
            vppl.remove(cartasMostradas.get(i));
        }
        //Actualizar VistaPrincipal para vizualisar cambios
        vppl.revalidate();
        vppl.repaint();

        cartasMostradas.clear();
    }

    public Juego getJuego() {
        return juego;
    }

}
