package eventos;

import modelo.AlgoPoly;
import vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirCasaHandler implements EventHandler<ActionEvent> {
	private AlgoPoly algoPoly;
	private ContenedorPrincipal contenedorPrincipal;

	public BotonConstruirCasaHandler(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		algoPoly.tirarDados();
		contenedorPrincipal.refrescar();
	}

}