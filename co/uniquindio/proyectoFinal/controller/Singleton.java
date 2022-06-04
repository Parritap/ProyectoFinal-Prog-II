package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Sede;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;

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
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
