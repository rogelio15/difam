package panel;

import dialog.altaRapida;
import difamserv.frmPrincipal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelFamilia extends javax.swing.JPanel {
    private int filas=0;
    private DefaultTableModel miModelo;
    private boolean AoC = false;
    //consultasMySQL x = new consultasMySQL();
    Vector columnas = new Vector();
    
    public panelFamilia() {
        initComponents();
        ControlBotones(false,true);
        columnas.add("Numero Familia");
        columnas.add("Nombre de Familia");
        columnas.add("Nombre de la Categoria");
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "categoria", ""), cboCats);
        llenarTabla();
        setVisible(true);
    }
    
    public void llenarTabla(){
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idfam,nombrefam,nombrecat","familia", "inner join categoria using(idcategoria)"),columnas));
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(600);

    }

    public static void actualizaCombo(JComboBox combo, boolean opc, Vector datos) {
        if (opc) {
            frmPrincipal.llenarCombo_ID(datos, combo);
        } else {
            frmPrincipal.llenarCombo(datos, combo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cboCats = new javax.swing.JComboBox();
        lblCat = new javax.swing.JLabel();
        btnAct2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descripción de Marca:");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete16.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/action_save.gif"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel12.setText("Categoría:");

        cboCats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABARROTES", "FARMACOS", "PERFUMERIA" }));
        cboCats.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboCatsKeyReleased(evt);
            }
        });

        lblCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lblCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCatMouseClicked(evt);
            }
        });

        btnAct2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sube.gif"))); // NOI18N
        btnAct2.setText("Actualizar");
        btnAct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAct2ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboCats, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAct2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel12)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboCats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAct2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText("");
        ControlBotones(false,true);
        tabla.setEnabled(true);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        txtNombre.setEditable(true);
        txtNombre.setText("");
        txtNombre.requestFocus(true);
        llenarTabla();
        tabla.setEnabled(false);
        ControlBotones(true,false);
}//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tabla.getSelectedRow()>=0){
            if((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?","Atencion!!",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){
                frmPrincipal.miConex.eliminaRegistro("familia", "idFam", tabla.getModel().getValueAt(tabla.getSelectedRow(),0).toString());
            }
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una CATEGORIA!!!");
        }
        ControlBotones(false,true);
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Favor de Escribir un Nombre");
            txtNombre.setFocusable(true);
        }else{
            if(AoC){
                if((JOptionPane.showConfirmDialog(null, "¿Esta seguro de el Cambio?","Atencion!!",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){
                    frmPrincipal.miConex.actualizaRegistro("familia","nombreFam='" + txtNombre.getText().toUpperCase().toString()+"', idCategoria='"+frmPrincipal.obtenID(cboCats)+"'","idFam='"+ tabla.getModel().getValueAt(tabla.getSelectedRow(),0).toString()+"'");
                }else{
                    txtNombre.setText("");
                }
            }else{

                frmPrincipal.miConex.altaRegistro("familia","null,'" + txtNombre.getText() + "',"+frmPrincipal.obtenID(cboCats));
            }
            AoC=false;
        }
        ControlBotones(false,true);
        tabla.setEnabled(true);
        llenarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboCatsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCatsKeyReleased
        // TODO add your handling code here:
}//GEN-LAST:event_cboCatsKeyReleased

    private void lblCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCatMouseClicked
        new altaRapida(null, true, "Categoria", 3, cboCats,this);
}//GEN-LAST:event_lblCatMouseClicked

    private void btnAct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAct2ActionPerformed
        if(tabla.getSelectedRow()>=0){
            ControlBotones(true, false);
            txtNombre.requestFocus(true);
            AoC = true;
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una Registro!!!");
        }
}//GEN-LAST:event_btnAct2ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if(tabla.isEnabled() != false){
            txtNombre.setText(tabla.getModel().getValueAt(tabla.getSelectedRow(), 1).toString());
            frmPrincipal.coincideCampo(cboCats, tabla.getModel().getValueAt(tabla.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tablaMouseClicked

    public void ControlBotones(boolean op1, boolean opc2){
        txtNombre.setEditable(op1);
        btnGuardar.setEnabled(op1);
        btnCancelar.setEnabled(op1);
        btnEliminar.setEnabled(opc2);
        btnAgregar.setEnabled(opc2);
        btnAct2.setEnabled(opc2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAct2;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboCats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCat;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
