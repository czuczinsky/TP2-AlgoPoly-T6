package eventos;

//import java.applet.Applet;
//import java.applet.AudioClip;
//import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;

public class BotonPerderHandler implements EventHandler<ActionEvent>  {
	private AlgoPoly algoPoly;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonPerderHandler(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		algoPoly.quebrarJugador();
		
//		URL url = getClass().getResource("/vista/sonidos/SUCTION.WAV");
//		AudioClip clip = Applet.newAudioClip(url);
//		clip.play();
	
		contenedorPrincipal.refrescar();
	}

}
