/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kladara;

import java.awt.Color;
import java.awt.Font;
import quick.dbtable.CellPropertiesModel;
import quick.dbtable.Skin;

/**
 *
 * @author damirl
 */
public class TablicaSkin extends Skin {

    Font headerFont = new Font("Tahoma", Font.BOLD, 14);
    Font font = new Font("Tahoma", Font.PLAIN, 12);
    Color background = Color.WHITE;
    Color selectionFontColor = Color.BLUE;
    Color header = new Color(220, 220, 220);
    Color selekcija = new Color(240, 240, 240);
    Color headerFontColor = Color.BLACK;
    Color fontColor = Color.BLACK;
    CellPropertiesModel cp = new CellPropertiesModel() {
        public Color getForeground(int row, int col) {
            return fontColor;
        }

        public Color getBackground(int row, int col) {
            return background;
        }
    };

    public TablicaSkin() {
        put(Skin.TABLE_FONT, font);
        put(Skin.SELECTION_BACKGROUND, Color.white);//
        put(Skin.SELECTION_FOREGROUND, Color.BLACK);
       //  put(Skin.HEADER_FOREGROUND, headerFontColor);//
        put(Skin.HEADER_BACKGROUND, header);
        put(Skin.HEADER_FONT, headerFont);//
        put(Skin.FOCUS_CELL_HIGHLIGHT_BORDER, new javax.swing.border.MatteBorder(2, 2, 2, 2, Color.BLACK));
        put(Skin.FOCUS_CELL_BACKGROUND, Color.white);
        put(Skin.FOCUS_CELL_FOREGROUND, Color.BLUE);
        put(Skin.GRID_COLOR, Color.GRAY);   //
        //  put(Skin.NAVIGATION_FOREGROUND, headerFontColor);
        //   put(Skin.NAVIGATION_BACKGROUND, header);
        put(Skin.NAVIGATION_FONT, headerFont);
        put(Skin.ROW_HEIGTH, new Integer(20));  //
        //  put(Skin.CELL_PROPERTIES_MODEL, cp);

        //examples to set other properties
        //put(Skin.TABLE_BACKGROUND,Color.lightGray);
        //put(Skin.TABLE_FOREGROUND,Color.black);
        //put(Skin.SHOW_HORIZONTAL_LINES, Boolean.TRUE);
        //put(Skin.SHOW_VERTICAL_LINES, Boolean.TRUE);
        //put(Skin.NEXT_ICON,new ImageIcon(getClass().getResource("next.gif")));
        //put(Skin.PREVIOUS_ICON, new ImageIcon(getClass().getResource("prev.gif")));
        //put(Skin.FIRST_ICON,new ImageIcon(getClass().getResource("first.gif")));
        //put(Skin.LAST_ICON,new ImageIcon(getClass().getResource("last.gif")));
        //put(Skin.DELETE_ICON,new ImageIcon(getClass().getResource("delete.gif")));
        //put(Skin.ADD_ICON,new ImageIcon(getClass().getResource("new.gif")));
        //put(Skin.NAVIGATION_BUTTON_COLOR,Color.lightGray);
        //put(Skin.INTERCELL_SPACING,new Dimension(1,1));
    }
}