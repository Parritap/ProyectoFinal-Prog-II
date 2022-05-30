package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.*;
import co.uniquindio.proyectoFinal.model.enums.Ciudad;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String id;

    private Reporte reporte;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Sede> listaSedes;
    private ArrayList<Administrador> listaAdministradores;

    //Constructores-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Empresa(String nombre, String id, Reporte reporte, ArrayList<Factura> listaFacturas, ArrayList<Producto> listaProductos, ArrayList<Cliente> listaClientes, ArrayList<Sede> listaSedes, ArrayList<Administrador> listaAdministradores) {
        this.nombre = nombre;
        this.id = id;
        this.reporte = reporte;
        this.listaFacturas = listaFacturas;
        this.listaProductos = listaProductos;
        this.listaClientes = listaClientes;
        this.listaSedes = listaSedes;
        this.listaAdministradores = listaAdministradores;
    }


    /**
     * Constructor sin reporte ni ArrayLists como parametros; aún sin tales, el constructor no deja ningún
     * atributo nulo, esto es, instancia todas las listas y el reporte.
     *
     * @param nombre Nombre de la empresa.
     * @param id     RUT de la empresa.
     */
    public Empresa(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.reporte = new Reporte();
        this.listaFacturas = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaSedes = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
    }

    //Constructor vacío.
    public Empresa() {
    }

    //Getters & Setters-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

    public ArrayList<Sede> getListaSedes() {
        return listaSedes;
    }

    public void setListaSedes(ArrayList<Sede> listaSedes) {
        this.listaSedes = listaSedes;
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
                ", listaSede=" + listaSedes +
                ", listaAdministradores=" + listaAdministradores +
                '}';
    }

    // CRUD--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //      CREATE --- READ --- UPDATE --- DELETE

    // CRUD Cliente ----------------------------------------------------------------------------------------------------------------------------------

    /**
     * Método que crea un cliente. Nombre e email no han de ser ni nulos ni vacíos. El email ha de ser valido.
     *
     * @param nombre No puede ser ni nulo ni vacío.
     * @param email  No puede ser ni nulo ni vacío. También ha de ser un email valido, y NO PUEDE HABER OTRO CLIENTE CON UNO IGUAL dentro de la empresa.
     * @return Mensaje que informa sobre el resultado del método: si se ha creado o no el cliente.
     * @throws Exception Hay multiples excepciones en este método.
     */
    public String crearCliente(String nombre, String direccion, String documento, String email,
                               String fechaNacimiento, String ciudad, String departamento) throws Exception {

        if (email == null || email.equals(""))
            throw new StringNuloOrVacioException("El email del cliente es nulo o vacío");

        if (existeCliente(email)) //Este método ya verifica si el email es valido mediante MyUtils.esEmailValido()
            throw new EmailYaRegistradoException("Este email ya se encuentra registrado dentro de la empresa");

        if (nombre == null || direccion == null || documento == null || fechaNacimiento == null || ciudad == null || departamento == null)
            throw new NullPointerException("Hay algún campo nulo");

        if (nombre.equals("") || direccion.equals("") || documento.equals("") || fechaNacimiento.equals("") || ciudad.equals("") || departamento.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Cliente cliente = new Cliente(nombre, direccion, documento, email, fechaNacimiento, ciudad, departamento);

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
     * NOTA: El email es el único atributo que no puede ser actualizado. Una vez creada la cuenta, el email es immutable.
     *
     * @param email Usado para buscar al cliente dentro de la empresa. El email es immutable, por lo que no se puede cambiar una vez creaa la cuenta.
     * @return String informando que el cliente ha sido actualizado.
     * @throws Exception De haber algún parámetro vacío o nulo, si el email pasado no es válido, o si el cliente no existe dentro de la empresa.
     */
    public String actualizarCliente(String email, String nuevoNombre, String nuevaDirecc, String nuevoDocumento, String nuevaFechaNacimiento,
                                    String nuevaCiudad, String nuevoDepartamento) throws Exception {

        if (email == null || nuevoNombre == null || nuevaDirecc == null || nuevoDocumento == null || nuevaFechaNacimiento == null ||
                nuevaCiudad == null || nuevoDepartamento == null)
            return ("Algún parámetro pasado es nulo, no se pudo realizar la actualización");

        if (email.equals("") || nuevoNombre.equals("") || nuevaDirecc.equals("") || nuevoDocumento.equals("") || nuevaFechaNacimiento.equals("") ||
                nuevaCiudad.equals("") || nuevoDepartamento.equals(""))
            return ("Algún parámetro pasado está vacío, no se pudo realizar la actualización");

        if (!MyUtils.esEmailValido(email))
            return ("El email pasado en el argumento no es valido, no se pudo realizar la actualización");

        Cliente cliente = obtenerCliente(email); //De no encontrar un cliente con el email pasado, el método retorna null.

        if (cliente == null)
            return ("El cliente con email " + email + " no existe dentro de la empresa, ");

        for (Cliente c : listaClientes) {
            if (c.equals(cliente)) {

                c.setNombre(nuevoNombre);
                c.setDireccion(nuevaDirecc);
                c.setDocumento(nuevoDocumento);
                c.setFechaNacimiento(nuevaFechaNacimiento);
                c.setCiudad(nuevaCiudad);
                c.setDepartamento(nuevoDepartamento);
                //Falta únicamente actualizar la listaDatosEnvio, pero eso es responsabilidad del cliente.
            }
        }
        return "Cliente con email " + email + " ha sido actualizado";
    }

    /**
     * Método que elimina un cliente dado su email.
     *
     * @param email Atributo de Cliente a buscar dentro de listaClientes
     * @return True de encontrar y haber eliminado el cliente con el email pasado en el argumento, false de lo contrario.
     * @throws EmailNoValidoException Si el email pasado no es valido.
     */
    public boolean eliminarCliente(String email) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(email))
            throw new EmailNoValidoException("" + email + " no es un email valido");

        for (Cliente c : listaClientes) {
            if (c.getEmail().equals(email)) {
                listaClientes.remove(c);
                return true;
            }
        }
        return false;
    }

    //CRUD Administrador -------------------------------------------------------------------------------------------------

    public boolean crearAdministrador(String id, String nombre, String documento,
                                      String direccion, String email, String fechaNacimiento,
                                      String estudios, TipoDocumento tipoDoc, Sede sede) throws StringNuloOrVacioException, EmailNoValidoException, EmailYaRegistradoException {

        MyUtils.validarSiNuloOrVacio(id, nombre, documento, direccion, email, fechaNacimiento, estudios); //Método encargado de verificar que no hayan nulos ni vacíos.

        if (tipoDoc == null)
            throw new NullPointerException("EL tipo de documento es nulo");

        if (sede == null)
            throw new NullPointerException("La sede indicada es nula");

        if (!MyUtils.esEmailValido(email))
            throw new EmailNoValidoException("" + email + " no es un email valido");

        if (existeAdmin(email))
            return false;

        Administrador admin = new Administrador(id, nombre, documento, direccion, email, fechaNacimiento, estudios, tipoDoc);

        this.listaAdministradores.add(admin);

        return true;

    }

    /**
     * Método que retorna un administrador según su email
     * @param adminEmail Email del admin a buscar dentro de listaAdministradores;
     * @return Null de no encontrar un administrador con tal email.
     * @throws EmailNoValidoException Si el email pasad no es un email válido.
     */
    public Administrador obtenerAdminByEmail(String adminEmail) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(adminEmail))
            throw  new EmailNoValidoException("" + adminEmail+ " no es un email válido");

        for (Administrador a: listaAdministradores) {

            if (a!=null && a.getEmail()!=null && a.getEmail().equals(adminEmail))
                return a;
        }
        return null;
    }

    /**
     * Método que retorna un admninistrador según su id de la empresa.
     * @param id Identificación dentro del contexto de empresa (no documento).
     * @return Null de no encontrar ningún administrador con la identificación mostrada.
     * @throws StringNuloOrVacioException Si el id es nulo o es vacío.
     */
    public Administrador obtenerAdminByID(String id) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(id); //Revisar comentarios del método.

        for (Administrador a : listaAdministradores) {

            if(a!=null && a.getId()!=null && a.getId().equals(id))
                return a;
        }
        return null;
    }

    public boolean actualizarAdmin (String id, String nuevoNombre, String nuevoDoc, String nuevaDirecc,String nuevaFechaNacimiento,String nuevosEstudios,TipoDocumento nuevoTipoDoc, String nuevaSedeID) throws StringNuloOrVacioException {

        //Los unicos atributos immutables de admin son el email y su id.

        MyUtils.validarSiNuloOrVacio(id);

        Administrador aux = obtenerAdminByID(id);

        for (Administrador admin : listaAdministradores) {
            if(admin.equals(aux)){

                if(!MyUtils.esNuloOrVacio(nuevoNombre))
                    admin.setNombre(nuevoNombre);


                if(!MyUtils.esNuloOrVacio(nuevoDoc))
                    admin.setNombre(nuevoDoc);

                if(!MyUtils.esNuloOrVacio(nuevaDirecc))
                    admin.setNombre(nuevaDirecc);

                if(!MyUtils.esNuloOrVacio(nuevaFechaNacimiento))
                    admin.setNombre(nuevaFechaNacimiento);

                if(!MyUtils.esNuloOrVacio(nuevosEstudios))
                    admin.setNombre(nuevosEstudios);

                if(nuevoTipoDoc!= null)
                    admin.setTipoDocumento(nuevoTipoDoc);

                if(!MyUtils.esNuloOrVacio(nuevaSedeID)){
                    admin.setSede(obtenerSede(nuevaSedeID));
                }

                return true;
            }
        }
        return false;
    }


    //CRUD SEDE------------------------------------------------------------------------------------------------------------



    // Métodos ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
     *
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

    /**
     * Método que verifica si existe un admin dentro de la empresa con el mismo email al pasado en
     * el argumento.
     *
     * @param email Email del administrador, el cual se buscará dentro de listaAdministradores.
     * @return True de existir un admin en la empresa con el mismo email al pasado en el argumento.
     * @throws EmailNoValidoException Si el email pasado no es valido.
     */
    private boolean existeAdmin(String email) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(email))
            throw new EmailNoValidoException("El email " + email + " no es válido");

        for (Administrador a : listaAdministradores) {

            if (a != null && a.getEmail().equals(email))
                return true;
        }
        return false;
    }

    /**
     * Método que verifica si existe un administrador dentro de la empresa con un ID igual al pasado
     * en el argumento.
     *
     * @param adminID ID de administrador a buscar dentro de listaAdministradores.
     * @return True si existe un administrador en la empresa con el mismo ID pasado en el argumento.
     */
    private boolean existeAdminID(String adminID) {

        for (Administrador a : listaAdministradores) {
            if (a != null && a.getId().equals(adminID))
                return true;
        }
        return false;
    }

    /**
     * Método que verifica si el Objeto Sede pasado en el argumento posee un administrador, id est,
     * que su administrador sea nulo.
     *
     * @return True si el administrador de la sede pasada en el argumento es diferente de null.
     */
    private boolean sedeTieneAdmin(Sede sede) {
        return (sede != null && sede.getId() != null && sede.getAdministrador() != null);
    }

    /**
     * Método que busca una sede en listaSedes mediante su id, y verifica si tiene o no un Administrador.
     * NOTA: Este método no evalúa si la sede pasada existe o no dentro de la empresa, simplemente se verifica si existe alguna
     * sede con un id igual al pasado en el argumento.
     *
     * @param sedeId Identificador de la sede en el contexto de la empresa.
     * @return True si la sede en cuestión posee administrador, false de lo contario.
     */
    private boolean sedeTieneAdmin(String sedeId) {
        for (Sede s : listaSedes
        ) {
            if (s != null && s.getId() != null && s.getId().equals(sedeId)) {
                if (s.getAdministrador() != null)
                    return true;
            }
        }
        return false;
    }


}
