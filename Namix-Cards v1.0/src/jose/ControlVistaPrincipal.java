/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;

import modelos.InfoVisualJuego;

/**
 *
 * @author Usuario
 */
public class ControlVistaPrincipal {

    private VistaPrincipal vppl;

    public ControlVistaPrincipal() {

        vppl = new VistaPrincipal();

    }

    public void actualizarPantalla(InfoVisualJuego infvj) {
        
        for (int i = 0; i < infvj.getCartasJugadorMano().size(); i++) {
            CartaVisualBasica cvb = new CartaVisualBasica();
            vppl.getContentPane().add(cvb);
            vppl.pack();
            cvb.setValores(infvj.getCartasJugadorMano().get(i));

           
            cvb.setVisible(true);
            cvb.setLocation(vppl.getWidth()/2, vppl.getHeight()/2);
        }
        
    }
}
