package Modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Factura {
    private int id;
    private LocalDate fecha;
    private Double total;
    private boolean pagado;

    public Factura(int id, int id_mesa, LocalDate fecha, Double total) {
        this.id = id;
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

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return id == factura.id && pagado == factura.pagado && Objects.equals(fecha, factura.fecha) && Objects.equals(total, factura.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, total, pagado);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                ", pagado=" + pagado +
                '}';
    }
}
