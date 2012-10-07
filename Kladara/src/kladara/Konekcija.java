/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kladara;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pomocni.Poruka;

/**
 *
 * @author damirl
 */
public class Konekcija {

    public static Connection konekcija;

    public Konekcija() {
        otvoriKonekciju();
    }

    public final void otvoriKonekciju() {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:" + "C:/Kladara/baza.db";
            String user = "damirl";
            String password = "lucifer";
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);                   
        } catch (SQLException ex) {
            Poruka.greska(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Poruka.greska(null, ex.getMessage());
        }


    }
}
