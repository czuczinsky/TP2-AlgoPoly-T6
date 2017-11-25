package vista;

import javax.swing.JOptionPane;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.Casillero;

public abstract class VistaRectangulo {
	private Casillero casillero;
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private StackPane pane;

	public VistaRectangulo(Casillero casillero, StackPane pane, Canvas canvas, double x, double y, double ancho, double alto) {
		this.casillero = casillero;
		this.pane = pane;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void pintar(Color color) {
		final Canvas canvas = new Canvas(ancho, ancho);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(color);
		gc.fillRect(0, 0, ancho, alto);
		this.pane.getChildren().add(canvas);
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}

	public void etiquetar(String etiqueta, Color color) {
		Text text = new Text(etiqueta);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		text.setFill(color);
		// text.setStroke(Color.web("#7080A0"));

		this.pane.getChildren().add(text);
		text.setTranslateX(x + 10);
		text.setTranslateY(y + alto - 12);
		// this.pane.setAlignment(Pos.CENTER_RIGHT); // Right-justify nodes in stack
		// StackPane.setMargin(text, new Insets(0, 10, 0, 0)); // Center "?"

	}

	public void ponerImagen(String sImagen) {
		Image image = new Image(sImagen);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		this.pane.getChildren().add(imageView);
		imageView.setTranslateX(x + (ancho - image.getWidth()) / 2);
		imageView.setTranslateY(y + (alto - image.getHeight()) / 2);
	}
	
	public Casillero getCasillero() {
		return casillero;
	}
	
	public void ponerBotonConstruir() {
	       ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construir.png");
			this.pane.getChildren().add(iconoConstruir);
			iconoConstruir.setTranslateX(x);
	        iconoConstruir.setTranslateY(y);
	        iconoConstruir.setOnMouseClicked(e -> {
	        	JOptionPane.showMessageDialog(null, "Presiono el botonito!!!");
	        });
	}

	public void ponerFichasJugador() {
		// TODO necesita array de jugadores para saber la posicion de c/u
	}
}
