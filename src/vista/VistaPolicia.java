package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaPolicia extends VistaRectangulo implements Dibujable {

	public VistaPolicia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero,canvas,x,y,ancho,alto);
	}

	public static VistaPolicia Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		return new VistaPolicia(casillero,canvas,x,y,ancho,alto);
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.GAINSBORO);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
		this.etiquetar("POLICIA");
	}
}
