/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kladara;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.SwingUtilities;
import pojo.Tipster;
import pomocni.Pomocna;
import pomocni.PomocnaBaza;
import pomocni.Poruka;

/**
 *
 * @author damirl
 */
public class PrometAzuriranje extends javax.swing.JDialog {

    /**
     * Creates new form TipseriPregled
     */
    private Integer id;
    private Integer opcija;
    private String selectSQL = "SELECT ID,DATUM,TIPSTER_ID,OPIS,ULOG,KOEFICIJENT,DOBITAK,SALDO,STATUS_ID,NAPOMENA,MT,IGRAM,PAROVA,SIGURNOST,SALDO_SIGURNOST FROM PROMET WHERE ID=?";
    private String insertSQL = "INSERT INTO PROMET (ID,DATUM,TIPSTER_ID,OPIS,ULOG,KOEFICIJENT,DOBITAK,SALDO,STATUS_ID,NAPOMENA,MT,IGRAM,PAROVA,SIGURNOST,SALDO_SIGURNOST) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String updateSQL = "UPDATE PROMET SET DATUM=?,TIPSTER_ID=?,OPIS=?,ULOG=?,KOEFICIJENT=?,DOBITAK=?,SALDO=?,STATUS_ID=?,NAPOMENA=?, MT=?,IGRAM=?,PAROVA=?,SIGURNOST=?,SALDO_SIGURNOST=? WHERE ID=?";

    public PrometAzuriranje(Component parent, boolean modal, int opcija, Integer id) {
        super();
        initComponents();
        setLocationRelativeTo(parent);
        this.id = id;
        this.opcija = opcija;
        PomocnaBaza.statusUComboBox(jComboBoxStatusNaziv, false);
        Pomocna.sigurnostUComboBox(jComboBoxSigurnost, false);
        if (opcija == 2) {
            select();
        } else {
            jFormattedTextFieldDatum.setValue(new Date());
            jComboBoxStatusNaziv.setSelectedIndex(0);
            jComboBoxSigurnost.setSelectedItem("10");
            jFormattedTextFieldMT.setValue(5);
        }
        this.getRootPane().setDefaultButton(jButtonOK);
        Pomocna.postavkeProzora(this, jFormattedTextFieldDatum);
        setVisible(true);
        setModal(modal);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOK = new javax.swing.JButton();
        jButtonIzlaz = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldId = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDatum = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTipster = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOpis = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNapomena = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldUlog = new javax.swing.JFormattedTextField();
        jFormattedTextFieldKoeficijent = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldDobitak = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextFieldSaldo = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTipsterNaziv = new javax.swing.JTextField();
        jComboBoxStatusNaziv = new javax.swing.JComboBox();
        jComboBoxSigurnost = new javax.swing.JComboBox();
        jFormattedTextFieldMT = new javax.swing.JFormattedTextField();
        jCheckBoxIgram = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextFieldParova = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldSaldoSigurnost = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Promet - ažuriranje");
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
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Datum");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Napomena");

        jFormattedTextFieldId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
        jFormattedTextFieldId.setFocusable(false);
        jFormattedTextFieldId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jFormattedTextFieldDatum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextFieldDatum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldDatum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDatumFocusGained(evt);
            }
        });

        jFormattedTextFieldTipster.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#####0"))));
        jFormattedTextFieldTipster.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldTipster.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldTipsterFocusGained(evt);
            }
        });
        jFormattedTextFieldTipster.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldTipsterPropertyChange(evt);
            }
        });
        jFormattedTextFieldTipster.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldTipsterKeyPressed(evt);
            }
        });

        jTextAreaOpis.setColumns(20);
        jTextAreaOpis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextAreaOpis.setLineWrap(true);
        jTextAreaOpis.setRows(5);
        jTextAreaOpis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextAreaOpisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextAreaOpisFocusLost(evt);
            }
        });
        jTextAreaOpis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaOpisKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaOpis);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Tipster");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Opis");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Ulog");

        jFormattedTextFieldUlog.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldUlog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldUlog.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldUlogFocusGained(evt);
            }
        });
        jFormattedTextFieldUlog.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldUlogPropertyChange(evt);
            }
        });

        jFormattedTextFieldKoeficijent.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.000"))));
        jFormattedTextFieldKoeficijent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldKoeficijent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldKoeficijentFocusGained(evt);
            }
        });
        jFormattedTextFieldKoeficijent.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldKoeficijentPropertyChange(evt);
            }
        });
        jFormattedTextFieldKoeficijent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldKoeficijentKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Koeficijent");

        jFormattedTextFieldDobitak.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldDobitak.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldDobitak.setFocusable(false);
        jFormattedTextFieldDobitak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Ev. dobitak");

        jFormattedTextFieldSaldo.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldSaldo.setFocusable(false);
        jFormattedTextFieldSaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Saldo");

        jTextFieldTipsterNaziv.setEditable(false);
        jTextFieldTipsterNaziv.setBackground(java.awt.SystemColor.controlHighlight);
        jTextFieldTipsterNaziv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldTipsterNaziv.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldTipsterNaziv.setFocusable(false);

        jComboBoxStatusNaziv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxStatusNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusNazivActionPerformed(evt);
            }
        });

        jComboBoxSigurnost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxSigurnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSigurnostActionPerformed(evt);
            }
        });
        jComboBoxSigurnost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxSigurnostKeyPressed(evt);
            }
        });

        jFormattedTextFieldMT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        jFormattedTextFieldMT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldMT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldMTFocusGained(evt);
            }
        });
        jFormattedTextFieldMT.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldMTPropertyChange(evt);
            }
        });

        jCheckBoxIgram.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBoxIgram.setText("Igram");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("MT %");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Sigurnost");

        jFormattedTextFieldParova.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0"))));
        jFormattedTextFieldParova.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldParova.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldParovaFocusGained(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Parova");

        jFormattedTextFieldSaldoSigurnost.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSaldoSigurnost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldSaldoSigurnost.setFocusable(false);
        jFormattedTextFieldSaldoSigurnost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextFieldTipster, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldId, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldDatum, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTipsterNaziv))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextFieldDobitak, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldKoeficijent, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldUlog, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSigurnost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldMT, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jCheckBoxIgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                            .addComponent(jFormattedTextFieldParova, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxStatusNaziv, 0, 116, Short.MAX_VALUE)
                                            .addComponent(jFormattedTextFieldSaldoSigurnost))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(437, 437, 437))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(316, 316, 316)
                                .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextFieldTipster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTipsterNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jFormattedTextFieldMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jFormattedTextFieldUlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextFieldKoeficijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxIgram)
                    .addComponent(jComboBoxStatusNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldDobitak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextFieldSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextFieldParova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSigurnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldSaldoSigurnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzlazActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButtonIzlazActionPerformed

    private void jTextAreaNapomenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaNapomenaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            jButtonOK.requestFocus();
        }
        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_TAB) {
            jComboBoxStatusNaziv.requestFocus();
        }
    }//GEN-LAST:event_jTextAreaNapomenaKeyPressed

    private void jFormattedTextFieldDatumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumFocusGained
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldDatum.selectAll();
            }
        });

    }//GEN-LAST:event_jFormattedTextFieldDatumFocusGained

    private void jTextAreaNapomenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaNapomenaFocusGained
        jTextAreaNapomena.selectAll();
    }//GEN-LAST:event_jTextAreaNapomenaFocusGained

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if (jFormattedTextFieldDatum.getValue() == null) {
            Poruka.greska(this, "Datum ?");
            jFormattedTextFieldDatum.requestFocus();
            return;
        }
        if (jTextFieldTipsterNaziv.getText().equals("")) {
            Poruka.greska(this, "Tipster ?");
            jFormattedTextFieldTipster.requestFocus();
            return;
        }
        if (jFormattedTextFieldUlog.getValue() == null || jFormattedTextFieldUlog.getText().equals("0,00")) {
            Poruka.greska(this, "Ulog ?");
            jFormattedTextFieldUlog.requestFocus();
            return;
        }
        if (jFormattedTextFieldKoeficijent.getValue() == null || jFormattedTextFieldKoeficijent.getText().equals("0,000")) {
            Poruka.greska(this, "Koeficijent ?");
            jFormattedTextFieldKoeficijent.requestFocus();
            return;
        }
        if (opcija == 1) {
            insert();
        } else {
            update();
        }
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jFormattedTextFieldTipsterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTipsterFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldTipster.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldTipsterFocusGained

    private void jFormattedTextFieldTipsterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTipsterKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            if (jFormattedTextFieldTipster.getValue() == null) {
                jFormattedTextFieldTipster.setValue(0);
            }
            Pomocna.idPozicioniranje = Integer.parseInt(jFormattedTextFieldTipster.getValue().toString());
            new TipsterPregled(this, true, true);
            jFormattedTextFieldTipster.setValue(Pomocna.idPozicioniranje);
        }


    }//GEN-LAST:event_jFormattedTextFieldTipsterKeyPressed

    private void jTextAreaOpisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaOpisFocusGained
        // TODO add your handling code here:
        jTextAreaOpis.selectAll();
    }//GEN-LAST:event_jTextAreaOpisFocusGained

    private void jTextAreaOpisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaOpisKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            jFormattedTextFieldUlog.requestFocus();
        }
        if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_TAB) {
            jFormattedTextFieldTipster.requestFocus();
        }
    }//GEN-LAST:event_jTextAreaOpisKeyPressed

    private void jFormattedTextFieldUlogFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldUlogFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldUlog.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldUlogFocusGained

    private void jFormattedTextFieldKoeficijentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldKoeficijentFocusGained
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldKoeficijent.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldKoeficijentFocusGained

    private void jFormattedTextFieldKoeficijentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldKoeficijentKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            jCheckBoxIgram.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldKoeficijentKeyPressed

    private void jFormattedTextFieldTipsterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTipsterPropertyChange
        if (evt.getPropertyName().equals("value")) {
            Tipster tipster = PomocnaBaza.getTipster(evt.getNewValue());
            jTextFieldTipsterNaziv.setText(tipster.getNaziv());
            jCheckBoxIgram.setSelected(tipster.getIgram() != null && tipster.getIgram().equals("1"));
        }

    }//GEN-LAST:event_jFormattedTextFieldTipsterPropertyChange

    private void jFormattedTextFieldUlogPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldUlogPropertyChange
        if (evt.getPropertyName().equals("value")) {
            racunajDobitak();
            racunajDobitakSigurnost();
        }
    }//GEN-LAST:event_jFormattedTextFieldUlogPropertyChange

    private void jFormattedTextFieldKoeficijentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldKoeficijentPropertyChange
        if (evt.getPropertyName().equals("value")) {
            racunajDobitak();
            racunajDobitakSigurnost();

        }
    }//GEN-LAST:event_jFormattedTextFieldKoeficijentPropertyChange

    private void jFormattedTextFieldMTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldMTFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldMT.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldMTFocusGained

    private void jFormattedTextFieldMTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldMTPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldMTPropertyChange

    private void jComboBoxStatusNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusNazivActionPerformed
        racunajDobitak();
        racunajDobitakSigurnost();
    }//GEN-LAST:event_jComboBoxStatusNazivActionPerformed

    private void jComboBoxSigurnostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxSigurnostKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            jFormattedTextFieldParova.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxSigurnostKeyPressed

    private void jFormattedTextFieldParovaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldParovaFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldParova.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldParovaFocusGained

    private void jTextAreaOpisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaOpisFocusLost
        if (jFormattedTextFieldParova.getValue() == null || jFormattedTextFieldParova.getText().equals("0")) {
            jFormattedTextFieldParova.setValue(jTextAreaOpis.getLineCount());
        }
    }//GEN-LAST:event_jTextAreaOpisFocusLost

    private void jComboBoxSigurnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSigurnostActionPerformed
        racunajDobitakSigurnost();
    }//GEN-LAST:event_jComboBoxSigurnostActionPerformed

    private void racunajDobitak() {
        try {
            BigDecimal ulog = new BigDecimal(jFormattedTextFieldUlog.getValue().toString());
            BigDecimal koeficijent = new BigDecimal(jFormattedTextFieldKoeficijent.getValue().toString());
            BigDecimal mt = new BigDecimal(jFormattedTextFieldMT.getValue().toString());
            BigDecimal dobitak = BigDecimal.ZERO;
            dobitak = (ulog.multiply(koeficijent)).setScale(2, RoundingMode.HALF_UP);
            if (mt.compareTo(BigDecimal.ZERO) != 0) {
                mt = mt.divide(Pomocna.sto, 2, RoundingMode.HALF_UP).add(BigDecimal.ONE);
                dobitak = dobitak.divide(mt, 2, RoundingMode.HALF_UP);
            }
            jFormattedTextFieldDobitak.setValue(dobitak);
            if (jComboBoxStatusNaziv.getSelectedIndex() == 0) {
                jFormattedTextFieldSaldo.setValue(0);
            } else if (jComboBoxStatusNaziv.getSelectedIndex() == 1) {
                jFormattedTextFieldSaldo.setValue(dobitak.subtract(ulog));
            } else {
                jFormattedTextFieldSaldo.setValue(ulog.negate());
            }
        } catch (Exception ex) {
            //Supress           
            //  System.err.println(ex.getMessage());            
        }
    }

    private void racunajDobitakSigurnost() {
        try {
            BigDecimal sigurnost = new BigDecimal(jComboBoxSigurnost.getSelectedItem().toString());
            BigDecimal koeficijent = new BigDecimal(jFormattedTextFieldKoeficijent.getValue().toString());
            BigDecimal mt = new BigDecimal(jFormattedTextFieldMT.getValue().toString());
            BigDecimal dobitakSigurnost = BigDecimal.ZERO;
            dobitakSigurnost = (sigurnost.multiply(koeficijent)).setScale(2, RoundingMode.HALF_UP);
            if (mt.compareTo(BigDecimal.ZERO) != 0) {
                mt = mt.divide(Pomocna.sto, 2, RoundingMode.HALF_UP).add(BigDecimal.ONE);
                dobitakSigurnost = dobitakSigurnost.divide(mt, 2, RoundingMode.HALF_UP);
            }
            jFormattedTextFieldSaldoSigurnost.setValue(dobitakSigurnost);
            if (jComboBoxStatusNaziv.getSelectedIndex() == 0) {
                jFormattedTextFieldSaldoSigurnost.setValue(0);
            } else if (jComboBoxStatusNaziv.getSelectedIndex() == 1) {
                jFormattedTextFieldSaldoSigurnost.setValue(dobitakSigurnost.subtract(sigurnost));
            } else {
                jFormattedTextFieldSaldoSigurnost.setValue(sigurnost.negate());
            }
        } catch (Exception ex) {
            //Supress           
            //  System.err.println(ex.getMessage());            
        }
    }

    private void select() {
        try {
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(selectSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            jFormattedTextFieldId.setValue(rs.getInt("ID"));
            jFormattedTextFieldDatum.setValue(rs.getDate("DATUM"));
            jFormattedTextFieldTipster.setValue(rs.getInt("TIPSTER_ID"));
            jTextAreaOpis.setText(rs.getString("OPIS"));
            jFormattedTextFieldUlog.setValue(rs.getBigDecimal("ULOG"));
            jFormattedTextFieldKoeficijent.setValue(rs.getBigDecimal("KOEFICIJENT"));
            jFormattedTextFieldDobitak.setValue(rs.getBigDecimal("DOBITAK"));
            jFormattedTextFieldSaldo.setValue(rs.getBigDecimal("SALDO"));
            jTextAreaNapomena.setText(rs.getString("NAPOMENA"));
            jComboBoxStatusNaziv.setSelectedIndex(rs.getInt("STATUS_ID"));
            jFormattedTextFieldMT.setValue(rs.getBigDecimal("MT"));
            jCheckBoxIgram.setSelected(rs.getString("IGRAM").equals("1"));
            jComboBoxSigurnost.setSelectedItem(rs.getString("SIGURNOST"));
            jFormattedTextFieldParova.setValue(rs.getInt("PAROVA"));
            jFormattedTextFieldSaldoSigurnost.setValue(rs.getBigDecimal("SALDO_SIGURNOST"));
            rs.close();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }

    private void update() {
        try {
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(updateSQL);
            ps.setDate(1, Pomocna.DatumUSQLDatum((Date) jFormattedTextFieldDatum.getValue()));
            ps.setInt(2, Integer.parseInt(jFormattedTextFieldTipster.getValue().toString()));
            ps.setString(3, jTextAreaOpis.getText().trim());
            ps.setBigDecimal(4, new BigDecimal(jFormattedTextFieldUlog.getValue().toString()));
            ps.setBigDecimal(5, new BigDecimal(jFormattedTextFieldKoeficijent.getValue().toString()));
            ps.setBigDecimal(6, new BigDecimal(jFormattedTextFieldDobitak.getValue().toString()));
            ps.setBigDecimal(7, new BigDecimal(jFormattedTextFieldSaldo.getValue().toString()));
            ps.setInt(8, jComboBoxStatusNaziv.getSelectedIndex());
            ps.setString(9, jTextAreaNapomena.getText().trim());
            ps.setBigDecimal(10, new BigDecimal(jFormattedTextFieldMT.getValue().toString()));
            ps.setString(11, jCheckBoxIgram.isSelected() ? "1" : "0");
            ps.setInt(12, Integer.parseInt(jFormattedTextFieldParova.getValue().toString()));
            ps.setString(13, jComboBoxSigurnost.getSelectedItem().toString());
            ps.setBigDecimal(14, new BigDecimal(jFormattedTextFieldSaldoSigurnost.getValue().toString()));
            ps.setInt(15, id);            
            ps.executeUpdate();
            Konekcija.konekcija.commit();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }

    private void insert() {
        try {
            id = PomocnaBaza.getIduciPK("PROMET");
            Pomocna.idPozicioniranje = id;
            PreparedStatement ps = Konekcija.konekcija.prepareStatement(insertSQL);
            ps.setInt(1, id);
            ps.setDate(2, Pomocna.DatumUSQLDatum((Date) jFormattedTextFieldDatum.getValue()));
            ps.setInt(3, Integer.parseInt(jFormattedTextFieldTipster.getValue().toString()));
            ps.setString(4, jTextAreaOpis.getText().trim());
            ps.setBigDecimal(5, new BigDecimal(jFormattedTextFieldUlog.getValue().toString()));
            ps.setBigDecimal(6, new BigDecimal(jFormattedTextFieldKoeficijent.getValue().toString()));
            ps.setBigDecimal(7, new BigDecimal(jFormattedTextFieldDobitak.getValue().toString()));
            ps.setBigDecimal(8, new BigDecimal(jFormattedTextFieldSaldo.getValue().toString()));
            ps.setInt(9, jComboBoxStatusNaziv.getSelectedIndex());
            ps.setString(10, jTextAreaNapomena.getText().trim());
            ps.setBigDecimal(11, new BigDecimal(jFormattedTextFieldMT.getValue().toString()));
            ps.setString(12, jCheckBoxIgram.isSelected() ? "1" : "0");
            ps.setInt(13, Integer.parseInt(jFormattedTextFieldParova.getValue().toString()));
            ps.setString(14, jComboBoxSigurnost.getSelectedItem().toString());
            ps.setBigDecimal(15, new BigDecimal(jFormattedTextFieldSaldoSigurnost.getValue().toString()));
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
    private javax.swing.JComboBox jComboBoxSigurnost;
    private javax.swing.JComboBox jComboBoxStatusNaziv;
    private javax.swing.JFormattedTextField jFormattedTextFieldDatum;
    private javax.swing.JFormattedTextField jFormattedTextFieldDobitak;
    private javax.swing.JFormattedTextField jFormattedTextFieldId;
    private javax.swing.JFormattedTextField jFormattedTextFieldKoeficijent;
    private javax.swing.JFormattedTextField jFormattedTextFieldMT;
    private javax.swing.JFormattedTextField jFormattedTextFieldParova;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaldo;
    private javax.swing.JFormattedTextField jFormattedTextFieldSaldoSigurnost;
    private javax.swing.JFormattedTextField jFormattedTextFieldTipster;
    private javax.swing.JFormattedTextField jFormattedTextFieldUlog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaNapomena;
    private javax.swing.JTextArea jTextAreaOpis;
    private javax.swing.JTextField jTextFieldTipsterNaziv;
    // End of variables declaration//GEN-END:variables
}
