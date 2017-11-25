package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaQuini6 extends VistaRectangulo implements Dibujable {

	public VistaQuini6(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaQuini6 Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaQuini6(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/quini6.png");
		super.dibujar();
	}

}