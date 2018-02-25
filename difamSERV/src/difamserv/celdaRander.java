package difamserv;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class celdaRander extends DefaultTableCellRenderer {

    int columna_patron;

    public celdaRander(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    /**
     * Acá redefinimos como se muestra, vemos q ahora lo forzamos a
     * trabajar con JLabel, pero si no lo es, por ejemplo un String
     * igual lo muestro llamando a Super
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(Color.white);
        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            label.setBorder(new EmptyBorder(2,2,2,2));
            label.setOpaque(true);
            fillColor(table, label, isSelected);
            return label;
        } else {
            if (columna_patron > -1) {
                switch (Integer.parseInt(table.getValueAt(row, columna_patron).toString())) {
                    case 0:
                        setBackground(new Color(255, 255, 255));
                        break;
                    case 1:
                        setBackground(new Color(130, 255, 130));
                        break;
                    case 2:
                        setBackground(new Color(255, 255, 130));
                        break;
                    case 3:
                        setBackground(new Color(227, 136, 125));
                        break;
                    case 4:
                        setBackground(new Color(223, 223, 223));
                        break;
                }
            }
            /*if (table.getValueAt(row, columna_patron).equals("INACTIVO") || table.getValueAt(row, columna_patron).equals("INCOMPLETO")) {
                setBackground(new Color(228,228,228));
            }*/
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    /**
     * Este método es para que pinte el fondo del JLabel cuando
     * lo seleccionamos para que no quede en blanco, desentonando
     * con el resto de las celdas que no son JLabel
     */
    public void fillColor(JTable t, JLabel l, boolean isSelected) {
        if (isSelected) {
            l.setBackground(t.getSelectionBackground());
            l.setForeground(t.getSelectionForeground());
        } else {
            l.setBackground(t.getBackground());
            l.setForeground(t.getForeground());
        }
    }
}
