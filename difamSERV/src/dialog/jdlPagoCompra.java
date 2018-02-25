package dialog;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class jdlPagoCompra extends javax.swing.JDialog {

    String compra = "";
    String nomproveedor = "";
    double mt=0.00;

    public jdlPagoCompra(java.awt.Frame parent, boolean modal, String compra, String nomproveedor, double mt) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.compra = compra;
        this.nomproveedor = nomproveedor;
        //this.mt = mt-Double.parseDouble(frmPrincipal.miConex.ConsultaDato("if((select sum(montopagoC) from compra inner join pagocompra using(idcompra) where idCompra=compra.idCompra) IS NULL,0.00,(select sum(montopagoC) from compra inner join pagocompra using(idcompra) where idCompra=compra.idCompra))",
        this.mt = mt-Double.parseDouble(frmPrincipal.miConex.ConsultaDato("if(sum(montoPagoC) IS NULL,0.00,sum(montoPagoC))",
                "pagocompra",
                "where idCompra='"+compra+"'"));
        txtMP.requestFocus();
        lblPagoC.setText(frmPrincipal.miConex.ConsultaDato("if(max(idPagoC) is null,1,(max(idPagoC)+1))", "pagocompra", ""));
        lblNomProv.setText(nomproveedor);
        lblID.setText(compra);
        lblFC.setText(frmPrincipal.miConex.ConsultaDato("fechaCompra", "compra", "where idCompra='" + compra + "'"));
        txtRes.setText("" + String.format("%10.2f", (this.mt - Double.parseDouble(txtMP.getText().toString()))));
        llenarTabla();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblPagoC = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblFC = new javax.swing.JLabel();
        lblNomProv = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMP = new javax.swing.JTextField();
        btnElimina = new javax.swing.JButton();
        btnAlta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtRes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        lblPagoC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagoC.setText(" ");
        lblPagoC.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Pago:"));

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText(" ");
        lblID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Compra:"));

        lblFC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFC.setText(" ");
        lblFC.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Compra:"));

        lblNomProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomProv.setText(" ");
        lblNomProv.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre Proveedor:"));

        jLabel5.setText("Monto pago: ");

        txtMP.setText("0");
        txtMP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMPKeyReleased(evt);
            }
        });

        btnElimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        btnAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        jLabel6.setText("Resta:");

        txtRes.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMP, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlta))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPagoC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomProv, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFC, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagoC)
                    .addComponent(lblNomProv)
                    .addComponent(lblFC)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlta)
                    .addComponent(btnElimina)
                    .addComponent(jLabel6)
                    .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        frmPrincipal.miConex.altaRegistro("pagocompra", lblPagoC.getText() + ",'"
                + txtMP.getText() + "','"
                + frmPrincipal.fechaS + "',"
                + lblID.getText());
//        mt-=Double.parseDouble(txtMP.getText());
        llenarTabla();
//        new jdlPagoCompra(null,true,compra,nomproveedor,mt);
        dispose();
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        frmPrincipal.miConex.eliminaRegistro("pagocompra", "idPagoC", tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
//        mt+=Double.parseDouble(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        llenarTabla();
//        new jdlPagoCompra(null,true,compra,nomproveedor,mt);
        dispose();
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void txtMPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMPKeyReleased
        txtRes.setText("" +  String.format("%10.2f", (mt - Double.parseDouble(txtMP.getText()))));
    }//GEN-LAST:event_txtMPKeyReleased

    public void llenarTabla() {
        Vector columnas = new Vector();
        columnas.add("ID PAGO");
        columnas.add("MONTO PAGO");
        columnas.add("FECHA PAGO");
        tabla.setModel(new DefaultTableModel(null, columnas));
        Vector datos = frmPrincipal.miConex.consDatosParaTablas("idPagoC,"
                + "montoPagoC,"
                + "fechaPagoC",
                "pagocompra",
                "where idCompra='" + compra + "'");
        if (!datos.isEmpty()) {
            tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
            tabla.setRowHeight(20);
            tabla.setModel(new DefaultTableModel(datos, columnas));
            frmPrincipal.packColumn(tabla, -1, 2);
        }
        if(Double.parseDouble(txtRes.getText())<=0){
            btnAlta.setEnabled(false);
        }else{
            btnAlta.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnElimina;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFC;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNomProv;
    private javax.swing.JLabel lblPagoC;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtMP;
    private javax.swing.JTextField txtRes;
    // End of variables declaration//GEN-END:variables
}
