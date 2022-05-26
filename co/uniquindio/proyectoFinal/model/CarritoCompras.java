package co.uniquindio.proyectoFinal.model;

import java.util.ArrayList;
import java.util.Objects;

public class CarritoCompras {

    private ArrayList<Producto> listaProductos;
    private ArrayList<DetalleFactura> listaDetalles;

    //Constructores----------------------------------------------------------------------------------------------------------------------------
    public CarritoCompras(ArrayList<Producto> listaProductos, ArrayList<DetalleFactura> listaDetalles) {
        this.listaProductos = listaProductos;
        this.listaDetalles = listaDetalles;
    }

    //Constructor vacío
    public CarritoCompras() {
    }

    //Getters & Setters------------------------------------------------------------------------------------------------------------------------


    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }


    //Equals and HashCode and toString-------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoCompras that = (CarritoCompras) o;
        return Objects.equals(listaProductos, that.listaProductos) && Objects.equals(listaDetalles, that.listaDetalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaProductos, listaDetalles);
    }


    //ToString

    @Override
    public String toString() {
        return "CarritoCompras{" +
                "listaProductos=" + listaProductos +
                ", listaDetalles=" + listaDetalles +
                '}';
    }


}
