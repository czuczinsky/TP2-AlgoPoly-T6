package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
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
	
	public void pintar(Color color) {
		canvas.getGraphicsContext2D().setFill(color);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
	}

	
	public void etiquetar(String etiqueta) {
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		canvas.getGraphicsContext2D().fillText(etiqueta,x + ancho / 2, y + alto / 2);
	}
}
