/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableCellEditor;

public class ComboBoxCellEditor extends AbstractCellEditor implements ActionListener, TableCellEditor, Serializable {

    private JComboBox comboBox;

    public ComboBoxCellEditor(JComboBox comboBox) {
        this.comboBox = comboBox;
        this.comboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        this.comboBox.addActionListener(this);
        ((JComponent) comboBox.getEditor().getEditorComponent()).setBorder(null);
    }

    private void setValue(Object value) {
        comboBox.setSelectedItem(value);
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals("comboBoxEdited")) {
            stopCellEditing();
        }
    }

    @Override
    public Object getCellEditorValue() {
        return comboBox.getSelectedItem();
    }

    @Override
    public boolean stopCellEditing() {
        if (comboBox.isEditable()) {
            comboBox.actionPerformed(new ActionEvent(this, 0, ""));
        }
        fireEditingStopped();
        return true;
    }

    // Implementing TableCellEditor
    @Override
    public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
        setValue(value);
        return comboBox;
    }

    // Implementing TreeCellEditor
//    public java.awt.Component getTreeCellEditorComponent(javax.swing.JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
//        String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, false);
//        setValue(stringValue);
//        return comboBox;
//    }    
}
