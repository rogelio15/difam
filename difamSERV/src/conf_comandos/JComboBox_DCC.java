/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conf_comandos;

import pruebas.BusquedaInComboBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

public class JComboBox_DCC {
    public static void llenarCombo(ArrayList misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            for (int i = 0; i < misRegistros.size(); i++) {
                HashMap misDatos = (HashMap) misRegistros.get(i);
                modeloCB.addElement(misDatos.get("2").toString() + "-" + misDatos.get("1").toString());
            }
        }
        combo.setModel(modeloCB);
        combo.setEditable(true);
        JTextComponent editor = (JTextComponent) combo.getEditor().getEditorComponent();
        editor.setDocument(new BusquedaInComboBox(combo));
    }
    
    public static void coincideCampo(JComboBox combo, String DATO) {
        combo.setSelectedItem(DATO);
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).toString().contains(DATO)) {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }

    public static void llenarCombo_ID(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(1) + "-" + misDatos.get(0));
            }
        }
        combo.setEditable(true);
        JTextComponent editor = (JTextComponent) combo.getEditor().getEditorComponent();
        editor.setDocument(new BusquedaInComboBox(combo));
        combo.setModel(modeloCB);
        asignaEstilo(combo);
    }

    public static void llenarCombo(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(0));
            }
        }
        combo.setModel(modeloCB);
        asignaEstilo(combo);
    }

    public static String obtenID(JComboBox combo) {
        return combo.getSelectedItem().toString().substring(combo.getSelectedItem().toString().indexOf('-') + 1);
    }
    
    public static void asignaEstilo(JComboBox combo){
        combo.setEditable(true);
        JTextComponent editor = (JTextComponent) combo.getEditor().getEditorComponent();
        editor.setDocument(new BusquedaInComboBox(combo));
    }
}