/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import quick.dbtable.CellComponent;

/**
 *
 * @author damirl
 */
public class CelijaNumeric extends JLabel implements TableCellRenderer {

    public CelijaNumeric() {
        setHorizontalAlignment(JLabel.RIGHT);
         setOpaque(true);
    }


  

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setBackground(Color.RED);
        return this;
    }
}
