package eventos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Terreno;
import vista.ContenedorPrincipal;

public class BotonConstruirCasaHandler implements EventHandler<MouseEvent> {
	private Terreno terreno;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonConstruirCasaHandler(Terreno terreno, ContenedorPrincipal contenedorPrincipal) {
		this.terreno = terreno;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		terreno.construirCasa();

		URL url = getClass().getResource("../sonidos/CONSTRUIR.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		contenedorPrincipal.refrescar();
	}
}
