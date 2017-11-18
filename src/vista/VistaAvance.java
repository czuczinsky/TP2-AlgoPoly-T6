package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import modelo.Casillero;

public class VistaAvance extends VistaRectangulo implements Dibujable {

	public VistaAvance(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero,canvas,x,y,ancho,alto);
	}

	public static VistaAvance Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		return new VistaAvance(casillero,canvas,x,y,ancho,alto);
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
		this.etiquetar("AVANCE");
	}
}
