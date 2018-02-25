package dialog;

import conexiones.consultasMySQL;
import difamserv.CODEgenerador;
import difamserv.frmPrincipal;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.jbarcodebean.BarcodeException;

public class jdGenerarCodigo extends javax.swing.JDialog {

    consultasMySQL consulta = new consultasMySQL();

    public jdGenerarCodigo(java.awt.Frame parent, boolean modal, consultasMySQL consulta, String codigo, String nombre) {
        super(parent, modal);
        initComponents();

        if (codigo.equals("")) {
            btn1.setSelected(true);
            btn1.requestFocus();
        } else {
            btn2.setSelected(true);
            btn2.requestFocus();
        }

        txtNombreImagen.setText(nombre);
        txtCodigo.setText(codigo);
        this.consulta = consulta;
        setTitle("Generador de Barras");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBot = new javax.swing.ButtonGroup();
        txtCodigo = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreImagen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn1 = new javax.swing.JRadioButton();
        btn2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCodigo.setEditable(false);

        btnGenerar.setText("GENERAR CODIGO");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        lblCodigo.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigo.setOpaque(true);

        jLabel1.setText("Nombre de la Imagen: ");

        txtNombreImagen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreImagenKeyReleased(evt);
            }
        });

        jLabel2.setText("Codigo: ");

        grupoBot.add(btn1);
        btn1.setText("GENERACIÓN AUTOMÁTICA");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        grupoBot.add(btn2);
        btn2.setText("INGRESAR CÓDIGO");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("<html><body>NOTA:<br>El nombre del archivo no debe tener caracteres raros como:<br> *,+,'', /, \\\\, etc.</body></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btn2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (!txtNombreImagen.getText().trim().equals("")) {
            if (txtNombreImagen.getText().trim().contains("/")) {
                JOptionPane.showMessageDialog(this, "El nombre del archivo no debe tener caracteres raros como:\n *,+,'', /, \\, etc.");
            } else {
                File x = new File(frmPrincipal.rutaRaiz + "/DIFAM/Barras/" + txtNombreImagen.getText().toString() + ".png");
                if (!x.exists()) {
                    if (btn1.isSelected()) {
                        Random codigo = new Random();
                        int nuevo = codigo.nextInt(1000000000);
                        txtCodigo.setText("" + nuevo);
                        lblCodigo.setText("");
                    }
                    if (btn1.isSelected()) {
                        HashMap dato = consulta.miProducto(txtCodigo.getText());
                        if (dato.isEmpty()) {
                            try {
                                new CODEgenerador(txtCodigo.getText().toString(), txtNombreImagen.getText().toString());
                                lblCodigo.setIcon(new ImageIcon(frmPrincipal.rutaRaiz + "/DIFAM/Barras/" + txtNombreImagen.getText().toString() + ".png"));
                                txtNombreImagen.setText("");
                                txtNombreImagen.requestFocus();

                            } catch (IOException ex) {
                                System.out.println("Error en la generacion del codigo");
                            } catch (BarcodeException ex) {
                                System.out.println("No se encuentra el driver de codigo de barras");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El código ya existe. Genére de Nuevo");
                            txtCodigo.setText("");
                        }
                        txtCodigo.setText("");
                    } else {
                        try {
                            new CODEgenerador(txtCodigo.getText().toString(), txtNombreImagen.getText().toString());
                            lblCodigo.setIcon(new ImageIcon(frmPrincipal.rutaRaiz + "/DIFAM/Barras/" + txtNombreImagen.getText().toString() + ".png"));
                            txtNombreImagen.setText("");
                            txtNombreImagen.requestFocus();

                        } catch (IOException ex) {
                            System.out.println("Error en la generacion del codigo");
                        } catch (BarcodeException ex) {
                            System.out.println("No se encuentra el driver de codigo de barras");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ese nombre ya existe. Elije uno nuevo\n"
                            + "ó elimina el archivo:\n"
                            + (frmPrincipal.rutaRaiz + "/DIFAM/Barras/" + txtNombreImagen.getText().toString() + ".png"), "Alerta!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "PORFAVOR, DALE UN NOMBRE A LA IMAGEN");
            txtNombreImagen.requestFocus();
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //JOptionPane.showMessageDialog(null, "1");
        txtCodigo.setEditable(false);
        txtNombreImagen.requestFocus();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        txtCodigo.setEditable(true);
        txtNombreImagen.requestFocus();
    }//GEN-LAST:event_btn2ActionPerformed

    private void txtNombreImagenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreImagenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreImagenKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn1;
    private javax.swing.JRadioButton btn2;
    private javax.swing.JButton btnGenerar;
    private javax.swing.ButtonGroup grupoBot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreImagen;
    // End of variables declaration//GEN-END:variables
}
