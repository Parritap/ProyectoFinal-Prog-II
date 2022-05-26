package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.model.enums.MetodoPago;

import java.util.Objects;

public class InformacionPago {

    private String numeroTarjeta;
    private String titularTarjeta;
    private String codigoSeguridadTarjeta;
    private String fechaVencimientoTarjeta;

    private MetodoPago metodoPago;


    //Constructores----------------------------------------------------------------------------------------------------


    public InformacionPago(String numeroTarjeta, String titularTarjeta, String codigoSeguridadTarjeta, String fechaVencimientoTarjeta, MetodoPago metodoPago) {
        this.numeroTarjeta = numeroTarjeta;
        this.titularTarjeta = titularTarjeta;
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.metodoPago = metodoPago;
    }

    //Constructor vacío.
    public InformacionPago() {
    }

    //Getters & Setters-----------------------------------------------------------------------------------------------

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitularTarjeta() {
        return titularTarjeta;
    }

    public void setTitularTarjeta(String titularTarjeta) {
        this.titularTarjeta = titularTarjeta;
    }

    public String getCodigoSeguridadTarjeta() {
        return codigoSeguridadTarjeta;
    }

    public void setCodigoSeguridadTarjeta(String codigoSeguridadTarjeta) {
        this.codigoSeguridadTarjeta = codigoSeguridadTarjeta;
    }

    public String getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    //Equals HashCode and toString-----------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacionPago that = (InformacionPago) o;
        return Objects.equals(numeroTarjeta, that.numeroTarjeta) && Objects.equals(titularTarjeta, that.titularTarjeta) && Objects.equals(codigoSeguridadTarjeta, that.codigoSeguridadTarjeta) && Objects.equals(fechaVencimientoTarjeta, that.fechaVencimientoTarjeta) && metodoPago == that.metodoPago;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroTarjeta, titularTarjeta, codigoSeguridadTarjeta, fechaVencimientoTarjeta, metodoPago);
    }

    @Override
    public String toString() {
        return "InformacionPago{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", titularTarjeta='" + titularTarjeta + '\'' +
                ", codigoSeguridadTarjeta='" + codigoSeguridadTarjeta + '\'' +
                ", fechaVencimientoTarjeta='" + fechaVencimientoTarjeta + '\'' +
                ", metodoPago=" + metodoPago +
                '}';
    }
}
