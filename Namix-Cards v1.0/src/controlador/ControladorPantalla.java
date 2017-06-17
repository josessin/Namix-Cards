/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import vistaImagenes.PanelPantallaPrin;
import vistas.PantallaPrincipal;

/**
 *
 * @author jeron
 */
public class ControladorPantalla {
    
    
    public void StartPantalla(){
    
        PanelPantallaPrin fondo = new PanelPantallaPrin();
        PantallaPrincipal ventana = new PantallaPrincipal();
        ventana.add(fondo, BorderLayout.CENTER);
        fondo.repaint();
        ventana.setVisible(true);
    }
    
    
    
}
