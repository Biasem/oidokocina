package UtilidadesBBDD;

import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

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



}