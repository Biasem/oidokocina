import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Graphics;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class ConstruirRestaurante extends JFrame{
    private static Image urlImagen = new ImageIcon(getUrlImagenInicio()).getImage();
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
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelInicio();
        ventana.setContentPane(panel);
        ventana.setVisible(true);


    }

    private void restaurarPanel()   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void panelInicio()   //panel principal de bienvenida
    {
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(urlImagen, 0, 0, getWidth(), getHeight(), this);
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
        ActionListener oyenteCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        cliente.addActionListener(oyenteCliente);

        panel.add(admin, BorderLayout.SOUTH);


    }


    private static String getUrlImagenInicio(){
        String ruta = new File("").getAbsolutePath();
        return ruta + "\\src\\main\\imagenes\\imagen_principal.jpg";
    }
    private static String getUrlImagenCliente(){
        String ruta = new File("").getAbsolutePath();
        return ruta + "\\src\\main\\imagenes\\carta.png";
    }

    private void panelcliente (){
        urlImagen = new ImageIcon(getUrlImagenCliente()).getImage();
        restaurarPanel();












    }


}
