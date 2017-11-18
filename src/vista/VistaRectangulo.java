package vista;

import javafx.scene.canvas.Canvas;
import modelo.Casillero;

public abstract class VistaRectangulo {
	Casillero casillero;
	Canvas canvas;
	double x;
	double y;
	double ancho;
	double alto;

	public VistaRectangulo(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		this.casillero = casillero;
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}
}
