package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaAvance extends VistaRectangulo implements Dibujable {

	public VistaAvance(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, StackPane pane,
			double x, double y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaAvance Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		return new VistaAvance(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/avance.png");
		this.etiquetar("AVANCE", Color.BLACK);
		super.dibujar();
	}
}
