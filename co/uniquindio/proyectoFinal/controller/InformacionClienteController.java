package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.time.LocalDate;

import co.uniquindio.proyectoFinal.exceptions.ClienteException;
import co.uniquindio.proyectoFinal.exceptions.ContraseniaException;
import co.uniquindio.proyectoFinal.exceptions.StringVacioException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InformacionClienteController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	Cliente cliente;
	Scene beforeScene;
	
	@FXML
	private ChoiceBox<TipoDocumento> choiceTipoDocumentoCliente;
	
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
    private TextField txtAntiguaContraseñaCliente;

    @FXML
    private TextField txtDocumentoCliente;

    @FXML
    private TextField txtDireccionCliente;
    
    @FXML
    void volverAtras(ActionEvent event){
    	
    	Stage thisStage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	thisStage.setScene(beforeScene);
    	
    }

    @FXML
    void actualizarInformacionCliente(ActionEvent event) {
    	
    	String nuevoNombre = txtNombreCliente.getText();
    	String nuevaDireccion = txtDireccionCliente.getText();
    	String nuevaCiudad = txtCiudadCliente.getText();
    	String nuevaFechaNacimiento = dateFechaNacimientoCliente.getValue().toString();
    	String nuevoDocumento = txtDocumentoCliente.getText();
    	String nuevoDepartamento = txtDepartamentoCliente.getText();
    	TipoDocumento tipoDocumento = choiceTipoDocumentoCliente.getValue();
    	
    	try {
    		
			empresa.actualizarCliente(cliente, nuevoNombre, nuevaDireccion, nuevaCiudad, nuevaFechaNacimiento, nuevoDocumento, nuevoDepartamento, tipoDocumento);
			setearCamposDeTextoInformacion("", "", "", null, "", "", null);
			System.out.println("informacion actualizada con exito");
    	
    	} catch (NullPointerException e) {

			System.out.println("error fatal, el cliente no puede ser nulo");
			e.printStackTrace();
			
		} catch (ClienteException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	
    }

    @FXML
    void actualizarContraseña(ActionEvent event) {

    	String verificacionContrasenia = txtAntiguaContraseñaCliente.getText();
    	String nuevaContrasenia = txtNuevaContraseñaCliente.getText();
    	
    	try {
    		
			empresa.actualizarContraseniaCliente(cliente, verificacionContrasenia, nuevaContrasenia);
			setearCamposDeTextoContrasenia("", "");
			System.out.println("su contraseña ha sido actualizada con exito");
			
		} catch (NullPointerException e) {
			System.out.println("error fatal, el cliente no puede ser nulo");
			e.printStackTrace();
		} catch (ClienteException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ContraseniaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (StringVacioException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	
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
    	
    	choiceTipoDocumentoCliente.getItems().setAll(TipoDocumento.values());
    	
    }
    
    public void setearCliente(Cliente cliente){
    	
    	this.cliente = cliente;
    	setearCamposDeTextoInformacion(cliente.getNombre(), cliente.getDireccion(), cliente.getCiudad(), 
    			LocalDate.parse(cliente.getFechaNacimiento()), cliente.getDocumento(), cliente.getDepartamento(), cliente.getTipoDocumento());
    	
    }
    
    public void setearBeforeScene(Scene beforeScene){ this.beforeScene = beforeScene; }
    
    public void setearCamposDeTextoInformacion(String nombre, String direccion, String ciudad, LocalDate fechaNacimiento, String documento,
			String departamento, TipoDocumento tipoDocumento) {

		txtNombreCliente.setText(nombre);
		txtDireccionCliente.setText(direccion);
		txtCiudadCliente.setText(ciudad);
		dateFechaNacimientoCliente.setValue(fechaNacimiento);
		txtDocumentoCliente.setText(documento);
		txtDepartamentoCliente.setText(departamento);
		choiceTipoDocumentoCliente.setValue(tipoDocumento);
		
	}
    
    public void setearCamposDeTextoContrasenia(String antiguaContrasenia, String nuevaContrasenia){
    	
    	txtAntiguaContraseñaCliente.setText(antiguaContrasenia);
    	txtNuevaContraseñaCliente.setText(nuevaContrasenia);
    	
    }
    
}
