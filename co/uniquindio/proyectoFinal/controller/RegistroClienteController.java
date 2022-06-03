package co.uniquindio.proyectoFinal.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistroClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarseCliente;

    @FXML
    private TableView<?> tblCliente;

    @FXML
    private TextField txtCiudadCliente;

    @FXML
    private TableColumn<?, ?> columnNumeroDocumentoCliente;

    @FXML
    private TextField txtEmailCliente;

    @FXML
    private TableColumn<?, ?> columnDepartamentoCliente;

    @FXML
    private TextField txtNumeroDocumentoCliente;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<?, ?> columnNombreCliente;

    @FXML
    private Button btnBorrarCuentaCliente;

    @FXML
    private TextField txtDepartamentoCliente;

    @FXML
    private TextField txtFechaNacimientoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextArea TxtInteraccionCliente;

    @FXML
    private Button btnLimpiarCliente;

    @FXML
    private TableColumn<?, ?> columnCiudadCliente;

    @FXML
    private TableColumn<?, ?> columnEmailCliente;

    @FXML
    private TableColumn<?, ?> columnFechaNacimientoCliente;

    @FXML
    private TableColumn<?, ?> columnTipoDocumentoCliente;

    @FXML
    private SplitMenuButton splitMenuTipoDocumentoCliente;

    @FXML
    void initialize() {
        assert btnRegistrarseCliente != null : "fx:id=\"btnRegistrarseCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert tblCliente != null : "fx:id=\"tblCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtCiudadCliente != null : "fx:id=\"txtCiudadCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnNumeroDocumentoCliente != null : "fx:id=\"columnNumeroDocumentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtEmailCliente != null : "fx:id=\"txtEmailCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnDepartamentoCliente != null : "fx:id=\"columnDepartamentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtNumeroDocumentoCliente != null : "fx:id=\"txtNumeroDocumentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnActualizarCliente != null : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnNombreCliente != null : "fx:id=\"columnNombreCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnBorrarCuentaCliente != null : "fx:id=\"btnBorrarCuentaCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtDepartamentoCliente != null : "fx:id=\"txtDepartamentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtFechaNacimientoCliente != null : "fx:id=\"txtFechaNacimientoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert txtNombreCliente != null : "fx:id=\"txtNombreCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert TxtInteraccionCliente != null : "fx:id=\"TxtInteraccionCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert btnLimpiarCliente != null : "fx:id=\"btnLimpiarCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnCiudadCliente != null : "fx:id=\"columnCiudadCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnEmailCliente != null : "fx:id=\"columnEmailCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnFechaNacimientoCliente != null : "fx:id=\"columnFechaNacimientoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert columnTipoDocumentoCliente != null : "fx:id=\"columnTipoDocumentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";
        assert splitMenuTipoDocumentoCliente != null : "fx:id=\"splitMenuTipoDocumentoCliente\" was not injected: check your FXML file 'RegistroCliente.fxml'.";

    }
}
