package co.uniquindio.proyectoFinal.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class application extends Application {

	private Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("tiendas Quindio");
		mostrarVentanaPrincipal();
		
	}
	
	public void mostrarVentanaPrincipal(){
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/Login.fxml"));
			
			AnchorPane root = (AnchorPane) loader.load();
			
		//	loginController = loader.getController();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
