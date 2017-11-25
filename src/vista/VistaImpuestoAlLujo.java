package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaImpuestoAlLujo extends VistaRectangulo implements Dibujable {

	public VistaImpuestoAlLujo(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaImpuestoAlLujo Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaImpuestoAlLujo(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/impuesto.png");
		this.etiquetar("IMPUESTO AL LUJO", Color.BLACK);
		super.dibujar();
	}

}
