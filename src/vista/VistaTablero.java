package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import modelo.Robot;
import sun.misc.GC;

public class VistaTablero {

	// private Robot robot;
	Canvas canvas;

	public VistaTablero(Canvas canvas) {
		// this.robot = robot;
		this.canvas = canvas;
	}

	public void dibujar() {
		this.dibujarFormas();
	}

	private void dibujarFormas() {
		int cantidad = 20; // TODO sacarlo de la cantidad de casilleros en tablero ( debe ser 4*n )
		int porLinea = cantidad / 4;
		double ancho = canvas.getWidth()/(porLinea+1);
		double alto = canvas.getHeight()/(porLinea+1);
		double x;
		double y;
		this.clean();
		for (int i = 0; i < cantidad; i++) {
			x = 0;
			y = 0;
			if (i < porLinea) {
				canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
				x = canvas.getWidth() - ancho * (i + 1);
				y = canvas.getHeight() - alto;
			} else if (i < porLinea * 2) {
				canvas.getGraphicsContext2D().setFill(Color.GREEN);
				x = 0;
				y = canvas.getHeight() - alto * (i + 1 - porLinea);
			} else if (i < porLinea * 3) {
				canvas.getGraphicsContext2D().setFill(Color.RED);
				x = ancho * (i - 2 * porLinea);
				y = 0;
			} else {
				canvas.getGraphicsContext2D().setFill(Color.ORANGE);
				x = canvas.getWidth() - ancho;
				y = alto * (i - 3 * porLinea);

			}
			canvas.getGraphicsContext2D().fillRect(x + 1, y + 1, ancho - 2, alto - 2);
			canvas.getGraphicsContext2D().setFill(Color.BLACK);
			canvas.getGraphicsContext2D().fillText(String.valueOf(i), x + ancho / 2, y + alto / 2);
		}
	}

	public void clean() {
		canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
		canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void update() {
		this.dibujar();
	}

}
