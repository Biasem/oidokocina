import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.border.AbstractBorder;
import java.awt.*;



public class ConstruirRestaurante {
    private static final Image urlimg = new ImageIcon(geturlimg()).getImage();
    private JFrame ventana;
    private JPanel panel,panelprincipal;
    private JButton camarero,admin,cliente,cocinero;


    ConstruirRestaurante(){
    ConstruirVentana();

    }


    private void ConstruirVentana()
    {                                               //se construye la ventana y panel principal
        ventana = new JFrame("OidoKocina");
        ventana.setSize(800,600);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        PanelFondo();
        ventana.setContentPane(panel);
        ventana.setVisible(true);




    }

    public class seticonimg extends javax.swing.JFrame{

        public seticonimg() {

        }
    }

    private void RestaurarPanel()   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void PanelFondo()   //panel principal de bienvenida
    {
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(urlimg, 0, 0, getWidth(), getHeight(), this);
                super.paint(g);
            }
        };

        panel.setOpaque(false);

        cocinero = new JButton("Cocinero");
        camarero = new JButton("Camarero");
        admin = new JButton("Administrador");
        cliente = new JButton("Cliente");
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(100,100,100,100));


        panel.add(cocinero,BorderLayout.NORTH);
        panel.add(camarero,BorderLayout.WEST);
        panel.add(cliente, BorderLayout.EAST);
        panel.add(admin, BorderLayout.SOUTH);

        cocinero.setBorderPainted(false);
        cocinero.setFocusPainted(false);
        cocinero.setContentAreaFilled(true);

        camarero.setBorderPainted(false);
        camarero.setFocusPainted(false);
        camarero.setContentAreaFilled(true);

        admin.setBorderPainted(false);
        admin.setFocusPainted(false);
        admin.setContentAreaFilled(true);

        cliente.setBorderPainted(false);
        cliente.setFocusPainted(false);
        cliente.setContentAreaFilled(true);


    }


    private static String geturlimg(){
        String ruta = new File("").getAbsolutePath();
        return ruta  + "\\src\\main\\imagenes\\menuprincipal.jpg";
    }



}
