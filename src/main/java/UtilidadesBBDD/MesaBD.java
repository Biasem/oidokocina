package UtilidadesBBDD;

import Modelos.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MesaBD extends UtilidadesBD{

    public static Mesa obtenerPorId(Integer id) {

        Connection con = conectarConBD();
        Mesa mesa = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM mesa where id = ?  ");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                mesa = new Mesa(rs.getInt("id"), rs.getInt("num_mesa"),
                        rs.getInt("num_comensales"));

            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }


        return mesa;
    }

  //  public static void crearActualizarMesa(Mesa mesa){

       // Mesa mesaDB = obtenerPorId(mesa.getId());

        //if(mesaDB != null){
       //     actualizarMesa(mesa);
        //}else{
          //  crearMesa(mesa);
        //}
    //}

   /* public static void crearMesa(Mesa mesa){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into mesa (id, num_mesa, num_comensales,)" +
                    "values(?,?,?)");

            insert.setInt(1, mesa.getId());
            insert.setString(2,mesa.getNum_Mesa());
            insert.setDouble(3, mesa.getNum_Comensales());

            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

*/

}