package co.uniquindio.proyectoFinal.controller;

	import java.net.URL;
	import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.DatosEnvio;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.SplitMenuButton;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class ClienteAñadirInformacionPagoController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<String, String> columnTitular;

	    @FXML
	    private SplitMenuButton splitMetodoPago;

	    @FXML
	    private TableColumn<String, String> columnCodigoSeguridad;

	    @FXML
	    private TextField txtNumeroTarjeta;

	    @FXML
	    private TableColumn<TipoDocumento, String> columnMetodoPago;

	    @FXML
	    private TextArea txtAreaIngresarDatos;

	    @FXML
	    private TextField txtTitularTarjeta;

	    @FXML
	    private TableColumn<String, String> columnFechaVencimeinto;

	    @FXML
	    private Button btnActualizarTransaccionVenta;

	    @FXML
	    private TableColumn<String, String> columnNumeroTarjeta;

	    @FXML
	    private TableView<DatosEnvio> tblGestionPago;

	    @FXML
	    private Button btnCrearTransaccionVenta;

	    @FXML
	    private Button btnEliminarTransaccionVenta;

	    @FXML
	    private TextField txtFechaVencimiento;

	    @FXML
	    private TextField txtCodigoSeguridad;

	    @FXML
	    private Button btnLimpiarCampos;
	    
	    @FXML
	    void crearTransaccionVentaAction(ActionEvent event) {
	    	
	    }

	    @FXML
	    void eliminarTransaccionVentaAction(ActionEvent event) {

	    }

	    @FXML
	    void actualizarTransaccionVentaAction(ActionEvent event) {
	    	
	    }

	    @FXML
	    void limpiarCamposAction(ActionEvent event) {
	    	limpiarCampos ();
	    	
	    }

	    private void limpiarCampos() {
	    	txtCodigoSeguridad.setText("");
	    	txtFechaVencimiento.setText("");
	    	txtNumeroTarjeta.setText("");
	    	txtTitularTarjeta.setText("");
		}

		@FXML
	    void initialize() {
	        

	    }
	}
