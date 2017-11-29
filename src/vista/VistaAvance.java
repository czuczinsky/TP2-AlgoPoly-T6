package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaAvance extends VistaRectangulo {

	public VistaAvance(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane,
			int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaAvance Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero,
			GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaAvance(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/avance.png");
		this.etiquetar("AVANCE", Color.BLACK);
		super.dibujar();
		this.ponerBotonInfo(
				"Dados: 2,3,4,5,6  >>  Avanza Dados-2\nDados: 7,8,9,10  >>  Avanza Efectivo%Dados\nDados: 11 o 12  >>  Avanza Dados-Propiedades",
				"Avance Dinamico");
	}
}