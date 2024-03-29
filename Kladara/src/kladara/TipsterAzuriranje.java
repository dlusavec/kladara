/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kladara;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import pomocni.PomocnaBaza;
import pomocni.Pomocna;
import pomocni.Poruka;

/**
 *
 * @author damirl
 */
public class TipsterAzuriranje extends javax.swing.JDialog {

    /**
     * Creates new form TipseriPregled
     */
    private Integer id;
    private Integer opcija;
    private String selectSQL = "SELECT ID,NAZIV,NAPOMENA,IGRAM FROM TIPSTER WHERE ID=?";
    private String insertSQL = "INSERT INTO TIPSTER(ID,NAZIV,NAPOMENA,IGRAM) VALUES(?,?,?,?)";
    private String updateSQL = "UPDATE TIPSTER SET NAZIV=?,NAPOMENA=?, IGRAM=? WHERE ID=?";

    public TipsterAzuriranje(Component parent, boolean modal, int opcija, Integer id) {
        super();
        initComponents();
        setLocationRelativeTo(parent);
        this.id = id;
        this.opcija = opcija;
        if (opcija == 2) {
            select();
        }
        this.getRootPane().setDefaultButton(jButtonOK);
        Pomocna.postavkeProzora(this,jFormattedTextFieldNaziv);
        setVisible(true);
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

        jButtonOK = new javax.swing.JButton();
        jButtonIzlaz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldSifra = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNaziv = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNapomena = new javax.swing.JTextArea();
        jCheckBoxIgram = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipsteri - ažuriranje");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(503, 201));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jButtonOK.setMnemonic('O');
        jButtonOK.setText("OK");
        jButtonOK.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonOK.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonOK.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Šifra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Naziv");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Napomena");

        jFormattedTextFieldSifra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextFieldSifra.setFocusable(false);
        jFormattedTextFieldSifra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jFormattedTextFieldNaziv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldNaziv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldNazivFocusGained(evt);
            }
        });

        jTextAreaNapomena.setColumns(20);
        jTextAreaNapomena.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAreaNapomena.setLineWrap(true);
        jTextAreaNapomena.setRows(5);
        jTextAreaNapomena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextAreaNapomenaFocusGained(evt);
            }
        });
        jTextAreaNapomena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaNapomenaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaNapomena);

        jCheckBoxIgram.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxIgram.setText("Igram");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxIgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxIgram))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzlazActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonIzlazActionPerformed

    private void jTextAreaNapomenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaNapomenaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            jButtonOK.requestFocus();
        }
        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_TAB) {
            jCheckBoxIgram.requestFocus();
        }
    }//GEN-LAST:event_jTextAreaNapomenaKeyPressed

    private void jFormattedTextFieldNazivFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldNazivFocusGained
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldNaziv.selectAll();
            }
        });

    }//GEN-LAST:event_jFormattedTextFieldNazivFocusGained

    private void jTextAreaNapomenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaNapomenaFocusGained
        jTextAreaNapomena.selectAll();
    }//GEN-LAST:event_jTextAreaNapomenaFocusGained

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if (jFormattedTextFieldNaziv.getText().trim().equals("")) {
            Poruka.greska(this, "Naziv ?");
            jFormattedTextFieldNaziv.requestFocus();
            return;
        }
        if (opcija == 1) {
            insert();
        } else {
            update();
        }
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void select() {
        try {
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            jFormattedTextFieldSifra.setValue(rs.getInt("ID"));
            jFormattedTextFieldNaziv.setValue(rs.getString("NAZIV"));
            jCheckBoxIgram.setSelected(rs.getString("IGRAM").equals("1"));
            jTextAreaNapomena.setText(rs.getString("NAPOMENA"));
            rs.close();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }

    private void update() {
        try {
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(updateSQL);
            ps.setString(1, jFormattedTextFieldNaziv.getText().trim());
            ps.setString(2, jTextAreaNapomena.getText().trim());
            ps.setString(3, jCheckBoxIgram.isSelected() ? "1" : "0");
            ps.setInt(4, id);
            ps.executeUpdate();
            Konekcija.konekcija.commit();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }

    private void insert() {
        try {
            id = PomocnaBaza.getIduciPK("TIPSTER");
            Pomocna.idPozicioniranje = id;
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(insertSQL);
            ps.setInt(1, id);
            ps.setString(2, jFormattedTextFieldNaziv.getText().trim());
            ps.setString(3, jTextAreaNapomena.getText().trim());
            ps.setString(4, jCheckBoxIgram.isSelected() ? "1" : "0");
            ps.executeUpdate();
            Konekcija.konekcija.commit();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzlaz;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxIgram;
    private javax.swing.JFormattedTextField jFormattedTextFieldNaziv;
    private javax.swing.JFormattedTextField jFormattedTextFieldSifra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaNapomena;
    // End of variables declaration//GEN-END:variables
}
