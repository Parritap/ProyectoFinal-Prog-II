package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.DatosEnvio;
import co.uniquindio.proyectoFinal.model.DetalleFactura;
import co.uniquindio.proyectoFinal.model.InformacionPago;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CarritoComprasController {

	Cliente cliente;
	Scene escenaAnterior;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<DatosEnvio> datoDeEnvio;

    @FXML
    private ChoiceBox<InformacionPago> informacionPago;

    @FXML
    private VBox vBoxComponentesProductoCarrito;

    @FXML
    void continuarCompra(ActionEvent event) {

    	if (datoDeEnvio.getSelectionModel().getSelectedItem() != null && informacionPago.getSelectionModel().getSelectedItem() != null) {
			
//    		desplegarAlerta();
    		//comprar productos
    		
		} else {
			
//			desplegarAlerta();
			
		}
    	
    }

    @FXML
    void cancelarCompra(ActionEvent event) {

    	Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	thisStage.setScene(escenaAnterior);
    	
    }

    //crear un metodo que reciba un producto y me retorne una lista de sedes en la que est� ese producto
    @FXML
    void initialize() {
    	
    }
    
    public void inicializarDatos(){
    	
    	datoDeEnvio.getItems().addAll(cliente.getListaDatosEnvio());
    	informacionPago.getItems().addAll(cliente.getListaInfoPago());
    	
    	for (DetalleFactura detalle : cliente.getCarritoCompras().getListaDetalles()) {
			
    		try {
    			
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ComponenteProductoCarrito.fxml"));
    			AnchorPane root = loader.load();
    			
    			ComponenteProductoCarritoController componenteProductoCarritoController = loader.getController();
    			componenteProductoCarritoController.setearDetalle(detalle);
    			componenteProductoCarritoController.setearCliente(cliente);
    			componenteProductoCarritoController.setearControladorCarrito(this);
    			componenteProductoCarritoController.inicializarDatos();
    			
				vBoxComponentesProductoCarrito.getChildren().add(root);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	
    }
    
    public void setearCliente(Cliente cliente){
    	
    	this.cliente = cliente;
    	
	}
    
    public void setearEscenaAnterior(Scene escenaAnterior){ this.escenaAnterior = escenaAnterior; }
    
}
