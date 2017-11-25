package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaRetroceso extends VistaRectangulo implements Dibujable {

	public VistaRetroceso(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaRetroceso Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaRetroceso(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/retroceso.png");
		this.etiquetar("RETROCESO", Color.BLACK);
		super.dibujar();
	}
}
