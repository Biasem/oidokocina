package UtilidadesBBDD;

import Modelos.LineaComanda;
import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static UtilidadesBBDD.UtilidadesBD.*;

public class FacturaYComandaBD {

    public static void crearFacturaMesa(int numMesa){

    }

    public static boolean mesaOcupada(Integer numMesa){
        Connection con = conectarConBD();
        Producto producto = null;
        Integer ocupada =0;

        try {
            PreparedStatement query = con.prepareStatement("SELECT ocupada FROM mesa where num_mesa = ?  ");
            query.setInt(1, numMesa);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                ocupada =  rs.getInt("ocupada");

            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
        if (ocupada==0){
            return false;
        }else{
            return true;
        }

    }
    public static void guardarComanda(List<LineaComanda> listaLineaComanda){
        Connection con = conectarConBD();

        try {
        for(LineaComanda comanda:listaLineaComanda) {
            PreparedStatement insert = con.prepareStatement("insert into linea_comanda (id_empleado,id_factura,id_producto,id_mesa,cantidad,cantidad_cocinada)" +
                    "values(?,?,?,?,?,?)");

            insert.setInt(1, comanda.getIdEmpleado());
            insert.setInt(2, comanda.getIdFactura());
            insert.setInt(3, comanda.getIdProducto());
            insert.setInt(4, comanda.getId_mesa());
            insert.setInt(5, comanda.getCantidadProducto());
            insert.setInt(6, comanda.getCantidadCocinada());

            //Ejecución del insert
            insert.executeUpdate();
            Thread.sleep(100);
        }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion(con);
        }


    }





}
