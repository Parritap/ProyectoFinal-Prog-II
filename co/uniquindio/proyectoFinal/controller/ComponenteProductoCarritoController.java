package co.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.DetalleFactura;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Sede;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ComponenteProductoCarritoController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	DetalleFactura detalle;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblNombreProducto;

    @FXML
    private ImageView imgImagenProducto;

    @FXML
    private Label lblDescripcionProducto;

    @FXML
    private ChoiceBox<Sede> choiceSedesProductoDisponible;

    @FXML
    void eliminarProductoCarrito(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    	//choiceSedesProductoDisponible.getItems().addAll(empresa.obtenerSedes(detalle.getProductoFacturado()));
    	
    }
    
    public void setearDetalle(DetalleFactura detalle){
    	
    	this.detalle = detalle;
    	
    }
}

