/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaImagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author jeron
 */
public class PanelImagenCarta extends javax.swing.JPanel {
    private String nombre;
    
    public PanelImagenCarta() {
        initComponents();
        this.setSize(super.getHeight(), super.getWidth());
               
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /*public void paint(Graphics g){
    
        Dimension tam = super.getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/golem.png"));
        g.drawImage(fondo.getImage(),0,0,getWidth(), getHeight(),null);
        setOpaque(false);
        super.paintComponent(g);
        this.repaint();
    
    }*/
    public void paint(Graphics g){
        String sep = File.separator;
        Dimension tam = super.getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource(sep+"imagenes"+sep+nombre+".png"));
        g.drawImage(fondo.getImage(),0,0,getWidth(), getHeight(),null);
        setOpaque(false);
        super.paintComponent(g);
        this.repaint();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
