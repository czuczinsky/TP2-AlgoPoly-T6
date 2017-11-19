package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import modelo.Casillero;

public class VistaCompania extends VistaRectangulo implements Dibujable {

	public VistaCompania(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaCompania Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaCompania(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		//this.pintar(Color.GOLD);
		//this.etiquetar(casillero.getNombre());
	
	
	 if (casillero.getNombre()=="AYSA") {
	  //this.pintar(Color.GAINSBORO);
	 
	Image image = new Image("file:src/vista/imagenes/aysa.png");
	GraphicsContext gc = canvas.getGraphicsContext2D();
	gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
	canvas.getGraphicsContext2D().setFill(Color.WHITE);
	gc.setTextAlign(TextAlignment.CENTER);
	gc.setTextBaseline(VPos.BOTTOM);
	canvas.getGraphicsContext2D().fillText("", x + ancho / 2, y + alto);
	 }
	 if (casillero.getNombre()=="EDESUR") {
		 
			Image image = new Image("file:src/vista/imagenes/edesur.png");
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
			canvas.getGraphicsContext2D().setFill(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.BOTTOM);
			canvas.getGraphicsContext2D().fillText("", x + ancho / 2, y + alto);
	 }
	 
	 if (casillero.getNombre()=="TREN") {
		 
			Image image = new Image("file:src/vista/imagenes/tren.png");
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
			canvas.getGraphicsContext2D().setFill(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.BOTTOM);
			canvas.getGraphicsContext2D().fillText("TRENES", x + ancho / 2, y + alto);
	 }
	 
	 if (casillero.getNombre()=="SUBTE") {
		 
			Image image = new Image("file:src/vista/imagenes/subte.png");
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
			canvas.getGraphicsContext2D().setFill(Color.BLACK);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.BOTTOM);
			canvas.getGraphicsContext2D().fillText("SUBTE", x + ancho / 2, y + alto);
	 }
}

}