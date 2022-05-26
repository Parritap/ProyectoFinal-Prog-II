package co.uniquindio.proyectoFinal.model;

import java.util.Objects;

public class DetalleFactura {

    private Producto productoFacturado;
    private int cantidad;

    //constructores-------------------------------------------------------------------------------------------------------

    public DetalleFactura(Producto productoFacturado, int cantidad) {
        this.productoFacturado = productoFacturado;
        this.cantidad = cantidad;
    }

    //Constructor vacío
    public DetalleFactura() {
    }

    //Getters & Setters--------------------------------------------------------------------------------------------------


    public Producto getProductoFacturado() {
        return productoFacturado;
    }

    public void setProductoFacturado(Producto productoFacturado) {
        this.productoFacturado = productoFacturado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Equals & HashCode-----------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleFactura that = (DetalleFactura) o;
        return cantidad == that.cantidad && Objects.equals(productoFacturado, that.productoFacturado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoFacturado, cantidad);
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "productoFacturado=" + productoFacturado +
                ", cantidad=" + cantidad +
                '}';
    }
}
