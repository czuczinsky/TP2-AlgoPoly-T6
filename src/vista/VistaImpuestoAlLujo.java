package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaImpuestoAlLujo extends VistaRectangulo implements Dibujable {

	public VistaImpuestoAlLujo(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public static VistaImpuestoAlLujo Instancia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaImpuestoAlLujo(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/impuesto.png");
		this.etiquetar("IMPUESTO AL LUJO", Color.BLACK);
		super.dibujar();
	}

}
