package pruebas;

import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class miVenta extends javax.swing.JPanel {

    private double montoT = 0.00;
    private DefaultTableModel modeloTabla;
    DecimalFormat formatoDecimal = new DecimalFormat("###,###,###.##");
    
    public miVenta() {
        initComponents();

        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
//        frmPrincipal.inventario=false;
        modeloTabla.addColumn("No.");
        modeloTabla.addColumn("ID Producto");
        modeloTabla.addColumn("Nombre del Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Venta");

        miTablaV.setModel(modeloTabla);
        miTablaV.getColumnModel().getColumn(0).setPreferredWidth(40);
        miTablaV.getColumnModel().getColumn(1).setPreferredWidth(130);
        miTablaV.getColumnModel().getColumn(2).setPreferredWidth(500);
        miTablaV.getColumnModel().getColumn(3).setPreferredWidth(80);
        miTablaV.getColumnModel().getColumn(4).setPreferredWidth(100);

        setVisible(true);
    }

    public void enfoca() {
        txtIDP.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtProv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIDP = new javax.swing.JTextField();
        txtIDP1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIDP2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIDP3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTablaV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtCobrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCamCant = new javax.swing.JButton();

        setFont(new java.awt.Font("Tahoma", 0, 20));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arroz.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("CODE ó ID Producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Código DIFAM");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtNombre.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Descripción del producto:");

        txtProv.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtProv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtProv.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Categoría:");

        txtPU.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtPU.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPU.setOpaque(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><b>Nota:</b><br>\n<font color=\"blue\">Utilize el lector de código de barras para agregar el producto a la venta</font></html>");

        txtIDP.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtIDP.setOpaque(false);
        txtIDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDPKeyReleased(evt);
            }
        });

        txtIDP1.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtIDP1.setOpaque(false);
        txtIDP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDP1KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Marca:");

        txtIDP2.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtIDP2.setOpaque(false);
        txtIDP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDP2KeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setText("Unidad de Medida:");

        txtIDP3.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtIDP3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIDP3.setText("$0.00");
        txtIDP3.setOpaque(false);
        txtIDP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDP3KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Precio de Venta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(txtIDP, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(txtProv, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtPU, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(txtIDP1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(txtIDP2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(txtIDP3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Productos de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        miTablaV.setFont(new java.awt.Font("Tahoma", 0, 15));
        miTablaV.setForeground(new java.awt.Color(0, 0, 102));
        miTablaV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(miTablaV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 30));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("$0.00");
        jPanel3.add(lblTotal, java.awt.BorderLayout.PAGE_END);

        txtCobrar.setFont(new java.awt.Font("Tahoma", 0, 15));
        txtCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimeti.gif"))); // NOI18N
        txtCobrar.setText("COBRAR");
        txtCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCobrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15));
        btnEliminar.setText("Quita de la Lista");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCamCant.setFont(new java.awt.Font("Tahoma", 0, 15));
        btnCamCant.setText("Cambiar CANT.");
        btnCamCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamCantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCamCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCobrar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCobrar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnCamCant))
                                .addContainerGap())))))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void verificaTotal() {
        Double valorTotal = 0.00;
        for (int i = 0; i < miTablaV.getRowCount(); i++) {
            valorTotal += Double.parseDouble(miTablaV.getModel().getValueAt(i, 3).toString()) * Double.parseDouble(miTablaV.getModel().getValueAt(i, 4).toString());
        }
        lblTotal.setText("$ " + String.format("%10.2f", valorTotal));
        montoT = valorTotal;
    }

    public void checaExistencia(String idP, String nomP, String preV) {
        boolean band = true;
        int valor = 0;
        String idProd = "";
        for (int i = 0; i < miTablaV.getRowCount(); i++) {
            idProd = miTablaV.getModel().getValueAt(i, 1).toString();
            if (idProd.equals(txtIDP.getText())) {
                valor = Integer.parseInt(miTablaV.getModel().getValueAt(i, 3).toString()) + frmPrincipal.cantidadProd;
                miTablaV.getModel().setValueAt(((Integer) valor).toString(), i, 3);
                band = false;                
                break;
            }
        }
        if (band) {
            modeloTabla.addRow(new String[5]);
            miTablaV.getModel().setValueAt(miTablaV.getRowCount(), miTablaV.getRowCount() - 1, 0);
            miTablaV.getModel().setValueAt(idP, miTablaV.getRowCount() - 1, 1);
            miTablaV.getModel().setValueAt(nomP, miTablaV.getRowCount() - 1, 2);
            miTablaV.getModel().setValueAt(frmPrincipal.cantidadProd, miTablaV.getRowCount() - 1, 3);
            miTablaV.getModel().setValueAt(String.format("%10.2f", Double.parseDouble(preV)), miTablaV.getRowCount() - 1, 4);
        }
        frmPrincipal.cantidadProd=1;
    }

    public void llenarCuadros() {
//        HashMap busqueda = (HashMap) (frmPrincipal.consultas.miProducto(txtIDP.getText().toUpperCase()));
//        if (!busqueda.isEmpty()) {
//            txtPU.setText(busqueda.get("precioV").toString());
//            txtNombre.setText(busqueda.get("nombreProd").toString());
//            txtProv.setText(busqueda.get("nombreProv").toString());
//            checaExistencia(txtIDP.getText().toString(), txtNombre.getText().toString(), txtPU.getText().toString());
//            verificaTotal();
//            txtIDP.setText("");
//        }
    }

    private void txtCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCobrarActionPerformed
        if (miTablaV.getRowCount() > 0) {
            int SoN = JOptionPane.showConfirmDialog(this, "¿Está segura de haber registrado todos\n"
                    + "los productos?", "¡Atención Vendedor!", JOptionPane.YES_NO_OPTION);
            if (SoN == JOptionPane.YES_OPTION) {
//                new cobroEfectivo(null, true, miTablaV, montoT,montoT, modeloTabla);
                montoT = 0;
                lblTotal.setText("$ " + String.format("%10.2f", montoT));
                txtNombre.setText("");
                txtPU.setText("");
                txtProv.setText("");
                txtIDP.setText("");
                txtIDP.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Aun no hay productos en la lista\n"
                    + "para Vender", "Atencion Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        txtIDP.requestFocus();
    }//GEN-LAST:event_txtCobrarActionPerformed

    private void txtIDPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            boolean existe = frmPrincipal.consultas.existenciaPrevia(txtIDP.getText().toString());
//            if (existe) {
//                llenarCuadros();
//            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            txtCobrarActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
//            new CantidadProd(null,true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
//            new vizProd(null, true, txtIDP);
        }
    }//GEN-LAST:event_txtIDPKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (miTablaV.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                modeloTabla.removeRow(miTablaV.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una PRODUCTO!!!");
        }
        verificaTotal();
        txtIDP.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCamCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamCantActionPerformed
        miTablaV.setEnabled(true);
        if (miTablaV.getSelectedRow() >= 0) {
            String cantidadP = JOptionPane.showInputDialog(null, "Cantidad").toString();
            System.out.println(cantidadP);
            if (cantidadP != null) {
                if (!(cantidadP.equals(""))) {
                    double cP = Double.parseDouble(cantidadP);
                    miTablaV.getModel().setValueAt(cP, miTablaV.getSelectedRow(), 3);
                    verificaTotal();
                    txtIDP.requestFocus();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una PRODUCTO!!!");
        }
}//GEN-LAST:event_btnCamCantActionPerformed

    private void txtIDP1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDP1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDP1KeyReleased

    private void txtIDP2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDP2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDP2KeyReleased

    private void txtIDP3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDP3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDP3KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamCant;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable miTablaV;
    private javax.swing.JButton txtCobrar;
    public javax.swing.JTextField txtIDP;
    public javax.swing.JTextField txtIDP1;
    public javax.swing.JTextField txtIDP2;
    public javax.swing.JTextField txtIDP3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPU;
    private javax.swing.JTextField txtProv;
    // End of variables declaration//GEN-END:variables
}
