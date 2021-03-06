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
        // El constructor de Singleton puede ser llamado desde aqu? al ser protected
        private final static Singleton eINSTANCE = new Singleton();

    }

    // M?todo para obtener la instancia de nuestra clase
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


            empresa.crearProducto("456", "reproductor mp3", 5000, "un reproductor mp3 para escuchar la quemona", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/reproductorMusica.jpg")), 100, CategoriaProducto.MUSICA);
            empresa.crearProducto("123", "televisor", 5000, "Televisor HD-4k para jugar minecraft", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/tv.jpg")), 100, CategoriaProducto.HOGAR);
            empresa.crearProducto("369", "pc-gamer", 9999, "Pc gamer que corre nuestros super-programas a 999 fps ", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/pcGamer.jpg")), 100, CategoriaProducto.TECNOLOGIA_COMPUTACIONAL);
            empresa.crearProducto("122", "celular NOVEDOSO", 2, "Celular del fut?ro", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/celular.jpg")), 100, CategoriaProducto.TECNOLOGIA_MOVIL);
            empresa.crearProducto("987", "Servidor empresarial", 7000, "Servidor ultra r?pido", new Image(getClass().getResourceAsStream("../view/imagenesProyecto/servidor.jpg")), 100, CategoriaProducto.EMPRESARIALES);
            
            empresa.crearCliente("Juan", "Armenia - Norte", "0000", TipoDocumento.CEDULA, "cliente@cliente.com", "cliente", "2004-12-10", "quimbaya", "quindio");
            empresa.crearCliente("Anna", "Calarc? - Centro", "111", TipoDocumento.TARJETA_IDENTIDAD, "anne@gmail.com", "anne", "2001-03-23", "Londres", "UK");
            empresa.crearCliente("Max", "Reino Unido - La Rue Street", "222", TipoDocumento.CEDULA_EXTRANJERIA, "max@gmail.com", "max", "2001-03-22", "Londres", "UK");

            empresa.crearAdministrador("0000", "Administrador General", "000000", "nn", "admin@admin.com", "admin", "2000-01-01", "nn", TipoDocumento.CEDULA);
            empresa.crearSede("los robles", "123", Ciudad.ARMENIA, "0000");

            empresa.crearAdministrador("1111", "carlos", "123", "calle 29", "carlos@gmail.com", "carlos123", "1990-02-10", "Union Europea", TipoDocumento.CEDULA_EXTRANJERIA);
            empresa.crearSede("naranjos", "234", Ciudad.BOGOTA, "1111");

            empresa.crearAdministrador("2222", "juan", "234", "calle 21", "juan@gmail.com", "juan234", "1999-02-10", "Nueva Zelanda", TipoDocumento.CEDULA);
            empresa.crearSede("bolivar", "345", Ciudad.MEDELLIN, "2222");
            
            
            
            
			
			
            //Tenemos que agregart productos a la Sede. Agregar? 30 productos a todas las sedes.
            //Recordar que cuando agregamos un producto a la sede, el m?todo agregarProductosSede se encarga
            // de disminuir la cantidad agregada a las existencias de empresa. Por lo tanto, en este caso, la empresa
            //Quedar? con unas existencias de 10 de cada producto, puesto que sete? las existencias a 100 en las l?neas 50 y 51.

            Producto producto1 = empresa.obtenerProducto("123");
            Producto producto2 = empresa.obtenerProducto("456");
            Producto producto3 = empresa.obtenerProducto("369");
            Producto producto4 = empresa.obtenerProducto("122");
            Producto producto5 = empresa.obtenerProducto("987");
            
            

            Sede sede = empresa.obtenerSede("123");


            empresa.agregarProductosSede(producto1, 30, sede);
            empresa.agregarProductosSede(producto1, 30, sede);
            empresa.agregarProductosSede(producto3, 30, sede);
            empresa.agregarProductosSede(producto4, 30, sede);
            empresa.agregarProductosSede(producto5, 30, sede);
            

            empresa.agregarProductosSede(producto2, 30, sede);
            empresa.agregarProductosSede(producto2, 30, sede);

            empresa.agregarProductosSede(producto1, 30, sede);
            empresa.agregarProductosSede(producto2, 30, sede);


            //El siguiente bloque de c?digo crear? una serie de facturas para testear la vista VerFacturas.

            ArrayList<DetalleFactura> listaDetalle1 = new ArrayList<>();
            listaDetalle1.add(new DetalleFactura(empresa.obtenerProducto("123"), 2));
            listaDetalle1.add(new DetalleFactura(empresa.obtenerProducto("123"), 5));

            ArrayList<DetalleFactura> listaDetalle2 = new ArrayList<>();
            listaDetalle2.add(new DetalleFactura(empresa.obtenerProducto("456"), 1));
            listaDetalle2.add(new DetalleFactura(empresa.obtenerProducto("456"), 2));

            ArrayList<DetalleFactura> listaDetalle3 = new ArrayList<>();
            listaDetalle3.add(new DetalleFactura(empresa.obtenerProducto("123"), 10));
            listaDetalle3.add(new DetalleFactura(empresa.obtenerProducto("456"), 12));

            //Creaci?n del los datos de envio
            empresa.obtenerCliente("cliente@cliente.com").crearDatosEnvio("Armenia", "Unicentro", "Don Parra", "3243585508");

            //Creaci?n de la informaci?n de pago.
            empresa.obtenerCliente("cliente@cliente.com").crearInformacionPago("1000-0000-000", "Juan Parra", "101", "2030-10-10", MetodoPago.CREDITO);

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
