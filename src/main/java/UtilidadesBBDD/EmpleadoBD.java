package UtilidadesBBDD;



import Modelos.Empleado;
import Modelos.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoBD extends UtilidadesBD {

    public static Empleado obtenerPorNumEmpleado(Integer numEmpleado) {

        Connection con = conectarConBD();
        Empleado empleado = null;

        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM empleado where num_empleado = ?  ");
            query.setInt(1, numEmpleado);
            ResultSet rs = query.executeQuery();

            //Recorremos los datos
            while (rs.next()) {
                empleado = new Empleado(rs.getString("nombre"),rs.getString("apellidos"),
                 rs.getInt("num_empleado"),Rol.values()[rs.getInt("rol")]);

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

        Empleado empBaseDatos = obtenerPorNumEmpleado(empleado.getNum_empleado());

        if(empBaseDatos != null){
            actualizarEmpleado(empleado);
        }else{
            crearEmpleado(empleado);
        }
    }


    public static void crearEmpleado(Empleado empleado){
        Connection con = conectarConBD();

        try {
            PreparedStatement insert = con.prepareStatement("insert into empleado (Num_empleado, nombre, apellidos, Rol)" +
                    "values(?,?,?,?)");

            insert.setInt(1,empleado.getNum_empleado());
            insert.setString(2,empleado.getNombre());
            insert.setString(3, empleado.getApellidos());
            insert.setInt(4, empleado.getRol().ordinal());

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
                    "set  nombre = ? , apellidos = ? , rol = ? " +
                    "where num_empleado = ? ");

            update.setString(1,empleado.getNombre());
            update.setString(2, empleado.getApellidos());
            update.setInt(3, empleado.getRol().ordinal());
            update.setInt(4, empleado.getNum_empleado());

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
            PreparedStatement delete = con.prepareStatement("delete from empleado where num_empleado = ? ");

            delete.setInt(1, empleado.getNum_empleado());

            //Ejecución del delete
            delete.executeUpdate();


        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }


    public static boolean esCamarero(Integer numEmpleado){


        return false;
    }
}
