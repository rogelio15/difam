package panel;

import dialog.vizProd;
import dialog.cobroEfectivo;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class miVenta_1 extends javax.swing.JPanel {

    private double montoT = 0.00;
    private DefaultTableModel modeloTabla;
    DecimalFormat formatoDecimal = new DecimalFormat("###,###,###.##");
    public ImageIcon defaultIcon;
    String idVenta = "";
    String idP = "";

    public miVenta_1() {
        initComponents();
        defaultIcon = new ImageIcon(getClass().getResource("/img/cestita.png"));
        
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        modeloTabla.addColumn("NO.");
        modeloTabla.addColumn("ID PRODUCTO");
        modeloTabla.addColumn("CANTIDAD");
        modeloTabla.addColumn("U. MEDIDA");
        modeloTabla.addColumn("DESCRIPCIÓN DEL PRODUCTO");
        modeloTabla.addColumn("P.V. GRAL.");
        modeloTabla.addColumn("IMPORTE.");

        tabla.setModel(modeloTabla);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(500);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);

        tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabla.setRowHeight(25);
        ControlBotones(false, false);

        txtIDCKeyReleased(new KeyEvent(this, 1, 20, 1, 10, '\n'));
        setVisible(true);
    }

    public void enfoca() {
        txtIDP.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoDifam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnomProd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        txtIDP = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtCobrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCamCant = new javax.swing.JButton();
        lblNomC = new javax.swing.JLabel();
        txtIDC = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTotalSD = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblDescT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CODE ó ID Producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Código DIFAM");

        txtCodigoDifam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoDifam.setOpaque(false);
        txtCodigoDifam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoDifamActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Descripción del producto:");

        txtnomProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnomProd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtnomProd.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Categoría:");

        txtCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCategoria.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCategoria.setOpaque(false);

        txtIDP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIDP.setOpaque(false);
        txtIDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDPKeyReleased(evt);
            }
        });

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMarca.setOpaque(false);
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMarcaKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Marca:");

        txtUnidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUnidad.setOpaque(false);
        txtUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnidadKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Unidad de Medida:");

        txtPrecioV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecioV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecioV.setText("$0.00");
        txtPrecioV.setOpaque(false);
        txtPrecioV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Precio de Venta:");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto de Producto:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 1, 12))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cestita.png"))); // NOI18N
        jPanel4.add(lblFoto, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(txtIDP, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoDifam, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(txtnomProd, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioV, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoDifam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnomProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Productos de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setFont(new java.awt.Font("Lao UI", 0, 16)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 0, 102));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total C/D:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(153, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("$0.00");
        jPanel3.add(lblTotal, java.awt.BorderLayout.PAGE_END);

        txtCobrar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimeti.gif"))); // NOI18N
        txtCobrar.setText("COBRAR");
        txtCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCobrarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEliminar.setText("Quita de la Lista");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCamCant.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCamCant.setText("Cambiar CANT.");
        btnCamCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCamCantActionPerformed(evt);
            }
        });

        lblNomC.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        lblNomC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomC.setText(" ");
        lblNomC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N

        txtIDC.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        txtIDC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDC.setText("001");
        txtIDC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N
        txtIDC.setOpaque(false);
        txtIDC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDCKeyReleased(evt);
            }
        });

        lblDesc.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesc.setText(" ");
        lblDesc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        lblTotalSD.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblTotalSD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalSD.setText("$0.00");
        jPanel5.add(lblTotalSD, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usted Ahorra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20))); // NOI18N
        jPanel6.setLayout(new java.awt.BorderLayout());

        lblDescT.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblDescT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescT.setText("$0.00");
        jPanel6.add(lblDescT, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomC, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCamCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCobrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomC)
                            .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCobrar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnCamCant)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void ControlBotones(boolean op1, boolean opc2) {
        btnEliminar.setEnabled(op1);
        btnCamCant.setEnabled(op1);
        txtCobrar.setEnabled(op1);
    }

    public void verificaTotal() {
        Double valorTotal = 0.00;
        Double importe = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            System.out.println("valor de i: " + i);
            importe = Double.parseDouble(tabla.getModel().getValueAt(i, 2).toString().trim()) * Double.parseDouble(tabla.getModel().getValueAt(i, 5).toString().trim());
            valorTotal += importe;
            System.out.println("precio: " + String.format("%10.2f", importe));
            tabla.getModel().setValueAt(String.format("%10.2f", importe), i, 6);
            importe = 0.00;
        }
        
        lblTotalSD.setText("$ " + String.format("%10.2f", valorTotal));
        lblDescT.setText("$ " + String.format("%10.2f", valorTotal * (Double.parseDouble(lblDesc.getText().substring(0, lblDesc.getText().indexOf("%")).trim()) / 100)));
        lblTotal.setText("$ " + String.format("%10.2f", valorTotal * (1 - (Double.parseDouble(lblDesc.getText().substring(0, lblDesc.getText().indexOf("%")).trim()) / 100))));
        montoT = valorTotal;
    }

    public void checaExistencia(String idP, String uni, String nomP, String cat, String preV) {
        boolean band = true;
        int valor = 0;
        String idProd = "";
        for (int i = 0; i < tabla.getRowCount(); i++) {
            idProd = tabla.getModel().getValueAt(i, 1).toString();
            if (idProd.equals(txtIDP.getText())) {
                valor = Integer.parseInt(tabla.getModel().getValueAt(i, 2).toString()) + frmPrincipal.cantidadProd;
                tabla.getModel().setValueAt(((Integer) valor).toString(), i, 2);
                band = false;
                break;
            }
        }
        if (band) {
            modeloTabla.addRow(new String[7]);
            tabla.getModel().setValueAt(tabla.getRowCount(), tabla.getRowCount() - 1, 0);
            tabla.getModel().setValueAt(idP, tabla.getRowCount() - 1, 1);
            tabla.getModel().setValueAt(frmPrincipal.cantidadProd, tabla.getRowCount() - 1, 2);

            tabla.getModel().setValueAt(uni, tabla.getRowCount() - 1, 3);
            tabla.getModel().setValueAt(nomP, tabla.getRowCount() - 1, 4);
            tabla.getModel().setValueAt(String.format("%10.2f", Double.parseDouble(preV)), tabla.getRowCount() - 1, 5);
            tabla.getModel().setValueAt(String.format("%10.2f", (Double.parseDouble(preV) * frmPrincipal.cantidadProd)), tabla.getRowCount() - 1, 6);
        }
        frmPrincipal.cantidadProd = 1;
    }
    
      //mètodo para reemplazar las "," en los valores double.
//    public String remmplazaCaracter(String campo) {
//        String caracter = "";
//        if (campo.contains(",")) {
//            caracter = campo.replace(',', '.');
//        }
//        return caracter;
//    }

    public void llenarCuadros() {

        HashMap busqueda = (HashMap) (frmPrincipal.consultas.miProducto(txtIDP.getText().toUpperCase()));

        if (!busqueda.isEmpty()) {
            System.out.println("buscamos valores de busqueda");
            txtCodigoDifam.setText(busqueda.get("codEmpresa").toString());
            txtnomProd.setText(busqueda.get("nombreProd").toString());
            txtCategoria.setText(busqueda.get("nombreCat").toString());
            txtMarca.setText(busqueda.get("nombreMarca").toString());
            txtUnidad.setText(busqueda.get("unidadMedida").toString());
            txtPrecioV.setText(busqueda.get("PrecioGenPV").toString());
            frmPrincipal.cargaImagen("foto", "producto", "where idProducto='" + txtIDP.getText() + "'", lblFoto, 110, 120, defaultIcon);
            checaExistencia(txtIDP.getText().toString(), txtUnidad.getText().toString(), txtnomProd.getText().toString(), txtCategoria.getText().toString(), txtPrecioV.getText().toString());
            verificaTotal();
            txtIDP.setText("");
        }
    }

    private void txtCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCobrarActionPerformed
        if (tabla.getRowCount() > 0) {
            int SoN = JOptionPane.showConfirmDialog(this, "¿Está segura de haber registrado todos\n"
                    + "los productos?", "¡Atención Vendedor!", JOptionPane.YES_NO_OPTION);
            if (SoN == JOptionPane.YES_OPTION) {
                new cobroEfectivo(null, true, tabla, montoT, montoT, modeloTabla, txtIDC.getText(), lblDesc.getText().substring(0, lblDesc.getText().indexOf("%")));
                montoT = 0;
                System.out.println("Falla lblTotal");

                lblTotal.setText("$ " + String.format("%10.2f", montoT));
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
            boolean existe = frmPrincipal.consultas.existenciaPrevia(txtIDP.getText().toString());
            if (existe) {
                llenarCuadros();
                ControlBotones(true, false);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            txtCobrarActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
//            new CantidadProd(null,true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            new vizProd(null, true, txtIDP, 4, -1);
        }
    }//GEN-LAST:event_txtIDPKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                modeloTabla.removeRow(tabla.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una PRODUCTO!!!");
        }
        verificaTotal();
        txtIDP.requestFocus();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCamCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCamCantActionPerformed
        tabla.setEnabled(true);
        if (tabla.getSelectedRow() >= 0) {
            String cantidadP = JOptionPane.showInputDialog(null, "Cantidad").toString();
            if (Integer.parseInt(cantidadP) > 0) {
                if (cantidadP != null) {
                    if (!(cantidadP.equals(""))) {
                        idP = String.valueOf(modeloTabla.getValueAt(tabla.getSelectedRow(), 1));
                        double cP = Double.parseDouble(cantidadP);
                        tabla.getModel().setValueAt(cP, tabla.getSelectedRow(), 2);
                        cambiaPrecio(cP);
                        verificaTotal();
                        txtIDP.requestFocus();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe agregar un valor mayor a 0!!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una PRODUCTO!!!");
        }
}//GEN-LAST:event_btnCamCantActionPerformed

    private void txtMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaKeyReleased

    private void txtUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadKeyReleased

    private void txtPrecioVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVKeyReleased

    private void txtCodigoDifamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoDifamActionPerformed
    }//GEN-LAST:event_txtCodigoDifamActionPerformed

    public void cambiaPrecio(double cantidad) {
        double precioVenta;
        precioVenta = frmPrincipal.consultas.obtenerPrecioGralVenta(idP, 2);
        tabla.getModel().setValueAt(String.format("%10.2f", (precioVenta * cantidad)), tabla.getRowCount() - 1, 6);
    }

    private void txtIDCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDCKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Vector datos = frmPrincipal.miConex.consDatosParaTablas("nombreCli,descuentoC", "cliente", "WHERE idCliente='" + txtIDC.getText() + "'");
            datos = (Vector) datos.get(0);
            lblNomC.setText(datos.get(0).toString());
            lblDesc.setText(datos.get(1).toString() + "%");
            verificaTotal();
        }
    }//GEN-LAST:event_txtIDCKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCamCant;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDescT;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNomC;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalSD;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JButton txtCobrar;
    private javax.swing.JTextField txtCodigoDifam;
    public javax.swing.JTextField txtIDC;
    public javax.swing.JTextField txtIDP;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtPrecioV;
    public javax.swing.JTextField txtUnidad;
    private javax.swing.JTextField txtnomProd;
    // End of variables declaration//GEN-END:variables
}