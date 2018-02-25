package panel;

//import ConfComandos.JTextField_DCC;
//import Atxy2k.CustomTextField.RestrictedTextField;
import dialog.jdRelacionRA;
import dialog.jdDias;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.Image;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class panelClientes_2 extends javax.swing.JPanel {
    ImageIcon defaultIcon;
    Vector columnas;
    String rutaImg = "";
    boolean actualiza = false, resp=false;
    String rutaFoto = "";

    public panelClientes_2() {
        initComponents();
        //RestrictedTextField formatotxt = new RestrictedTextField(txtCURP);
        //formatotxt.setLimit(5);
        //formatotxt.setOnlyNums(true);
        defaultIcon = new ImageIcon(getClass().getResource("/img/clienteShop.png"));
        columnas = new Vector();
        columnas.add("ID");
        columnas.add("RAZON SOCIAL");
        columnas.add("NOMBRE CLIENTE");
        columnas.add("FECHA NAC.");
        columnas.add("MONT. CRED.");
        columnas.add("DIAS CRED.");
        columnas.add("DIAS");
        columnas.add("HORARIO");
        columnas.add("RUTA");
        columnas.add("AGENTE");
        columnas.add("TIPO");
        columnas.add("CALLE");
        columnas.add("N. INT.");
        columnas.add("N. EXT.");
        columnas.add("COLONIA");
        columnas.add("ESTADO");
        columnas.add("POBLACION");
        columnas.add("C.P.");
        columnas.add("TEL. LOCAL");
        columnas.add("CELULAR");
        columnas.add("EMAIL");
        columnas.add("FAX");
        columnas.add("CURP");
        columnas.add("DESC.");
        columnas.add("CUENTA BANC.");
        columnas.add("RFC");
        columnas.add("credito");
        columnas.add("contado");
        columnas.add("factura");
        columnas.add("remision");
        columnas.add("FECHA REG.");
        columnas.add("CONTACTO");
        columnas.add("OBSERVACIONES");
        columnas.add("ESTADO");
        chkNRem.setSelected(true);
        llenarTabla("");
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "ruta", ""), cboRuta);
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idR_A,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp)", "ruta_agente", "inner join empleado using(idempleado) inner join ruta using(idruta) where idRuta='" + (cboRuta.getSelectedItem().toString().substring(cboRuta.getSelectedItem().toString().lastIndexOf("-") + 1)) + "'"), cboAgente);
        ControlBotones(false, true);
    }

    

    public void ControlBotones(boolean op1, boolean opc2) {

        txtIDC.setEnabled(op1);
        txtIDC.setEnabled(op1);
        txtRS.setEnabled(op1);
        txtNombreC.setEnabled(op1);
        txtCURP.setEnabled(op1);
        txtFN.setEnabled(op1);
        txtContact.setEnabled(op1);
        txtDC.setEnabled(op1);
        txtDNI.setEnabled(op1);
        txtDNE.setEnabled(op1);
        txtDCol.setEnabled(op1);
        txtCP.setEnabled(op1);
        txtTL.setEnabled(op1);
        txtTC.setEnabled(op1);
        txtEmail.setEnabled(op1);
        txtFAX.setEnabled(op1);
        txtRFC.setEnabled(op1);
        txtCB.setEnabled(op1);
        txtLC.setEnabled(op1);
        txtPlazoP.setEnabled(op1);
        txtLPago.setEnabled(op1);
        chkCredito.setSelected(false);
        chkContado.setSelected(true);
        chkFactura.setSelected(false);
        chkNRem.setSelected(false);
        txtDesc.setEnabled(op1);
        txtDias.setEnabled(op1);
        txtHAC.setEnabled(op1);

        btnActualiza.setEnabled(opc2);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        tabla.setEnabled(opc2);
    }

    public void vaciaCuadros() {
        txtIDC.setText("");
        txtRS.setText("");
        txtNombreC.setText("");
        txtCURP.setText("");
        txtFN.setText("");
        txtContact.setText("");
        txtDC.setText("");
        txtDNI.setText("");
        txtDNE.setText("");
        txtDCol.setText("");
        txtCP.setText("");
        txtTL.setText("");
        txtTC.setText("");
        txtEmail.setText("");
        txtFAX.setText("");
        txtRFC.setText("");
        txtCB.setText("");
        txtLC.setText("");
        txtPlazoP.setText("");
        txtLPago.setText("");
        txtDesc.setText("");
        txtDias.setText("");
        txtHAC.setText("");
    }

//    public void ordenarColumna(int noCol) {
//        DefaultTableModel tablaPedidos = (DefaultTableModel) this.miTablaProd.getModel();
//        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tablaPedidos);
//        miTablaProd.setRowSorter(sorter);
//        miTablaProd.getRowSorter().toggleSortOrder(noCol);
//    }
    public void llenarTabla(String condicion) {
        tabla.setDefaultRenderer(Object.class, new celdaRander(-1));
        tabla.setRowHeight(25);
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idCliente,razonSocialCliente,nombreCli,fechaNac,limiteMontoCred,limiteDiasCred,dias,horario,descRuta,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp),tipoCliente,dcalleCli,dnoInt,dnoExt,coloniaCli,estadoCli,poblacionCli,cP ,telLCli,telCCli,email,fax,curp,descuentoC,cuentaBanco,rfcCliente,credito,contado,factura,remision,fechaRegistro,contacto,observaciones,IF(estadoCliente='1','ACTIVO','INACTIVO')", "cliente", "inner join ruta_agente using(idR_A) inner join ruta using(idRuta)inner join empleado using(idEmpleado) WHERE nombreCli like '%" + txtBuscar.getText().toUpperCase() + "%' " + condicion), columnas));
        tabla.setAutoCreateRowSorter(true);
        frmPrincipal.packColumn(tabla,0,2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        txtCURP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDC = new javax.swing.JTextField();
        txtRS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        txtFN = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboPobC = new javax.swing.JComboBox();
        txtCP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDNE = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        txtDCol = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        cboEstC = new javax.swing.JComboBox();
        txtTL = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtFAX = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        cboTC = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtCB = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtTC = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cboAgente = new javax.swing.JComboBox();
        cboRuta = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        lblFam1 = new javax.swing.JLabel();
        lblFam2 = new javax.swing.JLabel();
        chkCredito = new javax.swing.JCheckBox();
        chkContado = new javax.swing.JCheckBox();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txtLC = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtPlazoP = new javax.swing.JTextField();
        txtLPago = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        chkNRem = new javax.swing.JCheckBox();
        chkFactura = new javax.swing.JCheckBox();
        jLabel47 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        btnDias1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtHAC = new javax.swing.JFormattedTextField();
        btnLimpiar = new javax.swing.JButton();
        cboStatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel1.setText("Codigo:");

        jLabel5.setText("Razon Social:");

        jLabel3.setText("Nombre Completo:");

        jLabel30.setText("Fecha de Nac.:");

        jLabel7.setText("Contacto:");

        jLabel4.setText("CURP:");

        try {
            txtFN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Calle");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Codigo postal");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Población");

        jLabel12.setText("Localidad:");

        cboPobC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ESPINAL", "CHICAPA", "CD. IXTEPEC", "IXTALTEPEC", "TEHUANTEPEC", "JUCHITAN", "SALINA CRUZ", "SAN DIONISIO", "UNION HIDALGO" }));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Estado");

        txtDNE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNEActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("No.Ext.");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel19.setText("Domicilio comercial:");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Colonia");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("No.Int");

        txtDCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDColActionPerformed(evt);
            }
        });

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        cboEstC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OAXACA" }));

        jLabel33.setText("Telefonos:");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Local");

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFCKeyReleased(evt);
            }
        });

        cboTC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "REMISIONES", "MOSTRADOR" }));

        jLabel35.setText("Tipo Cliente:");

        jLabel36.setText("Cuenta bancaria:");

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("RFC: ");

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("FAX");

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Email");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Celular");

        jLabel41.setText("Ruta:");

        cboAgente.setEditable(true);
        cboAgente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboRuta.setEditable(true);
        cboRuta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRutaActionPerformed(evt);
            }
        });

        jLabel42.setText("Agente:");

        lblFam1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFam1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblFam1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFam1MouseClicked(evt);
            }
        });

        lblFam2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFam2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblFam2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFam2MouseClicked(evt);
            }
        });

        chkCredito.setBackground(new java.awt.Color(255, 255, 255));
        chkCredito.setText("Credito");

        chkContado.setBackground(new java.awt.Color(255, 255, 255));
        chkContado.setText("Contado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRS, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContact, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFN, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDNE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtDCol, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEstC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPobC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkCredito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkContado))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFAX, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboTC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFam1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAgente, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFam2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCURP)
                        .addComponent(jLabel30)
                        .addComponent(txtFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel11)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPobC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cboEstC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCredito)
                    .addComponent(chkContado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40))
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txtCB)
                        .addComponent(jLabel35)
                        .addComponent(cboTC))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFam1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(cboAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFam2))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto de Cliente"));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clienteShop.png"))); // NOI18N
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jLabel6.setText("Cant. Clientes: ");

        jLabel9.setText("Buscar Cliente: ");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Condiciones de Venta"));

        jLabel43.setText("Limite de Credito: $");

        jLabel44.setText("Plazo de pago: $");

        txtPlazoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlazoPKeyReleased(evt);
            }
        });

        jLabel45.setText("Precio de pago: $");

        chkNRem.setBackground(new java.awt.Color(255, 255, 255));
        chkNRem.setText("Nota de Remision");

        chkFactura.setBackground(new java.awt.Color(255, 255, 255));
        chkFactura.setText("Factura");

        jLabel47.setText("Descuento %:");

        txtDesc.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDesc, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkFactura, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkNRem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLC, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPlazoP, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLPago, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlazoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkNRem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel46.setText("Días de Atención:");

        btnDias1.setText("Días");
        btnDias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDias1ActionPerformed(evt);
            }
        });

        jLabel29.setText("Hora de Atención:");

        try {
            txtHAC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHACActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHAC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDias, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDias1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDias1)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR DATOS");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - ACTIVO Y PERMITIDO", "1 - ACTIVO EN CREDITO, SEGUIR VENDIENDO", "2 - ACTIVO PERO SOLO COBRANZA", "3 - INACTIVO POR NO PAGAR, COBRAR", "4 - INACTIVO CLIENTE INCUMPLIDO, NO VENDER" }));

        jLabel2.setText("Estado:");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("POR FECHA");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("POR NOMBRE");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboStatus, 0, 482, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualiza))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBarCode)))
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
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnBarCode)
                    .addComponent(jLabel6)
                    .addComponent(lblTotalP)
                    .addComponent(jLabel9)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txtIDC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
        txtRS.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString());
        txtNombreC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString());
        String fena = tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString();
        txtFN.setText(fena.substring(8) + "/" + fena.substring(5, 7) + "/" + fena.substring(0, 4));
        //System.out.println(frmPrincipal.parseFecha();
        //txtFN.setText(frmPrincipal.parseFecha(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString()));
        txtLC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());
        txtPlazoP.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 5).toString());
        txtDias.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
        txtHAC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString());
        frmPrincipal.coincideCampo(cboRuta,tabla.getModel().getValueAt(tabla.getSelectedRow(), 8).toString());
        frmPrincipal.coincideCampo(cboAgente,tabla.getModel().getValueAt(tabla.getSelectedRow(), 9).toString());
        frmPrincipal.coincideCampo(cboTC,tabla.getModel().getValueAt(tabla.getSelectedRow(), 10).toString());
        txtDC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 11).toString());
        txtDNI.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 12).toString());
        txtDNE.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 13).toString());
        txtDCol.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 14).toString());
        frmPrincipal.coincideCampo(cboEstC,tabla.getModel().getValueAt(tabla.getSelectedRow(), 15).toString());
        frmPrincipal.coincideCampo(cboPobC,tabla.getModel().getValueAt(tabla.getSelectedRow(), 16).toString());
        txtCP.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 17).toString());
        txtTL.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 18).toString());
        txtTC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 19).toString());
        txtEmail.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 20).toString());
        txtFAX.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 21).toString());
        txtCURP.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 22).toString());
        txtDesc.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 23).toString());
        txtCB.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 24).toString());
        txtRFC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 25).toString());
        System.out.println(Boolean.parseBoolean(tabla.getModel().getValueAt(tabla.getSelectedRow(), 26).toString()));
        //chkCredito.setSelected(Boolean.parseBoolean(tabla.getModel().getValueAt(tabla.getSelectedRow(), 26).toString()));
        //chkContado.setSelected(Boolean.parseBoolean(tabla.getModel().getValueAt(tabla.getSelectedRow(), 27).toString()));
        //chkFactura.setSelected(Boolean.parseBoolean(tabla.getModel().getValueAt(tabla.getSelectedRow(), 28).toString()));
        //chkNRem.setSelected(Boolean.parseBoolean(tabla.getModel().getValueAt(tabla.getSelectedRow(), 29).toString()));
        txtContact.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 31).toString());
        frmPrincipal.cargaImagen("foto", "cliente", "where idCliente='" + txtIDC.getText() + "'", lblFoto, 128,128,defaultIcon);
}//GEN-LAST:event_tablaMouseClicked

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
//        organiza();
}//GEN-LAST:event_tablaKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.eliminaRegistro("cliente", "idCliente", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
        ControlBotones(false, true);
        llenarTabla("");
}//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        llenarTabla("");
}//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_txtBuscarKeyTyped

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            ControlBotones(true, false);
            txtIDC.setEnabled(false);
            btnActualiza.setEnabled(false);
            actualiza = true;
            //llenarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un PRODUCTO!!!");
        }
}//GEN-LAST:event_btnActualizaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtRS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar la RAZON SOCIAL", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtRS.requestFocus();
        } else if (txtContact.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtContact.requestFocus();
        } else if (txtDC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtDC.requestFocus();
        } else if (txtDNI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtDNI.requestFocus();
        } else if (txtDCol.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtDCol.requestFocus();
        } else if (txtCP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtCP.requestFocus();
        } else if (txtTL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtTL.requestFocus();
        } else if (txtLC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtLC.requestFocus();
        } else if (txtPlazoP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtPlazoP.requestFocus();
        } else if (txtDias.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtDias.requestFocus();
        } else if (txtHAC.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el NOMBRE DEL CLIENTE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtHAC.requestFocus();
        } else {
            if (!actualiza) {
                boolean existencia = frmPrincipal.consultas.existenciaPrevia(txtIDC.getText().toString());

                if (existencia) {
                    JOptionPane.showMessageDialog(null, "Este Cliente ya existe en la Base de Datos.");
                } else {
                    //System.out.println(frmPrincipal.fFSQL.format(new Date(txtFN.getText().toUpperCase().toString())));
                    resp = frmPrincipal.miConex.altaRegistro("cliente",
                            "null,"
                            + "'" + txtRS.getText().toUpperCase() + "',"
                            + "'" + txtNombreC.getText().toUpperCase() + "',"
                            + "'" + frmPrincipal.fFSQL.format(new Date(txtFN.getText().toUpperCase().toString())) + "',"
                            + "'" + txtContact.getText().toUpperCase() + "',"
                            + "'" + txtDC.getText().toUpperCase() + "',"
                            + "'" + txtDNI.getText().toUpperCase() + "',"
                            + "'" + txtDNE.getText().toUpperCase() + "',"
                            + "'" + txtDCol.getText().toUpperCase() + "',"
                            + "'" + cboEstC.getSelectedItem().toString() + "',"
                            + "'" + cboPobC.getSelectedItem().toString() + "',"
                            + "'" + txtCP.getText().toUpperCase() + "',"
                            + "'" + txtTL.getText().toUpperCase() + "',"
                            + "'" + txtTC.getText().toUpperCase() + "',"
                            + "'" + txtEmail.getText() + "',"
                            + "'" + txtFAX.getText().toUpperCase() + "',"
                            + "'" + txtCURP.getText().toUpperCase() + "',"
                            + "'" + Integer.parseInt(txtDesc.getText()) + "',"
                            + "'" + txtCB.getText().toUpperCase() + "',"
                            + "'" + txtRFC.getText().toUpperCase() + "',"
                            + "'" + txtLC.getText().toUpperCase() + "',"
                            + "'" + txtPlazoP.getText().toUpperCase() + "',"
                            //+ "'" + txtLP.getText().toUpperCase() + "',"
                            + "'',"
                            + "'" + txtDias.getText().toUpperCase() + "',"
                            + "'" + txtHAC.getText().toUpperCase() + "',"
                            + ((cboStatus.getSelectedItem().equals("ACTIVO")) ? "true" : "false") + ","
                            + "'" + frmPrincipal.obtenID(cboAgente) + "',"
                            + "'" + cboTC.getSelectedItem().toString() + "',"
                            + ((chkCredito.isSelected()) ? "true" : "false") + ","
                            + ((chkContado.isSelected()) ? "true" : "false") + ","
                            + ((chkFactura.isSelected()) ? "true" : "false") + ","
                            + ((chkNRem.isSelected()) ? "true" : "false") + ","
                            + "'" + frmPrincipal.fechaS + "',"
                            + "null");
                }
            } else {
                
                resp = frmPrincipal.miConex.actualizaRegistro("cliente",
                            "razonSocialCliente='" + txtRS.getText().toUpperCase() + "',"
                            + "nombreCli='" + txtNombreC.getText().toUpperCase() + "',"
                            + "fechaNac='" + frmPrincipal.fFSQL.format(new Date(txtFN.getText().toUpperCase().toString())) + "',"
                            + "contacto='" + txtContact.getText().toUpperCase() + "',"
                            + "dcalleCli='" + txtDC.getText().toUpperCase() + "',"
                            + "dnoInt='" + txtDNI.getText().toUpperCase() + "',"
                            + "dnoExt='" + txtDNE.getText().toUpperCase() + "',"
                            + "coloniaCli='" + txtDCol.getText().toUpperCase() + "',"
                            + "estadoCli='" + cboEstC.getSelectedItem().toString() + "',"
                            + "estadoCli='" + cboPobC.getSelectedItem().toString() + "',"
                            + "cP='" + txtCP.getText().toUpperCase() + "',"
                            + "telLCli='" + txtTL.getText().toUpperCase() + "',"
                            + "telCCli='" + txtTC.getText().toUpperCase() + "',"
                            + "email='" + txtEmail.getText() + "',"
                            + "fax='" + txtFAX.getText().toUpperCase() + "',"
                            + "email='" + txtCURP.getText().toUpperCase() + "',"
                            + "descuentoC='" + txtDesc.getText().toUpperCase() + "',"
                            + "cuentaBanco='" + txtCB.getText().toUpperCase() + "',"
                            + "rfcCliente='" + txtRFC.getText().toUpperCase() + "',"
                            + "limiteMontoCred='" + txtLC.getText().toUpperCase() + "',"
                            + "limiteDiasCred='" + txtPlazoP.getText().toUpperCase() + "',"
                            //+ "'" + txtLP.getText().toUpperCase() + "',"
                            //+ "observaciones='',"
                            + "dias='" + txtDias.getText().toUpperCase() + "',"
                            + "horario='" + txtHAC.getText().toUpperCase() + "',"
                            + "estadoCliente=" + ((cboStatus.getSelectedItem().equals("ACTIVO")) ? "true" : "false") + ","
                            + "idR_A='" + frmPrincipal.obtenID(cboAgente) + "',"
                            + "tipoCliente='" + cboTC.getSelectedItem().toString() + "',"
                            + "credito="+((chkCredito.isSelected()) ? "true" : "false") + ","
                            + "contado=" + ((chkContado.isSelected()) ? "true" : "false") + ","
                            + "factura=" + ((chkFactura.isSelected()) ? "true" : "false") + ","
                            + "remision=" + ((chkNRem.isSelected()) ? "true" : "false") + "",
                            "idCliente="+txtIDC.getText());
                actualiza=false;
                
            }
            ControlBotones(false, true);
            llenarTabla("order by fechaRegistro desc");
            if(resp)
                vaciaCuadros();
            txtIDC.requestFocus();
            resp=false;
        }
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vaciaCuadros();
        ControlBotones(false, true);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ControlBotones(true, false);
        txtIDC.setText(frmPrincipal.miConex.ConsultaDato("max(idCliente)+1", "cliente",""));
        txtIDC.setEnabled(false);
        //vaciaCuadros();
        txtRS.requestFocus(true);
//        lblFoto.setIcon(new ImageIcon("imagenes/accept16.png"));
}//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDNEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNEActionPerformed
}//GEN-LAST:event_txtDNEActionPerformed

    private void txtDColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDColActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtDColActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtDNIActionPerformed

    private void lblFam1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFam1MouseClicked
        new jdRelacionRA(null,true,cboRuta);
    }//GEN-LAST:event_lblFam1MouseClicked

    private void lblFam2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFam2MouseClicked
        new jdRelacionRA(null,true,cboAgente);
    }//GEN-LAST:event_lblFam2MouseClicked

    private void btnDias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDias1ActionPerformed
        new jdDias(null,true,txtDias);
    }//GEN-LAST:event_btnDias1ActionPerformed

    private void txtHACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHACActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHACActionPerformed

    private void btnBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarCodeActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            //            new GenerarCodigo(null,true,frmPrincipal.consultas,txtID.getText(),txtNombre.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un CLIENTE!!!");
        }
}//GEN-LAST:event_btnBarCodeActionPerformed

    private void cboRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRutaActionPerformed
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idR_A,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp)", "ruta_agente", "inner join empleado using(idempleado) inner join ruta using(idruta) where idRuta='" + (cboRuta.getSelectedItem().toString().substring(cboRuta.getSelectedItem().toString().lastIndexOf("-") + 1)) + "'"), cboAgente);
    }//GEN-LAST:event_cboRutaActionPerformed

    private void txtPlazoPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlazoPKeyReleased
        txtLPago.setText("" + Double.parseDouble(txtLC.getText()) / Double.parseDouble(txtPlazoP.getText()));
    }//GEN-LAST:event_txtPlazoPKeyReleased

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        if (evt.getClickCount() == 2) {
            if (!txtIDC.getText().equals(" ")) {
                JFileChooser explorador = new JFileChooser();
                explorador.showOpenDialog(this);
                rutaFoto = explorador.getSelectedFile().toString();
                ImageIcon imageIcon = new ImageIcon(rutaFoto);
                Image image = imageIcon.getImage().getScaledInstance(150, 140, java.awt.Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(image));

                if (JOptionPane.showConfirmDialog(this, "Usted selecciono una imagen.\nDesea actualizar la foto del empleado?", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    frmPrincipal.miConex.setImagen(explorador.getSelectedFile().toString(), "foto", "cliente", "where idCliente='" + txtIDC.getText() + "'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un empleado");
            }
        }
    }//GEN-LAST:event_lblFotoMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        vaciaCuadros();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        llenarTabla("order by fechaRegistro desc");
}//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        llenarTabla("order by nombrecli asc");
}//GEN-LAST:event_jRadioButton4ActionPerformed

    private void txtRFCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyReleased
        if(txtRFC.getText().trim().toUpperCase().equals("NO")){
            chkFactura.setEnabled(false);
        }else{
            chkFactura.setEnabled(true);
        }
    }//GEN-LAST:event_txtRFCKeyReleased

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
    private javax.swing.JButton btnBarCode;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDias1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboAgente;
    private javax.swing.JComboBox cboEstC;
    private javax.swing.JComboBox cboPobC;
    private javax.swing.JComboBox cboRuta;
    private javax.swing.JComboBox cboStatus;
    private javax.swing.JComboBox cboTC;
    private javax.swing.JCheckBox chkContado;
    private javax.swing.JCheckBox chkCredito;
    private javax.swing.JCheckBox chkFactura;
    private javax.swing.JCheckBox chkNRem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFam1;
    private javax.swing.JLabel lblFam2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblTotalP;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCB;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtDCol;
    private javax.swing.JTextField txtDNE;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFAX;
    private javax.swing.JFormattedTextField txtFN;
    private javax.swing.JFormattedTextField txtHAC;
    private javax.swing.JTextField txtIDC;
    private javax.swing.JTextField txtLC;
    private javax.swing.JTextField txtLPago;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtPlazoP;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRS;
    private javax.swing.JTextField txtTC;
    private javax.swing.JTextField txtTL;
    // End of variables declaration//GEN-END:variables
}
