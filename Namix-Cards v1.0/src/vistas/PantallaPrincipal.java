/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.ControladorPantalla;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Carta;
import vistaImagenes.CartaVisual;

/**
 *
 * @author jeron
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    //Controlador
    //private ControladorPantalla conp = new ControladorPantalla();
    //Variables
    private int vidaJ, vidaPc, manaJ, manaPc, manaDisJ, manaDisPc;
    private ArrayList<Carta> CartasManoJ, CartasTableroJ, CartasTableroPc;
    private Dimension tam = getToolkit().getScreenSize();
    //ESTO SE VA A BORRAR
    //--------------------------------------
    //CartaVisual cv = new CartaVisual();
    //--------------------------------------
    
    public PantallaPrincipal() {
        initComponents();
        this.setSize(tam);
        
        //ESTO SE VA A BORRAR
        //-------------------------------------------------------------------------------------------------------------
        /*cv.setSize(tam.width/9, tam.height/4);
        cv.setLocation(this.getWidth() - (cv.getWidth() + cv.getWidth()),
        this.getHeight() - (cv.getHeight() + cv.getHeight()));
        this.add(cv);*/
        //-------------------------------------------------------------------------------------------------------------
    }


    
    public void CargaInfoJuego(int vidaJ, int vidaPc, int manaJ,int manaPc,int manaDisJ,int manaDisPc, 
            ArrayList<Carta> CartasManoJ, ArrayList<Carta> CartasTableroJ, ArrayList<Carta> CartasTableroPc,
            ArrayList<Carta> CartasManoPc){
        
        this.vidaJ = vidaJ;
        this.vidaPc = vidaPc;
        this.manaJ = manaJ;
        this.manaPc = manaPc;
        this.manaDisJ = manaDisJ;
        this.manaDisPc = manaDisPc;
        this.CartasManoJ = CartasManoJ;
        this.CartasTableroJ = CartasTableroJ;
        this.CartasTableroPc = CartasTableroPc;
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTerminarT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Namix Cards");
        setFocusableWindowState(false);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btnTerminarT.setText("Terminar Truno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 293, Short.MAX_VALUE)
                .addComponent(btnTerminarT))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(btnTerminarT)
                .addGap(105, 105, 105))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminarT;
    // End of variables declaration//GEN-END:variables
}
