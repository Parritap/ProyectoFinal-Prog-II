package co.uniquindio.proyectoFinal.model;

import java.util.Objects;

public class DatosEnvio {

    private String codigo ;
    private String ciudad;
    private String domicilio;
    private String destinatario;
    private String telefono;

    private Cliente cliente;


    //Constructures-----------------------------------------------------------------------------------------------------------
    public DatosEnvio(String codigo, String ciudad, String domicilio, String destinatario, String telefono, Cliente cliente) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.domicilio = domicilio;
        this.destinatario = destinatario;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    public DatosEnvio(String ciudad, String domicilio, String destinatario, String telefono, Cliente cliente) {
        this.ciudad = ciudad;
        this.domicilio = domicilio;
        this.destinatario = destinatario;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    //Constructor Vacio
    public DatosEnvio() {
    }



    //Getters & Setters----------------------------------------------------------------------------------------------------------
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    //Equals and HashCode--------------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosEnvio that = (DatosEnvio) o;
        return Objects.equals(ciudad, that.ciudad) && Objects.equals(domicilio, that.domicilio) && Objects.equals(destinatario, that.destinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, ciudad, domicilio, destinatario, telefono, cliente);
    }

    @Override
    public String toString() {
        return ciudad + " - " + domicilio;
    }
}
