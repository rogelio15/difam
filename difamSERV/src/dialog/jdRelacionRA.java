package dialog;

import conf_comandos.JComboBox_DCC;
import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class jdRelacionRA extends javax.swing.JDialog {
JComboBox combo;
    public jdRelacionRA(java.awt.Frame parent, boolean modal,JComboBox combo) {
        super(parent, modal);
        initComponents();
        setTitle("Relación RUTA-AGENTE");
        //llenarCombo(frmPrincipal.conexion.consDatosParaCampos("descripcionpuesto", "puesto", ""),cboPuesto);
//        llenarCombo(frmPrincipal.conexion.consDatosParaCampos("idDepartamento,descripciondepto", "departamento", " order by descripciondepto asc"),cboDeptos);
        llenarTabla();
        this.combo = combo;
        JComboBox_DCC.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "ruta",""), cboRuta);
        JComboBox_DCC.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("idEmpleado,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp)", "empleado","where tipo='G'"), cboAgente);
        setLocationRelativeTo(null);
        //new ConfComandos.ComboBoxCellEditor(combo);
        setVisible(true);
    }

//    public void llenarCombo1(Vector misRegistros, JComboBox combo) {
//        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
//        if (!misRegistros.isEmpty()) {
//            for (int i = 0; i < misRegistros.size(); i++) {
//                Vector misDatos = (Vector) misRegistros.get(i);
//                modeloCB.addElement(misDatos.get(0));
//            }
//        }
//        combo.setModel(modeloCB);
//    }
//
//    public void llenarCombo(Vector misRegistros, JComboBox combo) {
//        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
//        if (!misRegistros.isEmpty()) {
//            for (int i = 0; i < misRegistros.size(); i++) {
//                Vector misDatos = (Vector) misRegistros.get(i);
//                modeloCB.addElement(misDatos.get(1) + "-" + misDatos.get(0));
//            }
//        }
//        combo.setModel(modeloCB);
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboDeptos1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboRuta = new javax.swing.JComboBox();
        btnRel = new javax.swing.JButton();
        cboAgente = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        cboDeptos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("RUTA:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre Ruta:");

        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRutaKeyReleased(evt);
            }
        });

        jButton1.setText("Alta Ruta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Relacion Ruta - Agente"));

        jLabel3.setText("Ruta:");

        btnRel.setText("Relacionar");
        btnRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelActionPerformed(evt);
            }
        });

        jLabel6.setText("Agente:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
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
                        .addComponent(cboRuta, 0, 337, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAgente, 0, 212, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cboAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmPrincipal.miConex.altaRegistro("ruta","null,'"+txtRuta.getText().toUpperCase()+"'");
        frmPrincipal.llenarCombo_ID(frmPrincipal.miConex.consDatosParaCampos("*", "ruta", ""),cboRuta);
        frmPrincipal.coincideCampo(cboRuta,txtRuta.getText().toUpperCase());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtRutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtRutaKeyReleased

    private void btnRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelActionPerformed
        frmPrincipal.miConex.altaRegistro("ruta_agente","null,'"+(cboRuta.getSelectedItem().toString().substring(cboRuta.getSelectedItem().toString().lastIndexOf("-")+1))+"','"+frmPrincipal.obtenID(cboAgente)+"'");
//        llenarCombo(frmPrincipal.conexion.consDatosParaCampos("*", "puesto", "order by DescripcionPuesto"), combo);
        llenarTabla();
//        new jdaltaUsuarios(null,true,"1");
}//GEN-LAST:event_btnRelActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        new jdAltaAgente(null,true,cboAgente);
}//GEN-LAST:event_jLabel19MouseClicked

    public void llenarTabla(){
    Vector columna = new Vector();
        columna.add("Ruta");
        columna.add("Nombre Agente");
        tabDatos.setDefaultRenderer(Object.class,new celdaRander(-1));
        tabDatos.setRowHeight(30);
        tabDatos.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("descRuta,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp)","ruta_agente", "inner join empleado using(idEmpleado) inner join ruta using(idRuta) order by descRuta"),columna));
        tabDatos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabDatos.getColumnModel().getColumn(1).setPreferredWidth(200);
//        tabDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
public static void main(String z[]){
    new jdRelacionRA(null,true,null);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRel;
    private javax.swing.JComboBox cboAgente;
    private javax.swing.JComboBox cboDeptos1;
    private javax.swing.JComboBox cboRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDatos;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

}
