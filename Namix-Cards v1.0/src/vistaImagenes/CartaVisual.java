/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaImagenes;

import controlador.ControladorPantalla;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author jeron
 */
public class CartaVisual extends javax.swing.JPanel {
    
    
    
    public CartaVisual() {
        initComponents();
        
        /*PanelImagenCarta ima = new PanelImagenCarta();
        
       /* ima.setSize(Ima.getWidth(), Ima.getHeight());
        ima.setVisible(true);
        Ima.add(ima, BorderLayout.CENTER);
        ima.repaint();*/
    }

    public JLabel getLblMana() {
        return lblMana;
    }

    public void setLblMana(Integer mana) {
        String manaTxt = String.valueOf(mana);
        this.lblMana.setText(manaTxt);
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(String nombre) {
        this.lblNombre.setText(nombre);
    }

    public JLabel getLblPoder() {
        return lblPoder;
    }

    public void setLblPoder(Integer poder) {
        String poderTxt = String.valueOf(poder);
        this.lblPoder.setText(poderTxt);
    }
    

    public JPanel getImagen() {
        return Imagen;
    }

    public void setImagen(JPanel Imagen) {
        this.Imagen = Imagen;
    }
    
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imagen = new javax.swing.JPanel();
        Imagen.setSize(super.getWidth()/2,super.getHeight()/2);
        lblNombre = new javax.swing.JLabel();
        lblPoder = new javax.swing.JLabel();
        lblMana = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout ImagenLayout = new javax.swing.GroupLayout(Imagen);
        Imagen.setLayout(ImagenLayout);
        ImagenLayout.setHorizontalGroup(
            ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        ImagenLayout.setVerticalGroup(
            ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblMana, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPoder, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 17, Short.MAX_VALUE)
                    .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 17, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 39, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Imagen;
    private javax.swing.JLabel lblMana;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPoder;
    // End of variables declaration//GEN-END:variables
}
