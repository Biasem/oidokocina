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
        vercarta.addActionListener(oyenteCarta);
        vercarta.setBorderPainted(true);
        vercarta.setFocusPainted(true);
        vercarta.setContentAreaFilled(true);
        vercarta.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        vercarta.setBackground(Color.WHITE);

        panel.add(vercarta);
        PanelPrincipal.botonAtras();


    }
    public static void verCarta(JPanel panel){

        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = e -> {
        PanelPrincipal.RestaurarPanel(panel);
            panelCliente(panel);
        };
        atras.addActionListener(oyenteAtras);
        //panel donde van los productos
        List<Producto> lista;
        lista = ProductoBD.obtenerTodosProductos().stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());

        lista = lista.stream().filter(p->!p.getTipoProducto().equals(TipoProducto.BEBIDAS)&&
                !p.getTipoProducto().equals(TipoProducto.POSTRES)&&
                !p.getTipoProducto().equals(TipoProducto.ESPECIALIDADES)).collect(Collectors.toList());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(lista.stream().map(p->p.getDescripcion()).distinct().collect(Collectors.toList()).size(), 4, 5, 2));

        //productos en botones para poner bonico
        Producto np = new Producto();
        np = lista.get(0);

        //Etiquetas de las reciones

        JLabel tapa = new JLabel();
        JLabel media = new JLabel();
        JLabel racion = new JLabel();

        tapa.setText("Tapa");
        media.setText("Media");
        racion.setText("Ración");

        ArrayList<JLabel> texto = new ArrayList<>();
        texto.add(tapa);
        texto.add(media);
        texto.add(racion);




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

        }

        panel.add(tapa);
        panel.add(media);
        panel.add(racion);

        for (Producto p:lista){
            if(p.equals(np)){// primera iteracion del bucle
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
            }
            //segunda iteración y siguientes, si p es distinto a np significa que entramos en un nuevo producto por tanto
            // tenemos que ver si ese producto nuevo es tapa media o racion y segun el anterior haya sido habra que rellenar
            else if (!p.getDescripcion().equals(np.getDescripcion())){
                //relleno del anterior segun sea tapa o media
                if(np.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(""));
                }
                if(np.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(etiqueta(""));
                }
                //segun el siguiente producto, procedemos a su inicio y prodecemos al avance de la variable auxiliar
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(etiqueta(p.getDescripcion()));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(""));
                    panel2.add(etiqueta(p.getPrecio().toString()));
                    np=p;
                }
            }
            //comparamos si el siguiente tiene la misma descripción solo obtenemos el precio
            else if(np.getDescripcion().equals(p.getDescripcion())){
                panel2.add(etiqueta(p.getPrecio().toString()));
                np=p;
            }

        }

        panel2.setOpaque(true);
        panel2.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 50, 1100, 620);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);


    }


}
