package UtilidadesBBDD;



import Modelos.Empleado;
import Modelos.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoBD extends UtilidadesBD {

    public static Empleado obtenerPorId(Integer id) {

        Connection con = conectarConBD();
        Empleado empleado = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM empleado where id = ?  ");
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                empleado = new Empleado(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellidos"),
                 rs.getInt("codigo_empleado"),Rol.values()[rs.getInt("tipo_empleado")]);
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }

        return empleado;
    }



    public static void crearActualizarEmpleado(Empleado empleado){

        Empleado empBaseDatos = obtenerPorId(empleado.getId());

        if(empBaseDatos != null){
            actualizarEmpleado(empleado);
        }else{
            crearEmpleado(empleado);
        }
    }


    public static void crearEmpleado(Empleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into empleado (id, codigo_empleado, nombre, apellidos, tipo_empleado)" +
                    "values(?,?,?,?,?)");

            insert.setInt(1, empleado.getId());
            insert.setInt(2,empleado.getNum_empleado());
            insert.setString(3,empleado.getNombre());
            insert.setString(4, empleado.getApellidos());
            insert.setInt(5, empleado.getRol().ordinal());

            //Ejecución del insert
            insert.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void actualizarEmpleado(Empleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement update = con.prepareStatement("update empleado " +
                    "set codigo_empleado = ? , nombre = ? , apellidos = ? , tipo_empledado = ?" +
                    "where id = ? ");

            update.setInt(1,empleado.getNum_empleado());
            update.setString(2,empleado.getNombre());
            update.setString(3, empleado.getApellidos());
            update.setInt(4, empleado.getRol().ordinal());
            update.setInt(5, empleado.getId());


            //Ejecución del update
            update.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static void eliminarEmpleado(Empleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement delete = con.prepareStatement("delete from empleado where id = ? ");

            delete.setInt(1, empleado.getId());

            //Ejecución del delete
            delete.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


}
