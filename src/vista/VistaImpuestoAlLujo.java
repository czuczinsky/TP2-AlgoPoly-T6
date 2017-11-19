package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaImpuestoAlLujo extends VistaRectangulo implements Dibujable {

	public VistaImpuestoAlLujo(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaImpuestoAlLujo Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaImpuestoAlLujo(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/impuesto.png");
		this.etiquetar("IMPUESTO AL LUJO", Color.BLACK);
	}

}
