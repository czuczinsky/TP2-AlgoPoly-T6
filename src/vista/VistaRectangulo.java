package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import modelo.Casillero;

public abstract class VistaRectangulo {
	private Casillero casillero;
	private Canvas canvas;
	private double x;
	private double y;
	private double ancho;
	private double alto;

	public VistaRectangulo(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		this.casillero = casillero;
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void pintar(Color color) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.fillRect(x, y, ancho, alto);
	}

	public void etiquetar(String etiqueta, Color color) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BOTTOM);
		gc.fillText(etiqueta, x + ancho / 2, y + alto);
	}

	public void ponerImagen(String sImagen) {
		Image image = new Image(sImagen);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
	}
	
	public Casillero getCasillero() {
		return casillero;
	}

}
