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

	ArrayList<VistaCasillero> vistaCasilleros;
	double ancho;
	double alto;
	StackPane pane;

	public VistaTablero(Tablero tablero, StackPane pane) {
		ancho = 850;
		alto = 600;
		this.pane = pane;

		double separacion = 10;
		vistaCasilleros = new ArrayList<VistaCasillero>();
		ArrayList<Casillero> casilleros = tablero.getCasilleros();
		int cantidad = casilleros.size();
		int porLinea = cantidad / 4;
		double anchoCasillero = this.ancho / (porLinea + 1);
		double altoCasillero = this.alto / (porLinea + 1);
		double x;
		double y;
		int i = 0;
		for (Casillero casillero : casilleros) {
			if (i < porLinea) {
				x = this.ancho - anchoCasillero * (i + 1);
				y = this.alto - altoCasillero;
			} else if (i < porLinea * 2) {
				x = 0;
				y = this.alto - altoCasillero * (i + 1 - porLinea);
			} else if (i < porLinea * 3) {
				x = anchoCasillero * (i - 2 * porLinea);
				y = 0;
			} else {
				x = this.ancho - anchoCasillero;
				y = altoCasillero * (i - 3 * porLinea);
			}

			vistaCasilleros.add(new VistaCasillero(casillero, pane, x + separacion / 2, y + separacion / 2,
					anchoCasillero - separacion, altoCasillero - separacion));
			i++;
		}

	}

	public void dibujar() {
		this.clean();
		for (VistaCasillero vistaCasillero : vistaCasilleros)
			vistaCasillero.dibujar();
	}

	public void clean() {
		Canvas canvas = new Canvas(ancho, alto);
		pane.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.CHARTREUSE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		Image image = new Image("file:src/vista/imagenes/AlgoPolyLogo.png");
		gc.drawImage(image, (canvas.getWidth() - image.getWidth()) / 2, (canvas.getHeight() - image.getHeight()) / 2);

		// Image imageDados = new Image("file:src/vista/imagenes/dados.gif");
		// gc.drawImage(imageDados, (canvas.getWidth() - imageDados.getWidth()) / 2,
		// (canvas.getHeight() - image.getHeight()) /3);

	}

	public void update() {
		this.dibujar();
	}

}
