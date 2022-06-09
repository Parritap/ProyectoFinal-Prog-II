package co.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.time.LocalDate;

import co.uniquindio.proyectoFinal.exceptions.AdminException;
import co.uniquindio.proyectoFinal.exceptions.ContraseniaException;
import co.uniquindio.proyectoFinal.exceptions.StringVacioException;
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
    private TextField txtAntiguaContraseniaAdmin;

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
    private TextField txtNuevaContraseniaAdmin;

    @FXML
    private ChoiceBox<TipoDocumento> choiceTipoDocumentoAdmin;

    @FXML
    private TextField txtNombreAdmin;

    @FXML
    void actualizarInformacionAdmin(ActionEvent event) {

        String nuevoID = txtIdAdmin.getText();
        String nuevoNombre = txtNombreAdmin.getText();
        String nuevoDoc = txtDocumentoAdmin.getText();
        String nuevaDirecc = txtDireccionAdmin.getText();
        String nuevaFechaNacimiento = dateFechaNacimientoAdmin.getValue().toString();
        String nuevosEstudios = txtEstudiosAdmin.getText();
        TipoDocumento nuevoTipoDoc = choiceTipoDocumentoAdmin.getValue();


        try {
            empresa.actualizarAdmin(admin, nuevoID, nuevoNombre, nuevoDoc, nuevaDirecc, nuevaFechaNacimiento, nuevosEstudios, nuevoTipoDoc);

            setearCamposDeTextoInformacion("", "", "", null, "", "", null);
        } catch (AdminException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void actualizarContraseña(ActionEvent event) {

        String verificacionContrasenia = txtAntiguaContraseniaAdmin.getText();
        String nuevaContrasenia = txtNuevaContraseniaAdmin.getText();

        try {

            empresa.actualizarContraseniaAdmin(admin, verificacionContrasenia, nuevaContrasenia);

            setearCamposDeTextoContrasenia("", "");

        } catch (AdminException e) {
            throw new RuntimeException(e);
        } catch (ContraseniaException e) {
            throw new RuntimeException(e);
        } catch (StringVacioException e) {
            throw new RuntimeException(e);
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
    	
    	choiceTipoDocumentoAdmin.getItems().setAll(TipoDocumento.values());
    	
    }

    /**
     *
     * @param admin
     */
    public void setearAdmin(Administrador admin){
    	
    	this.admin = admin;
    	setearCamposDeTextoInformacion(admin.getNombre(), admin.getDireccion(), admin.getEstudios(),
    			LocalDate.parse(admin.getFechaNacimiento()), admin.getDocumento(), admin.getId(), admin.getTipoDocumento());
    }

    /**
     *
     * @param nombre
     * @param direccion
     * @param estudios
     * @param fechaNacimiento
     * @param documento
     * @param id
     * @param tipoDocumento
     */
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

    /**
     *
     * @param antiguaContrasenia
     * @param nuevaContrasenia
     */
    public void setearCamposDeTextoContrasenia(String antiguaContrasenia, String nuevaContrasenia){
    	
    	txtAntiguaContraseniaAdmin.setText(antiguaContrasenia);
    	txtNuevaContraseniaAdmin.setText(nuevaContrasenia);
    	
    }
    
}

