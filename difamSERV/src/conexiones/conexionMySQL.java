package conexiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utilidades.RedondearDouble;

public class conexionMySQL {

    private Connection conexion;
    private ResultSet miConsulta;
    private Statement miSentenciaSQL;
    private String IP = "127.0.0.1";
    private String BD = "comdifam";
    private String USUARIO = "root";
    private String CONTRA = "mysql123";
    private String PUERTO = "3306";

    public void analizaarchivo() {
        File sarchivo = new File("conf.dcc");
        String direccionIP = "", palabra;
        if (sarchivo.exists()) {
            try {
                FileReader lectura = new FileReader(sarchivo);
                BufferedReader contenido = new BufferedReader(lectura);
                while ((palabra = contenido.readLine()) != null) {
                    direccionIP = palabra;
                }
            } catch (IOException ex) {
                System.out.println("Error de lectura de archivo");
            }
            String palabritas[] = direccionIP.split(":");
            BD = palabritas[1];
            USUARIO = palabritas[2];
            IP = palabritas[3];
            PUERTO = palabritas[4];
            CONTRA = palabritas[5];
        }
    }

    public conexionMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            analizaarchivo();
            //conexion = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PUERTO + "/" + BD, USUARIO, CONTRA);
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/comdifam", "root", "mysql123");
            System.out.println("BIENVIENIDOS a la conexion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion con el Servidor");
            System.out.println("Error de Conexion: " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver NO encontrado");
            System.out.println("Error Driver: " + ex);
        }
    }

    public void prueba() {
        System.out.println("Aki prueba");
    }

    /*public boolean actualizaCLON(String fecha) {
     boolean siono = false;
     try {
     miSentenciaSQL = conexion.createStatement();
     miConsulta = miSentenciaSQL.executeQuery("SELECT fechaInv FROM existencia where fechaInv='" + fecha + "';");
     System.out.println("ptm CLON");
     if (miConsulta.next()) {
     System.out.println("Hay dato");
     if (miConsulta.getString("fechaInv").equals(fecha)) {
     System.out.println("Fecha: " + miConsulta.getString("fechaInv"));
     siono = true;
     }
     }
     miConsulta.close();
     miSentenciaSQL.close();
     } catch (SQLException er) {
     }
     return siono;
     }*/

    /*public void copiarDatos() {
     try {
     miSentenciaSQL = conexion.createStatement();
     //miSentenciaSQL.executeQuery("DELETE FROM existencia;");
     miSentenciaSQL.executeUpdate("INSERT INTO existencia SELECT null,clave,nombreM,existencia,date(now()) FROM medicamento;");
     miSentenciaSQL.close();
     } catch (SQLException er) {
     }
     }*/
    public double consultaPrecioImpuesto(String idProducto) {
        System.out.println("Id producto" + idProducto);
        System.out.println("entrando al metodo para consultar el precio con impuesto");
        Double precioImpuesto = 0.0;
        System.out.println("Entrando al catc");
        try {
            System.out.println("Dentro del catch");
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("SELECT precioCImpuesto FROM producto WHERE idProducto = '" + idProducto + "';");
            if (miConsulta.next()) {
                precioImpuesto = miConsulta.getDouble(idProducto);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de precio con impuesto:\n" + ex);
        }

        return precioImpuesto;
    }

    public boolean actualizaRegistro(String tabla, String ClaveNueva, String ClaveAnt) {
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("UPDATE " + tabla + " SET " + ClaveNueva + " WHERE " + ClaveAnt + ";");
            miSentenciaSQL.executeUpdate("UPDATE " + tabla + " SET " + ClaveNueva + " WHERE " + ClaveAnt + ";");
            miSentenciaSQL.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar la Tabla: " + tabla);
            return false;
        }
    }

    public boolean altaRegistro(String tabla, String valores) {
        boolean bandera = false;
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("INSERT INTO " + tabla + " VALUES(" + valores + ");");
            miSentenciaSQL.executeUpdate("INSERT INTO " + tabla + " VALUES(" + valores + ");");
            miSentenciaSQL.close();
            bandera = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de alta: " + tabla);
        }
        return bandera;
    }

    public boolean insertarActualizarImpProd(ArrayList arr, String idProd) {
        boolean resp = false;
        try {
            miSentenciaSQL = conexion.createStatement();
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("INSERT INTO producto_impuesto VALUES(null," + arr.get(i) + ",'" + idProd + "');");
                miSentenciaSQL.executeUpdate("INSERT INTO producto_impuesto VALUES(null," + arr.get(i) + ",'" + idProd + "');");
            }
            miSentenciaSQL.close();
            resp = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de alta de producto_impuesto ");
        }
        return resp;
    }

//    public boolean eliminarProducto(String tabla, String id){
//         try {
//             System.out.println("actualizando status");
//            miSentenciaSQL = conexion.createStatement();
//            System.out.println("UPDATE " + tabla + " SET status = false WHERE id =" + id +";");
//            miSentenciaSQL.executeUpdate("UPDATE " + tabla + " SET status = false WHERE idProducto = '"+id+"';");
//            miSentenciaSQL.close();
//            return true;
//        } catch (SQLException ex) {
//            System.out.println("Error al Actualizar la Tabla: " + tabla);
//            return false;
//        }
//         
//    }
    public void eliminaRegistro(String tabla, String campoClave, String id) {
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("DELETE FROM " + tabla + " WHERE " + campoClave + " = '" + id + "';");
            System.out.println("Entrando al delete");
            miSentenciaSQL.executeUpdate("DELETE FROM " + tabla + " WHERE " + campoClave + " = '" + id + "';");
            System.out.println("Eliminado...");
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "Este valor NO puede ser eliminado, ya que\n"
                        + "hay datos que dependen de el", "ERROR DE ELIMINACION RESTRINGIDA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error en la eliminacion del datos");
            }
            System.out.println("Error Eliminando " + tabla + ": " + ex);
        }
    }

    public void eliminaRegistro(String tabla, String condicion) {
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("DELETE FROM " + tabla + " WHERE " + condicion + ";");
            miSentenciaSQL.executeUpdate("DELETE FROM " + tabla + " WHERE " + condicion + ";");
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "Este valor NO puede ser eliminado, ya que\n"
                        + "hay datos que dependen de el", "ERROR DE ELIMINACION RESTRINGIDA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error en la eliminacion del datos");
            }
            System.out.println("Error Eliminando " + tabla + ": " + ex);
        }
    }

    public int obtenerImpuesto(String datos, int valor) {
        int resultado = 0;
        try {
            miSentenciaSQL = conexion.createStatement();

            if (valor == 1) {
                miConsulta = miSentenciaSQL.executeQuery("select idImpuesto from impuesto where nomImpuesto ='" + datos + "';");
                System.out.println(" rzm select idImpuesto from impuesto where nomImpuesto ='" + datos + "';");
                datos = "";
            } else {
                miConsulta = miSentenciaSQL.executeQuery("select idImpuesto from impuesto where equivalenteImp  ='" + datos + "';");
                System.out.println("select idImpuesto from impuesto where ='" + datos + "';");
                datos = "";
            }

            while (miConsulta.next()) {
                resultado = miConsulta.getInt(1);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (Exception e) {
            System.out.println("Error en la consulta " + e);
        }
        return resultado;
    }

    public String ConsultaDato(String dato, String tabla, String condicion) {
        String campo = "";
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("Datos:");
            System.out.println("select " + dato + " from " + tabla + " " + condicion);
            miConsulta = miSentenciaSQL.executeQuery("select " + dato + " from " + tabla + " " + condicion + ";");
            if (miConsulta.next()) {
                campo = miConsulta.getString(dato);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta campo!!!");
        }
        System.out.println(campo);
        return campo;
    }

    public Vector consDatosParaCampos(String campos, String tabla, String condicion) {
        Vector registros = new Vector();
        System.out.println("select " + campos + " from " + tabla + " " + condicion + ";");
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("select " + campos + " from " + tabla + " " + condicion + ";");
            while (miConsulta.next()) {
                Vector fila = new Vector();
                for (int i = 1; i <= miConsulta.getMetaData().getColumnCount(); i++) {
                    System.out.println(miConsulta.getString(i));
                    fila.add(miConsulta.getString(i));
                }
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta y llenado del vector....");
        }
        return registros;
    }

    public Vector consDatosParaTablas(String campos, String tabla, String condicion) {
        Vector registros = new Vector();
        System.out.println("select " + campos + " from " + tabla + " " + condicion + ";");
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("select " + campos + " from " + tabla + " " + condicion + ";");
            while (miConsulta.next()) {
                Vector fila = new Vector();
                for (int i = 1; i <= miConsulta.getMetaData().getColumnCount(); i++) {
//                    JLabel etiqueta = new JLabel(miConsulta.getString(i));
//                    etiqueta.setBorder(new EmptyBorder(20, 5, 20, 5));
//                    etiqueta.setFont(new Font("Calibri", Font.BOLD, 13));
//                    fila.add(etiqueta);
//                    System.out.println(miConsulta.getString(i));
                    fila.add(miConsulta.getString(i));
                }
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta y llenado del vector....");
        }
        return registros;
    }

//    public boolean actualizaRegistro(String tabla, String ClaveNueva, String ClaveAnt){
//        boolean res = false;
//        try {
//            System.out.println("UPDATE "+ tabla +" SET "+ ClaveNueva +" WHERE "+ ClaveAnt +";");
//            miSentenciaSQL = conexion.createStatement();
//            miSentenciaSQL.executeUpdate("UPDATE "+ tabla +" SET "+ ClaveNueva +" WHERE "+ ClaveAnt +";");
//            miSentenciaSQL.close();
//            res=true;
//        } catch (SQLException ex) {
//            System.out.println("Error al Actualizar la Tabla: " + tabla);
//        }
//        return res;
//    }
    public boolean actualizaProducto(String datos, String idP) {
        boolean respuesta = false;
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("UPDATE " + datos + " WHERE idProducto='" + idP + "';");
            miSentenciaSQL.executeUpdate("UPDATE " + datos + " WHERE idProducto='" + idP + "';");
            miSentenciaSQL.close();
            respuesta = true;
        } catch (SQLException ex) {
            System.out.println("Error al momento de: actualizaProducto");
            ex.getStackTrace();
        }
        return respuesta;
    }

    public Vector historialEmpleado(String consulta) {
        Vector registros = new Vector();
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery(consulta);

            while (miConsulta.next()) {
                Vector fila = new Vector();
                fila.add(miConsulta.getString("idVenta"));
                fila.add(miConsulta.getString("fechaVenta"));
                fila.add(miConsulta.getString("horaV"));
                fila.add(miConsulta.getString("montoTotalV"));
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta Historial Empleado....");
        }
        return registros;
    }

    public boolean guardarEmpleado(String n, String ap, String am, Date fn, String d, String tel, String rutaFoto) {
        boolean bandera = false;
        boolean band = false;
        {
            FileInputStream fis = null;
            try {
                File file = new File(rutaFoto);
                fis = new FileInputStream(file);
                PreparedStatement pstm = conexion.prepareStatement("INSERT INTO "
                        + " empleado(idEmpleado,nombreEmp,apellidoPatEmp,apellidoMatEmp,fechaNac,direccionEmp,telefonoEmp,foto)"
                        + " VALUES(null,?,?,?,?,?,?,?);");

                pstm.setString(1, n);
                pstm.setString(2, ap);
                pstm.setString(3, am);
                pstm.setDate(4, fn);
                pstm.setString(5, d);
                pstm.setString(6, tel);
                pstm.setBinaryStream(7, fis, (int) file.length());
                pstm.execute();
                pstm.close();
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException: " + ex);
            } catch (SQLException e) {
                System.out.println("Imagen muy grande... ELIGE UNA MENOR A 60 KB");
                band = true;
            } finally {
                try {
                    fis.close();
                    if (band != true) {
                        bandera = true;
                    }
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex);
                }
            }
        }
        return bandera;
    }

    /*public Vector consultaMed(int opcion, String nombre) {
     Vector registros = new Vector();
     try {
     miSentenciaSQL = conexion.createStatement();
     if (opcion == 1) {
     miConsulta = miSentenciaSQL.executeQuery("SELECT * FROM medicamento WHERE codbarras = '" + nombre + "' ORDER BY clave;");
     } else if (opcion == 0) {
     miConsulta = miSentenciaSQL.executeQuery("SELECT * FROM medicamento WHERE nombreM like '%" + nombre + "%' ORDER BY nombreM ASC;");
     } else if (opcion == 3) {
     miConsulta = miSentenciaSQL.executeQuery("SELECT * FROM medicamento WHERE clave = '" + nombre + "' ORDER BY clave;");
     }
     while (miConsulta.next()) {
     Vector fila = new Vector();
     fila.add(miConsulta.getString("clave"));
     fila.add(miConsulta.getString("nombreM"));
     fila.add(miConsulta.getString("especificacion"));
     fila.add(miConsulta.getString("ubicacion"));
     fila.add(miConsulta.getString("existencia"));
     registros.add(fila);
     }
     miConsulta.close();
     miSentenciaSQL.close();
     } catch (SQLException er) {
     System.out.println("Error en la consulta....");
     }
     return registros;
     }*/
    public Vector consultaEmp() {
        Vector registros = new Vector();
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("SELECT * FROM empleado ORDER BY tipo ASC;");

            while (miConsulta.next()) {
                Vector fila = new Vector();
                fila.add(miConsulta.getString("idEmpleado"));
                fila.add(miConsulta.getString("nombreE") + " " + miConsulta.getString("apellidoP") + " " + miConsulta.getString("apellidoM"));
                fila.add(miConsulta.getString("fechaNac"));
                fila.add(((miConsulta.getString("tipo").charAt(0) != 'A') ? ((miConsulta.getString("tipo").charAt(0) != 'C') ? "EMPLEADO" : "CONSULTOR") : "ADMINISTRADOR"));
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta....");
        }
        return registros;
    }

    public boolean guardarProducto(String p, String n, String pv, String pc, String prov, String cat, String rutaFoto) {
        boolean bandera = false;
        boolean band = false;
        {
            FileInputStream fis = null;
            try {
                File file = new File(rutaFoto);
                fis = new FileInputStream(file);
                PreparedStatement pstm = conexion.prepareStatement("INSERT INTO "
                        + " producto(idProducto,nombreProd,precioV,precioC,idProveedor,idCategoria,foto,existencia)"
                        + " VALUES(?,?,?,?,?,?,?,?)");
                pstm.setString(1, p);
                pstm.setString(2, n);
                pstm.setDouble(3, Double.parseDouble(pv));
                pstm.setDouble(4, Double.parseDouble(pc));
                pstm.setInt(5, Integer.parseInt(prov));
                pstm.setInt(6, Integer.parseInt(cat));
                pstm.setBinaryStream(7, fis, (int) file.length());
                pstm.setInt(8, 1);
                pstm.execute();
                pstm.close();
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException: " + ex);
            } catch (SQLException e) {
                System.out.println("Imagen muy grande... ELIGE UNA MENOR A 60 KB");
                band = true;
            } finally {
                try {
                    fis.close();
                    if (band != true) {
                        bandera = true;
                    }
                } catch (IOException ex) {
                    System.out.println("IOException: " + ex);
                }
            }
        }
        return bandera;
    }

    /*public boolean altasMedEmpl(String d1, String d2, String d3, String d4, String d5, String d6, int opcion) {
     boolean respuesta = false;
     try {
     miSentenciaSQL = conexion.createStatement();
     if (opcion != 0) {
     miSentenciaSQL.executeUpdate("INSERT INTO medicamento VALUES('" + d1 + "','" + d2 + "','" + d3 + "','" + d4 + "','" + d5 + "','" + d6 + "',0);");
     respuesta = true;
     } else {
     miSentenciaSQL.executeUpdate("INSERT INTO empleado VALUES('" + d1 + "','" + d2 + "','" + d3 + "','" + d4 + "','" + d5 + "','" + d6.charAt(0) + "');");
     respuesta = true;
     }
     miSentenciaSQL.close();
     } catch (SQLException ex) {
     System.out.println("Error en Altas: " + ex);
     }
     return respuesta;
     }
     */
    public void insertaUsuario(String nick, String contra, char tipo, String idE) {
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("INSERT INTO usuario VALUES(null,'" + nick + "','" + contra + "','" + idE + "');");
            miSentenciaSQL.executeUpdate("INSERT INTO usuario VALUES(null,'" + nick + "','" + contra + "','" + idE + "');");
            System.out.println("UPDATE empleado SET tipo='" + tipo + "' WHERE idEmpleado=" + idE);
            miSentenciaSQL.executeUpdate("UPDATE empleado SET tipo='" + tipo + "' WHERE idEmpleado=" + idE);
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
        }
    }

    /*public void borrarDatos(String id, int opcion) {
     try {
     miSentenciaSQL = conexion.createStatement();
     if (opcion != 0) {
     miSentenciaSQL.executeUpdate("DELETE FROM medicamento WHERE clave='" + id + "';");
     JOptionPane.showMessageDialog(null, "Medicamento Eliminado...", "EXITO", JOptionPane.INFORMATION_MESSAGE);
     } else {
     miSentenciaSQL.executeUpdate("DELETE FROM empleado WHERE idEmpleado = '" + id + "';");
     JOptionPane.showMessageDialog(null, "Empleado Eliminado...", "EXITO", JOptionPane.INFORMATION_MESSAGE);
     }
     miSentenciaSQL.close();
     } catch (SQLException ex) {
     System.out.println("Error en Altas: " + ex);
     System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
     }
     }*/
    public String idSurtido(String fecha) {
        String idS = "";
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("SELECT idSurtido FROM surtido WHERE fechaS='" + fecha + "';");
            if (miConsulta.next()) {
                idS = miConsulta.getString("idSurtido").toString();
            }
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
        return idS;
    }

    public String idExpedicion(String fecha) {
        String idS = "";
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("SELECT idCompra FROM compra WHERE fechaCompra='" + fecha + "';");
            miConsulta = miSentenciaSQL.executeQuery("SELECT idCompra FROM compra WHERE fechaCompra='" + fecha + "';");
            if (miConsulta.next()) {
                idS = miConsulta.getString("idCompra").toString();
            }
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
        return idS;
    }

    public String idExpedicion(String fecha, String prov) {
        String idS = "";
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("SELECT idCompra FROM compra WHERE fechaCompra='" + fecha + "' and idproveedor='" + prov + "';");
            miConsulta = miSentenciaSQL.executeQuery("SELECT idCompra FROM compra WHERE fechaCompra='" + fecha + "' and idproveedor='" + prov + "';");
            if (miConsulta.next()) {
                idS = miConsulta.getString("idCompra").toString();
            }
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
        return idS;
    }

    public String crearVenta(String fecha, String idEmpleado) {
        String idS = "";
        try {
            miSentenciaSQL = conexion.createStatement();
            miSentenciaSQL.executeUpdate("INSERT INTO surtido VALUES(null,'" + fecha + "','" + idEmpleado + "')");

            miConsulta = miSentenciaSQL.executeQuery("SELECT idSurtido FROM surtido WHERE fechaS='" + fecha + "';");
            if (miConsulta.next()) {
                idS = miConsulta.getString("idSurtido").toString();
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
        return idS;
    }

    public String crearExpendio(String fecha, String hora, String idEmpleado, Double montoTC, String idProv) {
        String idS = "";
        System.out.println("fecha: " + fecha);
        System.out.println("idE: " + idEmpleado);
        try {
            miSentenciaSQL = conexion.createStatement();
            miSentenciaSQL.executeUpdate("INSERT INTO compra VALUES(null,'" + fecha + "','" + hora + "'," + montoTC + ",0,'C',0,'" + idProv + "','" + idEmpleado + "')");

            miConsulta = miSentenciaSQL.executeQuery("SELECT idCompra FROM compra WHERE fechaCompra='" + fecha + "' and idProveedor='" + idProv + "';");
            if (miConsulta.next()) {
                idS = miConsulta.getString("idCompra").toString();
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
        return idS;
    }

    public void insertaExpendio(int opc, double cant, String precio, String idC, String clave) {
        try {
            miSentenciaSQL = conexion.createStatement();
            if (opc != 0) {
                // SI ES 1 ES UNA INSERCIÓN O ALTA DEL PRODUCTO EN LA COMPRA
                miSentenciaSQL.executeUpdate("INSERT INTO compra_producto VALUES(null,'" + cant + "'," + Double.parseDouble(precio) + ",'" + idC + "','" + clave + "');");
            } else {
                // SI ES 0 ES UNA ACTUALIZACION DEL PRODUCTO EN LA COMPRA
                miSentenciaSQL.executeUpdate("UPDATE compra_producto SET cantidadC=cantidadC+" + cant + " WHERE idProducto = '" + clave + "';");

            }
            //ACTUALIZAR EXISTENCIA
            miSentenciaSQL.executeUpdate("UPDATE producto SET existencia=existencia+" + cant + " WHERE idProducto='" + clave + "';");
            JOptionPane.showMessageDialog(null, "Actualiza la existencia! - insertaExpendio()");
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en Altas: " + ex);
            System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
        }
    }

    /*public void insertaSurtido(int opc, int cant, String idS, String clave) {
     try {
     miSentenciaSQL = conexion.createStatement();
     if (opc != 0) {
     miSentenciaSQL.executeUpdate("INSERT INTO surtido_medicamento VALUES(null,'" + cant + "','" + idS + "','" + clave + "');");
     } else {
     miSentenciaSQL.executeUpdate("UPDATE surtido_medicamento SET cantidad=cantidad+" + cant + " WHERE clave = '" + clave + "';");
     }
     miSentenciaSQL.executeUpdate("UPDATE medicamento SET existencia=existencia-" + cant + " WHERE clave='" + clave + "';");
     miSentenciaSQL.close();
     } catch (SQLException ex) {
     System.out.println("Error en Altas: " + ex);
     System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
     }
     }*/

    /*public void actualizaSurtido(int cant, String idS, String clave) {
     try {
     miSentenciaSQL = conexion.createStatement();
     miSentenciaSQL.executeUpdate("INSERT INTO surtido_medicamento VALUES(null,'" + cant + "','" + idS + "','" + clave + "');");
     miSentenciaSQL.executeUpdate("UPDATE medicamento SET existencia=existencia-" + cant + " WHERE clave='" + clave + "'");
     miSentenciaSQL.close();
     } catch (SQLException ex) {
     System.out.println("Error en Altas: " + ex);
     System.out.println("Error en Codigo: " + ex.getErrorCode() + ex.getMessage());
     }
     }*/
    public Vector consultaVenta(String fecha) {
        Vector registros = new Vector();
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("SELECT clave,nombreM,especificacion,ubicacion,cantidad FROM surtido_medicamento INNER JOIN medicamento USING(clave) INNER JOIN surtido USING(idSurtido) WHERE fechaS='" + fecha + "' ORDER BY clave;");

            while (miConsulta.next()) {
                Vector fila = new Vector();
                fila.add(miConsulta.getString("clave"));
                fila.add(miConsulta.getString("nombreM"));
                fila.add(miConsulta.getString("especificacion"));
                fila.add(miConsulta.getString("ubicacion"));
                fila.add(miConsulta.getString("cantidad"));
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta....");
        }
        return registros;
    }

    public Vector consultaExpendio(String fecha, String idProv) {
        Vector registros = new Vector();
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("SELECT idProducto,nombreProd,unidadMedida,precioC,existencia,cantidadC FROM compra_producto INNER JOIN producto USING(idproducto) INNER JOIN compra USING(idCompra) WHERE fechaCompra='" + fecha + "' and idProveedor='" + idProv + "' ORDER BY idproducto;");
            miConsulta = miSentenciaSQL.executeQuery("SELECT idProducto,nombreProd,unidadMedida,precioC,existencia,cantidadC FROM compra_producto INNER JOIN producto USING(idproducto) INNER JOIN compra USING(idCompra) WHERE fechaCompra='" + fecha + "' and idProveedor='" + idProv + "' ORDER BY idproducto;");
            int no = 0;
            while (miConsulta.next()) {
                Vector fila = new Vector();
                fila.add(miConsulta.getString("idProducto"));
                fila.add(miConsulta.getString("nombreProd"));
                fila.add(miConsulta.getString("unidadMedida"));
                fila.add(miConsulta.getString("cantidadC"));
                fila.add(String.format("%10.2f", Double.parseDouble(miConsulta.getString("precioC").toString())));
                registros.add(fila);
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException er) {
            System.out.println("Error en la consulta....");
        }
        return registros;
    }

    public Vector ValidaUsuario(String nom, String contra) {
        Vector misDatos = new Vector();
        try {
            miSentenciaSQL = conexion.createStatement();
            System.out.println("select concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) as nombreC,fechaNacC,tipo,idEmpleado from usuario inner join empleado using(idempleado) where nick = '" + nom + "' AND contrasena = '" + contra + "';");
            miConsulta = miSentenciaSQL.executeQuery("select concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) as nombreC,fechaNacC,tipo,idEmpleado from usuario inner join empleado using(idempleado) where nick = '" + nom + "' AND contrasena = '" + contra + "';");
            if (miConsulta.next()) {
                misDatos.add(miConsulta.getString("nombreC"));
                misDatos.add(miConsulta.getString("fechaNacC"));
                misDatos.add(miConsulta.getString("tipo"));
                misDatos.add(miConsulta.getString("idEmpleado"));
                System.out.println(miConsulta);
            }
            miConsulta.close();
            miSentenciaSQL.close();

        } catch (SQLException ex) {
            System.out.println("Error en la transaccion");
        }
        return misDatos;
    }

    public HashMap validaUsuario(String nick, String contrasena) {
        HashMap usuario = new HashMap();
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("SELECT idEmpleado,nick,contrasena, concat(nombreEmp,' ',apellidoPatEmp,' ',apellidoMatEmp) AS nombreCompleto,tipo from usuario INNER JOIN empleado USING(idEmpleado) WHERE nick='" + nick + "' and contrasena='" + contrasena + "';");
            if (miConsulta.next()) {
                usuario.put("idEmpleado", miConsulta.getString("idEmpleado"));
                usuario.put("nick", miConsulta.getString("nick"));
                usuario.put("contrasena", miConsulta.getString("contrasena"));
                usuario.put("nombreCompleto", miConsulta.getString("nombreCompleto"));
                usuario.put("tipo", miConsulta.getString("tipo"));
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Consulta de USUARIO mala");
        }

        return usuario;
    }

    public ArrayList<Double> ObtenerImpuestos(String datos, int valor) {
        ArrayList impuestos = new ArrayList();
        try {
            if (valor == 1) {
                miSentenciaSQL = conexion.createStatement();
                System.out.println("select equivalenteImp from impuesto " + datos + ";");
                miConsulta = miSentenciaSQL.executeQuery("select equivalenteImp from impuesto " + datos + ";");
                while (miConsulta.next()) {
                    impuestos.add(miConsulta.getDouble("equivalenteImp"));
                }

            } else {
                miSentenciaSQL = conexion.createStatement();
                miConsulta = miSentenciaSQL.executeQuery("select * from producto_impuesto " + datos + ";");
                System.out.println("select * from producto_impuesto " + datos + ";");
                while (miConsulta.next()) {
                    impuestos.add(miConsulta.getDouble("equivalenteImp"));
                }
            }

            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta!!!");
        }
        return impuestos;
    }

    public ArrayList<Integer> obtenerIdImpuestos(ArrayList arr) {
        ArrayList<Integer> datos = new ArrayList<>();
        try {
            miSentenciaSQL = conexion.createStatement();
            for (int i = 0; i < arr.size(); i++) {
                miConsulta = miSentenciaSQL.executeQuery("select * from impuesto where equivalenteImp in (" + arr.get(i) + ");");
                System.out.println("select equivalenteImp from impuesto " + arr.get(i) + ";");
                while (miConsulta.next()) {
                    datos.add(miConsulta.getInt("idImpuesto"));
                }
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta!!!");
        }
        return datos;
    }

    public HashMap BuscaUsuarios(String idE) {
        HashMap misDatos = new HashMap();
        try {
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("select nick,contrasena from usuario inner join empleado using(idEmpleado) where idEmpleado='" + idE + "';");
            if (miConsulta.next()) {
                misDatos.put("nick", miConsulta.getString("nick"));
                misDatos.put("contrasena", miConsulta.getString("contrasena"));
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta!!!");
        }
        return misDatos;
    }

    public Connection getConexion() {
        return conexion;
    }

    public String altaV(String fV, String hV, double mTV, double mE, String idEmp, String gan, String idC, String tipoV, String tipoP, boolean estado, String desc, Vector datos) {
        RedondearDouble utilidades = new RedondearDouble();
        String idVC = "";
        Double can = null;
        try {
            Statement ejecutaSQL = conexion.createStatement();
            System.out.println("INSERT INTO venta VALUES(null,'" + fV + "','" + hV + "'," + mTV + "," + mE + ",'" + tipoV + "','" + tipoP + "'," + estado + ",'" + desc + "','" + gan + "','" + idC + "','" + idEmp + "',0);");
            ejecutaSQL.executeUpdate("INSERT INTO venta VALUES(null,'" + fV + "','" + hV + "'," + mTV + "," + mE + ",'" + tipoV + "','" + tipoP + "'," + estado + ",'" + desc + "','" + gan + "','" + idC + "','" + idEmp + "',0);");
            System.out.println("Cerrando conexion");
            ejecutaSQL.close();
            ejecutaSQL = conexion.createStatement();

            miConsulta = ejecutaSQL.executeQuery("SELECT idVenta FROM venta WHERE fechaVenta='" + fV + "' and horaV='" + hV + "' and idEmpleado='" + idEmp + "';");
            if (miConsulta.next()) {
                idVC = miConsulta.getString("idVenta").toString();
                miConsulta.close();
                ejecutaSQL.close();
                ejecutaSQL = conexion.createStatement();
                System.out.println(idVC);
                System.out.println("iniciando el for que trono");
                for (int i = 0; i < datos.size(); i++) {
                    Vector celdas = (Vector) datos.get(i);
             
                    System.out.println("INSERT INTO venta_producto VALUES(null," + celdas.get(1) + "," + celdas.get(2) + ",'" + idVC + "','" + celdas.get(0) + "','" + celdas.get(3) + "');");
                    ejecutaSQL.executeUpdate("INSERT INTO venta_producto VALUES(null," + celdas.get(1) + "," + celdas.get(2) + ",'" + idVC + "','" + celdas.get(0) + "','" + celdas.get(3) + "');");
                    ejecutaSQL.executeUpdate("UPDATE producto SET  existencia_pieza= existencia_pieza-" + celdas.get(1) + " WHERE idProducto='" + celdas.get(0) + "'");
                  
                }
                
                for (int i = 0; i < datos.size(); i++) {
                    Vector celdas1 = (Vector) datos.get(i);
                    System.out.println("SELECT existencia_pieza,cantXUM FROM producto WHERE idProducto='"+celdas1.get(0)+"';");
                    miConsulta = ejecutaSQL.executeQuery("SELECT existencia_pieza,cantXUM FROM producto WHERE idProducto='"+celdas1.get(0)+"';");
                    if(miConsulta.next()){

                        double caja = miConsulta.getInt("existencia_pieza") /miConsulta.getDouble("cantXUM");
                        double cajaAux = utilidades.Redondear(caja);
                        //actualizando existencia
                        System.out.println("UPDATE producto SET  existencia= " + cajaAux + " WHERE idProducto='" + celdas1.get(0) + "'");
                        ejecutaSQL.executeUpdate("UPDATE producto SET  existencia= " + cajaAux + " WHERE idProducto='" + celdas1.get(0) + "'");
                    }
                   
                }
                
                miConsulta.close();
                ejecutaSQL.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return idVC;
    }

    public String altaPV(String fV, String hV, double mTV, double mE, String idEmp, String gan, String idC, String tipoV, String tipoP, boolean estado, String desc, Vector datos) {
        String idVC = "";
        try {
            Statement ejecutaSQL = conexion.createStatement();
            System.out.println("INSERT INTO venta VALUES(null,'" + fV + "','" + hV + "'," + mTV + "," + mE + ",'" + tipoV + "','" + tipoP + "'," + estado + ",'" + desc + "','" + gan + "','" + idC + "','" + idEmp + "',0,sysdate());");
            ejecutaSQL.executeUpdate("INSERT INTO venta VALUES(null,'" + fV + "','" + hV + "'," + mTV + "," + mE + ",'" + tipoV + "','" + tipoP + "'," + estado + ",'" + desc + "','" + gan + "','" + idC + "','" + idEmp + "',0,sysdate());");
            ejecutaSQL.close();
            ejecutaSQL = conexion.createStatement();

            miConsulta = ejecutaSQL.executeQuery("select idVenta FROM venta WHERE fechaVenta='" + fV + "' and horaV='" + hV + "' and idEmpleado='" + idEmp + "';");
            if (miConsulta.next()) {
                idVC = miConsulta.getString("idVenta").toString();
                miConsulta.close();
                ejecutaSQL.close();
                ejecutaSQL = conexion.createStatement();
                System.out.println(idVC);
                for (int i = 0; i < datos.size(); i++) {
                    Vector celdas = (Vector) datos.get(i);
                    System.out.println("INSERT INTO venta_producto VALUES(null," + celdas.get(1) + "," + celdas.get(2) + ",'" + idVC + "','" + celdas.get(0) + "','" + celdas.get(3) + "');");
                    ejecutaSQL.executeUpdate("INSERT INTO venta_producto VALUES(null," + celdas.get(1) + "," + celdas.get(2) + ",'" + idVC + "','" + celdas.get(0) + "','" + celdas.get(3) + "');");
                    //equivalencia(celdas.get(1).toString(), celdas.get(0).toString(), ejecutaSQL);
                    ejecutaSQL.executeUpdate("UPDATE producto SET existencia=existencia-" + celdas.get(1) + " WHERE idProducto='" + celdas.get(0) + "'");
                }
                ejecutaSQL.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idVC;
    }

    public void equivalencia(String cant, String idProd, Statement ejecutaSQL) {
        double cantEquiv = Double.parseDouble(ConsultaDato("if(cantProdEquiv is null,0,cantProdEquiv)", "equivalencia", "where idProducto='" + idProd + "'"));
        System.err.println("cantEquiv<" + cantEquiv + ">");
        if (cantEquiv == 0) {
            altaRegistro("equivalencia", "null," + cant + "," + idProd);
            System.err.println("alta en equivalencia: " + cant);
            equivalencia(cant, idProd, ejecutaSQL);
        } else if (cantEquiv > 0) {
            try {
                double cantVenta = Double.parseDouble(ConsultaDato("if(cantXUM is null,0,cantXUM)", "producto", "where idProducto='" + idProd + "'"));
                System.err.println("cantVenta<" + cantVenta + ">");
                System.err.println("if (cantEquiv<" + cantEquiv + "> >= cantVenta<" + cantVenta + ">)");
                if ((cantEquiv + Double.parseDouble(cant)) >= cantVenta) {
                    System.err.println("decrementar existencia 1 " + cant);

                    ejecutaSQL.executeUpdate("UPDATE producto SET existencia=existencia-" + (int) (cantVenta / cantEquiv) + " WHERE idProducto='" + idProd + "'");
                    ejecutaSQL.executeUpdate("UPDATE equivalencia SET cantProdEquiv=0 WHERE idProducto='" + idProd + "'");
                    ejecutaSQL.executeUpdate("UPDATE equivalencia SET cantProdEquiv=cantProdEquiv+" + cantVenta % cantEquiv + " WHERE idProducto='" + idProd + "'");
                    //ejecutaSQL.executeUpdate("UPDATE equivalencia SET existencia=existencia-" + cantVenta%cantEquiv + " WHERE idProducto='" + celdas.get(0) + "'");
                } else {
                    System.err.println("aumenta a cantidad: " + cant);
                    ejecutaSQL.executeUpdate("UPDATE equivalencia SET cantProdEquiv=cantProdEquiv+" + cant + " WHERE idProducto='" + idProd + "'");

                }//ejecutaSQL.executeUpdate("UPDATE equivalencia SET existencia=existencia-" + cantVenta%cantEquiv + " WHERE idProducto='" + celdas.get(0) + "'");
            } catch (SQLException ex) {
                Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void setImagen(String direccion, String campo, String tabla, String condicion) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(direccion));
            PreparedStatement miSQL = conexion.prepareStatement("update " + tabla + " set " + campo + "=? " + condicion);
            miSQL.setBlob(1, inputStream);
            miSQL.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ImageIcon getImagen(String campos, String tabla, String condicion) {
        ImageIcon imageIcon = null;
        try {
            System.out.println("select " + campos + " from " + tabla + " " + condicion + ";");
            miSentenciaSQL = conexion.createStatement();
            miConsulta = miSentenciaSQL.executeQuery("select " + campos + " from " + tabla + " " + condicion + ";");
            while (miConsulta.next()) {
                Blob bytesImagen = miConsulta.getBlob(1);
                if (bytesImagen != null) {
                    byte[] bytesLeidos = bytesImagen.getBytes(1, (int) bytesImagen.length());
                    imageIcon = new ImageIcon(bytesLeidos);
                }
            }
            miConsulta.close();
            miSentenciaSQL.close();
        } catch (SQLException e) {
            System.out.println("Error en la consulta de imagen....");
        }
        return imageIcon;
    }
//    public String altaVenta(String fechaV,String hora, double montoTV,double montoEfectivo,int idEmp, Vector datos, String concepto){
//        String idVC = "";
//        try {
//
//            Statement ejecutaSQL = conexion.createStatement();
//            ejecutaSQL.executeUpdate("INSERT INTO "+concepto+" VALUES(null,'" + fechaV + "','" + hora + "',"+ montoTV +","+ montoEfectivo +","+ idEmp +");");
//            ejecutaSQL.close();
//            ejecutaSQL = conexion.createStatement();
//
//            miConsulta = ejecutaSQL.executeQuery("Select id"+concepto+" FROM "+concepto+" WHERE fecha"+concepto+" = '" + fechaV + "' AND hora"+ ((concepto.equals("compra"))?"C":"V")+" = '" + hora + "' AND idEmpleado = '" +idEmp + "';");
//            if(miConsulta.next()){
//                String id = miConsulta.getString("id"+concepto+"").toString();
//                idVC = id;
//                miConsulta.close();
//                ejecutaSQL.close();
//                ejecutaSQL = conexion.createStatement();
//
//                for(int i=0; i<datos.size();i++){
//                    Vector celdas = (Vector)datos.get(i);
//                        ejecutaSQL.executeUpdate("INSERT INTO "+concepto+"_producto VALUES(null," + celdas.get(0) + "," + celdas.get(1) + ",'" + id + "','" + celdas.get(2) + "');");
//                        ejecutaSQL.executeUpdate("UPDATE producto SET existencia=existencia-" + celdas.get(0) + " WHERE idProducto='" + celdas.get(2) + "'");
//                }
//                ejecutaSQL.close();
//            }
//        } catch (SQLException ex) {
//            //Logger.getLogger(conexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return idVC;
//    }
}
