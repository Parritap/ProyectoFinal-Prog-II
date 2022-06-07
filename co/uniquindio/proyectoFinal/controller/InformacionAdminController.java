package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InformacionAdminController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	Administrador admin;

    @FXML
    private TextField txtAntiguaContraseñaAdmin;

    @FXML
    private TextField txtIdAdmin;

    @FXML
    private TextField txtDocumentoAdmin;

    @FXML
    private TextField txtDireccionAdmin;

    @FXML
    private DatePicker dateFechaNacimientoAdmin;

    @FXML
    private TextField txtEstudiosAdmin;

    @FXML
    private TextField txtNuevaContraseñaAdmin;

    @FXML
    private ChoiceBox<TipoDocumento> choiceTipoDocumentoAdmin;

    @FXML
    private TextField txtNombreAdmin;

    @FXML
    void actualizarInformacionAdmin(ActionEvent event) {

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
    	
    	choiceTipoDocumentoAdmin.getItems().setAll(TipoDocumento.values());
    	
    }
    
    public void setearAdmin(Administrador admin){
    	
    	this.admin = admin;
    	setearCamposDeTextoInformacion(admin.getNombre(), admin.getDireccion(), admin.getEstudios(), 
    			LocalDate.parse(admin.getFechaNacimiento()), admin.getDocumento(), admin.getId(), admin.getTipoDocumento());
    
    }
    
    public void setearCamposDeTextoInformacion(String nombre, String direccion, String estudios, LocalDate fechaNacimiento, String documento,
			String id, TipoDocumento tipoDocumento) {

		txtNombreAdmin.setText(nombre);
		txtDireccionAdmin.setText(direccion);
		txtEstudiosAdmin.setText(estudios);
		dateFechaNacimientoAdmin.setValue(fechaNacimiento);
		txtDocumentoAdmin.setText(documento);
		txtIdAdmin.setText(id);
		choiceTipoDocumentoAdmin.setValue(tipoDocumento);
		
	}
    
    public void setearCamposDeTextoContrasenia(String antiguaContrasenia, String nuevaContrasenia){
    	
    	txtAntiguaContraseñaAdmin.setText(antiguaContrasenia);
    	txtNuevaContraseñaAdmin.setText(nuevaContrasenia);
    	
    }
    
}

