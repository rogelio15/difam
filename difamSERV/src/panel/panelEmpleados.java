package panel;


import dialog.jdaltaUsuarios;
import difamserv.frmPrincipal;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class panelEmpleados extends javax.swing.JPanel {

    private String ruta;
//    private recibeMiRuta y = new recibeMiRuta();
    String rutaImg = "";
    Vector columnas = new Vector();
    private boolean AoC = false;

    public panelEmpleados() {
        initComponents();
        btnHistorial.setEnabled(false);
        columnas.add("No. Empleado");
        columnas.add("Nombre Completo");
        columnas.add("Fecha de Nacimiento");
        columnas.add("Direccion");
        columnas.add("Teléfono");
        columnas.add("Tipo");
        columnas.add("Email");
        columnas.add("Monto Perm.");
        llenarTabla();
        ControlBotones(false, true);
        setVisible(true);
    }

    public void cambiaImagen() {
        //Icon icon = new ImageIcon(img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
//        lblFoto.setIcon(new ImageIcon(y.getRutaImagen()));
    }

    public void validaEnter(KeyEvent evt, JTextField campo) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campo.requestFocus();
        }
    }

    public void llenarTabla() {
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idEmpleado,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp),fechaNacC,direccionEmp,telefonoEmp,(IF(tipo='G','AGENTE',IF(tipo='D','ADMINISTRADOR','CAJERO'))),emailEmp,montoVentaPerm", "empleado", ""), columnas));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    public void ControlBotones(boolean op1, boolean opc2) {
        txtD.setEditable(op1);
        txtT.setEditable(op1);
        txtFN.setEditable(op1);
        txtNombre.setEditable(op1);
        txtAM.setEditable(op1);
        txtAP.setEditable(op1);
        btnAct.setEnabled(op1);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        btnAct.setEnabled(opc2);
        tabla.setEnabled(opc2);
        //miTablaProd.setEnabled(opc2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtAM = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAct = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtT = new javax.swing.JTextField();
        txtFN = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMPerm = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbTipoU = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        txtAM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAMKeyReleased(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAPKeyReleased(evt);
            }
        });

        jLabel6.setText("Teléfono:");

        jLabel2.setText("Apellido Paterno:");

        txtD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel3.setText("Apellido Materno:");

        jLabel5.setText("Dirección:");

        btnAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sube.gif"))); // NOI18N
        btnAct.setText("Actualizar");
        btnAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/action_save.gif"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTKeyReleased(evt);
            }
        });

        try {
            txtFN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFN.setToolTipText("DD/MM/AAAA");
        txtFN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFNKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prer.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setText("Monto de Crédito Permitido:");

        txtMPerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMPermKeyReleased(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel9.setText("Email:");

        jLabel10.setText("Tipo Usuario:");

        cmbTipoU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "AGENTE", "CAJERO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtD, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtFN)
                            .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(txtT, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtAM, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(btnAct, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMPerm, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoU, 0, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMPerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel8.setText("Empleados ya Registrados:");

        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/infor.gif"))); // NOI18N
        btnHistorial.setText("Ver Historial del Mes");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/basurita.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHistorial))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActActionPerformed
        ControlBotones(true, false);
        txtNombre.requestFocus(true);
        AoC = true;
}//GEN-LAST:event_btnActActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        rutaImg = "";
        lblFoto.setIcon(new ImageIcon("iCliente.png"));
        vaciaCuadros();
        ControlBotones(true, false);
        txtNombre.requestFocus();
}//GEN-LAST:event_btnAgregarActionPerformed

    public void vaciaCuadros() {
        txtD.setText("");
        txtNombre.setText("");
        txtAP.setText("");
        txtAM.setText("");
        txtT.setText("");
        txtFN.setText("");
        txtEmail.setText("");
        txtMPerm.setText("");
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlBotones(false, true);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (tabla.getSelectedRow() >= 0) {
//            new historialEmpleado(null, true, miTablaEmp.getValueAt(miTablaEmp.getSelectedRow(), 0).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Empleado!!");
        }
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un NOMBRE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
        } else if (txtAP.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el APELLIDO PATERNO", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtAP.requestFocus();
        } else if (txtAM.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar el APELLIDO MATERNO", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtAM.requestFocus();
        } else if (txtFN.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar una Fecha de Nacimiento", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtFN.requestFocus();
        } else if (txtD.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de escribir la Direccion", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtD.requestFocus();
        } else if (txtFN.getText().length() != 10) {
            JOptionPane.showMessageDialog(null, "La Fecha De Nacimiento no esta completa", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtFN.requestFocus();
        } else {

            String fechaNac = "";
            String dia = String.format("%02d", Integer.parseInt(txtFN.getText().substring(0, 2)));
            String mes = String.format("%02d", Integer.parseInt(txtFN.getText().substring(3, 5)));
            String anio = txtFN.getText().substring(6);
            fechaNac = anio + "-" + mes + "-" + dia;

            if (AoC) {
                if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de el Cambio?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                    frmPrincipal.miConex.actualizaRegistro("empleado", 
                                                            "nombreEmp='"+txtNombre.getText().toUpperCase()+"',"+
                                                            "apellidoPatEmp='"+txtAP.getText().toUpperCase()+"',"+
                                                            "apellidoMatEmp='"+txtAM.getText().toUpperCase()+"',"+
                                                            "fechaNacC='"+fechaNac+"',"+
                                                            "direccionEmp='"+txtD.getText().toUpperCase()+"',"+
                                                            "montoVentaPerm='"+txtMPerm.getText().toUpperCase()+"',"+
                                                            "emailEmp='"+txtEmail.getText()+"',"+
                                                            "telefonoEmp='"+txtT.getText().toUpperCase()+"',"+
                                                            "tipo='"+cmbTipoU.getSelectedItem().toString().charAt(1)+"'",
                                                            "idEmpleado='" + tabla.getModel().getValueAt(tabla.getSelectedRow(),0).toString()+"'");
                
                    System.out.println(cmbTipoU.getSelectedItem().toString().charAt(1));
                } else {
                    txtNombre.setText("");
                }
                AoC = false;
            } else {
                frmPrincipal.miConex.altaRegistro("empleado",
                        "null,'" + txtNombre.getText().toUpperCase() + "',"
                        + "'" + txtAP.getText().toUpperCase() + "',"
                        + "'" + txtAM.getText().toUpperCase() + "',"
                        + "'" + fechaNac + "',"
                        + "'" + txtD.getText().toUpperCase() + "',"
                        + "'" + txtT.getText() + "',"
                        + "'" + txtEmail.getText() + "',"
                        + "'" + txtMPerm.getText() + "','N'");

                llenarTabla();
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    String nom = txtNombre.getText() + " " + txtAP.getText() + " " + txtAM.getText();
                    if (nom.equals(tabla.getValueAt(i, 1).toString())) {
                        new jdaltaUsuarios(null, true, tabla.getValueAt(i, 0).toString());
                        break;
                    }
                }
            }            
        }

        llenarTabla();
        vaciaCuadros();
        ControlBotones(false, true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        btnHistorial.setEnabled(true);
        Vector datos = frmPrincipal.miConex.consDatosParaCampos("nombreEmp,apellidoPatEmp,apellidoMatEmp,fechaNacC,montoVentaPerm", "empleado", "where idEmpleado='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString() + "'");
        datos = (Vector) datos.get(0);
        txtNombre.setText(datos.get(0).toString());
        txtAP.setText(datos.get(1).toString());
        txtAM.setText(datos.get(2).toString());
        String fena = datos.get(3).toString();
        txtFN.setText(fena.substring(8) + "/" + fena.substring(5, 7) + "/" + fena.substring(0, 4));
        txtD.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString());
        txtT.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());
        txtEmail.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
        txtMPerm.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 7).toString());

         frmPrincipal.coincideCampo(cmbTipoU, tabla.getModel().getValueAt(tabla.getSelectedRow(), 5).toString());

    }//GEN-LAST:event_tablaMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tabla.getSelectedRow() >= 0) {
            if ((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?", "Atencion!!", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                frmPrincipal.miConex.eliminaRegistro("empleado", "idEmpleado", tabla.getModel().getValueAt(tabla.getSelectedRow(), 0).toString());
                ControlBotones(false, true);
                llenarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un EMPLEADO!!!");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        validaEnter(evt, txtAP);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtAMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAMKeyReleased
        validaEnter(evt, txtFN);
    }//GEN-LAST:event_txtAMKeyReleased

    private void txtAPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAPKeyReleased
        validaEnter(evt, txtAM);
    }//GEN-LAST:event_txtAPKeyReleased

    private void txtFNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFNKeyReleased
        validaEnter(evt, txtT);
    }//GEN-LAST:event_txtFNKeyReleased

    private void txtTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKeyReleased
        validaEnter(evt, txtD);
    }//GEN-LAST:event_txtTKeyReleased

    private void txtDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
    }//GEN-LAST:event_txtDKeyReleased

    private void txtMPermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMPermKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMPermKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAct;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JComboBox cmbTipoU;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtAM;
    private javax.swing.JTextField txtAP;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFN;
    private javax.swing.JTextField txtMPerm;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtT;
    // End of variables declaration//GEN-END:variables
}
