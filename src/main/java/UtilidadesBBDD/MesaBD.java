package UtilidadesBBDD;

import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaBD extends UtilidadesBD{

    public static List<Mesa> obtenerTodasMesas() {
        List<Mesa> milista = new ArrayList<>();
        Connection con = conectarConBD();
        Mesa mesa;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM mesa  ");
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                mesa = new Mesa(rs.getInt("num_mesa"),
                        rs.getInt("num_comensales"), rs.getBoolean("ocupada"));
                milista.add(mesa);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
        return milista;
    }

    public static void ocuparMesa(int numMesa){

        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("update mesa set ocupada = 1 " +
                    "where num_mesa =? ");

            insert.setInt(1, numMesa);

            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

    public static void crearMesa(Integer numMesa,Integer numComensales){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into mesa (num_mesa, num_comensales, ocupada)" +
                    "values(?,?,?) ");

            insert.setInt(1, numMesa);
            insert.setInt(2,numComensales);
            insert.setInt(3,0);


            //Ejecución del insert
            insert.executeUpdate();

            JOptionPane.showMessageDialog(null,"Mesa creada");

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,"Esa mesa ya esta creada, seleccione otra");

        } finally {
            cerrarConexion(con);

        }
    }
    public static Mesa obtenerPorNumMesa(Integer numMesa) {

        Connection con = conectarConBD();
        Mesa mesa = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM mesa where num_mesa = ?  ");
            query.setInt(1, numMesa);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                mesa = new Mesa(rs.getInt("num_mesa"), rs.getInt("num_comensales"),
                        rs.getBoolean("ocupada"));

            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return mesa;
    }

    public static void actualizarMesa(Integer numMesa,Integer numComensales){
        Connection con = conectarConBD();

        try {
            PreparedStatement update = con.prepareStatement("update mesa " +
                    "set num_comensales = ? " +
                    " where num_mesa = ? ");
            update.setInt(1,numComensales);
            update.setInt(2, numMesa);


            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }
    public static void eliminarMesa(Integer numMesa){
        Connection con = conectarConBD();
        Integer ocupada = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT ocupada FROM mesa where num_mesa = ? ");
            query.setInt(1,numMesa);
            ResultSet rs = query.executeQuery();
            while (rs.next()){
                ocupada = rs.getInt("ocupada");
            }
            if(ocupada == 0){
                PreparedStatement delete = con.prepareStatement("delete from mesa where num_mesa = ? ");

                delete.setInt(1, numMesa);

                //Ejecución del delete
                delete.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null,"Esa mesa ocupada, solo se puede eliminar mesas libres");

            }


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


}