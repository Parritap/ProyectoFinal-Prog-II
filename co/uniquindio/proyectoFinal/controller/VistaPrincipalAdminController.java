package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;

import co.uniquindio.proyectoFinal.model.Administrador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VistaPrincipalAdminController {

	Administrador administrador;
	
    @FXML
    private BorderPane vistaPrincipalAdmin;
    
    @FXML
    private AnchorPane anchorEspacioVistaOpcion;

    @FXML
    void abrirVistaCrudProducto(MouseEvent event) {
    	
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CrudProducto.fxml"));
			AnchorPane root = loader.load();
			
			CrudProductoController crudProductoController = loader.getController();
			crudProductoController.setearAdministrador(administrador);
			
			vistaPrincipalAdmin.setCenter(root);
	    	BorderPane.setAlignment(root, Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}    	
		
    }

	@FXML
    void abrirTablaVerClientes(MouseEvent event) {

        AnchorPane root = (AnchorPane) obtenerRaizArchivoFxml(getClass().getResource("../view/VerClientes.fxml"));

        vistaPrincipalAdmin.setCenter(root);
        BorderPane.setAlignment(root, Pos.CENTER);
		
		
    }

    @FXML
    void abrirTablaVerFacturas(MouseEvent event) {

    }

    @FXML
    void abrirVistaGenerarReportes(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	
    }
    
    private Parent obtenerRaizArchivoFxml(URL resource) {

    	Parent root = null;
    	
    	try {
			
    		root = FXMLLoader.load(resource);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return root;
	}

	public void setearAdministrador(Administrador administrador) { this.administrador = administrador; }
}
