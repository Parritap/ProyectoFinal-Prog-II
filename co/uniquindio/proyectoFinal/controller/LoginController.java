package co.uniquindio.proyectoFinal.controller;

import co.uniquindio.proyectoFinal.model.Administrador;
import co.uniquindio.proyectoFinal.model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

	Empresa empresa = Singleton.getInstance().getEmpresa();
	
    @FXML
    private Label LblMensajeErrorIngreso;

    @FXML
    private TextField txtContraseñaUsuarioIngresar;

    @FXML
    private TextField txtEmailUsuarioIngresar;

    @FXML
    void ingresarEnAplicacion(ActionEvent event) {

    }

    @FXML
    void registrarseEnAplicacion(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    	
    	
    }
}

