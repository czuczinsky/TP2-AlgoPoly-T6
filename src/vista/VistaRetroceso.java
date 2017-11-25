package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaRetroceso extends VistaRectangulo implements Dibujable {

	public VistaRetroceso(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public static VistaRetroceso Instancia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaRetroceso(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/retroceso.png");
		this.etiquetar("RETROCESO", Color.BLACK);
		super.dibujar();
	}
}
