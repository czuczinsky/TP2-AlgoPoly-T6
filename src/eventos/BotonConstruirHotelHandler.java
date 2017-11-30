package eventos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.Terreno;
import vista.ContenedorPrincipal;

public class BotonConstruirHotelHandler implements EventHandler<MouseEvent> {
	private Terreno terreno;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonConstruirHotelHandler(Terreno terreno, ContenedorPrincipal contenedorPrincipal) {
		this.terreno = terreno;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		terreno.construirHotel();

		URL url = getClass().getResource("../sonidos/CONSTRUIR2.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		contenedorPrincipal.refrescar();
	}
}
