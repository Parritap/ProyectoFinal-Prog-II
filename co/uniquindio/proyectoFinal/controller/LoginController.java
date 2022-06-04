package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	
    @FXML
    private Label LblMensajeErrorIngreso;

    @FXML
    private TextField txtContraseñaUsuarioIngresar;

    @FXML
    private TextField txtEmailUsuarioIngresar;

    @FXML
    void ingresarEnAplicacion(ActionEvent event) {

    	String contrasenia = txtContraseñaUsuarioIngresar.getText();
    	String email = txtEmailUsuarioIngresar.getText();
    	
    	if (!contrasenia.equals("") && !email.equals("")) {
    		
			try {
				
				if (verificarDatosCorrectosAdministrador(email, contrasenia)) {
					
	    			cambiarEscenaDeVentana(getClass().getResource("../view/VistaPrincipalAdmin.fxml"), event);
	    			
				} else if (verificarDatosCorrectosCliente(email, contrasenia)) {
					
					cambiarEscenaDeVentana(getClass().getResource("../view/VistaPrincipalTienda.fxml"), event);
					
				}
				
			} catch (EmailNoValidoException e) {

				LblMensajeErrorIngreso.setText("el email que digitó no es valido");
				
			}
    		
		} else {
			
			LblMensajeErrorIngreso.setText("llene ambos campos de texto para ingresar a la aplicacion");
			
		}
    }

    private void cambiarEscenaDeVentana(URL resource, ActionEvent event) {

    	if (event != null && resource != null) {
			
    		Stage thisStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        	
    		try {
    			
    			AnchorPane root = FXMLLoader.load(resource);
    			thisStage.setScene(new Scene(root));
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
		}
    	
    	
	}

	private boolean verificarDatosCorrectosCliente(String email, String contrasenia) throws EmailNoValidoException {

    	Cliente cliente = empresa.obtenerCliente(email);
    	
    	if (cliente != null && cliente.getContrasenia().equals(contrasenia)) {
    		
    		return true;
    		
		} else {
			
			LblMensajeErrorIngreso.setText("datos incorrectos");
			
		}
    	
    	return false;
    	
	}

	private boolean verificarDatosCorrectosAdministrador(String email, String contrasenia) throws EmailNoValidoException {

    	Administrador administrador = empresa.obtenerAdminByEmail(email);
    	
    	if ((administrador != null) && (administrador.getContrasenia().equals(contrasenia))) {
			return true;
		}
    	
    	return false;
    	
	}

	@FXML
    void registrarseEnAplicacion(ActionEvent event) {

		
		
    }

    @FXML
    void initialize() {
        
    	
    	
    }
}

