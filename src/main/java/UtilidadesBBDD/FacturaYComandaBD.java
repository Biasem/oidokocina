package UtilidadesBBDD;

import Modelos.Mesa;
import Modelos.Producto;
import Modelos.TipoProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static UtilidadesBBDD.UtilidadesBD.*;

public class FacturaYComandaBD {

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
}
