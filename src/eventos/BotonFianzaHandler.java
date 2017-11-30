package eventos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import modelo.AlgoPoly;
import modelo.Carcel;
import vista.ContenedorPrincipal;

public class BotonFianzaHandler implements EventHandler<MouseEvent> {
	private AlgoPoly algoPoly;
	private Carcel carcel;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonFianzaHandler(AlgoPoly algoPoly, Carcel carcel, ContenedorPrincipal contenedorPrincipal) {
		this.algoPoly = algoPoly;
		this.carcel = carcel;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		this.carcel.cobrarFianza(algoPoly.getJugadorActual());

		URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		this.mostrarAlert("Pag\u00f3 fianza.");
		
		this.contenedorPrincipal.refrescar();
	}
	
	private void mostrarAlert(String mensaje) {
		Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
		dialogoAlerta.setTitle("");
		dialogoAlerta.setHeaderText(null);
		dialogoAlerta.setContentText(mensaje);
		dialogoAlerta.initStyle(StageStyle.UTILITY);
		dialogoAlerta.showAndWait();
	}
}
