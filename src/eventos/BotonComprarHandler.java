package eventos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;

public class BotonComprarHandler implements EventHandler<ActionEvent> {
	private AlgoPoly algoPoly;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonComprarHandler(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		this.algoPoly.comprarAgrupagle();

		URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		contenedorPrincipal.refrescar();
	}
}
