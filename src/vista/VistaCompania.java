package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Compania;
import modelo.Jugador;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane,
			int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaCompania(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		Jugador propietario;
		Compania compania = (Compania) this.getCasillero();
		if (compania.tienePropietario()) {
			propietario = compania.getPropietario();
			this.pintar(propietario);
		} else
			this.pintar(Color.GAINSBORO);

		if (compania.getNombre() == "AYSA") {
			this.ponerImagen("file:src/vista/imagenes/aysa.png");
		}
		if (compania.getNombre() == "EDESUR") {
			this.ponerImagen("file:src/vista/imagenes/edesur.png");
		}
		if (compania.getNombre() == "TREN") {
			this.ponerImagen("file:src/vista/imagenes/tren.png");
			this.etiquetar("TRENES", Color.BLACK);
		}
		if (compania.getNombre() == "SUBTE") {
			this.ponerImagen("file:src/vista/imagenes/subte.png");
			this.etiquetar("SUBTE", Color.BLACK);
		}
		super.dibujar();
		this.ponerBotones();
	}

	private void ponerBotones() {
		if (((Compania) this.getCasillero()).puedeComprarsePor(this.getAlgoPoly().getJugadorActual()))
			this.ponerBotonComprar();
		if (((Compania) this.getCasillero()).puedeVendersePor(this.getAlgoPoly().getJugadorActual()))
			this.ponerBotonVender();
		this.ponerBotonInfo("$" + String.valueOf(((Compania) this.getCasillero()).getPrecio()), "Precio");
	}
}