package dialog;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class jdRelacionFC extends javax.swing.JDialog {
JComboBox combo;
    public jdRelacionFC(java.awt.Frame parent, boolean modal,JComboBox combo) {
        super(parent, modal);
        initComponents();
        //llenarCombo(frmPrincipal.conexion.consDatosParaCampos("descripcionpuesto", "puesto", ""),cboPuesto);
//        llenarCombo(frmPrincipal.conexion.consDatosParaCampos("idDepartamento,descripciondepto", "departamento", " order by descripciondepto asc"),cboDeptos);
        this.combo = combo;
        llenarTabla();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void llenarCombo1(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(0));
            }
        }
        combo.setModel(modeloCB);
    }

    public void llenarCombo(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(1) + "-" + misDatos.get(0));
            }
        }
        combo.setModel(modeloCB);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboDeptos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre Ruta:");

        txtDepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDeptoKeyReleased(evt);
            }
        });

        jButton1.setText("Alta Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Relacion Puesto - Departamento"));

        jLabel3.setText("CATEGORÍA:");

        cboDeptos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nombre Familia:");

        jButton2.setText("Relacionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDeptos, 0, 300, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboDeptos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
        );

        tabDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMBRE AGENTE", "NOMBRE RUTA", "POBLACIÓN"
            }
        ));
        jScrollPane1.setViewportView(tabDatos);

        jLabel5.setText("Lista de Relaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDepto, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        frmPrincipal.conexion.altaRegistro("departamento","null,'"+txtDepto.getText().toUpperCase()+"'");
//        llenarCombo(frmPrincipal.conexion.consDatosParaCampos("idDepartamento,descripciondepto", "departamento", " order by descripciondepto asc"),cboDeptos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDeptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeptoKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtDeptoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        frmPrincipal.conexion.altaRegistro("puesto","null,'"+txtPuesto.getText().toUpperCase()+"',"+cboDeptos.getSelectedItem().toString().substring(cboDeptos.getSelectedItem().toString().indexOf("-")+1));
//        llenarCombo(frmPrincipal.conexion.consDatosParaCampos("*", "puesto", "order by DescripcionPuesto"), combo);
        llenarTabla();
        new jdaltaUsuarios(null,true,"1");
}//GEN-LAST:event_jButton2ActionPerformed

    public void llenarTabla(){
    Vector columna = new Vector();
        columna.add("Puesto");
        columna.add("Depto.");
        tabDatos.setDefaultRenderer(Object.class,new celdaRander(0));
        tabDatos.setRowHeight(30);
        tabDatos.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("*","familia", ""),columna));
        tabDatos.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabDatos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
public static void main(String z[]){
    new jdRelacionFC(null,true,null);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboDeptos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDatos;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtPuesto;
    // End of variables declaration//GEN-END:variables

}
