package Modelos;

import java.util.Objects;

public class Mesa {
    private int id;
    private int Num_Mesa;
    private int Num_Comensales;
    private boolean ocupada;

    public Mesa(int id, int num_Mesa, int num_Comensales, boolean ocupada) {
        this.id = id;
        Num_Mesa = num_Mesa;
        Num_Comensales = num_Comensales;
        this.ocupada = ocupada;
    }

    public Mesa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_Mesa() {
        return Num_Mesa;
    }

    public void setNum_Mesa(int num_Mesa) {
        Num_Mesa = num_Mesa;
    }

    public int getNum_Comensales() {
        return Num_Comensales;
    }

    public void setNum_Comensales(int num_Comensales) {
        Num_Comensales = num_Comensales;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return id == mesa.id && Num_Mesa == mesa.Num_Mesa && Num_Comensales == mesa.Num_Comensales && ocupada == mesa.ocupada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Num_Mesa, Num_Comensales, ocupada);
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", Num_Mesa=" + Num_Mesa +
                ", Num_Comensales=" + Num_Comensales +
                ", ocupada=" + ocupada +
                '}';
    }
}
