package panel;

import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class panelProveedores extends javax.swing.JPanel {
    //private consultasMySQL x = new consultasMySQL();

    boolean AoC = true;
    private int filas = 0;
    Vector columnas = new Vector();

    public panelProveedores() {
        initComponents();
        columnas.add("No. de Proveedor");
        columnas.add("Nombre de Proveedor");
        columnas.add("Direccion");
        columnas.add("Teléfono");
        columnas.add("Email");
        columnas.add("Fax");
        columnas.add("RFC");
        llenarTabla();
        ControlBotones(false, true);
        setVisible(true);
    }

    public void validaEnter(KeyEvent evt, JTextField campo) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campo.requestFocus();
        }
    }

    public void llenarTabla() {
        Vector datos = frmPrincipal.miConex.consDatosParaTablas("*", "proveedor", "order by idProveedor");
        tabla.setModel(new DefaultTableModel(datos, columnas) {

            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        });
        tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(280);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(110);
    }

    public void ControlBotones(boolean op1, boolean opc2) {
        txtNombre.setEditable(op1);
        txtDireccion.setEditable(op1);
        txtTelefono.setEditable(op1);
        txtEmail.setEditable(op1);
        txtFax.setEditable(op1);
        txtRFC.setEditable(op1);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnAct.setEnabled(opc2);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        tabla.setEnabled(opc2);
    }

    public void vaciaCuadros() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtFax.setText("");
        txtRFC.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAct = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/action_save.gif"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero Proveedor", "Nombre de  Proveedor", "Telefono", "Dirección", "Email", "Fax"
            }
        ));
        tabla.setCellSelectionEnabled(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Proveedor"));

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel1.setText("Razon Social:");

        jLabel2.setText("Dirección:");

        jLabel3.setText("Telefono:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        jLabel4.setText("E-mail:");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel6.setText("Fax:");

        txtFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFaxKeyReleased(evt);
            }
        });

        jLabel7.setText("RFC:");

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFCKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Lista de Prooveedores:");

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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/basurita.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sube.gif"))); // NOI18N
        btnAct.setText("Actualizar");
        btnAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActActionPerformed(evt);
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel5)
                    .addComponent(btnAct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un NOMBRE", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtNombre.requestFocus();
        } else if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar una Dirección", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtDireccion.requestFocus();
        } else if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un Telefono o escribe NO", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtTelefono.requestFocus();
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de ingresar un Email o escribe NO", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtEmail.requestFocus();
        } else if (txtFax.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de escribir un Fax o escribe NO", "Atencion... AVISO", JOptionPane.INFORMATION_MESSAGE);
            txtFax.requestFocus();
        } else {
            if (AoC) {
                frmPrincipal.miConex.altaRegistro("proveedor",
                        "null,'" + txtNombre.getText().toUpperCase() + "',"
                        + "'" + txtDireccion.getText().toUpperCase() + "',"
                        + "'" + txtTelefono.getText() + "',"
                        + "'" + txtEmail.getText() + "',"
                        + "'" + txtFax.getText() + "',"
                        + "'" + txtRFC.getText().toUpperCase() + "'");
            } else {
                frmPrincipal.miConex.actualizaRegistro("proveedor",
                        "nombreProv='" + txtNombre.getText().toUpperCase() + "',"
                        + "direccionProv='" + txtDireccion.getText().toUpperCase() + "',"
                        + "telefonoProv='" + txtTelefono.getText().toUpperCase() + "',"
                        + "email='" + txtEmail.getText() + "',"
                        + "fax='" + txtFax.getText().toUpperCase() + "',"
                        + "rfc='" + txtRFC.getText().toUpperCase() + "'",
                        "idProveedor='" + tabla.getModel().getValueAt(tabla.getSelectedRow(), 0) + "'");
                AoC = true;
            }
            ControlBotones(false, true);
            llenarTabla();
            vaciaCuadros();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vaciaCuadros();
        ControlBotones(false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ControlBotones(true, false);
        vaciaCuadros();
        txtNombre.requestFocus(true);
        llenarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tabla.getSelectedRow()>=0){
            if((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?","Atencion!!",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){
                frmPrincipal.miConex.eliminaRegistro("proveedor", "idProveedor", tabla.getModel().getValueAt(tabla.getSelectedRow(),0).toString());
            }
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una CATEGORIA!!!");
        }
        ControlBotones(false, true);
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        validaEnter(evt, txtDireccion);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        validaEnter(evt, txtTelefono);
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        validaEnter(evt, txtEmail);
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        validaEnter(evt, txtFax);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtFaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFaxKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarActionPerformed(null);
        }
    }//GEN-LAST:event_txtFaxKeyReleased

    private void txtRFCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCKeyReleased

    private void btnActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActActionPerformed
        if(tabla.getSelectedRow()>=0){
            ControlBotones(true, false);
            txtNombre.requestFocus(true);
            AoC = false;
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una Registro!!!");
        }
    }//GEN-LAST:event_btnActActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txtNombre.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString());
        txtDireccion.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString());
        txtTelefono.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 3).toString());
        txtEmail.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 4).toString());
        txtFax.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 5).toString());
        txtRFC.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tablaMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAct;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
