import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.*;


public class ConstruirRestaurante {

    private JFrame ventana;
    private JPanel panel,panelimprimir;
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


        PanelBienvenida(panel);
        ventana.add(panel);
        ventana.setVisible(true);
    }

    private void RestaurarPanel()   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void PanelBienvenida(JPanel Panel)   //panel principal de bienvenida
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

    }




}
