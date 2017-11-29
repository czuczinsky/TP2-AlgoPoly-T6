package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaSalida extends VistaRectangulo implements Dibujable {

	public VistaSalida(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaSalida Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane, int x, int y, double ancho,
			double alto) {
		return new VistaSalida(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/salida.png");
		super.dibujar();
	}
}
