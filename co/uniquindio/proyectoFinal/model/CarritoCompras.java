package co.uniquindio.proyectoFinal.model;

import java.util.ArrayList;
import java.util.Objects;

public class CarritoCompras {

    private ArrayList<DetalleFactura> listaDetalles;

    //Constructores----------------------------------------------------------------------------------------------------------------------------
    public CarritoCompras(ArrayList<DetalleFactura> listaDetalles) {

        this.listaDetalles = listaDetalles;
    }

    //Constructor vacío
    public CarritoCompras() {
    }

    //Getters & Setters------------------------------------------------------------------------------------------------------------------------


    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }


    //Equals and HashCode and toString-------------------------------------------------------------------------------------------------------------;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoCompras that = (CarritoCompras) o;
        return Objects.equals(listaDetalles, that.listaDetalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaDetalles);
    }

    @Override
    public String toString() {
        return "CarritoCompras{" +
                "listaDetalles=" + listaDetalles +
                '}';
    }
}


