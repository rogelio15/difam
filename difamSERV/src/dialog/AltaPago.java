package dialog;

import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JOptionPane;

public class AltaPago extends javax.swing.JDialog {
    String quienPaga=null;
    public AltaPago(java.awt.Frame parent, boolean modal, Vector datos) {
        super(parent, modal);
        initComponents();
        setTitle(".: Alta Pago :.");
        txtNV.setText(datos.get(0).toString());
        txtMontoC.setText(datos.get(1).toString());
        txtFV.setText(datos.get(2).toString());
        txtFP.setText(datos.get(3).toString());
        txtDR.setText(datos.get(4).toString());
        //txtPago.setText(datos.get(5).toString());
        txtSTotal.setText(datos.get(6).toString());
        txtMRest.setText(datos.get(7).toString());
        quienPaga = datos.get(8).toString();
        System.out.println("PAGA: "+quienPaga);
        txtPago.requestFocus();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtSTotal = new javax.swing.JTextField();
        txtMRest = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        txtNV = new javax.swing.JTextField();
        txtMontoC = new javax.swing.JTextField();
        txtFV = new javax.swing.JFormattedTextField();
        txtDR = new javax.swing.JTextField();
        txtFP = new javax.swing.JFormattedTextField();
        btnAltaP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtSTotal.setEditable(false);
        txtSTotal.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtSTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSTotal.setText("0");
        txtSTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Pagado:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtMRest.setEditable(false);
        txtMRest.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtMRest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMRest.setText("0");
        txtMRest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto Rest.:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("150");
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No. Pago:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtPago.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto de Pago:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPagoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        txtNV.setEditable(false);
        txtNV.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNV.setText("0");
        txtNV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "No. Venta:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtMontoC.setEditable(false);
        txtMontoC.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtMontoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoC.setText("0");
        txtMontoC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto Credito:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtFV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Venta:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        txtFV.setEditable(false);
        txtFV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtFV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFV.setText("00/00/0000");
        txtFV.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtDR.setEditable(false);
        txtDR.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtDR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDR.setText("0");
        txtDR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias Restantes:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtFP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha Pago:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        txtFP.setEditable(false);
        txtFP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        txtFP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFP.setText("00/00/0000");
        txtFP.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        btnAltaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        btnAltaP.setText("ACEPTAR");
        btnAltaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMRest, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFV, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFP)
                            .addComponent(txtNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDR)
                            .addComponent(txtMontoC, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAltaP))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDR, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnAltaP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaPActionPerformed
        if (Double.parseDouble(txtMRest.getText()) >= 0) {
            if (txtMRest.getText().equals("0.0")) {
                JOptionPane.showMessageDialog(null, "El cliente ha cubierto por completo el monto de remision!");
                frmPrincipal.miConex.actualizaRegistro("venta", "estadoVenta=true,fechaCierre=sysdate()", "idVenta='" + txtNV.getText() + "'");
            }
            frmPrincipal.miConex.altaRegistro("pago", "null," + txtPago.getText() + ",'" + frmPrincipal.parseFecha(txtFP.getText()) + "','"+quienPaga+"','" + txtNV.getText() + "'");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Estás ingresando un pago que excede al monto restante");
        }
    }//GEN-LAST:event_btnAltaPActionPerformed

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        double total = Double.parseDouble(txtMontoC.getText()) - (Double.parseDouble(txtSTotal.getText()) + Double.parseDouble(txtPago.getText()));
        txtMRest.setText("" + total);
    }//GEN-LAST:event_txtPagoKeyReleased

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPago.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyPressed
    }//GEN-LAST:event_txtPagoKeyPressed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    public static void main(String x[]) {
        Vector vector = new Vector();
        vector.add("23");
        vector.add("1514.00");
        vector.add("02/05/2014");
        vector.add("05/05/2014");
        vector.add("7");
        vector.add("0.00");
        vector.add("1514.00");
        vector.add("0.00");
        new AltaPago(null, true, vector);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtDR;
    private javax.swing.JFormattedTextField txtFP;
    private javax.swing.JFormattedTextField txtFV;
    private javax.swing.JTextField txtMRest;
    private javax.swing.JTextField txtMontoC;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtSTotal;
    // End of variables declaration//GEN-END:variables
}
