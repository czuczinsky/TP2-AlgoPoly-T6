package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Carcel;
import modelo.Casillero;

public class VistaCarcel extends VistaRectangulo implements Dibujable {

	public VistaCarcel(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, StackPane pane,
			double x, double y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaCarcel Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		return new VistaCarcel(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/prision.png");
		this.etiquetar("CARCEL", Color.BLACK);
		super.dibujar();
		this.ponerBotones();

	}

	private void ponerBotones() {
		if (((Carcel) this.getCasillero()).puedePagarFianza(this.getAlgoPoly().getJugadorActual()))
			this.ponerBotonPagarFianza();
	}
}
