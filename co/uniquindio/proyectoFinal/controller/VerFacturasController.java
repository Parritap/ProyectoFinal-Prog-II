package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Factura;
import co.uniquindio.proyectoFinal.model.enums.TipoDocumento;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class VerFacturasController implements Initializable {

    Empresa empresa = Singleton.getInstance().getEmpresa();


    //Voy a crear un cliente provisional, pero despues hay que borrarlo.
    Cliente cliente = empresa.obtenerCliente("cliente@cliente.com");


    @FXML
    private ListView<Factura> listView;

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

    public VerFacturasController() throws EmailNoValidoException {
    }

    @FXML
    void filtrarFacturas(ActionEvent event) {


    }

    @FXML
    void aaaaaa(
            ActionEvent event) {

    }

    @FXML
    void bbbbb(ActionEvent event) {

    }


    ObservableList<Factura> listaFacturas = FXCollections.observableArrayList(cliente.getListaFacturas());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        codigo.setCellValueFactory(new PropertyValueFactory<Factura, String>("codigo"));
        fecha.setCellValueFactory(new PropertyValueFactory<Factura, String>("fecha"));
        total.setCellValueFactory(new PropertyValueFactory<Factura, Double>("total"));
        subtotal.setCellValueFactory(new PropertyValueFactory<Factura, Double>("subtotal"));
        iva.setCellValueFactory(new PropertyValueFactory<Factura, Double>("iva"));
        sede.setCellValueFactory(new PropertyValueFactory<Factura, String>("sede"));

        this.tableView.setItems(listaFacturas);
    }
}