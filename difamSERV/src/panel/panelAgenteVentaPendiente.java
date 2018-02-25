package panel;


import difamserv.celdaRander;
import difamserv.frmPrincipal;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import mis_operaciones.operaTablas;

public class panelAgenteVentaPendiente extends javax.swing.JPanel {

    private String ruta;
//    private recibeMiRuta y = new recibeMiRuta();
    String rutaImg = "";
    Vector columnas = new Vector();
    private boolean AoC = false;

    public panelAgenteVentaPendiente() {
        initComponents();
        columnas.add("No. Venta");
        columnas.add("Cliente");
        columnas.add("Ruta");
        columnas.add("Monto a Pagar");
        columnas.add("Cubierto");
        columnas.add("Restante");
        llenaCombo("");
        llenarTabla();
//        ControlBotones(false, true);
        setVisible(true);
    }
    
    public void llenaCombo(String cond){
        Vector datos = frmPrincipal.miConex.consDatosParaCampos("idEmpleado,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp)", "empleado", cond);
        frmPrincipal.llenarCombo_ID(datos, cboAgentes);
    }

    public void cambiaImagen() {
        //Icon icon = new ImageIcon(img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
//        lblFoto.setIcon(new ImageIcon(y.getRutaImagen()));
    }

    public void validaEnter(KeyEvent evt, JTextField campo) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campo.requestFocus();
        }
    }

    public void llenarTabla() {
        tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabla.setRowHeight(25);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("V.idVenta,C.razonSocialCliente, R.descRuta,(V.montoTotalV-(select sum(P.montoPago) from pago P where V.idVenta = P.idVenta and estadoPago=0 group by V.idVenta)) as resta,  (IF((select sum(montopago) from pago P where P.idventa=V.idVenta and estadopago=1) IS NULL,0.00,(select sum(montopago) from pago P where P.idventa=V.idVenta and estadopago=1))) as cubierto,0", "venta", 
                                             "V  inner join cliente C ON C.idCliente=V.idCliente   inner join ruta_agente RA ON C.idR_A=RA.idR_A  inner join Ruta R ON RA.idRuta=R.idRuta  inner join empleado E ON E.idEmpleado=RA.idEmpleado   where  estadoVenta='0'  and estadoCobro='0'  and (DATEDIFF(curdate(),ADDDATE(V.fechaVenta,C.limitediascred)))>60    AND E.idEmpleado='"+frmPrincipal.obtenID(cboAgentes)+"'"), columnas));
        operaTablas.sumaCampos(tabla, 3, 4, 5);
        frmPrincipal.packColumn(tabla, 0, 2);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cboAgentes = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel8.setText("Agente:");

        cboAgentes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboAgentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgentesActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Vista Previa:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setText("PDF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAgentes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboAgentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

//    public void vaciaCuadros() {
//        txtD.setText("");
//        txtNombre.setText("");
//        txtAP.setText("");
//        txtAM.setText("");
//        txtT.setText("");
//        txtFN.setText("");
//        txtEmail.setText("");
//        txtMPerm.setText("");
//    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
//        btnHistorial.setEnabled(true);
//        Vector datos = frmPrincipal.miConex.consDatosParaCampos("nombreEmp,apellidoPatEmp,apellidoMatEmp,fechaNacC,montoVentaPerm", "empleado", "where idEmpleado='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString() + "'");
//        datos = (Vector) datos.get(0);
        
//        txtNombre.setText(datos.get(0).toString());
//        txtAP.setText(datos.get(1).toString());
//        txtAM.setText(datos.get(2).toString());
//        String fena = datos.get(3).toString();
//        txtFN.setText(fena.substring(8) + "/" + fena.substring(5, 7) + "/" + fena.substring(0, 4));
//        txtD.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString());
//        txtT.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());
//        txtEmail.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
//        txtMPerm.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void cboAgentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgentesActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cboAgentesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgentes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
