package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Compania;
import modelo.Jugador;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaCompania(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		Jugador propietario;
		Compania compania = (Compania) this.getCasillero();
		if (compania.tienePropietario()) {
			propietario = compania.getPropietario();
			this.pintar(propietario);
		} else
			this.pintar(Color.GAINSBORO);


		if (this.getCasillero().getNombre() == "AYSA") {
			this.ponerImagen("file:src/vista/imagenes/aysa.png");
		}
		if (this.getCasillero().getNombre() == "EDESUR") {
			this.ponerImagen("file:src/vista/imagenes/edesur.png");
		}
		if (this.getCasillero().getNombre() == "TREN") {
			this.ponerImagen("file:src/vista/imagenes/tren.png");
			this.etiquetar("TRENES", Color.WHITE);
		}
		if (this.getCasillero().getNombre() == "SUBTE") {
			this.ponerImagen("file:src/vista/imagenes/subte.png");
			this.etiquetar("SUBTE", Color.BLACK);
		}
		super.dibujar();
	}
}