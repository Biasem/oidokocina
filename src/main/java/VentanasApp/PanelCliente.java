package VentanasApp;

import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;
import metodos.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.awt.Font.BOLD;
import static metodos.metodos.etiqueta;

public class PanelCliente extends JPanel {


    public static void panelCliente(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        JButton vercarta = new JButton();
        vercarta.setBounds(400,200,400,400);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\menu.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        vercarta.setIcon(imagen);
        ActionListener oyenteCarta = e -> {
            PanelPrincipal.RestaurarPanel(panel);
            verCarta(panel);
        };

        ArrayList <JButton> peque = new ArrayList<>();
        peque.add(vercarta);
        vercarta.addActionListener(oyenteCarta);

        metodos.plantillaboton(peque, panel);

        PanelPrincipal.botonAtras();


    }
    public static void verCarta(JPanel panel){
        ArrayList<JPanel> paneles = new ArrayList<>();

        JPanel panelcomida = new JPanel();
        JPanel panelbebidas = new JPanel();
        JPanel panelpostres = new JPanel();
        JPanel panelespecialidades = new JPanel();

        paneles.add(panelcomida);
        paneles.add(panelbebidas);
        paneles.add(panelpostres);
        paneles.add(panelespecialidades);

        JScrollPane scrollcomida = new JScrollPane(panelcomida);
        JScrollPane scrollbebida = new JScrollPane(panelbebidas);
        JScrollPane scrollpostres = new JScrollPane(panelpostres);
        JScrollPane scrollespecial = new JScrollPane(panelespecialidades);


        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = e -> {
            PanelPrincipal.RestaurarPanel(panel);
            panelCliente(panel);
        };
        atras.addActionListener(oyenteAtras);

        metodos.botonAtras(atras);

        //panel donde van los productos

        List<Producto> lista;
        List<Producto> listabebidas;
        List<Producto> listapostres;
        List<Producto> listaespecial;
        List<Producto> listacomida;

        // Creamos tres listas para luego hacer los bucles por separado

        lista = ProductoBD.obtenerTodosProductos().stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());

        listabebidas = lista.stream().filter(p->p.getTipoProducto().equals(TipoProducto.BEBIDAS)).collect(Collectors.toList());

        listapostres = lista.stream().filter(p->p.getTipoProducto().equals(TipoProducto.POSTRES)).collect(Collectors.toList());

        listaespecial = lista.stream().filter(p->p.getTipoProducto().equals(TipoProducto.ESPECIALIDADES)).collect(Collectors.toList());

        listacomida = lista.stream().filter(p->!p.getTipoProducto().equals(TipoProducto.BEBIDAS)&&
                !p.getTipoProducto().equals(TipoProducto.POSTRES)&&
                !p.getTipoProducto().equals(TipoProducto.ESPECIALIDADES)).collect(Collectors.toList())
        .stream().sorted(Comparator.comparing(Producto::getTipoProducto)).collect(Collectors.toList()).
        stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());


        // Generamos los paneles y botones

        JButton botoncomida = new JButton();
        JButton botonbebidas = new JButton();
        JButton botonpostres = new JButton();
        JButton botonespecialidades = new JButton();

        ArrayList<JButton> botones = new ArrayList<>();

        botones.add(botoncomida);
        botones.add(botonbebidas);
        botones.add(botonpostres);
        botones.add(botonespecialidades);

        botoncomida.setText("Comida");
        botonbebidas.setText("Bebidas");
        botonpostres.setText("Postres");
        botonespecialidades.setText("Especial");

        botoncomida.setBounds(50, 20, 60, 30);
        botonbebidas.setBounds(120, 20, 60, 30);
        botonpostres.setBounds(190, 20, 60, 30);
        botonespecialidades.setBounds(260, 20, 60, 30);

        for (JButton x: botones){
            x.setFocusPainted(true);
            x.setContentAreaFilled(true);
            x.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, Color.darkGray));
            x.setBackground(Color.WHITE);
            x.setFont(new Font("TimesRoman", BOLD,10));
        }

        panel.add(botoncomida);
        panel.add(botonbebidas);
        panel.add(botonpostres);
        panel.add(botonespecialidades);

        panelcomida.setLayout(new GridLayout(listacomida.stream().map(Producto::getDescripcion).distinct().collect(Collectors.toList()).size(), 4, 5, 2));
        panelbebidas.setLayout(new GridLayout(listabebidas.size(), 2, 2, 1));
        panelpostres.setLayout(new GridLayout(listapostres.size(), 2, 2, 1));
        panelespecialidades.setLayout(new GridLayout(listaespecial.size(), 2, 2, 1));

        //Etiquetas de las raciones

        JLabel tapa = new JLabel();
        JLabel media = new JLabel();
        JLabel racion = new JLabel();
        JLabel precio = new JLabel();

        tapa.setText("Tapa");
        media.setText("Media");
        racion.setText("Ración");
        precio.setText("Precio");

        ArrayList<JLabel> texto = new ArrayList<>();
        texto.add(tapa);
        texto.add(media);
        texto.add(racion);
        texto.add(precio);


        for (JLabel x: texto){
            x.setFont( new Font("TimesRoman", BOLD,15));
            x.setForeground(Color.BLACK);
            x.setOpaque(true);
            if (x == tapa){
                x.setBounds(325, 20, 260, 30);
            }
            if (x == media){
                x.setBounds(585, 20, 280, 30);
            }
            if (x == racion){
                x.setBounds(865, 20, 285, 30);
            }
            if (x == precio){
                x.setBounds(325, 20, 260, 30);
            }

        }

        // Acciones que harán los botones. En este caso, desactivan los paneles y alteran el texto de los JLabel.

        ActionListener comidaaccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollcomida.setVisible(true);
                scrollbebida.setVisible(false);
                scrollpostres.setVisible(false);
                scrollespecial.setVisible(false);
                tapa.setText("Tapa");
                media.setText("Media");
                racion.setText("Ración");
            }
        };

        ActionListener bebidaaccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollcomida.setVisible(false);
                scrollbebida.setVisible(true);
                scrollpostres.setVisible(false);
                scrollespecial.setVisible(false);
                tapa.setText("");
                media.setText("Precio");
                racion.setText("");
            }
        };

        ActionListener postreaccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollcomida.setVisible(false);
                scrollbebida.setVisible(false);
                scrollpostres.setVisible(true);
                scrollespecial.setVisible(false);
                tapa.setText("");
                media.setText("Precio");
                racion.setText("");
            }
        };

        ActionListener especialidadaccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollcomida.setVisible(false);
                scrollbebida.setVisible(false);
                scrollpostres.setVisible(false);
                scrollespecial.setVisible(true);
                tapa.setText("");
                media.setText("Precio");
                racion.setText("");
            }
        };

        botoncomida.addActionListener(comidaaccion);
        botonbebidas.addActionListener(bebidaaccion);
        botonpostres.addActionListener(postreaccion);
        botonespecialidades.addActionListener(especialidadaccion);

        panel.add(tapa);
        panel.add(media);
        panel.add(racion);

        // Panel comidas
        Producto np = new Producto();
        np = lista.get(0);

        for (Producto p:listacomida){
            if(p.equals(np)){// primera iteracion del bucle
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
            }
            //segunda iteración y siguientes, si p es distinto a np significa que entramos en un nuevo producto por tanto
            // tenemos que ver si ese producto nuevo es tapa media o racion y segun el anterior haya sido habra que rellenar
            else if (!p.getDescripcion().equals(np.getDescripcion())){
                //relleno del anterior segun sea tapa o media
                if(np.getTipoProducto().equals(TipoProducto.TAPA)){
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(""));

                }
                if(np.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panelcomida.add(etiqueta(""));
                }
                //segun el siguiente producto, procedemos a su inicio y prodecemos al avance de la variable auxiliar
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panelcomida.add(etiqueta(p.getDescripcion()));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(""));
                    panelcomida.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
            }
            //comparamos si el siguiente tiene la misma descripción solo obtenemos el precio
            else if(np.getDescripcion().equals(p.getDescripcion())){
                panelcomida.add(etiqueta(p.getPrecio().toString()));
                np=p;
            }
        }

        for (Producto p:listabebidas){
                panelbebidas.add(etiqueta(p.getDescripcion()));
                panelbebidas.add(etiqueta(p.getPrecio().toString()));
        }


       for (Producto x: listaespecial){
               panelespecialidades.add(etiqueta(x.getDescripcion()));
               panelespecialidades.add(etiqueta(x.getPrecio().toString()));
       }

        for (Producto p:listapostres){
            panelpostres.add(etiqueta(p.getDescripcion()));
            panelpostres.add(etiqueta(p.getPrecio().toString()));
        }



        // Hacemos que todos los paneles se vean igual en cuanto a estetica



        for (JPanel x: paneles){
            x.setOpaque(true);
            x.setBackground(Color.WHITE);
        }

        ArrayList<JScrollPane> listascroll = new ArrayList<>();

        listascroll.add(scrollcomida);
        listascroll.add(scrollbebida);
        listascroll.add(scrollpostres);
        listascroll.add(scrollespecial);

        for (JScrollPane x: listascroll){
            x.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            x.setBounds(50, 50, 1100, 620);// aqui se puede ajustar los parametros del scrool
            x.setOpaque(false);
            x.getViewport().setOpaque(false);
            panel.add(x);
        }


    }
}