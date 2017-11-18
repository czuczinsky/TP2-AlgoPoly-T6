package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaTerreno extends VistaRectangulo implements Dibujable {

	public VistaTerreno(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaTerreno Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaTerreno(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		if (casillero.getNombre().equals("TUCUMAN")) {
			this.pintar(Color.BLUEVIOLET);
		} else {
			this.pintar(Color.BROWN);
		}
		this.etiquetar(casillero.getNombre());
	}

}
