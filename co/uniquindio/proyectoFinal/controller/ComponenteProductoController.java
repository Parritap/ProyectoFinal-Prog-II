package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;
import co.uniquindio.proyectoFinal.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ComponenteProductoController {

	VistaPrincipalTiendaController vistaPrincipalTiendaController;
	Producto producto;
	
    @FXML
    private ImageView imgProducto;

    @FXML
    private Label txtDescripcionProducto;

    @FXML
    private Label txtNombreProducto;
    
    @FXML
    private Label txtPrecioProducto;

    @FXML
    void agregarAlCarrito(ActionEvent event) {

    	try {
    		
    		if (!vistaPrincipalTiendaController.cliente.getCarritoCompras().existeProducto(producto)) {
				
    			vistaPrincipalTiendaController.cliente.getCarritoCompras().crearDetalle(producto, 0);
    			
			}
    		
		} catch (NegativeNumberException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	
    }
    
    public void setearCamposProducto(Image image, String descripcion, String nombre, double precio){
    	
    	imgProducto.setImage(image);
    	txtDescripcionProducto.setText(descripcion);
    	txtNombreProducto.setText(nombre);
    	txtPrecioProducto.setText(Double.toString(precio));
    	
    }

	public void setearControladorVistaPrincipal(VistaPrincipalTiendaController vistaPrincipalTiendaController) {
		
		this.vistaPrincipalTiendaController = vistaPrincipalTiendaController;
		
	}
	
	public void setearProducto(Producto producto){
		
		this.producto = producto;
		
	}
}

