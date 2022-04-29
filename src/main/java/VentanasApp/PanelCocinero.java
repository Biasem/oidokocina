package VentanasApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelCocinero extends JPanel {
    static void panelCocinero(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //Boton Comandas
        JButton verComandas = new JButton("Comandas");
        verComandas.setBounds(300,300,100,100);
        ActionListener oyenteComandas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComandas(panel);
            }
        };
        verComandas.addActionListener(oyenteComandas);
        panel.add(verComandas);
        //boton atras
        PanelPrincipal.botonAtras();
    }

    private static void panelComandas(JPanel panel){
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
        //Boton tramitar pedido
        JButton prepararComanda = new JButton("Preparar Comanda");
        prepararComanda.setBounds(600,500,300,50);
        panel.add(prepararComanda);

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

        //boton atras
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero(panel);
            }
        };
        atras.addActionListener(oyenteAtras);
    }

}
