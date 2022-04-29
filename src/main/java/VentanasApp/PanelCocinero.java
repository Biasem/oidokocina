package VentanasApp;

import javax.swing.*;
import java.awt.event.*;

public class PanelCocinero extends JPanel {
    static void panelCocinero(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //Boton Comandas
        JButton verComandas = new JButton("Comandas");
        verComandas.setBounds(300,300,100,100);
        ActionListener oyenteComandas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComandas(panel);
            }
        };
        verComandas.addActionListener(oyenteComandas);
        panel.add(verComandas);
        //boton atras
        PanelPrincipal.botonAtras();
    }
    private static void panelComandas(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);


        //boton atras
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero(panel);
            }
        };
        atras.addActionListener(oyenteAtras);
    }

}
