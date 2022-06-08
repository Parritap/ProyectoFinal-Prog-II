package co.uniquindio.proyectoFinal.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.uniquindio.proyectoFinal.model.Cliente;
import co.uniquindio.proyectoFinal.model.Empresa;
import co.uniquindio.proyectoFinal.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FuncionalidadesExtraController {

	Singleton singleton = Singleton.getInstance();
	
	Empresa empresa = singleton.empresa;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button bntConsultarFechaMasVentaProducto;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private Button btnConsultarTresProductosMasVendidos;

    @FXML
    private Button btnObtenerClienteMasCompra;

    @FXML
    private TextArea textArea;

    @FXML
    void obtenerClienteMasCompraAction(ActionEvent event) {
    	obtenerClienteMasComprador();
    }

    private void obtenerClienteMasComprador() {
    	limpiarCampo();
    	Cliente cliente = new Cliente();
    	cliente = empresa.encontrarClienteMasCompra();
    	String clienteMasCompra = cliente.toString();
		textArea.setText(clienteMasCompra);
	}

	@FXML
    void consultarFechaMasVentaProductoAction(ActionEvent event) {
		limpiarCampo();
		consultarFechaMasVentaProducto();
    }

    private void consultarFechaMasVentaProducto() {
		String nombreProducto = txtNombreProducto.getText();
		String fecha = empresa.determinarFechaProductoMasVendido(nombreProducto);
		textArea.setText(fecha);
		
	}

	@FXML
    void consultarTresProductoMasVendidosAction(ActionEvent event) {
    	consultarTresProductosMasVendidos();
    }

    private void consultarTresProductosMasVendidos() {
    	limpiarCampo();
		ArrayList <Producto> productosMasVendidos = new ArrayList <>();
		productosMasVendidos = empresa.obtenerTresProductosMasVendidos();
		textArea.setText(productosMasVendidos.toString());
		
		
	}

	@FXML
    void limpiarAction(ActionEvent event) {
    	limpiarCampo();
    }

    private void limpiarCampo() {
		textArea.setText("");
		txtNombreProducto.setText("");
		
	}

	@FXML
    void initialize() {
       
    }
}
