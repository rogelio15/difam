/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jdBCompra.java
 *
 * Created on 8/04/2014, 09:03:04 PM
 */

package dialog;

import difamserv.frmPrincipal;
import panel.miCompra;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Crisostomo
 */
public class jdBCompra extends javax.swing.JDialog{
    JTable tabla;
    Vector columnas;
    miCompra interfaz;
    /** Creates new form jdBCompra */
    public jdBCompra(java.awt.Frame parent, boolean modal,JTable tabla,Vector columnas, miCompra interfaz) {
        super(parent, modal);
        initComponents();
        this.interfaz = interfaz;
        this.tabla = tabla;
        this.columnas = columnas;
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idProveedor,nombreProv","proveedor",""), cboProv);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboProv = new javax.swing.JComboBox();
        btnO2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtNoC = new javax.swing.JTextField();
        btnO1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opción 2::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 1, 11))); // NOI18N

        cboProv.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        cboProv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnO2.setText("CARGAR");
        btnO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Proveedor:");

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel2.setText("Fecha de Compra:");

        txtFC.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtFC.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFC, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnO2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboProv, 0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnO2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opción 1:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lao UI", 1, 11))); // NOI18N

        txtNoC.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoCKeyReleased(evt);
            }
        });

        btnO1.setText("CARGAR");
        btnO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnO1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Numero de Compra:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnO1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnO1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO1ActionPerformed
        //tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)), columnas));
        Vector datos= frmPrincipal.miConex.consDatosParaTablas("nombreProv,idProveedor,fechaCompra","compra","inner join proveedor using(idproveedor) where idCompra='"+txtNoC.getText()+"'");
        datos = (Vector)datos.get(0);
        //frmPrincipal.habilitacion.setIdExp(txtNoC.getText());
//        miCompra.lblMPagado.setText(String.format("%10.2f",Double.parseDouble(datos.get(1).toString())));
        JOptionPane.showMessageDialog(null,datos.get(2).toString());
        miCompra.lblFC.setText(datos.get(2).toString());
        frmPrincipal.coincideCampo(miCompra.cboProv,datos.get(0).toString());
        frmPrincipal.habilitacion.setIdExp(txtNoC.getText());
//      tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(datos.get(2).toString(), datos.get(1).toString()), columnas));
        interfaz.validaImporte();
        interfaz.verificaTotal_1();
        miCompra.dimenTabla();
        dispose();
    }//GEN-LAST:event_btnO1ActionPerformed

    private void btnO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnO2ActionPerformed
        //tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(frmPrincipal.fechaS, frmPrincipal.obtenID(cboProv)), columnas));
        miCompra.lblFC.setText(txtFC.getText());
        frmPrincipal.coincideCampo(miCompra.cboProv,cboProv.getSelectedItem().toString().substring(0,cboProv.getSelectedItem().toString().indexOf("-")));
        tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consultaExpendio(txtFC.getText(), frmPrincipal.obtenID(cboProv)), columnas));
        interfaz.validaImporte();
        interfaz.verificaTotal_1();
        miCompra.dimenTabla();
        dispose();
    }//GEN-LAST:event_btnO2ActionPerformed

    private void txtNoCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoCKeyReleased
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            btnO1ActionPerformed(null);
        }
    }//GEN-LAST:event_txtNoCKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnO1;
    private javax.swing.JButton btnO2;
    private javax.swing.JComboBox cboProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtFC;
    private javax.swing.JTextField txtNoC;
    // End of variables declaration//GEN-END:variables

}
