package dialog;

import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class jdaltaUsuarios extends javax.swing.JDialog {
    
    public jdaltaUsuarios(java.awt.Frame parent, boolean modal, String idE) {
        super(parent, modal);
        initComponents();
        setTitle(".: Recuperación de Contraseñas :.");
        setLocationRelativeTo(null);
        setResizable(false);
        txtidEmpleado.setText(idE);
        txtidEmpleado.setEnabled(false);
        txtUsua.requestFocus(true);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*","ubicacion",""), cboU);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnA = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        jspContra = new javax.swing.JPasswordField();
        jspRepetir = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboU = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/red.gif"))); // NOI18N
        jLabel1.setOpaque(true);

        jLabel2.setText("No. de Emp: ");

        txtidEmpleado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtidEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidEmpleadoKeyPressed(evt);
            }
        });

        jLabel3.setText("Usuario:");

        txtUsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuaActionPerformed(evt);
            }
        });
        txtUsua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuaKeyPressed(evt);
            }
        });

        jLabel4.setText("Contraseña: ");

        jLabel5.setText("Confirmar Contraseña: ");

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        btnA.setText("AGREGAR");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        btnL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnL.setText("LIMPIAR");

        jspContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jspContraKeyPressed(evt);
            }
        });

        jspRepetir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jspRepetirKeyPressed(evt);
            }
        });

        jLabel6.setText("Tipo:");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGENTE", "ADMINISTRADOR", "CAJERO" }));

        jLabel7.setText("Ubicación:");

        cboU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGENTE", "ADMINISTRADOR", "CAJERO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnL))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTipo, 0, 172, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsua, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspContra, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboU, 0, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jspContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jspRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnA)
                            .addComponent(btnL)))
                    .addComponent(jLabel1, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        if (txtUsua.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta agregar la matricula", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }else if (jspContra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta agregar la contraseña", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }else if (jspRepetir.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta agregar la contraseña", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        }else if(!jspContra.getText().equals(jspRepetir.getText())){
            JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN!", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            frmPrincipal.miConex.insertaUsuario(txtUsua.getText(), jspContra.getText(),cboTipo.getSelectedItem().toString().charAt(1), txtidEmpleado.getText().toUpperCase());
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Usuario agregado!!!",
                    "Mensaje del sistema",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_btnAActionPerformed

    private void txtidEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidEmpleadoKeyPressed
    }//GEN-LAST:event_txtidEmpleadoKeyPressed

    private void txtUsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuaActionPerformed
    }//GEN-LAST:event_txtUsuaActionPerformed

    private void txtUsuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jspContra.requestFocus();
        }
    }//GEN-LAST:event_txtUsuaKeyPressed

    private void jspContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jspContraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jspRepetir.requestFocus();
        }
    }//GEN-LAST:event_jspContraKeyPressed

    private void jspRepetirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jspRepetirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnA.requestFocus();
        }
    }//GEN-LAST:event_jspRepetirKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnL;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JComboBox cboU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jspContra;
    private javax.swing.JPasswordField jspRepetir;
    private javax.swing.JTextField txtUsua;
    private javax.swing.JTextField txtidEmpleado;
    // End of variables declaration//GEN-END:variables
}
