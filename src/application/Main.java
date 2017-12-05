package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *  <h1>Clase Main:</h1>
 * 	Esta clase se encarga de la ejecuci�n del programa.
 *	@author Sergio Cuadrado
 *	@version 1.0
 */
public class Main extends Application {
	/**
	 * <h1>Variable stage</h1>
	 * Esta variable permite que usemos m�todos de la clase Stage de JavaFX.
	 * @see Stage
	 */
	Stage stage;
	/**
	 * <h1>M�todo start</h1>
	 * Esencial para los proyectos de JavaFX. Se ejecuta en el m�todo Main
	 * @param primaryStage par�metro que ser� usado asignadole el valor de la variable stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			mainWindow();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * <h1>M�todo Main</h1>
	 * M�todo principal. Este m�todo es indispensable para la ejecuci�n de cualquier
	 * programa en Java.
	 * @param args argumentos de tipo Array de String que se le pueden pasar al m�todo.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * <h1>M�todo mainWindow</h1>
	 * M�todo que se encarga de cargar la interfaz a partir de un archivo FXML.
	 */
	public void mainWindow() {
		try {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("ventana.fxml"));
	        AnchorPane pane=loader.load();
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setScene(new Scene(pane));
	        stage.show();
 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
