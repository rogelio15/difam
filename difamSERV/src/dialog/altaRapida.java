package dialog;

import difamserv.frmPrincipal;
import panel.miCompra;
import panel.panelFamilia;
import pruebas.panelProducto;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class altaRapida extends javax.swing.JDialog {

    String tabla;
    int opc;
    JPanel panel;
    JComboBox combo;

    public altaRapida(java.awt.Frame parent, boolean modal, String tabla, int opc, JComboBox combo, JPanel panel) {
        super(parent, modal);
        initComponents();
        this.tabla = tabla;
        this.opc = opc;
        this.combo = combo;
        this.panel = panel;
        setTitle("Alta rápida de " + tabla);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDato = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        txtDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoActionPerformed(evt);
            }
        });
        txtDato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDatoKeyReleased(evt);
            }
        });

        jButton1.setText("ALTA RAPIDA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDato, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String values = "";
        switch (opc) {
            case 0:
                values = "null,'" + txtDato.getText().toUpperCase() + "','','','','',''";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                miCompra.llenaProv();
                break;
            case 1:
            case 3:
                values = "null,'" + txtDato.getText().toUpperCase() + "'";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                panelProducto.actualizaCombo(combo, true, frmPrincipal.miConex.consDatosParaCampos("*", tabla, ""));
                panelFamilia.actualizaCombo(combo, true, frmPrincipal.miConex.consDatosParaCampos("*", tabla, ""));
                break;
            case 2:
                values = "null,'" + txtDato.getText().toUpperCase() + "'";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                panelProducto.actualizaCombo(combo, true, frmPrincipal.miConex.consDatosParaCampos("*", tabla, ""));
                break;
            case 4:
                values = "null,'" + txtDato.getText().toUpperCase() + "',1";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                panelProducto.actualizaCombo(combo, false, frmPrincipal.miConex.consDatosParaCampos("nombrefam", tabla, ""));
                break;
            case 5:
                values = "null,'" + txtDato.getText().toUpperCase() + "'";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                panelProducto.actualizaCombo(combo, true, frmPrincipal.miConex.consDatosParaCampos("*", tabla, ""));
                break;
            case 6:
                values = "null,'" + txtDato.getText().toUpperCase() + "'";
                frmPrincipal.miConex.altaRegistro(tabla, values);
                panelProducto.actualizaCombo(combo, true, frmPrincipal.miConex.consDatosParaCampos("*", tabla, ""));
                break;
        }
        frmPrincipal.coincideCampo(combo, txtDato.getText().toUpperCase());
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed
    }//GEN-LAST:event_txtDatoActionPerformed

    private void txtDatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_txtDatoKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
