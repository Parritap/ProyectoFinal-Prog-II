package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.ClienteNoEncontradoException;
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
    //      CREATE --- READ --- UPDATE --- DELETE

    /**
     * Método que crea un cliente. Nombre e email no han de ser ni nulos ni vacíos. El email ha de ser valido.
     *
     * @param nombre No puede ser ni nulo ni vacío.
     * @param email  No puede ser ni nulo ni vacío. También ha de ser un email valido, y NO PUEDE HABER OTRO CLIENTE CON UNO IGUAL dentro de la empresa.
     * @return Mensaje que informa sobre el resultado del método: si se ha creado o no el cliente.
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

        return "La cuenta con email " + email + " ha sido creada";
    }


    /**
     * Método que busca a un cliente en listaClientes dado un email.
     *
     * @param email Email a buscar dentro de listaClientes.
     * @return Null de no encontrar ningún cliente.
     * @throws EmailNoValidoException Si el email pasado no es valido.
     */
    public Cliente obtenerCliente(String email) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(email))
            throw new EmailNoValidoException("El email pasado en el argumento no es un email valido");

        for (Cliente c : listaClientes) {

            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }


    /**
     * Método que actualiza un cliente dado su email, el cual se usa para buscarlo dentro de listaClientes.
     *
     * @param email Usado para buscar al cliente dentro de la empresa. El email es inmmutable, por lo que no se puede cambiar una vez creaa la cuenta.
     * @throws Exception De haber algún parámetro vacío o nulo, si el email pasado no es válido, o si el cliente no existe dentro de la empresa.
     */
    public void actualizarCliente(String email, String nuevoNombre, String nuevaDirecc, String nuevaFechaNacimiento,
                                  String nuevaCiudad, String nuevoDepartamento) throws Exception {

        if (email == null || nuevoNombre == null || nuevaDirecc == null || nuevaFechaNacimiento == null ||
                nuevaCiudad == null || nuevoDepartamento == null)
            throw new NullPointerException("Algún parámetro pasado es nulo");

        if (email.equals("") || nuevoNombre.equals("") || nuevaDirecc.equals("") || nuevaFechaNacimiento.equals("") ||
                nuevaCiudad.equals("") || nuevoDepartamento.equals(""))
            throw new ParametroVacioException("Algún parámetro pasado está vacío");

        if (!MyUtils.esEmailValido(email))
            throw new EmailNoValidoException("El email pasado en el argumento no es valido");

        Cliente cliente = obtenerCliente(email);

        if (cliente == null)
            throw new ClienteNoEncontradoException("El cliente con email " + email + " no existe dentro de la empresa");

        for (Cliente c : listaClientes) {
            if (c.equals(cliente)) {

                c.setNombre(nuevoNombre);
                c.setDireccion(nuevaDirecc);
                c.setFechaNacimiento(nuevaFechaNacimiento);
                c.setCiudad(nuevaCiudad);
                c.setDepartamento(nuevoDepartamento);
                //Falta únicamente actualizar la listaDatosEnvio, pero eso es responsabilidad del cliente.
            }
        }
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


    /**
     * Método que verifica si un cliente existe dado su email
     * @return True si el cliente existe dentro de listaClientes, false de lo contario.
     * @throws NullPointerException Si el email pasado es nulo.
     */
    public boolean existeCliente(String email) throws NullPointerException {

        if (MyUtils.esEmailValido(email)) {  //Si verificamos que el email es válido, no gastamos poder de la CPU innecesariamente.
            for (Cliente c : listaClientes) {
                if (c.getEmail().equals(email))
                    return true;
            }
        }
        return false;
    }
}
