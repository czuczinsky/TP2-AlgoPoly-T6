package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaRetroceso extends VistaRectangulo implements Dibujable {

	public VistaRetroceso(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane,
			int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaRetroceso Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaRetroceso(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		this.pintar(Color.GAINSBORO);
		this.ponerImagen("file:src/vista/imagenes/retroceso.png");
		this.etiquetar("RETROCESO", Color.BLACK);
		super.dibujar();
		this.ponerBotonInfo(
				"Dados: 2,3,4,5,6  >>  Retrocede Dados-Propiedades\nDados: 7,8,9,10  >>  Retrocede Efectivo%Dados\nDados: 11 o 12  >>  Retrocede Dados-2",
				"Retroceso Dinamico");
	}
}
