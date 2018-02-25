/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conf_comandos;

import javax.swing.JTable;

/**
 *
 * @author dannycruz
 */
public class JTable_Conv_DCC {
    public static double convStringDouble(JTable tabla,int col,int fila){
        return Double.parseDouble(tabla.getValueAt(col, fila).toString());
    }
}