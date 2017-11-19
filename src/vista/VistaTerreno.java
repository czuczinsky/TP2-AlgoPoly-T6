package vista;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import modelo.Casillero;

public class VistaTerreno extends VistaRectangulo implements Dibujable {

	public VistaTerreno(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaTerreno Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaTerreno(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		/*if (casillero.getNombre().equals("TUCUMAN")) {
			this.pintar(Color.BLUEVIOLET);
		} else {
			this.pintar(Color.BROWN);
		}
		this.etiquetar(casillero.getNombre());
	}
*/
		if (casillero.getNombre()=="Bs.As. SUR") {
			  //this.pintar(Color.GAINSBORO);
			 
			Image image = new Image("file:src/vista/imagenes/bsas.png");
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
			canvas.getGraphicsContext2D().setFill(Color.BLACK);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.BOTTOM);
			canvas.getGraphicsContext2D().fillText("Bs.As. SUR", x + ancho / 2, y + alto);
			 }
			 if (casillero.getNombre()=="Bs.As. NORTE") {
				 
					Image image = new Image("file:src/vista/imagenes/bsas.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("Bs.As. NORTE", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="CORDOBA SUR") {
				 
					Image image = new Image("file:src/vista/imagenes/cordoba.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("CORDOBA SUR", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="CORDOBA NORTE") {
				 
					Image image = new Image("file:src/vista/imagenes/cordoba.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("CORDOBA NORTE", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="SALTA SUR") {
				 
					Image image = new Image("file:src/vista/imagenes/salta.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("SALTA SUR", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="SALTA NORTE") {
				 
					Image image = new Image("file:src/vista/imagenes/salta.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("SALTA NORTE", x + ancho / 2, y + alto);
			 }
			 if (casillero.getNombre()=="NEUQUEN") {
				 
					Image image = new Image("file:src/vista/imagenes/neuquen.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("NEUQUEN", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="TUCUMAN") {
				 
					Image image = new Image("file:src/vista/imagenes/tucuman.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("TUCUMAN", x + ancho / 2, y + alto);
			 }
			 
			 if (casillero.getNombre()=="SANTA FE") {
				 
					Image image = new Image("file:src/vista/imagenes/santafe.png");
					GraphicsContext gc = canvas.getGraphicsContext2D();
					gc.drawImage(image, x + (ancho - image.getWidth()) / 2, y + (alto - image.getHeight()) / 2);
					canvas.getGraphicsContext2D().setFill(Color.BLACK);
					gc.setTextAlign(TextAlignment.CENTER);
					gc.setTextBaseline(VPos.BOTTOM);
					canvas.getGraphicsContext2D().fillText("SANTA FE", x + ancho / 2, y + alto);
			 }
		}
		
		
}
