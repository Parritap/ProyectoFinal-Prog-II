package co.uniquindio.proyectoFinal.controller;


	import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Factura;
import co.uniquindio.proyectoFinal.model.InformacionPago;
import co.uniquindio.proyectoFinal.model.Reporte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextArea;
	public class ReportesController {

		Singleton singleton = Singleton.getInstance();
		Empresa empresa = singleton.empresa;
		ObservableList <Factura> informacionFacturaData = FXCollections.observableArrayList();
		
		
		
	    @FXML
	    private ResourceBundle resources;
	    
	    @FXML
	    private Button btnLimpiar;
	    
	    @FXML
	    private TextArea txtArea;
	    
	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<String, String> columnFecha;

	    @FXML
	    private DatePicker datePickerFechaInicial;

	    @FXML
	    private TableView<Factura> tblReportes;

	    @FXML
	    private TableColumn<String, String> columnCodigo;

	    @FXML
	    private Button btnGenerarReporte;

	    @FXML
	    private TableColumn<Double,String> columnIva;

	    @FXML
	    private DatePicker datePickerFechaFinal;

	    @FXML
	    private TableColumn<Double, String> columnSubtotal;

	    @FXML
	    private TableColumn<Double, String> columnTotal;
	    
	    
	    @FXML
	    void limpiarAction(ActionEvent event) {
	    	limpiarTabla();
	    }
	    
	    
	    private void limpiarTabla() {
			
			informacionFacturaData.clear();
		}




		@FXML
	    void generarReporteAction(ActionEvent event) {

	    	generarReporte();
	    	
	    }

	    private void generarReporte() {
			ArrayList <Factura> listaFacturas = new ArrayList <>();
			Reporte reporte = new Reporte();
			String fechaInicial= String.valueOf(datePickerFechaInicial.getValue());
			String fechaFinal= String.valueOf(datePickerFechaFinal.getValue());
			reporte = empresa.crearReporte(fechaInicial, fechaFinal);
			listaFacturas = reporte.getListaFacturas();
	    	informacionFacturaData.addAll(listaFacturas);
		}

		@FXML
	    void initialize() {
	      columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
	      columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
	      columnIva.setCellValueFactory(new PropertyValueFactory<>("iva"));
	      columnSubtotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
	      columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
	      
	      
	      
	      
	      
	      tblReportes.getItems().clear();
	      tblReportes.setItems(informacionFacturaData);
	      
	      
	    }
	}
	

