/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * panelProducto.java
 *
 * Created on 1/03/2014, 12:18:31 AM
 */
package pruebas;

import dialog.altaRapida;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import dialog.jdImpuesto;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.*;

/**
 *
 * @author dany
 */
public class panelProducto extends javax.swing.JPanel {
    
    Vector columnas;
    String rutaImg = "";
    boolean actualiza = false;
    String rutaFoto="";
    ImageIcon defaultIcon;
    /** Creates new form panelProducto */
    public panelProducto() {
        initComponents();
        
        defaultIcon = new ImageIcon(getClass().getResource("/img/bagP.png"));
        columnas = new Vector();
        columnas.add("ID Producto");columnas.add("Codigo Empresa");columnas.add("Descripción Producto");columnas.add("Abreviat.");
        columnas.add("Existencia");columnas.add("Unidad Medida");columnas.add("Cant. U.M.");columnas.add("Precio C.");
        columnas.add("Precio V.");columnas.add("Precio 1");columnas.add("Precio 2");columnas.add("Precio 3");
        columnas.add("Precio 4");columnas.add("Stock Min.");columnas.add("Stock Max.");
        //        consultaImporte();
        columnas.add("Desc. Marca");columnas.add("Desc. Familia");columnas.add("Desc. Categoría");columnas.add("Ubicación");
        columnas.add("P. Protec.");columnas.add("P. Gral.");
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "marca", ""),  cboMarcas);
        frmPrincipal.llenarCombo(frmPrincipal.miConex.consDatosParaCampos("nombreUM", "unidadMedida", ""),cboUM);
        frmPrincipal.llenarCombo(frmPrincipal.miConex.consDatosParaCampos("nombreFam", "familia", ""), cboFam);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "categoria", ""), cboCats);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "ubicacion", ""), cboUbic);
        llenarTabla();
        ControlBotones(false, true);
    }

    public void ControlBotones(boolean op1, boolean opc2) {

        txtID.setEditable(op1);
        txtCD.setEditable(op1);
        txtNombre.setEditable(op1);
        txtAb.setEditable(op1);
        txtExist.setEditable(op1);
        //txtCPUM.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 5).toString());
        txtCPUM.setEditable(op1);
        txtPC.setEditable(op1);
        //txtPV.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 8).toString());
//        txtP1.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 9).toString());
//        txtP2.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 10).toString());
//        txtSMin.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 11).toString());
//        txtSMin.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 12).toString());
        txtSMin.setEditable(op1);
        txtSMax.setEditable(op1);
        cboMarcas.setEditable(op1);
        cboFam.setEditable(op1);
        cboCats.setEditable(op1);
        cboUbic.setEditable(op1);
        txtPProtec.setEditable(op1);
        txtPG.setEditable(op1);

        btnActualiza.setEnabled(opc2);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        tabla.setEnabled(opc2);
    }

    public void vaciaCuadros() {
        txtID.setText("");
        txtNombre.setText("");
        txtPC.setText("");
//        txtPV.setText("");
        txtExist.setText("0");
    }

//    public void ordenarColumna(int noCol) {
//        DefaultTableModel tablaPedidos = (DefaultTableModel) this.miTablaProd.getModel();
//        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tablaPedidos);
//        miTablaProd.setRowSorter(sorter);
//        miTablaProd.getRowSorter().toggleSortOrder(noCol);
//    }
    public void llenarTabla() {
        tabla.setDefaultRenderer(Object.class, new celdaRander(0));
        tabla.setRowHeight(23);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,codempresa,nombreprod,abreviado,existencia,unidadMedida,cantXUM,precioC,precioV,precio1,precio2,precio3,precio4,stockMin,stockMax,nombremarca,nombrefam,nombrecat,nombreubicacion,precioProtec,precioGen", "producto", " inner join categoria using(idcategoria)inner join marca using(idMarca) inner join ubicacion using(idubicacion) WHERE nombreProd like '%" + txtBuscar.getText().toUpperCase() + "%'"), columnas));
        tabla.setAutoCreateRowSorter(true);
        frmPrincipal.packColumn(tabla, 0,2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel35 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox();
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
        txtPProtec = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPCImp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPG = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel7.setText("Codigo o ID del Producto:");

        txtCD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCDKeyReleased(evt);
            }
        });

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
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

        jLabel2.setText("Empaque:");

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

        jLabel31.setText("Existencia:");

        txtExist.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

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

        jLabel35.setText("Estado:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));
        cboEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboEstadoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtAb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCPUM, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboUM, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(lblUM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCats, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboFam, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFam))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMar))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtSMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(txtSMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtExist)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboUbic, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUbic))
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCPUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lblUM)))
                                .addComponent(cboCats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCat, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFam)
                            .addComponent(cboFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMar)
                                .addComponent(cboMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUbic)
                            .addComponent(cboUbic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto de Producto"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagP.png"))); // NOI18N
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

        btnActualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualiza.png"))); // NOI18N
        btnActualiza.setText("Actualiza");
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/action_save.gif"))); // NOI18N
        btnGuardar.setText("GuardarG");
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
        panelPrecios.setBorder(javax.swing.BorderFactory.createTitledBorder("Precios:"));

        jLabel8.setText("Precio Compra:");

        jLabel14.setText("Precio Protección:");

        txtPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPCKeyPressed(evt);
            }
        });

        jLabel22.setText("Precio c/imp:");

        jLabel15.setText("Precio Mínimo:");

        jLabel16.setText("Precio Promedio:");

        jLabel21.setText("Precio General:");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("0%");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("0%");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("0%");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("0%");

        jLabel27.setText("Precio PV Gral/Pza:");

        jLabel28.setText("Precio PV Gral.:");

        jLabel29.setText("UTILIDAD GRAL/PZA");

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("% Utilidades:");

        javax.swing.GroupLayout panelPreciosLayout = new javax.swing.GroupLayout(panelPrecios);
        panelPrecios.setLayout(panelPreciosLayout);
        panelPreciosLayout.setHorizontalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreciosLayout.createSequentialGroup()
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPreciosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(txtPCImp, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPProtec, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPG, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField9)
                    .addComponent(jLabel29))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelPreciosLayout.setVerticalGroup(
            panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreciosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(panelPreciosLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtPCImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPreciosLayout.createSequentialGroup()
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPProtec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPreciosLayout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel32)))))
        );

        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar1.setText("Agregar Impuesto a Prod.");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualiza))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBarCode))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelPrecios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnBarCode)
                    .addComponent(jLabel6)
                    .addComponent(lblTotalP)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCDKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtCDKeyReleased

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            boolean existencia = frmPrincipal.consultas.existenciaPrevia(txtID.getText().toString());
//            if (existencia) {
//                JOptionPane.showMessageDialog(this, "Este Producto ya existe en la Base de Datos", "¡Atención Usuario!", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                txtNombre.requestFocus();
//            }
//        }
}//GEN-LAST:event_txtIDKeyReleased

    private void cboMarcasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboMarcasKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
}//GEN-LAST:event_cboMarcasKeyReleased

    private void lblCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCatMouseClicked
        new altaRapida(null, true, "Categoria", 3, cboCats,this);
}//GEN-LAST:event_lblCatMouseClicked

    private void cboFamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboFamKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_cboFamKeyReleased

    private void lblFamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFamMouseClicked
        new altaRapida(null, true, "Familia", 4, cboFam,this);
        //panelProducto.actualizaCombo(cboFam, true, frmPrincipal.miConex.consDatosParaCampos("*", "familia", ""));
}//GEN-LAST:event_lblFamMouseClicked

    private void cboCatsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCatsKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_cboCatsKeyReleased

    private void lblUMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUMMouseClicked
        new altaRapida(null, true, "UnidadMedida", 2, cboUM,this);
}//GEN-LAST:event_lblUMMouseClicked

    private void lblMarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMarMouseClicked
        new altaRapida(null, true, "Marca", 1, cboMarcas,this);
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
//        char caracter = evt.getKeyChar();
//        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtAb.getText().indexOf(".") == -1)) {
//            evt.consume();
//        }
}//GEN-LAST:event_txtAbKeyTyped

    private void txtCPUMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPUMKeyReleased
//        validaEnter(evt, txtPV);
}//GEN-LAST:event_txtCPUMKeyReleased

    private void txtCPUMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPUMKeyTyped
        char caracter = evt.getKeyChar();
        if (!(caracter >= KeyEvent.VK_0 && caracter <= KeyEvent.VK_9) && !(caracter == KeyEvent.VK_PERIOD && txtCPUM.getText().indexOf(".") == -1)) {
            evt.consume();
        }
}//GEN-LAST:event_txtCPUMKeyTyped

    private void txtSMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMinKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_txtSMinKeyReleased

    private void txtSMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMinKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_txtSMinKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txtID.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
        txtCD.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString());
        txtNombre.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString());
        txtAb.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString());
        txtExist.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());
        frmPrincipal.coincideCampo(cboUM,tabla.getModel().getValueAt(tabla.getSelectedRow(), 5).toString());
        txtCPUM.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
        txtPC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString());
        //txtPV.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 8).toString());
//        txtP1.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 9).toString());
//        txtP2.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 10).toString());
//        txtSMin.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 11).toString());
//        txtSMin.setText(miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 12).toString());
        txtSMin.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 13).toString());
        txtSMax.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 14).toString());
        frmPrincipal.coincideCampo(cboMarcas, tabla.getModel().getValueAt(tabla.getSelectedRow(), 15).toString());
        frmPrincipal.coincideCampo(cboFam, tabla.getModel().getValueAt(tabla.getSelectedRow(), 16).toString());
        frmPrincipal.coincideCampo(cboCats, tabla.getModel().getValueAt(tabla.getSelectedRow(), 17).toString());
        frmPrincipal.coincideCampo(cboUbic, tabla.getModel().getValueAt(tabla.getSelectedRow(), 18).toString());
        txtPProtec.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 19).toString());
        txtPG.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 20).toString());
//        frmPrincipal.coincideCampo(cboServs, miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 6).toString());
        frmPrincipal.cargaImagen("foto","producto","where idProducto='"+txtID.getText()+"'", lblFoto,120,150,defaultIcon);
}//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
//        organiza();
}//GEN-LAST:event_tablaKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        if (miTablaProd.getSelectedRow() >= 0) {
//            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
//                frmPrincipal.miConex.eliminaRegistro("producto", "idProducto", miTablaProd.getModel().getValueAt(miTablaProd.getSelectedRow(), 0).toString());
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
//        }
//        ControlBotones(false, true);
//        llenarTabla();
}//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarCodeActionPerformed
        if (tabla.getSelectedRow() >= 0) {
//            new GenerarCodigo(null,true,frmPrincipal.consultas,txtID.getText(),txtNombre.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
}//GEN-LAST:event_btnBarCodeActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenarTabla();
}//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_txtBuscarKeyTyped

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        if (tabla.getSelectedRow() >= 0) {
//            ControlBotones(true, false);
            btnActualiza.setEnabled(false);
//            actualiza = true;
            //llenarTabla();
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
                boolean existencia = frmPrincipal.consultas.existenciaPrevia(txtID.getText().toString());

                if (existencia) {
                    JOptionPane.showMessageDialog(null, "Este Producto ya existe en la Base de Datos.");
//                    int SoN = JOptionPane.showConfirmDialog(this, "Este Producto ya existe, el nuevo registro\n"
//                            + "incrementará la existencia, ¿Está seguro?", "¡Atención Usuario!", JOptionPane.YES_NO_OPTION);
//                    if (SoN == JOptionPane.YES_OPTION) {
//                        System.out.println("Suma producto a la BD");
////                        frmPrincipal.sumaExistencia(txtID.getText().toString());
//                    }
                } else {
//                    if (rutaImg.equals("")) {
//                        frmPrincipal.miConex.altaRegistro("producto",
//                                "'" + txtID.getText().toUpperCase() + "',"
//                                + "'" + txtNombre.getText().toUpperCase() + "',"
////                                + "'" + Double.parseDouble(txtPV.getText().toString()) + "',"
//                                + "'" + Double.parseDouble(txtPC.getText().toString()) + "',"
//                                + Integer.parseInt(nombreP.substring(0, nombreP.indexOf(" "))) + ","
//                                + Integer.parseInt(nombreC.substring(0, nombreC.indexOf(" "))) + ",null,0");
//                    } else {
                        frmPrincipal.miConex.altaRegistro("producto","'"+txtID.getText().toUpperCase() + "',"+
                                "'"+txtCD.getText().toUpperCase()+ "',"+
                                "'"+txtNombre.getText().toUpperCase()+ "',"+
                                ((cboEstado.getSelectedItem().equals("ACTIVO"))?"true":"false")+","+
                                "'"+txtAb.getText().toUpperCase()+ "',"+
                                "'"+cboUM.getSelectedItem().toString()+"',"+
                                "'"+txtCPUM.getText().toUpperCase()+ "',"+
                                "'"+txtExist.getText().toUpperCase()+ "',"+
                                //frmPrincipal.obtenID(cboUM)+ ","+
                                "'"+txtPC.getText().toUpperCase()+ "',"+
//                                "'"+Double.parseDouble(txtPC.getText())*(0.98)+ "',"+
                                "0.0,0.0,0.0,0.0,0.0,"+
                                "'"+txtPProtec.getText().toString()+ "',"+
                                "'"+txtPG.getText().toString()+"',"+
                                "'"+txtSMin.getText().toUpperCase()+ "',"+
                                "'"+txtSMax.getText().toUpperCase()+ "',"+
                                "'"+frmPrincipal.obtenID(cboMarcas)+ "',"+
                                "'"+frmPrincipal.obtenID(cboUbic)+ "',"+
                                "'"+frmPrincipal.obtenID(cboCats)+ "',"+
                                "'"+cboFam.getSelectedItem()+ "',"+
                                "null");
//                        rutaImg = "";
//                    }
                }
            } else {
                frmPrincipal.miConex.actualizaProducto(
                        "producto set nombreProd= '" + txtNombre.getText().toUpperCase() + "'"
                        + ", idProducto='" + txtID.getText().toUpperCase()
                        + ", precioC= " + txtPC.getText().toString()
                        + ", existencia= " + txtExist.getText().toString()
                        + ", idProveedor= " + nombreP.substring(0, nombreP.indexOf(" "))
                        + ", idCategoria= " + nombreC.substring(0, nombreC.indexOf(" ")) + " ",
                        tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
                actualiza = false;
            }
            ControlBotones(false, true);
            llenarTabla();
            vaciaCuadros();
            txtID.requestFocus();
        }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        vaciaCuadros();
//        ControlBotones(false, true);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ControlBotones(true, false);
        vaciaCuadros();
        txtID.requestFocus(true);
//        lblFoto.setIcon(new ImageIcon("imagenes/accept16.png"));
}//GEN-LAST:event_btnAgregarActionPerformed

    private void txtSMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMaxKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSMaxKeyReleased

    private void txtSMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSMaxKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSMaxKeyTyped

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        new jdImpuesto(null,true,txtID.getText(),txtNombre.getText());
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void lblUbicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUbicMouseClicked
        new altaRapida(null, true, "Ubicacion", 5, cboUbic,null);
    }//GEN-LAST:event_lblUbicMouseClicked

    private void cboUbicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboUbicKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUbicKeyReleased

    private void cboEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboEstadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoKeyReleased

    private void txtPCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            txtPCImp.setText(""+Double.parseDouble(txtPC.getText())*(1.5));
            txtPC.requestFocus();
        }
    }//GEN-LAST:event_txtPCKeyPressed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        if (evt.getClickCount() == 2) {
            if (!txtID.getText().equals(" ")) {
                JFileChooser explorador = new JFileChooser();
                explorador.showOpenDialog(this);
                rutaFoto = explorador.getSelectedFile().toString();
                ImageIcon imageIcon = new ImageIcon(rutaFoto);
                Image image = imageIcon.getImage().getScaledInstance(190, 225, java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(image));

                if (JOptionPane.showConfirmDialog(this, "Usted selecciono una imagen.\nDesea actualizar la foto del empleado?", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    frmPrincipal.miConex.setImagen(explorador.getSelectedFile().toString(), "foto", "producto", "where idProducto='" + txtID.getText()+"'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado");
            }
        }
    }//GEN-LAST:event_lblFotoMouseClicked

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
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBarCode;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboCats;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboFam;
    private javax.swing.JComboBox cboMarcas;
    private javax.swing.JComboBox cboUM;
    private javax.swing.JComboBox cboUbic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblFam;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMar;
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
    private javax.swing.JTextField txtPCImp;
    private javax.swing.JTextField txtPG;
    private javax.swing.JTextField txtPProtec;
    private javax.swing.JTextField txtSMax;
    private javax.swing.JTextField txtSMin;
    // End of variables declaration//GEN-END:variables
}
