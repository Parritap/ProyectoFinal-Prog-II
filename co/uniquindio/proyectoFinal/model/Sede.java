package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
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
     *
     * @param id Identificación de la sede dentro de la empresa
     */
    public Sede(String nombre, String id, Empresa empresa, ArrayList<Producto> listaProductos, Ciudad ciudad, ArrayList<Factura> listaFacturas) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = listaProductos;
        this.ciudad = ciudad;
        this.listaFacturas = listaFacturas;
    }

    /**
     * Constructor sin administrador ni lista de Facturas.
     *
     * @param id Identificación de la sede dentro de la empresa
     */
    public Sede(String nombre, String id, Empresa empresa, ArrayList<Producto> listaProductos, Ciudad ciudad) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = listaProductos;
        this.ciudad = ciudad;
        this.listaFacturas = new ArrayList<>();
    }

    /**
     * Constructor sin administrador, id est (Admin = null).
     * Aunque las listas no aparezcan como parámetros, el presente constructor las inicializa para que estas no sean nulas.
     * Por lo tanto, al usar este constructor, hay Null Safety.
     *
     * @param id Identificación de la sede dentro de la empresa
     */
    public Sede(String nombre, String id, Empresa empresa, Ciudad ciudad, Administrador admin) {
        this.nombre = nombre;
        this.id = id;
        this.empresa = empresa;
        this.listaProductos = new ArrayList<>();
        this.ciudad = ciudad;
        this.listaFacturas = new ArrayList<>();
        this.administrador = admin;
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


    //MÉTODOS---------------------------------------------------------------------------

    /**
     * Obtiene la instancia del producto que hay en sede que es identica a la que hay en empresa,
     * esto es, devuelve el clon del producto que hay en Sede con base a un producto dado por parametro.
     * @param producto Producto a buscar en sede.
     * @return
     */
    public Producto obtenerProducto (Producto producto){

        for (Producto p: listaProductos) {

            if(p.equals(producto))
                return p;
        }
        return null;
    }

    /**
     * Métod que retorna un producto de la sede según su ID
     * @param prodID Identificador del producto
     * @return Null de no encontrar ningún producto con el ID indicado.
     * @throws StringNuloOrVacioException Si el ID pasado es nulo o está vacío.
     */
    public Producto obtenerProductoByID(String prodID) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(prodID);

        for (Producto p : listaProductos) {

            if (p != null && p.getId() != null && p.getId().equals(prodID)) {
                return p;
            }
        }
        return null;
    }

    public Producto obtenerProductoByNombre(String nombre) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(nombre);

        for (Producto p : listaProductos) {

            if (p != null && p.getNombre() != null && p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

	@Override
	public String toString() {
		return id + " - " + nombre;
	}
    
}
