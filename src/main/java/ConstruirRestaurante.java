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
        panel = new JPanel();

        ImageIcon icon = new ImageIcon("E:\\restaurante_java\\src\\main\\imagenes\\imagen_principal.jpg");
        panel.paint(icon);

        panel.imageUpdate(icon.getImage(), 0,0,)

    }

    private void PanelConstruir()   //panel principal de bienvenida
    {
        panelprincipal = new JPanel();
        panelprincipal.setLayout(null);
        JLabel fondo = new JLabel("hola holita");
        panelprincipal.setOpaque(false);

    }


}
