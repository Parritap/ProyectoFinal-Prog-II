package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;

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


    //CRUD DetalleFactura------------------------------------------------------------------------------------------------------------------------

    public void crearDetalle(Producto prod, int cantidad) throws NegativeNumberException {

        MyUtils.validarSiPositivo(cantidad);

        if (prod == null)
            throw new NullPointerException("El producto pasado en el argumento es nulo");

        DetalleFactura d = new DetalleFactura(prod, cantidad);

        listaDetalles.add(d);
    }

    public void actualizarDetalle(DetalleFactura detalle, Producto prod, int cantidad) throws NegativeNumberException {

        MyUtils.validarSiPositivo(cantidad);

        if (prod == null)
            throw new NullPointerException("El producto pasado en el argumento es nulo");


        for (DetalleFactura d : listaDetalles) {

            if (d.equals(detalle))

                d.setCantidad(cantidad);
            d.setProductoFacturado(prod);
        }
    }

    public void eliminarDetalle(DetalleFactura detalle) {

        for (DetalleFactura d : listaDetalles) {

            if (d.equals(detalle))
                listaDetalles.remove(d);
        }
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


