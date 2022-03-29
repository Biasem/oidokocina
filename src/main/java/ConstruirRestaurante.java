import javax.swing.*;
import java.awt.*;
import java.io.File;


public class ConstruirRestaurante {
    private static final Image urlimg = new ImageIcon(geturlimg()).getImage();
    private JFrame ventana;
    private JPanel panel,panelprincipal;
    private JTextArea areadetexto;
    private JScrollPane barralateral;
    private JTextField cajatexto;
    private JLabel etiqueta;
    private JButton boton;

    ConstruirRestaurante(){
    ConstruirVentana();

    }

    private void ConstruirVentana()
    {                                               //se construye la ventana y panel principal
        ventana = new JFrame("OidoKocina");
        ventana.setSize(800,600);
        ventana.setLocationRelativeTo(null);


        PanelFondo();
        PanelConstruir();
        ventana.setContentPane(panel);
        ventana.setVisible(true);

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

        JLabel prueba = new JLabel("ave aveeee");
        panel.add(prueba);


    }

    private void PanelConstruir()   //panel principal de bienvenida
    {
        panelprincipal = new JPanel();
        panelprincipal.setLayout(null);
        JLabel fondo = new JLabel("hola holita");
        panelprincipal.setOpaque(false);

    }
    private static String geturlimg(){
        String ruta = new File("").getAbsolutePath();
        return ruta + "\\src\\main\\imagenes\\imagen_principal.jpg";
    }

}
