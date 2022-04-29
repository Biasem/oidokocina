package VentanasApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;


public class PanelPrincipal {
    private static Image urlimg = new ImageIcon(geturlimg()).getImage();
    private JFrame ventana;
    private static JPanel panel;
    private static JButton camarero;
    private static JButton admin;
    private static JButton cliente;
    private static JButton cocinero;

    public PanelPrincipal(){
        ConstruirVentana();
    }

    private void ConstruirVentana(){                     //se construye la ventana y panel principal

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
        PanelFondo(panel);
        ventana.setContentPane(panel);
        ventana.setVisible(true);
    }

    public class seticonimg extends javax.swing.JFrame{
        public seticonimg() {
        }
    }

    public static void RestaurarPanel(JPanel panel)   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private static void PanelFondo(JPanel panel)   //panel principal de bienvenida
    {
        RestaurarPanel(panel);
        panel.setOpaque(false);

        /// Botón cocinero
        cocinero = new JButton("Cocinero");
        ActionListener oyenteCocinero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCocinero.panelCocinero(panel);
            }
        };
        cocinero.addActionListener(oyenteCocinero);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cocinero.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cocinero.setIcon(imagen);
        cocinero.setFocusPainted(true);


        /// Botón camarero
        camarero = new JButton("Camarero");
        ActionListener oyenteCamarero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCamarero.panelCamarero(panel);
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
                PanelAdministrador.panelAdministrador(panel);
            }
        };
        admin.addActionListener(oyenteAdmin);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\apoyo.png" ;
        imagen = new ImageIcon(ruta);
        admin.setIcon(imagen);
        admin.setFocusPainted(true);

        /// Botón cliente

        cliente = new JButton("Cliente");
        ActionListener oyenteCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCliente.panelCliente(panel);
            }
        };
        cliente.addActionListener(oyenteCliente);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cliente.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cliente.setIcon(imagen);
        cliente.setFocusPainted(true);

        panel.setLayout(null);

        cocinero.setBounds(860, 500, 250, 100);
        camarero.setBounds(610, 500, 250, 100);
        admin.setBounds(360, 500, 250, 100);
        cliente.setBounds(110, 500, 250, 100);

        panel.add(cocinero);
        panel.add(camarero);
        panel.add(cliente);
        panel.add(admin);


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
/*
    //panel de COCINERO
    private static void panelCocinero(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel(panel);
        panel.setLayout(null);
        //Boton Comandas
        JButton verComandas = new JButton("Comandas");
        verComandas.setBounds(300,300,100,100);
        ActionListener oyenteComandas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComandas();
            }
        };
        verComandas.addActionListener(oyenteComandas);
        panel.add(verComandas);
        //boton atras
        botonAtras(panel);
    }
    private static void panelComandas(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel(panel);
        panel.setLayout(null);


        //boton atras
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero();
            }
        };
        atras.addActionListener(oyenteAtras);
    }

 */

    // metodos para botones estándar
    public static void botonAtras(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFondo(panel);
            }
        };
        atras.addActionListener(oyenteAtras);
    }
    public static void botonAtrasCamarero(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        atras.setOpaque(false);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCamarero.panelCamarero(panel);
            }
        };
        atras.addActionListener(oyenteAtras);
    }
    public static void botonAtrasAdministrador(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        atras.setOpaque(false);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdministrador.panelAdministrador(panel);
            }
        };
        atras.addActionListener(oyenteAtras);
    }




}
