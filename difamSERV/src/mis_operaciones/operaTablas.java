/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mis_operaciones;

import javax.swing.*;

public class operaTablas {

    public static boolean sumaCampos(JTable tabla, int c1, int c2, int colRes) {
        System.out.println("SUMA DE CAMPOS LIBRERIA");
        for (int fila = 0; fila < tabla.getRowCount(); fila++) {
            tabla.setValueAt((convertirStringDouble(tabla.getValueAt(fila, c1).toString()) - convertirStringDouble(tabla.getValueAt(fila, c2).toString())),fila,colRes);
        }
        return true;
    }

    public static double sumaCampos(double c1, double c2) {
        double res = c1 + c2;
        return res;
    }
    
    public static double convertirStringDouble(String valor){
        return Double.parseDouble(valor);
    }
}
