package Modelos;

import java.util.Objects;

public class LineaComanda {
    private int id;
    private int numEmpleado;
    private int idFactura;
    private int idProducto;
    private int num_mesa;
    private int cantidadProducto;
    private int cantidadCocinada;

    public LineaComanda(){}

    public LineaComanda(int id, int numEmpleado, int idFactura, int idProducto, int num_mesa, int cantidadProducto, int cantidadCocinada) {
        this.id = id;
        this.numEmpleado = numEmpleado;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.num_mesa = num_mesa;
        this.cantidadProducto = cantidadProducto;
        this.cantidadCocinada = cantidadCocinada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
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

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
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
        return id == that.id && numEmpleado == that.numEmpleado && idFactura == that.idFactura && idProducto == that.idProducto && num_mesa == that.num_mesa && cantidadProducto == that.cantidadProducto && cantidadCocinada == that.cantidadCocinada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numEmpleado, idFactura, idProducto, num_mesa, cantidadProducto, cantidadCocinada);
    }

    @Override
    public String toString() {
        return "LineaComanda{" +
                "id=" + id +
                ", numEmpleado=" + numEmpleado +
                ", idFactura=" + idFactura +
                ", idProducto=" + idProducto +
                ", num_mesa=" + num_mesa +
                ", cantidadProducto=" + cantidadProducto +
                ", cantidadCocinada=" + cantidadCocinada +
                '}';
    }
}
