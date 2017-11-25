package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaPolicia extends VistaRectangulo implements Dibujable {

	public VistaPolicia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public static VistaPolicia Instancia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaPolicia(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/policia.png");
		this.etiquetar("POLICIA", Color.WHITE);
		super.dibujar();
	}
}
