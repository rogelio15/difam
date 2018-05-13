package panel;

import difamserv.frmPrincipal;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

public class panelVistaReportes extends javax.swing.JPanel {

    public panelVistaReportes(String nombreArchivo,HashMap parametros) {
        initComponents();
        try {
            System.out.println("Reporte visto: " + nombreArchivo);
            JasperPrint reporte = JasperFillManager.fillReport("reportes/"+ nombreArchivo +".jasper",
                                                               parametros,
                                                               frmPrincipal.miConex.getConexion());

            JRViewer x = new JRViewer(reporte);
            x.setFitWidthZoomRatio();
            add(x);
        } catch (Exception error) {
            error.printStackTrace();
            //System.out.println("Mensaje de Error:  " + error.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
