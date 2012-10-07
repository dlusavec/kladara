/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;
import quick.dbtable.Column;
import quick.dbtable.DBTable;

/**
 *
 * @author damirl
 */
public class Pomocna {

    public static Integer idPozicioniranje = 0;
    public static Integer redPozicioniranje = 0;
    public static SimpleDateFormat formatDatuma = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat formatDatumaBaza = new SimpleDateFormat("yyyy-MM-dd");
    public static BigDecimal sto = new BigDecimal(100);
    public static String mapaIzvestaja = "C:/Kladara/Izvjestaji_kladara/";
//    public static Kalendar kalendar = new Kalendar(new Frame(), false, false);

    public Pomocna() {
    }

    public static void pozicioniranje(int opcija, int kolona, DBTable tablica) {
        // opcija 1 - po vrijednosti, 2 po redu u tablici
        int redova = tablica.getRowCount();
        if (opcija == 1) {
            for (int i = 0; i < redova; i++) {
                String s = tablica.getValueAt(i, 0).toString();
                if (s.equals(Pomocna.idPozicioniranje.toString())) {
                    tablica.selectCell(i, 0, true);
                    break;
                }
            }
        } else {
            tablica.selectCell(redova <= redPozicioniranje ? redova - 1 : redPozicioniranje, 0, true);
        }

    }

    public static void pozicioniranjeReset() {
        idPozicioniranje = 0;
        redPozicioniranje = 0;
    }

    public static Date getPocetakMjeseca(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getKrajMjeseca(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    public static Date getMjesecPrijeNakon(Date datum, int plusMinus) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int mjesec = c.get(Calendar.MONTH);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.MONTH, mjesec + plusMinus);
        return c.getTime();
    }

    public static void navigacijaKrozMjesece(JFormattedTextField jFormattedTextField, KeyEvent keyEvent, boolean pocetakMjeseca) {
        if (keyEvent.isAltDown() && (keyEvent.getKeyCode() == KeyEvent.VK_DOWN || keyEvent.getKeyCode() == KeyEvent.VK_UP)) {
            Date datum;
            try {
                datum = (Date) jFormattedTextField.getValue();
            } catch (Exception e) {
                datum = new Date();
            }
            datum = getMjesecPrijeNakon(datum, keyEvent.getKeyCode() == KeyEvent.VK_UP ? 1 : -1);
            datum = pocetakMjeseca ? getPocetakMjeseca(datum) : getKrajMjeseca(datum);
            jFormattedTextField.setValue(datum);
        }
    }

    public static Date getPocetakGodine(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int godina = c.get(Calendar.YEAR);
        c.set(godina, 0, 1);
        return c.getTime();
    }

    public static java.sql.Date DatumUSQLDatum(java.util.Date datum) {
        java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
        return sqlDatum;
    }

    public static String TekstDatumUSQLDatum(String datum) {
        String datumSQL = "";
        try {
            datumSQL = formatDatumaBaza.format(formatDatuma.parse(datum.trim()));
        } catch (ParseException ex) {
            Logger.getLogger(Pomocna.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "'" + datumSQL + "'";
    }

    public static void instalirajCheckBox(DBTable tablica, int kolona) {
        Hashtable ht = new Hashtable();
        ht.put("1", new Boolean(true));
        ht.put("0", new Boolean(false));
        tablica.setCellComponent(tablica.getColumn(kolona), Column.CHECKBOX_CELL, ht);
    }

    public static void igramUComboBox(JComboBox combo) {
        combo.removeAllItems();
        combo.addItem("Ne Igram");
        combo.addItem("Igram");
        combo.addItem("Sve");
    }

    public static void sigurnostUComboBox(JComboBox combo, boolean opcijaSve) {
        combo.removeAllItems();
        for (int i = 1; i <= 10; i++) {
            combo.addItem(Integer.toString(i));
        }
        if (opcijaSve) {
            combo.addItem("Sve");
        }
    }

    /*   public static void odaberiDatum(JFormattedTextField jFormattedTextFieldDatum) {
     Date trenutniDatum;
     try {
     trenutniDatum = (Date) jFormattedTextFieldDatum.getValue();
     } catch (Exception e) {
     trenutniDatum = new Date();
     kalendar.setVisible(true);
     kalendar.setAlwaysOnTop(true);
     }

     }*/
    public static void registrirajFokusNaPrvuKomponentu(JComponent komponenta) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("F1");
        Action action = new AbstractAction("focus") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JComponent) e.getSource()).requestFocusInWindow();
            }
        };
        komponenta.registerKeyboardAction(action, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public static void postavkeProzora(Window prozor) {
        Set forwardKeys = prozor.getFocusTraversalKeys(
                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
        Set newForwardKeys = new HashSet(forwardKeys);
        newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        prozor.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                newForwardKeys);
    }

    public static void kreirajMapuIzvjestaja() {
        File mapa = new File(mapaIzvestaja);
        if (!mapa.exists()) {
            mapa.mkdir();
        }
    }
}
