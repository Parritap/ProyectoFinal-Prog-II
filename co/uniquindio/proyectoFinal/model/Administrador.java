package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;

import java.util.Objects;

public class Administrador {

    private String id;
    private String nombre;
    private String direccion;
    private String email;
    private String fechaNacimiento;
    private String estudios;

    private TipoDocumento tipoDocumento;
    private Sede sede;

    //Constructores----------------------------------------------------------------------------------------------------------------------------

    public Administrador(String id, String nombre, String direccion, String email, String fechaNacimiento, String estudios, TipoDocumento tipoDocumento, Sede sede) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estudios = estudios;
        this.tipoDocumento = tipoDocumento;
        this.sede = sede;
    }

    //Constructor sin sede
    public Administrador(String id, String nombre, String direccion, String email, String fechaNacimiento, String estudios, TipoDocumento tipoDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estudios = estudios;
        this.tipoDocumento = tipoDocumento;
    }

    //Constructor vacío

    public Administrador() {
    }

    //Getters & Setters------------------------------------------------------------------------------------------------------------------------


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

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    //Equals & HashCode--------------------------------------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(id, that.id) && Objects.equals(sede, that.sede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sede);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", estudios='" + estudios + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", sede=" + sede +
                '}';
    }
}
