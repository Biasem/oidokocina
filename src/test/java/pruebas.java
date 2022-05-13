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
        lista = lista.stream().filter(p->!p.getTipoProducto().equals(TipoProducto.BEBIDAS)&&
                !p.getTipoProducto().equals(TipoProducto.POSTRES)&&
                !p.getTipoProducto().equals(TipoProducto.ESPECIALIDADES)).collect(Collectors.toList());

        np = lista.get(0);
        String cadena="";
        for (Producto p:lista){
            if(p.equals(np)){// primera iteracion del bucle
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    System.out.println(p.getDescripcion());
                    System.out.println(p.getPrecio());
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    System.out.println(p.getDescripcion());
                    System.out.println("000");
                    System.out.println(p.getPrecio());
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    System.out.println(p.getDescripcion());
                    System.out.println("000");
                    System.out.println("000");
                    System.out.println(p.getPrecio());
                    np=p;
                }
            }
            //segunda iteración y siguientes, si p es distinto a np significa que entramos en un nuevo producto por tanto
            // tenemos que ver si ese producto nuevo es tapa media o racion y segun el anterior haya sido habra que rellenar
            else if (!p.getDescripcion().equals(np.getDescripcion())){
                //relleno del anterior segun sea tapa o media
                if(np.getTipoProducto().equals(TipoProducto.TAPA)){
                    System.out.println("000");
                    System.out.println("000");
                }
                if(np.getTipoProducto().equals(TipoProducto.MEDIA)){
                    System.out.println("000");
                }
                //segun el siguiente producto, procedemos a su inicio y prodecemos al avance de la variable auxiliar
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    System.out.println(p.getDescripcion());
                    System.out.println(p.getPrecio());
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    System.out.println(p.getDescripcion());
                    System.out.println("000");
                    System.out.println(p.getPrecio());
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    System.out.println(p.getDescripcion());
                    System.out.println("000");
                    System.out.println("000");
                    System.out.println(p.getPrecio());
                    np=p;
                }
            }
            //comparamos si el siguiente tiene la misma descripción solo obtenemos el precio
            else if(np.getDescripcion().equals(p.getDescripcion())){
                System.out.println(p.getPrecio());
                np=p;
            }

        }
        lista = ProductoBD.obtenerTodosProductos().stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());
        System.out.println(lista.stream().map(p->p.getDescripcion()).distinct().collect(Collectors.toList()));


    }
}