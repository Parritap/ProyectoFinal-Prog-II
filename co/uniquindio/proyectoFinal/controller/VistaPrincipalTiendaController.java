package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VistaPrincipalTiendaController {

	Cliente cliente;
	Empresa empresa = Singleton.getInstance().getEmpresa();
	
    @FXML
    private VBox vBoxComponentesProductos;

    @FXML
    private TextField txtBuscarProductoCliente;

    @FXML
    void filtrarProductosPorCategoria(ActionEvent event) {

    	crearYDesplegarVentanaModalFiltros();
    	
    }

	@FXML
    void abrirCarritoDeCompras(ActionEvent event) {

    	try {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CarritoCompras.fxml"));
			AnchorPane root = loader.load();
			
			CarritoComprasController carritoComprasController = loader.getController();
			carritoComprasController.setearCliente(cliente);
			carritoComprasController.inicializarDatos();
			
			Scene scene = ((Node) event.getSource()).getScene();
			carritoComprasController.setearEscenaAnterior(scene);
			
			Stage thisStage = (Stage) scene.getWindow();
			thisStage.setScene(new Scene(root));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void abrirDatosEnvioCliente(ActionEvent event) {

    }

    @FXML
    void abrirInformacionPagoCliente(ActionEvent event) {

    }

    @FXML
    void abrirInformacionCuentaCliente(ActionEvent event) {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/InformacionCliente.fxml"));
    	try {
    		
			AnchorPane root = loader.load();
			InformacionClienteController informacionClienteController = loader.getController();
			
			informacionClienteController.setearCliente(cliente);
			informacionClienteController.setearBeforeScene(((Node) event.getSource()).getScene());
			
			Scene scene = new Scene(root);
			
			Stage thisStage = (Stage)(((Node) event.getSource()).getScene().getWindow());
			thisStage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void abrirFacturasCliente(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    	txtBuscarProductoCliente.textProperty().addListener((observable, oldValue, newValue) -> {
    		
    		vBoxComponentesProductos.getChildren().clear();
    		for (Producto producto : empresa.getListaProductos()) {
				
    			if (producto.getNombre().contains(newValue)) {
					
    				crearComponente(producto);
    				
				}
    			
			}
    		
    	});
    }
    
    public void inicializarDatos(){
    	
    	for (int i = 0; i < empresa.getListaProductos().size(); i++) {
			
    		crearComponente(empresa.getListaProductos().get(i));
    		
		}
    	
    }
    
    public void filtrarProductos(CategoriaProducto categoria){
    	
    	for (int i = 0; i < empresa.getListaProductos().size(); i++) {
			
    		if (empresa.getListaProductos().get(i).getCategoria().equals(categoria)) {
		
    			crearComponente(empresa.getListaProductos().get(i));
    			
    		}
		}
    }
    
    private void crearYDesplegarVentanaModalFiltros() {

    	ToggleGroup group = new ToggleGroup();
    	VBox opcionesFiltrar = new VBox(8);
    	
    	for (CategoriaProducto categoria : CategoriaProducto.values()) {
			
    		RadioButton button = new RadioButton(categoria.toString());
    		button.setToggleGroup(group);
    		opcionesFiltrar.getChildren().add(button);
    		
		}
    	
    	RadioButton button = new RadioButton("TODO");
    	button.setToggleGroup(group);
    	button.setSelected(true);
    	
    	opcionesFiltrar.getChildren().add(button);
    	
    	Stage stage = new Stage();
    	
    	Button buttonAceptarFiltrar = new Button("aceptar");
    	buttonAceptarFiltrar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				if (!((RadioButton) group.getSelectedToggle()).getText().equals("TODO")) {
					
					vBoxComponentesProductos.getChildren().clear();
		    		for (Producto producto : empresa.getListaProductos()) {
						
		    			if (producto.getCategoria().toString().equals(((RadioButton) group.getSelectedToggle()).getText())) {
							
		    				crearComponente(producto);
		    				
						}
					}
					
				} else {
					
					vBoxComponentesProductos.getChildren().clear();
		    		inicializarDatos();
					
				}
	    		
	    		stage.close();
			}
		});
    	
    	opcionesFiltrar.getChildren().add(buttonAceptarFiltrar);
    	
    	opcionesFiltrar.setAlignment(Pos.CENTER);
    	
    	Scene scene = new Scene(opcionesFiltrar, 300, 250);
    	stage.setScene(scene);
    	
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.showAndWait();
		
	}
    
    public void crearComponente(Producto producto){
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ComponenteProducto.fxml"));
		AnchorPane root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ComponenteProductoController controladorComponente = loader.getController();
		controladorComponente.setearCamposProducto(producto.getImg(), producto.getDescripcion(), producto.getNombre(), producto.getPrecio());    		
		controladorComponente.setearControladorVistaPrincipal(this);
		controladorComponente.setearProducto(producto);
		
		vBoxComponentesProductos.getChildren().add(root);
    	
    }

	public void setearCliente(Cliente cliente) {

		this.cliente = cliente;
		
	}
}
