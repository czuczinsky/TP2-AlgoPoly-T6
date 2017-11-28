package eventos;

import modelo.AlgoPoly;
import modelo.Quini6;
import vista.ContenedorPrincipal;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
		
		// el algoPoly.mover te cambia el jugador actual.
		// por eso el sonido se escucha en el turno siguiente del jugador que cayo en quni6

		if ((algoPoly.getJugadorActual().getPosicion()) instanceof Quini6 ) {

// sobraba el file: en "file:src/vista/sonidos/Quini6.mp3"	
		String path = "src/vista/sonidos/Quini6.mp3";
//		String path = "file:src/vista/sonidos/Quini6.mp3";

		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
//		mediaPlayer.setAutoPlay(true);
//		MediaView mediaView = new MediaView(mediaPlayer);
//		mediaPlayer.setAutoPlay(true);
//		MediaView mediaView = new MediaView(mediaPlayer);
		}
		contenedorPrincipal.refrescar();
	}
	
}
