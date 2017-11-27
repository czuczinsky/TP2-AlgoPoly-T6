package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaQuini6 extends VistaRectangulo implements Dibujable {

	public VistaQuini6(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, StackPane pane,
			double x, double y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaQuini6 Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		return new VistaQuini6(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/quini6.png");
		super.dibujar();
	}

}