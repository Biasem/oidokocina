package VentanasApp;

import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VentanaCliente extends JPanel {


    public static JPanel panelCliente(JPanel panel){
        ConstruirRestaurante.RestaurarPanel(panel);
        // Image urlimg = new ImageIcon(geturlimg()).getImage();
        panel.setLayout(null);
        JButton vercarta = new JButton();
        vercarta.setBounds(400,200,400,400);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\menu.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        vercarta.setIcon(imagen);
        ActionListener oyenteCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConstruirRestaurante.RestaurarPanel(panel);
                verCarta(panel);
            }
        };
        vercarta.addActionListener(oyenteCarta);
        vercarta.setBorderPainted(true);
        vercarta.setFocusPainted(true);
        vercarta.setContentAreaFilled(true);
        vercarta.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        vercarta.setBackground(Color.WHITE);


        vercarta.setBorderPainted(true);
        vercarta.setFocusPainted(true);
        vercarta.setContentAreaFilled(true);
        vercarta.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        vercarta.setBackground(Color.WHITE);

        panel.add(vercarta);
        ConstruirRestaurante.botonAtras(panel);

        return panel;
    }
    public static JPanel verCarta(JPanel panel){

        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ConstruirRestaurante.RestaurarPanel(panel);
                panelCliente(panel);
            }
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

        for (Producto p:lista){
            if(p.equals(np)){// primera iteracion del bucle
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
            }
            //segunda iteración y siguientes, si p es distinto a np significa que entramos en un nuevo producto por tanto
            // tenemos que ver si ese producto nuevo es tapa media o racion y segun el anterior haya sido habra que rellenar
            else if (!p.getDescripcion().equals(np.getDescripcion())){
                //relleno del anterior segun sea tapa o media
                if(np.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                }
                if(np.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(""));
                }
                //segun el siguiente producto, procedemos a su inicio y prodecemos al avance de la variable auxiliar
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
            }
            //comparamos si el siguiente tiene la misma descripción solo obtenemos el precio
            else if(np.getDescripcion().equals(p.getDescripcion())){
                panel2.add(new JButton(p.getPrecio().toString()));
                np=p;
            }

        }

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);
        return panel;

    }


}
