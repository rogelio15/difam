package difamserv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.jbarcodebean.BarcodeException;
import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code39;
import net.sourceforge.jbarcodebean.model.Interleaved25;

public class CODEgenerador {
    
    public CODEgenerador(String codigo, String nombre)throws IOException, BarcodeException {
        JBarcodeBean barcode = new JBarcodeBean();
        // nuestro tipo de codigo de barra
        //barcode.setCodeType(new Interleaved25());
        barcode.setCodeType(new Code39());
        // nuestro valor a codificar y algunas configuraciones mas
        barcode.setCode(codigo);
        barcode.setCheckDigit(true);
        BufferedImage bufferedImage = barcode.draw(new BufferedImage(200, 150, BufferedImage.TYPE_INT_RGB));
        // guardar en disco como png
        File file = new File(frmPrincipal.rutaRaiz + "/DIFAM/Barras/" + nombre + ".png");
        ImageIO.write(bufferedImage, "png", file);
    }
}