package panel;

import dialog.vizProd;
import dialog.altaRapida;
import dialog.jdBCompra;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class miCompra_1 extends javax.swing.JPanel {

    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaRegistro = new DefaultTableModel();
    public static double montoT = 0.00;
    public Vector columnas = new Vector();
    boolean recien = true;
    String idP;
    Vector importes;
    public ImageIcon defaultIcon;

    public miCompra_1() {
        initComponents();
        defaultIcon = new ImageIcon(getClass().getResource("/img/bagP.png"));
        llenaProv();

//        frmPrincipal.inventario=true;        
        columnas.add("ID PRODUCTO");
        columnas.add("DESCRIPCIÓN DEL PRODUCTO");

        columnas.add("U. MEDIDA");
        columnas.add("CANTIDAD");
        columnas.add("V. UNIT.");
        importes = frmPrincipal.miConex.consDatosParaCampos("nomImpuesto,idImpuesto,porcentaje", "impuesto", "");
        for (int imp = 0; imp < importes.size(); imp++) {
            columnas.add(((Vector) importes.get(imp)).get(0));
        }

        columnas.add("P. C/IMP.");
        columnas.add("IMPORTE S/");

        tabla.setDefaultRenderer(Object.class, new celdaRander(0));
        tabla.setRowHeight(30);
        llenarTabla();
        //Vector datos = ;
//        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS,frmPrincipal.obtenID(cboProv)), columnas));
//        frmPrincipal.packColumn(tabla, 0,2);

        verificaTotal();

        setVisible(true);

    }

    public void validaImporte() {
        //DONDE 5 ES LA PRIMERA COLUMNA DE IMPUESTOS
        for (int row = 0; row < tabla.getRowCount(); row++) {
            for (int colimp = 5; colimp < (5 + importes.size()); colimp++) {
                //String idI = ;
                if (frmPrincipal.miConex.ConsultaDato("idImpuesto", "producto_impuesto", "where idProducto='" + tabla.getValueAt(row, 0) + "'").equals(((Vector) importes.get(colimp - 5)).get(1).toString())) {
                    tabla.setValueAt(String.format("%10.2f", Double.parseDouble(((Vector) importes.get(colimp - 5)).get(2).toString())), row, colimp);
                } else {
                    tabla.setValueAt(String.format("%10.2f", Double.parseDouble("0.00")), row, colimp);
                }
            }
        }
    }

    public void llenarTabla() {
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)), columnas));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 1).setPreferredWidth(100);
        validaImporte();
        verificaTotal_1();
    }

    public static void dimenTabla() {
//        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS,frmPrincipal.obtenID(cboProv)), columnas));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 1).setPreferredWidth(100);
    }

    public static void llenaProv() {
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idProveedor,nombreProv", "proveedor", "order by idProveedor"), cboProv);
    }

    public void guardar(int cantS) {
        int s = cantS;
        if (tabla.getModel().getRowCount() == 0) {
            frmPrincipal.habilitacion.setIdExp(frmPrincipal.miConex.crearExpendio(frmPrincipal.fechaS, frmPrincipal.horaS, frmPrincipal.habilitacion.getEmpleado(), (cantS * Double.parseDouble(txtPC.getText())), frmPrincipal.obtenID(cboProv)));
            frmPrincipal.miConex.insertaExpendio(1, cantS, txtPC.getText().toString(), frmPrincipal.habilitacion.getIdExp(), idP);
            //Vector datos = ;
            tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)), columnas));
        } else {
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            if (recien) {
                String idExp = frmPrincipal.miConex.idExpedicion(fecha);
                frmPrincipal.habilitacion.setIdExp(idExp);
                System.out.println("idExp: " + frmPrincipal.habilitacion.getIdExp());
                recien = false;
            }
            //-----VERIFICADOR DE EXISTENCIA-----
            boolean band = false;
            for (int i = 0; i < (tabla.getModel().getRowCount()); i++) {
                if (tabla.getModel().getValueAt(i, 0).equals(idP)) {
                    band = true;
                    break;
                }
            }
            if (band) {
                frmPrincipal.miConex.insertaExpendio(0, cantS, txtPC.getText().toString(), frmPrincipal.habilitacion.getIdExp(), idP);
            } else {
                frmPrincipal.miConex.insertaExpendio(1, cantS, txtPC.getText().toString(), frmPrincipal.habilitacion.getIdExp(), idP);
            }
            //--------------- FIN ---------------
            Vector datos = frmPrincipal.miConex.consultaExpendio(fecha, frmPrincipal.obtenID(cboProv));
            tabla.setModel(new DefaultTableModel(datos, columnas));
        }

        llenarTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCodeDIFAM = new javax.swing.JTextField();
        txtCat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFam = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPCA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtExist = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVA = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtP1 = new javax.swing.JTextField();
        txtP2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtP3 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtP4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPC = new javax.swing.JTextField();
        txtPProtec = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPCI = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPMin = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPProm = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        lblP1 = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        lblP4 = new javax.swing.JLabel();
        btnCorregir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboProv = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        btnCorregir1 = new javax.swing.JButton();
        lblMPagado = new javax.swing.JLabel();
        btnCorregir2 = new javax.swing.JButton();
        btnCorregir3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.0");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto Total de Compra:"));

        jLabel6.setText("Lista de Compra:");

        tabla.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CANT", "UNID", "DESCRIPCION DEL PRODUCTO", "PRECIO", "PRECIO NETO"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel1.setText("No ID:");

        txtID.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtID.setToolTipText("F2 para busqueda por nombre");
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel2.setText("Unidad de Medida:");

        txtUM.setEditable(false);
        txtUM.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtUM.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel3.setText("Descripción:");

        txtDesc.setEditable(false);
        txtDesc.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagP.png"))); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto de Producto"));

        txtCant.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel11.setText("Cantidad:");

        jLabel13.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel13.setText("Code:");

        txtCodeDIFAM.setEditable(false);
        txtCodeDIFAM.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        txtCat.setEditable(false);
        txtCat.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel4.setText("Categoría:");

        jLabel8.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel8.setText("Familia:");

        txtFam.setEditable(false);
        txtFam.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel9.setText("Precio Compra Ant.: $");

        txtPCA.setEditable(false);
        txtPCA.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPCA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel10.setText("Existencia:");

        txtExist.setEditable(false);
        txtExist.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtExist.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel12.setText("Precio Venta Ant.: $");

        txtVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVAKeyTyped(evt);
            }
        });

        jButton1.setText("UTILIDAD");

        jLabel14.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel14.setText("Precio 1:");

        txtP1.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtP1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP1KeyTyped(evt);
            }
        });

        txtP2.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtP2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP2KeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel15.setText("Precio 2:");

        jLabel16.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel16.setText("Precio 3:");

        txtP3.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtP3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP3KeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel18.setText("Precio 4:");

        txtP4.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtP4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtP4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP4KeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Precios:"));

        jLabel19.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel19.setText("Precio Compra:");

        jLabel20.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel20.setText("Precio Protección:");

        txtPC.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCActionPerformed(evt);
            }
        });
        txtPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPCKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPCKeyReleased(evt);
            }
        });

        txtPProtec.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel22.setText("Precio c/imp:");

        txtPCI.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel21.setText("Precio Mínimo:");

        txtPMin.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPMinActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel23.setText("Precio Promedio:");

        txtPProm.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPPromActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel24.setText("Precio General:");

        jTextField5.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("0%");

        jLabel26.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("0%");

        jLabel27.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("0%");

        jLabel28.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("0%");

        jLabel29.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel29.setText("Precio PV Gral/Pza:");

        jLabel30.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel30.setText("Precio PV Gral.:");

        jLabel32.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("% Utilidades:");

        jLabel31.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("0%");

        jTextField6.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        jTextField7.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPProm)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jLabel30)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPCI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPProtec)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21)
                            .addComponent(txtPMin, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(5, 5, 5)
                        .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPProtec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel31))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblP1.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP1.setText("0%");

        lblP2.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP2.setText("0%");

        lblP3.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP3.setText("0%");

        lblP4.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblP4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP4.setText("0%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodeDIFAM, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUM, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExist, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFam, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPCA, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCant, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblP1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtP1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addComponent(txtP2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16)
                            .addComponent(txtP3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblP4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel18)
                            .addComponent(txtP4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodeDIFAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(lblFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblP1)
                    .addComponent(lblP2)
                    .addComponent(lblP3)
                    .addComponent(lblP4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCorregir.setText("ELIMINAR REGISTRO");
        btnCorregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregirActionPerformed(evt);
            }
        });

        jLabel7.setText("Razon Social de Proveedor:");

        cboProv.setEditable(true);
        cboProv.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        cboProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona un Proveedor..." }));
        cboProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProvActionPerformed(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        btnCorregir1.setText("CERRAR COMPRA");
        btnCorregir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregir1ActionPerformed(evt);
            }
        });

        lblMPagado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMPagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMPagado.setText("0.0");
        lblMPagado.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto Pagado::"));

        btnCorregir2.setText("CARGAR COMPRA PREV.");
        btnCorregir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregir2ActionPerformed(evt);
            }
        });

        btnCorregir3.setText("REGISTRO PAGO");
        btnCorregir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregir3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorregir2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorregir3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCorregir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCorregir1))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblMPagado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCorregir)
                            .addComponent(jLabel6)
                            .addComponent(btnCorregir1)
                            .addComponent(btnCorregir2)
                            .addComponent(btnCorregir3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblMPagado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17))
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void verificaTotal_1() {
        Double valorTotal = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Double precio = Double.parseDouble(tabla.getModel().getValueAt(i, 4).toString());
            for (int colimp = 5; colimp < (5 + importes.size()); colimp++) {
                precio = precio * (1 + Double.parseDouble("" + Double.parseDouble("" + tabla.getValueAt(i, colimp)) / 100));
            }
            tabla.getModel().setValueAt(precio, i, tabla.getColumnCount() - 2);
            precio = precio * Double.parseDouble(tabla.getModel().getValueAt(i, 3).toString());
            tabla.getModel().setValueAt(precio, i, tabla.getColumnCount() - 1);
            valorTotal += precio;
        }
        lblTotal.setText("$ " + String.format("%10.2f", valorTotal));
        montoT = valorTotal;
    }

    public static void verificaTotal() {
        Double valorTotal = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            valorTotal += Double.parseDouble(tabla.getModel().getValueAt(i, 2).toString()) * Double.parseDouble(tabla.getModel().getValueAt(i, 3).toString());
        }
        lblTotal.setText("$ " + String.format("%10.2f", valorTotal));
        montoT = valorTotal;
//        Double valorTotal = 0.00;
//        for (int i = 0; i < tabla.getRowCount(); i++) {            
//            valorTotal += Double.parseDouble(tabla.getModel().getValueAt(i, 2).toString()) * Double.parseDouble(tabla.getModel().getValueAt(i, 3).toString());
//        }
//        lblTotal.setText("$ " + String.format("%10.2f", valorTotal));
//        montoT = valorTotal;
    }

    public void enfoca() {
        txtID.requestFocus(true);
    }

    public void llenarCuadros() {
        HashMap busqueda = (HashMap) (frmPrincipal.consultas.miProducto(txtID.getText().toUpperCase()));
        if (!busqueda.isEmpty()) {
            txtCodeDIFAM.setText(busqueda.get("codEmpresa").toString());
            txtDesc.setText(busqueda.get("nombreProd").toString());
            txtCat.setText(busqueda.get("nombreCat").toString());
            txtFam.setText(busqueda.get("nombreFam").toString());
            txtUM.setText(busqueda.get("unidadMedida").toString());
            txtExist.setText(busqueda.get("existencia").toString());
            txtPCA.setText(busqueda.get("precioC").toString());
            txtVA.setText(busqueda.get("precioV").toString());
            frmPrincipal.cargaImagen("foto", "producto", "where idProducto='" + txtID.getText() + "'", lblFoto, 100, 130, defaultIcon);
            idP = txtID.getText();
            verificaTotal_1();
            txtID.setText("");
        }
    }

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        idP = txtID.getText().toUpperCase();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtID.setText(txtID.getText().toUpperCase());
            //boolean existe = frmPrincipal.consultas.existenciaPrevia(txtID.getText().toString());
            //if (existe) {
            llenarCuadros();
//                txtCant.setText("");
//                txtCant.requestFocus();
            txtPC.setText("");
            txtPC.requestFocus();
            //}
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            new vizProd(null, true, txtID, 1, -1);
        }
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            guardar(Integer.parseInt(txtCant.getText()));
            txtID.requestFocus();
            txtDesc.setText("");
            txtUM.setText("");
//            txtProveedor.setText("");
            txtCant.setText("");
            txtCodeDIFAM.setText("");
        }
    }//GEN-LAST:event_txtCantKeyReleased

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantKeyTyped

    private void btnCorregirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregirActionPerformed
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.actualizaRegistro("producto", "existencia=existencia-(" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString().trim() + ") ", "idproducto='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "'");
                frmPrincipal.miConex.eliminaRegistro("compra_producto", "idproducto", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "' and idCompra='" + frmPrincipal.miConex.idExpedicion(fecha));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Registro!!!");
        }
        llenarTablaInvt(fecha);
        verificaTotal();
    }//GEN-LAST:event_btnCorregirActionPerformed

    private void btnCorregir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregir1ActionPerformed
        frmPrincipal.miConex.actualizaRegistro("compra", "estadoCompra=1", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "' and idCompra='" + frmPrincipal.miConex.idExpedicion(frmPrincipal.fechaS));
    }//GEN-LAST:event_btnCorregir1ActionPerformed

    private void txtVAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVAKeyReleased
        txtP1.setText(String.format("%10.2f", Double.parseDouble(txtVA.getText()) * 1.04));
        txtP2.setText(String.format("%10.2f", Double.parseDouble(txtP1.getText()) * 1.04));
        txtP3.setText(String.format("%10.2f", Double.parseDouble(txtP2.getText()) * 1.04));
        txtP4.setText(String.format("%10.2f", Double.parseDouble(txtP3.getText()) * 1.04));
    }//GEN-LAST:event_txtVAKeyReleased

    private void txtVAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVAKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVAKeyTyped

    private void txtP1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1KeyReleased
    }//GEN-LAST:event_txtP1KeyReleased

    private void txtP1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP1KeyTyped

    private void txtP2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP2KeyReleased

    private void txtP2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP2KeyTyped

    private void txtP3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP3KeyReleased

    private void txtP3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP3KeyTyped

    private void txtP4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP4KeyReleased

    private void txtP4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtP4KeyTyped

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        new altaRapida(null, true, "proveedor", 0, cboProv, this);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void btnCorregir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregir2ActionPerformed
        new jdBCompra(null, true, tabla, columnas, null);
    }//GEN-LAST:event_btnCorregir2ActionPerformed

    private void cboProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cboProvActionPerformed

    private void btnCorregir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregir3ActionPerformed
    }//GEN-LAST:event_btnCorregir3ActionPerformed

    private void txtPCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPCKeyTyped

    private void txtPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCant.requestFocus();
        }
    }//GEN-LAST:event_txtPCKeyReleased

    private void txtPMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPMinActionPerformed

    private void txtPPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPPromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPPromActionPerformed

    private void txtPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPCActionPerformed

    public void llenarTablaInvt(String fecha) {
//        Vector datos = frmPrincipal.miConex.consultaExpendio(fecha);
//        tablaRegistro.setModel(new DefaultTableModel(datos, columnas));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorregir;
    private javax.swing.JButton btnCorregir1;
    private javax.swing.JButton btnCorregir2;
    private javax.swing.JButton btnCorregir3;
    public static javax.swing.JComboBox cboProv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblFoto;
    public static javax.swing.JLabel lblMPagado;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP4;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCat;
    private javax.swing.JTextField txtCodeDIFAM;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtExist;
    private javax.swing.JTextField txtFam;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtP1;
    private javax.swing.JTextField txtP2;
    private javax.swing.JTextField txtP3;
    private javax.swing.JTextField txtP4;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtPCA;
    private javax.swing.JTextField txtPCI;
    private javax.swing.JTextField txtPMin;
    private javax.swing.JTextField txtPProm;
    private javax.swing.JTextField txtPProtec;
    private javax.swing.JTextField txtUM;
    private javax.swing.JTextField txtVA;
    // End of variables declaration//GEN-END:variables
}
