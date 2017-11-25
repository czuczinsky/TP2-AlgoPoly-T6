package vista;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;
import modelo.Tablero;

public class VistaTablero {

	Canvas canvas;
	ArrayList<VistaCasillero> vistaCasilleros;

	public VistaTablero(Tablero tablero, StackPane pane) {
		canvas = new Canvas(850, 600);
		pane.getChildren().add(canvas);

		
		double separacion = 10;
		vistaCasilleros = new ArrayList<VistaCasillero>();
		ArrayList<Casillero> casilleros = tablero.getCasilleros();
		int cantidad = casilleros.size();
		int porLinea = cantidad / 4;
		double ancho = canvas.getWidth() / (porLinea + 1);
		double alto = canvas.getHeight() / (porLinea + 1);
		double x;
		double y;
		int i = 0;
		for (Casillero casillero : casilleros) {
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

			vistaCasilleros.add(new VistaCasillero(casillero, canvas, x + separacion / 2, y + separacion / 2,
					ancho - separacion, alto - separacion));
			i++;
		}

	}

	public void dibujar() {
		this.clean();
		for (VistaCasillero vistaCasillero : vistaCasilleros)
			vistaCasillero.dibujar();
	}

	public void clean() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.CHARTREUSE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		Image image = new Image("file:src/vista/imagenes/AlgoPolyLogo.png");
		gc.drawImage(image, (canvas.getWidth() - image.getWidth()) / 2, (canvas.getHeight() - image.getHeight()) / 2);
		
		//Image imageDados = new Image("file:src/vista/imagenes/dados.gif");
		//gc.drawImage(imageDados, (canvas.getWidth() - imageDados.getWidth()) / 2, (canvas.getHeight() - image.getHeight()) /3);
	
	}

	public void update() {
		this.dibujar();
	}

}
