package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaAvance extends VistaRectangulo implements Dibujable {

	public VistaAvance(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaAvance Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaAvance(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/avance.png");
		this.etiquetar("AVANCE", Color.BLACK);
		super.dibujar();
	}
}
