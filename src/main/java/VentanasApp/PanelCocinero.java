package VentanasApp;

import Modelos.LineaComanda;
import Modelos.Producto;
import UtilidadesBBDD.FacturaYComandaBD;
import UtilidadesBBDD.ProductoBD;
import metodos.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PanelCocinero extends JPanel {
    static void panelCocinero(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //Boton Comandas
        JButton verComandas = new JButton("Comandas");
        verComandas.setBounds(300,300,100,100);
        ActionListener oyenteComandas = e -> panelComandas(panel);
        verComandas.addActionListener(oyenteComandas);
        panel.add(verComandas);
        //boton atras
        PanelPrincipal.botonAtras();
    }

    private static void panelComandas(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 20, 20));
        //productos en botones para poner bonico

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(400, 0, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        //scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        ArrayList<LineaComanda> lista = new ArrayList<>();
        lista = (ArrayList<LineaComanda>) FacturaYComandaBD.ObtenerComandas().stream().sorted(Comparator.comparing(LineaComanda::getNum_mesa)).collect(Collectors.toList());

        for (LineaComanda x: lista){
            final int[] numero = {0};
            int id = x.getIdProducto();

            JLabel texto = new JLabel();
            texto.setText("" + x.getNumEmpleado() + "" + x.getIdProducto() + "Cantidad:" + x.getCantidadProducto() + "Cantidad cocinada:" + numero[0]);
            metodos.plantillatexto(texto);

            JButton mesa = new JButton();
            mesa.setText("" + x.getNum_mesa());
            ActionListener mesafuncion = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (id == x.getIdProducto()){
                        numero[0] = numero[0] + 1;

                        if (numero[0] >= x.getCantidadProducto()){
                            mesa.setEnabled(false);
                            texto.setText("Hecho");
                        }
                    }
                }
            };
            mesa.addActionListener(mesafuncion);
            metodos.plantillabotoncocinero(mesa);

            panel2.add(mesa);
            panel2.add(texto);

        }

        //boton atras
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = e -> panelCocinero(panel);
        atras.addActionListener(oyenteAtras);
    }

}
