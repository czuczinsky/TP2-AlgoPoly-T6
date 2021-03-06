package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaPolicia extends VistaRectangulo {

	public VistaPolicia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane,
			int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaPolicia Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaPolicia(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/policia.png");
		this.etiquetar("POLICIA", Color.BLACK);
		super.dibujar();
		this.ponerBotonInfo("Envia a la Carcel", "Accion");
	}
}
