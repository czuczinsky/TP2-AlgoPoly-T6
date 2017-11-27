package vista;

import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Agrupable;
import modelo.Terreno;

public abstract class VistaRectangulo implements Dibujable {
	private AlgoPoly algoPoly;
	private Casillero casillero;
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private StackPane pane;

	public VistaRectangulo(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho,
			double alto) {
		this.algoPoly = algoPoly;
		this.casillero = casillero;
		this.pane = pane;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void pintar(Color color) {
		Rectangle fondo = new Rectangle(0, 0, ancho, alto);
		fondo.setFill(color);
		this.pane.getChildren().add(fondo);
		fondo.setTranslateX(x);
		fondo.setTranslateY(y);
	}

	public void pintar(Jugador propietario) {
		Rectangle fondo = new Rectangle(0, 0, ancho, alto);
		if (propietario.getNombre().equals("Rojo"))
			fondo.setFill(Color.RED);
		if (propietario.getNombre().equals("Verde"))
			fondo.setFill(Color.GREEN);
		if (propietario.getNombre().equals("Azul"))
			fondo.setFill(Color.BLUE);

		this.pane.getChildren().add(fondo);
		fondo.setTranslateX(x);
		fondo.setTranslateY(y);
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
		// StackPane.setMargin(text, new Insets(0, 10, 0, 0));

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

	public void ponerBotonComprar() {
		ImageView iconoComprar = new ImageView("file:src/vista/imagenes/changuito.png");
		iconoComprar.setFitWidth(30);
        iconoComprar.setFitHeight(30);
        iconoComprar.setPreserveRatio(true);
        iconoComprar.setSmooth(true);
		this.pane.getChildren().add(iconoComprar);
		iconoComprar.setTranslateX(x);
		iconoComprar.setTranslateY(y);
		iconoComprar.setOnMouseClicked(e -> {
			// TODO mover a Control. Agregar refresh
			((Agrupable) casillero).venderA(algoPoly.getJugadorActual());;
			
			JOptionPane.showMessageDialog(null, "Compro este sitio (Lo vera reflejado en el proximo turno)");
		});
	}
	public void ponerBotonConstruirCasa() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirCasa.png");
		this.pane.getChildren().add(iconoConstruir);
		iconoConstruir.setTranslateX(x);
		iconoConstruir.setTranslateY(y);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control. Agregar refresh
			((Terreno) casillero).construirCasa();
			JOptionPane.showMessageDialog(null, "Construyo casa (la muestra en proximo turno)");
		});
	}

	public void ponerBotonConstruirHotel() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirHotel.png");
		this.pane.getChildren().add(iconoConstruir);
		iconoConstruir.setTranslateX(x);
		iconoConstruir.setTranslateY(y);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control. Agregar refresh
			((Terreno) casillero).construirHotel();
			JOptionPane.showMessageDialog(null, "Construyo hotel (la muestra en proximo turno)");
		});
	}

	public void ponerCasa(int i) {
		ImageView iconoCasa = new ImageView("file:src/vista/imagenes/casa.png");
		this.pane.getChildren().add(iconoCasa);
		iconoCasa.setTranslateX(x + 28 + i * 40);
		iconoCasa.setTranslateY(y + 30);
	}

	public void ponerHotel() {
		ImageView iconoCasa = new ImageView("file:src/vista/imagenes/hotel.png");
		this.pane.getChildren().add(iconoCasa);
		iconoCasa.setTranslateX(x + 40);
		iconoCasa.setTranslateY(y + 20);
	}

	public void ponerFichasJugador() {
		double offset = 15;
		Image image = new Image("file:src/vista/imagenes/ficharoja.png");
		ImageView imageView;
		for (Jugador jugador : algoPoly.getJugadores()) {
			imageView = new ImageView();
			if (casillero.equals(jugador.getPosicion())) {
				imageView = new ImageView();
				if (jugador.getNombre().equals("Rojo")) {
					image = new Image("file:src/vista/imagenes/ficharoja.png");
					imageView.setTranslateX(x + 55 - offset);
				}
				if (jugador.getNombre().equals("Verde")) {
					image = new Image("file:src/vista/imagenes/fichaverde.png");
					imageView.setTranslateX(x + 55);
				}
				if (jugador.getNombre().equals("Azul")) {
					image = new Image("file:src/vista/imagenes/fichaazul.png");
					imageView.setTranslateX(x + 55 + offset);
				}
				imageView.setImage(image);
				imageView.setTranslateY(y + 25);
				imageView.setFitWidth(40);
				imageView.setFitHeight(40);
				imageView.setPreserveRatio(true);
				imageView.setSmooth(true);
				this.pane.getChildren().add(imageView);
			}
		}
	}

	public void dibujar() {
		ponerFichasJugador();
	}

	public AlgoPoly getAlgoPoly() {
		return algoPoly;
	}
}
