package difamserv;

import java.util.Vector;
import javax.swing.*;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

public class hiloMail extends Thread {

    String id = "", str_Mensaje = "";
    String str_Para = "";
    int idP = 0;
    JLabel label;
    JLabel productos[];
    DefaultListModel model;
    boolean respResp;

    @Override
    public void run() {
        if (!str_Para.equals("")) {
            if (enviarEmail()) {
                JOptionPane.showMessageDialog(null, ((respResp) ? "Mensaje de promociones enviado con exito!" : "Mensaje de respaldos enviados exitosamente!"));
            } else {
                JOptionPane.showMessageDialog(null, "Por el momento NO SE PUDO ENVIAR el mensaje.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tienes destinatarios a quienes ENVIAR el mensaje.");
        }
    }

    public hiloMail(DefaultListModel model, JLabel productos[], String destinatarios, boolean respResp) {
        this.productos = productos;
        this.model = model;
        this.respResp = respResp;
        str_Para = destinatarios;
    }

    public void obtenerMensaje() {
        str_Mensaje = "Aprovecha hoy! la nueva promoci&#243;n que tenemos para t&#237;:<br><br>";

        for (int i = 0; i < model.size(); i++) {
            Vector productosVal = frmPrincipal.miConex.consDatosParaCampos("idpromo,idproducto,nombreprod,preciopromo,cantidadprod,detallepromo,fechaFin", "promocion", "inner join producto using(idproducto) where idPromo ='" + model.getElementAt(i).toString().substring(0, model.getElementAt(i).toString().indexOf("-")) + "'");
            productosVal = (Vector) productosVal.get(0);
            str_Mensaje += "Promoci&#243;n: " + productosVal.get(0).toString() + "<br>"
                    + "-----------------------------------------------------------------<br>"
                    + "ID: <b>" + productosVal.get(1).toString() + "</b><br>"
                    + "Producto: <b>" + productosVal.get(2).toString() + "</b><br>"
                    + "Precio: <b>" + productosVal.get(3).toString() + "</b><br>"
                    + "Cantidad: <b>" + productosVal.get(4).toString() + "</b><br>"
                    + "Detalle: <b>" + productosVal.get(5).toString() + "</b><br>"
                    + "V&#225;lido hasta: <b>" + productosVal.get(6).toString() + "</b><br>"
                    + "-----------------------------------------------------------------<br>";

        }
        str_Mensaje += "V&#225;lido hasta vencer o agotar existencias.\n";
    }

    public void obtenerRespaldo() {
        str_Mensaje = "&#201;ste mail tiene el Respaldo correspondiente al día " + frmPrincipal.fechaS + ".<br><br>";
        str_Mensaje += "Guardar &#233;ste archivo en ua ruta accesible y proceda a actualizar su sistema.<br><br>";
        str_Mensaje += "Saludos Agente.";
    }

    private boolean enviarEmail() {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            //Recoger los datos
            String str_De = "prikanny@gmail.com";
            String str_PwRemitente = "sagasaguita";

//             = "dany_prica@hotmail.com";
            String str_Asunto = "";
            if (respResp) {
                str_Asunto = "PROMOCIÓN DIFAM";
                obtenerMensaje();
            } else {
                str_Asunto = "RESPALDO DEL DÍA";
                obtenerRespaldo();
            }
            //Obtenemos los destinatarios
            String destinos[] = str_Para.split(",");

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(str_De));

            Address[] receptores = new Address[destinos.length];
            int j = 0;
            while (j < destinos.length) {
                receptores[j] = new InternetAddress(destinos[j]);
                j++;
            }

//            BodyPart texto = new MimeBodyPart();
//            texto.setText(str_Mensaje);
            MimeBodyPart texto = new MimeBodyPart();
            texto.setText(str_Mensaje);
            texto.setContent(str_Mensaje, "text/html");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            if (respResp) {
                adjunto.setDataHandler(
                        new DataHandler(new FileDataSource(frmPrincipal.rutaRaiz + "/SisPuntoVenta/Imgs/difamlogo.gif")));
                adjunto.setFileName("difamlogo.gif");
            } else {
                System.out.println(frmPrincipal.rutaRaiz + "/DIFAM/Respaldos/difam_" + frmPrincipal.fechaS + ".sql");
                adjunto.setDataHandler(
                        new DataHandler(new FileDataSource(frmPrincipal.rutaRaiz + "/DIFAM/Respaldos/difam_" + frmPrincipal.fechaS + ".sql")));
                adjunto.setFileName("difam" + frmPrincipal.fechaS + ".sql");
            }
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            //receptores.
            message.addRecipients(Message.RecipientType.TO, receptores);
            message.setSubject(str_Asunto);
            message.setContent(multiParte);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(str_De, str_PwRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            // Cierre de la conexion.
            t.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
