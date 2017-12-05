package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller implements Initializable {
	/**
	 * Distintos AnchorPane usados en la interfaz, representan las diferentes "páginas" (pane1,pane2,pane3)
	 */
	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel;
	

	/**
	 * <h1>Método translateAnimations</h1>
	 * Este método establece la animación realizada al pasar a la siguiente slide.
	 * @param duration parametro double que indica los segundos.
	 * @param node parametro usado en caso de que exista un árbol(tree) en la interfaz
	 * @param byX parametro double usado para la posición
	 */
	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
	}

	int showSlide = 0;

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
		}

	}

}
