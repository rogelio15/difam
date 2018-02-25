package pruebas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class BusquedaInComboBox extends PlainDocument {

    JComboBox comboBox;
    ComboBoxModel model;
    JTextComponent editor;
    boolean selecting = false;

    public BusquedaInComboBox(final JComboBox comboBox) {
        this.comboBox = comboBox;
        model = comboBox.getModel();
        editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        // return immediately when selecting an item
        if (selecting) {
            return;
        }
        super.remove(offs, len);
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (selecting) {
            return;
        }
        super.insertString(offs, str, a);
        Object item = lookupItem(getText(0, getLength()));
        if (item != null) {
            setSelectedItem(item);
        } else {
            item = comboBox.getSelectedItem();
            offs = offs - str.length();
            comboBox.getToolkit().beep(); // when available use: UIManager.getLookAndFeel().provideErrorFeedback(comboBox);
        }

        setText(item.toString());
        highlightCompletedText(offs + str.length());
    }

    private void setText(String text) throws BadLocationException {
        super.remove(0, getLength());
        super.insertString(0, text, null);
    }

    private void highlightCompletedText(int start) {
        editor.setSelectionStart(start);
        editor.setSelectionEnd(getLength());
    }

    private void setSelectedItem(Object item) {
        selecting = true;
        model.setSelectedItem(item);
        selecting = false;
    }

    public Object lookupItem(String pattern) {
        Object selectedItem = model.getSelectedItem();
        // only search for a different item if the currently selected does not match
        if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), pattern)) {
            return selectedItem;
        } else {
            // iterate over all items
            for (int i = 0, n = model.getSize(); i < n; i++) {
                Object currentItem = model.getElementAt(i);
                // current item starts with the pattern?
                if (startsWithIgnoreCase(currentItem.toString(), pattern)) {
                    return currentItem;
                }
            }
        }
        // no item starts with the pattern => return null
        return null;
    }

    // checks if str1 starts with str2 - ignores case
    private boolean startsWithIgnoreCase(String str1, String str2) {
        return str1.toUpperCase().startsWith(str2.toUpperCase());
    }
}