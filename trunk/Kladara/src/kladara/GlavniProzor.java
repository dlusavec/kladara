package kladara;

import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import pomocni.Pomocna;
import pomocni.Poruka;

/**
 *
 * @author damirl
 */
public class GlavniProzor extends javax.swing.JFrame {
  
    public GlavniProzor() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemTipster = new javax.swing.JMenuItem();
        jMenuItemPromet = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemRekapitulacijaTipster = new javax.swing.JMenuItem();
        jMenuItemRekapitulacijaDan = new javax.swing.JMenuItem();
        jMenuItemRekapitulacijaMjesec = new javax.swing.JMenuItem();

        setTitle("Kladara");
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenu1.setText("Tipsteri/promet");

        jMenuItemTipster.setText("Tipsteri");
        jMenuItemTipster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTipsterActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemTipster);

        jMenuItemPromet.setText("Promet");
        jMenuItemPromet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrometActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPromet);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Rekapitulacije");

        jMenuItemRekapitulacijaTipster.setText("Rekapitulacija po tipsteru");
        jMenuItemRekapitulacijaTipster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRekapitulacijaTipsterActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRekapitulacijaTipster);

        jMenuItemRekapitulacijaDan.setText("Rekapitulacija po danima");
        jMenuItemRekapitulacijaDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRekapitulacijaDanActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRekapitulacijaDan);

        jMenuItemRekapitulacijaMjesec.setText("Rekapitulacija po mjesecima");
        jMenuItemRekapitulacijaMjesec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRekapitulacijaMjesecActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemRekapitulacijaMjesec);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTipsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTipsterActionPerformed
        // TODO add your handling code here:
        // new TipseriPregled(this, true);
        new TipsterPregled(this, true, false);
    }//GEN-LAST:event_jMenuItemTipsterActionPerformed

    private void jMenuItemPrometActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrometActionPerformed
        // TODO add your handling code here:
        new PrometPregled(this.getRootPane(), false);
    }//GEN-LAST:event_jMenuItemPrometActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            Konekcija.konekcija.commit();
            Konekcija.konekcija.close();
        } catch (SQLException ex) {
            //Supress
        } finally {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemRekapitulacijaTipsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRekapitulacijaTipsterActionPerformed
        new RekapitulacijaTipsterPregled(this.getRootPane(), false);
    }//GEN-LAST:event_jMenuItemRekapitulacijaTipsterActionPerformed

    private void jMenuItemRekapitulacijaDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRekapitulacijaDanActionPerformed
        new RekapitulacijaDanPregled(this.getRootPane(), false);
    }//GEN-LAST:event_jMenuItemRekapitulacijaDanActionPerformed

    private void jMenuItemRekapitulacijaMjesecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRekapitulacijaMjesecActionPerformed
         new RekapitulacijaMjesecPregled(this.getRootPane(), false);
    }//GEN-LAST:event_jMenuItemRekapitulacijaMjesecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }         
            /* Create and display the form */
        } catch (ClassNotFoundException ex) {
            Poruka.greska(null, ex.getMessage());
        } catch (InstantiationException ex) {
            Poruka.greska(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            Poruka.greska(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            Poruka.greska(null, ex.getMessage());
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pomocna.kreirajMapuIzvjestaja();
                new Konekcija();
                pomocni.PomocnaBaza.instalirajPomocneTablice();
                new GlavniProzor().setVisible(true);               
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemPromet;
    private javax.swing.JMenuItem jMenuItemRekapitulacijaDan;
    private javax.swing.JMenuItem jMenuItemRekapitulacijaMjesec;
    private javax.swing.JMenuItem jMenuItemRekapitulacijaTipster;
    private javax.swing.JMenuItem jMenuItemTipster;
    // End of variables declaration//GEN-END:variables
}
