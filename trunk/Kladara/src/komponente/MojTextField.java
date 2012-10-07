/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komponente;

import javax.swing.JTextField;

/**
 *
 * @author damirl
 */
public class MojTextField extends JTextField {

    public String mojTekst;

    public MojTextField() {
        super();
        mojTekst = "mojTekst";
        setText(mojTekst);
    }

    public String getMojTekst() {
        return mojTekst;
    }

    public void setMojTekst(String mojTekst) {
        this.mojTekst = mojTekst;
    }
}
