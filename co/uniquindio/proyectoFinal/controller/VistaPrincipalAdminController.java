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
    void abrirInformacionCuentaAdmin(MouseEvent event){
    	
    	try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/InformacionAdmin.fxml"));
			AnchorPane root = loader.load();
			
			InformacionAdminController informacionAdminController = loader.getController();
			informacionAdminController.setearAdmin(administrador);
			
			vistaPrincipalAdmin.setCenter(root);
	    	BorderPane.setAlignment(root, Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
    	
    }
    
    @FXML
    void abrirFuncionalidadesExtra(MouseEvent event){
    	
    	//no se si las funcionalidades extra son generales para todos los administradores o depende de que sede se esté administrando
    	//por favor responder abajo :)
    	
    	// Son generales a todos los administradores...
    	try {
			
    		//falta esta vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncionalidadesExtra.fxml"));
			AnchorPane root = loader.load();
			
			//FuncionalidadesExtraAdminController funcionalidadesExtraAdminController = loader.getController();
			
			vistaPrincipalAdmin.setCenter(root);
	    	BorderPane.setAlignment(root, Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
    	
    }

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

    	try {
			//falta esta vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VerFacturasAdmin.fxml"));
			AnchorPane root = loader.load();
			
			//VerFacturasAdminController verFacturasAdminController = loader.getController();
			
			vistaPrincipalAdmin.setCenter(root);
	    	BorderPane.setAlignment(root, Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
    	
    }

    @FXML
    void abrirVistaGenerarReportes(MouseEvent event) {

    	try {
			//falta esta vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/GenerarReportes.fxml"));
			AnchorPane root = loader.load();
			
			//GenerarReportesController generarReportesController = loader.getController();
			
			vistaPrincipalAdmin.setCenter(root);
	    	BorderPane.setAlignment(root, Pos.CENTER);
			
		} catch (IOException e) {
			e.printStackTrace();
		}   
    	
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
