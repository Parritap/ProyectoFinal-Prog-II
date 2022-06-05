package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class VistaPrincipalTiendaController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	
    @FXML
    private VBox vBoxComponentesProductos;

    @FXML
    private TextField txtBuscarProductoCliente;

    @FXML
    void filtrarProductosPorCategoria(ActionEvent event) {

    	
    	
    }

    @FXML
    void abrirCarritoDeCompras(ActionEvent event) {

    }

    @FXML
    void abrirDatosEnvioCliente(ActionEvent event) {

    }

    @FXML
    void abrirInformacionPagoCliente(ActionEvent event) {

    }

    @FXML
    void abrirInformacionCuentaCliente(ActionEvent event) {

    }

    @FXML
    void abrirFacturasCliente(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
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
		
		vBoxComponentesProductos.getChildren().add(root);
    	
    }
}