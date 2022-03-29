import javax.swing.*;
import java.awt.*;


public class ConstruirRestaurante {

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
        Image image = new ImageIcon("D:\\java_restaurante\\src\\main\\imagenes\\imagen_principal.jpg").getImage();
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
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


}
