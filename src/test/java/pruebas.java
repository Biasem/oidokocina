import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;
import UtilidadesBBDD.UtilidadesBD;

import java.awt.Dimension;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class pruebas extends UtilidadesBD{

    public static void main(String... args) {
        for(TipoProducto t :TipoProducto.values()){
            System.out.println(t);
        }

    }
}