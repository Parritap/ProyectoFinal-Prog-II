package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Factura;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

public class VerFacturasController {

    Empresa empresa = Singleton.getInstance().getEmpresa();

    Cliente cliente;

    @FXML
    private ListView<Factura> listView;

    @FXML
    private TableView<String> tableView;

    @FXML
    private DatePicker datePicker;

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


}