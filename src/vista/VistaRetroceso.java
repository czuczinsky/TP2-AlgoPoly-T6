package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaRetroceso extends VistaRectangulo implements Dibujable {

	public VistaRetroceso(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero,canvas,x,y,ancho,alto);
	}

	public static VistaRetroceso Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		return new VistaRetroceso(casillero,canvas,x,y,ancho,alto);
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
		canvas.getGraphicsContext2D().setFill(Color.BLACK);
		canvas.getGraphicsContext2D().fillText("RETROCESO", x + 5, y + alto / 2);
	}

}
