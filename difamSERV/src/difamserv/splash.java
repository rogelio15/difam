package difamserv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class splash extends javax.swing.JFrame implements Runnable {

    JProgressBar progreso = new JProgressBar(0, 100);
    public Timer timer;
    int i;
    JPanel panelC;
    Thread hilo;

    @Override
    public void run() {
        new InicioDeSesion();
        System.out.println("principal creado");
    }

    public splash() {
        initComponents();
        setTitle("Cargando...");
        progreso.setBorderPainted(false);
        progreso.setBackground(new Color(226, 196, 150));
        hilo = new Thread(this);
        timer = new Timer(50, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (i == 90) {
                    hilo.start();
                    System.out.println("Hilo llamao");
                }
                if (i == 100) {
                    Toolkit.getDefaultToolkit().beep();
                    timer.stop();
                    setVisible(false);
                    dispose();
                    progreso.setValue(0);
                }
                i = i + 2;
                progreso.setValue(i);
            }
        });

        panelC = new JPanel(new BorderLayout()) {

            public void paintComponent(Graphics g) {
                Dimension tamanio = getSize();
                ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/miSplash.png"));
                g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        panelC.add(progreso, BorderLayout.SOUTH);
        add(panelC, BorderLayout.CENTER);
        setSize(400, 270);

        setLocationRelativeTo(null);
        setVisible(true);

        progreso.setValue(0);
        i = 0;
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new splash().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
