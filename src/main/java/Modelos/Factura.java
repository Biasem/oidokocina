package Modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Factura {
    private int id;
    private int id_mesa;
    private LocalDate fecha;
    private Double total;

    public Factura(int id, int id_mesa, LocalDate fecha, Double total) {
        this.id = id;
        this.id_mesa = id_mesa;
        this.fecha = fecha;
        this.total = total;
    }

    public Factura(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return id == factura.id && id_mesa == factura.id_mesa && Objects.equals(fecha, factura.fecha) && Objects.equals(total, factura.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_mesa, fecha, total);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", id_mesa=" + id_mesa +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
