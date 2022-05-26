package co.uniquindio.proyectoFinal.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DemoAppController {

    @FXML
    private Label myLabel;

    @FXML
    private Button myButton;


    public  void btnOnAction (){
        this.myLabel.setText("Hi!!!!!!!!!");
    }

}
