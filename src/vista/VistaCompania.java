package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaCompania(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		if (casillero.getNombre() == "AYSA") {
			this.ponerImagen("file:src/vista/imagenes/aysa.png");
		}
		if (casillero.getNombre() == "EDESUR") {
			this.ponerImagen("file:src/vista/imagenes/edesur.png");
		}
		if (casillero.getNombre() == "TREN") {
			this.ponerImagen("file:src/vista/imagenes/tren.png");
			this.etiquetar("TRENES", Color.WHITE);
		}
		if (casillero.getNombre() == "SUBTE") {
			this.ponerImagen("file:src/vista/imagenes/subte.png");
			this.etiquetar("SUBTE", Color.BLACK);
		}
	}
}