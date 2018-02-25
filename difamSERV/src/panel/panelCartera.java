package panel;
import dialog.AltaPago;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class panelCartera extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloC = new DefaultTableModel();
    String idVenta = "1", montoP = "";
    Vector columnas, columnasC;
    double mp = 0;
    double contPago = 0;
    String quienPaga = "0"; //0 si paga el cliente, 1 si paga el agente
    
    public panelCartera() {
        initComponents();
        confpanel();
        listarPagos();
    }

    public panelCartera(String cliente, String venta, String montoP, String dias) {
        initComponents();
        confpanel();
        tablaC.setModel(new DefaultTableModel(null,columnasC));
        this.montoP = montoP;
        txtID.setText(cliente);
        txtIDV.setText(venta);
        lblMP.setText(montoP);
        txtDTrans.setText(dias);
        if(Integer.parseInt(dias)>60){
            quienPaga = "1";
            txtQuien.setText("VENDEDOR");
        }
        llenarCuadros();        
        mp = Double.parseDouble(lblMT.getText());
        CalcularRestos();
        verificaTotal();
    }
    public void CalcularRestos(){
        contPago = 0;
        for(int row=0;row<tablaC.getRowCount();row++){
//            double importe =  Double.parseDouble(tablaC.getValueAt(row,4).toString());
//            double restPago = Double.parseDouble(tablaC.getValueAt(row,5).toString());
            contPago += Double.parseDouble(tablaC.getValueAt(row,3).toString());
            tablaC.setValueAt(contPago, row,4);
            tablaC.setValueAt(mp-contPago, row,5);
        }
    }

    public void confpanel() {
        columnas = new Vector();
        columnas.add("ID");
        columnas.add("CANT.");
        columnas.add("DESCRIPCION");
        columnas.add("PRECIO UNIT.");
        columnas.add("PRECIO NETO");

        columnasC = new Vector();
        columnasC.add("NO. PAGO");
        //columnasC.add("VENTA");
        columnasC.add("FECHA PAGO.");
        columnasC.add("DIAS REST.");
        columnasC.add("MONTO");
        columnasC.add("IMPORTE");
        columnasC.add("TOTAL REST.");
        columnasC.add("PAGADO POR");
    }

    public void llenarTabla() {
        frmPrincipal.miConex.consDatosParaTablas("*", "venta_producto", "inner join venta using(idVenta) inner join producto using(producto) where idVenta='" + idVenta + "'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPob = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnAPago = new javax.swing.JButton();
        lblPagoE = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblAgente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblRuta = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        lblMP = new javax.swing.JLabel();
        lblMR = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIDV = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        lblFV = new javax.swing.JLabel();
        txtDTrans = new javax.swing.JTextField();
        txtQuien = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblPob.setBackground(new java.awt.Color(255, 255, 255));
        lblPob.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblPob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPob.setText(" ");
        lblPob.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Población:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblPob.setOpaque(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs18/aceptar.png"))); // NOI18N
        jButton2.setText("ELIMINAR PAGO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs18/edit.png"))); // NOI18N
        btnAPago.setText("AGREGAR PAGO");
        btnAPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPagoActionPerformed(evt);
            }
        });

        lblPagoE.setBackground(new java.awt.Color(255, 255, 255));
        lblPagoE.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblPagoE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagoE.setText(" ");
        lblPagoE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pago estimado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblPagoE.setOpaque(true);

        lblMT.setBackground(new java.awt.Color(255, 255, 255));
        lblMT.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblMT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMT.setText(" ");
        lblMT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto a Pagar:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblMT.setOpaque(true);

        lblAgente.setBackground(new java.awt.Color(255, 255, 255));
        lblAgente.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblAgente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgente.setText(" ");
        lblAgente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Agente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblAgente.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        jLabel8.setText("Lista de Productos:");

        tabla.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.Pago", "No Venta", "Fecha de Venta", "Fecha Pago", "Días Rest.", "Monto Pago", "Importe", "Total Restante", "Reportado a DIFAM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        lblRuta.setBackground(new java.awt.Color(255, 255, 255));
        lblRuta.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRuta.setText(" ");
        lblRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ruta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblRuta.setOpaque(true);

        lblNom.setBackground(new java.awt.Color(255, 255, 255));
        lblNom.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNom.setText(" ");
        lblNom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblNom.setOpaque(true);

        tablaC.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tablaC.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaC);

        txtID.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Cliente:"));
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        lblMP.setBackground(new java.awt.Color(255, 255, 255));
        lblMP.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblMP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMP.setText(" ");
        lblMP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto pagado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblMP.setOpaque(true);

        lblMR.setBackground(new java.awt.Color(255, 255, 255));
        lblMR.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblMR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMR.setText(" ");
        lblMR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto restante:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblMR.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        jLabel12.setText("Lista de Pagos a ésta Remisión:");

        txtIDV.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtIDV.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Venta:"));
        txtIDV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDVKeyTyped(evt);
            }
        });

        lblTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblTotal.setFont(new java.awt.Font("Lao UI", 1, 16)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto restante:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblTotal.setOpaque(true);

        lblFV.setBackground(new java.awt.Color(255, 255, 255));
        lblFV.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblFV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFV.setText(" ");
        lblFV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Venta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        lblFV.setOpaque(true);

        txtDTrans.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtDTrans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDTrans.setBorder(javax.swing.BorderFactory.createTitledBorder("Días Transcurridos:"));
        txtDTrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDTransKeyTyped(evt);
            }
        });

        txtQuien.setBackground(new java.awt.Color(255, 255, 255));
        txtQuien.setFont(new java.awt.Font("Lao UI", 1, 16)); // NOI18N
        txtQuien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtQuien.setText("CLIENTE");
        txtQuien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto pagado por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N
        txtQuien.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAgente, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDV, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPagoE, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMR, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNom, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFV, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPob, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(112, 112, 112))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAPago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNom)
                    .addComponent(lblPob)
                    .addComponent(lblRuta)
                    .addComponent(lblFV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgente)
                    .addComponent(lblMR)
                    .addComponent(lblMP)
                    .addComponent(lblPagoE)
                    .addComponent(lblMT)
                    .addComponent(txtIDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnAPago)
                    .addComponent(lblTotal)
                    .addComponent(txtQuien))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPagoActionPerformed
        Vector info = new Vector();
        info.add(txtIDV.getText());
        info.add(lblMT.getText());
        info.add(lblFV.getText());
        info.add(frmPrincipal.lblFecha.getText());
        info.add("7");
        info.add("0.00");
        info.add(lblMP.getText());
        info.add("0.00");
        info.add(quienPaga);
        new AltaPago(null, true, info);
        listarPagos();
}//GEN-LAST:event_btnAPagoActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
//        if (evt.getKeyCode() == KeyEvent.VK_F2) {
//            new vizProd(null, true, txtID, 2, 0);
//            txtIDV.setText(txtID.getText());
//            new vizProd(null, true, txtIDV, 3, 3);
//            llenarCuadros();
//        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtIDVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDVKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDVKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(tablaC.getSelectedRow()>0){
            frmPrincipal.miConex.eliminaRegistro("pago","idPago",tablaC.getValueAt(tablaC.getSelectedRow(),0).toString());
        }
        listarPagos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDTransKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTransKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTransKeyTyped

    public void llenarCuadros2() {
        double monto = Double.parseDouble(lblMP.getText());
        Vector datosCli = frmPrincipal.miConex.consDatosParaCampos("nombreCli,descRuta,poblacionCli,(select concat(nombreemp,' ',apellidopatemp,' ',apellidomatemp) from empleado where idEmpleado = venta.idempleado) as nomempleado,montoTotalV,limiteDiasCred,fechaventa", "venta", " inner join cliente using(idcliente) inner join ruta_agente using(idr_A) inner join ruta using(idruta) where idcliente='" + txtID.getText() + "' and idVenta='" + txtIDV.getText() + "'");
        datosCli = (Vector) datosCli.get(0);
        lblNom.setText(datosCli.get(0).toString());
        lblRuta.setText(datosCli.get(1).toString());
        lblPob.setText(datosCli.get(2).toString());
        lblAgente.setText(datosCli.get(3).toString());
        lblMT.setText(datosCli.get(4).toString());
        lblPagoE.setText("" + (Double.parseDouble(datosCli.get(4).toString()) / Double.parseDouble(datosCli.get(5).toString())));
        lblFV.setText(datosCli.get(6).toString());
        lblMR.setText("" + (Double.parseDouble(datosCli.get(4).toString()) - monto));
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,cantidadV,nombreProd,precioUnitPV,(cantidadV*precioUnitPV)", "venta_producto", "inner join producto using(idProducto) where idVenta='" + txtIDV.getText() + "'"), columnas));
        tabla.setDefaultRenderer(Object.class, new celdaRander(0));
        tabla.setRowHeight(20);
        frmPrincipal.packColumn(tabla, 0, 2);
        listarPagos();
    }
    public void llenarCuadros() {
        double monto = Double.parseDouble(lblMP.getText());
        Vector datosCli = frmPrincipal.miConex.consDatosParaCampos("nombreCli,descRuta,poblacionCli,(select concat(nombreemp,' ',apellidopatemp,' ',apellidomatemp) from empleado where idEmpleado = venta.idempleado) as nomempleado,montoTotalV,limiteDiasCred,fechaventa", "venta", " inner join cliente using(idcliente) inner join ruta_agente using(idr_A) inner join ruta using(idruta) where idcliente='" + txtID.getText() + "' and idVenta='" + txtIDV.getText() + "'");
        datosCli = (Vector) datosCli.get(0);
        System.out.println(datosCli);
        lblNom.setText(datosCli.get(0).toString());
        lblRuta.setText(datosCli.get(1).toString());
        lblPob.setText(datosCli.get(2).toString());
        lblAgente.setText(datosCli.get(3).toString());
        lblMT.setText(datosCli.get(4).toString());
        lblPagoE.setText("" + (Double.parseDouble(datosCli.get(4).toString()) / Double.parseDouble(datosCli.get(5).toString())));
        lblFV.setText(datosCli.get(6).toString());
        lblMR.setText("" + (Double.parseDouble(datosCli.get(4).toString()) - monto));

//        tabla.setDefaultRenderer(Object.class, new celdaRander(0));
        tabla.setRowHeight(20);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,cantidadV,nombreProd,precioUnitPV,(cantidadV*precioUnitPV)", "venta_producto", "inner join producto using(idProducto) where idVenta='" + txtIDV.getText() + "'"), columnas));

        frmPrincipal.packColumn(tabla, 0, 2);
        listarPagos();
    }
    public void listarPagos2() {
        if (!montoP.equals("0.00")) {
            tablaC.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idPago,fechaPago,DATEDIFF(ADDDATE(fechaVenta,limitediascred),fechaPago) as diasr,montoPago,null,null,IF(estadoPago='1','VENDEDOR','CLIENTE')", "pago", "inner join venta using(idVenta) inner join cliente using(idCliente) where idVenta='" + txtIDV.getText() + "'"), columnasC));
            tablaC.setDefaultRenderer(Object.class, new celdaRander(0));
            tablaC.setRowHeight(20);
            frmPrincipal.packColumn(tablaC, 0, 2);
            lblMP.setText(frmPrincipal.miConex.ConsultaDato("sum(montoPago)", "pago","where idVenta='"+txtIDV.getText()+"'"));
            lblMR.setText("" + (Double.parseDouble(lblMT.getText()) - Double.parseDouble(lblMP.getText())));
            if(lblMP.getText().equals(lblMT.getText())){
                btnAPago.setEnabled(false);
            }
            CalcularRestos();
        }
    }
    public void listarPagos() {
        if (!montoP.equals("0.00")) {
            Vector datos = frmPrincipal.miConex.consDatosParaTablas("idPago,fechaPago,DATEDIFF(ADDDATE(fechaVenta,limitediascred),fechaPago) as diasr,montoPago,null,null,IF(estadoPago='1','VENDEDOR','CLIENTE')", "pago", "inner join venta using(idVenta) inner join cliente using(idCliente) where idVenta='" + txtIDV.getText() + "'");
            if (!datos.isEmpty()) {
                tablaC.setRowHeight(20);
                tablaC.setModel(new DefaultTableModel(datos, columnasC));
                frmPrincipal.packColumn(tablaC, 0, 2);
                lblMP.setText(frmPrincipal.miConex.ConsultaDato("sum(montoPago)", "pago", "where idVenta='" + txtIDV.getText() + "'"));
                lblMR.setText("" + (Double.parseDouble(lblMT.getText()) - Double.parseDouble(lblMP.getText())));
                if (lblMP.getText().equals(lblMT.getText())) {
                    btnAPago.setEnabled(false);
                }
                CalcularRestos();
            }
        }
    }

    public void verificaTotal() {
        Double valorTotal = 0.00;
        Double importe = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            importe=Double.parseDouble(tabla.getModel().getValueAt(i, 4).toString());
            //importe= Double.parseDouble(tabla.getModel().getValueAt(i, 2).toString()) * Double.parseDouble(tabla.getModel().getValueAt(i, 5).toString());
            valorTotal +=importe;
            //tabla.getModel().setValueAt(String.format("%10.2f", importe), i, 6);
            importe=0.00;
        }
        lblTotal.setText("$ " + String.format("%10.2f", valorTotal));
        //Aplocar descuento
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAPago;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAgente;
    private javax.swing.JLabel lblFV;
    private javax.swing.JLabel lblMP;
    private javax.swing.JLabel lblMR;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblPagoE;
    private javax.swing.JLabel lblPob;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaC;
    private javax.swing.JTextField txtDTrans;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDV;
    private javax.swing.JLabel txtQuien;
    // End of variables declaration//GEN-END:variables
}
