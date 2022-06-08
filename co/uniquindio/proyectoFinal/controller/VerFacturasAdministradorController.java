package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Factura;
import co.uniquindio.proyectoFinal.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VerFacturasAdministradorController {

	Administrador administrador;
	Factura selectedItem;
	ObservableList<Factura> listaFacturasData = FXCollections.observableArrayList();
	ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
	
    @FXML
    private TableColumn<Factura, String> tblColCodigoFactura;

    @FXML
    private TableColumn<Factura, Double> tblColIvaFactura;

    @FXML
    private TableColumn<Factura, Double> tblColTotalFactura;

    @FXML
    private TableView<Factura> tblFacturasSede;

    @FXML
    private TextField txtNombreProductoFacturaBuscar;

    @FXML
    private TableColumn<Factura, Cliente> tblColClienteFactura;

    @FXML
    private TextField txtCodigoBuscarFacturas;

    @FXML
    private TableColumn<Factura, String> tblColFechaFactura;

    @FXML
    private ListView<Producto> listProductosFactura;

    @FXML
    private TableColumn<Factura, Double> tblColSubtotalFactura;

    @FXML
    void initialize() {

    	tblColClienteFactura.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    	tblColFechaFactura.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    	tblColCodigoFactura.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	tblColTotalFactura.setCellValueFactory(new PropertyValueFactory<>("total"));
    	tblColSubtotalFactura.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
    	tblColIvaFactura.setCellValueFactory(new PropertyValueFactory<>("iva"));
    	
    	tblFacturasSede.setItems(listaFacturasData);
    	
    	listProductosFactura.setItems(listaProductosData);
    	
    	tblFacturasSede.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
    		
    		selectedItem = newValue;
    		if (selectedItem != null) {
				
    			listaProductosData.setAll(selectedItem.obtenerListaProductos());
    			
			} else {
				
				listaProductosData.clear();
				
			}
    		
    	});
    	
    	txtCodigoBuscarFacturas.textProperty().addListener((obs, oldValue, newValue) -> {
    		
    		if (newValue != null) {
    			
    			listaFacturasData.setAll(administrador.getSede().filtrarFacturas(newValue));
    			
			}
    	});
    	
    	txtNombreProductoFacturaBuscar.textProperty().addListener((obs, oldValue, newValue) -> {
    		
    		if (newValue != null && selectedItem != null) {
				
    			listaProductosData.setAll(selectedItem.filtrarProductos(newValue));
    			
			}
    		
    	});
    	
    }
    
    public void setearAdmin(Administrador administrador){
    	
    	this.administrador = administrador;
    	listaFacturasData.setAll(administrador.getSede().getListaFacturas());
    	
    }
}

