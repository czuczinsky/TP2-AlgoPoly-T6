package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import modelo.Casillero;

public class VistaSalida extends VistaRectangulo implements Dibujable {

	public VistaSalida(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaSalida Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaSalida(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		
		this.pintar(Color.GAINSBORO);
		Image image = new Image("file:src/vista/imagenes/salida.png");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
		canvas.getGraphicsContext2D().setFill(Color.WHITE);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.BOTTOM);
		canvas.getGraphicsContext2D().fillText("", x + ancho / 2, y + alto);	}
}
