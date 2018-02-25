package dialog;

import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.*;

public class jdAltaPromo extends javax.swing.JDialog {

    public jdAltaPromo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtFVal.setText(frmPrincipal.lblFecha.getText());
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idProducto,nombreProd", "producto", ""), cboProd);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cboProd = new javax.swing.JComboBox();
        txtDet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        txtFHas = new javax.swing.JFormattedTextField();
        txtFVal = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        jButton1.setText("ALTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboProd.setEditable(true);
        cboProd.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        cboProd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDet.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtDet.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        jLabel3.setText("Descripción producto:");

        txtCant.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad por Promo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 11))); // NOI18N
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantKeyReleased(evt);
            }
        });

        txtFHas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 11))); // NOI18N
        try {
            txtFHas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFHas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFHas.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N

        txtFVal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Válido de:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 11))); // NOI18N
        try {
            txtFVal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFVal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFVal.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtFVal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFValKeyReleased(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio como:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 11))); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 173, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(txtDet, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFVal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFHas, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(cboProd, 0, 250, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCant, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFHas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Está de acuerdo que los datos son correctos?") == JOptionPane.YES_OPTION) {
            boolean band = frmPrincipal.miConex.altaRegistro("promocion", "null,'"
                    + frmPrincipal.parseFecha(txtFVal.getText()) + "','"
                    + frmPrincipal.parseFecha(txtFHas.getText()) + "','"
                    + frmPrincipal.obtenID(cboProd) + "','"
                    + txtPrecio.getText() + "','"
                    + txtCant.getText() + "','"
                    + txtDet.getText() + "'");
            if(band){
                dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFValKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFValKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFHas.requestFocus();
        }
    }//GEN-LAST:event_txtFValKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCant.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDet.requestFocus();
        }
    }//GEN-LAST:event_txtCantKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtDet;
    private javax.swing.JFormattedTextField txtFHas;
    private javax.swing.JFormattedTextField txtFVal;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
