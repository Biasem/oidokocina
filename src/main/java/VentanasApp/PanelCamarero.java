package VentanasApp;

import Modelos.Mesa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class PanelCamarero extends JPanel {
    //BORRAR CUANDO ESTE IMPLEMENTADO LA BBDD DE MESAS
    private static List<Mesa> listaMesas = new ArrayList<>();
    static Mesa mesa1 = new Mesa(1,1,0,false);
    static Mesa mesa2 = new Mesa(2,2,0,true);
//-----------------------------------------------------------------------------------------------

    static void panelCamarero(JPanel panel){
    //BORRAR CUANDO ESTE IMPLEMENTADO LA BBDD DE MESAS
        listaMesas.add(mesa1);
        listaMesas.add(mesa2);
        //-------------------------------------------------------
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        //boton de aforo
        JButton aforo = new JButton("Aforo");
        aforo.setBounds(230, 500, 250, 100);
        ActionListener oyenteAforo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAforo(panel);
            }
        };
        aforo.addActionListener(oyenteAforo);
        aforo.setBorderPainted(true);
        aforo.setFocusPainted(true);
        aforo.setContentAreaFilled(true);
        aforo.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        aforo.setBackground(Color.WHITE);
        String ruta6 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\crowd.png" ;
        ImageIcon imagen6 = new ImageIcon(ruta6);
        Image imagenLimitadaTamanyo = imagen6.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen6.setImage(imagenLimitadaTamanyo);
        aforo.setIcon(imagen6);
        panel.add(aforo);

        //boton de pedidos
        JButton pedidos = new JButton("Pedidos");
        pedidos.setBounds(730, 500, 250, 100);
        ActionListener oyentepedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPedidos(panel);
            }
        };
        pedidos.addActionListener(oyentepedidos);
        pedidos.setBorderPainted(true);
        pedidos.setFocusPainted(true);
        pedidos.setContentAreaFilled(true);
        pedidos.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        pedidos.setBackground(Color.WHITE);
        String ruta3 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\products.png" ;
        ImageIcon imagen3 = new ImageIcon(ruta3);
        Image imagenLimitadaTamanyo3 = imagen3.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen3.setImage(imagenLimitadaTamanyo3);
        pedidos.setIcon(imagen3);
        panel.add(pedidos);

        //boton de cuentas
        JButton cuentas = new JButton("Cuentas");
        cuentas.setBounds(480, 500, 250, 100);
        ActionListener oyentecuentas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCuentas(panel);
            }
        };
        cuentas.addActionListener(oyentecuentas);
        cuentas.setBorderPainted(true);
        cuentas.setFocusPainted(true);
        cuentas.setContentAreaFilled(true);
        cuentas.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cuentas.setBackground(Color.WHITE);
        String ruta4 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\bill.png" ;
        ImageIcon imagen4 = new ImageIcon(ruta4);
        Image imagenLimitadaTamanyo4 = imagen4.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen4.setImage(imagenLimitadaTamanyo4);
        cuentas.setIcon(imagen4);
        panel.add(cuentas);
        //boton atras
        PanelPrincipal.botonAtras();
    }
    // subpanel de camarero AFORO
    private static void panelAforo(JPanel panel){
        Font fuente = new Font("TimesRoman",Font.BOLD,20);
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(listaMesas.size(), 3, 20, 20));
        //productos en botones para poner bonico

        for (Mesa m:listaMesas) {
            panel2.add(new JLabel("Mesa "+m.getNum_Mesa()){
                @Override
                public void setFont(Font font) {
                    font = fuente;
                    super.setFont(font);
                }
                @Override
                public void setForeground(Color bg) {
                    super.setForeground(Color.white);
                }
            });
            panel2.add(new JLabel(){

                @Override
                public void setFont(Font font) {
                    font = fuente;
                    super.setFont(font);
                }
                @Override
                public void setForeground(Color bg) {
                    if(m.isOcupada()==false){
                        super.setForeground(Color.green);
                    }else{
                        super.setForeground(Color.red);
                    }
                }
                @Override
                public void setText(String text) {
                    if(m.isOcupada()==false){
                        super.setText("Libre");
                    }else{
                        super.setText("Ocupada");
                    }
                }
            });
            JButton bocon = new JButton("Ocupar mesa");
            bocon.setEnabled(true);
            panel2.add(bocon);
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
        PanelPrincipal.botonAtrasCamarero();
    }
    // subpanel de camarero CUENTAS
    private static void panelCuentas(JPanel panel){
        //urlimg = new ImageIcon(geturlimg()).getImage();
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 20, 20));
        //productos en botones para poner bonico
        for (int i = 1;i<20;i++) {
            panel2.add(new JButton("Mesa "+i));
            panel2.add(new JButton("Pedido finalizado/si/no"));
            panel2.add(new JButton("boton pagar"));

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
        PanelPrincipal.botonAtrasCamarero();
    }
    // subpanel de camarero PEDIDOS
    private static void panelPedidos(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //Label Mesa
        JLabel labelMesa = new JLabel("Mesa:");
        labelMesa.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelMesa.setForeground(Color.white);
        labelMesa.setBounds(100,150,70,20);
        panel.add(labelMesa);
        //Campo Mesa
        JTextField campoMesa = new JTextField();
        campoMesa.setBounds(160,150,50,20);
        panel.add(campoMesa);

        //Label Camarero
        JLabel labelCamarero = new JLabel("Camarero:");
        labelCamarero.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCamarero.setForeground(Color.white);
        labelCamarero.setBounds(250,150,100,20);
        panel.add(labelCamarero);
        //Campo Camarero
        JTextField campoCamarero = new JTextField();
        campoCamarero.setBounds(350,150,50,20);
        panel.add(campoCamarero);

        //Label Producto
        JLabel labelProducto = new JLabel("Producto:");
        labelProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelProducto.setForeground(Color.white);
        labelProducto.setBounds(100,200,100,20);
        panel.add(labelProducto);
        //Campo Producto
        JTextField campoProducto = new JTextField();
        campoProducto.setBounds(200,200,50,20);
        panel.add(campoProducto);

        //Label Cantidad
        JLabel labelCantidad = new JLabel("Cantidad:");
        labelCantidad.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCantidad.setForeground(Color.white);
        labelCantidad.setBounds(260,200,100,20);
        panel.add(labelCantidad);
        //Campo Cantidad
        JTextField campoCantidad = new JTextField();
        campoCantidad.setBounds(350,200,50,20);
        panel.add(campoCantidad);

        //Boton añadir producto a la comanda
        JButton aniadirProducto = new JButton("Añadir");
        aniadirProducto.setBounds(300,250,100,50);
        panel.add(aniadirProducto);

        //Boton tramitar comanda
        JButton enviarComanda = new JButton("Enviar Comanda");
        enviarComanda.setBounds(600,500,300,50);
        panel.add(enviarComanda);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 20, 20));
        //productos en botones para poner bonico

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(400, 0, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        //scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        PanelPrincipal.botonAtrasCamarero();
    }

}
