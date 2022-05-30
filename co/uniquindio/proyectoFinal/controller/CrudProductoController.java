package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudProductoController {

	Producto selectedItem = null;
	ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
	ObservableList<CategoriaProducto> listaCategoriasProducto = FXCollections.observableArrayList();

    @FXML
    private TextField txtCodigoProductoBuscar;

    @FXML
    private TextField txtCantidadProducto;

    @FXML
    private TableColumn<Producto, CategoriaProducto> tblColTipoProducto;

    @FXML
    private TableColumn<Producto, String> tblColNombreProducto;

    @FXML
    private TableColumn<Producto, Double> tblColPrecioProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private Button btnDatosListos;

    @FXML
    private TableColumn<Producto, String> tblColCodigoProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private ChoiceBox<CategoriaProducto> choiceBoxTipoProducto;

    @FXML
    private TableColumn<Producto, Integer> tblColCantidadProducto;

    @FXML
    private TextField txtCodigoProducto;

    @FXML
    private TableView<Producto> tblProducto;
    
    @FXML
    private Label mensajeError;

    @FXML
    void crearProducto(ActionEvent event) {

    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    }

    @FXML
    void actualizarProducto(ActionEvent event) {

    }

    @FXML
    void guardarDatos(ActionEvent event) {

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    	//me falta setear la tabla cuando inicie la aplicacion
        
    	tblColCodigoProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tblColNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tblColPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
    	tblColCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("existencias"));
    	tblColTipoProducto.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	
    	tblProducto.setItems(listaProductosData);
    	
    	tblProducto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    		
    		selectedItem = newValue;
    		if (selectedItem != null) {
				
    			setearCamposDeTexto(selectedItem.getId(), selectedItem.getNombre(), 
    					selectedItem.getPrecio(), selectedItem.getExistencias(), selectedItem.getCategoria());
    			
			}
    	});
    	
    	//esta parte toca arreglarla cuando esté el enum listo
//    	listaCategoriasProducto.addAll(CategoriaProducto);
//    	
//    	choiceBoxTipoProducto.setItems(value);
    	
    }

	private void setearCamposDeTexto(String id, String nombre, double precio, int existencias,
			CategoriaProducto categoria) {

		txtCodigoProducto.setText(id);
		txtNombreProducto.setText(nombre);
		txtPrecioProducto.setText(Double.toString(precio));
		txtCantidadProducto.setText(Integer.toString(existencias));
		choiceBoxTipoProducto.setValue(categoria);
		
	}
}
