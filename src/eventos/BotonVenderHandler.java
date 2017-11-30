package eventos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import modelo.Agrupable;
import vista.ContenedorPrincipal;

public class BotonVenderHandler implements EventHandler<MouseEvent> {
	private Agrupable agrupable;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonVenderHandler(Agrupable agrupable, ContenedorPrincipal contenedorPrincipal) {
		this.agrupable = agrupable;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(MouseEvent event) {
		agrupable.vender();

		URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();

		this.mostrarAlert("Vendi\u00f3 " + agrupable.getNombre() + ".");

		contenedorPrincipal.refrescar();
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
