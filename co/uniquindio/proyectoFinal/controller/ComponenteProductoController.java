package co.uniquindio.proyectoFinal.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ComponenteProductoController {

    @FXML
    private ImageView imgProducto;

    @FXML
    private Label txtDescripcionProducto;

    @FXML
    private Label txtNombreProducto;
    
    @FXML
    private Label txtPrecioProducto;

    @FXML
    void agregarAlCarrito(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    	
    	
    }
    
    public void setearCamposProducto(Image image, String descripcion, String nombre, double precio){
    	
    	imgProducto.setImage(image);
    	txtDescripcionProducto.setText(descripcion);
    	txtNombreProducto.setText(nombre);
    	txtPrecioProducto.setText(Double.toString(precio));
    	
    }
}

