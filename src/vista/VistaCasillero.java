package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaCasillero {
	double x;
	double y;
	double ancho;
	double alto;
	Canvas canvas;

	public VistaCasillero(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.ORANGE);
		canvas.getGraphicsContext2D().fillRect(x + 1, y + 1, ancho - 2, alto - 2);
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillText("etiqueta", x + ancho / 2, y + alto / 2);
	}

}
