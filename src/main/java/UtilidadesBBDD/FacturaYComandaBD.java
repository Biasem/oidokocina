package UtilidadesBBDD;

import Modelos.LineaComanda;
import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static UtilidadesBBDD.UtilidadesBD.*;

public class FacturaYComandaBD {

    public static void crearFacturaMesa(int numMesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into factura (fecha,total,pagado,num_mesa)" +
                    "values(?,?,?,?)");

            insert.setDate(1, Date.valueOf(LocalDate.now()));
            insert.setDouble(2, 0.0);
            insert.setInt(3, 0);
            insert.setInt(4, numMesa);
            //Ejecución del insert
            insert.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
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
            PreparedStatement query = con.prepareStatement("select id from factura where num_mesa = ? and pagado = 0  ");
            query.setInt(1, listaLineaComanda.get(0).getNum_mesa());
            ResultSet rs = query.executeQuery();
            int idFactura = 0;
            while (rs.next()) {
                idFactura =  rs.getInt("id");

            }

        for(LineaComanda comanda:listaLineaComanda) {
            PreparedStatement insert = con.prepareStatement("insert into linea_comanda (num_empleado,id_factura,id_producto,num_mesa,cantidad,cantidad_cocinada)" +
                    "values(?,?,?,?,?,?)");

            insert.setInt(1, comanda.getNumEmpleado());
            insert.setInt(2, idFactura);
            insert.setInt(3, comanda.getIdProducto());
            insert.setInt(4, comanda.getNum_mesa());
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

    public static void obtenerCuentasAPagar(){
        Connection con = conectarConBD();
        int numMesaOcupada = 0;
        try {
            PreparedStatement query = con.prepareStatement("select num_mesa from mesa where ocupada =1 ");
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                numMesaOcupada =  rs.getInt("id");



            }


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }






    }




}
