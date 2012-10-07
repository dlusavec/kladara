/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author damirl
 */
public class Poruka {

    public static void greska(Component komponenta, String poruka) {
        JOptionPane.showMessageDialog(komponenta,
                poruka,
                "Greška!",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void informacija(Component komponenta, String poruka) {
        JOptionPane.showMessageDialog(komponenta,
                poruka,
                "Poruka",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean potvrda(Component komponenta, String poruka) {
        int i = JOptionPane.showConfirmDialog(komponenta, poruka, "Potvrda", JOptionPane.YES_NO_OPTION);
        return i == 0;
    }
}
