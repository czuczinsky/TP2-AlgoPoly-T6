package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.Casillero;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero,canvas,x,y,ancho,alto);
	}

	public static VistaCompania Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		return new VistaCompania(casillero,canvas,x,y,ancho,alto);
	}

	public void dibujar() {
		canvas.getGraphicsContext2D().setFill(Color.GOLD);
		canvas.getGraphicsContext2D().fillRect(x, y, ancho, alto);
		this.etiquetar(casillero.getNombre());
	}

}
