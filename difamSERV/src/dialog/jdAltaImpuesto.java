package dialog;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jdAltaImpuesto extends javax.swing.JDialog {

    JComboBox combo;

    public jdAltaImpuesto(java.awt.Frame parent, boolean modal, JComboBox combo) {
        super(parent, modal);
        initComponents();
        setTitle("Mis Impuestos");
        llenarTabla();
        this.combo = combo;
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboDeptos1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAlta = new javax.swing.JButton();
        txtPorcentaje = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnAlta1 = new javax.swing.JButton();

        cboDeptos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("RUTA:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alta Impuestos"));

        jLabel6.setText("Porcentaje:");

        txtImpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImpuestoKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre Imp.:");

        btnAlta.setText("Alta Imp.");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "IMPUESTO", "PORCENTAJE"
            }
        ));
        jScrollPane1.setViewportView(tabDatos);

        jLabel5.setText("Lista de Impuestos:");

        btnAlta1.setText("Eliminar");
        btnAlta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(btnAlta1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnAlta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        if (!txtImpuesto.getText().equals("") && !txtPorcentaje.getText().equals("")) {
            double equivalente = calcularEquivalente(txtPorcentaje.getText().trim());
            boolean a = frmPrincipal.miConex.altaRegistro("impuesto", "null,'" + txtImpuesto.getText().toUpperCase() + "','" + txtPorcentaje.getText().toUpperCase() + "','" + equivalente + "'");
            System.out.println(a);
            if (a) {
                txtImpuesto.setText("");
                txtPorcentaje.setText("");
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos!");
        }
    }//GEN-LAST:event_btnAltaActionPerformed

    private double calcularEquivalente(String impuesto) {
        if (impuesto.length() > 1) {
            String cadena = "1.";
            String res = cadena.concat(impuesto);
            return Double.parseDouble(res);
        } else {
            String cadena = "1.0";
            String res = cadena.concat(impuesto);
            return Double.parseDouble(res);
        }
    }

    private void txtImpuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImpuestoKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtImpuestoKeyReleased

    private void txtPorcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyReleased

    }//GEN-LAST:event_txtPorcentajeKeyReleased

    private void btnAlta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlta1ActionPerformed
        if (tabDatos.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?, puede haber productos con éste impuesto aplicado.", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.eliminaRegistro("impuesto", "idImpuesto", tabDatos.getModel().getValueAt(tabDatos.getSelectedRow(), 0).toString());
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una CATEGORIA!!!");
        }
    }//GEN-LAST:event_btnAlta1ActionPerformed

    public void llenarTabla() {
        Vector columna = new Vector();
        columna.add("ID");
        columna.add("Impuesto");
        columna.add("Porcentaje");
        tabDatos.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabDatos.setRowHeight(25);
        tabDatos.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idImpuesto,nomImpuesto,porcentaje", "impuesto", ""), columna));
        tabDatos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabDatos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabDatos.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnAlta1;
    private javax.swing.JComboBox cboDeptos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDatos;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}