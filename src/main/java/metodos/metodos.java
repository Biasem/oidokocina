package metodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import static java.awt.Font.BOLD;

public class metodos {

    public static void  botonAtras(JButton atras){

        atras.setBounds(10,10,40,40);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
    }

    //metodo jlabel

    public static JLabel etiqueta(String texto) {
        Font prueba = new Font("TimesRoman", BOLD, 12);
        JLabel epico = new JLabel(texto) {
            @Override
            public void setFont(Font font) {
                font = prueba;
                super.setFont(font);
            }

            @Override
            public void setForeground(Color bg) {
                super.setForeground(Color.black);
            }

            @Override
            public void setBackground(Color bg) {
                super.setOpaque(true);
                super.setBackground(Color.white);
            }
        };
        return epico;
    }

    //metodo plantilla botones

    public static void plantillaboton(ArrayList<JButton> listaboton, JPanel pantalla){

        for (JButton x: listaboton){
            x.setFocusPainted(true);
            x.setContentAreaFilled(true);
            x.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, Color.darkGray));
            x.setBackground(Color.WHITE);
            pantalla.add(x);
        }

    }

    public static void plantillatexto(JLabel texto){
        texto.setFont( new Font("TimesRoman", BOLD,15));
        texto.setForeground(Color.BLACK);
        texto.setOpaque(true);
    }

    public static void plantillatextococinero(JLabel texto){
        texto.setFont( new Font("TimesRoman", BOLD,12));
        texto.setForeground(Color.BLACK);
        texto.setOpaque(true);
    }

    public static void plantillabotoncocinero (JButton x){
        x.setFocusPainted(true);
        x.setContentAreaFilled(true);
        x.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        x.setBackground(Color.LIGHT_GRAY);
        x.setMaximumSize(new Dimension(20,10));
    }

}
