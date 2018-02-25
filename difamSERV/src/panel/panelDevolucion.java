package panel;

import dialog.vizProd;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelDevolucion extends javax.swing.JPanel {

    DefaultTableModel modeloTabla;
    private double montoT = 0.00;
    public static String ticket = "";
    public static ArrayList cambios = new ArrayList();
    public boolean oficiogenerado = false;
            
    public panelDevolucion(String ticket) {
        initComponents();
        //frmPrincipal.inventario=false;
        this.ticket = ticket;
        
        Vector datosCli = frmPrincipal.miConex.consDatosParaCampos("nombreCli,descRuta,poblacionCli,concat(nombreemp,' ',apellidopatemp,' ',apellidopatemp),limiteDiasCred,limiteMontoCred,razonSocialCliente,concat(dcalleCli,', INT. ',dnoInt,', COL. ',coloniaCli,', ',estadoCli,', C.P. ',cP) as direccion,limiteDiasCred", "cliente", "inner join ruta_agente using(idR_A) inner join ruta using(idruta) inner join empleado using(idEmpleado) inner join venta using(idCliente) where idVenta='" + ticket + "'");
        datosCli = (Vector) datosCli.get(0);
        lblCliente.setText("CLIENTE: " + datosCli.get(0).toString());
        lblAgente.setText("AGENTE: " + datosCli.get(3).toString());
        
        llenarTabla();
//        lblVenta.setText(lblVenta.getText() + " " + ticket);
        lblIva.setText("" + ((Double.parseDouble(lblMontoTotalV.getText().toString()) * 0.16)));
////        double td = (Double.parseDouble(lblMontoTotalV.getText().toString()) - ((Double.parseDouble(lblDescuento.getText().toString()) / 100) * Double.parseDouble(lblMontoTotalV.getText().toString())));
//        lblTotalDesc.setText(String.format("%10.2f", td));
        verificaTotal();
//        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTablaProd = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblVenta = new javax.swing.JLabel();
        panelVR = new javax.swing.JPanel();
        btnOficio = new javax.swing.JButton();
        lblMontoTotalV = new javax.swing.JLabel();
        lblDiferencia = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        btnAgrega = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        btnCant = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        lblMontoCDesc = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblAgente = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel6.setText("<html><body>(1) Seleccione el producto a cambiar dentro de la tabla.<br>\n(2) Agregue, elimine o cambie la cantidad el producto deseado.<br>\n(3) Visualiza DIFERENCIA de montos. Si la diferencia es positiva, el cliente ENTREGARÁ dicho monto, de lo contrario, se le dará al cliente el monto que se indica en color rojo.<br>\n(4) Selecciona Imprimir el ticket, para actualizar el monto de la Venta para los cortes de Caja. NOTA. es muy importante realizar el ultimo paso.<br>\n(5) IMPORTANTE: Los cambios se realizan en tiempo real, no hay retroceso en los cambios.\n</body></html>");
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        miTablaProd.setModel(new javax.swing.table.DefaultTableModel(
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
        miTablaProd.setCellSelectionEnabled(true);
        miTablaProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miTablaProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(miTablaProd);

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("MontoTotal + IVA::"));

        lblVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVenta.setText("No Venta: ");

        panelVR.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualiza Estudio"));
        panelVR.setLayout(new java.awt.BorderLayout());

        btnOficio.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnOficio.setText("VER NUEVO OFICIO");
        btnOficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficioActionPerformed(evt);
            }
        });

        lblMontoTotalV.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblMontoTotalV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoTotalV.setText("0.00");
        lblMontoTotalV.setBorder(javax.swing.BorderFactory.createTitledBorder("MontoTotal Previo"));

        lblDiferencia.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDiferencia.setForeground(new java.awt.Color(204, 51, 0));
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiferencia.setText("0.00");
        lblDiferencia.setBorder(javax.swing.BorderFactory.createTitledBorder("Diferencia de Montos:"));

        lblIva.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIva.setText("0.00");
        lblIva.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA"));

        btnAgrega.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnAgrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/aceptar.png"))); // NOI18N
        btnAgrega.setText("Añadir");
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });

        btnElimina.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnElimina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/declinar.png"))); // NOI18N
        btnElimina.setText("Quitar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        btnCant.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnCant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return16.png"))); // NOI18N
        btnCant.setText("Cambiar Cantidad");
        btnCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        lblDesc.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDesc.setText("0.00");
        lblDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("% Desc:"));

        lblMontoCDesc.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblMontoCDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoCDesc.setText("0.00");
        lblMontoCDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto Descuento:"));

        lblCliente.setText("Cliente");

        lblAgente.setText("Agente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMontoTotalV, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMontoCDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOficio))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelVR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(lblDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblVenta)
                                .addComponent(btnAgrega))
                            .addComponent(btnElimina)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCant)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnOficio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(lblAgente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                    .addComponent(panelVR, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotalV)
                    .addComponent(lblDiferencia)
                    .addComponent(lblIva)
                    .addComponent(lblDesc)
                    .addComponent(lblMontoCDesc)
                    .addComponent(lblTotal))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void llenarTabla() {
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloTabla.addColumn("ID Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Nombre del Producto");
        modeloTabla.addColumn("Unidad Medida");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Importe");

        miTablaProd.setModel(modeloTabla);

        ArrayList misDatos = frmPrincipal.consultas.miVenta(ticket);
        double cantV = 0.00, punit = 0.00;
        if (!misDatos.isEmpty()) {
            miTablaProd.setDefaultRenderer(Object.class, new celdaRander(-1));
            miTablaProd.setRowHeight(20);
            for (int i = 0; i < misDatos.size(); i++) {
                modeloTabla.addRow(new String[5]);
                HashMap registro = (HashMap) misDatos.get(i);
                cantV = Double.parseDouble(registro.get("cantidadV").toString());
                punit = Double.parseDouble(registro.get("precioUnitPV").toString());
                modeloTabla.setValueAt(registro.get("idProducto"), i, 0);
                modeloTabla.setValueAt(String.format("%10.2f", cantV), i, 1);
                modeloTabla.setValueAt(registro.get("unidadMedida"), i, 2);
                modeloTabla.setValueAt(registro.get("nombreProd"), i, 3);
                modeloTabla.setValueAt(String.format("%10.2f", Double.parseDouble(registro.get("precioUnitPV").toString())), i, 4);
                modeloTabla.setValueAt(String.format("%10.2f", cantV * punit), i, 5);
                lblMontoTotalV.setText(String.format("%10.2f", (Double.parseDouble(registro.get("montoTotalV").toString()))));
                lblDesc.setText("" + Double.parseDouble(registro.get("descV").toString()));
                frmPrincipal.packColumn(miTablaProd, -1, 2);
            }
        }
        oficiogenerado = false;
    }

    public void verificaTotal() {
        Double valorTotal = 0.00;
        for (int i = 0; i < miTablaProd.getRowCount(); i++) {
            miTablaProd.getModel().setValueAt(String.format("%10.2f", (Double.parseDouble(miTablaProd.getModel().getValueAt(i, 1).toString()) * Double.parseDouble(miTablaProd.getModel().getValueAt(i, miTablaProd.getColumnCount() - 2).toString()))), i, miTablaProd.getColumnCount() - 1);
            valorTotal += Double.parseDouble(miTablaProd.getModel().getValueAt(i, 1).toString()) * Double.parseDouble(miTablaProd.getModel().getValueAt(i, miTablaProd.getColumnCount() - 2).toString());
        }
        lblTotal.setText(String.format("%10.2f", valorTotal));
        montoT = valorTotal;
        double td = (Double.parseDouble(lblTotal.getText().toString())) - ((Double.parseDouble(lblDesc.getText().toString()) / 100) * Double.parseDouble(lblTotal.getText().toString()));
        lblMontoCDesc.setText(String.format("%10.2f", td));
        lblDiferencia.setText(String.format("%10.2f", (Double.parseDouble(lblMontoTotalV.getText().toString())) - (Double.parseDouble(lblTotal.getText().toString()))));
    }

    private void miTablaProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miTablaProdMouseClicked
        if (evt.getClickCount() == 2) {
            verificaTotal();
        }
    }//GEN-LAST:event_miTablaProdMouseClicked

    private void btnOficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOficioActionPerformed
        frmPrincipal.miConex.actualizaRegistro("venta", "montoTotalV='" +montoT+ "', cobro='" + (Double.parseDouble(lblTotal.getText().trim())) + "'", "idVenta='" + ticket + "'");
        HashMap idV = new HashMap();
        panelVR.removeAll();
        String tv = frmPrincipal.miConex.ConsultaDato("tipoVenta", "venta", " where idVenta='"+ticket+"'");
        if(tv.equals("R")){
            idV.put("idVenta", "" + ticket);
            idV.put("tipoPago",(!(frmPrincipal.miConex.ConsultaDato("tipoPago", "venta", " where idVenta='"+ticket+"'")).equals("E")) ? "CREDITO PERMITIDO" : "CONTADO");
            panelVR.add(new panelVistaReportes("Remision", idV));
        }else{
            idV.put("noVenta", ticket);
            panelVR.add(new panelVistaReportes("ticket_D", idV));
        }
        panelVR.updateUI();
        oficiogenerado = true;
    }//GEN-LAST:event_btnOficioActionPerformed

    private void btnAgregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaActionPerformed
        if(oficiogenerado){
            llenarTabla();
        }
        txtID.requestFocus();
        new vizProd(null, true, txtID, 1, -1);
    }//GEN-LAST:event_btnAgregaActionPerformed

    private void btnCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantActionPerformed
        if(oficiogenerado){
            llenarTabla();
        }
        if (miTablaProd.getSelectedRow() >= 0) {
            Object cant = JOptionPane.showInputDialog(this, "Cantidad");
            if (cant != null) {
                miTablaProd.setValueAt(Double.parseDouble(cant.toString()), miTablaProd.getSelectedRow(), 1);
            }
            verificaTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista", "Atención", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCantActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        if(oficiogenerado){
            llenarTabla();
        }
        if (miTablaProd.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el registro?", "Atención usuario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.out.println("idTicket= " +ticket + " and idProducto="+miTablaProd.getValueAt(miTablaProd.getSelectedRow(),0));
                frmPrincipal.miConex.eliminaRegistro("venta_producto", "idVenta ='" + ticket + "' and idProducto='"+miTablaProd.getValueAt(miTablaProd.getSelectedRow(),0)+"'");
                modeloTabla.removeRow(miTablaProd.getSelectedRow());
                verificaTotal();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista", "Atención", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnEliminaActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        /*String idP = txtID.getText().toUpperCase();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtID.setText(txtID.getText().toUpperCase());
        }*/
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        String idP = txtID.getText().toUpperCase();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtID.setText(txtID.getText().toUpperCase());
            agregarATabla(idP);
            txtID.setText("");
        }
        
    }//GEN-LAST:event_txtIDKeyPressed

    
    public void agregarATabla(String idP){
        boolean band = true;
        double valor = 0.00;
        String idProd = "";
        String cantidadP = JOptionPane.showInputDialog(null, "Cantidad").toString();
        System.out.println(cantidadP);
        if (cantidadP != null) {
            for (int i = 0; i < miTablaProd.getRowCount(); i++) {
                idProd = miTablaProd.getModel().getValueAt(i, 0).toString();
                if (idProd.equals(idP)) {
                    valor = Double.parseDouble(miTablaProd.getModel().getValueAt(i, 1).toString()) + Double.parseDouble(cantidadP);
                    miTablaProd.getModel().setValueAt(((Double) valor).toString(), i, 1);
                    frmPrincipal.miConex.actualizaRegistro("venta_producto","cantidadV="+valor," idProducto='"+idP+"' and idVenta='"+ticket+"'");
                    band = false;
                    break;
                }
            }
            if (band) {
                modeloTabla.addRow(new String[6]);
                //P002	      1.00	PAQUETE	PAÑAL KLEENBEBE SUAVELASTIC MAX MD	    435.00	    435.00
                //miTablaProd.getModel().setValueAt(miTablaProd.getRowCount(), miTablaProd.getRowCount() - 1, 0);
                miTablaProd.getModel().setValueAt(idP, miTablaProd.getRowCount() - 1, 0);
                miTablaProd.getModel().setValueAt(String.format("%10.2f",Double.parseDouble(cantidadP)), miTablaProd.getRowCount() - 1, 1);
                Vector datos = frmPrincipal.miConex.consDatosParaTablas("unidadMedida,nombreProd,precioMax", "producto", "where idProducto='"+idP+"'");
                datos = (Vector)datos.get(0);
                miTablaProd.getModel().setValueAt(datos.get(0), miTablaProd.getRowCount() - 1, 2);
                miTablaProd.getModel().setValueAt(datos.get(1), miTablaProd.getRowCount() - 1, 3);
                miTablaProd.getModel().setValueAt(String.format("%10.2f",Double.parseDouble(datos.get(2).toString())), miTablaProd.getRowCount() - 1, 4);
                frmPrincipal.miConex.altaRegistro("venta_producto","null," + Double.parseDouble(cantidadP) +"," + Double.parseDouble(datos.get(2).toString()) + ","+ticket+",'"+idP+"',0.00,0.00");
            }   
            frmPrincipal.cantidadProd = 1;
        }
        verificaTotal();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgrega;
    private javax.swing.JButton btnCant;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnOficio;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgente;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDiferencia;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblMontoCDesc;
    private javax.swing.JLabel lblMontoTotalV;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JTable miTablaProd;
    private javax.swing.JPanel panelVR;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
