package UtilidadesBBDD;

import Modelos.LineaComanda;
import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static UtilidadesBBDD.UtilidadesBD.*;

public class FacturaYComandaBD {

    public static void ActualizarCantidad(LineaComanda comanda){
        Connection con = conectarConBD();

        try {

            PreparedStatement update = con.prepareStatement("update linea_comanda " + "set cantidad_cocinada = ? " + "where id = ? ");

            int numerito = 0;
            numerito = comanda.getCantidadCocinada() + 1;
            update.setInt(1, numerito);
            update.setInt(2, comanda.getId());

            update.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally{
            cerrarConexion(con);
        }


    }


        public static List<LineaComanda> ObtenerComandas() {
        List<LineaComanda> comandas = new ArrayList<>();
        Connection con = conectarConBD();
        LineaComanda linea_comanda;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM linea_comanda  ");
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {


                LineaComanda comida = new LineaComanda(rs.getInt("id"),
                        rs.getInt("num_empleado"),
                        rs.getInt("id_factura"),
                        rs.getInt("id_producto"),
                        rs.getInt("num_mesa"),
                        rs.getInt("cantidad"),
                        rs.getInt("cantidad_cocinada"));

                comandas.add(comida);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
        return comandas;
    }

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

    public static boolean obtenerCuentasAPagar(Integer numMesa){
        Connection con = conectarConBD();
        int numMesaOcupada = 0;
        int id_factura =0;
        List<LineaComanda> listaLineaComanda = new ArrayList<>();
        try {
            PreparedStatement query = con.prepareStatement("select id from factura where pagado =0 and num_mesa = ? ");
            query.setInt(1,numMesa);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                id_factura = rs.getInt("id");
            }
            PreparedStatement query2 = con.prepareStatement("select cantidad, cantidad_cocinada from linea_comanda where id_factura  = ? ");
            query2.setInt(1,id_factura);
            ResultSet rs2 = query2.executeQuery();



            while (rs2.next()) {
                LineaComanda lineaComanda = new LineaComanda();
                lineaComanda.setCantidadProducto(rs2.getInt("cantidad"));
                lineaComanda.setCantidadCocinada(rs2.getInt("cantidad_cocinada"));
                listaLineaComanda.add(lineaComanda);
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
            if(listaLineaComanda.isEmpty())return false;
            for(LineaComanda lc:listaLineaComanda){
                if (lc.getCantidadCocinada()!=lc.getCantidadProducto())return false;
            }
            return true;
        }
    }
    public static List<LineaComanda> obtenerProductosFactura(Integer numMesa){
        Connection con = conectarConBD();
        int numMesaOcupada = 0;
        int id_factura =0;
        List<LineaComanda> listaLineaComanda = new ArrayList<>();
        try {
            PreparedStatement query = con.prepareStatement("select id from factura where pagado =0 and num_mesa = ? ");
            query.setInt(1,numMesa);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                id_factura = rs.getInt("id");
            }
            PreparedStatement query2 = con.prepareStatement("select p.id , sum(lc.cantidad) as cantidad, num_empleado from linea_comanda lc join producto p on lc.id_producto = p.id  where id_factura = ? group by p.id ");
            query2.setInt(1,id_factura);
            ResultSet rs2 = query2.executeQuery();


            while (rs2.next()) {
                LineaComanda lineaComanda = new LineaComanda();
                lineaComanda.setIdProducto(rs2.getInt("id"));
                lineaComanda.setCantidadProducto(rs2.getInt("cantidad"));
                lineaComanda.setNumEmpleado(rs2.getInt("num_empleado"));
                lineaComanda.setNum_mesa(numMesa);
                lineaComanda.setIdFactura(id_factura);
                listaLineaComanda.add(lineaComanda);
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
        return listaLineaComanda;
    }

}
