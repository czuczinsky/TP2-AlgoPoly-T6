package vista;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modelo.Agrupable;
import modelo.Carcel;
import modelo.Casillero;
import modelo.Tablero;
//import modelo.Robot;
import sun.misc.GC;

public class VistaTablero {

	// private Robot robot;
	Canvas canvas;
	ArrayList<VistaCasillero> vistaCasilleros;

	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.canvas = canvas;

		vistaCasilleros = new ArrayList<VistaCasillero>();
		ArrayList<Casillero> casilleros = tablero.getCasilleros();
		int cantidad = casilleros.size();
		int porLinea = cantidad / 4;
		double ancho = canvas.getWidth() / (porLinea + 1);
		double alto = canvas.getHeight() / (porLinea + 1);
		double x;
		double y;
		int i=0;
		for (Casillero casillero : casilleros) {
			x = 0;
			y = 0;
			if (i < porLinea) {
				x = canvas.getWidth() - ancho * (i + 1);
				y = canvas.getHeight() - alto;
			} else if (i < porLinea * 2) {
				x = 0;
				y = canvas.getHeight() - alto * (i + 1 - porLinea);
			} else if (i < porLinea * 3) {
				x = ancho * (i - 2 * porLinea);
				y = 0;
			} else {
				x = canvas.getWidth() - ancho;
				y = alto * (i - 3 * porLinea);
			}
			vistaCasilleros.add(new VistaCasillero(casillero, canvas, x, y, ancho, alto));
			i++;
		}

	}

	public void dibujar() {
		this.clean();
		for (VistaCasillero vistaCasillero : vistaCasilleros)
			vistaCasillero.dibujar();
		
	}

	public void clean() {
		canvas.getGraphicsContext2D().setFill(Color.LIGHTBLUE);
		canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void update() {
		this.dibujar();
	}

}