package panel;

import dialog.vizProd;
import conf_comandos.JTable_Conv_DCC;
import difamserv.Conversion;
import difamserv.frmPrincipal;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JFileChooser;
//import quicktime.sound.SoundConstants;

public class panelPedidos extends javax.swing.JPanel {

    private ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/img/clienteShop.png"));
    private DefaultTableModel modelo = new DefaultTableModel();
    private BufferedReader br = null;
    private double montoT = 0.00;
    private String idV = "15";
    private HashMap param = new HashMap();
    private String cadena = "";
    private ArrayList gananciaEmpresa = new ArrayList();

    private double[] saldoAgente = new double[1];

    public void focusID() {
        txtID.requestFocus(true);
    }

    public panelPedidos() {
        initComponents();
        rbtnCont.setSelected(true);
        lblFEmi.setText(frmPrincipal.lblFecha.getText());
        asignarModelo();
        txtID.requestFocus(true);
    }

    public void asignarModelo() {
        tabla.setRowHeight(20);
        modelo = new DefaultTableModel();
        modelo.addColumn("NO.");
        modelo.addColumn("ID PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("U. MEDIDA");
        modelo.addColumn("DESCRIPCIÓN DEL PRODUCTO");
        modelo.addColumn("GANANCIA");
        modelo.addColumn("P.V. MIN.");
        modelo.addColumn("P.V. MAX.");
        modelo.addColumn("P. VENTA");
        modelo.addColumn("IMPORTE.");
        tabla.setModel(modelo);

//        tabla.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "SaveAction");
//        tabla.getActionMap().put("SaveAction", new AbstractAction() {
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Control de tabla");
//            }
//        });
    }

    public String sumarDias(String fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date fechaD = frmPrincipal.fF.parse(fecha);
            calendar.setTime(fechaD);
            calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        } catch (ParseException ex) {
            Logger.getLogger(panelPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return frmPrincipal.fF.format((Date) calendar.getTime()); // Devuelve el objeto Date con los nuevos días añadidos

    }

    public void ganEmpresa(int idProd, int precioMin, int ventaEmp, int cant) {

        double pC = 0.00, pM = 0.00, vE = 0.00, r = 0.00, cantP = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            cantP = JTable_Conv_DCC.convStringDouble(tabla, i, cant);
            pC = Double.parseDouble(frmPrincipal.miConex.ConsultaDato("precioC", "producto", "where idProducto='" + tabla.getValueAt(i, idProd).toString() + "'"));//JTable_Conv_DCC.convStringDouble(tabla, i, precioC);
            pM = JTable_Conv_DCC.convStringDouble(tabla, i, precioMin);
            vE = JTable_Conv_DCC.convStringDouble(tabla, i, ventaEmp);
            if (vE < pM) {
                System.out.println("EL PRECIO VENDIDO ES MENOR AL MINIMO");
                r = (vE - pC) * cantP;
                gananciaEmpresa.set(i, r);
                System.out.println("Resultado: " + r);
            } else {
                r = (pM - pC) * cantP;
                gananciaEmpresa.set(i, r);
                System.out.println("Resultado: " + r);
            }
            System.out.println("Array[" + i + "]: <" + gananciaEmpresa.get(i) + ">");
        }
    }

    public void verificaTotal() {
        System.out.println("Verificando el total");
        Conversion conv = new Conversion();
        double valorTotal = 0.00;
        double importe = 0.00;
        double ganancia = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.getModel().setValueAt(i + 1, i, 0);
            importe = Double.parseDouble(tabla.getModel().getValueAt(i, 2).toString()) * Double.parseDouble(tabla.getModel().getValueAt(i, tabla.getColumnCount() - 2).toString());
            valorTotal += importe;
            tabla.getModel().setValueAt(String.format("%10.2f", importe).trim(), i, tabla.getColumnCount() - 1);
            importe = 0.00;
            ganancia += Double.parseDouble(tabla.getModel().getValueAt(i, 5).toString());
        }

        saldoAgente[0] = ganancia;
        System.out.println("saldoAgente[0]: " + saldoAgente[0]);

        txtGan.setText(String.format("%10.2f", ganancia).trim());
        txtTotal.setText((String.format("%10.2f", valorTotal).trim()));
        lblTotal.setText("$ " + (String.format("%10.2f", valorTotal)).trim());
        montoT = valorTotal;

        lblMontoLetra.setText(conv.letra("" + montoT));
        if (montoT > Double.parseDouble((txtLimite.getText().toString()))) {
            txtTotal.setForeground(Color.RED);
        } else {
            txtTotal.setForeground(Color.BLACK);
        }
        if (txtGan.getText().contains("-")) {
            JOptionPane.showMessageDialog(null, "Favor de revisar tu calculo, tu ganancia es incorrecta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoCondicion = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtRznS = new javax.swing.JLabel();
        txtRuta = new javax.swing.JLabel();
        txtPoblacion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtDirec = new javax.swing.JLabel();
        txtLimite = new javax.swing.JLabel();
        txtDCred = new javax.swing.JLabel();
        lblFEmi = new javax.swing.JLabel();
        txtNAgente = new javax.swing.JLabel();
        rbtnCont = new javax.swing.JRadioButton();
        lblFVen = new javax.swing.JLabel();
        rbtnCred = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblMontoLetra = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCCant = new javax.swing.JButton();
        btnProd = new javax.swing.JButton();
        btnElim = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnPLista = new javax.swing.JButton();
        txtIDP = new javax.swing.JTextField();
        chkDesc = new javax.swing.JCheckBox();
        lblIDP = new javax.swing.JLabel();
        txtGan = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Maiandra GD", 0, 12)); // NOI18N
        jLabel8.setText("Lista de Productos:");

        txtNombre.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombre.setText(" ");
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtTotal.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotal.setText(" ");
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtRznS.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtRznS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRznS.setText(" ");
        txtRznS.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Razon Social:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtRuta.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRuta.setText(" ");
        txtRuta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ruta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtPoblacion.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtPoblacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPoblacion.setText(" ");
        txtPoblacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Población:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clienteShop.png"))); // NOI18N
        jPanel1.add(lblFoto, java.awt.BorderLayout.CENTER);

        txtID.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setText(" ");
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID Cliente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 0, 12))); // NOI18N
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        txtDirec.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtDirec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDirec.setText(" ");
        txtDirec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtLimite.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtLimite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLimite.setText(" ");
        txtLimite.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Límite de Credito:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtDCred.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtDCred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDCred.setText(" ");
        txtDCred.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Días Cred:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        lblFEmi.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblFEmi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFEmi.setText(" ");
        lblFEmi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Emisión:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        txtNAgente.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        txtNAgente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNAgente.setText(" ");
        txtNAgente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Agente:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        rbtnCont.setBackground(new java.awt.Color(255, 255, 255));
        grupoCondicion.add(rbtnCont);
        rbtnCont.setText("CONTADO");

        lblFVen.setFont(new java.awt.Font("Lao UI", 0, 13)); // NOI18N
        lblFVen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFVen.setText(" ");
        lblFVen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de Vencimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        rbtnCred.setBackground(new java.awt.Color(255, 255, 255));
        grupoCondicion.add(rbtnCred);
        rbtnCred.setText("CRÉDITO");

        tabla.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        lblMontoLetra.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        lblMontoLetra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoLetra.setText(" ");
        lblMontoLetra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto en letras:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        lblTotal.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText(" ");
        lblTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        btnCCant.setText("CAMBIAR CANT. [F3]");
        btnCCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCantActionPerformed(evt);
            }
        });

        btnProd.setText("BUSCAR PROD. [F2]");
        btnProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdActionPerformed(evt);
            }
        });

        btnElim.setText("ELIMINAR PROD. [F5]");
        btnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR LISTA [F12]");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPLista.setText("CAMBIAR PRECIO DE VENTA [F4]");
        btnPLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPListaActionPerformed(evt);
            }
        });

        txtIDP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDPKeyReleased(evt);
            }
        });

        chkDesc.setBackground(new java.awt.Color(255, 255, 255));
        chkDesc.setText("Aplicar Descuento");
        chkDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDescActionPerformed(evt);
            }
        });

        lblIDP.setText("ID PROD.:");

        txtGan.setFont(new java.awt.Font("Lao UI", 1, 15)); // NOI18N
        txtGan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGan.setText(" ");
        txtGan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ganancia:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Maiandra GD", 0, 12))); // NOI18N

        btnExaminar.setText("EXAMINAR ARCHIVO");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRznS, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNAgente, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFEmi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFVen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDCred, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnCred)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnCont)
                        .addGap(18, 18, 18)
                        .addComponent(chkDesc)
                        .addGap(18, 18, 18)
                        .addComponent(lblIDP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                        .addComponent(btnExaminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCCant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtGan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMontoLetra, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotal)
                                .addComponent(txtLimite)
                                .addComponent(txtDCred))
                            .addComponent(txtDirec))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtRznS)
                                .addComponent(txtNAgente))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFEmi)
                                .addComponent(lblFVen))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbtnCred)
                    .addComponent(rbtnCont)
                    .addComponent(txtIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDesc)
                    .addComponent(lblIDP)
                    .addComponent(btnExaminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblMontoLetra)
                    .addComponent(txtGan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnElim)
                    .addComponent(btnCCant)
                    .addComponent(btnProd)
                    .addComponent(btnPLista))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        add(jScrollPane2, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtGan.getText().contains("-")) {
            JOptionPane.showMessageDialog(null, "Favor de revisar tu calculo, tu ganancia es incorrecta");
        } else {
            frmPrincipal.iconoCerrar();
            if (Double.parseDouble(txtLimite.getText()) >= Double.parseDouble(txtTotal.getText())) {
                altaPedido();
            } else {
                if (JOptionPane.showConfirmDialog(null, "Monto de Compra excede el monto de crédito permitido!\nEstás seguro de permitir el registro?", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    altaPedido();
                }
            }
        }
}//GEN-LAST:event_btnGuardarActionPerformed
    //mètodo para reemplazar las "," en los valores double.
//    public String remmplazaCaracter(String campo) {
//        String caracter = "";
//        if (campo.contains(",")) {
//            caracter = campo.replace(',', '.');
//        }
//        return caracter;
//    }

    private void btnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Estás seguro de eliminar el registro?", "Atención usuario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.removeRow(tabla.getSelectedRow());
            //gananciaEmpresa.remove(tabla.getSelectedRow());
            verificaTotal();
            ganEmpresa(1, 6, 8, 2);
        }
}//GEN-LAST:event_btnElimActionPerformed

    private void btnProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdActionPerformed
        new vizProd(null, true, txtIDP, 1, -1);
        if (!txtIDP.getText().trim().equals("")) {
            String cant = JOptionPane.showInputDialog(null, "Cantidad").toString();
            if (!cant.equals(null)) {
                modelo.addRow(new String[8]);

                gananciaEmpresa.add(0.00);

                double cantP = Double.parseDouble(cant);
                //Vector dato = frmPrincipal.miConex.consDatosParaTablas("idProducto,idProducto,"+cantP+",unidadMedida,nombreprod," + txtDCred.getText() + ",precio" + txtDCred.getText() + "", "producto", "where idproducto='" + txtIDP.getText() + "'");
                Vector dato = frmPrincipal.miConex.consDatosParaTablas("0,idProducto," + cantP + ",unidadMedida,nombreprod,((precioMax-precioProtec)*" + cantP + "),precioProtec,precioMax,precioMax,(precioMax*" + cant + ")", "producto", "where idproducto='" + txtIDP.getText() + "'");
                dato = (Vector) dato.get(0);
                System.out.println(dato);
                for (int i = 0; i < dato.size(); i++) {

                    if (i == 5) {
                        double ganancia = Double.parseDouble(dato.get(i).toString().trim());
                        modelo.setValueAt(String.format("%10.2f", ganancia), tabla.getRowCount() - 1, i);
                    } else {
                        modelo.setValueAt(dato.get(i), tabla.getRowCount() - 1, i);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la cantidad");
            }
            verificaTotal();
            ganEmpresa(1, 6, 8, 2);
            frmPrincipal.packColumn(tabla, 0, 2);
        }
        txtIDP.setText("");
        txtIDP.requestFocus();
}//GEN-LAST:event_btnProdActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            llenarCuadros();
            txtIDP.requestFocus();
        }
}//GEN-LAST:event_txtIDKeyTyped

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            llenarCuadros();
            txtIDP.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            new vizProd(null, true, txtID, 2, 0);
        }
}//GEN-LAST:event_txtIDKeyReleased

    private void btnCCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCCantActionPerformed
        String cantidad = JOptionPane.showInputDialog(null, "Cantidad: ", "Cambio de dato", JOptionPane.QUESTION_MESSAGE).toString();
        if (!cantidad.equals(null)) {
            tabla.setValueAt(cantidad, tabla.getSelectedRow(), 2);
            verificaTotal();
            // ganEmpresa(1, 6, 8, 2);
        }
    }//GEN-LAST:event_btnCCantActionPerformed

    private void btnPListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPListaActionPerformed
        Double dato = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa precio:", "Decremento de precio", JOptionPane.INFORMATION_MESSAGE).toString());
        double ganProd = 00.00;
        double gananciaProducto = 0.00;

        System.out.println("dato entrante: " + dato);

        if (!dato.equals(null)) {
            ganProd = (dato - valorCelda(6)) * valorCelda(2);
            System.out.println("(dato<" + dato + "> - valorCelda(6))<" + valorCelda(6) + "> * valorCelda(2)<" + valorCelda(2) + ">");
            System.out.println("ganancia: " + ganProd);
            //      if (dato <= Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString())) {
            //if ((Double.parseDouble(txtGan.getText())-((ganProd<0)?ganProd*-1: ganProd))>0) {
//                System.out.println("dato<" + dato + "> >= valorCelda(8)<" + valorCelda(8) + ">");
//                if (dato >= valorCelda(8)) {
//                    tabla.setValueAt(dato, tabla.getSelectedRow(), tabla.getColumnCount() - 2);
//                    tabla.setValueAt(ganProd, tabla.getSelectedRow(), 5);
//                    System.out.println("iguales");
//                } else {
            //       System.out.println("(calculaGanancia()<" + calculaGanancia() + ">");
            //      System.out.println("(ganProd <" + ganProd + "> < 0)");

            //validar si el precio agregado es mayor a precioProteccion
            double precioPro = Double.parseDouble(frmPrincipal.miConex.ConsultaDato("precioProtec", "producto", "where idProducto='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString() + "'"));//JTable_Conv_DCC.convStringDouble(tabla, i, precioC);
            System.out.println("Precio proteccion: " + precioPro);
            System.out.println("Dato: " + dato);

            if (dato >= precioPro) {
                //calcular ganancia
                gananciaProducto = (calculaGananciaVenta(dato, precioPro) * valorCelda(2));
                //calcular nuevo precio neto
                double precioNeto = (dato * valorCelda(2));
                //asignar precio tabla
                tabla.setValueAt(dato, tabla.getSelectedRow(), 8);
                //asignar ganancia
                tabla.setValueAt((String.format("%10.2f", (gananciaProducto))), tabla.getSelectedRow(), 5);
                //multiplicar nuevo precio
                tabla.setValueAt(precioNeto, tabla.getSelectedRow(), 9);

                verificaTotal();

            } else {

                //Debemos validar cuando quiera meter un precio menor al precio protecciòn.
                System.out.println("Validar que el agente tenga ganancia.");

                /*recalcular ganancia, si es la primera venta y el agente ha puesto un percio abajo del precio proteccion,
                          las ganancias seran de -saldo a favor, en ese momento se debe indicar al agente que no tiene permiso para bajar 
                          un precio sin ganancias previas.
                 */
                gananciaProducto = calculaGananciaVenta(dato, precioPro);

                System.out.println("tabla.getRowCount(): " + tabla.getRowCount());
                if (tabla.getRowCount() >= 2) {
                    
                    saldoAgente[0] = saldoAgente[0] +gananciaProducto;
                    
                    System.out.println("Ganancia: " + saldoAgente[0]);

                } else {

                    saldoAgente[0] = gananciaProducto;

                }

                if (saldoAgente[0] > 0) {

                    //cuidado estas pasando tu saldo a favor.
                    if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de bajar el precio?, esto implicaria descontar de el saldo a favor.", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        double precioNeto = (dato * valorCelda(2));
                        //asignar precio tabla
                        tabla.setValueAt(dato, tabla.getSelectedRow(), 8);
                        //asignar ganancia
                        tabla.setValueAt((String.format("%10.2f", (gananciaProducto))), tabla.getSelectedRow(), 5);
                        //multiplicar nuevo precio
                        tabla.setValueAt(precioNeto, tabla.getSelectedRow(), 9);
                        
                        verificaTotal();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No cuentas con saldo a favor.", "ATENCIÓN USUARIO", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }//GEN-LAST:event_btnPListaActionPerformed

    public double calculaGanancia() {
        double ganancia = 0.00;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ganancia += Double.parseDouble(tabla.getModel().getValueAt(i, 5).toString());
        }

        System.out.println("calculo de gnancia: " + (ganancia - valorCelda(5)));

        return ganancia - valorCelda(5);
    }

    public double calculaGananciaVenta(double precioV, double precioPro) {

        double gananciaV = 0.00;

        gananciaV = precioV - precioPro;

        return gananciaV;

    }

    public double valorCelda(int col) {
        return Double.parseDouble(tabla.getModel().getValueAt(tabla.getSelectedRow(), col).toString());
    }

    private void txtIDPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPKeyReleased
        if (tabla.getSelectedRow() < 0 && tabla.getRowCount() > 0) {
            tabla.getSelectionModel().setSelectionInterval(0, 0);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btnProdActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btnCCantActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            btnPListaActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            btnElimActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            btnGuardarActionPerformed(null);
        }
        if (tabla.getSelectedRow() >= 0) {
            if (evt.getKeyCode() == KeyEvent.VK_UP) {
                if (tabla.getSelectedRow() > 0) {
                    tabla.getSelectionModel().setSelectionInterval(tabla.getSelectedRow() - 1, tabla.getSelectedRow() - 1);
                }
            }
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                if (tabla.getSelectedRow() < tabla.getRowCount() - 1) {
                    tabla.getSelectionModel().setSelectionInterval(tabla.getSelectedRow() + 1, tabla.getSelectedRow() + 1);
                }
            }
        }
    }//GEN-LAST:event_txtIDPKeyReleased

    private void txtIDPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPKeyPressed
    }//GEN-LAST:event_txtIDPKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txtIDP.requestFocus(true);
    }//GEN-LAST:event_tablaMouseClicked

    private void chkDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDescActionPerformed
        double totalDesc = (Double.parseDouble(txtTotal.getText()) * (1 - (Double.parseDouble(frmPrincipal.miConex.ConsultaDato("descuentoC", "cliente", "where idCliente='" + txtID.getText() + "'")) / 100)));
        if (chkDesc.isSelected()) {
            txtTotal.setText(String.format("%10.2f", totalDesc));
            lblTotal.setText("$ " + String.format("%10.2f", totalDesc));
        } else {
            verificaTotal();
        }
    }//GEN-LAST:event_chkDescActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        JFileChooser explorador = new JFileChooser();
        explorador.showOpenDialog(this);
        String rutaArchivo = explorador.getSelectedFile().toString();
        String idCliente = rutaArchivo.toString().substring(0, rutaArchivo.toString().lastIndexOf("_"));
        txtID.setText(idCliente.toString().substring(idCliente.toString().lastIndexOf("_") + 1));
        llenarCuadros();
        System.out.println(idCliente);
        try {
            asignarModelo();
            br = new BufferedReader(new FileReader(rutaArchivo));
            String line = br.readLine();
            int row = 0;
            while (line != null) {
                modelo.addRow(new String[7]);
                String[] rowfields = line.split(";");
                for (int i = 0; i < rowfields.length; i++) {
                    tabla.setValueAt(rowfields[i], row, i);
                }
                line = br.readLine();
                System.out.println(line);
                row++;
            }
            frmPrincipal.packColumn(tabla, 0, 2);
            verificaTotal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnExaminarActionPerformed

    public void altaPedido() {
        Vector filas = new Vector();
        Vector celdas;
        for (int f = 0; f < tabla.getRowCount(); f++) {
            celdas = new Vector();
            System.out.println("Datos en altaPedido: [" + tabla.getModel().getValueAt(f, 1) + "]["
                    + tabla.getModel().getValueAt(f, 2) + "]["
                    + (tabla.getColumnCount() - 2) + "]["
                    + tabla.getModel().getValueAt(f, 5) + "]["
                    + gananciaEmpresa.get(f) + "]");

            celdas.add(tabla.getModel().getValueAt(f, 1));
            celdas.add(tabla.getModel().getValueAt(f, 2));
            celdas.add(tabla.getModel().getValueAt(f, tabla.getColumnCount() - 2));
            celdas.add(tabla.getModel().getValueAt(f, 5));
            celdas.add(gananciaEmpresa.get(f));
            filas.add(celdas);
        }

        while (tabla.getRowCount() > 0) {
            modelo.removeRow(0);
            gananciaEmpresa.remove(0);
        }

        idV = frmPrincipal.miConex.altaV(frmPrincipal.fechaS,
                frmPrincipal.horaS,
                montoT,
                Double.parseDouble("0"),
                frmPrincipal.habilitacion.getEmpleado().toString(),
                txtGan.getText(),
                txtID.getText(), "R", "E", false,
                "0",
                filas);
        param.put("idVenta", "" + idV);
        param.put("tipoPago", "" + ((rbtnCred.isSelected()) ? "CREDITO PERMITIDO" : "CONTADO"));
        frmPrincipal.agregaPanel(new panelVistaReportes("Remision", param), new BorderLayout(), null, null);
    }

    public void llenarCuadros() {
        Vector datosCli = frmPrincipal.miConex.consDatosParaCampos("nombreCli,descRuta,poblacionCli,concat(nombreemp,' ',apellidopatemp,' ',apellidopatemp),limiteDiasCred,limiteMontoCred,razonSocialCliente,concat(dcalleCli,', INT. ',dnoInt,', COL. ',coloniaCli,', ',estadoCli,', C.P. ',cP) as direccion,limiteDiasCred", "cliente", "inner join ruta_agente using(idR_A) inner join ruta using(idruta) inner join empleado using(idEmpleado) where idCliente='" + txtID.getText() + "'");
        if (!datosCli.isEmpty()) {
            datosCli = (Vector) datosCli.get(0);
            txtNombre.setText(datosCli.get(0).toString());
            txtPoblacion.setText(datosCli.get(2).toString());
            txtRuta.setText(datosCli.get(1).toString());
            txtNAgente.setText(datosCli.get(3).toString());
            txtDCred.setText(datosCli.get(4).toString());
            txtLimite.setText(datosCli.get(5).toString());
            txtRznS.setText(datosCli.get(6).toString());
            txtDirec.setText(datosCli.get(7).toString());
            lblFVen.setText(sumarDias(lblFEmi.getText(), Integer.parseInt(datosCli.get(8).toString())).toString());
            frmPrincipal.cargaImagen("foto", "cliente", "where idCliente='" + txtID.getText() + "'", lblFoto, 128, 128, defaultIcon);
        }
    }

    public void generarArchivo() {
        for (int fila = 0; fila
                < tabla.getRowCount(); fila++) {
            for (int col = 0; col
                    < tabla.getColumnCount(); col++) {
                cadena += tabla.getValueAt(fila, col) + ";";
            }
            cadena = cadena.substring(0, cadena.length() - 1) + "\n";
        }

        FileWriter escribir = null;
        try {
            escribir = new FileWriter("PEDIDO" + "_"
                    + frmPrincipal.miConex.ConsultaDato("idEmpleado",
                            "empleado",
                            "where concat(nombreemp,' ',apellidopatemp,' ',apellidopatemp)='" + txtNAgente.getText() + "'") + "_"
                    + txtID.getText() + "_"
                    + frmPrincipal.fechaS
                    + ".txt",
                    false);
            escribir.write(cadena);
            escribir.close();
            JOptionPane.showMessageDialog(null, "Archivo de PEDIDO generado exitosamente");
        } catch (IOException ex) {
            System.out.println("Error de escritura de archivo");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCCant;
    private javax.swing.JButton btnElim;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPLista;
    private javax.swing.JButton btnProd;
    private javax.swing.JCheckBox chkDesc;
    private javax.swing.ButtonGroup grupoCondicion;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFEmi;
    private javax.swing.JLabel lblFVen;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblIDP;
    private javax.swing.JLabel lblMontoLetra;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbtnCont;
    private javax.swing.JRadioButton rbtnCred;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtDCred;
    private javax.swing.JLabel txtDirec;
    private javax.swing.JLabel txtGan;
    public javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDP;
    private javax.swing.JLabel txtLimite;
    private javax.swing.JLabel txtNAgente;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPoblacion;
    private javax.swing.JLabel txtRuta;
    private javax.swing.JLabel txtRznS;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
