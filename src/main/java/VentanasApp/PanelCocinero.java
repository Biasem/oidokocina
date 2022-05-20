package VentanasApp;

import Modelos.Empleado;
import Modelos.LineaComanda;
import Modelos.Producto;
import UtilidadesBBDD.EmpleadoBD;
import UtilidadesBBDD.FacturaYComandaBD;
import UtilidadesBBDD.ProductoBD;
import metodos.metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PanelCocinero extends JPanel {
    static void panelCocinero(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //Boton Comandas
        JButton verComandas = new JButton("Comandas");

        String enlace = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\guion.png";
        ImageIcon imagen = new ImageIcon(enlace);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        verComandas.setIcon(imagen);
        verComandas.setFocusPainted(true);

        ArrayList<JButton> comanda = new ArrayList<>();
        comanda.add(verComandas);
        metodos.plantillaboton(comanda, panel);
        verComandas.setBounds(460, 500, 250, 100);
        ActionListener oyenteComandas = e -> panelComandas(panel);
        verComandas.addActionListener(oyenteComandas);
        //boton atras
        PanelPrincipal.botonAtras();
    }

    private static void panelComandas(JPanel panel){
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 20, 20));
        //productos en botones para poner bonico

        panel2.setOpaque(true);
        panel2.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 50, 1120, 620);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        String enlace = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\fondo.png";
        ImageIcon imagen = new ImageIcon(enlace);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(1120, 620,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);


        JLabel image = new JLabel();
        image.setIcon(imagen);
        image.setBounds(0, 0, 1120, 620);


        //scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);



        ArrayList<LineaComanda> lista = new ArrayList<>();
        lista = (ArrayList<LineaComanda>) FacturaYComandaBD.ObtenerComandas().stream().sorted(Comparator.comparing(LineaComanda::getNum_mesa)).collect(Collectors.toList());

        ArrayList<JButton> total = new ArrayList<>();

        for (LineaComanda x: lista){
            if (x.getCantidadProducto() <= x.getCantidadCocinada()){

            }

            else{
                JLabel texto = new JLabel();
                texto.setName(String.valueOf(x.getId()));
                int empleado = 0;
                int producto = 0;

                empleado = x.getNumEmpleado();
                producto = x.getIdProducto();

                Empleado trabajador = new Empleado();
                Producto comida = new Producto();

                comida = ProductoBD.obtenerPorId(producto);
                trabajador = EmpleadoBD.obtenerPorNumEmpleado(empleado);

                texto.setText("Camarero:  " + trabajador.getNombre() + "  " + "Producto:  " + comida.getDescripcion() + "  " + "Cantidad:  " + x.getCantidadProducto() + "  " + "Preparado:  " + x.getCantidadCocinada());
                metodos.plantillatextococinero(texto);

                JButton mesa = new JButton();
                mesa.setText(String.valueOf(x.getNum_mesa()));
                mesa.setName(String.valueOf(x.getId()));

                ArrayList<LineaComanda> nuevalista = lista;

                ActionListener mesafuncion = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LineaComanda comanda = new LineaComanda();
                        for (LineaComanda y: nuevalista){

                            if (Integer.valueOf(mesa.getName()) == y.getId()){
                                comanda = y;
                            }
                        }
                        FacturaYComandaBD.ActualizarCantidad(comanda);

                        if (comanda.getCantidadProducto() == comanda.getCantidadCocinada()){
                            mesa.setEnabled(false);
                            if (texto.getName() == mesa.getName()){
                                texto.setText("Hecho");
                            }
                        }
                        panelComandas(panel);
                    }
                };
                mesa.addActionListener(mesafuncion);
                metodos.plantillabotoncocinero(mesa);

                total.add(mesa);
                panel2.add(mesa);
                panel2.add(texto);
            }
        }

        if (panel2.getComponentCount() == 0){
            panel2.add(image);
           scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
           scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        }else{
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }

        panel2.setLayout(new GridLayout(total.size(), 2, 2, 2));


        //boton atras
        JButton atras = new JButton("atras");
        metodos.botonAtras(atras);
        panel.add(atras);
        ActionListener oyenteAtras = e -> panelCocinero(panel);
        atras.addActionListener(oyenteAtras);
    }

}
