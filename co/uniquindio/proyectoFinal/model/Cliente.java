package co.uniquindio.proyectoFinal.model;


import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    private String nombre;
    private String direccion;
    private String email;
    private String fechaNacimiento;
    private String ciudad;
    private String departamento;

    private ArrayList<DatosEnvio> listaDatosEnvio;
    private CarritoCompras carritoCompras;


    //Constructores----------------------------------------------------------------------------------------------------------------------------


    public Cliente(String nombre, String direccion, String email, String fechaNacimiento, String ciudad, String departamento, ArrayList<DatosEnvio> listaDatosEnvio, CarritoCompras carritoCompras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.listaDatosEnvio = listaDatosEnvio;
        this.carritoCompras = carritoCompras;
    }

    //constructor vacío.
    public Cliente() {
    }


    //Constructor sin datos de envio ni carrito de compras
    public Cliente(String nombre, String direccion, String email, String fechaNacimiento, String ciudad, String departamento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    //Getters & Setters ------------------------------------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<DatosEnvio> getListaDatosEnvio() {
        return listaDatosEnvio;
    }

    public void setListaDatosEnvio(ArrayList<DatosEnvio> listaDatosEnvio) {
        this.listaDatosEnvio = listaDatosEnvio;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

 //equals & HashCode -------------------------------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(fechaNacimiento, cliente.fechaNacimiento) && Objects.equals(carritoCompras, cliente.carritoCompras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, direccion, email, fechaNacimiento, ciudad, departamento, listaDatosEnvio, carritoCompras);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", departamento='" + departamento + '\'' +
                ", listaDatosEnvio=" + listaDatosEnvio +
                ", carritoCompras=" + carritoCompras +
                '}';
    }
}
