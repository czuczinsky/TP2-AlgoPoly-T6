package eventos;

import modelo.AlgoPoly;
import vista.ContenedorPrincipal;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverHandler implements EventHandler<ActionEvent> {
	private AlgoPoly algoPoly;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonMoverHandler(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		algoPoly.mover();
		
		URL url = getClass().getResource("../sonidos/SUCTION.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		contenedorPrincipal.refrescar();
	}
}
