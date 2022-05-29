package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.model.enums.Ciudad;

import java.util.ArrayList;
import java.util.Objects;

public class Sede {

    private String nombre;
    private String id;

    private Empresa empresa;
    private ArrayList<Producto> listaProductos;
    private Ciudad ciudad; // <ENUM>
    private Administrador administrador; //UNA SEDE NO POSEE ADMINISTRADOR SI SU ATRIBUTO @ADMINISTRADOR ES NULO.
    private ArrayList<Factura> listaFacturas;

    //Constructor---------------------------------------------------------------------------------------------------------


    public Sede(String nombre, String id, Empresa empresa, ArrayList<Producto> listaProductos, Ciudad ciudad, Administrador administrador, ArrayList<Factura> listaFacturas) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = listaProductos;
        this.ciudad = ciudad;
        this.administrador = administrador;
        this.listaFacturas = listaFacturas;
    }

    /**
     * Constructor sin administrador.
     * @param id Identificación de la sede dentro de la empresa
     */
    public Sede(String nombre, String id, Empresa empresa, ArrayList<Producto> listaProductos, Ciudad ciudad,  ArrayList<Factura> listaFacturas) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = listaProductos;
        this.ciudad = ciudad;
        this.listaFacturas = listaFacturas;
    }

    /**
     * Constructor sin administrador, id est (Admin = null).
     * Aunque las listas no aparezcan como parámetros, el presente constructor las inicializa para que estas no sean nulas.
     * Por lo tanto, al usar este constructor, hay Null Safety.
     * @param id Identificación de la sede dentro de la empresa
     */
    public Sede(String nombre, String id, Empresa empresa, Ciudad ciudad) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = new ArrayList<>();
        this.ciudad = ciudad;
        this.listaFacturas = new ArrayList<>();
    }


    public Sede() {
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------------


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    //Equals HashCode and toStrign--------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sede sede = (Sede) o;
        return Objects.equals(id, sede.id) && Objects.equals(empresa, sede.empresa) && ciudad == sede.ciudad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empresa, ciudad);
    }


}
