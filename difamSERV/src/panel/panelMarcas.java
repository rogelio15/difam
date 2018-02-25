package panel;

import difamserv.frmPrincipal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class panelMarcas extends javax.swing.JPanel {
    private int filas=0;
    private DefaultTableModel miModelo;
    private boolean AoC = false;
    //consultasMySQL x = new consultasMySQL();
    Vector columnas = new Vector();
    
    public panelMarcas() {
        initComponents();
        ControlBotones(false,true);
        columnas.add("Numero de Categoria");
        columnas.add("Nombre de la Categoria");
        llenarTabla();
        setVisible(true);
    }
    
    public void llenarTabla(){
        miTablaCat.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("*","Marca", "order by nombreMarca"),columnas));
        miTablaCat.getColumnModel().getColumn(0).setPreferredWidth(40);
        miTablaCat.getColumnModel().getColumn(1).setPreferredWidth(950);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        miTablaCat = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAct2 = new javax.swing.JButton();

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

        miTablaCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero de Categoria", "Nombre Categoria"
            }
        ));
        miTablaCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miTablaCatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(miTablaCat);

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

        btnAct2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sube.gif"))); // NOI18N
        btnAct2.setText("Actualizar");
        btnAct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAct2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAct2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGuardar)
                    .addComponent(btnAgregar)
                    .addComponent(btnAct2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText("");
        ControlBotones(false,true);
        miTablaCat.setEnabled(true);
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        txtNombre.setEditable(true);
        txtNombre.setText("");
        txtNombre.requestFocus(true);
        llenarTabla();
        miTablaCat.setEnabled(false);
        ControlBotones(true,false);
}//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(miTablaCat.getSelectedRow()>=0){
            if((JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar el Registro?","Atencion!!",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){
                frmPrincipal.miConex.eliminaRegistro("marca", "idMarca", miTablaCat.getModel().getValueAt(miTablaCat.getSelectedRow(),0).toString());
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
                    frmPrincipal.miConex.actualizaRegistro("marca", "nombreMarca='"+txtNombre.getText().toUpperCase()+"'", "idMarca='"+miTablaCat.getModel().getValueAt(miTablaCat.getSelectedRow(),0).toString()+"'");
                }else{
                    txtNombre.setText("");
                }
            }else{
                //System.out.println("null,'" + txtNomCat.getText() + "'");
                frmPrincipal.miConex.altaRegistro("marca","null,'" + txtNombre.getText() + "'");
            }
            AoC=false;
        }
        ControlBotones(false,true);
        miTablaCat.setEnabled(true);
        llenarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void miTablaCatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miTablaCatMouseClicked
        if(miTablaCat.isEnabled() != false){
            txtNombre.setText(miTablaCat.getModel().getValueAt(miTablaCat.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_miTablaCatMouseClicked

    private void btnAct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAct2ActionPerformed
        if(miTablaCat.getSelectedRow()>=0){
            ControlBotones(true, false);
            txtNombre.requestFocus(true);
            AoC = true;
        }else{
            JOptionPane.showMessageDialog(this,"Debe seleccionar una Registro!!!");
        }
}//GEN-LAST:event_btnAct2ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable miTablaCat;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
