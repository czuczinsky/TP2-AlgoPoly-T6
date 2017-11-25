package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaCarcel extends VistaRectangulo implements Dibujable {

	public VistaCarcel(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaCarcel Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaCarcel(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/prision.png");
		this.etiquetar("CARCEL", Color.WHITE);
	}
}
