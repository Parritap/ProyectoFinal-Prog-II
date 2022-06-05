package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;
import co.uniquindio.proyectoFinal.exceptions.ProductoException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.scene.image.Image;

public class Singleton{

	Empresa empresa;


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

		Administrador admin = new Administrador("0000", "Administrador General",  "000000", "nn",
				"admin@admin.com", "admin", "1-01-2000", "nn", TipoDocumento.CEDULA, null);

		empresa.getListaAdministradores().add(admin);
		
		//inicializar datos de prueba
		
		try {
			empresa.crearCliente("juan", "Nueva York", "12345678", "cliente@cliente.com", "cliente", "10/12/2004", "quimbaya", "quindio");
			try {
				empresa.crearProducto("123", "leche", 5000, "caja de leche de 120ml", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/Admin.png")), 32, CategoriaProducto.HOGAR);
			} catch (ProductoException e) {
				e.printStackTrace();
			}
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
}
