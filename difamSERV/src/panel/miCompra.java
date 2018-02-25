package panel;

import dialog.vizProd;
import dialog.altaRapida;
import dialog.jdlPagoCompra;
import dialog.jdBCompra;
import datos_multiplos.miUtilidades;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import static java.lang.Double.parseDouble;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class miCompra extends javax.swing.JPanel {

    //public static enum miUtilidades mp;
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaRegistro = new DefaultTableModel();
    public static double montoT = 0.00;
    public Vector columnas = new Vector();
    boolean recien = true;
    String idP;
    Vector importes;
    double vn = 0.00;
    public ImageIcon defaultIcon;
    boolean mezcla = false;
    miUtilidades mp;
    private boolean traeImpuesto;

    public miCompra() {
        initComponents();
        defaultIcon = new ImageIcon(getClass().getResource("/img/bagP.png"));
        lblFC.setText(frmPrincipal.fechaS);
        llenaProv();
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
        tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabla.setRowHeight(30);
        frmPrincipal.habilitacion.setIdExp(frmPrincipal.miConex.idExpedicion(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)));
        llenarTabla();
        //Vector datos = ;
//        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS,frmPrincipal.obtenID(cboProv)), columnas));
//        frmPrincipal.packColumn(tabla, 0,2);
        setVisible(true);
    }

    public void validaEstado() {
        String dato = frmPrincipal.miConex.ConsultaDato("estadoCompra", "compra", " where idCompra='" + frmPrincipal.habilitacion.getIdExp() + "'");
        if (dato.equals("1")) {
            enableComponents(panelDatos, false);
            btnCorregir.setEnabled(false);
            btnCerrar.setEnabled(false);
            btnRegPago.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Compra cerrada!");
        } else {
            enableComponents(panelDatos, true);
            btnCorregir.setEnabled(true);
            btnCerrar.setEnabled(true);
            btnRegPago.setEnabled(false);
        }
    }

    public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
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
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(lblFC.getText(), frmPrincipal.obtenID(cboProv)), columnas));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(tabla.getColumnCount() - 1).setPreferredWidth(100);
        validaImporte();
        verificaTotal_1();
        validaEstado();
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

    public void guardar(double cantS) {
        double s = cantS;
        if (tabla.getModel().getRowCount() == 0) {
            frmPrincipal.habilitacion.setIdExp(frmPrincipal.miConex.crearExpendio(frmPrincipal.fechaS, frmPrincipal.horaS, frmPrincipal.habilitacion.getEmpleado(), (cantS * Double.parseDouble(txtPC.getText())), frmPrincipal.obtenID(cboProv)));
            frmPrincipal.miConex.insertaExpendio(1, cantS, txtPC.getText().toString(), frmPrincipal.habilitacion.getIdExp(), idP);
            tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)), columnas));
        } else {
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            if (recien) {
                String idExp = frmPrincipal.miConex.idExpedicion(fecha, frmPrincipal.obtenID(cboProv));
                //String idExp = frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv));
                frmPrincipal.habilitacion.setIdExp(idExp);
                System.out.println("idExp: " + frmPrincipal.habilitacion.getIdExp());
                recien = false;
            }
            //-----VERIFICADOR DE EXISTENCIA EN LA LISTA DE COMPRA-----
            boolean band = false;
            for (int i = 0; i < (tabla.getModel().getRowCount()); i++) {
                //JOptionPane.showMessageDialog(null,idP);
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
        frmPrincipal.miConex.actualizaRegistro("producto", "estado=true,"
                //+ "existencia=(existencia+" + txtCant.getText() + "),"
                + "precioC='" + txtPC.getText() + "',"
                //+ "precioC='" + txtPCI.getText() + "',"
                + "precioProtec='" + txtPProtec.getText() + "',"
                + "precioMin='" + txtPMin.getText() + "',"
                + "precioProm='" + txtPProm.getText() + "',"
                + "precioMax='" + txtPMax.getText() + "',"
                + "PrecioGenPV='" + txtPVGP.getText() + "',"
                + "ultCantC='" + txtCant.getText() + "',"
                + "ultPrecIC='" + txtPCI.getText() + "'"
                + "", "IdProducto='" + idP + "'");
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSubTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        txtCantPaq = new javax.swing.JTextField();
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
        txtPMax = new javax.swing.JTextField();
        lblPProtec = new javax.swing.JLabel();
        lblPMin = new javax.swing.JLabel();
        lblPProm = new javax.swing.JLabel();
        lblPMax = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblPPVP = new javax.swing.JLabel();
        txtPVGP = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtUCant = new javax.swing.JTextField();
        lblNota = new javax.swing.JLabel();
        btnCorregir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboProv = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        lblFC = new javax.swing.JLabel();
        btnCorregir2 = new javax.swing.JButton();
        btnRegPago = new javax.swing.JButton();
        lblImp = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblSubTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("0.0");
        lblSubTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("SUBTOTAL:"));

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

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel1.setText("No ID:");

        txtID.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtID.setToolTipText("F2 para busqueda por nombre");
        txtID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDMouseClicked(evt);
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

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel2.setText("Unid. Med.:");

        txtUM.setEditable(false);
        txtUM.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtUM.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel3.setText("Descripción:");

        txtDesc.setEditable(false);
        txtDesc.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagP.png"))); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto de Producto"));

        txtCantPaq.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtCantPaq.setText("1");
        txtCantPaq.setEnabled(false);
        txtCantPaq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantPaqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantPaqKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel11.setText("Cant. Paq:");

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
        jLabel9.setText("Precio Ant.: $");

        txtPCA.setEditable(false);
        txtPCA.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPCA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel10.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel10.setText("Existencia:");

        txtExist.setEditable(false);
        txtExist.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtExist.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Precios de Compra:"));

        jLabel19.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel19.setText("Precio Compra:");

        jLabel20.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel20.setText("Precio Protección:");

        txtPC.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPCKeyTyped(evt);
            }
        });

        txtPProtec.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPProtec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPProtec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPProtecKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel22.setText("Precio c/imp:");

        txtPCI.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPCIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPCIKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel21.setText("Precio Mínimo:");

        txtPMin.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPMinActionPerformed(evt);
            }
        });
        txtPMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPMinKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel23.setText("Precio Promedio:");

        txtPProm.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPProm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPPromActionPerformed(evt);
            }
        });
        txtPProm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPPromKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel24.setText("Precio Maximo:");

        txtPMax.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPMaxKeyReleased(evt);
            }
        });

        lblPProtec.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblPProtec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPProtec.setText("0%");

        lblPMin.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblPMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPMin.setText("0%");

        lblPProm.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblPProm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPProm.setText("0%");

        lblPMax.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblPMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPMax.setText("0%");

        jLabel29.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel29.setText("Precio PV Gral/Pza:");

        jLabel32.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("% Utilidades:");

        lblPPVP.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblPPVP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPPVP.setText("0%");

        txtPVGP.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtPVGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPProm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                    .addComponent(lblPMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPPVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPVGP)))))
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
                            .addComponent(lblPProtec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPProtec)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21)
                            .addComponent(txtPMin, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(lblPMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lblPMin)
                    .addComponent(lblPProtec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPVGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPMax)
                    .addComponent(lblPProm)
                    .addComponent(lblPPVP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel34.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel34.setText("Cantidad:");

        txtCant.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCant.setText("1");
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        jLabel12.setText("Ultima Cantidad Comprada:");

        txtUCant.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        txtUCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUCant.setText("1");
        txtUCant.setEnabled(false);
        txtUCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUCantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUCantKeyTyped(evt);
            }
        });

        lblNota.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        lblNota.setText("NOTA:");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesc))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodeDIFAM))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUM, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExist))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFam))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPCA, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantPaq))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUCant, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCant))
                    .addComponent(lblNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodeDIFAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtCantPaq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(lblFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNota)
                .addContainerGap())
        );

        btnCorregir.setText("ELIMINAR REGISTRO");
        btnCorregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregirActionPerformed(evt);
            }
        });

        jLabel7.setText("R.S. Proveedor:");

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

        btnCerrar.setText("CERRAR COMPRA");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblFC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFC.setText("XX/XX/XXXX");
        lblFC.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de Compra:"));

        btnCorregir2.setText("CARGAR COMPRA PREV.");
        btnCorregir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregir2ActionPerformed(evt);
            }
        });

        btnRegPago.setText("REGISTRO PAGO");
        btnRegPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPagoActionPerformed(evt);
            }
        });

        lblImp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblImp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImp.setText("0.0");
        lblImp.setBorder(javax.swing.BorderFactory.createTitledBorder("IMPUESTO:"));

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.0");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTAL:"));

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
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblFC, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCorregir2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegPago)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCorregir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrar))
                            .addComponent(jScrollPane1))))
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
                            .addComponent(btnCerrar)
                            .addComponent(btnCorregir2)
                            .addComponent(btnRegPago))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFC)
                            .addComponent(lblTotal)
                            .addComponent(lblSubTotal)
                            .addComponent(lblImp)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17))
                        .addGap(7, 7, 7)
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void verificaTotal_1() {
        Double valorTotal = 0.00;
        Double valorTotalIVA = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Double precio = Double.parseDouble(tabla.getModel().getValueAt(i, 4).toString());
            for (int colimp = 5; colimp < (5 + importes.size()); colimp++) {
                precio = precio * (1 + Double.parseDouble("" + Double.parseDouble("" + tabla.getValueAt(i, colimp)) / 100));
            }
            tabla.getModel().setValueAt(String.format("%10.2f", precio), i, tabla.getColumnCount() - 2);
            precio = precio * Double.parseDouble(tabla.getModel().getValueAt(i, 3).toString());
            valorTotalIVA += precio;
            //tabla.getModel().setValueAt(precio, i, tabla.getColumnCount()-1);
            precio = Double.parseDouble(tabla.getModel().getValueAt(i, 3).toString()) * Double.parseDouble(tabla.getModel().getValueAt(i, 4).toString());
            tabla.getModel().setValueAt(String.format("%10.2f", precio), i, tabla.getColumnCount() - 1);
            valorTotal += precio;
        }
        lblSubTotal.setText("$ " + String.format("%10.2f", valorTotal));
        lblImp.setText("$ " + String.format("%10.2f", valorTotalIVA - valorTotal));
        lblTotal.setText("$ " + String.format("%10.2f", valorTotalIVA));
        montoT = valorTotal;
    }

    public static void verificaTotal() {
        Double valorTotal = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {

            valorTotal += parseDouble(tabla.getModel().getValueAt(i, 2).toString()) * parseDouble(tabla.getModel().getValueAt(i, 3).toString());
        }
        lblSubTotal.setText("$ " + String.format("%10.2f", valorTotal));
        montoT = valorTotal;
    }

    public void enfoca() {
        txtID.requestFocus(true);
    }

    public void llenarCuadros() {
        HashMap busqueda = (HashMap) (frmPrincipal.consultas.miProducto(txtID.getText().toUpperCase()));
        double precioImpuesto = 0;
        if (!busqueda.isEmpty()) {

            if (!frmPrincipal.miConex.ConsultaDato("idImpuesto", "producto_impuesto", "inner join producto using(idproducto) where idproducto='" + txtID.getText().toUpperCase() + "'").equals("")) {
                traeImpuesto = true;
                System.out.println("TraeImpuesto: " + traeImpuesto);
                txtPC.setEnabled(false);
                System.out.println("Entando consulta impuesto");
                System.out.println("Precio compra: " + txtPC.getText());
                //obtener todos los impuestos que trae el producto
                asignarPrecios(busqueda, 1);
                //txtPCI.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPC.getText()) * 1.16)).trim());
            } else {
                txtPC.setEnabled(true);
                txtPCI.setEnabled(false);
                txtPC.requestFocus();
                precioImpuesto = Double.parseDouble(busqueda.get("precioC").toString());
                asignarPrecios(busqueda, 2);
            }

            txtUCant.setText(busqueda.get("ultCantC").toString());
            txtCantPaq.setText(busqueda.get("cantXUM").toString());
            frmPrincipal.cargaImagen("foto", "producto", "where idProducto='" + txtID.getText() + "'", lblFoto, 100, 130, defaultIcon);
            //idP = txtID.getText();
            verificaTotal_1();
            txtID.setText("");

        }
        System.out.println("Vacio");
    }

    public void asignarPrecios(HashMap busqueda, int operacion) {
        System.out.println("Asignando precios");
        ArrayList<Double> impuestos = new ArrayList<>();
        txtCodeDIFAM.setText(busqueda.get("codEmpresa").toString());
        txtDesc.setText(busqueda.get("nombreProd").toString());
        txtCat.setText(busqueda.get("nombreCat").toString());
        txtFam.setText(busqueda.get("nombreFam").toString());
        txtUM.setText(busqueda.get("unidadMedida").toString());
        txtExist.setText(busqueda.get("existencia").toString());
        txtPC.setText(busqueda.get("precioC").toString());
        txtPProtec.setText(busqueda.get("precioProtec").toString());
        txtPMin.setText(busqueda.get("precioMin").toString());
        txtPProm.setText(busqueda.get("precioProm").toString());
        txtPMax.setText(busqueda.get("precioMax").toString());
        txtPVGP.setText(busqueda.get("PrecioGenPV").toString());
        txtPCA.setText(busqueda.get("ultPrecIC").toString());

        //si es igual a 1, entonces si trae impuestos, si no solo se obtiene el valor de la compra.
        if (operacion == 1) {
            System.out.println("Se obtitne los impuestos y se calcula el precio");
            String id = busqueda.get("idProducto").toString();
            System.out.println("id : " + id);
            impuestos = frmPrincipal.miConex.ObtenerImpuestos("where idImpuesto in ("  + id + ")", 1);
            
            for (Double impuesto : impuestos) {
                System.out.println("Valor que se devuelve: " + impuesto);
            }
            
            txtPCI.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPC.getText()) * 1.16)).trim());
            
        } else {
            txtPCI.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPC.getText()))).trim());
        }
        calcularUtilidad();
    }

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtID.getText().equals("")) {
                System.out.println("Accede a la validacion del campoId de busqueda");
                idP = txtID.getText().toUpperCase();
                txtID.setText(txtID.getText().toUpperCase());
                llenarCuadros();
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            new vizProd(null, true, txtID, 1, -1);
        }
    }//GEN-LAST:event_txtIDKeyReleased

    private void txtCantPaqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantPaqKeyReleased
    }//GEN-LAST:event_txtCantPaqKeyReleased

    private void txtCantPaqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantPaqKeyTyped
    }//GEN-LAST:event_txtCantPaqKeyTyped

    private void btnCorregirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregirActionPerformed
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.actualizaRegistro("producto", "existencia=existencia-(" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString().trim() + ") ", "idproducto='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "'");
                //frmPrincipal.miConex.eliminaRegistro("compra_producto", "idproducto", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "' and idCompra='" + frmPrincipal.miConex.idExpedicion(fecha));
                System.out.println("tabla: " + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0));
                System.out.println("id: " + frmPrincipal.habilitacion.getIdExp());
                frmPrincipal.miConex.eliminaRegistro("compra_producto", "idproducto", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "' and idCompra='" + frmPrincipal.habilitacion.getIdExp());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Registro!!!");
        }
        llenarTablaInvt(fecha);
        verificaTotal();
    }//GEN-LAST:event_btnCorregirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Está seguro de cerrar la compra, ya no podrá modificarse!") == JOptionPane.YES_OPTION) {
            if (tabla.getRowCount() > 0) {
                if (frmPrincipal.miConex.actualizaRegistro("compra", "montoTotalC='" + lblTotal.getText().substring(1).trim() + "',estadoCompra=1", "idCompra='" + frmPrincipal.habilitacion.getIdExp() + "'")) {
                    JOptionPane.showMessageDialog(null, "Compra cerrada.. ésta compra ya no podrá modificarse");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para cerrar una compra, deben haber productos enlistados");
            }
        }
        validaEstado();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        new altaRapida(null, true, "proveedor", 0, cboProv, this);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void btnCorregir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregir2ActionPerformed
        new jdBCompra(null, true, tabla, columnas, this);
    }//GEN-LAST:event_btnCorregir2ActionPerformed

    private void cboProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProvActionPerformed
        //lblFC.setText(frmPrincipal.fechaS);
        frmPrincipal.habilitacion.setIdExp(frmPrincipal.miConex.idExpedicion(lblFC.getText(), frmPrincipal.obtenID(cboProv)));
        llenarTabla();
    }//GEN-LAST:event_cboProvActionPerformed

    private void btnRegPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPagoActionPerformed
        new jdlPagoCompra(null, true, frmPrincipal.habilitacion.getIdExp(), cboProv.getSelectedItem().toString(), Double.parseDouble(lblTotal.getText().substring(1).trim()));
    }//GEN-LAST:event_btnRegPagoActionPerformed

    private void txtPCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyTyped
        char caracter = evt.getKeyChar();
        System.out.println("Prueba de caracter");
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPC.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPCKeyTyped

    private void txtPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyReleased
        System.out.println("traeImpuesto Nuevo: " + traeImpuesto);
        if (traeImpuesto) {
            System.out.println("no se calcula el precio con impuesto");
        } else {
            System.out.println("Se calcula el precio con impuesto");
            txtPCI.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPC.getText()) * 1.16)).trim());
            System.out.println("Prueba de caracter");

            if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
                System.out.println("Entro validación no enter");

                System.out.println("Entro validación no nula");
                calcularUtilidad();

            }
            calcularPrecios(evt, false);
        }

        //validar cuando el producto no cuenta con impuesto

    }//GEN-LAST:event_txtPCKeyReleased

    public void calcularUtilidad() {
        vn = Double.parseDouble(txtPCI.getText());
        //txtPCI.setText(String.format("%10.2f", Double.parseDouble(txtPC.getText()) * 1.16).trim());

        System.out.println("PCI: " + txtPCI.getText());
        //txtPProtec.setText(String.format("%10.2f", Double.parseDouble(txtPCI.getText()) * 1.15).trim());
        lblPProtec.setText(utilidad(txtPProtec.getText(), 1));
        System.out.println("precio proteccion" + lblPProtec.getText());
        //txtPMin.setText(String.format("%10.2f", Double.parseDouble(txtPCI.getText()) * 1.17).trim());
        lblPMin.setText(utilidad(txtPMin.getText(), 1));
        System.out.println("precio minimo" + txtPMin.getText());
        //txtPProm.setText(String.format("%10.2f", Double.parseDouble(txtPCI.getText()) * 1.20).trim());
        lblPProm.setText(utilidad(txtPProm.getText(), 1));
        System.out.println("precio promedio" + lblPProm.getText());
        //txtPMax.setText(String.format("%10.2f", Double.parseDouble(txtPMin.getText()) * 1.25).trim());
        lblPMax.setText(utilidad(txtPMax.getText(), 1));
        System.out.println("precio maximo" + txtPMax.getText());
        //txtPVGP.setText(String.format("%10.2f", Double.parseDouble(txtPMax.getText()) / Double.parseDouble(txtCantPaq.getText())).trim());

    }

    public String utilidad(String valorPorcentual, int op) {
        double vp = Double.parseDouble(valorPorcentual);
        double resultado = 0;
        if (op == 1) {
            resultado = ((vp * 100) / vn) - 100;
        }
//        if (op == 2) {
//            resultado = ((vp * Double.parseDouble(txtCPUM.getText()) / vn) * 100) - 100;
//        }
        return String.format("%10.2f", resultado);
    }

    public void restaurarValores() {
        System.out.println("Deberia poner todo en ceros");
        txtPProtec.setText("0.00");
        lblPProtec.setText("0.00");
        txtPMin.setText("0.00");
        lblPMin.setText("0.00");
        txtPProm.setText("0.00");
        lblPProm.setText("0.00");
        txtPMax.setText("0.00");
        lblPMax.setText("0.00");
        txtPVGP.setText("0.00");
    }
    private void txtPMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPMinActionPerformed

    private void txtPPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPPromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPPromActionPerformed

    public void limpiarCuadros() {
        txtID.requestFocus();
        txtDesc.setText("");
        txtUM.setText("");
        txtCantPaq.setText("");
        txtCodeDIFAM.setText("");
        txtFam.setText("");
        txtCantPaq.setText("");
        txtCat.setText("");
        txtPCA.setText("");
        txtExist.setText("");
        txtCant.setText("");
        txtUCant.setText("");
        txtPC.setText("");
        txtPCI.setText("");
        txtPProtec.setText("");
        txtPMin.setText("");
        txtPProm.setText("");
        txtPMax.setText("");
        txtPVGP.setText("");

    }

    private void txtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyReleased
        System.out.println("Metodo para ver cuadro de texto");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCant.getText().equals("")) {
                System.out.println("Mostrar mensaje de prueba");
                System.out.println("Mezcla1<" + mezcla + ">");
                System.out.println("txtPCA<" + txtPCA.getText() + ">");
                System.out.println("txtPC<" + txtPC.getText() + ">");
                System.out.println("txtCant<" + txtCant.getText() + ">");

                if (txtPCA.getText().equals(txtPC.getText()) || txtPCA.getText().equals("0")) {
                    System.out.println("Mezcla2<" + mezcla + ">");
                    guardar(Double.parseDouble(txtCant.getText()));
                    limpiarCuadros();
                    if (tabla.getRowCount() > 0) {
                        btnRegPago.setEnabled(true);
                    } else {
                        btnRegPago.setEnabled(false);
                    }
                    mezcla = false;
                } else if (!txtPCA.getText().equals("0")) {
                    System.out.println("Mezcla3<" + mezcla + ">");
                    if (!mezcla) {
                        //System.out.println("HAY UNA DIFERENCIA DE PRECIOS, PUEDES REALIZAR LA MEZCLA O IGNORARLA");
                        System.out.println("Realizando parse de datos");
                        System.out.println("Datos recibido: " + txtUCant.getText());
                        System.out.println("Datos recibido: " + txtPCA.getText());
                        //txtPCA.setText("10");
                        double compraA = parseDouble(txtUCant.getText()) * Double.parseDouble(txtPCA.getText());
                        System.out.println("CompraA: " + compraA);
                        double compraU = parseDouble(txtCant.getText()) * Double.parseDouble(txtPCI.getText());
                        System.out.println("compraU: " + compraU);
                        double cantidad = parseDouble(txtUCant.getText()) + Double.parseDouble(txtCant.getText());
                        System.out.println("cantidad: " + cantidad);

                        lblNota.setText("<html><body>NOTAS: El precio actual, es diferente al ultimo precio de compra,<br>favor de mezclar los precios!<br>Anterior:" + compraA + "<br>Actual:" + compraU + "<br>Cantidad:" + cantidad + "<br></body></html>");
                        if (JOptionPane.showConfirmDialog(null, "El precio actual, es diferente al ultimo precio de compra,\nfavor de mezclar los precios!\nAnterior:" + compraA + "\nActual:" + compraU + "\nCantidad:" + cantidad + "\n¿ESTAS SEGURO DE QUERER MEZCLAR LOS PRECIOS?", "Mezcla de precios", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            txtPCI.setText("" + String.format("%10.2f", ((compraA + compraU) / cantidad)));//PRECIO CON IMPUESTOS
                            txtPCIKeyReleased(evt);
                            mezcla = true;
                        } else {
                            guardar(Double.parseDouble(txtCant.getText()));
                            limpiarCuadros();
                            if (tabla.getRowCount() > 0) {
                                btnRegPago.setEnabled(true);
                            } else {
                                btnRegPago.setEnabled(false);
                            }
                            mezcla = false;
                        }
                    } else {
                        guardar(Double.parseDouble(txtCant.getText()));
                        limpiarCuadros();
                        if (tabla.getRowCount() > 0) {
                            btnRegPago.setEnabled(true);
                        } else {
                            btnRegPago.setEnabled(false);
                        }
                        mezcla = false;
                    }
                    System.out.println("Mezcla4<" + mezcla + ">");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes ingresar un valor");
                txtCant.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCantKeyReleased

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantKeyTyped

    private void txtIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMouseClicked

    private void txtPCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCIKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPCI.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPCIKeyTyped

    public void calcularPrecios(KeyEvent evt, boolean IVA) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtPCI.getText().equals("")) {
                if (!mezcla) {
                    System.out.println("Mezcla de calcularPrecios: " + mezcla);

                } else {
                    txtCant.setText("");
                }
                txtCant.requestFocus();
            }
        }
        vn = Double.parseDouble(txtPCI.getText());
        System.out.println("Vn = " + vn);
        if (IVA) {
            //System.out.println("Precio con impuesto: " + Math.rint(Double.parseDouble(txtPCI.getText()) / 1.16));
            txtPC.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPCI.getText()) / 1.16)).trim());
        }
    }

    private void txtPCIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCIKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            //txtPProtec.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPCI.getText()) * 1.15)).trim());
            lblPProtec.setText(utilidad(txtPProtec.getText(), 1));
            System.out.println("preio proteccion" + lblPProtec.getText());
            //txtPMin.setText(String.format("%10.2f", Double.parseDouble(txtPCI.getText()) * 1.17).trim());
            lblPMin.setText(utilidad(txtPMin.getText(), 1));
            System.out.println("preio proteccion" + txtPMin.getText());
            //txtPProm.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPCI.getText()) * 1.20)).trim());
            lblPProm.setText(utilidad(txtPProm.getText(), 1));
            System.out.println("preio proteccion" + txtPProm.getText());
            //txtPMax.setText(String.format("%10.2f", Math.rint(Double.parseDouble(txtPMin.getText()) * 1.25)).trim());
            lblPMax.setText(utilidad(txtPMax.getText(), 1));
            System.out.println("preio proteccion" + txtPMax.getText());
            //txtPVGP.setText(String.format("%10.2f", Double.parseDouble(txtPMax.getText()) / Double.parseDouble(txtCantPaq.getText())).trim());
        }
        calcularPrecios(evt, true);
    }//GEN-LAST:event_txtPCIKeyReleased

    private void txtPProtecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPProtecKeyReleased
        if (!txtPProtec.getText().trim().equals("")) {
            lblPProtec.setText(utilidad(txtPProtec.getText(), 1));
        }
    }//GEN-LAST:event_txtPProtecKeyReleased

    private void txtPMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMinKeyReleased
        if (!txtPMin.getText().trim().equals("")) {
            lblPMin.setText(utilidad(txtPMin.getText(), 1));
        }
    }//GEN-LAST:event_txtPMinKeyReleased

    private void txtPPromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPPromKeyReleased
        if (!txtPProm.getText().trim().equals("")) {
            lblPProm.setText(utilidad(txtPProm.getText(), 1));
        }
    }//GEN-LAST:event_txtPPromKeyReleased

    private void txtPMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMaxKeyReleased
        if (!txtPMax.getText().trim().equals("")) {
            lblPMax.setText(utilidad(txtPMax.getText(), 1));
            txtPVGP.setText(String.format("%10.2f", Double.parseDouble(txtPMax.getText()) / Double.parseDouble(txtCantPaq.getText())).trim());
        }
    }//GEN-LAST:event_txtPMaxKeyReleased

    private void txtUCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUCantKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUCantKeyReleased

    private void txtUCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUCantKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUCantKeyTyped

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyPressed

    public void llenarTablaInvt(String fecha) {
//        Vector datos = frmPrincipal.miConex.consultaExpendio(fecha);
//        tablaRegistro.setModel(new DefaultTableModel(datos, columnas));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCorregir;
    private javax.swing.JButton btnCorregir2;
    private javax.swing.JButton btnRegPago;
    public static javax.swing.JComboBox cboProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblFC;
    private javax.swing.JLabel lblFoto;
    public static javax.swing.JLabel lblImp;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblPMax;
    private javax.swing.JLabel lblPMin;
    private javax.swing.JLabel lblPPVP;
    private javax.swing.JLabel lblPProm;
    private javax.swing.JLabel lblPProtec;
    public static javax.swing.JLabel lblSubTotal;
    public static javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelDatos;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCantPaq;
    private javax.swing.JTextField txtCat;
    private javax.swing.JTextField txtCodeDIFAM;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtExist;
    private javax.swing.JTextField txtFam;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtPCA;
    private javax.swing.JTextField txtPCI;
    private javax.swing.JTextField txtPMax;
    private javax.swing.JTextField txtPMin;
    private javax.swing.JTextField txtPProm;
    private javax.swing.JTextField txtPProtec;
    private javax.swing.JTextField txtPVGP;
    private javax.swing.JTextField txtUCant;
    private javax.swing.JTextField txtUM;
    // End of variables declaration//GEN-END:variables
}