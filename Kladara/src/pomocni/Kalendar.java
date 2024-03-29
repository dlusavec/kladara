/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.awt.Component;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author damirl
 */
public class Kalendar extends javax.swing.JDialog {

    /**
     * Creates new form TipseriPregled
     */
    public Date odabraniDatum;

    public Kalendar(Component parent, boolean modal, boolean prikazi) {
        super();
        initComponents();
        setLocationRelativeTo(parent);
        kalendar.setLocale(new Locale("hr"));
        this.getRootPane().setDefaultButton(jButtonOdabir);
        kalendar.setDate(Pomocna.getKrajMjeseca(new Date()));
        setVisible(prikazi);
        setModal(modal);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kalendar = new com.toedter.calendar.JCalendar();
        jButtonOdabir = new javax.swing.JButton();
        jButtonIzlaz = new javax.swing.JButton();

        setTitle("Kalendar");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setPreferredSize(new java.awt.Dimension(400, 290));
        setResizable(false);

        jButtonOdabir.setMnemonic('O');
        jButtonOdabir.setText("Odabir");
        jButtonOdabir.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonOdabir.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonOdabir.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonOdabir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdabirActionPerformed(evt);
            }
        });

        jButtonIzlaz.setMnemonic('z');
        jButtonIzlaz.setText("Izlaz");
        jButtonIzlaz.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonIzlaz.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonIzlaz.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzlazActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOdabir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOdabir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzlazActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButtonIzlazActionPerformed

    private void jButtonOdabirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdabirActionPerformed
        odabraniDatum = kalendar.getDate();
        setVisible(false);
    }//GEN-LAST:event_jButtonOdabirActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzlaz;
    private javax.swing.JButton jButtonOdabir;
    private com.toedter.calendar.JCalendar kalendar;
    // End of variables declaration//GEN-END:variables
}
