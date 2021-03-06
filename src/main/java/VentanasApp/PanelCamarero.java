package VentanasApp;

import Modelos.LineaComanda;
import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.*;
import metodos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.Color.*;


public class PanelCamarero extends JPanel {
    //BORRAR CUANDO ESTE IMPLEMENTADO LA BBDD DE MESAS

    static List<Producto> listaProductos = new ArrayList<>();
    static List<LineaComanda> listaComandas = new ArrayList<>();
//-----------------------------------------------------------------------------------------------

    static void panelCamarero(JPanel panel){

        if (listaProductos.isEmpty()) listaProductos = ProductoBD.obtenerTodosProductos().stream().collect(Collectors.toList());

        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        ArrayList<JButton> listabotones = new ArrayList<>();

        //boton de aforo
        JButton aforo = new JButton("Aforo");
        aforo.setBounds(230, 500, 250, 100);
        ActionListener oyenteAforo = e -> panelAforo(panel);
        aforo.addActionListener(oyenteAforo);

        listabotones.add(aforo);

        String ruta6 = new File("").getAbsolutePath() + "//src//main//imagenes//crowd.png" ;
        ImageIcon imagen6 = new ImageIcon(ruta6);
        Image imagenLimitadaTamanyo = imagen6.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen6.setImage(imagenLimitadaTamanyo);
        aforo.setIcon(imagen6);

        //boton de pedidos
        JButton pedidos = new JButton("Pedidos");
        pedidos.setBounds(730, 500, 250, 100);
        ActionListener oyentepedidos = e -> panelPedidos(panel);
        pedidos.addActionListener(oyentepedidos);

        listabotones.add(pedidos);

        String ruta3 = new File("").getAbsolutePath() + "//src//main//imagenes//products.png" ;
        ImageIcon imagen3 = new ImageIcon(ruta3);
        Image imagenLimitadaTamanyo3 = imagen3.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen3.setImage(imagenLimitadaTamanyo3);
        pedidos.setIcon(imagen3);

        //boton de cuentas
        JButton cuentas = new JButton("Cuentas");
        cuentas.setBounds(480, 500, 250, 100);
        ActionListener oyentecuentas = e -> panelCuentas(panel);
        cuentas.addActionListener(oyentecuentas);

        listabotones.add(cuentas);

        String ruta4 = new File("").getAbsolutePath() + "//src//main//imagenes//bill.png" ;
        ImageIcon imagen4 = new ImageIcon(ruta4);
        Image imagenLimitadaTamanyo4 = imagen4.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen4.setImage(imagenLimitadaTamanyo4);
        cuentas.setIcon(imagen4);

        metodos.plantillaboton(listabotones, panel);

        //boton atras
        PanelPrincipal.botonAtras();
    }
    // subpanel de camarero AFORO
    private static void panelAforo(JPanel panel){
        List<Mesa> listaMesas = new ArrayList<>();
        listaMesas.addAll(MesaBD.obtenerTodasMesas());

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
                    super.setForeground(white);
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
            ArrayList<JButton> botones = new ArrayList<>();
            botones.add(botonOcuparMesa);
            botonOcuparMesa.setName(""+m.getNum_Mesa());
            ActionListener accionOcuparMesa = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Mesa j:listaMesas){
                        if (j.getNum_Mesa()==Integer.valueOf(botonOcuparMesa.getName())){
                            MesaBD.ocuparMesa(j.getNum_Mesa());
                            FacturaYComandaBD.crearFacturaMesa(j.getNum_Mesa());
                            panelAforo(panel);
                        }
                    }
                }
            };
            botonOcuparMesa.addActionListener(accionOcuparMesa);
            if(m.isOcupada())botonOcuparMesa.setEnabled(false);
            metodos.plantillaboton(botones, panel2);
        }
        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(200, 90, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(true);
        scrollPane.setBackground(Color.darkGray);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        PanelPrincipal.botonAtrasCamarero();
    }
    // subpanel de camarero CUENTAS
    private static void panelCuentas(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        List<Mesa> listaMesas = new ArrayList<>();
        listaMesas.addAll(MesaBD.obtenerTodasMesas().stream().filter(m->m.isOcupada()==true).collect(Collectors.toList()));
        Font fuente = new Font("TimesRoman",Font.BOLD,20);


        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(listaMesas.size(), 2, 20, 20));
        //productos en botones para poner bonico
        for (Mesa m:listaMesas) {
            panel2.add(new JLabel("Mesa" + m.getNum_Mesa()) {
                @Override
                public void setFont(Font font) {
                    font = fuente;
                    super.setFont(font);
                }
                @Override
                public void setForeground(Color bg) {
                    super.setForeground(WHITE);
                }
            });
            JButton botonPagarCuenta = new JButton("Pagar Cuenta");
            botonPagarCuenta.setFocusPainted(true);
            botonPagarCuenta.setContentAreaFilled(true);
            botonPagarCuenta.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, Color.darkGray));
            botonPagarCuenta.setBackground(Color.WHITE);
            botonPagarCuenta.setName(""+m.getNum_Mesa());
            ActionListener accionPagarCuenta = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (m.getNum_Mesa()==Integer.valueOf(botonPagarCuenta.getName())) {
                        CrearFacturaPDF.crearFactura(FacturaYComandaBD.obtenerProductosFactura(m.getNum_Mesa()));
                        panelCuentas(panel);
                    }
                }
            };
            botonPagarCuenta.addActionListener(accionPagarCuenta);
            if(!FacturaYComandaBD.obtenerCuentasAPagar(m.getNum_Mesa()))botonPagarCuenta.setEnabled(false);
            panel2.add(botonPagarCuenta);
        }

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(200, 90, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(true);
        scrollPane.setBackground(DARK_GRAY);
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
        labelMesa.setForeground(white);
        labelMesa.setBounds(50,150,70,20);
        panel.add(labelMesa);
        //Campo Mesa
        JTextField campoMesa = new JTextField();
        campoMesa.addKeyListener(new FiltroNumeros());
        campoMesa.setBounds(110,150,50,20);
        panel.add(campoMesa);

        //Label Camarero
        JLabel labelCamarero = new JLabel("Camarero:");
        labelCamarero.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCamarero.setForeground(white);
        labelCamarero.setBounds(50,350,100,20);
        panel.add(labelCamarero);
        //Campo Camarero
        JTextField campoCamarero = new JTextField();
        campoCamarero.addKeyListener(new FiltroNumeros());
        campoCamarero.setBounds(170,350,50,20);
        panel.add(campoCamarero);

        //Label Producto
        JLabel labelProducto = new JLabel("Producto:");
        labelProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelProducto.setForeground(white);
        labelProducto.setBounds(50,250,100,20);
        panel.add(labelProducto);
        //Combo Producto
        JComboBox comboProducto = new JComboBox();
        comboProducto.setBounds(150,250,250,20);
        panel.add(comboProducto);

        //Label Tipo Producto
        JLabel labelTipoProducto = new JLabel("Tipo:");
        labelTipoProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelTipoProducto.setForeground(white);
        labelTipoProducto.setBounds(50,200,100,20);
        panel.add(labelTipoProducto);
        //Combo Tipo Producto
        JComboBox comboTipoProducto = new JComboBox();
        comboTipoProducto.setBounds(100,200,140,20);
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
        labelCantidad.setForeground(white);
        labelCantidad.setBounds(50,300,100,20);
        panel.add(labelCantidad);
        //Campo Cantidad
        JTextField campoCantidad = new JTextField();
        campoCantidad.addKeyListener(new FiltroNumeros());
        campoCantidad.setBounds(150,300,50,20);
        panel.add(campoCantidad);

        ArrayList<JButton> botones = new ArrayList<>();
        //Boton a??adir linea comanda
        JButton aniadirProducto = new JButton("A??adir");
        botones.add(aniadirProducto);
        aniadirProducto.setBounds(650,600,100,50);
        ActionListener accionAniadirProducto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //comprobamos que no haya campos vacios
                if(!campoCamarero.getText().isEmpty()&&!campoMesa.getText().isEmpty()&&!campoCantidad.getText().isEmpty()
                &&comboProducto.getItemCount()>0){
                    //comprobamos que la cantidad no sea 0
                    if (Integer.valueOf(campoCantidad.getText()) > 0) {
                        //comprobamos camarero
                        if (EmpleadoBD.esCamarero(Integer.valueOf(campoCamarero.getText()))) {
                            //Comprobamos la mesa
                            if (FacturaYComandaBD.mesaOcupada(Integer.valueOf(campoMesa.getText()))) {
                                LineaComanda nuevaLineaComanda = new LineaComanda();
                                nuevaLineaComanda.setCantidadProducto(Integer.valueOf(campoCantidad.getText()));
                                nuevaLineaComanda.setIdProducto(listaProductos.stream().
                                        filter(p -> p.getTipoProducto().equals(TipoProducto.valueOf(comboTipoProducto.getSelectedItem().toString())) &&
                                                p.getDescripcion().equals(comboProducto.getSelectedItem().toString())).collect(Collectors.toList()).get(0).getId());
                                nuevaLineaComanda.setNumEmpleado(Integer.valueOf(campoCamarero.getText()));
                                nuevaLineaComanda.setNum_mesa(Integer.valueOf(campoMesa.getText()));
                                nuevaLineaComanda.setId(0);
                                nuevaLineaComanda.setIdFactura(0);
                                nuevaLineaComanda.setCantidadCocinada(0);
                                listaComandas.add(nuevaLineaComanda);
                                panelPedidos(panel);
                            } else {
                                JOptionPane.showMessageDialog(null, "Mesa Libre, imposible hacer comanda");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No has seleccionado un camarero");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad tiene que ser mayor a cero");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Hay campos vac??os");

                }
            }
        };
        aniadirProducto.addActionListener(accionAniadirProducto);


        //Boton tramitar comanda
        JButton enviarComanda = new JButton("Enviar Comanda");
        botones.add(enviarComanda);
        ActionListener accionEnviarComanda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            FacturaYComandaBD.guardarComanda(listaComandas);
            listaComandas = new ArrayList<>();
            panelPedidos(panel);
            }
        };
        enviarComanda.addActionListener(accionEnviarComanda);
        enviarComanda.setBounds(750,600,200,50);


        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        //productos en botones para poner bonico

        metodos.plantillaboton(botones, panel);
        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        int bajadaLabel = 0;
        int numeroParaBoton = 0;

        for(LineaComanda lc:listaComandas){
            JLabel labelProducto2 = new JLabel(listaProductos.stream().filter(p->p.getId()== lc.getIdProducto()).collect(Collectors.toList()).get(0).getDescripcion());
            labelProducto2.setBounds(0,20*bajadaLabel,250,20);
            panel2.add(labelProducto2);
            JLabel labelTipoProducto2 = new JLabel(listaProductos.stream().filter(p->p.getId()== lc.getIdProducto()).collect(Collectors.toList()).get(0).getTipoProducto().toString());
            labelTipoProducto2.setBounds(250,20*bajadaLabel,300,20);
            panel2.add(labelTipoProducto2);
            JLabel labelCantidad2 = new JLabel("Cantidad "+lc.getCantidadProducto());
            labelCantidad2.setBounds(350,20*bajadaLabel,110,20);
            panel2.add(labelCantidad2);
            JButton botonEliminarlineacomanda = new JButton("Eliminar linea");
            botonEliminarlineacomanda.setBounds(430,20*bajadaLabel,125,20);
            botonEliminarlineacomanda.setName(""+numeroParaBoton);
            ActionListener accionEliminarLineaComanda = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                int numero = Integer.valueOf(botonEliminarlineacomanda.getName());
                    listaComandas.remove(numero);
                    System.out.println(numero);
                    System.out.println(listaComandas);
                    panelPedidos(panel);
                }
            };
            botonEliminarlineacomanda.addActionListener(accionEliminarLineaComanda);
            panel2.add(botonEliminarlineacomanda);
            bajadaLabel++;
            numeroParaBoton++;
        }
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(500, 50, 600, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        //scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        PanelPrincipal.botonAtrasCamarero();
    }

}
