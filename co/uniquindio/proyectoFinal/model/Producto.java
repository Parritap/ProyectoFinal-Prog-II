package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.scene.image.Image;
import java.util.Objects;

public class Producto {

    private String id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Image img;
    private int existencias;

    private CategoriaProducto categoria;
    private Empresa empresa;


    //Constructores----------------------------------------------------------------------------------------------------------

    public Producto(String id, String nombre, double precio, String descripcion, Image img, int existencias, CategoriaProducto categoria, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.img = img;
        this.existencias = existencias;
        this.categoria = categoria;
        this.empresa = empresa;
    }

    //Constructor vacío
    public Producto() {
    }

    //Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    //Equals, HashCode and toString-----------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, categoria);
    }


    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
