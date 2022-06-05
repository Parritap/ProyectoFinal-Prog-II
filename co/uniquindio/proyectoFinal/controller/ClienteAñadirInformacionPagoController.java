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
	        assert columnTitular != null : "fx:id=\"columnTitular\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert splitMetodoPago != null : "fx:id=\"splitMetodoPago\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert columnCodigoSeguridad != null : "fx:id=\"columnCodigoSeguridad\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert txtNumeroTarjeta != null : "fx:id=\"txtNumeroTarjeta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert columnMetodoPago != null : "fx:id=\"columnMetodoPago\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert txtAreaIngresarDatos != null : "fx:id=\"txtAreaIngresarDatos\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert txtTitularTarjeta != null : "fx:id=\"txtTitularTarjeta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert columnFechaVencimeinto != null : "fx:id=\"columnFechaVencimeinto\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert btnActualizarTransaccionVenta != null : "fx:id=\"btnActualizarTransaccionVenta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert columnNumeroTarjeta != null : "fx:id=\"columnNumeroTarjeta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert tblGestionPago != null : "fx:id=\"tblGestionPago\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert btnCrearTransaccionVenta != null : "fx:id=\"btnCrearTransaccionVenta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert btnEliminarTransaccionVenta != null : "fx:id=\"btnEliminarTransaccionVenta\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert txtFechaVencimiento != null : "fx:id=\"txtFechaVencimiento\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert txtCodigoSeguridad != null : "fx:id=\"txtCodigoSeguridad\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";
	        assert btnLimpiarCampos != null : "fx:id=\"btnLimpiarCampos\" was not injected: check your FXML file 'ClienteAñadirInformacionPago.fxml'.";

	    }
	}
