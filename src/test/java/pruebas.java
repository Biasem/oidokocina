import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;
import UtilidadesBBDD.UtilidadesBD;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pruebas extends UtilidadesBD{

    public static void main(String... args) {
        List<Producto> lista;
        lista = ProductoBD.obtenerTodosProductos().stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());

        //lista de bebidas System.out.println(lista.stream().filter(p->p.getTipoProducto().equals(TipoProducto.BEBIDAS)).collect(Collectors.toList()));
        //lista de postres System.out.println(lista.stream().filter(p->p.getTipoProducto().equals(TipoProducto.POSTRE)).collect(Collectors.toList()));
        Producto np = new Producto();
        lista = lista.stream().filter(p->!p.getTipoProducto().equals(TipoProducto.BEBIDAS)&&!p.getTipoProducto().equals(TipoProducto.POSTRES)).collect(Collectors.toList());

        np = lista.get(0);
        String cadena="";
        for (Producto p:lista){
            if(p.)
            if (p.equals(np)){
                cadena +=p.getDescripcion()+p.getPrecio();
            }else if(p.getDescripcion().equals(np.getDescripcion())&&!p.getTipoProducto().equals(np.getTipoProducto())){
                cadena+= "  "+p.getPrecio();
            }
            else{
                np = p;
                cadena+=" \n"+p.getDescripcion()+" "+p.getPrecio();

            }
        }
        System.out.println(cadena);
    }
}