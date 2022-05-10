package Modelos;

import java.util.Objects;

public class LineaComanda {
    private int id;
    private int idEmpleado;
    private int idFactura;
    private int idProducto;
    private int id_mesa;
    private int cantidadProducto;
    private int cantidadCocinada;

    public LineaComanda(){}

    public LineaComanda(int id, int idEmpleado, int idFactura, int idProducto, int id_mesa, int cantidadProducto, int cantidadCocinada) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.id_mesa = id_mesa;
        this.cantidadProducto = cantidadProducto;
        this.cantidadCocinada = cantidadCocinada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadCocinada() {
        return cantidadCocinada;
    }

    public void setCantidadCocinada(int cantidadCocinada) {
        this.cantidadCocinada = cantidadCocinada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaComanda that = (LineaComanda) o;
        return id == that.id && idEmpleado == that.idEmpleado && idFactura == that.idFactura && idProducto == that.idProducto && id_mesa == that.id_mesa && cantidadProducto == that.cantidadProducto && cantidadCocinada == that.cantidadCocinada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmpleado, idFactura, idProducto, id_mesa, cantidadProducto, cantidadCocinada);
    }

    @Override
    public String toString() {
        return "LineaComanda{" +
                "id=" + id +
                ", idEmpleado=" + idEmpleado +
                ", idFactura=" + idFactura +
                ", idProducto=" + idProducto +
                ", id_mesa=" + id_mesa +
                ", cantidadProducto=" + cantidadProducto +
                ", cantidadCocinada=" + cantidadCocinada +
                '}';
    }
}
