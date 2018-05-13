package difamserv;

import panel.panelAgenteVentaPendiente;
import panel.miVenta_1;
import panel.miListaComprasEstado;
import panel.miCompra;
import panel.listaCarteras;
import dialog.recupContra;
import panel.misGastos;
import dialog.frmConf;
import panel.panelPedidos;
import panel.panelPestanas;
import panel.panelDevolucion;
import panel.panelVistaReportes;
import panel.panelPromos;
import panel.panelPagoEmpleados;
import dialog.jdStock;
import dialog.jdAltaImpuesto;
import dialog.jdRelacionRA;
import dialog.jdGenerarCodigo;
import conexiones.consultasMySQL;
import conexiones.conexionMySQL;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import mis_operaciones.operaTablas;

public class frmPrincipal extends javax.swing.JFrame implements Runnable {

    private Thread hilo;
    String titulo = "SISTEMA DE VENTA - v1.0 - Nny's Systems                ";
    String MSG = "", fN = "2012-08-01";
    StringBuilder concatena = new StringBuilder(""), conca = new StringBuilder("");
    int contConca = 0, Cc2 = 0;
    public static boolean cerrarSalir = false;
    public static ImageIcon imgCerrar;
    ImageIcon bolsita = new ImageIcon(getClass().getResource("/img/DIFAM.png"));
    ImageIcon imgSalir = new ImageIcon(getClass().getResource("/img/salir.png"));
    public static ImageIcon defaultIcon;
    JLabel logo = new JLabel(bolsita, JLabel.CENTER);
    public static int cantidadProd = 1;
    public static conexionMySQL miConex;
    public static consultasMySQL consultas;
    public static String horaS, fechaS;
    public static valoresImp habilitacion = new valoresImp();
    SimpleDateFormat fH = new SimpleDateFormat("hh:mm:ss a");
    public static SimpleDateFormat fF = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat fHSQL = new SimpleDateFormat("hh:mm:ss");
    public static SimpleDateFormat fFSQL = new SimpleDateFormat("yyyy-MM-dd");
    public static operaTablas oT = new operaTablas();
    public static String rutaRaiz = "/SisPuntoVenta";

    public void run() {
        while (true) {
            try {
                lblHora.setText(fH.format(System.currentTimeMillis()).toUpperCase());
                lblFecha.setText((fF.format(System.currentTimeMillis())).toUpperCase());
                horaS = fHSQL.format(System.currentTimeMillis());
                fechaS = fFSQL.format(System.currentTimeMillis());
                if (contConca < titulo.length()) {
                    concatena.append(titulo.charAt(contConca));
                    setTitle(concatena.toString());
                    contConca++;
                } else {
                    concatena.delete(0, concatena.length());
                    contConca = 0;
                }
                if (Cc2 < MSG.length()) {
                    conca.append(MSG.charAt(Cc2));
                    lblMsg.setText(conca.toString());
                    Cc2++;
                } else {
                    conca.delete(0, conca.length());
                    Cc2 = 0;
                }
                hilo.sleep(100);
            } catch (Exception error) {
            }
        }
    }

    public frmPrincipal(Vector misDatos, conexionMySQL miConex) {
        initComponents();
        logo.setOpaque(true);
        logo.setBackground(Color.white);
        defaultIcon = new ImageIcon(getClass().getResource("/img/clienteShop.png"));
        imgCerrar = new ImageIcon(getClass().getResource("/img/cerrar.png"));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.miConex = miConex;
        consultas = new consultasMySQL();
        lblUsuario.setText(misDatos.get(0).toString());
        String tipo = ((misDatos.get(2).toString().charAt(0) != 'A') ? ((misDatos.get(2).toString().charAt(0) != 'V') ? "REPARTIDOR " : "VENDEDOR PUNTO VENTA") : "ADMINISTRADOR ");
        lblTipo.setText(tipo);
        habilitacion.setIDEmpleado(misDatos.get(3).toString());
        String anio = misDatos.get(1).toString().substring(5);

        if (anio.equals(new SimpleDateFormat("MM-dd").format(System.currentTimeMillis()))) {
            MSG = "  *** FELIZ CUMPLEAÑOS " + misDatos.get(0).toString() + " ''*\\(n_n)/*''  ***     ";
            lblMsg.setForeground(Color.RED);
        } else {
            MSG = "*** Bienvenido al Sistema de Venta para tiendas - CAJERO         ";
            lblMsg.setForeground(Color.BLACK);
        }
        //setSize(1000,750);
        setExtendedState(this.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

//        if (habilitacion.getTipoE() != 'A') {
//            if (habilitacion.getTipoE() != 'E') {
//                mnuExistencia.setEnabled(false);
//                mnuRegistros.setEnabled(false);
//                mnuPagos.setEnabled(false);
//            }
//        }
        agregaPanel(new JPanel(), new BorderLayout(), null, logo);
        hilo = new Thread(this);
        hilo.start();
        setVisible(true);
    }

    public void cerrar() {
        if (cerrarSalir) {
//            panelCentro.removeAll();
//            panelCentro.add(logo, BorderLayout.CENTER);
//            panelCentro.updateUI();
            agregaPanel(new JPanel(), new BorderLayout(), null, logo);
            btnSalir.setIcon(imgSalir);
            cerrarSalir = false;
            btnSalir.setText("SALIR");
        } else {
            hilo.stop();
            dispose();
        }
    }

    public static void agregaPanel(JPanel panel, BorderLayout borde, FlowLayout flow, JLabel centro) {
        panelCentro.removeAll();
        if (borde != null) {
            panelCentro.setLayout(borde);
        } else {
            panelCentro.setLayout(flow);
        }

        if (centro != null) {
            panelCentro.add(centro);
        } else {
            panelCentro.add(panel);
        }
        panelCentro.updateUI();
    }

    public void agregaPanel(JPanel panel) {
        panelCentro.setLayout(new BorderLayout());
        panelCentro.removeAll();
        panelCentro.add(panel);
        panelCentro.updateUI();
    }

    public static void iconoCerrar() {
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNorte = new javax.swing.JPanel();
        btnBusqueda = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();
        btnNuevo2 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnNuevo4 = new javax.swing.JButton();
        btnNuevo5 = new javax.swing.JButton();
        btnNuevo6 = new javax.swing.JButton();
        btnNuevo3 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelSur = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUsuario = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAltasBajas = new javax.swing.JMenuItem();
        mnuAltasBajas1 = new javax.swing.JMenuItem();
        mnuAltasBajas2 = new javax.swing.JMenuItem();
        mnuCODE = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuLogOut = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuConf1 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuExistencia = new javax.swing.JMenuItem();
        mnuRegistros = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuCorteCaja = new javax.swing.JMenuItem();
        mnuPagos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuVentasPagar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuConf = new javax.swing.JMenuItem();
        mnuContras = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelNorte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelNorte.setLayout(new javax.swing.BoxLayout(panelNorte, javax.swing.BoxLayout.LINE_AXIS));

        btnBusqueda.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrin.png"))); // NOI18N
        btnBusqueda.setText("PUNTO DE VENTA");
        btnBusqueda.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnBusqueda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusqueda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });
        panelNorte.add(btnBusqueda);

        btnNuevo1.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/transportista55.png"))); // NOI18N
        btnNuevo1.setText("COMPRAS");
        btnNuevo1.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo1);

        btnNuevo2.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carpedido55.png"))); // NOI18N
        btnNuevo2.setText("PEDIDOS");
        btnNuevo2.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo2);

        btnNuevo.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile.png"))); // NOI18N
        btnNuevo.setText("CARTERAS");
        btnNuevo.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo);

        btnNuevo4.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnNuevo4.setText("DEVOLUCIONES");
        btnNuevo4.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo4ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo4);

        btnNuevo5.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/billetes.png"))); // NOI18N
        btnNuevo5.setText("SUELDOS");
        btnNuevo5.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo5ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo5);

        btnNuevo6.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedido2.png"))); // NOI18N
        btnNuevo6.setText("GASTOS");
        btnNuevo6.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo6ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo6);

        btnNuevo3.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnNuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/promo2.png"))); // NOI18N
        btnNuevo3.setText("PROMOS");
        btnNuevo3.setActionCommand("ALTA DE PRODUCTO");
        btnNuevo3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnNuevo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo3ActionPerformed(evt);
            }
        });
        panelNorte.add(btnNuevo3);

        btnSalir.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.png"))); // NOI18N
        btnSalir.setText("SALIR  ");
        btnSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 7, 10));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelNorte.add(btnSalir);

        getContentPane().add(panelNorte, java.awt.BorderLayout.PAGE_START);

        panelSur.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSur.setLayout(new javax.swing.BoxLayout(panelSur, javax.swing.BoxLayout.LINE_AXIS));

        lblMsg.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblMsg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notita.png"))); // NOI18N
        lblMsg.setText("MENSAJE");
        panelSur.add(lblMsg);
        panelSur.add(jSeparator1);

        lblUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        lblUsuario.setText("USUARIO");
        lblUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelSur.add(lblUsuario);

        lblTipo.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/E.png"))); // NOI18N
        lblTipo.setText("TIPO DE USUARIO");
        lblTipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelSur.add(lblTipo);

        lblFecha.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        lblFecha.setText("FECHA");
        lblFecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelSur.add(lblFecha);

        lblHora.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alarmitaV.png"))); // NOI18N
        lblHora.setText("HORA");
        lblHora.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        panelSur.add(lblHora);

        getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

        panelCentro.setBackground(new java.awt.Color(255, 255, 255));
        panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelCentro.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Altas");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(0, 7, 0, 7));

        mnuAltasBajas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnuAltasBajas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAltasBajas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        mnuAltasBajas.setText("Nuevos Registros");
        mnuAltasBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltasBajasActionPerformed1(evt);
            }
        });
        jMenu1.add(mnuAltasBajas);

        mnuAltasBajas1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnuAltasBajas1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAltasBajas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        mnuAltasBajas1.setText("Asignar Rutas");
        mnuAltasBajas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltasBajas1ActionPerformed1(evt);
            }
        });
        jMenu1.add(mnuAltasBajas1);

        mnuAltasBajas2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuAltasBajas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        mnuAltasBajas2.setText("Impuestos");
        mnuAltasBajas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAltasBajas2ActionPerformed1(evt);
            }
        });
        jMenu1.add(mnuAltasBajas2);

        mnuCODE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mnuCODE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuCODE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        mnuCODE.setText("Generador CODE G");
        mnuCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCODEActionPerformed1(evt);
            }
        });
        jMenu1.add(mnuCODE);
        jMenu1.add(jSeparator3);

        mnuLogOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/csesion.png"))); // NOI18N
        mnuLogOut.setText("Cerrar Sesión");
        mnuLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLogOut);

        mnuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete16.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        mnuReportes.setText("Reporte");
        mnuReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuReportes.setMargin(new java.awt.Insets(0, 7, 0, 7));

        mnuConf1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mnuConf1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuConf1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        mnuConf1.setText("Ver mi stock");
        mnuConf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConf1ActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuConf1);
        mnuReportes.add(jSeparator5);

        mnuExistencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuExistencia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuExistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        mnuExistencia.setText("Existencia Actual");
        mnuExistencia.setMargin(new java.awt.Insets(0, 2, 0, 0));
        mnuExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExistenciaActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuExistencia);

        mnuRegistros.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        mnuRegistros.setText("Registro de Productos");
        mnuRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrosActionPerformed1(evt);
            }
        });
        mnuReportes.add(mnuRegistros);
        mnuReportes.add(jSeparator2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem3.setText("Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem5.setText("Empleados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem6.setText("Rutas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuReportes.add(jMenuItem6);
        mnuReportes.add(jSeparator4);

        mnuCorteCaja.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte.png"))); // NOI18N
        mnuCorteCaja.setText("Corte de Caja");
        mnuCorteCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCorteCajaActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuCorteCaja);

        mnuPagos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ticket.png"))); // NOI18N
        mnuPagos.setText("Pagos");
        mnuPagos.setMargin(new java.awt.Insets(0, 2, 0, 0));
        mnuPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPagosActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuPagos);

        jMenuBar1.add(mnuReportes);

        jMenu3.setText("Correos");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(0, 7, 0, 7));

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem2.setText("Respaldos a Agentes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Mis Pagos");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(0, 7, 0, 7));

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem1.setText("Mi Lista de Compras");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Agentes");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu5.setMargin(new java.awt.Insets(0, 7, 0, 7));

        mnuVentasPagar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuVentasPagar.setText("Ventas a pagar");
        mnuVentasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentasPagarActionPerformed(evt);
            }
        });
        jMenu5.add(mnuVentasPagar);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Estadistica");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(0, 7, 0, 7));

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenuItem7.setText("Ganancia mensual");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(0, 7, 0, 7));

        mnuConf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mnuConf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acepto.png"))); // NOI18N
        mnuConf.setText("Configuración");
        mnuConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfActionPerformed(evt);
            }
        });
        jMenu2.add(mnuConf);

        mnuContras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuContras.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mnuContras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/llave.png"))); // NOI18N
        mnuContras.setText("Ver contraseñas");
        mnuContras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuContrasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuContras);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        iconoCerrar();
        miVenta_1 x = new miVenta_1();
        agregaPanel(x, new BorderLayout(), null, null);
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new listaCarteras(), new BorderLayout(), null, null);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void mnuAltasBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltasBajasActionPerformed
    }//GEN-LAST:event_mnuAltasBajasActionPerformed

    private void mnuContrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuContrasActionPerformed
        new recupContra(null, true);
    }//GEN-LAST:event_mnuContrasActionPerformed

    private void mnuExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExistenciaActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelVistaReportes("existTotal_C", null));
    }//GEN-LAST:event_mnuExistenciaActionPerformed

    private void mnuLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogOutActionPerformed
        new InicioDeSesion();
        hilo.stop();
        dispose();
    }//GEN-LAST:event_mnuLogOutActionPerformed

    private void mnuCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCODEActionPerformed
    }//GEN-LAST:event_mnuCODEActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        miCompra x = new miCompra();
        agregaPanel(x, new BorderLayout(), null, null);
        x.enfoca();
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void mnuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPagosActionPerformed
//        new fecha(this, true, '2');
    }//GEN-LAST:event_mnuPagosActionPerformed

    private void mnuRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrosActionPerformed
    }//GEN-LAST:event_mnuRegistrosActionPerformed

    private void mnuRegistrosActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrosActionPerformed1
//        new fecha(this, true, '3');
    }//GEN-LAST:event_mnuRegistrosActionPerformed1

    private void mnuCorteCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCorteCajaActionPerformed

    }//GEN-LAST:event_mnuCorteCajaActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        hilo.stop();
        dispose();
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuAltasBajasActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltasBajasActionPerformed1
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelPestanas(), new BorderLayout(), null, null);
    }//GEN-LAST:event_mnuAltasBajasActionPerformed1

    private void mnuCODEActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCODEActionPerformed1
        new jdGenerarCodigo(this, true, new consultasMySQL(), "", "");
    }//GEN-LAST:event_mnuCODEActionPerformed1

    private void mnuAltasBajas1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltasBajas1ActionPerformed1
        new jdRelacionRA(null, true, null);
    }//GEN-LAST:event_mnuAltasBajas1ActionPerformed1

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        panelPedidos x = new panelPedidos();
        agregaPanel(x, null, new FlowLayout(), null);
        x.focusID();
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void mnuConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfActionPerformed
        new frmConf(this, true);
    }//GEN-LAST:event_mnuConfActionPerformed

    private void btnNuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo3ActionPerformed
        agregaPanel(new panelPromos(), new BorderLayout(), null, null);
    }//GEN-LAST:event_btnNuevo3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        crearArchivo();
        Thread hilo = new hiloMail(null, null, (frmPrincipal.miConex.ConsultaDato("GROUP_CONCAT(emailemp)", "empleado", "WHERE emailemp !='' and emailemp is not null and tipo='G'")), false);
        hilo.start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuConf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConf1ActionPerformed
        new jdStock(this, true, null, 1, -1);
    }//GEN-LAST:event_mnuConf1ActionPerformed

    private void btnNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo4ActionPerformed
        String ticket = JOptionPane.showInputDialog(this, "Numero de Ticket:");
        System.out.println("No. ticket a cambiar: " + ticket);
        if (ticket != null) {
            if (!(ticket.equals(""))) {
                cerrarSalir = true;
                btnSalir.setText("CERRAR");
                btnSalir.setIcon(imgCerrar);
                agregaPanel(new panelDevolucion(ticket));
            }
        }
    }//GEN-LAST:event_btnNuevo4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        miListaComprasEstado x = new miListaComprasEstado();
        agregaPanel(x, new BorderLayout(), null, null);
        /*VALIDACION DE COMPRAS CERRADAS A LAS CUALES REGISTRAR PAGOS.. SOLO A LAS CERRADAS.. SE SOLICITA PAGOS.. LAS QUE NO SOLICITAR CERRAR.*/
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnNuevo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo5ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        panelPagoEmpleados x = new panelPagoEmpleados();
        agregaPanel(x, null, new FlowLayout(), null);
    }//GEN-LAST:event_btnNuevo5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelVistaReportes("csCatProductos", null));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelVistaReportes("csClientes", null));
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelVistaReportes("csEmpleados", null));
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelVistaReportes("csRutas", null));
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnuVentasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentasPagarActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new panelAgenteVentaPendiente());
    }//GEN-LAST:event_mnuVentasPagarActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        HashMap param = new HashMap();
        param.put("anio", "2015");
        agregaPanel(new panelVistaReportes("grafGananciaXMes", param));
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnNuevo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo6ActionPerformed
        cerrarSalir = true;
        btnSalir.setText("CERRAR");
        btnSalir.setIcon(imgCerrar);
        agregaPanel(new misGastos(), new BorderLayout(), null, null);
    }//GEN-LAST:event_btnNuevo6ActionPerformed

    private void mnuAltasBajas2ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAltasBajas2ActionPerformed1
        new jdAltaImpuesto(this, true, null);
    }//GEN-LAST:event_mnuAltasBajas2ActionPerformed1

    public void crearArchivo() {
        try {
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(rutaRaiz + "/DIFAM/Respaldos/difam_" + frmPrincipal.fechaS + ".sql");
            FileWriter fw = new FileWriter(backupFile);
            Process child = runtime.exec(rutaRaiz + "/DIFAM/Respaldos/mysqldump --opt --password=holamundo --user=root " //modificaciones aqui
                    + "--databases comdifam -R");
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);

            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
            JOptionPane.showMessageDialog(null, "Respaldo generado exitosamente...\nAcepta para enviar por mail", "Verificar", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void coincideCampo(JComboBox combo, String DATO) {
        combo.setSelectedItem(DATO);
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).toString().contains(DATO)) {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }

    public static void llenarCombo_ID(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            modeloCB.addElement("SELECCIONE..");
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(1) + "-" + misDatos.get(0));
            }
        }
        combo.setModel(modeloCB);
    }

    public static void llenarCombo(Vector misRegistros, JComboBox combo) {
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        if (!misRegistros.isEmpty()) {
            modeloCB.addElement("SELECCIONE..");
            for (int i = 0; i < misRegistros.size(); i++) {
                Vector misDatos = (Vector) misRegistros.get(i);
                modeloCB.addElement(misDatos.get(0));
            }
        }
        combo.setModel(modeloCB);
    }

    public static String obtenID(JComboBox combo) {
        return combo.getSelectedItem().toString().substring(combo.getSelectedItem().toString().indexOf('-') + 1);
    }

    public static void cargaImagen(String campo, String tabla, String condicion, JLabel lugar, int w, int h, ImageIcon defaultI) {
        ImageIcon foto = miConex.getImagen(campo, tabla, condicion);
        System.out.println(foto);
        if (foto == null) {
            if (defaultI == null) {
                lugar.setIcon(defaultIcon);
            } else {
                lugar.setIcon(defaultI);
            }
        } else {
            ImageIcon imageIcon = foto;
            Image image = imageIcon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
            lugar.setIcon(new ImageIcon(image));
        }
    }

    public static void packColumn(JTable table, int vColIndex, int margin) {
        if (table.getRowCount() > 0 && table.getColumnCount() > 0) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                TableModel model = table.getModel();
                DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
                TableColumn col = colModel.getColumn(c);
                int width = 0;            // Obtém a largura do cabeçalho da coluna
                TableCellRenderer renderer = col.getHeaderRenderer();
                if (renderer == null) {
                    renderer = table.getTableHeader().getDefaultRenderer();
                }
                Component comp = renderer.getTableCellRendererComponent(
                        table, col.getHeaderValue(), false, false, 0, 0);
                width = comp.getPreferredSize().width;            // Obtém a largura maxima da coluna de dados
                for (int r = 0; r < table.getRowCount(); r++) {
                    renderer = table.getCellRenderer(r, c);
                    comp = renderer.getTableCellRendererComponent(
                            table, table.getValueAt(r, c), false, false, r,
                            c);
                    width = Math.max(width, comp.getPreferredSize().width);
                }
                width += 2 * margin;            // Configura a largura
                col.setPreferredWidth(width);
            }
        } else {
            System.out.println("La tabla NO TIENE DATOS");
        }
    }

    public static String parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSQL = "";
        try {
            Date fechaDate = formato.parse(fecha);
            fechaSQL = fFSQL.format(fechaDate);
        } catch (ParseException ex) {
            System.out.println("Error: frmPrincipal al convertir Fecha a SQL");
        }
        return fechaSQL;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton btnNuevo3;
    private javax.swing.JButton btnNuevo4;
    private javax.swing.JButton btnNuevo5;
    private javax.swing.JButton btnNuevo6;
    public static javax.swing.JButton btnSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    public static javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTipo;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mnuAltasBajas;
    private javax.swing.JMenuItem mnuAltasBajas1;
    private javax.swing.JMenuItem mnuAltasBajas2;
    private javax.swing.JMenuItem mnuCODE;
    private javax.swing.JMenuItem mnuConf;
    private javax.swing.JMenuItem mnuConf1;
    private javax.swing.JMenuItem mnuContras;
    private javax.swing.JMenuItem mnuCorteCaja;
    private javax.swing.JMenuItem mnuExistencia;
    private javax.swing.JMenuItem mnuLogOut;
    private javax.swing.JMenuItem mnuPagos;
    private javax.swing.JMenuItem mnuRegistros;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuVentasPagar;
    public static javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    // End of variables declaration//GEN-END:variables
}
