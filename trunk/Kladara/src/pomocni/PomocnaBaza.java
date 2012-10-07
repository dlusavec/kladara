/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import kladara.Konekcija;
import pojo.Tipster;

/**
 *
 * @author damirl
 */
public class PomocnaBaza {

    public static void obrisiSlog(String tablica, Integer pk) {
        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            stmt.execute("DELETE FROM " + tablica + " WHERE ID=" + pk.toString());
            konekcija.commit();
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
    }

    public static Integer getIduciPK(String tablica) {
        Integer pk = 0;
        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID) ID FROM " + tablica);
            while (rs.next()) {
                pk = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
        return ++pk;
    }

    private static boolean tablicaPostoji(String tablica) {
        boolean postoji = false;
        try {
            if (Konekcija.konekcija == null || !Konekcija.konekcija.isValid(0)) {
                return false;
            }
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COALESCE(MAX(1),0) POSTOJI WHERE EXISTS(SELECT 1 FROM INFORMATION_SCHEMA.TABLES "
                    + " WHERE TABLE_TYPE='TABLE' AND TABLE_NAME='" + tablica.trim() + "')");
            rs.first();
            postoji = rs.getInt("POSTOJI") == 1;

        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
        return postoji;
    }

    public static void instalirajPomocneTablice() {
        try {
            if (Konekcija.konekcija != null && Konekcija.konekcija.isValid(0)) {
                Statement stmt = Konekcija.konekcija.createStatement();
                // NAZIV_DANA
                if (!tablicaPostoji("NAZIV_DANA")) {
                    String sql = "CREATE TABLE NAZIV_DANA(\n"
                            + "ENGLESKI VARCHAR_IGNORECASE(20) NOT NULL,\n"
                            + "HRVATSKI VARCHAR_IGNORECASE(20) NOT NULL\n"
                            + ");\n"
                            + "CREATE UNIQUE INDEX IX_NATIV_DANA_A  ON NAZIV_DANA(ENGLESKI,HRVATSKI);\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Monday','Ponedjeljak');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Tuesday','Utorak');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Wednesday','Srijeda');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Thursday','Četvrtak');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Friday','Petak');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Saturday','Subota');\n"
                            + "INSERT INTO NAZIV_DANA(ENGLESKI,HRVATSKI) VALUES('Sunday','Nedjelja');";
                    Scanner skener = new Scanner(sql);
                    skener.useDelimiter(";");
                    while (skener.hasNext()) {
                        stmt.execute(skener.next());
                    }
                    Konekcija.konekcija.commit();
                }
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
    }

    public static String getTipsterNaziv(Object id) {
        String naziv = "";
        if (id == null) {
            return "";
        }
        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAZIV FROM TIPSTER WHERE ID = " + id.toString());
            while (rs.next()) {
                naziv = rs.getString("NAZIV");
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
        return naziv;
    }

    public static Tipster getTipster(Object id) {
        Tipster tipster = new Tipster();
        if (id == null) {
            return tipster;
        }
        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID,NAZIV,NAPOMENA,GRUPA_ID,IGRAM,MT FROM TIPSTER WHERE ID = " + id.toString());
            while (rs.next()) {
                tipster = new Tipster();
                tipster.setId(rs.getInt("ID"));
                tipster.setNaziv(rs.getString("NAZIV"));
                tipster.setNapomena(rs.getString("NAPOMENA"));
                tipster.setGrupaId(rs.getInt("GRUPA_ID"));
                tipster.setIgram(rs.getString("IGRAM"));
                tipster.setMt(rs.getBigDecimal("MT"));
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
        return tipster;
    }

    public static String getStatusNaziv(Object id) {
        String naziv = "";
        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAZIV FROM STATUS WHERE ID = " + id.toString());
            while (rs.next()) {
                naziv = rs.getString("NAZIV");
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
        return naziv;
    }

    public static void statusUComboBox(JComboBox combo, boolean opcijaSve) {
        combo.removeAllItems();

        try {
            Connection konekcija = Konekcija.konekcija;
            Statement stmt = konekcija.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NAZIV FROM STATUS ORDER BY ID");
            while (rs.next()) {
                combo.addItem(rs.getString("NAZIV"));
            }

            if (opcijaSve) {
                combo.addItem("Zaključen");
                combo.addItem("Sve");
            }
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        }
    }
}
