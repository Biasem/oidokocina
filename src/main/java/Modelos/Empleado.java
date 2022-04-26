package Modelos;

import java.util.Objects;

public class Empleado {

    private int id;
    private String nombre;
    private String apellidos;
    private Integer num_empleado;
    private Rol rol;

    public Empleado(int id, String nombre, String apellidos, Integer num_empleado, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.num_empleado = num_empleado;
        this.rol = rol;
    }

    public Empleado(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(Integer num_empleado) {
        this.num_empleado = num_empleado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", num_empleado=" + num_empleado +
                ", rol=" + rol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && num_empleado == empleado.num_empleado && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellidos, empleado.apellidos) && rol == empleado.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, num_empleado, rol);
    }
}
