package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.time.LocalDate;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InformacionClienteController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	Cliente cliente;
	
    @FXML
    private TextField txtDepartamentoCliente;

    @FXML
    private TextField txtCiudadCliente;

    @FXML
    private DatePicker dateFechaNacimientoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtNuevaContraseñaCliente;

    @FXML
    private TextField txtConfirmarContraseñaCliente;

    @FXML
    private TextField txtDocumentoCliente;

    @FXML
    private TextField txtDireccionCliente;

    @FXML
    void actualizarInformacionCliente(ActionEvent event) {
    	
    }

    @FXML
    void actualizarContraseña(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
    	try {
    		
			AnchorPane root = loader.load();
			Scene scene = new Scene(root);
			
			Stage thisStage = (Stage)(((Node) event.getSource()).getScene().getWindow());
			thisStage.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
    	
    }
    
    public void setearCliente(Cliente cliente){ this.cliente = cliente; }
    
    private void setearCamposDeTextoInformacion(String nombre, String direccion, String ciudad, LocalDate fechaNacimiento, String documento,
			String departamento) {

		txtNombreCliente.setText(nombre);
		txtDireccionCliente.setText(direccion);
		txtCiudadCliente.setText(ciudad);
		dateFechaNacimientoCliente.setValue(fechaNacimiento);
		txtDocumentoCliente.setText(documento);
		txtDepartamentoCliente.setText(departamento);
		
	}
    
    
}
