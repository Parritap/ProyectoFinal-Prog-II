package co.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.DetalleFactura;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ComponenteProductoCarritoController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	DetalleFactura detalle;
	Cliente cliente;
	CarritoComprasController carritoComprasController;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblNombreProducto;
    
    @FXML
    private Label lblPrecioProducto;

    @FXML
    private ImageView imgImagenProducto;

    @FXML
    private Label lblDescripcionProducto;

    
    @FXML
    private TextField txtCantidadProducto;

    @FXML
    void eliminarProductoCarrito(ActionEvent event) {

    	cliente.eliminarDetalleCarrito(detalle);
    	carritoComprasController.inicializarDatos();
    	
    }

    @FXML
    void initialize() {
        
    	
    }
    
    public void inicializarDatos(){
    	
    	lblNombreProducto.setText(detalle.getProductoFacturado().getNombre());
    	lblDescripcionProducto.setText(detalle.getProductoFacturado().getDescripcion());
    	lblPrecioProducto.setText(Double.toString(detalle.getProductoFacturado().getPrecio()));
    	imgImagenProducto.setImage(detalle.getProductoFacturado().getImg());
    	txtCantidadProducto.setText(Integer.toString(detalle.getCantidad()));
    	
    	txtCantidadProducto.textProperty().addListener((observable, oldValue, newValue) -> {
    		
    		try {
				
    			if (newValue != "") {
    			
    				detalle.setCantidad(Integer.parseInt(newValue));
    				
    			}
    			
			} catch (Exception e) {

				e.printStackTrace();
				
			}
    		
    	});
    	
    }
    
    public void setearDetalle(DetalleFactura detalle){
    	
    	this.detalle = detalle;
    
    }
    
    public void setearCliente(Cliente cliente){ this.cliente = cliente; }
    
    public void setearControladorCarrito(CarritoComprasController carritoComprasController){ this.carritoComprasController = carritoComprasController; }
}

