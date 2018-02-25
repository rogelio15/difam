package dialog;

import difamserv.frmPrincipal;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jdImpuesto extends javax.swing.JDialog {

    Vector columna = new Vector();

    public jdImpuesto(java.awt.Frame parent, boolean modal, String id, String nom) {
        super(parent, modal);
        initComponents();
        columna.add("ID");
        columna.add("Impuesto");
        columna.add("Porcentaje");
        lblID.setText(id);
        lblN.setText(nom);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idimpuesto,concat(nomimpuesto,'( ',porcentaje,' %)')", "impuesto", "order by nomimpuesto asc"), cboImp);
        llenarTabla();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void llenarTabla() {
        tabImp.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaCampos("idRPI,nomimpuesto,porcentaje", "producto_impuesto", "inner join impuesto using(idimpuesto) where idproducto='" + lblID.getText() + "'"), columna));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabImp = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnE = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblN = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboImp = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabImp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabImp);

        jLabel3.setText("LISTA DE IMPUESTOS QUE TIENE EL PRODUCTO:");

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete16.png"))); // NOI18N
        btnE.setText("ELIMINAR IMP.");
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnA.setText("AGREGAR IMP.");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblID.setText(" ");
        lblID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID de Producto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N

        lblN.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblN.setText(" ");
        lblN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción de Producto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Impuesto:");

        cboImp.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        cboImp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboImp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnA))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA)
                    .addComponent(jLabel1)
                    .addComponent(cboImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        if (!lblID.getText().equals("")) {
            frmPrincipal.miConex.altaRegistro("producto_impuesto", "null,"
                    + "'" + frmPrincipal.obtenID(cboImp) + "',"
                    + "'" + lblID.getText() + "'");

            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Favo de agregar un impuesto al prodcuto!");
        }
    }//GEN-LAST:event_btnAActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        if (tabImp.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.eliminaRegistro("producto_impuesto", "idRPI", tabImp.getModel().getValueAt(tabImp.getSelectedRow(), 0).toString());
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un impuesto!!!");
        }
    }//GEN-LAST:event_btnEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnE;
    private javax.swing.JComboBox cboImp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblN;
    private javax.swing.JTable tabImp;
    // End of variables declaration//GEN-END:variables
}
