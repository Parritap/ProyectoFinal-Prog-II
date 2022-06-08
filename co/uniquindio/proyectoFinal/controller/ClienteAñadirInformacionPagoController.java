package co.uniquindio.proyectoFinal.controller;

	import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.DatosEnvio;
import co.uniquindio.proyectoFinal.model.InformacionPago;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import co.uniquindio.proyectoFinal.model.enums.MetodoPago;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

	public class ClienteAñadirInformacionPagoController {
		
		Singleton singleton = Singleton.getInstance();
		Cliente cliente;
		Scene beforeScene = null;
		ObservableList <InformacionPago> informacionPagoData = FXCollections.observableArrayList();
		InformacionPago selectedItem = null;
		
		@FXML
		private Button btnSalir;
		

	    @FXML
	    private DatePicker datePickerFechaVencimiento;

		@FXML
		private ResourceBundle resources;

		@FXML
		private URL location;

	    @FXML
	    private TableColumn<String, String> columnTitular;

	    @FXML
	    private ChoiceBox<MetodoPago> choiceBoxMetodoPago;

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
	    private TableView<InformacionPago> tblGestionPago;

	    @FXML
	    private Button btnCrearTransaccionVenta;

	    @FXML
	    private Button btnEliminarTransaccionVenta;


	    @FXML
	    private TextField txtCodigoSeguridad;

	    @FXML
	    private Button btnLimpiarCampos;
	    
	    
	    @FXML
	    void salirAction(ActionEvent event) {

	    }
	    
	   
	    @FXML
	    void crearTransaccionVentaAction(ActionEvent event) throws StringNuloOrVacioException {
	    	crearTranasaccionVenta();
	    	tblGestionPago.getSelectionModel().clearSelection();
			limpiarCampos();
	    }

	    private void crearTranasaccionVenta() throws StringNuloOrVacioException {
	    	InformacionPago infoPago = new InformacionPago();
	    	String numTarjeta = txtNumeroTarjeta.getText();
	    	String titularTarjeta = txtTitularTarjeta.getText();
	    	String codigoSeguridadTarjeta = txtCodigoSeguridad.getText();
	    	String fechaVencimiento = String.valueOf(datePickerFechaVencimiento.getValue());
	    	MetodoPago metodoPago = choiceBoxMetodoPago.getSelectionModel().getSelectedItem();
	    	infoPago = cliente.crearInformacionPago(numTarjeta, titularTarjeta, codigoSeguridadTarjeta, fechaVencimiento, metodoPago);
			informacionPagoData.add(infoPago);
		}

		@FXML
	    void eliminarTransaccionVentaAction(ActionEvent event) {
			eliminarTransaccion ();
	    }

	    private void eliminarTransaccion() {
	    	if (selectedItem != null){
	    		cliente.eliminarInfoPago(selectedItem);
	    		informacionPagoData.remove(selectedItem);
	    	}
			tblGestionPago.getSelectionModel().clearSelection();
			limpiarCampos();
			
		}

		@FXML
	    void actualizarTransaccionVentaAction(ActionEvent event) {
			actualizarDatos();
			tblGestionPago.getSelectionModel().clearSelection();
			limpiarCampos();
	    }

	    private void actualizarDatos() {
	    	if (selectedItem != null){
				InformacionPago infoPago = selectedItem;
				String nuevoNumTarjeta = txtNumeroTarjeta.getText();
		    	String nuevoTitular = txtTitularTarjeta.getText();
		    	String nuevoCodigoSeg = txtCodigoSeguridad.getText();
		    	String nuevaFechaVencimiento = String.valueOf(datePickerFechaVencimiento.getValue());
		    	MetodoPago metodoPago = choiceBoxMetodoPago.getSelectionModel().getSelectedItem();
		    	int index = informacionPagoData.indexOf(infoPago);
		    	infoPago = cliente.actualizarInfoPago(infoPago , nuevoNumTarjeta, nuevoTitular, nuevoCodigoSeg, nuevaFechaVencimiento, metodoPago);
		    	informacionPagoData.set(index, infoPago);
	    	}
			
		}

		@FXML
	    void limpiarCamposAction(ActionEvent event) {
	    	limpiarCampos ();
	    	
	    }

	    private void limpiarCampos() {
	    	txtCodigoSeguridad.setText("");
	    	txtNumeroTarjeta.setText("");
	    	txtTitularTarjeta.setText("");
		}

		@FXML
	    void initialize() {
	        columnCodigoSeguridad.setCellValueFactory(new PropertyValueFactory<>("codigoSeguridadTarjeta"));
	        columnFechaVencimeinto.setCellValueFactory(new PropertyValueFactory<>("fechaVencimientoTarjeta"));
	        columnNumeroTarjeta.setCellValueFactory(new PropertyValueFactory<>("numeroTarjeta"));
	        columnTitular.setCellValueFactory(new PropertyValueFactory<>("titularTarjeta"));
	        columnMetodoPago.setCellValueFactory(new PropertyValueFactory<>("MetodoPago"));
	        
	        
	       tblGestionPago.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

	    		selectedItem = newSelection;
	    		mostrarInformacionDatosEnvio(newSelection);
	    	});
	       
	       choiceBoxMetodoPago.getItems().addAll(MetodoPago.values());
	        tblGestionPago.getItems().clear();
	        tblGestionPago.setItems(informacionPagoData);
	    }

		private void mostrarInformacionDatosEnvio(InformacionPago newSelection) {
			if (newSelection != null){
				txtCodigoSeguridad.setText(newSelection.getCodigoSeguridadTarjeta());
				
				LocalDate localDate = LocalDate.parse(newSelection.getFechaVencimientoTarjeta());
				datePickerFechaVencimiento.setValue(localDate);
				txtNumeroTarjeta.setText(newSelection.getNumeroTarjeta());
				txtTitularTarjeta.setText(newSelection.getTitularTarjeta());
				//No se si el setUserData sirva
				choiceBoxMetodoPago.setUserData(newSelection.getMetodoPago());
			}
			
		}
		public void setearCliente (Cliente cliente){
			this.cliente = cliente;
		}
		public void setearBeforeScene (Scene beforeScene){
			this.beforeScene = beforeScene;
		}
	}
