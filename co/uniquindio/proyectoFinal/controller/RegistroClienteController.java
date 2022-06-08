package co.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.enums.MetodoPago;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegistroClienteController {
	
	Singleton singleton = Singleton.getInstance();
	
	Empresa empresa = singleton.empresa;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private DatePicker datePickerFechaNacimiento;
    
    @FXML
    private TextField txtDepartamentoCliente;

    @FXML
    private TextField txtContraseña;
    
    @FXML
    private Button btnRegistrarseCliente;

    @FXML
    private Label labelExcepciones;


    @FXML
    private TextField txtCiudadCliente;

    @FXML
    private TextField txtEmailCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtDireccion;
    
    @FXML
    private TextField txtNumeroDocumentoCliente;

    @FXML
    private ChoiceBox<TipoDocumento> choiceBoxTipoDocumento;

    @FXML
    private Button btnLimpiarCampos;

  

    @FXML
    void registrarseAction(ActionEvent event) throws Exception {
    	
    	registrarCliente();
    	limpiarCampos();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
		AnchorPane root = loader.load();
		
		Stage thisStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		thisStage.setScene(new Scene(root));
    	
    }


    private void registrarCliente() throws Exception {
    	TipoDocumento tipoDocumento = choiceBoxTipoDocumento.getSelectionModel().getSelectedItem();
    	String ciudad = txtCiudadCliente.getText();
    	String departamento = txtDepartamentoCliente.getText();
    	String email =txtEmailCliente.getText();
    	String fechaNacimiento = datePickerFechaNacimiento.getValue().toString();
    	String nombre =txtNombreCliente.getText();
    	String documento =txtNumeroDocumentoCliente.getText();
    	String direccion = txtDireccion.getText();
    	String contrasenia = txtContraseña.getText();
   
  
		empresa.crearCliente(nombre, direccion, documento, tipoDocumento, email, contrasenia, fechaNacimiento, ciudad, departamento);
		
	}


	@FXML
    void limpiarCamposAction(ActionEvent event) {

    	limpiarCampos();
    	
    }

    private void limpiarCampos() {
    	
    	txtCiudadCliente.setText("");
    	txtDepartamentoCliente.setText("");
    	txtEmailCliente.setText("");
    	txtNombreCliente.setText("");
    	txtNumeroDocumentoCliente.setText("");
    	txtContraseña.setText("");
    	txtDireccion.setText("");
		
	}


	@FXML
    void initialize() {
		choiceBoxTipoDocumento.getItems().addAll(TipoDocumento.values());
    }
}
