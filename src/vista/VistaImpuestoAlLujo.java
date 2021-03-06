package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaImpuestoAlLujo extends VistaRectangulo {

	public VistaImpuestoAlLujo(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero,
			GridPane pane, int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaImpuestoAlLujo Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaImpuestoAlLujo(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/impuesto.png");
		this.etiquetar("IMPUESTO AL LUJO", Color.BLACK);
		super.dibujar();
		this.ponerBotonInfo("Descuenta 10% de todo el efectivo", "Impuesto al lujo");
	}
}
