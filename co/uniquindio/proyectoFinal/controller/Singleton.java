package co.uniquindio.proyectoFinal.controller;

import java.util.ArrayList;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.exceptions.EmailYaRegistradoException;
import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;
import co.uniquindio.proyectoFinal.exceptions.ProductoException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.*;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import co.uniquindio.proyectoFinal.model.enums.Ciudad;
import co.uniquindio.proyectoFinal.model.enums.MetodoPago;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Singleton {

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

        //inicializar datos de prueba

        try {


            empresa.crearProducto("456", "Frijol", 5000, "Frijol de grano grande", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/prestamo.jpg")), 1000, CategoriaProducto.MUSICA);
            empresa.crearProducto("123", "Leche", 5000, "Caja de leche de 120ml", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/Admin.png")), 1000, CategoriaProducto.HOGAR);


            empresa.crearCliente("Juan", "Armenia - Norte", "0000", TipoDocumento.CEDULA, "cliente@cliente.com", "cliente", "2004-12-10", "quimbaya", "quindio");
            empresa.crearCliente("Anna", "Calarcá - Centro", "111", TipoDocumento.TARJETA_IDENTIDAD, "anne@gmail.com", "anne", "2001-03-23", "Londres", "UK");
            empresa.crearCliente("Max", "Reino Unido - La Rue Street", "222", TipoDocumento.CEDULA_EXTRANJERIA, "max@gmail.com", "max", "2001-03-22", "Londres", "UK");

            empresa.crearAdministrador("0000", "Administrador General", "000000", "nn", "admin@admin.com", "admin", "2000-01-01", "nn", TipoDocumento.CEDULA);
            empresa.crearSede("los robles", "123", Ciudad.ARMENIA, "0000");

            empresa.crearAdministrador("1111", "carlos", "123", "calle 29", "carlos@gmail.com", "carlos123", "1990-02-10", "Union Europea", TipoDocumento.CEDULA_EXTRANJERIA);
            empresa.crearSede("naranjos", "234", Ciudad.BOGOTA, "1111");

            empresa.crearAdministrador("2222", "juan", "234", "calle 21", "juan@gmail.com", "juan234", "1999-02-10", "Nueva Zelanda", TipoDocumento.CEDULA);
            empresa.crearSede("bolivar", "345", Ciudad.MEDELLIN, "2222");
            
            
            
            
			
			
            //Tenemos que agregart productos a la Sede. Agregaré 30 productos a todas las sedes.
            //Recordar que cuando agregamos un producto a la sede, el método agregarProductosSede se encarga
            // de disminuir la cantidad agregada a las existencias de empresa. Por lo tanto, en este caso, la empresa
            //Quedará con unas existencias de 10 de cada producto, puesto que seteé las existencias a 100 en las líneas 50 y 51.


            empresa.agregarProductosSede("123", 30, "123");
            empresa.agregarProductosSede("456", 30, "123");

            empresa.agregarProductosSede("123", 30, "234");
            empresa.agregarProductosSede("456", 30, "234");

            empresa.agregarProductosSede("123", 30, "345");
            empresa.agregarProductosSede("456", 30, "345");


            //El siguiente bloque de código creará una serie de facturas para testear la vista VerFacturas.

            ArrayList<DetalleFactura> listaDetalle1 = new ArrayList<>();
            listaDetalle1.add(new DetalleFactura(empresa.obtenerProducto("123"), 2));
            listaDetalle1.add(new DetalleFactura(empresa.obtenerProducto("456"), 5));

            ArrayList<DetalleFactura> listaDetalle2 = new ArrayList<>();
            listaDetalle2.add(new DetalleFactura(empresa.obtenerProducto("123"), 1));
            listaDetalle2.add(new DetalleFactura(empresa.obtenerProducto("456"), 2));

            ArrayList<DetalleFactura> listaDetalle3 = new ArrayList<>();
            listaDetalle3.add(new DetalleFactura(empresa.obtenerProducto("123"), 10));
            listaDetalle3.add(new DetalleFactura(empresa.obtenerProducto("456"), 12));

            //Creación del los datos de envio
            empresa.obtenerCliente("cliente@cliente.com").crearDatosEnvio("Armenia", "Unicentro", "Don Parra", "3243585508");

            //Creación de la información de pago.
            empresa.obtenerCliente("cliente@cliente.com").crearInformacionPago("1000-0000-000", "Juan Parra", "101", "10/10/2030", MetodoPago.CREDITO);

            empresa.crearFactura(empresa.obtenerCliente("cliente@cliente.com"), empresa.obtenerSede("123"), listaDetalle1, empresa.obtenerCliente("cliente@cliente.com").getListaDatosEnvio().get(0), empresa.obtenerCliente("cliente@cliente.com").getListaInfoPago().get(0));

            empresa.crearFactura(empresa.obtenerCliente("cliente@cliente.com"), empresa.obtenerSede("123"), listaDetalle2, empresa.obtenerCliente("cliente@cliente.com").getListaDatosEnvio().get(0), empresa.obtenerCliente("cliente@cliente.com").getListaInfoPago().get(0));

            empresa.crearFactura(empresa.obtenerCliente("cliente@cliente.com"), empresa.obtenerSede("123"), listaDetalle3, empresa.obtenerCliente("cliente@cliente.com").getListaDatosEnvio().get(0), empresa.obtenerCliente("cliente@cliente.com").getListaInfoPago().get(0));
            
        } catch (Exception e) {
            e.printStackTrace();
        } catch (ProductoException e) {
            throw new RuntimeException(e);
        }

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
