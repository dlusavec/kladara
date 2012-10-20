/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kladara;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import pojo.Tipster;
import pomocni.ExportUExcel;
import pomocni.Pomocna;
import pomocni.PomocnaBaza;
import pomocni.Poruka;

/**
 *
 * @author damirl
 */
public class RekapitulacijaTipsterSigurnostPregled extends javax.swing.JDialog {

    /**
     * Creates new form TipseriPregled
     */
    String selectSQL = "";

    public RekapitulacijaTipsterSigurnostPregled(Component parent, boolean modal) {
        super();
        initComponents();
        setLocationRelativeTo(parent);
        tablica.setRowCountSql(null);
        postavkeParametri();
        napraviSelectSQL();
        try {
            tablica.refresh();
            totalSQL();
            postavkeTablica();
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
        this.getRootPane().setDefaultButton(jButtonOK);
        Pomocna.postavkeProzora(this, jFormattedTextFieldDatumOd);
        setVisible(true);
        lokacijaPoljaTotala();
        setModal(modal);
        tablica.selectCell(0, 0, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablica = new quick.dbtable.DBTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonLista = new javax.swing.JButton();
        jButtonDetalj = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldDatumOd = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldDatumDo = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldTipster = new javax.swing.JFormattedTextField();
        jTextFieldTipsterNaziv = new javax.swing.JTextField();
        jComboBoxIgram = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonIzlaz = new javax.swing.JButton();
        jFormattedTextFieldSSigurnost = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSSaldo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldSTiketa = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSDobitno = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSGubitno = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSROI = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rekapitulacija - Tipster sigurnost");
        setLocationByPlatform(true);
        setResizable(false);

        tablica.setConnection(Konekcija.konekcija);
        tablica.setMaximumSize(new java.awt.Dimension(1100, 310));
        tablica.setMinimumSize(new java.awt.Dimension(1100, 310));
        tablica.setSelectSql("SELECT B.ID AS Id, b.Naziv as Naziv,SUM(A.ULOG) as Uloženo, SUM(A.Saldo) AS Saldo, ROUND(SUM(A.SALDO)/SUM(A.ULOG)*100,2) AS ROI,\nROUND(AVG(ULOG),2) as Prosj_ulog,ROUND(SUM(SALDO)/AVG(ULOG),2) as Osvojio_uloga,\nCOUNT(*) as Tiketa, SUM(CASE A.STATUS_ID WHEN 1 THEN 1 ELSE 0 END) AS Dobitno,SUM(CASE A.STATUS_ID WHEN 2 THEN 1 ELSE 0 END) AS Gubitno\nFROM PROMET A\nINNER JOIN TIPSTER B ON B.ID=a.TIPSTER_ID\nWHERE A.DATUM>='2012-09-01' and STATUS_ID IN(1,2)\nGROUP BY B.ID,B.NAZIV \nORDER BY Naziv");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(1100, 56));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 56));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 56));

        jButtonLista.setMnemonic('L');
        jButtonLista.setText("Lista");
        jButtonLista.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonLista.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonLista.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaActionPerformed(evt);
            }
        });

        jButtonDetalj.setMnemonic('D');
        jButtonDetalj.setText("Detalj");
        jButtonDetalj.setMaximumSize(new java.awt.Dimension(80, 30));
        jButtonDetalj.setMinimumSize(new java.awt.Dimension(80, 30));
        jButtonDetalj.setPreferredSize(new java.awt.Dimension(80, 30));
        jButtonDetalj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetaljActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDetalj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDetalj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setMaximumSize(new java.awt.Dimension(1100, 80));
        jPanel2.setMinimumSize(new java.awt.Dimension(1100, 80));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Datum od");

        jFormattedTextFieldDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextFieldDatumOd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldDatumOd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDatumOdFocusGained(evt);
            }
        });
        jFormattedTextFieldDatumOd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDatumOdKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("do");

        jFormattedTextFieldDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextFieldDatumDo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jFormattedTextFieldDatumDo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDatumDoFocusGained(evt);
            }
        });
        jFormattedTextFieldDatumDo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDatumDoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tipster");

        jFormattedTextFieldTipster.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
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

        jTextFieldTipsterNaziv.setEditable(false);
        jTextFieldTipsterNaziv.setBackground(java.awt.SystemColor.controlHighlight);
        jTextFieldTipsterNaziv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldTipsterNaziv.setForeground(new java.awt.Color(0, 0, 153));
        jTextFieldTipsterNaziv.setFocusable(false);

        jComboBoxIgram.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Igram");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jFormattedTextFieldDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldTipster, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTipsterNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxIgram, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jFormattedTextFieldDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jFormattedTextFieldDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jFormattedTextFieldTipster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldTipsterNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBoxIgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFormattedTextFieldSSigurnost.setEditable(false);
        jFormattedTextFieldSSigurnost.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSSigurnost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
        jFormattedTextFieldSSigurnost.setFocusable(false);
        jFormattedTextFieldSSigurnost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFormattedTextFieldSSaldo.setEditable(false);
        jFormattedTextFieldSSaldo.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
        jFormattedTextFieldSSaldo.setFocusable(false);
        jFormattedTextFieldSSaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total");

        jFormattedTextFieldSTiketa.setEditable(false);
        jFormattedTextFieldSTiketa.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSTiketa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
        jFormattedTextFieldSTiketa.setFocusable(false);
        jFormattedTextFieldSTiketa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFormattedTextFieldSDobitno.setEditable(false);
        jFormattedTextFieldSDobitno.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSDobitno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
        jFormattedTextFieldSDobitno.setFocusable(false);
        jFormattedTextFieldSDobitno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFormattedTextFieldSGubitno.setEditable(false);
        jFormattedTextFieldSGubitno.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSGubitno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###,##0.00"))));
        jFormattedTextFieldSGubitno.setFocusable(false);
        jFormattedTextFieldSGubitno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFormattedTextFieldSROI.setEditable(false);
        jFormattedTextFieldSROI.setBackground(java.awt.SystemColor.controlHighlight);
        jFormattedTextFieldSROI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00%"))));
        jFormattedTextFieldSROI.setFocusable(false);
        jFormattedTextFieldSROI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(197, 197, 197)
                .addComponent(jFormattedTextFieldSSigurnost, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldSSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldSROI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFormattedTextFieldSTiketa, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldSDobitno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldSGubitno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addComponent(tablica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tablica, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextFieldSSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextFieldSSigurnost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextFieldSROI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldSDobitno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldSGubitno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldSTiketa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postavkeParametri() {
        jFormattedTextFieldDatumOd.setValue(Pomocna.getPocetakMjeseca(new Date()));
        jFormattedTextFieldDatumDo.setValue(new Date());
        Pomocna.igramUComboBox(jComboBoxIgram);
        jComboBoxIgram.setSelectedIndex(2);
    }

    private void postavkeTablica() {
        tablica.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        tablica.setEditable(false);
        //Kolone
        //Id
        tablica.getColumn(0).setMaxWidth(60);
        tablica.getColumn(0).setHeaderValue("Id");
        //Tipster
        tablica.getColumn(1).setMinWidth(180);
        tablica.getColumn(1).setMaxWidth(180);
        tablica.getColumn(1).setHeaderValue("Tipster");
        //Uloženo
        tablica.getColumn(2).setMinWidth(100);
        tablica.getColumn(2).setMaxWidth(100);
        tablica.getColumn(2).setHeaderValue("Ul. jedinica");
        //Saldo
        tablica.getColumn(3).setMinWidth(100);
        tablica.getColumn(3).setMaxWidth(100);
        tablica.getColumn(3).setHeaderValue("Saldo");
        //ROI
        tablica.getColumn(4).setHeaderValue("ROI %");
        tablica.getColumn(4).setMinWidth(100);
        tablica.getColumn(4).setMaxWidth(100);
        //Prosjecni sig.
        tablica.getColumn(5).setMinWidth(100);
        tablica.getColumn(5).setMaxWidth(100);
        tablica.getColumn(5).setHeaderValue("Prosj. jed.");
        //Prosjecni koeficijent
        tablica.getColumn(6).setMinWidth(100);
        tablica.getColumn(6).setMaxWidth(100);
        tablica.getColumn(6).setHeaderValue("Prosj. koef.");
        //Tiketa
        tablica.getColumn(7).setMinWidth(70);
        tablica.getColumn(7).setMaxWidth(70);
        tablica.getColumn(7).setHeaderValue("Tiketa");
        //Dobitno
        tablica.getColumn(8).setHeaderValue("Dobitno");
        tablica.getColumn(8).setMinWidth(70);
        tablica.getColumn(8).setMaxWidth(70);
        //Gubitno       
        tablica.getColumn(9).setHeaderValue("Gubitno");
        tablica.getColumn(9).setMinWidth(70);
        tablica.getColumn(9).setMaxWidth(70);
        //Dobitno %       
        tablica.getColumn(10).setHeaderValue("Dob. %");

        TablicaSkin skin = new TablicaSkin();
        tablica.setSkin(skin);
        Object put = UIManager.put("Table.gridColor", Color.black);

    }

    private void lokacijaPoljaTotala() {
        Point tocka = jFormattedTextFieldSSigurnost.getLocation();
        /*  jFormattedTextFieldSUlog.setLocation(200, tocka.y);
    
         jFormattedTextFieldSDobitak.setLocation(300, tocka.y);
      
         jFormattedTextFieldSOsvojeno.setLocation(620, tocka.y);
       
         jFormattedTextFieldSTiketa.setLocation(700, tocka.y);
       
         jFormattedTextFieldSDobitno.setLocation(800, tocka.y);
     
         jFormattedTextFieldSGubitno.setLocation(950, tocka.y);*/
    }

    private void napraviSelectSQL() {
     String sql = "SELECT B.ID AS Id, b.Naziv as Naziv,SUM(CAST(A.SIGURNOST AS DECIMAL(2))) as Sigurnost, SUM(A.Saldo_sigurnost) AS Saldo, ROUND(SUM(A.SALDO_SIGURNOST)/SUM(CAST(A.SIGURNOST AS DECIMAL(2)))*100,2) AS ROI,\n"
                + "ROUND(AVG(CAST(SIGURNOST AS DECIMAL(2))),2) as Prosj_ulog,ROUND(AVG(KOEFICIJENT),3) as Prosj_koef,\n"
                + "COUNT(*) as Tiketa, SUM(CASE A.STATUS_ID WHEN 1 THEN 1 ELSE 0 END) AS Dobitno,SUM(CASE A.STATUS_ID WHEN 2 THEN 1 ELSE 0 END) AS Gubitno, \n"
                + "ROUND(CAST(SUM(CASE A.STATUS_ID WHEN 1 THEN 1 ELSE 0 END) AS DECIMAL(15,3))/COUNT(*)*100,2) Dobitno_posto \n"
                + "FROM PROMET A \n"
                + "INNER JOIN TIPSTER B ON B.ID=A.TIPSTER_ID\n";
        String where = "";
        //Where
        where = napraviWhereSQL();
        sql = sql + where;
        // Group by
        sql = sql + " GROUP BY B.ID, B.NAZIV ";
        // Order by             
        sql = sql + " ORDER BY B.ID ";
        tablica.setSelectSql(sql);
    }

    private void totalSQL() {
        try {
          String sql = "SELECT SUM(CAST(A.SIGURNOST AS DECIMAL(2))) as Sigurnost, SUM(A.Saldo_sigurnost) AS Saldo, ROUND(SUM(A.SALDO_SIGURNOST)/SUM(CAST(A.SIGURNOST AS DECIMAL(2)))*100,2) AS ROI,\n"
                + "ROUND(AVG(CAST(SIGURNOST AS DECIMAL(2))),2) as Prosj_ulog,ROUND(AVG(KOEFICIJENT),3) as Prosj_koef,\n"
                + "COUNT(*) as Tiketa, SUM(CASE A.STATUS_ID WHEN 1 THEN 1 ELSE 0 END) AS Dobitno,SUM(CASE A.STATUS_ID WHEN 2 THEN 1 ELSE 0 END) AS Gubitno, \n"
                + "ROUND(CAST(SUM(CASE A.STATUS_ID WHEN 1 THEN 1 ELSE 0 END) AS DECIMAL(15,3))/COUNT(*)*100,2) Dobitno_posto \n"
                + "FROM PROMET A \n";             
            String where = "";
            //Where
            where = napraviWhereSQL();
            sql = sql + where;
            Statement stmt = Konekcija.konekcija.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.first();
            jFormattedTextFieldSSigurnost.setValue(rs.getBigDecimal("SIGURNOST"));
            jFormattedTextFieldSSaldo.setValue(rs.getBigDecimal("SALDO"));
            jFormattedTextFieldSROI.setValue(rs.getBigDecimal("ROI"));            
            jFormattedTextFieldSTiketa.setValue(rs.getBigDecimal("TIKETA"));
            jFormattedTextFieldSDobitno.setValue(rs.getBigDecimal("DOBITNO"));
            jFormattedTextFieldSGubitno.setValue(rs.getBigDecimal("GUBITNO"));
            rs.close();
        } catch (SQLException ex) {
            Poruka.greska(rootPane, ex.getMessage());
        }

    }

    private String napraviWhereSQL() {
        String where = " where ";
        //Datum od do
        where = where + " A.DATUM BETWEEN " + Pomocna.TekstDatumUSQLDatum(jFormattedTextFieldDatumOd.getText()) + " AND "
                + Pomocna.TekstDatumUSQLDatum(jFormattedTextFieldDatumDo.getText());
        //Tipster
        if (!jTextFieldTipsterNaziv.getText().equals("")) {
            where = where + " AND A.TIPSTER_ID=" + jFormattedTextFieldTipster.getValue();
        }
        //Igram
        if (jComboBoxIgram.getSelectedIndex() != 2) {
            where = where + " AND A.IGRAM=" + jComboBoxIgram.getSelectedIndex();
        }
        where = where + " AND A.STATUS_ID IN(1,2)";
        return where;
    }
    private void jFormattedTextFieldDatumOdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumOdFocusGained
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldDatumOd.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldDatumOdFocusGained

    private void jFormattedTextFieldDatumOdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumOdKeyPressed
        Pomocna.navigacijaKrozMjesece((JFormattedTextField) evt.getSource(), evt, true);
    }//GEN-LAST:event_jFormattedTextFieldDatumOdKeyPressed

    private void jFormattedTextFieldDatumDoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumDoFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldDatumDo.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldDatumDoFocusGained

    private void jFormattedTextFieldDatumDoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumDoKeyPressed
        Pomocna.navigacijaKrozMjesece((JFormattedTextField) evt.getSource(), evt, false);
    }//GEN-LAST:event_jFormattedTextFieldDatumDoKeyPressed

    private void jFormattedTextFieldTipsterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTipsterFocusGained
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFormattedTextFieldTipster.selectAll();
            }
        });
    }//GEN-LAST:event_jFormattedTextFieldTipsterFocusGained

    private void jFormattedTextFieldTipsterPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTipsterPropertyChange
        if (evt.getPropertyName().equals("value")) {
            Tipster tipster = PomocnaBaza.getTipster(evt.getNewValue());
            jTextFieldTipsterNaziv.setText(tipster.getNaziv());
            //jCheckBoxIgram.setSelected(tipster.getIgram() != null && tipster.getIgram().equals("1"));
        }
    }//GEN-LAST:event_jFormattedTextFieldTipsterPropertyChange

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

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if ((jFormattedTextFieldTipster.getValue() != null && !jFormattedTextFieldTipster.getText().trim().equals("0")) && jTextFieldTipsterNaziv.getText().equals("")) {
            Poruka.greska(this, "Tipster ?");
            jFormattedTextFieldTipster.requestFocus();
            return;
        }

        try {
            napraviSelectSQL();
            tablica.refresh();
            totalSQL();
            postavkeTablica();
            tablica.selectCell(0, 0, true);
        } catch (SQLException ex) {
            Poruka.greska(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzlazActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonIzlazActionPerformed

    private void jButtonListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaActionPerformed
        String zaglavlje = "Rekapitulacija tipstera - sigurnost, Period: " + jFormattedTextFieldDatumOd.getText() + " do " + jFormattedTextFieldDatumDo.getText();
        if (jTextFieldTipsterNaziv.getText() != null && !jTextFieldTipsterNaziv.getText().equals("")) {
            zaglavlje = zaglavlje + ", Tipster: " + jTextFieldTipsterNaziv.getText();
        }
        zaglavlje = zaglavlje + ", Igram: " + jComboBoxIgram.getSelectedItem();
        Pomocna.redPozicioniranje = tablica.getSelectedRow();
        ExportUExcel.exportTabliceUExcel(zaglavlje, tablica, "Rekapitulacija_tipster_sigurnost.xls", "2 3 7 8 9", "2 3");
        Pomocna.pozicioniranje(2, 0, tablica);
    }//GEN-LAST:event_jButtonListaActionPerformed

    private void jButtonDetaljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetaljActionPerformed
        tablica.selectCell(tablica.getSelectedRow(), 0);
        new DetaljPrometPregled(this.getParent(), false, jFormattedTextFieldDatumOd.getText(), jFormattedTextFieldDatumDo.getText(), tablica.getValueAt(tablica.getSelectedRow(), 0), jComboBoxIgram.getSelectedIndex());
    }//GEN-LAST:event_jButtonDetaljActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetalj;
    private javax.swing.JButton jButtonIzlaz;
    private javax.swing.JButton jButtonLista;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxIgram;
    private javax.swing.JFormattedTextField jFormattedTextFieldDatumDo;
    private javax.swing.JFormattedTextField jFormattedTextFieldDatumOd;
    private javax.swing.JFormattedTextField jFormattedTextFieldSDobitno;
    private javax.swing.JFormattedTextField jFormattedTextFieldSGubitno;
    private javax.swing.JFormattedTextField jFormattedTextFieldSROI;
    private javax.swing.JFormattedTextField jFormattedTextFieldSSaldo;
    private javax.swing.JFormattedTextField jFormattedTextFieldSSigurnost;
    private javax.swing.JFormattedTextField jFormattedTextFieldSTiketa;
    private javax.swing.JFormattedTextField jFormattedTextFieldTipster;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldTipsterNaziv;
    private quick.dbtable.DBTable tablica;
    // End of variables declaration//GEN-END:variables
}
