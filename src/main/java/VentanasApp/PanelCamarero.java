package VentanasApp;

import Modelos.LineaComanda;
import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.FacturaYComandaBD;
import UtilidadesBBDD.ProductoBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PanelCamarero extends JPanel {
    //BORRAR CUANDO ESTE IMPLEMENTADO LA BBDD DE MESAS
    static Mesa mesa1 = new Mesa(1,1,0,true);
    static Mesa mesa2 = new Mesa(2,2,0,true);
    static List<Mesa> listaMesas = new ArrayList<>();
    static List<Producto> listaProductos = new ArrayList<>();
    static List<LineaComanda> listaComandas = new ArrayList<>();
//-----------------------------------------------------------------------------------------------

    static void panelCamarero(JPanel panel){
        //BORRAR CUANDO ESTE IMPLEMENTADA LA BBDD
        if (listaMesas.isEmpty()){
            listaMesas.add(mesa1);
            listaMesas.add(mesa2);
        }
        if (listaProductos.isEmpty()) listaProductos = ProductoBD.obtenerTodosProductos().stream().collect(Collectors.toList());

        //---------------------------------------------------------------------

        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        //boton de aforo
        JButton aforo = new JButton("Aforo");
        aforo.setBounds(230, 500, 250, 100);
        ActionListener oyenteAforo = e -> panelAforo(panel);
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
        ActionListener oyentepedidos = e -> panelPedidos(panel);
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
        ActionListener oyentecuentas = e -> panelCuentas(panel);
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
                    if(!m.isOcupada()){
                        super.setForeground(Color.green);
                    }else{
                        super.setForeground(Color.red);
                    }
                }
                @Override
                public void setText(String text) {
                    if(!m.isOcupada()){
                        super.setText("Libre");
                    }else{
                        super.setText("Ocupada");
                    }
                }
            });
            JButton botonOcuparMesa = new JButton("Ocupar mesa");
            botonOcuparMesa.setName(""+m.getNum_Mesa());
            ActionListener accionOcuparMesa = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Mesa j:listaMesas){
                        if (j.getNum_Mesa()==Integer.valueOf(botonOcuparMesa.getName())){
                            j.setOcupada(true);
                            panelAforo(panel);
                        }
                    }
                }
            };
            botonOcuparMesa.addActionListener(accionOcuparMesa);
            if(m.isOcupada())botonOcuparMesa.setEnabled(false);
            panel2.add(botonOcuparMesa);
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
        labelMesa.setBounds(50,100,70,20);
        panel.add(labelMesa);
        //Campo Mesa
        JTextField campoMesa = new JTextField();
        campoMesa.setBounds(110,100,50,20);
        panel.add(campoMesa);

        //Label Camarero
        JLabel labelCamarero = new JLabel("Camarero:");
        labelCamarero.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCamarero.setForeground(Color.white);
        labelCamarero.setBounds(250,100,100,20);
        panel.add(labelCamarero);
        //Campo Camarero
        JTextField campoCamarero = new JTextField();
        campoCamarero.setBounds(350,100,50,20);
        panel.add(campoCamarero);

        //Label Producto
        JLabel labelProducto = new JLabel("Producto:");
        labelProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelProducto.setForeground(Color.white);
        labelProducto.setBounds(50,200,100,20);
        panel.add(labelProducto);
        //Combo Producto
        JComboBox comboProducto = new JComboBox();
        comboProducto.setBounds(150,200,250,20);
        panel.add(comboProducto);

        //Label Tipo Producto
        JLabel labelTipoProducto = new JLabel("Tipo:");
        labelTipoProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelTipoProducto.setForeground(Color.white);
        labelTipoProducto.setBounds(50,150,100,20);
        panel.add(labelTipoProducto);
        //Combo Tipo Producto
        JComboBox comboTipoProducto = new JComboBox();
        comboTipoProducto.setBounds(100,150,140,20);
        comboTipoProducto.addItem(TipoProducto.TAPA);
        comboTipoProducto.addItem(TipoProducto.MEDIA);
        comboTipoProducto.addItem(TipoProducto.RACION);
        comboTipoProducto.addItem(TipoProducto.ESPECIALIDADES);
        comboTipoProducto.addItem(TipoProducto.BEBIDAS);
        comboTipoProducto.addItem(TipoProducto.POSTRES);
        panel.add(comboTipoProducto);
        ActionListener accionComboTipoProducto = e -> {
            comboProducto.removeAllItems();
            for (Producto p:listaProductos.stream().filter(p->p.getTipoProducto().
                    equals(TipoProducto.valueOf(comboTipoProducto.getSelectedItem().toString()))).collect(Collectors.toList())){
                comboProducto.addItem(p.getDescripcion());
            }
        };
        comboTipoProducto.addActionListener(accionComboTipoProducto);

        //Label Cantidad
        JLabel labelCantidad = new JLabel("Cantidad:");
        labelCantidad.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCantidad.setForeground(Color.white);
        labelCantidad.setBounds(50,250,100,20);
        panel.add(labelCantidad);
        //Campo Cantidad
        JTextField campoCantidad = new JTextField();
        campoCantidad.setBounds(150,250,50,20);
        panel.add(campoCantidad);



        //Boton añadir linea comanda
        JButton aniadirProducto = new JButton("Añadir");
        aniadirProducto.setBounds(300,350,100,50);
        ActionListener accionAniadirProducto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Comprobamos la mesa
                if(FacturaYComandaBD.mesaOcupada(Integer.valueOf(campoMesa.getText()))){
                    LineaComanda nuevaLineaComanda = new LineaComanda();
                    nuevaLineaComanda.setCantidadProducto(Integer.valueOf(campoCantidad.getText()));
                    nuevaLineaComanda.setIdProducto(listaProductos.stream().
                            filter(p -> p.getTipoProducto().equals(TipoProducto.valueOf(comboTipoProducto.getSelectedItem().toString()))&&
                            p.getDescripcion().equals(comboProducto.getSelectedItem().toString())).collect(Collectors.toList()).get(0).getId());
                    nuevaLineaComanda.setIdEmpleado(Integer.valueOf(campoCamarero.getText()));
                    nuevaLineaComanda.setId_mesa(Integer.valueOf(campoMesa.getText()));
                    nuevaLineaComanda.setId(0);
                    nuevaLineaComanda.setIdFactura(0);
                    nuevaLineaComanda.setCantidadCocinada(0);
                    listaComandas.add(nuevaLineaComanda);
                    panelPedidos(panel);
                }
            }
        };
        aniadirProducto.addActionListener(accionAniadirProducto);
        panel.add(aniadirProducto);

        //Boton tramitar comanda
        JButton enviarComanda = new JButton("Enviar Comanda");
        enviarComanda.setBounds(600,500,300,50);
        panel.add(enviarComanda);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        //productos en botones para poner bonico

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        int bajadaLabel = 0;
        for(LineaComanda lc:listaComandas){
            JLabel labelProducto2 = new JLabel(listaProductos.stream().filter(p->p.getId()== lc.getIdProducto()).collect(Collectors.toList()).get(0).getDescripcion());
            labelProducto2.setBounds(0,15*bajadaLabel,250,20);
            panel2.add(labelProducto2);
            JLabel labelTipoProducto2 = new JLabel(listaProductos.stream().filter(p->p.getId()== lc.getIdProducto()).collect(Collectors.toList()).get(0).getTipoProducto().toString());
            labelTipoProducto2.setBounds(250,15*bajadaLabel,250,20);
            panel2.add(labelTipoProducto2);
            JLabel labelCantidad2 = new JLabel(""+lc.getCantidadProducto());
            labelCantidad2.setBounds(350,15*bajadaLabel,50,20);
            panel2.add(labelCantidad2);
            bajadaLabel++;
        }
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
