package panel;

import dialog.panelCategorias;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class panelPestanas extends javax.swing.JPanel {

    int indice = 0;

    public panelPestanas() {
        initComponents();
        setVisible(true);
//        if(habilitacion.getTipoE() != 'A'){
//            misPestanas.setEnabledAt(2, false);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        misPestanas = new javax.swing.JTabbedPane();
        panelPro = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        panelProd = new javax.swing.JPanel();
        panelEmp = new javax.swing.JPanel();
        panelCat = new javax.swing.JPanel();
        scroll3 = new javax.swing.JScrollPane();
        panelClientes = new javax.swing.JPanel();
        panelMarcas = new javax.swing.JPanel();
        panelFamilias = new javax.swing.JPanel();

        misPestanas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                misPestanasStateChanged(evt);
            }
        });

        panelPro.setLayout(new java.awt.BorderLayout());
        misPestanas.addTab("Proveedor", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), panelPro); // NOI18N

        scroll2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelProd.setBackground(new java.awt.Color(255, 255, 255));
        scroll2.setViewportView(panelProd);

        misPestanas.addTab("Productos", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), scroll2); // NOI18N

        panelEmp.setLayout(new java.awt.BorderLayout());
        misPestanas.addTab("Empleados", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), panelEmp); // NOI18N

        panelCat.setLayout(new java.awt.BorderLayout());
        misPestanas.addTab("Categorias", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), panelCat); // NOI18N

        scroll3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelClientes.setBackground(new java.awt.Color(255, 255, 255));
        scroll3.setViewportView(panelClientes);

        misPestanas.addTab("Clientes", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), scroll3); // NOI18N

        panelMarcas.setLayout(new java.awt.BorderLayout());
        misPestanas.addTab("Marcas", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), panelMarcas); // NOI18N

        panelFamilias.setLayout(new java.awt.BorderLayout());
        misPestanas.addTab("Familias", new javax.swing.ImageIcon(getClass().getResource("/img/E.png")), panelFamilias); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(misPestanas, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(misPestanas, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        misPestanas.getAccessibleContext().setAccessibleName("Categoria");
    }// </editor-fold>//GEN-END:initComponents

    private void misPestanasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_misPestanasStateChanged
        indice = misPestanas.getSelectedIndex();
        switch (indice) {
            case 0:
                agregaPanel(panelPro, new panelProveedores());
                break;
            case 1:
                agregaPanel(panelProd, new panelProducto1());
                break;
            case 2:
                agregaPanel(panelEmp,new panelEmpleados());
                break;
            case 3:
                agregaPanel(panelCat, new panelCategorias());
                break;
            case 4:
                agregaPanel(panelClientes, new panelClientes_2());
                break;
            case 5:
                agregaPanel(panelMarcas, new panelMarcas());
                break;
            case 6:
                agregaPanel(panelFamilias, new panelFamilia());
                break;
        }
}//GEN-LAST:event_misPestanasStateChanged

    public void agregaPanel(JPanel paneUbicacion, JPanel panelVisualiza) {
        paneUbicacion.removeAll();
        paneUbicacion.add(panelVisualiza, BorderLayout.CENTER);
        paneUbicacion.updateUI();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane misPestanas;
    private javax.swing.JPanel panelCat;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelEmp;
    private javax.swing.JPanel panelFamilias;
    private javax.swing.JPanel panelMarcas;
    private javax.swing.JPanel panelPro;
    private javax.swing.JPanel panelProd;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    // End of variables declaration//GEN-END:variables
}
