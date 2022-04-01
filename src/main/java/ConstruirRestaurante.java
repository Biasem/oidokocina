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
    private JPanel panel,panelprincipal;
    private JButton camarero,admin,cliente,cocinero,vercarta;


    ConstruirRestaurante(){
    ConstruirVentana();

    }

    private void ConstruirVentana()
    {                                               //se construye la ventana y panel principal
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

    private void restaurarPanel()   //metodo para reinicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void panelInicio(){ //panel principal de bienvenida
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


    private static String getUrlImagenInicio(){
        String ruta = new File("").getAbsolutePath();
        return ruta  + "\\src\\main\\imagenes\\imagen_principal.jpg";
    }
    private static String getUrlImagenCliente(){
        String ruta = new File("").getAbsolutePath();
        return ruta + "\\src\\main\\imagenes\\carta.png";
    }

    private void panelcliente (){
        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();
        panel.setLayout(null);
        vercarta = new JButton("Carta");
        vercarta.setBounds(350,250,100,50);

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
