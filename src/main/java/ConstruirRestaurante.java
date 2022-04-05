import Modelos.Producto;
import UtilidadesBBDD.ProductoBD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Graphics;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ConstruirRestaurante {
    private static Image urlImagen = new ImageIcon(getUrlImagenInicio()).getImage();
    private JFrame ventana;
    private JPanel panel;
    private JButton camarero,admin,cliente,cocinero,vercarta;


    ConstruirRestaurante(){
    ConstruirVentana();

    }

    // metodos para obtener urls de las imagenes de fondo
    private static String getUrlImagenInicio(){
        String ruta = new File("").getAbsolutePath();
        return ruta  + "\\src\\main\\imagenes\\imagen_principal.jpg";
    }
    private static String getUrlImagenCliente(){
        String ruta = new File("").getAbsolutePath();
        return ruta + "\\src\\main\\imagenes\\carta.png";
    }

    //metodo para inicializar la ventana y el panel vacio
    private void ConstruirVentana(){
        ventana = new JFrame("OidoKocina");
        ventana.setSize(800,600);
       // ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(urlImagen, 0, 0, getWidth(), getHeight(), this);
                super.paint(g);
            }
        };
        panelInicio();
        ventana.setContentPane(panel);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }

    // metodo para formatear los paneles
    private void restaurarPanel(){
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    // Panel de Inicio
    private void panelInicio(){
        urlImagen = new ImageIcon(getUrlImagenInicio()).getImage();
        restaurarPanel();
        panel.setOpaque(false);


        cocinero = new JButton("Cocinero");
        camarero = new JButton("Camarero");
        admin = new JButton("Administrador");
        cliente = new JButton("Cliente");
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(100,100,100,100));


        panel.add(cocinero,BorderLayout.NORTH);
        ActionListener oyenteCocinero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero();
            }
        };
        cocinero.addActionListener(oyenteCocinero);

        panel.add(camarero,BorderLayout.WEST);
        ActionListener oyenteCamarero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCamarero();
            }
        };
        camarero.addActionListener(oyenteCamarero);

        panel.add(cliente, BorderLayout.EAST);
        ActionListener oyenteCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        cliente.addActionListener(oyenteCliente);

        panel.add(admin, BorderLayout.SOUTH);
        ActionListener oyenteAdmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAdministrador();
            }
        };
        admin.addActionListener(oyenteAdmin);

    }
    // Panel de la carta
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

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 10, 5));
        for (Producto p : ProductoBD.obtenerTodosProductos()) {
            panel2.add(new JButton(p.toString()));
        }
        panel2.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 800, 500);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);



    }

    // Panel cliente
    private void panelcliente (){
        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();
        panel.setLayout(null);
        vercarta = new JButton("Carta");
        vercarta.setBounds(350,250,100,50);
        ActionListener oyenteCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurarPanel();
                verCarta();
            }
        };
        vercarta.addActionListener(oyenteCarta);


        panel.add(vercarta);
        botonatras();
    }
    private void panelAdministrador (){
        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();
        panel.setLayout(null);
        botonatras();

    }
    private void panelCamarero (){
        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();
        panel.setLayout(null);
        botonatras();

    }
    private void panelCocinero (){

        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();
        panel.setLayout(null);
        botonatras();










    // metodos para botones estándar
    }
    public void botonatras(){
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInicio();
            }
        };
        atras.addActionListener(oyenteAtras);
    }

}
