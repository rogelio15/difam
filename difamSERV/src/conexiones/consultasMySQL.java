package conexiones;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class consultasMySQL {

    conexionMySQL x = new conexionMySQL();
    private Connection conexion = x.getConexion();
    private Image data;
    Statement ejecutaSQL;
    ResultSet miConsulta;

    public consultasMySQL() {
    }

    public ArrayList misProductos(String nom) {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM producto INNER JOIN categoria USING(idCategoria) INNER JOIN proveedor USING(idProveedor) WHERE nombreProd like '%" + nom + "%' ORDER BY nombreProd;");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idProducto", miConsulta.getString("idProducto"));
                misDatos.put("nombreProd", miConsulta.getString("nombreProd"));
                misDatos.put("precioV", miConsulta.getString("precioV"));
                misDatos.put("precioC", miConsulta.getString("precioC"));
                misDatos.put("existencia", miConsulta.getString("existencia"));
                misDatos.put("nombreProv", miConsulta.getString("nombreProv"));
                misDatos.put("nombreCat", miConsulta.getString("nombreCat"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
            //JOptionPane.showMessageDialog(null, "Entre en la Consulta de Categorias");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Categorias:\n" + ex);
        }
        return miConjunto;
    }

    public ArrayList misPagos() {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM pagos inner join proveedor using(idproveedor) WHERE fechapago=DATE(NOW());");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("nombreProv", miConsulta.getString("nombreProv"));
                misDatos.put("montoPago", miConsulta.getString("montoPago"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Pagos:\n" + ex);
        }
        return miConjunto;
    }

    public double obtenerPrecioGralVenta(String id, int valor) {
        double precioGralV = 0.0;
        try {
            ejecutaSQL = conexion.createStatement();
            if (valor == 1) {
                miConsulta = ejecutaSQL.executeQuery("SELECT PrecioGen FROM producto where idProducto = '" + id + "';");
            }
            if (valor == 2) {
                miConsulta = ejecutaSQL.executeQuery("SELECT PrecioGenPV FROM producto where idProducto = '" + id + "';");
                System.out.println("SELECT PrecioGenPV FROM producto where idProducto = '" + id + "';");
            }
            
            if (miConsulta.next()) {
                precioGralV = miConsulta.getDouble(1);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Producto:\n" + ex);
        }
        return precioGralV;
    }

    public HashMap miProducto(String idP) {
        HashMap miConjunto = new HashMap();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            System.out.println("SELECT * FROM producto INNER JOIN categoria USING(idCategoria) INNER JOIN marca USING(idMarca) INNER JOIN ubicacion USING(idUbicacion) WHERE idProducto LIKE '" + idP + "';");
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM producto INNER JOIN categoria USING(idCategoria) INNER JOIN marca USING(idMarca) INNER JOIN ubicacion USING(idUbicacion) WHERE idProducto LIKE '" + idP + "';");
            if (miConsulta.next()) {
                miConjunto.put("idProducto", miConsulta.getString("idProducto"));
                miConjunto.put("codEmpresa", miConsulta.getString("codEmpresa"));
                miConjunto.put("nombreProd", miConsulta.getString("nombreProd"));
                miConjunto.put("precioMax", miConsulta.getString("precioMax"));
                miConjunto.put("precioMin", miConsulta.getString("precioMin"));
                miConjunto.put("precioProm", miConsulta.getString("precioProm"));

                miConjunto.put("precioC", miConsulta.getString("precioC"));
                miConjunto.put("precioProtec", miConsulta.getString("precioProtec"));
                miConjunto.put("nombreMarca", miConsulta.getString("nombreMarca"));
                miConjunto.put("nombreFam", miConsulta.getString("nombreFam"));
                miConjunto.put("nombreCat", miConsulta.getString("nombreCat"));
                miConjunto.put("unidadMedida", miConsulta.getString("unidadMedida"));
                miConjunto.put("PrecioGenPV", miConsulta.getString("PrecioGenPV"));
                miConjunto.put("existencia", miConsulta.getString("existencia"));
                miConjunto.put("cantXUM", miConsulta.getString("cantXUM"));
                miConjunto.put("ultCantC", miConsulta.getString("ultCantC"));
                miConjunto.put("ultPrecIC", miConsulta.getString("ultPrecIC"));
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Categorias:\n" + ex);
        }
        return miConjunto;
    }

    public HashMap miProducto2(String idP) {
        HashMap miConjunto = new HashMap();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM producto INNER JOIN categoria USING(idCategoria) INNER JOIN marca USING(idMarca) INNER JOIN ubicacion USING(idUbicacion) WHERE idProducto LIKE '" + idP + "';");
            if (miConsulta.next()) {
                miConjunto.put("idProducto", miConsulta.getString("idProducto"));
                miConjunto.put("codEmpresa", miConsulta.getString("codEmpresa"));
                miConjunto.put("nombreProd", miConsulta.getString("nombreProd"));
                miConjunto.put("precioV", miConsulta.getString("precioV"));
                miConjunto.put("precioC", miConsulta.getString("precioC"));
                miConjunto.put("nombreMarca", miConsulta.getString("nombreMarca"));
                miConjunto.put("nombreFam", miConsulta.getString("nombreFam"));
                miConjunto.put("nombreCat", miConsulta.getString("nombreCat"));
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Categorias:\n" + ex);
        }
        return miConjunto;
    }

    public boolean existenciaPrevia(String id) {
        boolean existe = false;
        try {
            ejecutaSQL = conexion.createStatement();
            miConsulta = ejecutaSQL.executeQuery("SELECT * FROM producto WHERE idProducto = '" + id + "';");
            if (miConsulta.next()) {
                existe = true;
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Producto:\n" + ex);
        }
        return existe;
    }

    public ArrayList misCategorias() {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM categoria ORDER BY idCategoria;");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idCategoria", miConsulta.getString("idCategoria"));
                misDatos.put("nombreCat", miConsulta.getString("nombreCat"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Categorias:\n" + ex);
        }
        return miConjunto;
    }

    public ArrayList misProveedores() {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM proveedor ORDER BY idProveedor;");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idProveedor", miConsulta.getString("idProveedor"));
                misDatos.put("nombreProv", miConsulta.getString("nombreProv"));
                misDatos.put("direccionProv", miConsulta.getString("direccionProv"));
                misDatos.put("telefonoProv", miConsulta.getString("telefonoProv"));
                misDatos.put("email", miConsulta.getString("email"));
                misDatos.put("fax", miConsulta.getString("fax"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Proveedores:\n" + ex);
        }
        return miConjunto;
    }

    public ArrayList misEmpleados() {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT idEmpleado,nombreEmp,apellidoPatEmp,apellidoMatEmp,fechaNac,direccionEmp,telefonoEmp FROM empleado ORDER BY idEmpleado;");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idEmpleado", miConsulta.getString("idEmpleado"));
                misDatos.put("nombreEmp", miConsulta.getString("nombreEmp"));
                misDatos.put("apellidoPatEmp", miConsulta.getString("apellidoPatEmp"));
                misDatos.put("apellidoMatEmp", miConsulta.getString("apellidoMatEmp"));
                misDatos.put("fechaNac", miConsulta.getString("fechaNac"));
                misDatos.put("direccionEmp", miConsulta.getString("direccionEmp"));
                misDatos.put("telefonoEmp", miConsulta.getString("telefonoEmp"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Proveedores:\n" + ex);
        }
        return miConjunto;
    }

    public ArrayList misClientes() {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            ResultSet miConsulta = ejecutaSQL.executeQuery("SELECT * FROM cliente ORDER BY idCliente;");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idCliente", miConsulta.getString("idCliente"));
                misDatos.put("nombreCli", miConsulta.getString("nombreCli"));
                misDatos.put("apellidoPatCli", miConsulta.getString("apellidoPatCli"));
                misDatos.put("apellidoMatCli", miConsulta.getString("apellidoMatCli"));
                misDatos.put("direccionCli", miConsulta.getString("direccionCli"));
                misDatos.put("telCli", miConsulta.getString("telCli"));
                misDatos.put("aval", miConsulta.getString("aval"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Categorias:\n" + ex);
        }
        return miConjunto;
    }

    public ArrayList miVenta(String noVenta) {
        ArrayList miConjunto = new ArrayList();
        try {
            Statement ejecutaSQL = conexion.createStatement();
            System.out.println("select * from venta_producto inner join venta using(idventa) inner join producto using(idproducto) where idVenta=" + noVenta + ";");
            ResultSet miConsulta = ejecutaSQL.executeQuery("select * from venta_producto inner join venta using(idventa) inner join producto using(idproducto) where idVenta=" + noVenta + ";");
            while (miConsulta.next()) {
                HashMap misDatos = new HashMap();
                misDatos.put("idProducto", miConsulta.getString("idProducto"));
                misDatos.put("nombreProd", miConsulta.getString("nombreProd"));
                misDatos.put("cantidadV", miConsulta.getString("cantidadV"));
                misDatos.put("precioUnitPV", miConsulta.getString("precioUnitPV"));
                misDatos.put("descV", miConsulta.getString("descV"));
                misDatos.put("montoTotalV", miConsulta.getString("montoTotalV"));
                misDatos.put("unidadMedida", miConsulta.getString("unidadMedida"));
                miConjunto.add(misDatos);
            }
            miConsulta.close();
            ejecutaSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de Clientes:\n" + ex);
        }
        return miConjunto;
    }
}
