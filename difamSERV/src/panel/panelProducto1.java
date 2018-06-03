package panel;

import dialog.altaRapida;
import dialog.jdAltaImpuesto;
import dialog.jdGenerarCodigo;
import dialog.jdImpuesto;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.*;

public class panelProducto1 extends javax.swing.JPanel {

    Double vn = 0.00;
    Vector columnas;
    String rutaImg = "";
    boolean actualiza = false;
    public static jdImpuesto impuesto;
    public static jdAltaImpuesto jdAltaImpuesto;
    private String rutaFoto = "";
    private ImageIcon defaultIcon;
    private ArrayList<Double> impuestos;

    /**
     * Creates new form panelProducto
     */
    public panelProducto1() {
        initComponents();

        defaultIcon = new ImageIcon(getClass().getResource("/img/bagP.png"));
        columnas = new Vector();

        /*        select idProducto,
         codEmpresa,
         nombreProd,
         abreviado,
         existencia,
         unidadMedida,
         cantXUM,
         precioC,
         precioMin,
         precioProm,
         precioMax,
         PrecioGenPV,
         stockMin,
         stockMax,
         nombremarca,
         nombreFam,
         nombreUbicacion,
         nombrecat,
         precioProtec,
         precioGen,
         estado
         from producto  inner join categoria using(idcategoria)inner join marca using(idMarca) inner join ubicacion using(idubicacion) WHERE nombreProd like '%%';*/
        columnas.add("ID Producto");
        columnas.add("Codigo Empresa");
        columnas.add("Descripción Producto");
        columnas.add("Abreviat.");
        columnas.add("Existencia");
        columnas.add("Unidad Medida");
        columnas.add("Cant. U.M.");
        columnas.add("P. Compra");
        columnas.add("P. Min");
        columnas.add("P. Prom.");
        columnas.add("P. Max");
        columnas.add("P. PV Gral.");
        columnas.add("Stock Min.");
        columnas.add("Stock Max.");
        columnas.add("Desc. Marca");
        columnas.add("Desc. Familia");
        columnas.add("Ubicación");
        columnas.add("Desc. Categoría");
        columnas.add("P. Protec.");
        //columnas.add("P. Gral.");
        columnas.add("Estado");
        columnas.add("existencia_pieza");

        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("nomImpuesto,idImpuesto", "impuesto", "WHERE idImpuesto != 1"), cboImp);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "marca", ""), cboMarcas);
        frmPrincipal.llenarCombo(frmPrincipal.miConex.consDatosParaCampos("nombreUM", "unidadMedida", ""), cboUM);
        frmPrincipal.llenarCombo(frmPrincipal.miConex.consDatosParaCampos("nombreFam", "familia", ""), cboFam);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "categoria", ""), cboCats);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "ubicacion", ""), cboUbic);
        llenarTabla("order by nombreprod");
        ControlBotones(false, true);
        ActionListener listener;
    }

    public void ControlBotones(boolean op1, boolean opc2) {
        txtID.setEditable(op1);
        txtCD.setEditable(op1);
        txtNombre.setEditable(op1);
        txtAb.setEditable(op1);
        txtExist.setEditable(op1);
        txtCPUM.setEditable(op1);
        txtPC.setEditable(opc2);
        txtSMin.setEditable(op1);
        txtSMax.setEditable(op1);
        txtPMin.setEditable(op1);
        txtPMax.setEditable(op1);
        chkIVA.setEnabled(op1);
        btnActualiza.setEnabled(opc2);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        tabla.setEnabled(opc2);
        txtPiezas.setEditable(op1);
    }

    public void vaciarCampos() {
        chkIVA.setSelected(false);
        txtID.setText("");
        txtCD.setText("");
        txtNombre.setText("");
        txtAb.setText("");
        txtCPUM.setText("");
        txtExist.setText("0");
        txtPC.setText("0.00");
        txtPProtec.setText("0.00");
        txtPMin.setText("0.00");
        txtPProm.setText("0.00");
        txtPMax.setText("0.00");
        txtPVGP.setText("0.00");
        txtSMin.setText("0");
        txtSMax.setText("0");
        txtPCI.setText("0.00");
        txtPProtec.setText("0.00");
        cboImp.setSelectedIndex(0);
        cboMarcas.setSelectedIndex(0);
        cboUM.setSelectedIndex(0);
        cboFam.setSelectedIndex(0);
        cboCats.setSelectedIndex(0);
        cboUbic.setSelectedIndex(0);
        txtPiezas.setText("");
    }

    public void vaciaCuadros() {
        txtID.setText("");
        txtCD.setText("");
        txtNombre.setText("");
        txtAb.setText("");
        txtCPUM.setText("");
        txtPC.setText("");
        txtSMin.setText("");
        txtSMax.setText("");
        txtPMin.setText("");
        txtPMax.setText("");
        txtPC.setText("");
        txtExist.setText("0");
        chkIVA.setSelected(false);
    }

    public void llenarTabla(String condicion) {
        tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabla.setRowHeight(23);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,codEmpresa,nombreProd,abreviado,existencia,unidadMedida,cantXUM,precioC,precioMin,precioProm,precioMax,PrecioGenPV,stockMin,stockMax,nombremarca,nombreFam,nombreUbicacion,nombrecat,precioProtec,estado,existencia_pieza", "producto", " inner join categoria using(idcategoria)inner join marca using(idMarca) inner join ubicacion using(idubicacion) WHERE nombreProd like '%" + txtBuscar.getText().toUpperCase() + "%'" + " " + condicion), columnas));
        //tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,codEmpresa,nombreProd,estado,abreviado,unidadMedida,cantXUM,existencia,precioC,precioProtec,precioMin,precioProm,precioMax,PrecioGenPV,PrecioGen,stockMin,stockMax,idMarca,idUbicacion,idCategoria,nombreFam", "producto", " inner join categoria using(idcategoria)inner join marca using(idMarca) inner join ubicacion using(idubicacion) WHERE nombreProd like '%" + txtBuscar.getText().toUpperCase() + "%'"), columnas));
        tabla.setAutoCreateRowSorter(true);
        frmPrincipal.packColumn(tabla, 0, 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCD = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        cboMarcas = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lblCat = new javax.swing.JLabel();
        cboFam = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        lblFam = new javax.swing.JLabel();
        cboCats = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        lblUM = new javax.swing.JLabel();
        lblMar = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cboUM = new javax.swing.JComboBox();
        txtAb = new javax.swing.JTextField();
        txtCPUM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSMin = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtSMax = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtExist = new javax.swing.JTextField();
        lblUbic = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cboUbic = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
        txtPiezas = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnBarCode = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblTotalP = new javax.swing.JLabel();
        btnActualiza = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelPrecios = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPC = new javax.swing.JTextField();
        txtPMin = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPCI = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPProm = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPMax = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtPVGP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblPProtec = new javax.swing.JLabel();
        lblPMin = new javax.swing.JLabel();
        lblPProm = new javax.swing.JLabel();
        lblPMax = new javax.swing.JLabel();
        lblPPVP = new javax.swing.JLabel();
        txtPProtec = new javax.swing.JTextField();
        btnAgregar2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        chkIVA = new javax.swing.JCheckBox();
        cboImp = new javax.swing.JComboBox();
        lblImp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel7.setText("Codigo o ID del Producto:");

        txtCD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCDKeyTyped(evt);
            }
        });

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        cboMarcas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMarcas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboMarcasKeyReleased(evt);
            }
        });

        jLabel5.setText("Marca:");

        lblCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCatMouseClicked(evt);
            }
        });

        cboFam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LACTEOS", "SODAS", "DETERGENTES", "SUAVIZANTES", "PERFUMES", "COLONIAS", "JUGOS" }));
        cboFam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboFamKeyReleased(evt);
            }
        });

        jLabel13.setText("Familia:");

        lblFam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblFam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFamMouseEntered(evt);
            }
        });

        cboCats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABARROTES", "FARMACOS", "PERFUMERIA" }));
        cboCats.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboCatsKeyReleased(evt);
            }
        });

        jLabel12.setText("Categoría:");

        lblUM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblUM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUMMouseClicked(evt);
            }
        });

        lblMar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblMar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMarMouseClicked(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        cboUM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CAJA", "EXHIBIDOR", "BULTO", "PIEZA", "CHAROLA" }));
        cboUM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboUMKeyReleased(evt);
            }
        });

        txtAb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbKeyTyped(evt);
            }
        });

        txtCPUM.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCPUM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCPUMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPUMKeyTyped(evt);
            }
        });

        jLabel2.setText("Equivalencia:");

        jLabel11.setText("Codigo DIFAM:");

        jLabel1.setText("Descripción del Producto:");

        jLabel4.setText("Unidad de Medida:");

        jLabel3.setText("Abreviado:");

        jLabel10.setText("Stock mínimo:");

        txtSMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSMinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSMinKeyTyped(evt);
            }
        });

        jLabel30.setText("Stock maximo:");

        txtSMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSMaxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSMaxKeyTyped(evt);
            }
        });

        jLabel31.setText("Existencia Cajas:");

        txtExist.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtExist.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtExist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExistActionPerformed(evt);
            }
        });
        txtExist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExistKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExistKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistKeyTyped(evt);
            }
        });

        lblUbic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUbic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblUbic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUbicMouseClicked(evt);
            }
        });

        jLabel34.setText("Ubicación:");

        cboUbic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUbic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboUbicKeyReleased(evt);
            }
        });

        jLabel36.setText("Estado:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cboEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboEstadoKeyReleased(evt);
            }
        });

        txtPiezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPiezasKeyReleased(evt);
            }
        });

        jLabel18.setText("Total piezas:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCPUM, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboUM, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUM))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboCats, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCat)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboFam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFam))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMar))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtAb, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtSMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboUbic, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUbic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboUM, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboCats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboUbic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUbic)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto de Producto"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagP.png"))); // NOI18N
        lblFoto.setToolTipText("<html> <body> Selecciona el producto en la lista<br> y haz doble clic aquí, para asignar<br> una imagen </body> </html>");
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        jPanel3.add(lblFoto, java.awt.BorderLayout.CENTER);

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
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla.setCellSelectionEnabled(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/basurita.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBarCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimeti.gif"))); // NOI18N
        btnBarCode.setText("Genera BarCODE");
        btnBarCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarCodeActionPerformed(evt);
            }
        });

        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        lblTotalP.setText("0");

        btnActualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return16.png"))); // NOI18N
        btnActualiza.setText("Actualiza");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/action_save.gif"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cant. Produtos: ");

        jLabel9.setText("Buscar Producto: ");

        panelPrecios.setBackground(new java.awt.Color(255, 255, 255));
        panelPrecios.setBorder(javax.swing.BorderFactory.createTitledBorder("Precios sólo para modo actualizar:"));

        jLabel8.setText("Precio Compra:");

        jLabel14.setText("Precio Minimo:");

        txtPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPC.setText("0.00");
        txtPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCActionPerformed(evt);
            }
        });
        txtPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPCKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPCKeyTyped(evt);
            }
        });

        txtPMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPMin.setText("0.00");
        txtPMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPMinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPMinKeyTyped(evt);
            }
        });

        jLabel22.setText("Precio c/imp:");

        txtPCI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPCI.setText("0.00");
        txtPCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPCIActionPerformed(evt);
            }
        });
        txtPCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPCIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPCIKeyTyped(evt);
            }
        });

        jLabel15.setText("Precio Protec:");

        jLabel16.setText("Precio Promedio:");

        txtPProm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPProm.setText("0.00");
        txtPProm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPPromKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPPromKeyTyped(evt);
            }
        });

        jLabel21.setText("Precio Maximo:");

        txtPMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPMax.setText("0.00");
        txtPMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPMaxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPMaxKeyTyped(evt);
            }
        });

        jLabel27.setText("Precio PV Gr/Pza:");

        txtPVGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPVGP.setText("0.00");
        txtPVGP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPVGPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPVGPKeyTyped(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("% utilidades");

        lblPProtec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPProtec.setText("0%");
        lblPProtec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblPProtecKeyReleased(evt);
            }
        });

        lblPMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPMin.setText("0%");

        lblPProm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPProm.setText("0%");

        lblPMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPMax.setText("0%");

        lblPPVP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPPVP.setText("0%");

        txtPProtec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPProtec.setText("0.00");
        txtPProtec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPProtecKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPProtecKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelPreciosLayout = new javax.swing.GroupLayout(panelPrecios);
        panelPrecios.setLayout(panelPreciosLayout);
        panelPreciosLayout.setHorizontalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPreciosLayout.createSequentialGroup()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPreciosLayout.createSequentialGroup()
                                    .addComponent(txtPMin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPProm))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPreciosLayout.createSequentialGroup()
                                    .addComponent(lblPMin, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPProm, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtPMax, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelPreciosLayout.createSequentialGroup()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPCI)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelPreciosLayout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11))
                                    .addComponent(txtPProtec)))
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPProtec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPVGP, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(lblPPVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPreciosLayout.setVerticalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreciosLayout.createSequentialGroup()
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel22)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPProtec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPProtec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel21))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPProm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPMin)
                    .addComponent(lblPProm)
                    .addComponent(lblPMax))
                .addGap(4, 4, 4)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPVGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPPVP)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualiza.png"))); // NOI18N
        btnAgregar2.setText("Limpiar campos");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("POR NOMBRE");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("POR FECHA");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel35.setText("IVA:");

        chkIVA.setBackground(new java.awt.Color(255, 255, 255));
        chkIVA.setText("16 %");
        chkIVA.setEnabled(false);
        chkIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkIVAItemStateChanged(evt);
            }
        });
        chkIVA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkIVAStateChanged(evt);
            }
        });
        chkIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIVAActionPerformed(evt);
            }
        });

        cboImp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        cboImp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cboImp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboImpItemStateChanged(evt);
            }
        });
        cboImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboImpActionPerformed(evt);
            }
        });

        lblImp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblImp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkIVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboImp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualiza))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBarCode))
                            .addComponent(panelPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(chkIVA)
                        .addComponent(cboImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPrecios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnBarCode)
                    .addComponent(jLabel6)
                    .addComponent(lblTotalP)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        panelPrecios.getAccessibleContext().setAccessibleName("Precios solo actualización manual::");
    }// </editor-fold>//GEN-END:initComponents

    private void txtCDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCDKeyReleased

}//GEN-LAST:event_txtCDKeyReleased

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased

}//GEN-LAST:event_txtIDKeyReleased

    private void cboMarcasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboMarcasKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
}//GEN-LAST:event_cboMarcasKeyReleased

    private void lblCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCatMouseClicked
        new altaRapida(null, true, "Categoria", 3, cboCats, this);
}//GEN-LAST:event_lblCatMouseClicked

    private void cboFamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboFamKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_cboFamKeyReleased

    private void lblFamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFamMouseClicked
        new altaRapida(null, true, "Familia", 4, cboFam, this);
        //panelProducto.actualizaCombo(cboFam, true, frmPrincipal.miConex.consDatosParaCampos("*", "familia", ""));
}//GEN-LAST:event_lblFamMouseClicked

    private void cboCatsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCatsKeyReleased
}//GEN-LAST:event_cboCatsKeyReleased

    private void lblUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUMMouseClicked
        new altaRapida(null, true, "UnidadMedida", 2, cboUM, this);
}//GEN-LAST:event_lblUMMouseClicked

    private void lblMarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMarMouseClicked
        new altaRapida(null, true, "Marca", 1, cboMarcas, this);
}//GEN-LAST:event_lblMarMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
//        validaEnter(evt, txtPC);
}//GEN-LAST:event_txtNombreKeyReleased

    private void cboUMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboUMKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboMarcas.requestFocus();
        }
}//GEN-LAST:event_cboUMKeyReleased

    private void txtAbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cboUM.requestFocus();
        }
}//GEN-LAST:event_txtAbKeyReleased

    private void txtAbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbKeyTyped
        limite(txtAb, 10, evt);
}//GEN-LAST:event_txtAbKeyTyped

    private void txtCPUMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPUMKeyReleased
//        validaEnter(evt, txtPV);
}//GEN-LAST:event_txtCPUMKeyReleased

    private void txtCPUMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPUMKeyTyped
        limite(txtCPUM, 3, evt);
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtCPUM.getText().indexOf(".") == -1)) {
            evt.consume();
        }
}//GEN-LAST:event_txtCPUMKeyTyped

    private void txtSMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMinKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtSMinKeyReleased

    private void txtSMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMinKeyTyped
        limite(txtSMin, 4, evt);
}//GEN-LAST:event_txtSMinKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        txtID.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
        txtCD.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString());
        txtNombre.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString());
        txtAb.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString());
        txtExist.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());

        frmPrincipal.coincideCampo(cboUM, tabla.getModel().getValueAt(tabla.getSelectedRow(), 5).toString());
        txtCPUM.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
        txtPC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString());

        txtPMin.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 8).toString());
        txtPProm.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 9).toString());
        txtPMax.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 10).toString());
        txtPVGP.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 11).toString());

        txtPProtec.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 18).toString());
        txtSMin.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 12).toString());
        txtSMax.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 13).toString());
        //txtPiezas.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 20).toString());

        frmPrincipal.coincideCampo(cboMarcas, tabla.getModel().getValueAt(tabla.getSelectedRow(), 14).toString());
        frmPrincipal.coincideCampo(cboFam, tabla.getModel().getValueAt(tabla.getSelectedRow(), 15).toString());
        frmPrincipal.coincideCampo(cboUbic, tabla.getModel().getValueAt(tabla.getSelectedRow(), 16).toString());
        frmPrincipal.coincideCampo(cboCats, tabla.getModel().getValueAt(tabla.getSelectedRow(), 17).toString());

        frmPrincipal.cargaImagen("foto", "producto", "where idProducto='" + txtID.getText() + "'", lblFoto, 120, 150, defaultIcon);

        txtPiezas.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 20).toString());

        ArrayList<Double> resultado = frmPrincipal.miConex.ObtenerImpuestos("inner join impuesto using(idImpuesto) where idProducto='" + txtID.getText() + "'", 2);
        
        if (resultado.size() > 1) {
            chkIVA.setSelected(true);
            for (Double resultado1 : resultado) {
                if (!resultado1.equals(1.0)) {
                    System.out.println("resultado: " + resultado1);
                    int id = frmPrincipal.miConex.obtenerImpuesto(resultado1.toString(), 2);
                    frmPrincipal.coincideCampo(cboImp, String.valueOf(id));
                }
            }
            calcularPrecios(resultado, 2);
        } else {
            if (resultado.isEmpty()) {
                chkIVA.setSelected(false);
                frmPrincipal.coincideCampo(cboImp, "");
                resultado.add(0.0);
                calcularPrecios(resultado, 2);
            } else {
                if (resultado.get(0).equals(1.16)) {
                    chkIVA.setSelected(true);
                    frmPrincipal.coincideCampo(cboImp, "");
                    calcularPrecios(resultado, 2);
                }
            }
        }
}//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
//        organiza();
}//GEN-LAST:event_tablaKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.eliminaRegistro("producto", "idProducto", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
        ControlBotones(false, true);
        llenarTabla("");
}//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarCodeActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            new jdGenerarCodigo(null, true, frmPrincipal.consultas, txtID.getText(), txtNombre.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
}//GEN-LAST:event_btnBarCodeActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenarTabla("");
}//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

}//GEN-LAST:event_txtBuscarKeyTyped

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            ControlBotones(true, false);
            actualiza = true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
}//GEN-LAST:event_btnActualizaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar una Clave", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtID.requestFocus();
        } else if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un NOMBRE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
        } else if (txtAb.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un Precio de Venta", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtAb.requestFocus();
        } else if (txtCPUM.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un Precio de Compra", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtCPUM.requestFocus();
        } else {
            String nombreP = cboUM.getModel().getSelectedItem().toString();
            String nombreC = cboMarcas.getModel().getSelectedItem().toString();
            if (!actualiza) {
                boolean existencia = frmPrincipal.consultas.existenciaPrevia(txtID.getText());
                if (existencia) {
                    JOptionPane.showMessageDialog(null, "Este Producto ya existe en la Base de Datos.");
                } else {
                    boolean resp = frmPrincipal.miConex.altaRegistro("producto", "'" + txtID.getText().toUpperCase() + "',"
                            + "'" + txtCD.getText().toUpperCase() + "',"
                            + "'" + txtNombre.getText().toUpperCase() + "',"
                            + ((cboEstado.getSelectedItem().equals("ACTIVO")) ? "true" : "false") + ","
                            + "'" + txtAb.getText().toUpperCase() + "',"
                            + "'" + cboUM.getSelectedItem().toString() + "',"
                            + "'" + txtCPUM.getText().toUpperCase() + "',"
                            + "'" + txtExist.getText().toUpperCase() + "',"
                            + "'" + txtPC.getText().toUpperCase().trim() + "',"
                            + "'" + txtPProtec.getText() + "',"
                            + "'" + txtPMin.getText() + "',"
                            + "'" + txtPProm.getText() + "',"
                            + "'" + txtPMax.getText() + "',"
                            + "'" + txtPVGP.getText() + "',"
                            + "'" + txtSMin.getText().toUpperCase() + "',"
                            + "'" + txtSMax.getText().toUpperCase() + "',"
                            + "'" + frmPrincipal.obtenID(cboMarcas) + "',"
                            + "'" + frmPrincipal.obtenID(cboUbic) + "',"
                            + "'" + frmPrincipal.obtenID(cboCats) + "',"
                            + "'" + cboFam.getSelectedItem().toString() + "',"
                            + "'" + "null" + "',0,"
                            + "" + "0,"
                            + "'" + frmPrincipal.fechaS + "',"
                            + "'" + txtPiezas.getText() + "'");

                    llenarTabla("order by fechaRegProd desc");
                    if (resp) {
                        ArrayList<Integer> idImpuestos = null;
                        idImpuestos = frmPrincipal.miConex.obtenerIdImpuestos(impuestos);
                        boolean respuesta = frmPrincipal.miConex.insertarActualizarImpProd(idImpuestos, txtID.getText().toUpperCase());
                        if (respuesta) {
                            JOptionPane.showMessageDialog(null, "Datos Agregados con Exito");
                            vaciarCampos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Favor de verificar sus datos");
                    }
                }
            } else {
                boolean respuesta = frmPrincipal.miConex.actualizaProducto("producto set idProducto='" + txtID.getText().toUpperCase() + "'"
                        + ", codEmpresa='" + txtCD.getText().toUpperCase() + "'"
                        + ", nombreProd='" + txtNombre.getText().toUpperCase() + "'"
                        + ", estado=" + ((cboEstado.getSelectedItem().equals("ACTIVO")) ? "true" : "false") + ""
                        + ", abreviado='" + txtAb.getText().toUpperCase() + "'"
                        + ", unidadMedida='" + cboUM.getSelectedItem().toString() + "'"
                        + ", cantXUM='" + txtCPUM.getText().toUpperCase() + "'"
                        + ", existencia='" + txtExist.getText().toUpperCase() + "'"
                        + ", precioC='" + txtPC.getText().toUpperCase() + "'"
                        + ", precioProtec='" + txtPProtec.getText().toUpperCase() + "'"
                        + ", precioMin='" + txtPMin.getText().toUpperCase() + "'"
                        + ", precioProm='" + txtPProm.getText().toUpperCase() + "'"
                        + ", precioMax='" + txtPMax.getText().toUpperCase() + "'"
                        + ", PrecioGenPV='" + txtPVGP.getText().toUpperCase() + "'"
                        + ", stockMin='" + txtSMin.getText().toUpperCase() + "'"
                        + ", stockMax='" + txtSMax.getText().toUpperCase() + "'"
                        + ", idMarca='" + frmPrincipal.obtenID(cboMarcas) + "'"
                        + ", idUbicacion='" + frmPrincipal.obtenID(cboUbic) + "'"
                        + ", idCategoria='" + frmPrincipal.obtenID(cboCats) + "'"
                        + ", nombreFam='" + cboFam.getSelectedItem() + "'"
                        + ", existencia_pieza='" + txtPiezas.getText() + "'",
                        tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());

                if (respuesta) {
                    actualiza = false;
                  
                    
                    
                    
                    
//si se quita algun impuesto o se añade, entonces se debe recalcular el precio con impuesto                    
//                    ArrayList<Double> idImpuestos = null;
//                    idImpuestos = frmPrincipal.miConex.ObtenerImpuestos("where idProducto = '" + txtID.getText() + "'", 2);
//                    if (idImpuestos.size() > 1) {
//                        //actualizar
//                        //boolean respuesta
//                        
//                    } else {
//                        //insertar
//                        boolean res = frmPrincipal.miConex.insertarActualizarImpProd(idImpuestos, txtID.getText().toUpperCase());
//
//                    }

                    JOptionPane.showMessageDialog(null, "EL registro se ha actualizado con exito!");

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar el producto, validar con sistema.");
                }
                //si no existe lo inserto, de lo contrario lo actualizo

            }
            ControlBotones(false, true);
            llenarTabla("order by fechaRegProd desc");
            vaciarCampos();
            txtID.requestFocus();
        }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlBotones(false, true);
        vaciarCampos();
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ControlBotones(true, false);
        txtID.requestFocus(true);
        lblFoto.setIcon(new ImageIcon("imagenes/accept16.png"));
        vaciarCampos();
}//GEN-LAST:event_btnAgregarActionPerformed

    private void txtSMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMaxKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSMaxKeyReleased

    private void txtSMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMaxKeyTyped
        limite(txtSMax, 4, evt);
    }//GEN-LAST:event_txtSMaxKeyTyped

    private void lblUbicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUbicMouseClicked
        new altaRapida(null, true, "Ubicacion", 5, cboUbic, null);
    }//GEN-LAST:event_lblUbicMouseClicked

    private void cboUbicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboUbicKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUbicKeyReleased

    private void cboEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboEstadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoKeyReleased

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        if (evt.getClickCount() == 2) {
            if (!txtID.getText().equals(" ")) {
                JFileChooser explorador = new JFileChooser();
                explorador.showOpenDialog(this);
                rutaFoto = explorador.getSelectedFile().toString();
                System.out.println("rutaFoto: " + rutaFoto);
                ImageIcon imageIcon = new ImageIcon(rutaFoto);
                Image image = imageIcon.getImage().getScaledInstance(190, 225, java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(image));
                if (JOptionPane.showConfirmDialog(this, "Usted selecciono una imagen.\nDesea actualizar la foto del empleado?", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    frmPrincipal.miConex.setImagen(explorador.getSelectedFile().toString(), "foto", "producto", "where idProducto='" + txtID.getText() + "'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado");
            }
        }
    }//GEN-LAST:event_lblFotoMouseClicked

    private void txtPCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyPressed

}//GEN-LAST:event_txtPCKeyPressed

    private void chkIVAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkIVAStateChanged
    }//GEN-LAST:event_chkIVAStateChanged

    private void chkIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkIVAItemStateChanged
    }//GEN-LAST:event_chkIVAItemStateChanged

    private void txtPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyReleased
        chkIVA.setEnabled(true);
    }//GEN-LAST:event_txtPCKeyReleased

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
        vaciaCuadros();
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void txtCDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCDKeyTyped
        limite(txtCD, 15, evt);
    }//GEN-LAST:event_txtCDKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        limite(txtNombre, 60, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        limite(txtID, 20, evt);
    }//GEN-LAST:event_txtIDKeyTyped

    private void txtExistKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistKeyTyped

        limite(txtExist, 4, evt);
    }//GEN-LAST:event_txtExistKeyTyped

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        llenarTabla("order by nombreprod asc");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        llenarTabla("order by fechaRegProd desc");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void txtPCIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCIKeyReleased
        impuestos = new ArrayList<>();
        if (!txtCPUM.getText().equals("")) {
            //if (!txtPC.getText().equals("")) {
                //si ha seleccionado iva y algun otro impuesto del combo
                if (chkIVA.isSelected() && !cboImp.getModel().getSelectedItem().toString().equals("SELECCIONE..")) {
                    //Consultar valor de impuesto en base de datos para mandar a metodo
                    int id = obtenerIdCombo(frmPrincipal.obtenID(cboImp));
                    impuestos = frmPrincipal.miConex.ObtenerImpuestos("where idImpuesto in (" + 1 + "," + id + ")", 1);
                    //imprimirMetodo(impuestos);
                    calcularPrecios(impuestos, 1);
                }
                //si solo ha seleccionado iva
                if (chkIVA.isSelected() && cboImp.getModel().getSelectedItem().toString().equals("SELECCIONE..")) {
                    //consultar valor de iva en base de datos para mandarselo al metodo
                    int id = 1;
                    impuestos = frmPrincipal.miConex.ObtenerImpuestos("where idImpuesto = " + id + "", 1);
                    calcularPrecios(impuestos, 1);
                }
                //si solo ha seleccionado algun impuesto del combo
                if (!chkIVA.isSelected() && !cboImp.getModel().getSelectedItem().toString().equals("SELECCIONE..")) {
                    //Consultar valor de impuesto en base de datos para mandar a metodo
                    int id = obtenerIdCombo(frmPrincipal.obtenID(cboImp).trim());
                    impuestos = frmPrincipal.miConex.ObtenerImpuestos("where idImpuesto = " + id + "", 1);
                    calcularPrecios(impuestos, 1);
                }
                //si solo es la opcion selecicone, no hay impuesto al producto.
                if (!chkIVA.isSelected() && cboImp.getModel().getSelectedItem().toString().equals("SELECCIONE..")) {
                    impuestos.add(0.0);
                    calcularPrecios(impuestos, 1);
                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Favor de ingresar un Precio de Compra");
//            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor de ingresar la cantidad en el dato de EMPAQUE");
            txtCPUM.requestFocus();
        }
    }//GEN-LAST:event_txtPCIKeyReleased

    public int obtenerIdCombo(String valor) {
        int resultado = frmPrincipal.miConex.obtenerImpuesto(valor, 1);
        return resultado;
    }

    private void txtPCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCIKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPCI.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPCIKeyTyped

    private void txtPCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCIActionPerformed

    }//GEN-LAST:event_txtPCIActionPerformed

    private void txtPMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMinKeyReleased
        lblPMin.setText(utilidad(txtPMin.getText(), 1));
    }//GEN-LAST:event_txtPMinKeyReleased

    private void txtPPromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPPromKeyReleased
        lblPProm.setText(utilidad(txtPProm.getText(), 1));
    }//GEN-LAST:event_txtPPromKeyReleased

    private void txtPMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMaxKeyReleased
        lblPMax.setText(utilidad(txtPMax.getText(), 1));
    }//GEN-LAST:event_txtPMaxKeyReleased

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed

    }//GEN-LAST:event_txtIDKeyPressed

    private void txtExistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistKeyReleased

        int cpum = Integer.parseInt(txtCPUM.getText().trim());
        int exist = Integer.parseInt(txtExist.getText().trim());
        int calculo = calculoEquivalencia(cpum, exist);
        txtPiezas.setText(String.valueOf(calculo));
    }//GEN-LAST:event_txtExistKeyReleased

    private void txtPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPCActionPerformed
    }//GEN-LAST:event_txtPCActionPerformed

    private void chkIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIVAActionPerformed
    }//GEN-LAST:event_chkIVAActionPerformed

    private void cboImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboImpActionPerformed
    }//GEN-LAST:event_cboImpActionPerformed

    private void cboImpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboImpItemStateChanged
    }//GEN-LAST:event_cboImpItemStateChanged

    private void lblImpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImpMouseClicked
        new jdAltaImpuesto(null, true, null);
    }//GEN-LAST:event_lblImpMouseClicked

    private void txtPVGPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPVGPKeyReleased
        lblPPVP.setText(utilidad(txtPVGP.getText(), 2));
    }//GEN-LAST:event_txtPVGPKeyReleased

    private void txtPProtecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPProtecKeyReleased
        lblPProtec.setText(utilidad(txtPProtec.getText(), 1));
    }//GEN-LAST:event_txtPProtecKeyReleased

    private void lblPProtecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblPProtecKeyReleased

    }//GEN-LAST:event_lblPProtecKeyReleased

    private void lblFamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFamMouseEntered

    private void txtPiezasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPiezasKeyReleased
        int calculo = calculoEquivalencia(Integer.valueOf(txtCPUM.getText().trim()), Integer.valueOf(txtExist.getText().trim()));
        txtPiezas.setText(String.valueOf(calculo));
    }//GEN-LAST:event_txtPiezasKeyReleased

    private void txtExistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistKeyPressed

    private void txtExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistActionPerformed

    private void txtPCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPC.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPCKeyTyped

    private void txtPProtecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPProtecKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPProtec.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPProtecKeyTyped

    private void txtPMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMinKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPMin.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPMinKeyTyped

    private void txtPPromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPPromKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPProm.getText().indexOf(".") == -1)) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPPromKeyTyped

    private void txtPMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPMaxKeyTyped
        // TODO add your handling code here:
         char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPMax.getText().indexOf(".") == -1)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPMaxKeyTyped

    private void txtPVGPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPVGPKeyTyped
        // TODO add your handling code here:
         char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtPVGP.getText().indexOf(".") == -1)) {
            evt.consume();
        }
        
        
    }//GEN-LAST:event_txtPVGPKeyTyped

    public int calculoEquivalencia(int cpum, int exis) {
        int total = 0;
        total = cpum * exis;
        return total;
    }

    public void limite(JTextField campo, int limite, KeyEvent evt) {
        if (campo.getText().length() >= limite) {
            evt.consume();
        }
    }

    //recibir un valor extra, el cual indica si viene el calculo al momento de realizar un alto o de consultarlo.
    public void calcularPrecios(ArrayList<Double> va, int valor) {
        if (valor == 1) {
            vn = (Double.parseDouble(txtPCI.getText().trim()));
        } else {
            vn = (Double.parseDouble(txtPC.getText().trim()));
        }
        //validar si la longitud de la lista es mayor a 1, de lo contrario solo es un impuesto agregado al producto.
        if (va.size() > 1) {
            if (valor == 1) {
                int i = 0;
                for (Double va1 : va) {
                    vn = vn / va.get(i);
                    i++;
                }
                txtPC.setText(String.format("%10.2f", vn));
            } else {
                int i = 0;
                for (Double va1 : va) {
                    vn = vn * va.get(i);
                    i++;
                }
                txtPCI.setText(String.format("%10.2f", vn));
            }
        } else {
            if (valor == 1) {
                for (Double va1 : va) {
                    //si el valor del impuesto es igual a 0.0, quiere decir que no se aplica impuesto al producto
                    if (va.get(0) == 0.0) {
                        String txtPCaux = String.format("%10.2f", Double.parseDouble(txtPCI.getText().trim()));
                        txtPC.setText((txtPCaux));
                    } else {
                        //realizar operación para calcular el impuesto.
                        String txtPCaux = String.format("%10.2f", Double.parseDouble(txtPCI.getText().trim()) / va.get(0));
                        txtPC.setText((txtPCaux));

                    }
                }
            } else {
                for (Double va1 : va) {
                    //si el valor del impuesto es igual a 0.0, quiere decir que no se aplica impuesto al producto
                    if (va.get(0) == 0.0) {
                        //roge
                        String txtPCIAux = String.format("%10.2f", Double.parseDouble(txtPC.getText().trim()));
                        txtPCI.setText((txtPCIAux));
                    } else {
                        //realizar operación para calcular el impuesto.
                        String txtPCIAux = String.format("%10.2f", Double.parseDouble(txtPC.getText().trim()) * va.get(0));
                        txtPCI.setText((txtPCIAux));
                    }
                }
            }
        }
        lblPProtec.setText(utilidad(txtPProtec.getText().trim(), 1));
        lblPMin.setText(utilidad(txtPMin.getText().trim(), 1));
        lblPProm.setText(utilidad(txtPProm.getText().trim(), 1));
        lblPMax.setText(utilidad(txtPMax.getText().trim(), 1));
        lblPPVP.setText(utilidad(txtPVGP.getText().trim(), 2));

    }

    public String utilidad(String valorPorcentual, int op) {
        
        String utilidad = "";
        vn = Double.parseDouble(txtPCI.getText().trim());
        double vp = Double.parseDouble(valorPorcentual);
        if (op == 1) {
            vp = ((vp * 100) / vn) - 100;
        }
        if (op == 2) {
            vp = ((vp * Double.parseDouble(txtCPUM.getText().trim()) / vn) * 100) - 100;
        }
        
        utilidad = String.format("%10.2f", vp);
        
        return utilidad;
    }

    public static void actualizaCombo(JComboBox combo, boolean opc, Vector datos) {
        if (opc) {
            frmPrincipal.llenarCombo_ID(datos, combo);
        } else {
            frmPrincipal.llenarCombo(datos, combo);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBarCode;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboCats;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboFam;
    private javax.swing.JComboBox cboImp;
    private javax.swing.JComboBox cboMarcas;
    private javax.swing.JComboBox cboUM;
    private javax.swing.JComboBox cboUbic;
    private javax.swing.JCheckBox chkIVA;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblFam;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblImp;
    private javax.swing.JLabel lblMar;
    private javax.swing.JLabel lblPMax;
    private javax.swing.JLabel lblPMin;
    private javax.swing.JLabel lblPPVP;
    private javax.swing.JLabel lblPProm;
    private javax.swing.JLabel lblPProtec;
    private javax.swing.JLabel lblTotalP;
    private javax.swing.JLabel lblUM;
    private javax.swing.JLabel lblUbic;
    private javax.swing.JPanel panelPrecios;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtAb;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCD;
    private javax.swing.JTextField txtCPUM;
    private javax.swing.JTextField txtExist;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtPCI;
    private javax.swing.JTextField txtPMax;
    private javax.swing.JTextField txtPMin;
    private javax.swing.JTextField txtPProm;
    private javax.swing.JTextField txtPProtec;
    private javax.swing.JTextField txtPVGP;
    private javax.swing.JTextField txtPiezas;
    private javax.swing.JTextField txtSMax;
    private javax.swing.JTextField txtSMin;
    // End of variables declaration//GEN-END:variables
}
