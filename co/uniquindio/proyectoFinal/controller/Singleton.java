package co.uniquindio.proyectoFinal.controller;

import java.util.ArrayList;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.exceptions.EmailYaRegistradoException;
import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;
import co.uniquindio.proyectoFinal.exceptions.ProductoException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.DatosEnvio;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.InformacionPago;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import co.uniquindio.proyectoFinal.model.enums.Ciudad;
import co.uniquindio.proyectoFinal.model.enums.MetodoPago;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.scene.image.Image;

public class Singleton{

	Empresa empresa;
	Cliente cliente;


	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static Singleton eINSTANCE = new Singleton();
	}

	// Método para obtener la instancia de nuestra clase
	public static Singleton getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public Singleton() {

		inicializarDatos();
	}


	private void inicializarDatos() {

		empresa = new Empresa("Tiendas Quindio", "1227642");
		
		//inicializar datos de prueba
		
		try {
			
			empresa.crearCliente("Juan", "Armenia - Norte", "0000", TipoDocumento.CEDULA,"cliente@cliente.com", "cliente", "2004-12-10", "quimbaya", "quindio");
			empresa.crearCliente("Anna", "Calarcá - Centro", "111",TipoDocumento.TARJETA_IDENTIDAD, "anne@gmail.com", "anne", "2001-03-23", "Londres", "UK");
			empresa.crearCliente("Max", "Reino Unido - La Rue Street", "222", TipoDocumento.CEDULA_EXTRANJERIA, "max@gmail.com", "max", "2001-03-22", "Londres", "UK");
			
			empresa.crearAdministrador("0000", "Administrador General",  "000000", "nn",
					"admin@admin.com", "admin", "2000-01-01", "nn", TipoDocumento.CEDULA);
			empresa.crearSede("los robles", "123", Ciudad.ARMENIA, "0000");
			
			empresa.crearAdministrador("1111", "carlos", "123", "calle 29", "carlos@gmail.com", "carlos123", "1990-02-10", "Union Europea", TipoDocumento.CEDULA_EXTRANJERIA);
			empresa.crearSede("naranjos", "234", Ciudad.BOGOTA, "1111");
			
			empresa.crearAdministrador("2222", "juan", "234", "calle 21", "juan@gmail.com", "juan234", "1999-02-10", "Nueva Zelanda", TipoDocumento.CEDULA);
			empresa.crearSede("bolivar", "345", Ciudad.MEDELLIN, "2222");
			
			cliente.crearInformacionPago("1234", "benito", "369", "2022/09/20", MetodoPago.CREDITO);
			cliente.crearInformacionPago("145", "armando casas", "2345", "2022/09/29", MetodoPago.DEBITO);
			
			try {
				empresa.crearProducto("456", "frijol", 5000, "frijol de grano grande", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/prestamo.jpg")), 26, CategoriaProducto.MUSICA);
				empresa.crearProducto("123", "leche", 5000, "caja de leche de 120ml", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/Admin.png")), 32, CategoriaProducto.HOGAR);
			} catch (ProductoException e) {
				e.printStackTrace();
			}
			
			empresa.obtenerSede("123").getListaProductos().add(empresa.obtenerProducto("123"));
			empresa.obtenerSede("123").getListaProductos().add(empresa.obtenerProducto("456"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public ArrayList <Cliente> obtenerListaClientes (){
		return empresa.getListaClientes();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public ArrayList<InformacionPago> obtenerListaInformacionPago(){
	
		return cliente.getListaInfoPago();
	}
	public ArrayList <DatosEnvio> obtenerListaDatosEnvio (){
		return cliente.getListaDatosEnvio();
	}
	public void eliminarInformacionPago (InformacionPago infoPago){
		cliente.eliminarInfoPago(infoPago);
	}

	public InformacionPago actualizarInformacionPago(InformacionPago infoPagoAntigua ,String nuevoNumTarjeta, String nuevoTitular, String nuevoCodigoSeg, String nuevaFechaVecnimientoTarjeta, MetodoPago metodoPago) {
		InformacionPago infoPago= new InformacionPago();
		infoPago = cliente.actualizarInfoPago( infoPagoAntigua , nuevoNumTarjeta, nuevoTitular, nuevoCodigoSeg, nuevaFechaVecnimientoTarjeta, metodoPago);
		return infoPago;
		
	}

	public DatosEnvio actualizarDatosEnvio(DatosEnvio datos, String nuevoCodigo, String nuevoDomicilio, String nuevoDestinatario, String nuevoTel) {
		DatosEnvio datosEnvio = new DatosEnvio();
		datosEnvio = cliente.actualizarDatosEnvio(datos, nuevoCodigo, nuevoDomicilio, nuevoDestinatario, nuevoTel);
		
		return datosEnvio;
	}

	public void eliminarDatosEnvio(DatosEnvio datos) {
		cliente.eliminarDatosEnvio(datos);
	}

	
}
