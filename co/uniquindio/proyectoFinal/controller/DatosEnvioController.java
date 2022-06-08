package co.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.exceptions.DatosEnvioException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.DatosEnvio;
import co.uniquindio.proyectoFinal.model.InformacionPago;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DatosEnvioController {
	
	
	Singleton singleton = Singleton.getInstance();
	Cliente cliente;
	Scene beforeScene = null;
	DatosEnvio selectedItem = null;
	ObservableList<DatosEnvio> listaDatosEnvio = FXCollections.observableArrayList();
	
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
    void salir(ActionEvent event){
    	
    	Stage thisStage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	thisStage.setScene(beforeScene);
    	
    }
    
    @FXML
    void crearDatosAction(ActionEvent event) throws StringNuloOrVacioException, DatosEnvioException {
    	crearDatosEnvio ();
    	tblGestionDatosEnvio.getSelectionModel().clearSelection();
		limpiarCampos();
    }

    private void crearDatosEnvio() throws StringNuloOrVacioException, DatosEnvioException {
    	DatosEnvio datosEnvio =  new DatosEnvio();
    	String ciudad = txtCiudadGestionDatosEnvio.getText();
    	String domicilio= txtDomicilioGestionDatosEnvio.getText();
    	String destinatario = txtDestinatarioGestionDatosEnvio.getText();
    	String telefono = txtTelefonoGestionDatosEnvio.getText();
    	datosEnvio = cliente.crearDatosEnvio(ciudad, domicilio, destinatario, telefono);
		listaDatosEnvio.add(datosEnvio);
	}

	@FXML
    void actualizarDatosAction(ActionEvent event) {
		actualizarDatos();
		tblGestionDatosEnvio.getSelectionModel().clearSelection();
		limpiarCampos();
    }

    private void actualizarDatos() {
    	if (selectedItem != null){
    		DatosEnvio datosEnvio = selectedItem;
    		String nuevaCiudad = txtCiudadGestionDatosEnvio.getText();
        	String nuevoDomicilio= txtDomicilioGestionDatosEnvio.getText();
        	String nuevoDestinatario = txtDestinatarioGestionDatosEnvio.getText();
        	String nuevoTelefono = txtTelefonoGestionDatosEnvio.getText();
        	int index = listaDatosEnvio.indexOf(datosEnvio);
        	cliente.actualizarDatosEnvio(datosEnvio, nuevoDomicilio, nuevaCiudad, nuevoDestinatario, nuevoTelefono);
        	listaDatosEnvio.set(index, datosEnvio);
    		}
	}

	@FXML
    void eliminarDatosAction(ActionEvent event) {
    	eliminarDatos();
    	tblGestionDatosEnvio.getSelectionModel().clearSelection();
		limpiarCampos();
    }

    private void eliminarDatos() {
		if (selectedItem != null){
			cliente.eliminarDatosEnvio (selectedItem);
			listaDatosEnvio.remove(selectedItem);
		}
		
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
        columnCiudad.setCellValueFactory(new PropertyValueFactory<>("Ciudad"));
        columnDestinatario.setCellValueFactory(new PropertyValueFactory<>("Destinatario"));
        columnDomicilio.setCellValueFactory(new PropertyValueFactory<>("domicilio"));
        columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        
        tblGestionDatosEnvio.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

    		selectedItem = newSelection;
    		mostrarInformacionDatosEnvio(newSelection);
    	});
        tblGestionDatosEnvio.getItems().clear();
        tblGestionDatosEnvio.setItems(listaDatosEnvio);
        
        
    }
	
	private void mostrarInformacionDatosEnvio(DatosEnvio newSelection) {
		if(selectedItem != null){
			txtCiudadGestionDatosEnvio.setText(selectedItem.getCiudad());
			txtDestinatarioGestionDatosEnvio.setText(selectedItem.getDestinatario());
			txtDomicilioGestionDatosEnvio.setText(selectedItem.getDomicilio());
			txtTelefonoGestionDatosEnvio.setText(selectedItem.getTelefono());
			
		}
	}
	public void setearCliente (Cliente cliente){
		this.cliente = cliente;
		listaDatosEnvio.setAll(cliente.getListaDatosEnvio());
		
	}
	public void setearBeforeScene (Scene beforeScene){
		this.beforeScene = beforeScene;
	}
}

