/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * listaCarteras.java
 *
 * Created on 25/04/2014, 07:51:54 PM
 */
package panel;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import panel.panelVistaReportes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 *
 * @author dany
 */
public class listaCarteras extends javax.swing.JPanel {

    Vector columnas;

    public listaCarteras() {
        initComponents();
//        columnas = new Vector();
//        columnas.add("ID VENTA");
//        columnas.add("NOMBRE DEL CLIENTE");
//        columnas.add("TIPO VENTA");
//        columnas.add("ESTADO");
//        columnas.add("FECHA");
//        columnas.add("MONTO TOTAL");
//        columnas.add("MONTO PAG.");
//        columnas.add("NOMBRE AGENTE");
        columnas = new Vector();
        columnas.add("ID Venta");
        columnas.add("Razon Social");
        columnas.add("Población");
        columnas.add("Dias Aten.");
        columnas.add("Hora Aten.");
        columnas.add("F. Venta");
        columnas.add("F. Vence");
        columnas.add("F. Hoy");
        columnas.add("D. Falt.");
        columnas.add("M. Venta");
        columnas.add("M. Pagado");
        columnas.add("Restante");
        columnas.add("U. Pago");
        columnas.add("Estado");
        columnas.add("Nombre Agente");
        //llenarTabla("where idCliente like '%%' and tipoVenta ='R' order by fechaVenta desc");
        llenarTabla("where tipoVenta='R' and estadoVenta='0'");
    }

    public void llenarTabla1(String condicion) {
        tabla.setDefaultRenderer(Object.class, new celdaRander(3));
        tabla.setRowHeight(20);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idVenta,nombreCli,(IF(tipoVenta='M','MOSTRADOR','REMISION')) AS tipoVenta,(IF(estadoVenta='1','COMPLETO','INCOMPLETO')) AS estadoVenta,fechaVenta,montoTotalV,montoTotalV,(select concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) from venta A inner join cliente B inner join ruta_agente C inner join empleado D ON B.idCliente = A.idCliente and C.idR_A = B.idR_A and C.idempleado = D.idempleado where idVenta=venta.idVenta) as nombreEmpleado", "venta", "inner join cliente using(idCliente) inner join ruta_agente using(idR_A) inner join ruta using(idruta) " + condicion), columnas));
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String monto = frmPrincipal.miConex.ConsultaDato("sum(montoPago)", "pago", "where idVenta='" + tabla.getValueAt(i, 0) + "'");
            System.out.println(monto);
            if (monto.equals("null")) {
                tabla.setValueAt("0.00", i, 6);
            } else {
                tabla.setValueAt(monto, i, 6);
            }
        }
        frmPrincipal.packColumn(tabla, 0, 2);
    }

    public void llenarTabla(String condicion) {
        Vector vectorDatos = frmPrincipal.miConex.consDatosParaTablas("V.idVenta,"
                + "C.razonsocialcliente,"
                + "C.poblacioncli,"
                + "C.dias,"
                + "C.horario,"
                + "V.fechaVenta,"
                + "ADDDATE(V.fechaVenta,C.limitediascred) as fechaVence,curdate() as fechaActual,"
                + "DATEDIFF(curdate(),ADDDATE(V.fechaVenta,C.limitediascred)) as dias,"
                + "V.montoTotalV,"
                + "IF((select sum(montopago) from pago where V.idVenta=pago.idVenta)!='',(select sum(montopago) from pago where V.idVenta=pago.idVenta),0.00) as sumapago,"
                + "IF((V.montoTotalV-(select sum(montopago) from pago where V.idVenta=pago.idVenta))!='',(V.montoTotalV-(select sum(montopago) from pago where V.idVenta=pago.idVenta)),0.00) as restante,"
                + "IF((select montopago from pago where V.idVenta=pago.idVenta order by fechaPago desc limit 1)!='',(select montopago from pago where V.idVenta=pago.idVenta order by fechaPago desc limit 1),0.00) as ultimopago,"
                + "C.estadocliente,"
                + "concat(E.nombreEmp,' ',E.apellidoPatEmp,' ',E.apellidoMatEmp)", "venta V", "inner join cliente C inner join ruta_agente RA inner join empleado E inner join ruta R ON C.idCliente=V.idCliente and C.idR_A=RA.idR_A and RA.idEmpleado=E.idEmpleado and R.idruta=RA.idruta " + condicion);
        if (!vectorDatos.isEmpty()) {
            tabla.setDefaultRenderer(Object.class, new celdaRander(13));
            tabla.setRowHeight(25);
            tabla.setModel(new DefaultTableModel(vectorDatos, columnas));
            tabla.setAutoCreateRowSorter(true);
            frmPrincipal.packColumn(tabla, 0, 2);
        }/*else{
        JOptionPane.showMessageDialog(null,"No hay datos");
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnDetalle = new javax.swing.JButton();
        btnIncomp = new javax.swing.JButton();
        btnDias = new javax.swing.JButton();
        btnAge = new javax.swing.JButton();
        btnAge1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnDetalle.setText("VER DETALLES");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        btnIncomp.setText("VER INCOMPLETOS");
        btnIncomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncompActionPerformed(evt);
            }
        });

        btnDias.setText("DÍAS PROXIMOS");
        btnDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiasActionPerformed(evt);
            }
        });

        btnAge.setText("POR AGENTES");
        btnAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgeActionPerformed(evt);
            }
        });

        btnAge1.setText("VER OFICIO");
        btnAge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAge1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAge1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIncomp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalle)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalle)
                    .addComponent(btnIncomp)
                    .addComponent(btnDias)
                    .addComponent(btnAge)
                    .addComponent(btnAge1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgeActionPerformed
        //llenarTabla("order by venta.idEmpleado,fechaVenta desc");
        llenarTabla("");
    }//GEN-LAST:event_btnAgeActionPerformed

    private void btnDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiasActionPerformed
        String array[] = {"LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
        String dato = JOptionPane.showInputDialog(null, "Selecciona", "Días", JOptionPane.INFORMATION_MESSAGE, null, array, array[0]).toString();
        //llenarTabla("where dias like '%"+dato.substring(0,3)+"%'");
        llenarTabla("");

    }//GEN-LAST:event_btnDiasActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        frmPrincipal.agregaPanel(new panelCartera(frmPrincipal.miConex.ConsultaDato("idCliente", "cliente", "where razonSocialCliente='" + tabla.getValueAt(tabla.getSelectedRow(), 1).toString() + "'"), tabla.getValueAt(tabla.getSelectedRow(), 0).toString(), tabla.getValueAt(tabla.getSelectedRow(), 10).toString(),tabla.getValueAt(tabla.getSelectedRow(), 8).toString()), null, new FlowLayout(), null);
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnIncompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncompActionPerformed
        llenarTabla("");
//        llenarTabla("where estadoVenta=false order by idCliente desc");
    }//GEN-LAST:event_btnIncompActionPerformed

    private void btnAge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAge1ActionPerformed
        HashMap param = new HashMap();
//        Vector<String> vec = (Vector<String>)(frmPrincipal.miConex.consDatosParaCampos("concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) as nombreEmpleado", "empleado", ""));
//        String[] array = vec.toArray(new String[vec.size()]);
        Vector vec = (Vector)(frmPrincipal.miConex.consDatosParaCampos("concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp,'(',idEmpleado,')') as nombreEmpleado", "empleado", ""));
        Object[] array = new String[vec.size()];
        array = vec.toArray();
        //vec.toString().split(",");
        //Vector v = new Vector();
//String [] s = v.toArray(new String[v.size()]);

        String dato = JOptionPane.showInputDialog(null, "Selecciona un empleado para ver la cartera:", "Empleado", JOptionPane.INFORMATION_MESSAGE, null, array, array[0]).toString();
        param.put("IdEmp", dato.substring((dato.lastIndexOf("(")+1),dato.length()-2));
        System.out.println(dato.substring((dato.lastIndexOf("(")+1),dato.length()-2));
//        if (!dato.equals(null)) {
//            tabla.setValueAt(dato, tabla.getSelectedRow(), 5);
//            tabla.setValueAt(frmPrincipal.miConex.ConsultaDato("precio" + dato, "producto",
//                    "where idProducto='" + tabla.getValueAt(tabla.getSelectedRow(), 1) + "'"),
//                    tabla.getSelectedRow(), 6);
//            verificaTotal();
//        }
//        param.put("IdEmp",);
        frmPrincipal.agregaPanel(new panelVistaReportes("carteraAgente_C",param), new BorderLayout(), null, null);
    }//GEN-LAST:event_btnAge1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAge;
    private javax.swing.JButton btnAge1;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnDias;
    private javax.swing.JButton btnIncomp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
