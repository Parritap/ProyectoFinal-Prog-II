package co.uniquindio.proyectoFinal.model;

import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.*;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import co.uniquindio.proyectoFinal.model.enums.Ciudad;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;

import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Empresa {

    private String nombre;
    private String id;

    private Reporte reporte = new Reporte();
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
    public String crearCliente(String nombre, String direccion, String documento, TipoDocumento tipoDocumento, String email, String contrasenia, String fechaNacimiento, String ciudad, String departamento) throws Exception {

        if (email == null || email.equals(""))
            throw new StringNuloOrVacioException("El email del cliente es nulo o vacío");

        if (existeCliente(email)) //Este método ya verifica si el email es valido mediante MyUtils.esEmailValido()
            throw new EmailYaRegistradoException("Este email ya se encuentra registrado dentro de la empresa");

        MyUtils.validarSiNuloOrVacio(nombre, direccion, documento, fechaNacimiento, ciudad, departamento);


        if (nombre.equals("") || direccion.equals("") || documento.equals("") || fechaNacimiento.equals("") || ciudad.equals("") || departamento.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Cliente cliente = new Cliente(nombre, direccion, documento, tipoDocumento, email, contrasenia, fechaNacimiento, ciudad, departamento);

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

            if (c.getEmail().equals(email)) return c;
        }
        return null;
    }

    public Cliente obtenerClienteByDoc(String documento) {

        if (!documento.equals("")) {

            for (Cliente c : listaClientes) {
                if (c != null && c.getDocumento() != null && c.getDocumento().equals(documento))
                    return c;
            }
        }
        return null;
    }

    /**
     * Método que actualiza un cliente dado su email, el cual se usa para buscarlo dentro de listaClientes.
     * NOTA: El email es el único atributo que no puede ser actualizado. Una vez creada la cuenta, el email es immutable.
     * <p>
     * Es posible dejar todos los parámetros nulos o vacíos (excepto el email), pues en tal caso, el método no actualizará estos, evitando arrojar errores innecesarios.
     *
     * @param email Usado para buscar al cliente dentro de la empresa. El email es immutable, por lo que no se puede cambiar una vez creaa la cuenta.
     * @return String informando que el cliente ha sido actualizado.
     * @throws Exception De haber algún parámetro vacío o nulo, si el email pasado no es válido, o si el cliente no existe dentro de la empresa.
     */
    public void actualizarCliente(String email, String nuevoNombre, String nuevaDirecc, String nuevoDocumento,
                                  String nuevaFechaNacimiento, String nuevaCiudad, String nuevoDepartamento,
                                  InformacionPago nuevaInfoPago) throws Exception {

        if (!email.equals("")) {

            if (!MyUtils.esEmailValido(email)) throw new EmailNoValidoException("" + email + " no es un email valido");


            for (Cliente c : listaClientes) {

                if (c != null && c.getEmail() != null && c.getEmail().equals(email)) {

                    if (!nuevoNombre.equals("")) c.setNombre(nuevoNombre);

                    if (!nuevaDirecc.equals("")) c.setDireccion(nuevaDirecc);

                    if (!nuevoDocumento.equals("")) c.setDocumento(nuevoDocumento);


                    if (!nuevaFechaNacimiento.equals("")) c.setFechaNacimiento(nuevaFechaNacimiento);

                    if (!nuevaCiudad.equals("")) c.setCiudad(nuevaCiudad);

                    if (!nuevoDepartamento.equals("")) c.setDepartamento(nuevoDepartamento);

                    if (nuevaInfoPago != null) c.getListaInfoPago().add(nuevaInfoPago);

                }
            }
        }
    }


    public void actualizarCliente(Cliente cliente, String nuevoNombre, String nuevaDireccion, String nuevaCiudad, String nuevaFechaNacimiento,
                                  String nuevoDocumento, String nuevoDepartamento, TipoDocumento tipoDocumento) throws ClienteException, NullPointerException {

        // existeCliente() lanza un NullPointerException en caso de que el cliente pasado sea nulo.
        if (!existeCliente(cliente))
            throw new ClienteException("El cliente pasado en el argumento no existe dentro de la empresa");

        if (!nuevoNombre.equals("")) cliente.setNombre(nuevoNombre);

        if (!nuevaDireccion.equals("")) cliente.setDireccion(nuevaDireccion);

        if (!nuevoDocumento.equals("")) cliente.setDocumento(nuevoDocumento);

        if (!nuevaFechaNacimiento.equals("")) cliente.setFechaNacimiento(nuevaFechaNacimiento);

        if (!nuevaCiudad.equals("")) cliente.setCiudad(nuevaCiudad);

        if (!nuevoDepartamento.equals("")) cliente.setDepartamento(nuevoDepartamento);

        if (tipoDocumento != null) cliente.setTipoDocumento(tipoDocumento);
    }

    /**
     * Método que elimina un cliente dado su email.
     *
     * @param email Atributo de Cliente a buscar dentro de listaClientes
     * @return True de encontrar y haber eliminado el cliente con el email pasado en el argumento, false de lo contrario.
     * @throws EmailNoValidoException Si el email pasado no es valido.
     */
    public void eliminarCliente(String email) throws EmailNoValidoException, ClienteException {

        if (!MyUtils.esEmailValido(email)) throw new EmailNoValidoException("" + email + " no es un email valido");

        if (!existeCliente(email))
            throw new ClienteException("El cliente con email " + email + " no se encuentra registrado dentro de la empresa");


        for (Cliente c : listaClientes) {
            if (c.getEmail().equals(email)) {
                listaClientes.remove(c);
            }
        }
    }

    /**
     * Método que actualiza la contraseña de un cliente validando primero con un campo de verificación que el cliente sí sepa su
     * contraseña actual. De llenar el campo y coincidir con su contraseña actual, el método permitirá actualizar la contraseña del
     * cliente, de lo contrario, lanzará una excepción.
     *
     * @param cliente                 Cliente a actualizar.
     * @param verificacionContrasenia String a comparar con la contraseña actual del cliente -> (Cliente.getContrasenia). Si ambas coinciden, se permite la actualización.
     * @param nuevaContrasenia
     * @throws ClienteException     Si el cliente no existe dentro de la empresa.
     * @throws NullPointerException Si el cliente es nulo.
     * @throws ContraseniaException Si la contraseña del cliente y verificacionContrasenia no coinciden.
     * @throws StringVacioException Si al menos uno de los (String) parámetros está vacío.
     */
    public void actualizarContraseniaCliente(Cliente cliente, String verificacionContrasenia, String nuevaContrasenia)
            throws ClienteException, NullPointerException, ContraseniaException, StringVacioException {

        if (verificacionContrasenia.equals("") || nuevaContrasenia.equals(""))
            throw new StringVacioException("Existe algún parámetro vacío.");

        //Internamente, existeCliente() ya arroja un NullPointerException
        if (!existeCliente(cliente)) throw new ClienteException("El cliente indicado en el argumento no existe");

        String viejaContra = cliente.getContrasenia();

        if (!viejaContra.equals(verificacionContrasenia))
            throw new ContraseniaException("La contraseña de verificación no coincide con la contraseña actual del cliente");

        cliente.setContrasenia(nuevaContrasenia);
    }

    //CRUD Administrador -------------------------------------------------------------------------------------------------


    /**
     * Método encargado de crear un administrador.
     *
     * @param id
     * @param nombre
     * @param documento
     * @param direccion
     * @param email
     * @param fechaNacimiento
     * @param estudios
     * @param tipoDoc
     * @param sede
     * @throws StringNuloOrVacioException
     * @throws EmailNoValidoException
     * @throws EmailYaRegistradoException
     */
    public void crearAdministrador(String id, String nombre, String documento, String direccion, String email, String contrasenia, String fechaNacimiento, String estudios, TipoDocumento tipoDoc, Sede sede) throws StringNuloOrVacioException, EmailNoValidoException, EmailYaRegistradoException {

        MyUtils.validarSiNuloOrVacio(id, nombre, documento, direccion, email, fechaNacimiento, estudios); //Método encargado de verificar que no hayan nulos ni vacíos.

        if (tipoDoc == null) throw new NullPointerException("EL tipo de documento indicado es nulo");

        if (sede == null) throw new NullPointerException("La sede indicada es nula");

        if (!MyUtils.esEmailValido(email)) throw new EmailNoValidoException("" + email + " no es mail valido");

        if (existeAdminByEmail(email))
            throw new EmailYaRegistradoException("El administrador con email " + email + " ya se encuentra registrado dentro de la empresa");

        Administrador admin = new Administrador(id, nombre, documento, direccion, email, contrasenia, fechaNacimiento, estudios, tipoDoc);

        this.listaAdministradores.add(admin);
    }


    /**
     * Método que crea un administrador SIN ASIGNARLE UNA SEDE.
     *
     * @param id
     * @param nombre
     * @param documento
     * @param direccion
     * @param email
     * @param contrasenia
     * @param fechaNacimiento
     * @param estudios
     * @param tipoDoc
     * @throws StringNuloOrVacioException
     * @throws EmailNoValidoException
     * @throws EmailYaRegistradoException
     */
    public void crearAdministrador(String id, String nombre, String documento, String direccion, String email, String contrasenia, String fechaNacimiento, String estudios, TipoDocumento tipoDoc) throws StringNuloOrVacioException, EmailNoValidoException, EmailYaRegistradoException {

        MyUtils.validarSiNuloOrVacio(id, nombre, documento, direccion, email, fechaNacimiento, estudios); //Método encargado de verificar que no hayan nulos ni vacíos.

        if (tipoDoc == null) throw new NullPointerException("EL tipo de documento indicado es nulo");

        if (!MyUtils.esEmailValido(email)) throw new EmailNoValidoException("" + email + " no es mail valido");

        if (existeAdminByEmail(email))
            throw new EmailYaRegistradoException("El administrador con email " + email + " ya se encuentra registrado dentro de la empresa");

        Administrador admin = new Administrador(id, nombre, documento, direccion, email, contrasenia, fechaNacimiento, estudios, tipoDoc);

        this.listaAdministradores.add(admin);
    }


    /**
     * Método que retorna un administrador según su email
     *
     * @param adminEmail Email del admin a buscar dentro de listaAdministradores;
     * @return Null de no encontrar un administrador con tal email.
     * @throws EmailNoValidoException Si el email pasad no es un email válido.
     */
    public Administrador obtenerAdminByEmail(String adminEmail) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(adminEmail))
            throw new EmailNoValidoException("" + adminEmail + " no es un email válido");

        for (Administrador a : listaAdministradores) {

            if (a != null && a.getEmail() != null && a.getEmail().equals(adminEmail)) return a;
        }
        return null;
    }

    /**
     * Método que retorna un admninistrador según su id de la empresa.
     *
     * @param id Identificación dentro del contexto de empresa (no documento).
     * @return Null de no encontrar ningún administrador con la identificación mostrada.
     * @throws StringNuloOrVacioException Si el id es nulo o es vacío.
     */
    public Administrador obtenerAdminByID(String id) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(id); //Revisar comentarios del método.

        for (Administrador a : listaAdministradores) {

            if (a != null && a.getId() != null && a.getId().equals(id)) return a;
        }
        return null;
    }


    /**
     * Método que actualiza sede indiacada en el argumento.
     * Es posible dejar todos los parámetros nulos o vacíos (excepto el ID), pues en tal caso, el método no actualizará estos, evitando arrojar errores innecesarios.
     *
     * @param id                   Identificador del administrador a actualizar.
     * @param nuevoNombre
     * @param nuevoDoc
     * @param nuevaDirecc
     * @param nuevaFechaNacimiento
     * @param nuevosEstudios
     * @param nuevoTipoDoc
     * @param nuevaSedeID
     * @throws StringNuloOrVacioException Si el ID pasado es nulo o está vacío.
     * @throws AdminException             De no existir ningun administrador con el ID indicado en el argumento.
     */
    public void actualizarAdmin(String id, String nuevoNombre, String nuevoDoc, String nuevaDirecc, String nuevaFechaNacimiento, String nuevosEstudios, TipoDocumento nuevoTipoDoc, String nuevaSedeID) throws StringNuloOrVacioException, AdminException {

        //Los unicos atributos immutables de admin son el email y su id.

        if (!id.equals("")) {

            if (!existeAdminByID(id)) throw new AdminException("No existe ningún admin con el ID " + id + "");

            Administrador aux = obtenerAdminByID(id);

            for (Administrador admin : listaAdministradores) {
                if (admin.equals(aux)) {

                    if (!MyUtils.esNuloOrVacio(nuevoNombre)) admin.setNombre(nuevoNombre);

                    if (!MyUtils.esNuloOrVacio(nuevoDoc)) admin.setDocumento(nuevoDoc);

                    if (!MyUtils.esNuloOrVacio(nuevaDirecc)) admin.setDireccion(nuevaDirecc);

                    if (!MyUtils.esNuloOrVacio(nuevaFechaNacimiento)) admin.setFechaNacimiento(nuevaFechaNacimiento);

                    if (!MyUtils.esNuloOrVacio(nuevosEstudios)) admin.setEstudios(nuevosEstudios);

                    if (nuevoTipoDoc != null) admin.setTipoDocumento(nuevoTipoDoc);

                    if (!MyUtils.esNuloOrVacio(nuevaSedeID)) {
                        admin.setSede(obtenerSede(nuevaSedeID));
                    }
                }
            }
        }

    }

    /*
    Un método para actualizar administrador que reciba el administrador a actualizar, el nuevo id, nuevo nombre,
    nuevo documento, nueva direccion, nueva fecha de nacimiento, nuevos estudios y nuevo tipo de documento y arroje
    una excepcion si el administrador que se le pasa es nulo
     */

    public void actualizarAdmin(Administrador admin, String nuevoID, String nuevoNombre, String nuevoDoc,
                                String nuevaDirec, String nuevaFechaNacimiento, String nuevosEstudios,
                                TipoDocumento nuevoTipoDoc) throws AdminException, NullPointerException {

        if (admin == null) throw new NullPointerException("El administrador pasado es nulo");

        if (nuevoID == null) throw new NullPointerException("El ID pasado es nulo");

        if (!nuevoID.equals("")) {

            if (existeAdminByID(nuevoID)) throw new AdminException("Ya existe un administrador con el ID " + nuevoID);

            if (!MyUtils.esNuloOrVacio(nuevoNombre)) admin.setNombre(nuevoNombre);

            if (!MyUtils.esNuloOrVacio(nuevoDoc)) admin.setDocumento(nuevoDoc);

            if (!MyUtils.esNuloOrVacio(nuevaDirec)) admin.setDireccion(nuevaDirec);

            if (!MyUtils.esNuloOrVacio(nuevaFechaNacimiento)) admin.setFechaNacimiento(nuevaFechaNacimiento);

            if (!MyUtils.esNuloOrVacio(nuevosEstudios)) admin.setEstudios(nuevosEstudios);

            if (nuevoTipoDoc != null) admin.setTipoDocumento(nuevoTipoDoc);
        }
    }

    public void actualizarContraseniaAdmin(Administrador administrador, String verificacionContrasenia, String nuevaContrasenia)
            throws AdminException, NullPointerException, ContraseniaException, StringVacioException {

        if (verificacionContrasenia.equals("") || nuevaContrasenia.equals(""))
            throw new StringVacioException("Existe algún parámetro vacío.");

        //Internamente, existeCliente() ya arroja un NullPointerException
        if (!existeAdmin(administrador))
            throw new AdminException("El administrador indicado en el argumento no existe");

        String viejaContra = administrador.getContrasenia();

        if (!viejaContra.equals(verificacionContrasenia))
            throw new ContraseniaException("La contraseña de verificación no coincide con la contraseña actual del administrador");

        administrador.setContrasenia(nuevaContrasenia);
    }


    //CRUD SEDE------------------------------------------------------------------------------------------------------------

    /**
     * Método que crea una sede.
     * Este constructor otorga listaProductos,
     *
     * @param nombre
     * @param sedeID
     * @param listaProductos
     * @param ciudad
     * @param adminID
     * @throws StringNuloOrVacioException
     * @throws SedeYaRegistradaException
     * @throws SedeException
     */
    public void crearSede(String nombre, String sedeID, ArrayList<Producto> listaProductos, Ciudad ciudad, String adminID) throws StringNuloOrVacioException, SedeYaRegistradaException, SedeException {

        //Lo que tiene más sentido es que una sede nueva empiece sin facturas.

        MyUtils.validarSiNuloOrVacio(nombre, sedeID, adminID);

        if (listaProductos == null) throw new NullPointerException("La lista de productos está vacía");

        if (ciudad == null) throw new NullPointerException("La ciudad pasada en el argumento es vacía");


        if (existeSede(sedeID))
            throw new SedeYaRegistradaException("Ya existe un sede con el id: " + sedeID + ", por lo tanto no se puede crear otra con el mismo id");

        if (adminTieneSede(adminID)) //Una sede no debe tener más de un administrador.
            throw new SedeException("El adminstrador con idetifación " + adminID + " ya posee una sede.");

        Sede sede = new Sede(nombre, sedeID, this, listaProductos, ciudad);

        this.listaSedes.add(sede);
    }


    /**
     * Método que crea una sede SIN LISTA DE PRODUCTOS.
     * El presente método usa un constructor para crear la sede que instancia la lista de productos de la misma, pero vacía.
     *
     * @param nombre  -
     * @param sedeID  -
     * @param ciudad  -
     * @param adminID -
     * @throws StringNuloOrVacioException -
     * @throws SedeYaRegistradaException  -
     * @throws SedeException              Si el administrador indicado en el argumento ya posee una sede.
     */
    public void crearSede(String nombre, String sedeID, Ciudad ciudad, String adminID) throws StringNuloOrVacioException, SedeYaRegistradaException, SedeException {

        //Lo que tiene más sentido es que una sede nueva empiece sin facturas.

        MyUtils.validarSiNuloOrVacio(nombre, sedeID, adminID);

        if (ciudad == null) throw new NullPointerException("La ciudad pasada en el argumento es vacía");

        if (existeSede(sedeID))
            throw new SedeYaRegistradaException("Ya existe un sede con el id: " + sedeID + ", por lo tanto no se puede crear otra con el mismo id");

        if (adminTieneSede(adminID)) //Una sede no debe tener más de un administrador.
            throw new SedeException("El adminstrador con idetifación " + adminID + " ya posee una sede.");

        Administrador administrador = obtenerAdminByID(adminID);
        Sede sede = new Sede(nombre, sedeID, this, ciudad, administrador);

        administrador.setSede(sede);

        this.listaSedes.add(sede);
    }


    /**
     * Método que retorna una sede según su identificador
     *
     * @param id Identificador de la sede.
     * @return Null de no existir una sede con el ID indicado.
     */
    public Sede obtenerSede(String id) {

        MyUtils.esEmailValido(id);

        for (Sede s : listaSedes) {

            if (s != null && s.getId() != null && s.getId().equals(id)) return s;
        }
        return null;
    }

    /**
     * Método que actualizada una sede según unos parámetros dados. Si el sedeID está vacío, el método no hará nada.
     *
     * @param sedeID         Identificador de la sede
     * @param nuevoNombre
     * @param adminID        Administrador que se encargará de la sede indicada.
     * @param listaProductos Nueva lista de productos. ESTA PUEDE SER NULA, NO AFECTARÁ EL MÉTODO, simplemente no cambiará la listaProductos que ya posee la sede.
     * @throws StringNuloOrVacioException
     * @throws SedeException              De no existir ninguna sede con el ID especificado.
     */
    public void actualizarSede(String sedeID, String nuevoNombre, String adminID, ArrayList<Producto> listaProductos) throws StringNuloOrVacioException, SedeException {

        //Los unicos atributos que, por sentido común, no se actualizan son: id - empresa -  ciudad - listFacturas


        if (!sedeID.equals("")) {

            if (existeSede(sedeID)) {

                for (Sede s : listaSedes) {

                    if (s != null && s.getId() != null && s.getId().equals(sedeID)) {

                        if (MyUtils.esNuloOrVacio(nuevoNombre)) s.setNombre(nuevoNombre);

                        if (MyUtils.esNuloOrVacio(adminID)) {

                            if (existeAdminByID(adminID)) s.setAdministrador(obtenerAdminByID(adminID));
                        }

                        if (listaProductos != null) s.setListaProductos(listaProductos);
                    }
                }
            } else {
                throw new SedeException("La sede con id " + sedeID + " no existe");
            }
        }


    }

    /**
     * Método que ingresa productos a la sede especificada en el argumento.
     *
     * @param productoEmpresa    Identificador del producto a enviar a la sede.
     * @param cantidadSolicitada Cantidad del producto mencionado. Tal cantidad no debe ser mayor a la existencias que posee la empresa.
     * @param sede               Identificador de la sede a agregar el producto.
     * @throws StringNuloOrVacioException
     * @throws SedeException              Si no existe una sede con el ID especificado.
     * @throws ProductoException          Si no existe un producto con el ID especificado.
     */
    public void agregarProductosSede(Producto productoEmpresa, int cantidadSolicitada, Sede sede) throws StringNuloOrVacioException, SedeException, ProductoException {

        if (productoEmpresa == null) throw new NullPointerException("El producto pasado en el parametro es nulo");
        if (sede == null) throw new NullPointerException("La sede pasada en el parametro es nula");

        if (!existeSede(sede))
            throw new SedeException("La sede pasada en el argumento no existe dentro de la empresa"); //Utiliza el método Sede.equals.

        if (productoEmpresa.getExistencias() < cantidadSolicitada)
            throw new ProductoException("La existencias solicitadas por la sede superan a las que hay en la empresa");


        for (Sede s : listaSedes) {

            if (s.equals(sede)) { //Buscamos la sede


                //El siguiente bloque de código se ejecuta en caso de que la empresa ya posea el producto que se desea agregar, así no agregamos más instancias del mismo producto
                //a la lista de productos de la sede.
                if (sedeContieneProducto(sede, productoEmpresa)) { //Compara por ID por medio del Producto.equals

                    //Se obtiene las existencias que ya existen en la sede.
                    int existencias = s.obtenerProducto(productoEmpresa).getExistencias();
                    existencias += cantidadSolicitada;

                    s.obtenerProducto(productoEmpresa).setExistencias(existencias);

                    //se obtiene las existencias que posee la empresa
                    int nuevasExistenciasEmpresa = productoEmpresa.getExistencias();

                    nuevasExistenciasEmpresa -= cantidadSolicitada; //Luego reducimos las existencias que introdujimos a la sede.
                    productoEmpresa.setExistencias(nuevasExistenciasEmpresa);

                } else {

                    //Si la sede no contiene el producto, lo lógico es meterlo dentro de la lista de productos que este posee

                    //Clonamos (Creamos una instancia de) el producto (que pertenece a la empresa).
                    Producto prod = clonarProducto(productoEmpresa);
                    //Le seteamos las existencias indicadas en el argumento.
                    prod.setExistencias(cantidadSolicitada);

                    //Agregamos el producto a la sede

                    s.getListaProductos().add(prod);

                    //Disminuimos la cantidad de producto a la empresa que enviamos a la sede.
                    int nuevasExistencias = productoEmpresa.getExistencias();
                    nuevasExistencias -= cantidadSolicitada;

                    productoEmpresa.setExistencias(nuevasExistencias);
                }
            }
        }
    }

    /**
     * Método encargado de eliminar una sede dado ID.
     *
     * @param sedeID Identificador de la sede.
     * @throws SedeException
     * @throws StringNuloOrVacioException
     */
    public void eliminarSede(String sedeID) throws SedeException, StringNuloOrVacioException {

        if (!existeSede(sedeID))
            throw new SedeException("La sede con el ID " + sedeID + " no existe dentro de la empresa");


        for (Sede s : listaSedes) {
            if (s != null && s.getId() != null && s.getId().equals(sedeID)) this.listaSedes.remove(s);
        }
    }

    //CRUD Producto --------------------------------------------------------------------------------------------------------

    /**
     * Método que crea un nuevo producto, validando que no exista ya uno con el mismo id y el mismo nombre
     *
     * @param id
     * @param nombre
     * @param precio
     * @param descripcion
     * @param imagen
     * @param existencias
     * @param categoria
     * @throws StringNuloOrVacioException
     * @throws NegativeNumberException
     * @throws ProductoException
     */
    public void crearProducto(String id, String nombre, double precio, String descripcion, Image imagen, int existencias, CategoriaProducto categoria) throws StringNuloOrVacioException, NegativeNumberException, ProductoException {

        MyUtils.validarSiNuloOrVacio(id, nombre, descripcion);

        if (imagen == null) throw new NullPointerException("La imgen pasada es nula");
        if (categoria == null) throw new NullPointerException("La categoría del producto es nula");
        if (precio < 0) throw new NegativeNumberException("El precio no puede ser menor o igual que 0");
        if (existencias < 0) throw new NegativeNumberException("El precio no puede ser menor que 0");


        if (existeProductoByID(id))
            throw new ProductoException("El producto con id " + id + " ya existe dentro de la empresa");
        if (existeProductoByNombre(nombre))
            throw new ProductoException("El Producto con nombre " + nombre + " ya existe dentro de la empresa");


        Producto prod = new Producto(id, nombre, precio, descripcion, imagen, existencias, categoria, this);

        this.listaProductos.add(prod);
    }

    /**
     * Método que obtiene un producto según su ID.
     *
     * @param prodID Identificador del producto dentro del contexto de la empresa.
     * @return Null de no encontrar el producto indicado en el argumento.
     * @throws StringNuloOrVacioException Si prodID es nulo o está vacío.
     */
    public Producto obtenerProducto(String prodID) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(prodID);

        for (Producto p : listaProductos) {

            if (p != null && p.getId() != null && p.getId().equals(prodID)) return p;
        }
        return null;
    }


    /**
     * Método que actualiza un producto DE LA EMPRESA (no de las sedes, pues tal es la responsabilidad de las mismas).
     * Si prodID es vacío, entonces el método no hace nada.
     * Los unicos atributos que no se actualizan son el ID y la empresa.
     * <p>
     * Es posible dejar atributos nulos o vacíos, pues en tal caso, el método no actualizará estos, evitando arrojar errores innecesarios.
     *
     * @param prodID
     * @param nuevoNombre
     * @param nuevoPrecio
     * @param nuevaDescrip
     * @param nuevaImagen
     * @param nuevasExistencias
     * @param nuevaCategoria
     * @throws StringNuloOrVacioException
     * @throws ProductoException
     * @throws NegativeNumberException
     */
    public void actualizarProducto(String prodID, String nuevoNombre, double nuevoPrecio, String nuevaDescrip, Image nuevaImagen, int nuevasExistencias, CategoriaProducto nuevaCategoria) throws StringNuloOrVacioException, ProductoException, NegativeNumberException {

        if (!prodID.equals("")) {

            MyUtils.validarSiPositivo(nuevasExistencias);

            MyUtils.validarSiPositivo(nuevoPrecio, "El precio del producto no puede ser negativo");
            MyUtils.validarSiPositivo(nuevasExistencias, "Las existencias no pueden ser negativas");


            if (!existeProductoByID(prodID))
                throw new ProductoException("No existe ningún producto con el ID " + prodID + " dentro de la empresa");

            for (Producto p : listaProductos) {

                if (p != null && p.getId() != null && p.getId().equals(prodID)) {

                    if (!MyUtils.esNuloOrVacio(nuevoNombre))
                        p.setNombre(nuevoNombre);

                    if (nuevoPrecio != 0)
                        p.setPrecio(nuevoPrecio);

                    if (!MyUtils.esNuloOrVacio(nuevaDescrip))
                        p.setDescripcion(nuevaDescrip);

                    if (nuevaImagen != null)
                        p.setImg(nuevaImagen);

                    if (nuevasExistencias != 0)
                        p.setExistencias(nuevasExistencias);

                    if (nuevaCategoria != null)
                        p.setCategoria(nuevaCategoria);
                }
            }
        }
    }


    public void actualizarProducto(Producto producto, String nuevoNombre, double nuevoPrecio, String nuevaDescrip, Image nuevaImagen, int nuevasExistencias, CategoriaProducto nuevaCategoria)
            throws StringNuloOrVacioException, ProductoException, NegativeNumberException {

        if (producto != null) {

            MyUtils.validarSiPositivo(nuevasExistencias);

            MyUtils.validarSiPositivo(nuevoPrecio, "El precio del producto no puede ser negativo");
            MyUtils.validarSiPositivo(nuevasExistencias, "Las existencias no pueden ser negativas");


            if (!existeProductoByID(producto.getId()))
                throw new ProductoException("No existe ningún producto con el ID " + producto.getId() + " dentro de la empresa");

            for (Producto p : listaProductos) {

                if (p != null && p.getId() != null && p.getId().equals(producto.getId())) {

                    if (!MyUtils.esNuloOrVacio(nuevoNombre)) {
                        p.setNombre(nuevoNombre);
                        modificarNombreProdSedes(nuevoNombre, producto);
                    }

                    if (nuevoPrecio != 0) {
                        p.setPrecio(nuevoPrecio);
                        modificarPrecioProdSedes(nuevoPrecio, producto);
                    }

                    if (!MyUtils.esNuloOrVacio(nuevaDescrip)) {
                        p.setDescripcion(nuevaDescrip);
                        modificarDescripcionProdSedes(nuevaDescrip, producto);
                    }

                    if (nuevaImagen != null) {
                        p.setImg(nuevaImagen);
                        modificarImagenProdSedes(nuevaImagen, producto);
                    }

                    if (nuevasExistencias != 0)
                        p.setExistencias(nuevasExistencias); //Solo mofificará las existencias del producto de la Empresa.

                    if (nuevaCategoria != null) {
                        p.setCategoria(nuevaCategoria);
                        modificarCategoriaProdSedes(nuevaCategoria, producto);
                    }
                }
            }

        }
    }


    /**
     * Método que elimina un producto dado su ID.
     *
     * @param producto Identifacdor del producto
     * @throws StringNuloOrVacioException
     * @throws ProductoException
     */
    public void eliminarProducto(Producto producto) throws StringNuloOrVacioException, ProductoException {

        MyUtils.validarSiNuloOrVacio(producto.getId());

        if (!existeProductoByID(producto.getId()))
            throw new ProductoException("El producto con ID " + producto.getId() + " no existe dentro de la empresa");


        //Primero eliminamos el producto de la sede
        for (Sede s: listaSedes) {

            for (Producto p: s.getListaProductos()) {
                if(p.equals(producto))
                    s.getListaProductos().remove(p);
            }
        }


        //Eliminamos el producto de la empresa.
        for (Producto p : listaProductos) {
            if (p.equals(producto))
                listaProductos.remove(p);
        }

    }


    //CRUD FACTURA --------------------------------------------------------------------------------------------------------------------


    //SE SUPONE QUE NO IMPORTANCIA,

    /**
     * Método que genera que genera un factura con con código unico, dado el cliente, listaDatalles, DatosEnvio y la información de pago.
     * <p>
     * El codigo se genera con la clase random, y es un número entre 1 y 10000.
     * La fecha se genera al momento de hacer la factura con la clase Date del java.util.Date
     * Con la lista de detalles ya se calcula internamente  el subtotal, iva y total.
     *
     * @param cliente
     * @param listaDetalles
     * @param datosEnvio
     * @param infoPago
     */
    public void crearFactura(Cliente cliente, Sede sede, ArrayList<DetalleFactura> listaDetalles, DatosEnvio datosEnvio, InformacionPago infoPago) throws ProductoException, SedeException {

        String codigo = generarCodigoUnicoFactura(); //Utiliza la clase random
        String fecha = obtenerFechaActual();
        double subtotal = calcularSubtotalFactura(listaDetalles);
        double iva = calcularIVA(subtotal);
        double total = iva + subtotal;


        verificarCompra(listaDetalles, sede);


        Factura factura = new Factura(codigo, fecha, total, subtotal, iva, sede, this, cliente, datosEnvio, infoPago);
        factura.setListaDetalles(listaDetalles);
        sede.getListaFacturas().add(factura);
        cliente.getListaFacturas().add(factura); //Esto agrega la factura a la lista de facturas del cliente al crearse la misma.
        this.listaFacturas.add(factura);
    }

    public Factura obtenerFactura(String codigo) {

        for (Factura f : listaFacturas) {

            if (f != null && f.getCodigo() != null && f.getCodigo().equals(codigo))
                return f;
        }
        return null;
    }

    public void EliminarFactura(Factura factura) {

        for (Factura f : listaFacturas) {
            if (f.equals(factura))
                listaFacturas.remove(f);
        }
    }


    // Métodos propios de Empresa----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Método que evalúa si un cliente ya existe dentro de la lista de clientes evaluando el objeto Cliente.
     *
     * @param cliente Cliente a buscar dentro de listaClientes.
     * @return True si el cliente ya existe, false de lo contrario.
     */
    public boolean existeCliente(Cliente cliente) throws NullPointerException {

        if (cliente == null) throw new NullPointerException("El cliente es nulo");

        for (Cliente c : getListaClientes()) {

            if (cliente.equals(c)) return true;
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
                if (c.getEmail().equals(email)) return true;
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
    public boolean existeAdminByEmail(String email) throws EmailNoValidoException {

        if (!MyUtils.esEmailValido(email)) throw new EmailNoValidoException("El email " + email + " no es válido");

        for (Administrador a : listaAdministradores) {

            if (a != null && a.getEmail().equals(email)) return true;
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
    public boolean existeAdminByID(String adminID) {

        for (Administrador a : listaAdministradores) {
            if (a != null && a.getId().equals(adminID)) return true;
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
        for (Sede s : listaSedes) {
            if (s != null && s.getId() != null && s.getId().equals(sedeId)) {
                if (s.getAdministrador() != null) return true;
            }
        }
        return false;
    }


    /**
     * Método que verifica si el administrador indicado (via ID) posee una sede.
     *
     * @param adminID Identificador del administrador dentro del contexto de la empresa.
     * @return True si el admin con el ID indicado administra una sede. False si este no administra ninguna sede.
     * @throws StringNuloOrVacioException
     */
    public boolean adminTieneSede(String adminID) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(adminID);

        for (Administrador a : listaAdministradores) {

            if (a != null && a.getId() != null && a.getId().equals(adminID) && a.getSede() != null) return true;
        }
        return false;
    }


    /**
     * Método que verifica si una sede existe dentro de la empresa dado su id.
     *
     * @param sedeID Atributo a buscar dentro de la sede dentro de listaSedes
     * @return True de existir la sede con el id indicado en el argumento. False de lo contrario.
     * @throws StringNuloOrVacioException Si el id pasado es nulo o vacío.
     */
    public boolean existeSede(String sedeID) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(sedeID);

        for (Sede s : listaSedes) {
            if (s != null && s.getId() != null && s.getId().equals(sedeID)) return true;
        }
        return false;
    }

    public boolean existeSede(Sede sede) {

        for (Sede s : listaSedes) {
            if (s.equals(sede)) return true;
        }
        return false;
    }


    /**
     * Método que veriica si existe algún producto dentro de listaProductos con el ID indicado
     *
     * @param prodID
     * @return
     * @throws StringNuloOrVacioException
     */
    public boolean existeProductoByID(String prodID) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(prodID);

        for (Producto p : listaProductos) {

            if (p != null && p.getId() != null && p.getId().equals(prodID)) return true;
        }
        return false;
    }

    /**
     * Método que verifica si existe algún producto dentro de listaProductos con el nombre indicado
     *
     * @param nombre
     * @return
     * @throws StringNuloOrVacioException
     */
    public boolean existeProductoByNombre(String nombre) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(nombre);

        for (Producto p : listaProductos) {

            if (p != null && p.getNombre() != null && p.getNombre().equals(nombre)) return true;
        }
        return false;
    }

    private double calcularSubtotalFactura(ArrayList<DetalleFactura> listaDetalles) {

        double total = 0;

        for (DetalleFactura d : listaDetalles) {
            total += d.getCantidad() * d.getProductoFacturado().getPrecio();
        }
        return total;
    }

    private double calcularIVA(double subtotal) {
        return (subtotal / 100) * 16;
    }

    private String generarCodigoUnicoFactura() {

        Random random = new Random();
        int x = random.nextInt(1000000) + 1;
        String codigo = "" + x;

        for (Factura f : listaFacturas) {

            if (f.getCodigo().equals(codigo))
                return generarCodigoUnicoFactura();
        }
        return codigo;
    }

    /**
     * Método que retorna la fecha actual como sigue : "DiaSemana Mes numDía hh:mm:ss COT aaaa"
     *
     * @return Fecha actual con todo lujo de detalle.
     */
    private String obtenerFechaActual() {

        SimpleDateFormat sfd = new SimpleDateFormat("yyyy/MM/dd");
        return sfd.format(new Date()).replace('/', '-');
    }
    //Métodos de Admin

    /**
     * Método que retorna la lista de facturas de un cliente
     *
     * @param emailCliente
     * @return
     * @throws EmailNoValidoException
     */
    public ArrayList<Factura> obtenerListaFacturasCliente(String emailCliente) throws EmailNoValidoException {
        Cliente cliente = obtenerCliente(emailCliente);
        ArrayList<Factura> listaFacturasCliente = new ArrayList<>();
        for (int i = 0; i < listaFacturas.size(); i++) {
            if (listaFacturas.get(i).getCliente() == cliente) {
                listaFacturasCliente.add(listaFacturas.get(i));
            }
        }
        return listaFacturasCliente;
    }


    /**
     * Método que crea un reporte (lista de facturas)entre dos fechas dadas en formato
     * año- mes -dia. Cabe resaltar que todas las fechas se traducen a numeros y para
     * saber si una fecha es despues de otra es porque el numero es mayor y vice versa
     *
     * @param fechaInicial
     * @param fechaFinal
     */
    public Reporte crearReporte(String fechaInicial, String fechaFinal) {
        Reporte reporte = null;
        ArrayList<Factura> listaFacturasReporte = new ArrayList<>();
        int fechaInicialTraducida = traducirFecha(fechaInicial);
        int fechaFinalTraducida = traducirFecha(fechaFinal);
        if (listaFacturas != null) {
            for (int i = 0; i < listaFacturas.size(); i++) {
                if (traducirFecha(listaFacturas.get(i).getFecha()) > fechaInicialTraducida &&
                        traducirFecha(listaFacturas.get(i).getFecha()) < fechaFinalTraducida) {
                    listaFacturasReporte.add(listaFacturas.get(i));
                }
            }
            reporte = new Reporte(this, listaFacturasReporte);
        }
        return reporte;
    }


    /**
     * Método que traduce una fecha en el formato año-mes-dia a numeros solamente, es decir
     * si un fecha es 2022/05/3 quedará 2022053
     *
     * @param fecha_anio_mes_dia
     * @return
     */
    private int traducirFecha(String fecha_anio_mes_dia) {
        int fechaTraducida = 0;
        String[] fechaDescompuesta = fecha_anio_mes_dia.split("-");
        String fechaArreglada = "";
        for (int i = 0; i < fechaDescompuesta.length; i++) {
            fechaArreglada += fechaDescompuesta[i];
        }
        fechaTraducida = Integer.parseInt(fechaArreglada);
        return fechaTraducida;
    }

    /**
     * Método que recorre el arraylist de clientes y por cada cliente,recorre todo el arraylist
     * de facturas contando todas las facturas asociadas al cliente.
     * Si el contador1 es mayor a un contador2, entonces es porque el cliente tiene
     * mas incidencias en la lista de facturas que el cliente anteriór, por ende,
     * se setea su numero de incidencias en contador2 y se setea el objeto con dicho cliente
     *
     * @return
     */
    public Cliente encontrarClienteMasCompra() {
        Cliente clienteEncontrado = null;
        int contador1 = 0;
        int contador2 = 0;

        for (int i = 0; i < listaClientes.size(); i++) {
            for (int j = 0; j < listaFacturas.size(); j++) {
                if (listaFacturas.get(j).getCliente() == listaClientes.get(i)) {
                    contador1 += 1;
                }
            }
            if (contador1 >= contador2) {
                contador2 = contador1;
                contador1 = 0;
                clienteEncontrado = listaClientes.get(i);
            }
        }
        return clienteEncontrado;
    }

    /**
     * Método que retorna la fecha en la que se mas se vendió un producto dado el nombre del
     * producto
     *
     * @param nombreProducto
     * @return
     */
    public String determinarFechaProductoMasVendido(String nombreProducto) {
        String fechaProductoMasVendido = "";
        int contador1 = 0;
        int contador2 = 0;
        String fechaAux = "";
        for (int j = 0; j < listaFacturas.size(); j++) {
            contador1 = listaFacturas.get(j).definirVecesEstaProducto(nombreProducto);
            fechaAux = listaFacturas.get(j).getFecha();
        }
        if (contador1 >= contador2) {
            contador2 = contador1;
            contador1 = 0;
            fechaProductoMasVendido = fechaAux;
        }

        return fechaProductoMasVendido;
    }

//obtener 3 productos mas vendidos - Funcióna, pero está muy largo y queda abierto a mejoras

    /**
     * Método que retorna una lista con los tres productos mas vendidos
     *
     * @return
     */
    public ArrayList<Producto> obtenerTresProductosMasVendidos() {
        ArrayList<Producto> listaProductosMasVendidos = new ArrayList<>();
        Producto producto1 = null;
        Producto producto2 = null;
        Producto producto3 = null;
        if (listaProductos.size() >= 3) {
            producto1 = calcularProductoMasVendido();
            producto2 = calcularProductoMasVendidoExceptoUno(producto1);
            producto3 = calcularProductoMasVendidoExceptoDos(producto1, producto2);
            listaProductosMasVendidos.add(producto1);
            listaProductosMasVendidos.add(producto2);
            listaProductosMasVendidos.add(producto3);

        } else {
            if (listaProductos.size() == 2) {
                producto1 = calcularProductoMasVendido();
                producto2 = calcularProductoMasVendidoExceptoUno(producto1);
                listaProductosMasVendidos.add(producto1);
                listaProductosMasVendidos.add(producto2);
            } else {
                if (listaProductos.size() == 1) {
                    producto1 = calcularProductoMasVendido();
                    listaProductosMasVendidos.add(producto1);
                }
            }
        }
        return listaProductosMasVendidos;
    }

    /**
     * Método que obtiene el producto mas vendido exeptuando dos productos
     * Es decir, esos dos productos se ignoran en la lectura de la lista
     *
     * @param producto1
     * @param producto2
     * @return
     */
    private Producto calcularProductoMasVendidoExceptoDos(Producto producto1, Producto producto2) {
        int contador1 = 0;
        int contador2 = 0;
        Producto productoMasVendido = null;
        for (int i = 0; i < listaProductos.size(); i++) {
            for (int j = 0; j < listaFacturas.size(); j++) {
                contador1 = listaFacturas.get(j).definirVecesEstaProducto(listaProductos.get(i).getNombre());
            }
            if (contador1 >= contador2 && listaProductos.get(i) != producto1 && listaProductos.get(i) != producto2) {
                contador2 = contador1;
                contador1 = 0;
                productoMasVendido = listaProductos.get(i);
            }
        }
        return productoMasVendido;
    }

    /**
     * Método que obtiene el producto mas vendido exeptuando un producto
     * Es decir, ese producto se ignora en la lectura de la lista
     *
     * @param producto1
     * @return
     */
    private Producto calcularProductoMasVendidoExceptoUno(Producto producto1) {
        int contador1 = 0;
        int contador2 = 0;
        Producto productoMasVendido = null;
        for (int i = 0; i < listaProductos.size(); i++) {
            for (int j = 0; j < listaFacturas.size(); j++) {
                contador1 = listaFacturas.get(j).definirVecesEstaProducto(listaProductos.get(i).getNombre());
            }
            if (contador1 >= contador2 && listaProductos.get(i) != producto1) {
                contador2 = contador1;
                contador1 = 0;
                productoMasVendido = listaProductos.get(i);
            }
        }
        return productoMasVendido;
    }

    /**
     * Método que obtiene el producto mas vendido
     *
     * @return
     */
    private Producto calcularProductoMasVendido() {
        int contador1 = 0;
        int contador2 = 0;
        Producto productoMasVendido = null;
        for (int i = 0; i < listaProductos.size(); i += 1) {
            for (int j = 0; j < listaFacturas.size(); j += 1) {
                contador1 = listaFacturas.get(j).definirVecesEstaProducto(listaProductos.get(i).getNombre());
            }
            if (contador1 > contador2) {
                contador2 = contador1;
                contador1 = 0;
                productoMasVendido = listaProductos.get(i);
            }
        }
        return productoMasVendido;
    }

    //Métodos de cliente

    /**
     * Método que determina el historial de compra de un cliente
     *
     * @param cliente
     * @return
     */
    public ArrayList<DetalleFactura> determinarHistorialCompra(Cliente cliente) {
        ArrayList<DetalleFactura> historialCompra = new ArrayList<>();
        for (int i = 0; i < listaFacturas.size(); i++) {
            if (listaFacturas.get(i).getCliente() == cliente) {
                historialCompra.addAll(listaFacturas.get(i).getListaDetalles());
            }
        }
        return historialCompra;
    }

    /**
     * Método que busca un producto dado el nombre
     *
     * @param nombreProducto
     * @return
     */
    public Producto buscarProductoPorNombre(String nombreProducto) {
        Producto productoEncontrado = null;
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = listaProductos.get(i);
            }
        }
        return productoEncontrado;
    }

    /**
     * Método que dado un precio, retorna una lísta de productos cuyos precios sean menores a
     * ese precio
     *
     * @param precio
     * @return
     */
    public ArrayList<Producto> filtrarProductosPorPrecio(double precio) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getPrecio() < precio) {
                productosFiltrados.add(listaProductos.get(i));
            }
        }
        return productosFiltrados;
    }

    /**
     * Método que dada una categoría, solo mete en una lista a los productos que sean
     * de esa misma categoría dada
     *
     * @param categoria
     * @return
     */
    public ArrayList<Producto> filtrarProductosPorCategoria(CategoriaProducto categoria) {
        ArrayList<Producto> productosFiltrados = new ArrayList<>();
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCategoria() == categoria) {
                productosFiltrados.add(listaProductos.get(i));
            }
        }
        return productosFiltrados;
    }

    /**
     * Método que dado un producto, retorna una lista con las sedes en las que
     * está presente
     *
     * @param producto
     * @return
     */
    public ArrayList<Sede> determinarListaSedesTienenProducto(Producto producto) {
        ArrayList<Sede> listaSedesProducto = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        for (int i = 0; i < listaSedes.size(); i++) {
            listaProductos = listaSedes.get(i).getListaProductos();
            boolean bandera = false;
            for (int j = 0; j < listaProductos.size() && bandera == false; j++) {
                if (listaProductos.get(j) == producto) {
                    listaSedesProducto.add(listaSedes.get(i));
                    bandera = true;
                }
            }
        }
        return listaSedes;


    }


    public ArrayList<Producto> filtrarProductosPorCodigo(String codigo) {

        ArrayList<Producto> listaProductosFiltrados = new ArrayList<Producto>();

        for (Producto producto : listaProductos) {

            if (producto.getId().contains(codigo)) {

                listaProductosFiltrados.add(producto);

            }

        }

        return listaProductosFiltrados;
    }

    private void verificarCompra(ArrayList<DetalleFactura> listaDetalles, Sede sede) throws ProductoException, SedeException {

        ArrayList<Producto> listaProdSede = sede.getListaProductos();
        ArrayList<Producto> listaProdDetalles = obtenerProductoDetalles(listaDetalles);


        //El siguiente bloque de código lanza una excepción en caso de que en un detalle se quiera llevar
        //una cantidad mayor de productos de las que hay la sede.
        for (DetalleFactura d : listaDetalles) {

            for (Producto prodSede : listaProdSede) {

                if (d.getProductoFacturado().equals(prodSede)) {
                    if (d.getCantidad() > prodSede.getExistencias()) {
                        throw new ProductoException("La cantidad a comprar del producto "
                                + prodSede.getNombre() + " supera las existencias de la sede " + sede.getNombre());
                    }
                }
            }
        }

        //El siguiente bloque de código lanza una excepción en caso de que haya un producto en un detalle
        //que no exista dentro de la sede indicada.

        boolean noExisteProducto;

        for (DetalleFactura d : listaDetalles) {

            noExisteProducto = true;

            for (Producto prodSede : listaProdSede) {

                if (d.getProductoFacturado().equals(prodSede)) {
                    noExisteProducto = false;
                    break;
                }
            }

            if (noExisteProducto)
                throw new SedeException("El producto " + d.getProductoFacturado().getNombre() + " no se encuentra dentro de la sede " + sede.getNombre());
        }
    }

    /**
     * Método que crea una lista de Producto que contiene todos los productos de una lista de detalles
     * pasado en el argumento.
     *
     * @param listaDetalles
     * @return Lista de productos.
     */
    private ArrayList<Producto> obtenerProductoDetalles(ArrayList<DetalleFactura> listaDetalles) {

        ArrayList<Producto> list = new ArrayList<>();

        for (DetalleFactura d : listaDetalles) {
            list.add(d.getProductoFacturado());
        }
        return list;
    }

    private boolean sedeContieneProducto(String sedeID, String prodID) throws StringNuloOrVacioException {

        Producto prod = obtenerProducto(prodID);
        Sede sede = obtenerSede(sedeID);

        for (Producto p : sede.getListaProductos()) {
            if (p.equals(prod)) return true;
        }
        return false;
    }

    private boolean sedeContieneProducto(Sede sede, Producto producto) {

        for (Producto p : sede.getListaProductos()) {

            if (p.equals(producto))
                return true;
        }
        return false;
    }

    public static Producto clonarProducto(Producto p) {

        Producto clone = new Producto();

        clone.setId(p.getId());
        clone.setNombre(p.getNombre());
        clone.setPrecio(p.getPrecio());
        clone.setDescripcion(p.getDescripcion());
        clone.setImg(p.getImg());
        clone.setExistencias(p.getExistencias());
        clone.setCategoria(p.getCategoria());
        clone.setEmpresa(p.getEmpresa());

        return clone;
    }

    private boolean existeAdmin(Administrador administrador) {

        if (administrador == null) throw new NullPointerException("El administrador pasado es nulo");

        for (Administrador a : listaAdministradores) {

            if (a != null && a.equals(administrador))
                if (a != null && a.equals(administrador))
                    return true;
        }
        return false;
    }

    private void modificarNombreProdSedes(String nuevoNombre, Producto producto) {

        for (Sede s : listaSedes) {
            for (Producto p : s.getListaProductos()) {
                if (p.equals(producto))
                    p.setNombre(nuevoNombre);
            }
        }
    }

    private void modificarPrecioProdSedes(double nuevoPrecio, Producto producto) {

        for (Sede s : listaSedes) {
            for (Producto p : s.getListaProductos()) {
                if (p.equals(producto))
                    p.setPrecio(nuevoPrecio);
            }
        }
    }

    private void modificarDescripcionProdSedes(String nuevaDescripcion, Producto producto) {

        for (Sede s : listaSedes) {
            for (Producto p : s.getListaProductos()) {
                if (p.equals(producto))
                    p.setDescripcion(nuevaDescripcion);
            }
        }
    }

    private void modificarImagenProdSedes(Image nuevaImagen, Producto producto) {

        for (Sede s : listaSedes) {
            for (Producto p : s.getListaProductos()) {
                if (p.equals(producto))
                    p.setImg(nuevaImagen);
            }
        }
    }

    private void modificarCategoriaProdSedes(CategoriaProducto nuevaCategoria, Producto producto) {

        for (Sede s : listaSedes) {
            for (Producto p : s.getListaProductos()) {
                if (p.equals(producto))
                    p.setCategoria(nuevaCategoria);
            }
        }
    }


}