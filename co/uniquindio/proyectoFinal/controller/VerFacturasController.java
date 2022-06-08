package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Factura;
import co.uniquindio.proyectoFinal.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class VerFacturasController{

    Empresa empresa = Singleton.getInstance().getEmpresa();
    Cliente cliente;
    Scene beforeScene;
    
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    ObservableList<Factura> listaFacturas = FXCollections.observableArrayList();

    @FXML
    private Button btnMostrarTodasFacturas;

    @FXML
    private ListView<Producto> listView;

    @FXML
    private TableView<Factura> tableView;

    @FXML
    private TableColumn<Factura, String> codigo;

    @FXML
    private TableColumn<Factura, String> fecha;

    @FXML
    private TableColumn<Factura, Double> total;

    @FXML
    private TableColumn<Factura, Double> subtotal;

    @FXML
    private TableColumn<Factura, Double> iva;

    @FXML
    private TableColumn<Factura, String> sede;


    @FXML
    private DatePicker datePicker;

    @FXML
    void filtrarFacturas(ActionEvent event) {

        ArrayList<Factura> lista= new ArrayList<>();

        String date = String.valueOf(datePicker.getValue());


        for (Factura f: cliente.getListaFacturas()) {

            if(f.getFecha().equals(date))
                lista.add(f);
        }

        listaFacturas.setAll(lista);

    }

    @FXML
    void mostrarTodasLasFacturas(ActionEvent event) {
        listaFacturas.setAll(cliente.getListaFacturas());
    }

    @FXML
    void initialize() {
    	
    	codigo.setCellValueFactory(new PropertyValueFactory<Factura, String>("codigo"));
        fecha.setCellValueFactory(new PropertyValueFactory<Factura, String>("fecha"));
        total.setCellValueFactory(new PropertyValueFactory<Factura, Double>("total"));
        subtotal.setCellValueFactory(new PropertyValueFactory<Factura, Double>("subtotal"));
        iva.setCellValueFactory(new PropertyValueFactory<Factura, Double>("iva"));
        sede.setCellValueFactory(new PropertyValueFactory<Factura, String>("sede"));

        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {

        	if (newValue != null) {
        		listaProductos.setAll(newValue.obtenerListaProductos());
			}
        	
        });
        
        tableView.setItems(listaFacturas);
        listView.setItems(listaProductos);
    	
    }
    
    public void setearCliente(Cliente cliente){
    	
    	this.cliente = cliente;
    	listaFacturas.setAll(cliente.getListaFacturas());
    	
    }
    
    public void setearBeforeScene(Scene scene){
    	
    	beforeScene = scene;
    	
    }
    
}