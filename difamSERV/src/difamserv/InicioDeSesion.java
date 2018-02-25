package difamserv;

import dialog.frmConf;
import conexiones.conexionMySQL;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Vector;
import javax.swing.JOptionPane;

public class InicioDeSesion extends javax.swing.JFrame {

    conexionMySQL mysql;

    public InicioDeSesion(){
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setTitle("Sist. Punto de Venta - v1.0");

//        /* DEFINIR IP DE SERVIDOR PARA CONEXION*/
//        File sarchivo = new File("conf.bat");
//        String direccionIP = "", palabra;
//        if (sarchivo.exists()) {
//            try {
//                FileReader lectura = new FileReader(sarchivo);
//                BufferedReader contenido = new BufferedReader(lectura);
//                while ((palabra = contenido.readLine()) != null) {
//                    direccionIP = palabra;
//                }
////                String[] arreglo = direccionIP.toCharArray();
//            } catch (IOException ex) {
//                Logger.getLogger(InicioDeSesion.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        File sarchivo = new File("conf.dcc");
        if (!sarchivo.exists()) {
            new frmConf(this, true);
            new InicioDeSesion();
        } else {
            setVisible(true);
            mysql = new conexionMySQL();
        }

        txtUsuario.setText("admin");
        txtContrasena.setText("admin");
        System.out.println("Iniciando el usuario");
        btnIniciarActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Inicio de Sesion :.");
        setBackground(new java.awt.Color(0, 0, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnIniciar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setActionCommand("Iniciar Sesión");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtUsuario.setBackground(new java.awt.Color(153, 153, 255));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setText("admin");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        txtContrasena.setBackground(new java.awt.Color(153, 153, 255));
        txtContrasena.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtContrasena.setText("admin");
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyPressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ini.png"))); // NOI18N

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/titIS.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContrasena))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIniciar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciar)
                            .addComponent(btnCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de introducir un Nombre", "Validacion", JOptionPane.ERROR_MESSAGE);
            txtUsuario.requestFocus();
        } else if (txtContrasena.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de introducir una Contraseña", "Validacion", JOptionPane.ERROR_MESSAGE);
            txtContrasena.requestFocus();
        } else {
            //mysql = new conexionMySQL();
            Vector usuario = mysql.ValidaUsuario(txtUsuario.getText().toString().toLowerCase(), txtContrasena.getText().trim().toLowerCase().toString());
            if (!usuario.isEmpty()) {
                if (!usuario.get(2).toString().equals("G")){
                    new frmPrincipal(usuario, mysql);
                    dispose();
                }else{
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "El tipo de usuario que intenta accesar es un Agente,\nusted no tiene acceso al sistema de ALMACEN,\nsolicite ser cambiado de tipo de Usuario", "Validación", JOptionPane.ERROR_MESSAGE);
                    setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no Valido", "Validacion", JOptionPane.ERROR_MESSAGE);
                txtUsuario.setText("");
                txtContrasena.setText("");
                txtUsuario.requestFocus();
            }
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtContrasena.requestFocus();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciarActionPerformed(null);
        }
    }//GEN-LAST:event_txtContrasenaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}