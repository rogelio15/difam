package dialog;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class jdStock extends javax.swing.JDialog {

    JTextField campo;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Vector columnas = new Vector();
    int opcCP, col;

    public jdStock(java.awt.Frame parent, boolean modal, JTextField campo, int opcCP, int col) {
        super(parent, modal);
        initComponents();
        switch (opcCP) {
            case 1:
                columnas.add("ID Producto");
                columnas.add("Nombre del Prod.");
                columnas.add("Precio Min.");
                columnas.add("Precio Max.");
                columnas.add("Exist.");
                columnas.add("Stock Min.");
                columnas.add("Categoria");
                break;
        }
        this.opcCP = opcCP;
        this.col = col;
        this.campo = campo;
        llenarTabla1("");
        setTitle("BUSQUEDA POR NOMBRE PRODUCTO");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void llenarTabla1(String orden) {
        tabla.setDefaultRenderer(Object.class, new celdaRander(col));
        tabla.setRowHeight(20);
        switch (opcCP) {
            case 1:
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,nombreProd,FORMAT(precioMin,2),FORMAT(precioMax,2),existencia,stockMin,nombrecat", "producto", "inner join categoria using(idcategoria) where existencia<stockMin and nombreProd like '%" + txtCampo.getText() + "%' " + orden), columnas));
                break;
        }
        frmPrincipal.packColumn(tabla, 0, 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gMM = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtCampo = new javax.swing.JTextField();
        gbtnMayor = new javax.swing.JRadioButton();
        gbtnMenor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        tabla.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        txtCampo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCampoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCampoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCampoKeyTyped(evt);
            }
        });

        gMM.add(gbtnMayor);
        gbtnMayor.setText("^");
        gbtnMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbtnMayorActionPerformed(evt);
            }
        });

        gMM.add(gbtnMenor);
        gbtnMenor.setText("v");
        gbtnMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbtnMenorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gbtnMayor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gbtnMenor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gbtnMayor)
                    .addComponent(gbtnMenor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campo.setText(tabla.getModel().getValueAt((tabla.getSelectedRow()), 0).toString());
            dispose();
        }
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
        
    }//GEN-LAST:event_tablaKeyTyped

    private void txtCampoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tabla.requestFocus(true);
        }
    }//GEN-LAST:event_txtCampoKeyPressed

    private void txtCampoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoKeyReleased
        if ((evt.getKeyCode() > KeyEvent.VK_A && evt.getKeyCode() < KeyEvent.VK_Z) || evt.getKeyCode() < KeyEvent.VK_DELETE) {
            llenarTabla1("");
        }
    }//GEN-LAST:event_txtCampoKeyReleased

    private void txtCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoKeyTyped
    }//GEN-LAST:event_txtCampoKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            campo.setText(tabla.getModel().getValueAt((tabla.getSelectedRow()), 0).toString());
            dispose();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void gbtnMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbtnMenorActionPerformed
        llenarTabla1(" ORDER BY existencia desc");
    }//GEN-LAST:event_gbtnMenorActionPerformed

    private void gbtnMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbtnMayorActionPerformed
        llenarTabla1(" ORDER BY existencia asc");
    }//GEN-LAST:event_gbtnMayorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gMM;
    private javax.swing.JRadioButton gbtnMayor;
    private javax.swing.JRadioButton gbtnMenor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCampo;
    // End of variables declaration//GEN-END:variables
}
