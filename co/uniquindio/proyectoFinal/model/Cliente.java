package co.uniquindio.proyectoFinal.model;


import co.uniquindio.proyectoFinal.Utilidades.MyUtils;
import co.uniquindio.proyectoFinal.exceptions.DatosEnvioException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.enums.MetodoPago;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    private String nombre;
    private String direccion;
    private String documento;
    private TipoDocumento tipoDocumento;
    private String email;
    private String contrasenia;
    private String fechaNacimiento;
    private String ciudad;
    private String departamento;
    private ArrayList<InformacionPago> listaInfoPago = new ArrayList<>();
    private ArrayList<DatosEnvio> listaDatosEnvio = new ArrayList<>();
    private CarritoCompras carritoCompras = new CarritoCompras();
    private ArrayList<Factura> listaFacturas = new ArrayList<>();


    //Constructores----------------------------------------------------------------------------------------------------------------------------

    /**
     * Constructor que incluye también listaDatosEnvio como parámetro.
     * El carrito de compras se instancia al crear el Cliente con este constructor, por lo que no hay peligro de un NullPointerException
     *
     * @param nombre
     * @param direccion
     * @param documento
     * @param email
     * @param fechaNacimiento
     * @param ciudad
     * @param departamento
     * @param listaDatosEnvio
     */
    public Cliente(String nombre, String direccion, String documento,TipoDocumento tipoDoc, String email, String contrasenia,
                   String fechaNacimiento, String ciudad, String departamento,
                   ArrayList<InformacionPago> listaInfoPago, ArrayList<DatosEnvio> listaDatosEnvio) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.documento = documento;
        this.tipoDocumento = tipoDoc;
        this.email = email;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.carritoCompras = new CarritoCompras();
        this.listaDatosEnvio = listaDatosEnvio;
        this.listaInfoPago = listaInfoPago;

        this.listaDatosEnvio.add(generarDatosEnvioPorDefecto()); //Genera unos datos de envío por defecto al crear el Cliente.
    }
    //constructor vacío.
    public Cliente() {
    }

    public Cliente (String nombre, String documento, String email){
        this.nombre = nombre;
        this.email = email;
        this.documento= documento;
    }


    /**
     * @param nombre
     * @param direccion
     * @param documento
     * @param email
     * @param fechaNacimiento
     * @param ciudad
     * @param departamento
     */
    public Cliente(String nombre, String direccion, String documento, TipoDocumento tipoDocumento, String email,String contrasenia,
                   String fechaNacimiento, String ciudad, String departamento) {
    	this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.documento = documento;
        this.email = email;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.listaInfoPago = new ArrayList<>();
        this.carritoCompras = new CarritoCompras();
        this.listaDatosEnvio = new ArrayList<>();
        //this.listaDatosEnvio.add(generarDatosEnvioPorDefecto()); //Genera unos datos de envío por defecto al crear el Cliente, aunque aún me queda la duda de si este método funciona...

    }

    public Cliente(String email) {
        this.email = email;
    }



    //Getters & Setters ------------------------------------------------------------------------------------------------------


    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public ArrayList<InformacionPago> getListaInfoPago() {
        return listaInfoPago;
    }

    public void setListaInfoPago(ArrayList<InformacionPago> listaInfoPago) {
        this.listaInfoPago = listaInfoPago;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //equals & HashCode -------------------------------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento, email);
    }

    @Override
    public String toString() {
        return documento;
    }

    //CRUD DATOSENVIO -----------------------------------------------------------------------------------------------------------------------------------

    public DatosEnvio generarDatosEnvioPorDefecto() {
        return new DatosEnvio("", ciudad, direccion, nombre, "000000000", this);
    }

    /**
     * Método que crea datos de envío con todos los parámetros encontrados en DatosEnvio.
     *
     * @param codigo
     * @param ciudad
     * @param domicilio
     * @param destinatario
     * @param telefono
     * @throws StringNuloOrVacioException
     * @throws DatosEnvioException
     */
    public void crearDatosEnvio(String codigo, String ciudad, String domicilio, String destinatario, String telefono) throws StringNuloOrVacioException, DatosEnvioException {

        //NOTA: Un dato es igual a otro cuando su ciudad, domicilio y destinatario son iguales.

        if (MyUtils.esNuloOrVacio(codigo, ciudad, domicilio, destinatario, telefono)) {

            if (existeDatoEnvio(codigo))
                throw new DatosEnvioException("Ya existe un DatosEnvio con el código " + codigo + "");


            DatosEnvio datos = new DatosEnvio(codigo, ciudad, domicilio, destinatario, telefono, this);

            if (esDatoEnvioUnico(datos)) { //Este método utiliza el .equals de DatosEnvio, el cual nó compara por codigo.
                this.listaDatosEnvio.add(datos);


            } else {
                throw new DatosEnvioException("Ya existe algún dato de envío con la misma ciudad, domicilio y destinatario");
            }


        } else {
            throw new DatosEnvioException("Hay algún parámetro vacío");
        }
    }


    /**
     * Método que crea un DatoEnvio PERO SIN CODIGO.
     * NOTA: Dos datos de envio son iguales si sus datos iguales si su ciudad, domicilio y destinatario son iguales.
     *
     * @param ciudad
     * @param domicilio
     * @param destinatario
     * @param telefono
     * @return 
     * @throws StringNuloOrVacioException
     * @throws DatosEnvioException
     */
    public DatosEnvio crearDatosEnvio(String ciudad, String domicilio, String destinatario, String telefono) throws StringNuloOrVacioException, DatosEnvioException {

        MyUtils.validarSiNuloOrVacio(ciudad, domicilio, destinatario, telefono);

        DatosEnvio datos = new DatosEnvio(ciudad, domicilio, destinatario, telefono, this);

        if (esDatoEnvioUnico(datos)) { //Este método utiliza el .equals de DatosEnvio, el cual nó compara por codigo.
            this.listaDatosEnvio.add(datos);


        } else {
            throw new DatosEnvioException("Ya existe algún dato de envío con la misma ciudad, domicilio y destinatario");
        }
		return datos;
		
    }

    /**
     * Método que obtiene los datos de envio de un cliente dado su código.
     *
     * @param codigo String a buscar dentro de los DatosEnvio de un cliente.
     * @return Null de no encontrar ninguno con el codigo indicado
     */
    public DatosEnvio obtenerDatosEnvioByCodigo(String codigo) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(codigo);

        for (DatosEnvio d : listaDatosEnvio) {

            if (d != null && d.getCodigo() != null && d.getCodigo().equals(codigo))
                return d;
        }
        return null;
    }

    /**
     * Método que obtiene los datos de envio de un cliente, buscando por domicilio.
     *
     * @param domicilio String a buscar dentro de los DatosEnvio de un cliente.
     * @return Null de no encontrar ninguno con el domicilio indicado.
     * @throws StringNuloOrVacioException
     */
    public DatosEnvio obtenerDatosEnvioByDomicilio(String domicilio) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(domicilio);

        for (DatosEnvio d : listaDatosEnvio) {

            if (d != null && d.getDomicilio() != null && d.getDomicilio().equals(domicilio))
                return d;
        }
        return null;
    }


    /**
     * Método que actualiza los atributos de DatosEnvio. Este método recibe como parámetro el objeto DatosEnvio.
     *
     * @param datos
     * @param nuevoCodigo
     * @param nuevoDomicilio
     * @param nuevoDestinatario
     * @param nuevoTel
     * @return 
     */
    public void actualizarDatosEnvio(DatosEnvio datos, String nuevoDomicilio, String ciudad, String nuevoDestinatario, String nuevoTel) {
    	
    	if (verificarDatosCorrectosDatosEnvio(datos,nuevoDomicilio,ciudad,nuevoDestinatario,nuevoTel)){
    	datos.setCiudad(ciudad);
    	datos.setDestinatario(nuevoDestinatario);
    	datos.setDomicilio(nuevoDomicilio);
    	datos.setTelefono(nuevoTel);
    	}
    	

    }

    private boolean verificarDatosCorrectosDatosEnvio(DatosEnvio datos, String nuevoDomicilio, String ciudad, String nuevoDestinatario, String nuevoTel) {
		boolean todoBien = false;
		if (datos != null){
			if (verificarString(nuevoDomicilio) && verificarString(ciudad) && 
					verificarString( nuevoDestinatario) && verificarString (nuevoTel)){
				todoBien = true;
			}
		}
		return todoBien;
	}
	private boolean verificarString(String cadena) {
		boolean stringValido = true;
		
		if (cadena.equals("")){
			stringValido = false;
		}
		return stringValido;
	}
	public void eliminarDatosEnvio(DatosEnvio datos) {

        for (int i = 0; i < listaDatosEnvio.size(); i++) {
			if (listaDatosEnvio.get(i).equals(datos)){
				listaDatosEnvio.remove(i);
			}
		}
    }


    //CRUD InformacionPago-------------------------------------------------------------------------------------------------------------------------

    public InformacionPago crearInformacionPago(String numTarjeta, String titularTarjeta, String codigoSeguridadTarjeta, String fechaVencimientoTarjeta, MetodoPago metodoPago) throws StringNuloOrVacioException {

        MyUtils.validarSiNuloOrVacio(numTarjeta, titularTarjeta, codigoSeguridadTarjeta, fechaVencimientoTarjeta);

        if (metodoPago == null)
            throw new NullPointerException("El método de pago pasado es nulo");

        InformacionPago infoPago = new InformacionPago(numTarjeta, titularTarjeta, codigoSeguridadTarjeta, fechaVencimientoTarjeta, metodoPago);

        this.listaInfoPago.add(infoPago);
		return infoPago;
    }

    /**
     * Método que obtiene la información de pago mediante el numero de tarjeta.
     *
     * @param numeroTarjeta
     * @return Null de no encontrar ninguna información de pago con tal numero de tarjeta.
     */
    public InformacionPago obtenerinfoPago(String numeroTarjeta) {

        for (InformacionPago i : listaInfoPago) {

            if (i != null && i.getNumeroTarjeta() != null & i.getNumeroTarjeta().equals(numeroTarjeta))
                return i;
        }
        return null;
    }

    public InformacionPago actualizarInfoPago(InformacionPago infoPago, String nuevoNumTarjeta, String nuevoTitular, String nuevoCodigoSeg, String nuevaFechaVecnimientoTarjeta, MetodoPago metodoPago) {

    	for (InformacionPago i : listaInfoPago) {

    		if (i.equals(infoPago)) {

    			if (!nuevoNumTarjeta.equals(""))
    				i.setNumeroTarjeta(nuevoNumTarjeta);

    			if (!nuevoTitular.equals(""))
    				i.setTitularTarjeta(nuevoTitular);

    			if (!nuevoCodigoSeg.equals(""))
    				i.setCodigoSeguridadTarjeta(nuevoCodigoSeg);

    			if (!nuevaFechaVecnimientoTarjeta.equals(""))
    				i.setFechaVencimientoTarjeta(nuevaFechaVecnimientoTarjeta);
    			infoPago.setMetodoPago(metodoPago);
    		}
    		
    	}
		return infoPago;
    }

    public void eliminarInfoPago(InformacionPago infoPago) {

        for (int i = 0; i < listaInfoPago.size(); i++) {
        	
			if (listaInfoPago.get(i).equals(infoPago)){
				listaInfoPago.remove(i);
			}
                
		} 

        
    }


    //CRUD CARRITOCOMPRAS ------------------------------------------------------------------------------------------------

    //En la vida, supuse que en realidad, cuando agregamos un producto al carrito, en realidad, lo que agregamos es
    // DetalleFactura, pues los atributos de este último son Producto y Cantidad.

    //El crear se hace inmediatamente se crea el cliente
    //Nunca debemos de eliminar el carrito de compras, simplemente lo limpiamos después de cada compra.

    public void agregarDetalleCarrito(DetalleFactura detalle) {
        this.carritoCompras.getListaDetalles().add(detalle);
    }

    public void eliminarDetalleCarrito(DetalleFactura detalle) {
        this.carritoCompras.getListaDetalles().remove(detalle);
    }

    public void limpiarCarrito() {
        this.carritoCompras = new CarritoCompras();
    }

    //MÉTODOS --------------------------------------------------------------------------------------------------

    /**
     * Método que verifica si el dato (Object) pasado en el argumento es unico o no. Se usa el .equals de DatosEnvio.
     * Un dato es igual a otro cuando su ciudad, domicilio y destinatario son iguales.
     *
     * @param dato DatosEnvio a comparar.
     * @return True si el dato pasado en el argumento es único. False de lo contario.
     */
    private boolean esDatoEnvioUnico(DatosEnvio dato) {

        for (DatosEnvio d : listaDatosEnvio) {
            if (d.equals(dato))
                return false;
        }
        return true;
    }

    private boolean existeDatoEnvio(String codigo) throws StringNuloOrVacioException {

        for (DatosEnvio d : listaDatosEnvio) {

            if (d != null && d.getCodigo() != null && d.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    
}
