package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.exceptions.EmailYaRegistradoException;
import co.uniquindio.proyectoFinal.exceptions.ParametroVacioException;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String id;

    private Reporte reporte;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Sede> listaSede;
    private ArrayList<Administrador> listaAdministradores;

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

    // CRUD------------------------------------------------------------------------------------------------------------------

    /**
     * Método que crea un cliente. Nombre e email no han de ser ni nulos ni vacíos. El email ha de ser valido.
     * @param nombre No puede ser ni nulo ni vacío.
     * @param email No puede ser ni nulo ni vacío. Tambien ha de ser un email valido.
     * @return  Mensaje que informa sobre el resultado del métodl, si se ha creado o no el método
     * @throws Exception Hay multiples excepciones en este método.
     */
    public String crearCliente(String nombre, String direccion, String email,
                               String fechaNacimiento, String ciudad, String departamento) throws Exception {

        if (nombre == null || nombre.equals(""))
            throw new NullPointerException("El nombre del cliente es nulo o vacío");

        if (email == null || email.equals(""))
            throw new NullPointerException("El email del cliente es nulo o vacío");

        if (existeCliente(email)) //Este método ya verifica si el email es valido mediante MyUtils.esEmailValido()
            throw new EmailYaRegistradoException("Este email ya se encuentra registrado dentro de la empresa");

        if (direccion == null || fechaNacimiento == null || ciudad == null || departamento == null)
            throw new NullPointerException("Hay algún campo nulo");

        if (direccion.equals("") || fechaNacimiento.equals("") || ciudad.equals("") || departamento.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Cliente cliente = new Cliente(nombre, direccion, email, fechaNacimiento, ciudad, departamento);

        this.listaClientes.add(cliente);

        return "La cuenta con email" + email + " ha sido creada";
    }


    // Métodos --------------------------------------------------------------------------------------------------------------

    /**
     * Método que evalúa si un cliente ya existe dentro de la lista de clientes evaluando el objeto Cliente.
     *
     * @param cliente Cliente a buscar dentro de listaClientes.
     * @return True si el cliente ya existe, false de lo contrario.
     */
    public boolean existeCliente(Cliente cliente) throws Exception {

        if (cliente == null)
            throw new NullPointerException("El cliente es nulo");

        if (!MyUtils.esEmailValido(cliente.getEmail()))
            throw new EmailNoValidoException("El email pasado no es valido");

        for (Cliente c : getListaClientes()) {

            if (cliente.equals(c))
                return true;
        }
        return true;
    }

    public boolean existeCliente(String email) throws NullPointerException {
        if (email == null)
            throw new NullPointerException("El email pasado es nulo");

        if (MyUtils.esEmailValido(email)) {  //Si verificamos que el email es válido, no gastamos poder de la CPU innecesariamente.
            for (Cliente c : listaClientes) {
                if (c.getEmail().equals(email))
                    return true;
            }
        }
        return false;
    }
}
