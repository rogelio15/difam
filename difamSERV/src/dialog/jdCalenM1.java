package dialog;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.*;

public class jdCalenM1 extends javax.swing.JDialog {

    int diaB = 1, mesB = 0, anioB = 0, diaS = 1;
    final int DIASSEMANA = 7;
    JLabel nombreMes;
    int valor = 0;
    String textoTitulo = "Calendario - v1.0. - Nny's Systems";
    int cont = 0;
    JButton botones[] = new JButton[49];
    String meses[] = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
    String dias[] = {"DOM", "LUN", "MAR", "MIER", "JUE", "VIER", "SAB"};
    char modulo;

    public jdCalenM1(java.awt.Frame parent, boolean modal, char modulo) {
        super(parent, modal);
        initComponents();
        paneBotones.setLayout(new GridLayout(7, 7, 4, 4));
        this.modulo = modulo;
        llenarPanel();
        cambiaMes();
        paneBotones.setSize(376, 300);
        setTitle(textoTitulo);
        setSize(355, 318);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        panelAS = new javax.swing.JPanel();
        btnA = new javax.swing.JButton();
        txtMes = new javax.swing.JTextField();
        btnS = new javax.swing.JButton();
        paneBotones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setLayout(new java.awt.BorderLayout());

        panelAS.setLayout(new javax.swing.BoxLayout(panelAS, javax.swing.BoxLayout.LINE_AXIS));

        btnA.setText("Anterior");
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        panelAS.add(btnA);

        txtMes.setForeground(new java.awt.Color(51, 0, 153));
        txtMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMes.setOpaque(false);
        panelAS.add(txtMes);

        btnS.setText("Siguiente");
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });
        panelAS.add(btnS);

        jPanel4.add(panelAS, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout paneBotonesLayout = new javax.swing.GroupLayout(paneBotones);
        paneBotones.setLayout(paneBotonesLayout);
        paneBotonesLayout.setHorizontalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        paneBotonesLayout.setVerticalGroup(
            paneBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jPanel4.add(paneBotones, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Dato:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 239, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarPanel() {
        for (int i = 0; i < dias.length; i++) {
            JLabel dia = new JLabel(dias[i]);
            dia.setOpaque(true);
            dia.setHorizontalAlignment(JLabel.CENTER);
            paneBotones.add(dia);
        }

        for (int i = 1; i <= 42; i++) {
            botones[i - 1] = new JButton();
            paneBotones.add(botones[i - 1]);
        }
        paneBotones.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        panelAS.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
    }

    public void cambiaMes() {
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.add(Calendar.MONTH, valor);

        int indiceActual = (DIASSEMANA * (fechaActual.get(Calendar.WEEK_OF_MONTH) - 1)) + fechaActual.get(Calendar.DAY_OF_WEEK);
        if (indiceActual == fechaActual.get(Calendar.DAY_OF_MONTH)) {
            indiceActual += 7;
        }

        for (int i = 1; i <= 42; i++) {
            botones[i - 1].setEnabled(true);
            botones[i - 1].setForeground(Color.BLACK);
            if (i == indiceActual) {
                botones[i - 1].setText("" + fechaActual.get(Calendar.DAY_OF_MONTH));
                botones[i - 1].setActionCommand("" + fechaActual.get(Calendar.DAY_OF_MONTH) + "|" + fechaActual.get(Calendar.DAY_OF_WEEK));
                botones[i - 1].setForeground(Color.RED);
            } else {
                botones[i - 1].setText("");
            }
        }
        int mes = fechaActual.get(Calendar.MONTH);
        for (int i = indiceActual - 2; i >= 0; i--) {
            fechaActual.add(Calendar.DAY_OF_MONTH, -1);
            botones[i].setText("" + fechaActual.get(Calendar.DAY_OF_MONTH));
            if (mes != fechaActual.get(Calendar.MONTH)) {
                botones[i].setEnabled(false);
                botones[i].setForeground(Color.GRAY);
            } else {
                botones[i].setActionCommand("" + fechaActual.get(Calendar.DAY_OF_MONTH) + "|" + fechaActual.get(Calendar.DAY_OF_WEEK));
            }
        }

        fechaActual = Calendar.getInstance();
        fechaActual.add(Calendar.MONTH, valor);
        mes = fechaActual.get(Calendar.MONTH);
        for (int i = indiceActual; i < 42; i++) {
            fechaActual.add(Calendar.DAY_OF_MONTH, 1);
            botones[i].setText("" + fechaActual.get(Calendar.DAY_OF_MONTH));
            if (mes != fechaActual.get(Calendar.MONTH)) {
                botones[i].setEnabled(false);
                botones[i].setForeground(Color.GRAY);
            } else {
                botones[i].setActionCommand("" + fechaActual.get(Calendar.DAY_OF_MONTH) + "|" + fechaActual.get(Calendar.DAY_OF_WEEK));
            }
        }
        fechaActual = Calendar.getInstance();
        fechaActual.add(Calendar.MONTH, valor);
        txtMes.setText(meses[fechaActual.get(Calendar.MONTH)] + ", " + fechaActual.get(Calendar.YEAR));

        diaB = fechaActual.get(Calendar.DAY_OF_MONTH);
        mesB = fechaActual.get(Calendar.MONTH);
        anioB = fechaActual.get(Calendar.YEAR);
        diaS = fechaActual.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i < 42; i++) {
            botones[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    diaB = Integer.parseInt(evt.getActionCommand().substring(0, evt.getActionCommand().indexOf("|")));
                    diaS = Integer.parseInt(evt.getActionCommand().substring(evt.getActionCommand().indexOf("|") + 1));
                    String fecha = anioB + "-" + String.format("%02d", (mesB + 1)) + "-" + String.format("%02d", (diaB));
                    HashMap parametro = new HashMap();
                    parametro.put("fecha", fecha);
                    String archivo = "";
                    switch (modulo) {
                        case '1':
                            archivo = "ventaPorDia";
//                            archivo = "cortedecajaxdia";
                            break;
                        case '2':
                            archivo = "pagosxdia";
                            break;
                        case '3':
                            archivo = "inventariadoxdia";
                            break;
                        case '4':
                            archivo = "contVProdDia";
                            break;
                    }

                    //frmPrincipal.agregaPanel(new VistaReportes(archivo, parametro));
                    //new Preview(null, true, archivo, parametro);
                    dispose();
//                    new Preview(null, true, archivo, parametro);
//                    dispose();
                }
            });
        }
    }

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        paneBotones.removeAll();
        valor--;
        llenarPanel();
        cambiaMes();
}//GEN-LAST:event_btnAActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        paneBotones.removeAll();
        valor++;
        llenarPanel();
        cambiaMes();
}//GEN-LAST:event_btnSActionPerformed
//    /**
//    * @param args the command line arguments
//    */
//    public static void main(String args[]) {
//        try{
//           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        new fecha(null,true);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnS;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel paneBotones;
    private javax.swing.JPanel panelAS;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
