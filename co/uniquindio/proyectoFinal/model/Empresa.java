package co.uniquindio.proyectoFinal.model;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String id;

    private Reporte reporte;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Sede> listaSede;
    private ArrayList <Administrador> listaAdministradores;

    //Constructores----------------------------------------------------------------------------------------------------------------------------

    public Empresa(String nombre, String id, Reporte reporte, ArrayList<Factura> listaFacturas, ArrayList<Producto> listaProductos, ArrayList<Cliente> listaClientes, ArrayList<Sede> listaSede, ArrayList<Administrador> listaAdministradores) {
        this.nombre = nombre;
        this.id = id;
        this.reporte = reporte;
        this.listaFacturas = listaFacturas;
        this.listaProductos = listaProductos;
        this.listaClientes = listaClientes;
        this.listaSede = listaSede;
        this.listaAdministradores = listaAdministradores;
    }

    public Empresa(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    //Constructor vacío.
    public Empresa() {
    }

    //Getters & Setters----------------------------------------------------------------------------------

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

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Sede> getListaSede() {
        return listaSede;
    }

    public void setListaSede(ArrayList<Sede> listaSede) {
        this.listaSede = listaSede;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    //toString

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", reporte=" + reporte +
                ", listaFacturas=" + listaFacturas +
                ", listaProductos=" + listaProductos +
                ", listaClientes=" + listaClientes +
                ", listaSede=" + listaSede +
                ", listaAdministradores=" + listaAdministradores +
                '}';
    }
}
