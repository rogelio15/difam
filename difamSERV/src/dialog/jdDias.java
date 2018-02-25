package dialog;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class jdDias extends javax.swing.JDialog {

    JTextField txtDias;

    public jdDias(java.awt.Frame parent, boolean modal, JTextField txtDias) {
        super(parent, modal);
        initComponents();
        this.txtDias = txtDias;
        setTitle("Dias");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chkLunes = new javax.swing.JCheckBox();
        chkViernes = new javax.swing.JCheckBox();
        chkDomingo = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        chkMiercoles = new javax.swing.JCheckBox();
        chkMartes = new javax.swing.JCheckBox();
        chkJueves = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Elije los dias"));

        chkLunes.setText("Lunes");

        chkViernes.setText("Viernes");

        chkDomingo.setText("Domingo");

        chkSabado.setText("Sabado");

        chkMiercoles.setText("Miercoles");

        chkMartes.setText("Martes");

        chkJueves.setText("Jueves");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(chkLunes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkMartes))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(chkViernes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkSabado)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkDomingo)
                    .addComponent(chkMiercoles))
                .addGap(8, 8, 8)
                .addComponent(chkJueves))
            .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLunes)
                    .addComponent(chkJueves)
                    .addComponent(chkMartes)
                    .addComponent(chkMiercoles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkViernes)
                    .addComponent(chkSabado)
                    .addComponent(chkDomingo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checaCheck(JCheckBox chk) {
        if (chk.isSelected()) {
            if (txtDias.getText().equals("")) {
                txtDias.setText(chk.getText().substring(0, 3).toUpperCase());
            } else {
                txtDias.setText(txtDias.getText() + "," + chk.getText().substring(0, 3).toUpperCase());
            }
        }
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        checaCheck(chkLunes);
        checaCheck(chkMartes);
        checaCheck(chkMiercoles);
        checaCheck(chkJueves);
        checaCheck(chkViernes);
        checaCheck(chkSabado);
        checaCheck(chkDomingo);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JCheckBox chkDomingo;
    private javax.swing.JCheckBox chkJueves;
    private javax.swing.JCheckBox chkLunes;
    private javax.swing.JCheckBox chkMartes;
    private javax.swing.JCheckBox chkMiercoles;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkViernes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
