package Modelos;

import java.util.Objects;

public class LineaComanda {
    private int id;
    private int idEmpleado;
    private int idFactura;
    private int idProducto;
    private int cantidadProducto;
    private int cantidadCocinada;

    public LineaComanda(int id, int idEmpleado, int idFactura, int idProducto, int cantidadProducto, int cantidadCocinada) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.cantidadCocinada = cantidadCocinada;
    }

    public LineaComanda(){}

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
        return id == that.id && idEmpleado == that.idEmpleado && idFactura == that.idFactura && idProducto == that.idProducto && cantidadProducto == that.cantidadProducto && cantidadCocinada == that.cantidadCocinada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmpleado, idFactura, idProducto, cantidadProducto, cantidadCocinada);
    }

    @Override
    public String toString() {
        return "LineaComanda{" +
                "id=" + id +
                ", idEmpleado=" + idEmpleado +
                ", idFactura=" + idFactura +
                ", idProducto=" + idProducto +
                ", cantidadProducto=" + cantidadProducto +
                ", cantidadCocinada=" + cantidadCocinada +
                '}';
    }
}
