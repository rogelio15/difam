/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * listaCarteras.java
 *
 * Created on 25/04/2014, 07:51:54 PM
 */
package panel;

import dialog.jdAltaPromo;
import difamserv.frmPrincipal;
import difamserv.hiloMail;
import java.awt.Color;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class panelPromos extends javax.swing.JPanel {

    Vector columnas;
    JLabel productos[];
    ImageIcon defaultIcon;
    JPopupMenu menu = new JPopupMenu("Popup");
    JMenuItem item = new JMenuItem("Eliminar");
    JMenuItem add = new JMenuItem("Enlistar");
    String id = "", str_Mensaje = "";
    Vector mails;
    String str_Para = "";
    int idP = 0;
    JLabel label;
    DefaultListModel model = new DefaultListModel();

    public panelPromos() {
        initComponents();
        mails = frmPrincipal.miConex.consDatosParaCampos("email", "cliente", "where email!='' and email!='NO'");

        for (int i = 0; i < mails.size(); i++) {
            if (str_Para.equals("")) {
                str_Para = (((Vector) mails.get(i)).get(0).toString());
            } else {
                str_Para += ("," + ((Vector) mails.get(i)).get(0).toString());
            }
        }

        System.out.println(str_Para);

        defaultIcon = new ImageIcon(getClass().getResource("/img/bagP.png"));
        //llenarTabla("where idCliente like '%%' order by fechaVenta desc");
        llenarCuadros();
        item.setIcon(new ImageIcon(getClass().getResource("/img/delete16.png")));
        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Está seguro de eliminar\nésta promoción", "Atención usuario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    spaProds.removeAll();        
                    frmPrincipal.miConex.eliminaRegistro("promocion", "idPromo", id);
                    llenarCuadros();
                    spaProds.updateUI();
                }
            }
        });
        add.setIcon(new ImageIcon(getClass().getResource("/img/add.png")));
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (label.isEnabled()) {
                    model.addElement(id + "-" + label.getText().substring(label.getText().indexOf("<b>") + 3, label.getText().indexOf("</b>")));
                    lstPromos.setModel(model);
                }else{
                    JOptionPane.showMessageDialog(null, "No podrá enlistar éste producto porque ha vencido la fecha de promoción,\nle recomendamos eliminarlo de la lista.");
                }
            }
        });

    }

    public void llenarCuadros() {
        Vector prods = frmPrincipal.miConex.consDatosParaTablas("idpromo,idproducto,nombreprod,preciopromo,cantidadprod,fechaFin", "promocion", "inner join producto using(idproducto)");
        productos = new JLabel[prods.size()];
        if (!prods.isEmpty()) {
            for (int i = 0; i < prods.size(); i++) {
                Vector dato = (Vector) prods.get(i);
                productos[i] = new JLabel("<html><body align='center'><b>" + dato.get(2) + "</b><br>Precio:<b> " + dato.get(3) + "</b><br>Cantidad:<b> " + dato.get(4) + "</b><br>Válido hasta: <b>" + dato.get(5) + "</b></body></html>");
                productos[i].setToolTipText(dato.get(0).toString());
                frmPrincipal.cargaImagen("foto", "producto", "where idproducto='" + dato.get(1) + "'", productos[i], 150, 150, defaultIcon);
                productos[i].setHorizontalAlignment(JLabel.CENTER);
                productos[i].setHorizontalTextPosition(JLabel.CENTER);
                productos[i].setVerticalTextPosition(JLabel.BOTTOM);
                productos[i].setBorder(BorderFactory.createEtchedBorder());
                productos[i].setBackground(Color.WHITE);
                productos[i].setOpaque(true);

                spaProds.add(productos[i]);
                productos[i].setEnabled(Boolean.parseBoolean(((Vector) frmPrincipal.miConex.consDatosParaCampos("(IF(DATEDIFF(fechaFIN,NOW())>=0,'true','false')) AS ESTADO", "promocion", " inner join producto using(idproducto) where idProducto='" + dato.get(1) + "'").get(0)).get(0).toString()));
                productos[i].addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        id = ((JLabel) e.getSource()).getToolTipText().toString();
                        label = ((JLabel) e.getSource());
                        menu.add(item);
                        menu.add(add);
                        menu.show(e.getComponent(), e.getX(), e.getY());
                        System.out.println("");
                    }
                    public void mousePressed(MouseEvent e) {
                    }
                    public void mouseReleased(MouseEvent e) {
                    }
                    public void mouseEntered(MouseEvent e) {
                    }
                    public void mouseExited(MouseEvent e) {
                    }
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAPromo = new javax.swing.JButton();
        spaProdssc = new javax.swing.JScrollPane();
        spaProds = new javax.swing.JPanel();
        btnDetalle2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPromos = new javax.swing.JList();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnAPromo.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnAPromo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/email.png"))); // NOI18N
        btnAPromo.setText("<HTML><BODY>ENVIAR MAIL<BR> A CLIENTES</BODY></HTML>");
        btnAPromo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAPromo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPromoActionPerformed(evt);
            }
        });

        spaProds.setBackground(new java.awt.Color(255, 255, 255));
        spaProds.setLayout(new java.awt.GridLayout(0, 5));
        spaProdssc.setViewportView(spaProds);

        btnDetalle2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnDetalle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/promoAdd.png"))); // NOI18N
        btnDetalle2.setText("<HTML><BODY>AÑADIR<BR> PROMO</BODY></HTML>");
        btnDetalle2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetalle2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetalle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalle2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(lstPromos);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("TODAS");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("LISTA DE PROMOCIONES A INFORMAR A CLIENTES:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spaProdssc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetalle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaProdssc, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDetalle2)
                    .addComponent(btnAPromo))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnAPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPromoActionPerformed
        Thread hilo = new hiloMail(model,productos,str_Para,true);
        hilo.start();
    }//GEN-LAST:event_btnAPromoActionPerformed

    private void btnDetalle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalle2ActionPerformed
        new jdAltaPromo(null,true);
        spaProds.removeAll();
        llenarCuadros();
        spaProds.updateUI();
        
    }//GEN-LAST:event_btnDetalle2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        model = new DefaultListModel();
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].isEnabled()) {
                model.addElement(productos[i].getToolTipText() + " - " + productos[i].getText().substring(productos[i].getText().indexOf("<b>") + 3, productos[i].getText().indexOf("</b>")));
            }
        }
        lstPromos.setModel(model);
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAPromo;
    private javax.swing.JButton btnDetalle2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstPromos;
    private javax.swing.JPanel spaProds;
    private javax.swing.JScrollPane spaProdssc;
    // End of variables declaration//GEN-END:variables
}
