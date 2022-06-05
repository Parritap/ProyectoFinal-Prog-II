package co.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.DatosEnvio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DatosEnvioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtDestinatarioGestionDatosEnvio;

    @FXML
    private TextArea txtAreaGestionDatosEnvio;

    @FXML
    private TableView<DatosEnvio> tblGestionDatosEnvio;

    @FXML
    private TextField txtCiudadGestionDatosEnvio;

    @FXML
    private TextField txtTelefonoGestionDatosEnvio;

    @FXML
    private TextField txtDomicilioGestionDatosEnvio;

    @FXML
    private TableColumn<String, String> columnDestinatario;

    @FXML
    private TableColumn<String, String> columnCiudad;

    @FXML
    private TableColumn<String, String> columnTelefono;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnCrearDatosEnvio;

    @FXML
    private Button btnActualizarDatosEnvio;

    @FXML
    private TableColumn<String, String> columnDomicilio;

    @FXML
    private Button btnLimpiarGestionDatosEnvio;

    @FXML
    private Button btnEliminarDatosEnvio;
    
    @FXML
    void crearDatosAction(ActionEvent event) {
    	
    }

    @FXML
    void actualizarDatosAction(ActionEvent event) {

    }

    @FXML
    void eliminarDatosAction(ActionEvent event) {

    }

    @FXML
    void limpiarAction(ActionEvent event) {
    	 limpiarCampos() ;
 	    	
    }

    private void limpiarCampos() {
		txtTelefonoGestionDatosEnvio.setText("");
		txtDomicilioGestionDatosEnvio.setText("");
		txtDestinatarioGestionDatosEnvio.setText("");
		txtCiudadGestionDatosEnvio.setText("");
		
	}

	@FXML
    void initialize() {
        assert txtDestinatarioGestionDatosEnvio != null : "fx:id=\"txtDestinatarioGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert txtAreaGestionDatosEnvio != null : "fx:id=\"txtAreaGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert tblGestionDatosEnvio != null : "fx:id=\"tblGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert txtCiudadGestionDatosEnvio != null : "fx:id=\"txtCiudadGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert txtTelefonoGestionDatosEnvio != null : "fx:id=\"txtTelefonoGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert txtDomicilioGestionDatosEnvio != null : "fx:id=\"txtDomicilioGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert columnDestinatario != null : "fx:id=\"columnDestinatario\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert columnCiudad != null : "fx:id=\"columnCiudad\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert columnTelefono != null : "fx:id=\"columnTelefono\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert btnCrearDatosEnvio != null : "fx:id=\"btnCrearDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert btnActualizarDatosEnvio != null : "fx:id=\"btnActualizarDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert columnDomicilio != null : "fx:id=\"columnDomicilio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert btnLimpiarGestionDatosEnvio != null : "fx:id=\"btnLimpiarGestionDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";
        assert btnEliminarDatosEnvio != null : "fx:id=\"btnEliminarDatosEnvio\" was not injected: check your FXML file 'AñadirDatosEnvio.fxml'.";

    }
}

