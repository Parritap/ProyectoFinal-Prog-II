package co.uniquindio.proyectoFinal.model;

import java.util.ArrayList;
import java.util.Objects;

public class Reporte {

    private Empresa empresa;
    private ArrayList<Factura> listaFacturas = new ArrayList<>(); // De esta manera, ambas comparte la misma instancia.

    public Reporte(Empresa empresa, ArrayList<Factura> listaFacturas) {
        this.empresa = empresa;
        this.listaFacturas = listaFacturas;
    }

    public Reporte() {
    }

    //Getters and Setters-------------------------------------------------------------------------------------------------------


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    //Equals, HashCode and toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reporte reporte = (Reporte) o;
        return Objects.equals(empresa, reporte.empresa) && Objects.equals(listaFacturas, reporte.listaFacturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, listaFacturas);
    }


    @Override
    public String toString() {
        return "Reporte{" +
                "empresa=" + empresa +
                ", listaFacturas=" + listaFacturas +
                '}';
    }

}
