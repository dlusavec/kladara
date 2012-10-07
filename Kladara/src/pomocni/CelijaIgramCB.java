/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pomocni;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import quick.dbtable.CellComponent;

/**
 *
 * @author damirl
 */
public class CelijaIgramCB implements CellComponent, TableCellRenderer  {

    JCheckBox igramCB = new JCheckBox();

    public CelijaIgramCB() {
    }

    @Override
    public void setValue(Object o) {
        igramCB.setSelected(o.equals("1"));
    }

    @Override
    public Object getValue() {
        return igramCB.isSelected();
    }

    @Override
    public JComponent getComponent() {
        return igramCB;
    }

    @Override
    public void addActionListener(ActionListener al) {
        igramCB.addActionListener(al);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
