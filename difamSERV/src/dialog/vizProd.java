package dialog;

import difamserv.celdaRander;
import difamserv.frmPrincipal;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class vizProd extends javax.swing.JDialog {

    JTextField campo;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Vector columnas = new Vector();
    int opcCP, col;

    public vizProd(java.awt.Frame parent, boolean modal, JTextField campo, int opcCP, int col) {
        super(parent, modal);
        initComponents();
        setTitle("BUSQUEDA RAPIDA");
        switch (opcCP) {
            case 1:
                System.out.println("Productos");
                setTitle("PRODUCTOS");
                columnas.add("ID Producto");
                columnas.add("Nombre del Prod.");
                columnas.add("Precio Min.");
                columnas.add("Precio Max.");
                columnas.add("Exist.");
                columnas.add("Categoria");
                break;
            case 2:
                System.out.println("Cliente");
                setTitle("CLIENTE");
                columnas.add("ID C.");
                columnas.add("RAZON SOCIAL");
                columnas.add("NOMBRE CLIENTE");
                columnas.add("POBLACIÓN");
                columnas.add("AGENTE");
                break;
            case 3:
                System.out.println("Numero venta");
                columnas.add("NO VENTA");
                columnas.add("NOMBRE CLIENTE");
                columnas.add("TIPO V.");
                columnas.add("ESTADO");
                columnas.add("FECHA V.");
                columnas.add("MONTO V.");
                break;
            case 4:
                System.out.println("Productos 4");
                setTitle("PRODUCTOS");
                columnas.add("ID Producto");
                columnas.add("Nombre del Prod.");
                columnas.add("Precio Unit.");
                columnas.add("Exist.");
                columnas.add("Categoria");
                break;
            case 5:
                setTitle("AGENTES");
                columnas.add("ID Agente");
                columnas.add("Nombre del Agente");
                columnas.add("Ruta Asginada");
                columnas.add("Telefono");
                break;
        }
        this.opcCP = opcCP;
        this.col = col;
        this.campo = campo;
        llenarTabla1();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void llenarTabla1() {
        tabla.setDefaultRenderer(Object.class, new celdaRander(col));
        tabla.setRowHeight(20);
        switch (opcCP){
            case 1:
                System.out.println("Entro a 1:");
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,nombreProd,FORMAT(precioMin,2),FORMAT(precioMax,2),existencia_pieza,nombrecat", "producto", "inner join categoria using(idcategoria) where nombreProd like '%" + txtCampo.getText() + "%'"), columnas));
                break;
            case 2:
                System.out.println("Entro a 2:");
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idCliente,razonSocialCliente,nombreCli, poblacioncli,concat(nombreemp,' ',apellidopatemp,' ',apellidopatemp)", "cliente", "inner join ruta_agente using(idR_A) inner join ruta using(idruta) inner join empleado using(idEmpleado) where nombreCli like '%" + txtCampo.getText() + "%' and estadoCliente<2"), columnas));
                break;
            case 3:
                System.out.println("Entro a 3:");
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idVenta,nombreCli,tipoVenta,(IF(estadoVenta='1','COMPLETO','INCOMPLETO')) AS estadoVenta,fechaVenta,montoTotalV", "venta", "inner join cliente using(idCliente) inner join ruta_agente using(idR_A) inner join ruta using(idruta) where idCliente = '" + campo.getText() + "' order by fechaVenta desc"), columnas));
                break;
            case 4:
                System.out.println("Entro a 4:");
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idProducto,nombreProd,FORMAT(PrecioGenPV,2),existencia_pieza,nombrecat", "producto", "inner join categoria using(idcategoria) where nombreProd like '%" + txtCampo.getText() + "%'"), columnas));
                break;
            case 5:
                System.out.println("Entro a 5:");
                tabla.setModel(new DefaultTableModel(frmPrincipal.miConex.consDatosParaTablas("idEmpleado,concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp),descRuta,telefonoEmp", "ruta_agente", "inner join ruta using(idRuta) inner join empleado using(idEmpleado) where concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) like '%" + txtCampo.getText() + "%' and tipo='G' order by descruta"), columnas));
                break;
        }
        frmPrincipal.packColumn(tabla, 0, 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtCampo = new javax.swing.JTextField();

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
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
            llenarTabla1();
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
//    public static void main(String x[]){
//        new vizProd(null,true);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCampo;
    // End of variables declaration//GEN-END:variables
}