package dialog;

import difamserv.frmPrincipal;
import panel.panelVistaReportes;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cobroEfectivo extends javax.swing.JDialog {

    double montoT = 0.00;
    JTable miTablaV;
    boolean cambioAlta = false;
    String fecha, hora, idVC;
    DefaultTableModel modeloTabla;
    double montoSI = 0.00;
    String idCliente = "";

    public cobroEfectivo(java.awt.Frame parent, boolean modal, JTable miTablaV, double montoT, double montoSI, DefaultTableModel modeloTabla, String idCliente, String desc) {
        super(parent, modal);
        initComponents();
        System.out.println(montoT);
        this.miTablaV = miTablaV;
        this.idCliente = idCliente;
        this.montoT = montoT;
        this.montoSI = montoSI;
        this.modeloTabla = modeloTabla;
        txtMonto.setText(String.format("%10.2f", montoT));
        txtDesc.setText(desc);
        txtDesc.requestFocus();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDesc = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtDesc.setFont(new java.awt.Font("IrisUPC", 1, 40)); // NOI18N
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDesc.setText("0.00");
        txtDesc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento %:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 16), new java.awt.Color(255, 0, 0))); // NOI18N
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });

        txtMonto.setEditable(false);
        txtMonto.setFont(new java.awt.Font("IrisUPC", 1, 40)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.setText("0.00");
        txtMonto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MONTO A COBRAR:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        txtCambio.setEditable(false);
        txtCambio.setFont(new java.awt.Font("IrisUPC", 1, 40)); // NOI18N
        txtCambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCambio.setText("0.00");
        txtCambio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambio $:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 1, 16), new java.awt.Color(255, 0, 0))); // NOI18N

        txtEfectivo.setFont(new java.awt.Font("IrisUPC", 1, 40)); // NOI18N
        txtEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEfectivo.setToolTipText("<html><b>Nota:</b><br> <font color=\"blue\">Primer ENTER dentro del campo EFECTIVO para visualizar el cambio.<BR>Segundo ENTER dentro del campo EFECTIVO para imprimir TICKET</font></html>");
        txtEfectivo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EFECTIVO $:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(255, 0, 0))); // NOI18N
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDesc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void altaVenta() {
        Vector filas = new Vector();
        Vector celdas;
        for (int f = 0; f < miTablaV.getRowCount(); f++) {
            celdas = new Vector();
            celdas.add(miTablaV.getModel().getValueAt(f, 1));
            celdas.add(miTablaV.getModel().getValueAt(f, 2));
            celdas.add(miTablaV.getModel().getValueAt(f, 5));
         
            //aqui es donde se realiza el calculo para saber la ganacia
            celdas.add("5");
            //harcodeado
            //celdas.add("5");
            filas.add(celdas);
          
        }
        while (miTablaV.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        
        //traer equivalencia y dividirla entre lo vendido para obtener el porcentaje de las cajas a descontar
        //
        
        idVC = frmPrincipal.miConex.altaV(frmPrincipal.fechaS,
                frmPrincipal.horaS,
                montoSI,
                Double.parseDouble(txtEfectivo.getText().toString()),
                frmPrincipal.habilitacion.getEmpleado().toString(),
                "0", idCliente, "M", "E", true,
                txtDesc.getText(),
                filas);
    }

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtEfectivo.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void txtEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyReleased

    }//GEN-LAST:event_txtEfectivoKeyReleased

    private void txtEfectivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (cambioAlta) {
                altaVenta();
                HashMap parametro = new HashMap();
                parametro.put("noVenta", idVC.toString());

                Iterator it = parametro.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry e = (Map.Entry) it.next();
//                    System.out.println("DAtos Map:");
//                    System.out.println(e.getKey() + " " + e.getValue());
//                    System.out.println("");
                }
//                if(txtDesc.getText().equals("0")){
//                    new impresionDirecta(null, true, "ticket", parametro);
//                }else{
//                    new impresionDirecta(null, true, "ticket_D", parametro);
                frmPrincipal.agregaPanel(new panelVistaReportes("ticket_D_8_1", parametro), new BorderLayout(), null, null);
//                }
                dispose();
            } else {
                if (txtEfectivo.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "INGRESA EL PAGO!");
                } else {
                    if (Double.parseDouble(txtEfectivo.getText().toString()) >= Double.parseDouble(txtMonto.getText().toString())) {
                        double cambio = Double.parseDouble(txtEfectivo.getText().toString()) - Double.parseDouble(txtMonto.getText().toString());
                        txtCambio.setText(String.format("%10.2f", cambio));
                        cambioAlta = true;
                        txtDesc.setEnabled(false);
                        txtEfectivo.setEditable(false);
                        txtEfectivo.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡EL MONTO PAGADO ES INSUFICIENTE!");
                        txtEfectivo.setText("");
                        txtEfectivo.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_txtEfectivoKeyPressed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtMonto.setText(String.format("%10.2f", (Double.parseDouble(txtMonto.getText())) * (1 - Double.parseDouble(txtDesc.getText()) / 100)));
//            ("$ " + String.format("%10.2f", valorTotal*((Double.parseDouble(lblDesc.getText().substring(0, lblDesc.getText().indexOf("%")).trim())/100))));
            txtEfectivo.requestFocus();
        }
    }//GEN-LAST:event_txtDescKeyPressed

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescKeyReleased

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescKeyTyped

    public static void main(String args[]) {
//        new cobroEfectivo(null, true, null, 113.10,19.50, null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
