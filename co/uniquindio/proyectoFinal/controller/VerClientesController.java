package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.exceptions.EmailNoValidoException;
import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VerClientesController implements Initializable {

    Empresa empresa = Singleton.getInstance().getEmpresa();

    @FXML
    private Button btnMostrarTodosClientes;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField txtf_IdCliente;

    @FXML
    private TextField txtf_emailCliente;

    @FXML
    private Button btnFiltrarPorEmail;

    @FXML
    private Button btnFiltrarPorID;

    @FXML
    private TableView<Cliente> table;

    @FXML
    private TableColumn<Cliente, String> nombre;
    @FXML
    private TableColumn<Cliente, String> ID;
    @FXML
    private TableColumn<Cliente, String> email;

    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(empresa.getListaClientes());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        ID.setCellValueFactory(new PropertyValueFactory<Cliente, String>("documento"));
        email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));

        table.setItems(listaClientes);
    }


    @FXML
    void filtrarPorEmail(ActionEvent event) throws EmailNoValidoException {

        try {
            if (!txtf_emailCliente.getText().equals("")) {
                String email = txtf_emailCliente.getText();

                if (empresa.obtenerCliente(email) != null) {

                    listaClientes.setAll(empresa.obtenerCliente(email));
                }
            }
        } catch (EmailNoValidoException e) {
            this.textArea.setText("El email pasado no es valido");
        }


    }

    @FXML
    void filtrarPorID(ActionEvent event) {

        if (!txtf_IdCliente.getText().equals("")) {
            String doc = txtf_IdCliente.getText();

            if (empresa.obtenerClienteByDoc(doc) != null) {
                listaClientes.setAll(empresa.obtenerClienteByDoc(doc));
            }
            if(empresa.obtenerClienteByDoc(doc) == null){
                textArea.setText("No hay cliente\ncon el documento\nindicado");
            }
        }
    }

    @FXML
    void mostrarTodosLosClientes(ActionEvent event) {
        listaClientes.setAll(empresa.getListaClientes());
    }

}
