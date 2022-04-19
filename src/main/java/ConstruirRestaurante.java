import Modelos.Producto;
import UtilidadesBBDD.ProductoBD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.AbstractBorder;
import java.awt.*;



public class ConstruirRestaurante {
    private Image urlimg = new ImageIcon(geturlimg()).getImage();
    private JFrame ventana;
    private JPanel panel,panelprincipal;
    private JButton camarero,admin,cliente,cocinero;


    ConstruirRestaurante(){
    ConstruirVentana();

    }


    private void ConstruirVentana()
    {                                               //se construye la ventana y panel principal
        ventana = new JFrame("OidoKocina");
        ventana.setSize(1200,720);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(urlimg, 0, 0, getWidth(), getHeight(), this);
                super.paint(g);
            }
        };
        PanelFondo();
        ventana.setContentPane(panel);
        ventana.setVisible(true);




    }

    public class seticonimg extends javax.swing.JFrame{

        public seticonimg() {

        }
    }

    private void RestaurarPanel()   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void PanelFondo()   //panel principal de bienvenida
    {

        RestaurarPanel();

        panel.setOpaque(false);


        /// Botón cocinero
        cocinero = new JButton("Cocinero");
        ActionListener oyenteCocinero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero();
            }
        };
        cocinero.addActionListener(oyenteCocinero);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cocinero.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cocinero.setIcon(imagen);
        cocinero.setFocusPainted(true);
        cocinero.setBackground(Color.DARK_GRAY);

        /// Botón camarero
        camarero = new JButton("Camarero");
        ActionListener oyenteCamarero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCamarero();
            }
        };
        camarero.addActionListener(oyenteCamarero);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\camarero.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        camarero.setIcon(imagen);
        camarero.setFocusPainted(true);

        /// Botón admin

        admin = new JButton("Administrador");
        ActionListener oyenteAdmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAdministrador();
            }
        };
        admin.addActionListener(oyenteAdmin);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\apoyo.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        admin.setIcon(imagen);
        admin.setFocusPainted(true);

        /// Botón cliente

        cliente = new JButton("Cliente");
        ActionListener oyenteCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        cliente.addActionListener(oyenteCliente);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cliente.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cliente.setIcon(imagen);
        cliente.setFocusPainted(true);

        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(100,100,100,100));


        panel.add(cocinero);
        panel.add(camarero);
        panel.add(cliente);
        panel.add(admin);

        cocinero.setLocation(400,400);
        cocinero.setSize(400, 100);
        cocinero.setFocusPainted(true);
        cocinero.setContentAreaFilled(true);
        cocinero.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cocinero.setBackground(Color.WHITE);

        camarero.setBorderPainted(true);
        camarero.setFocusPainted(true);
        camarero.setContentAreaFilled(true);
        camarero.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        camarero.setBackground(Color.WHITE);

        admin.setBorderPainted(true);
        admin.setFocusPainted(true);
        admin.setContentAreaFilled(true);
        admin.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        admin.setBackground(Color.WHITE);

        cliente.setBorderPainted(true);
        cliente.setFocusPainted(true);
        cliente.setContentAreaFilled(true);
        cliente.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cliente.setBackground(Color.WHITE);




    }


    private static String geturlimg(){
        String ruta = new File("").getAbsolutePath();
        return ruta  + "\\src\\main\\imagenes\\menuprincipal.jpg";
    }
    // Panel donde mostramos la carta, se puede hacer modo pestañas
    private void verCarta(){

        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        atras.addActionListener(oyenteAtras);
        //panel donde van los productos
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(ProductoBD.obtenerTodosProductos().size(), 3, 10, 5));
        //productos en botones para poner bonico
        for (Producto p : ProductoBD.obtenerTodosProductos()) {
            panel2.add(new JButton(p.getDescripcion()));
            panel2.add(new JButton(String.valueOf(p.getTipoProducto())));
            panel2.add(new JButton(String.valueOf(p.getPrecio())));

        }
        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

    }

    // Panel cliente
    private void panelcliente (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        JButton vercarta = new JButton("Carta");
        vercarta.setBounds(350,250,100,50);
        ActionListener oyenteCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurarPanel();
                verCarta();
            }
        };
        vercarta.addActionListener(oyenteCarta);


        panel.add(vercarta);
        botonatras();
    }
    private void panelAdministrador (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        botonatras();

    }
    private void panelCamarero (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton de aforo
        JButton aforo = new JButton("Aforo");
        aforo.setBounds(100,100,100,50);
        ActionListener oyenteAforo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAforo();
            }
        };
        aforo.addActionListener(oyenteAforo);
        panel.add(aforo);

        //boton de pedidos
        JButton pedidos = new JButton("Pedidos");
        pedidos.setBounds(200,100,100,50);
        ActionListener oyentepedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPedidos();
            }
        };
        pedidos.addActionListener(oyentepedidos);
        panel.add(pedidos);

        //boton de cuentas
        JButton cuentas = new JButton("Cuentas");
        cuentas.setBounds(300,100,100,50);
        ActionListener oyentecuentas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCuentas();
            }
        };
        cuentas.addActionListener(oyentecuentas);
        panel.add(cuentas);
        //boton atras
        botonatras();
    }

    private void panelAforo(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 20, 20));
        //productos en botones para poner bonico
        for (int i = 1;i<20;i++) {
            panel2.add(new JButton("Mesa "+i));
            panel2.add(new JButton("Ocupada/Libre"));
            panel2.add(new JButton("boton para ocupar mesa"));

        }
        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        botonatrascamarero();
    }
    private void panelCuentas(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton Atras hacia panel camarero
        botonatrascamarero();
    }
    private void panelPedidos(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton Atras hacia panel camarero
        botonatrascamarero();
    }


    private void panelCocinero (){

        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton atras
        botonatras();
    }

    // metodos para botones estándar
    public void botonatras(){
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFondo();
            }
        };
        atras.addActionListener(oyenteAtras);
    }
    public void botonatrascamarero(){
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCamarero();
            }
        };
        atras.addActionListener(oyenteAtras);
    }


}
