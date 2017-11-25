package vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;
import modelo.Compania;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(casillero, pane, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		return new VistaCompania(casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		Compania comapnia = (Compania) this.getCasillero();
		if (comapnia.tienePropietario())
			if (comapnia.getPropietario().getNombre().equals("Rojo"))

				this.pintar(Color.RED);
			else if (comapnia.getPropietario().getNombre().equals("Verde"))
				this.pintar(Color.GREEN);
			else if (comapnia.getPropietario().getNombre().equals("Azul"))
				this.pintar(Color.BLUE);
			else
				this.pintar(Color.GAINSBORO);
		else
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