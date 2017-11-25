package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaPolicia extends VistaRectangulo implements Dibujable {

	public VistaPolicia(Casillero casillero, StackPane pane, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, pane, canvas, x, y, ancho, alto);
	}

	public static VistaPolicia Instancia(Casillero casillero, StackPane pane, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaPolicia(casillero, pane, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/policia.png");
		this.etiquetar("POLICIA", Color.WHITE);
	}
}
