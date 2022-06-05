package co.uniquindio.proyectoFinal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Factura {

    private String codigo;
    private String fecha;
    private double total;
    private double subtotal;
    private double iva;



    private Empresa empresa;
    private Cliente cliente;
    private ArrayList<DetalleFactura> listaDetalles;
    private DatosEnvio datosEnvio;
    private InformacionPago informacionPago;

    private Sede sede;


    //Constructores -----------------------------------------------------------------------------------------------------------------------------------------------------------------


    public Factura(String codigo, String fecha, double total, double subtotal, double iva, Empresa empresa, Cliente cliente, ArrayList<DetalleFactura> listaDetalles, DatosEnvio datosEnvio, InformacionPago informacionPago, Sede sede) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.empresa = empresa;
        this.cliente = cliente;
        this.listaDetalles = listaDetalles;
        this.datosEnvio = datosEnvio;
        this.informacionPago = informacionPago;
        this.sede = sede;
    }

    public Factura(String codigo, String fecha, double total, double subtotal, double iva, Sede sede, Empresa empresa, Cliente cliente, DatosEnvio datosEnvio, InformacionPago informacionPago) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.subtotal = subtotal;
        this.iva = iva;
        this.sede = sede;
        this.empresa = empresa;
        this.cliente = cliente;
        this.datosEnvio = datosEnvio;
        this.informacionPago = informacionPago;
    }

    //Constructor Vacio
    public Factura() {
    }

    //Getters & Setters-----------------------------------------------------------------------------------------------------------------------------------------------------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(DatosEnvio datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public InformacionPago getInformacionPago() {
        return informacionPago;
    }

    public void setInformacionPago(InformacionPago informacionPago) {
        this.informacionPago = informacionPago;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    //Equals HashCode and ToString-------------------------------------------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(codigo, factura.codigo) && Objects.equals(fecha, factura.fecha) && Objects.equals(cliente, factura.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, fecha, cliente);
    }
    /**
     * Método que define las veces que aparece un producto en cada detalle 
     * dado el nombre de un producto
     * @param nombreProducto
     * @return
     */
	public int definirVecesEstaProducto(String nombreProducto) {
		int vecesProducto = 0;
		for (int i = 0; i < listaDetalles.size(); i++) {
			if (listaDetalles.get(i).obtenerNombreProductoFacturado ().equals(nombreProducto)){
				vecesProducto += listaDetalles.get(i).getCantidad();
			}
		}
		return vecesProducto;
	}
}
