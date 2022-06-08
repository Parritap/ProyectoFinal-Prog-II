package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.exceptions.NegativeNumberException;
import co.uniquindio.proyectoFinal.exceptions.ProductoException;
import co.uniquindio.proyectoFinal.exceptions.SedeException;
import co.uniquindio.proyectoFinal.exceptions.StringNuloOrVacioException;
import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Producto;
import co.uniquindio.proyectoFinal.model.enums.CategoriaProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class CrudProductoController {

    Empresa empresa = Singleton.getInstance().getEmpresa();
    Administrador administrador;
    Producto selectedItemTable;
    Producto selectedItemList;
    ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();

    @FXML
    private TextField txtCodigoProductoBuscar;

    @FXML
    private TextField txtCantidadProducto;

    @FXML
    private TextArea txtDescripcionProducto;

    @FXML
    private TextField txtNombreImagenProducto;

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
    private ListView<Producto> listProductosEmpresa;

    @FXML
    private TextField txtCantidadProductosASolicitar;

    @FXML
    void solicitarProductos(ActionEvent event) {

        if (selectedItemList != null) {

            try {
                int cantidadProducto = Integer.parseInt(txtCantidadProductosASolicitar.getText());
                empresa.agregarProductosSede(selectedItemList, cantidadProducto, administrador.getSede());

                txtCantidadProductosASolicitar.setText("");
                listProductosEmpresa.getSelectionModel().clearSelection();
                
                listaProductosData.setAll(empresa.getListaProductos());

            } catch (StringNuloOrVacioException | SedeException | ProductoException e) {
                e.printStackTrace();
            }
		}

    }

    @FXML
    void crearProducto(ActionEvent event) {

        String id = txtCodigoProducto.getText();
        String nombre = txtNombreProducto.getText();
        double precio = Double.parseDouble(txtPrecioProducto.getText());
        String descripcion = txtDescripcionProducto.getText();
        Image imagen = new Image(getClass().getResourceAsStream("../view/imagenesProyecto/" + txtNombreImagenProducto.getText()));
        int existencias = Integer.parseInt(txtCantidadProducto.getText());
        CategoriaProducto categoria = choiceBoxTipoProducto.getSelectionModel().getSelectedItem();

        try {

            empresa.crearProducto(id, nombre, precio, descripcion, imagen, existencias, categoria);

            setearCamposDeTexto("", "", "", "", null, "");

        } catch (StringNuloOrVacioException | NegativeNumberException | ProductoException e) {
            e.printStackTrace();
        }

        listaProductosData.setAll(empresa.getListaProductos());

    }

    @FXML
    void eliminarProducto(ActionEvent event) {

        if (selectedItemTable != null) {

            try {

                empresa.eliminarProducto(selectedItemTable.getId());

            } catch (StringNuloOrVacioException | ProductoException e) {
                e.printStackTrace();
            }
        }

        listaProductosData.setAll(empresa.getListaProductos());
    }

    @FXML
    void actualizarProducto(ActionEvent event) {

        if (selectedItemTable != null) {

            String nombre = txtNombreProducto.getText();
            double precio = Double.parseDouble(txtPrecioProducto.getText());
            String descripcion = txtDescripcionProducto.getText();
            Image imagen = new Image(getClass().getResourceAsStream("../view/imagenesProyecto/" + txtNombreImagenProducto.getText()));
            int existencias = Integer.parseInt(txtCantidadProducto.getText());
            CategoriaProducto categoria = choiceBoxTipoProducto.getSelectionModel().getSelectedItem();

            try {
                empresa.actualizarProducto(selectedItemTable, nombre, precio, descripcion, imagen, existencias, categoria);

            } catch (StringNuloOrVacioException | NegativeNumberException | ProductoException e) {
                e.printStackTrace();
            }
        }

        listaProductosData.setAll(empresa.getListaProductos());

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

        setearCamposDeTexto("", "", "", "", null, "");

    }

    @FXML
    void initialize() {

        listaProductosData.setAll(empresa.getListaProductos());

        tblColCodigoProducto.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblColNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tblColPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tblColCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("existencias"));
        tblColTipoProducto.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        tblProducto.setItems(listaProductosData);

        //Función que se ejecuta cuando uno da click en una línea.
        tblProducto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            selectedItemTable = newValue;
            if (selectedItemTable != null) {

                setearCamposDeTexto(selectedItemTable.getId(), selectedItemTable.getNombre(),
                        Double.toString(selectedItemTable.getPrecio()), Integer.toString(selectedItemTable.getExistencias()),
                        selectedItemTable.getCategoria(), selectedItemTable.getDescripcion());

            }
        });

        listProductosEmpresa.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {

            if (newValue != null) {

                selectedItemList = newValue;

            }
        });

        choiceBoxTipoProducto.getItems().addAll(CategoriaProducto.values());

        txtCodigoProductoBuscar.textProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != "") {

                listaProductosData.setAll(empresa.filtrarProductosPorCodigo(newValue));

            }

        });

        listProductosEmpresa.getItems().setAll(listaProductosData);

    }

    private void setearCamposDeTexto(String id, String nombre, String precio, String existencias,
                                     CategoriaProducto categoria, String descripcion) {

        txtCodigoProducto.setText(id);
        txtNombreProducto.setText(nombre);
        txtPrecioProducto.setText(precio);
        txtCantidadProducto.setText(existencias);
        choiceBoxTipoProducto.setValue(categoria);
        txtDescripcionProducto.setText(descripcion);
        txtNombreImagenProducto.setText("");

    }

    public void setearAdministrador(Administrador administrador) {

        this.administrador = administrador;

    }
}
