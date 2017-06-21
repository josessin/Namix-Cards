/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaImagenes;

import juego.Juego;
import vistas.InfoJuego;
import vistas.InicioJuego;
import vistas.PantallaPrincipal;

/**
 *
 * @author jeron
 */
public class BotonesParaInicioJuego extends javax.swing.JPanel {
    private InfoJuego iJ;
    private Juego PartidaAnterior;
    private InicioJuego dato;
    /**
     * Creates new form BotonesParaInicioJuego
     */
    public BotonesParaInicioJuego(InicioJuego dato, Juego PartidaAnterior) {
       initComponents();
       this.PartidaAnterior = PartidaAnterior;
       this.dato = dato;
        btn2P.setVisible(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btn2P = new javax.swing.JButton();

        setOpaque(false);

        btnStart.setBackground(new java.awt.Color(255, 255, 153));
        btnStart.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        btnStart.setText("Start");
        btnStart.setLocation((int) this.getSize().getHeight(),(int) this.getSize().getWidth());
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(255, 255, 153));
        btnHelp.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 153));
        btnSalir.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        btnSalir.setText("Exit");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btn2P.setBackground(new java.awt.Color(255, 255, 153));
        btn2P.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        btn2P.setText("2 Players");
        btn2P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2PActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn2P, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHelp)
                .addGap(11, 11, 11)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn2P)
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn2PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2PActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn2PActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        iJ = new InfoJuego(dato);
        iJ.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(PartidaAnterior == null){
            Juego juego = new Juego();

            this.setVisible(false);
        }else{
            PartidaAnterior.logger.destruir();
            PartidaAnterior = null;
            Juego juego = new Juego();

            this.setVisible(false);

        }
    }//GEN-LAST:event_btnStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2P;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnStart;
    // End of variables declaration//GEN-END:variables

}
    
