/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difamserv;

import javax.swing.UIManager;

/**
 *
 * @author Rogelio
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("swing.defaultlaf=com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("swing.defaultlaf=com.sun.javax.swing.plaf.mac.MacLookAndFeel");
            
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(System.getProperty("user.home"));
        //new splash();
        new InicioDeSesion();
    }
}
