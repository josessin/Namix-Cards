/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jose;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import modelos.InfoVisualJuego;

/**
 *
 * @author Usuario
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private ControlVistaPrincipal cvppl;

    public VistaPrincipal(final ControlVistaPrincipal cvppl) {
        initComponents();

        this.cvppl = cvppl;

        //REGistrando rezise event
        this.getRootPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
                if (cvppl != null) {
                    cvppl.actualizarPantalla(cvppl.getIvj());
                }
            }
        });

        Dimension tam = getToolkit().getScreenSize();
        this.setPreferredSize(tam);
        pack();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblManaJugador2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblVidaJugador1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblManaJugador1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblVidaJugador2 = new javax.swing.JLabel();
        jugador1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jugador2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jButton1.setText("FIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("mana");

        lblManaJugador2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblManaJugador2.setForeground(new java.awt.Color(0, 153, 51));
        lblManaJugador2.setText("0");

        jLabel2.setText("Vida");

        lblVidaJugador1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblVidaJugador1.setForeground(new java.awt.Color(204, 0, 0));
        lblVidaJugador1.setText("0");

        jLabel3.setText("mana");

        lblManaJugador1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblManaJugador1.setForeground(new java.awt.Color(0, 153, 51));
        lblManaJugador1.setText("0");

        jLabel4.setText("Vida");

        lblVidaJugador2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblVidaJugador2.setForeground(new java.awt.Color(204, 0, 0));
        lblVidaJugador2.setText("0");

        jugador1.setBackground(new java.awt.Color(102, 0, 255));
        jugador1.setForeground(new java.awt.Color(153, 51, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("2");

        javax.swing.GroupLayout jugador1Layout = new javax.swing.GroupLayout(jugador1);
        jugador1.setLayout(jugador1Layout);
        jugador1Layout.setHorizontalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jugador1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(39, 39, 39))
        );
        jugador1Layout.setVerticalGroup(
            jugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jugador2.setBackground(new java.awt.Color(153, 0, 153));
        jugador2.setForeground(new java.awt.Color(153, 51, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("1");

        javax.swing.GroupLayout jugador2Layout = new javax.swing.GroupLayout(jugador2);
        jugador2.setLayout(jugador2Layout);
        jugador2Layout.setHorizontalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jugador2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
        );
        jugador2Layout.setVerticalGroup(
            jugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVidaJugador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVidaJugador2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblManaJugador2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblManaJugador1)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblManaJugador2)
                            .addComponent(lblVidaJugador1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblVidaJugador2)
                                .addComponent(lblManaJugador1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(21, 21, 21))
                            .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange

    }//GEN-LAST:event_formPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cvppl.getJuego().terminarTurno();
    }//GEN-LAST:event_jButton1ActionPerformed

    void cargarValores(InfoVisualJuego ivj) {
        lblManaJugador1.setText(Integer.toString(ivj.getManaDispJugador()));
        lblManaJugador2.setText(Integer.toString(ivj.getManaDispPC()));
        lblVidaJugador1.setText(Integer.toString(ivj.getVidasJugador()));
        lblVidaJugador2.setText(Integer.toString(ivj.getVidasPC()));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jugador1;
    private javax.swing.JPanel jugador2;
    private javax.swing.JLabel lblManaJugador1;
    private javax.swing.JLabel lblManaJugador2;
    private javax.swing.JLabel lblVidaJugador1;
    private javax.swing.JLabel lblVidaJugador2;
    // End of variables declaration//GEN-END:variables

}