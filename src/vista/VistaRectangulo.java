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
import modelo.Carcel;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Agrupable;
import modelo.Terreno;

public abstract class VistaRectangulo implements Dibujable {
	private AlgoPoly algoPoly;
	private ContenedorPrincipal contenedorPrincipal;
	private Casillero casillero;
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private StackPane pane;

	public VistaRectangulo(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero,
			StackPane pane, double x, double y, double ancho, double alto) {
		this.algoPoly = algoPoly;
		this.contenedorPrincipal = contenedorPrincipal;
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
		iconoComprar.setFitWidth(40);
		iconoComprar.setFitHeight(40);
		iconoComprar.setPreserveRatio(true);
		iconoComprar.setSmooth(true);
		this.pane.getChildren().add(iconoComprar);
		iconoComprar.setTranslateX(x);
		iconoComprar.setTranslateY(y);
		iconoComprar.setOnMouseClicked(e -> {
			// TODO mover a Control.
			this.algoPoly.comprarAgrupagle();
			// ((Agrupable) casillero).venderA(algoPoly.getJugadorActual());
			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonVender() {
		ImageView iconoComprar = new ImageView("file:src/vista/imagenes/vender.png");
		iconoComprar.setFitWidth(40);
		iconoComprar.setFitHeight(40);
		iconoComprar.setPreserveRatio(true);
		iconoComprar.setSmooth(true);
		this.pane.getChildren().add(iconoComprar);
		iconoComprar.setTranslateX(x + 83);
		iconoComprar.setTranslateY(y + 3);
		iconoComprar.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Agrupable) casillero).vender();
			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonPagarFianza() {
		ImageView iconoFianza = new ImageView("file:src/vista/imagenes/fianza.png");
		iconoFianza.setFitWidth(40);
		iconoFianza.setFitHeight(40);
		iconoFianza.setPreserveRatio(true);
		iconoFianza.setSmooth(true);
		this.pane.getChildren().add(iconoFianza);
		iconoFianza.setTranslateX(x + 83);
		iconoFianza.setTranslateY(y + 3);
		iconoFianza.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Carcel) casillero).cobrarFianza(algoPoly.getJugadorActual());
			;
			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonConstruirCasa() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirCasa.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.getChildren().add(iconoConstruir);
		iconoConstruir.setTranslateX(x);
		iconoConstruir.setTranslateY(y);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Terreno) casillero).construirCasa();
			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonConstruirHotel() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirHotel.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.getChildren().add(iconoConstruir);
		iconoConstruir.setTranslateX(x);
		iconoConstruir.setTranslateY(y);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control
			((Terreno) casillero).construirHotel();
			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonInfo(String texto, String titulo) {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/info.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.getChildren().add(iconoConstruir);
		iconoConstruir.setTranslateX(x + 96);
		iconoConstruir.setTranslateY(y + 28);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control
			JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
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
				imageView.setFitWidth(60);
				imageView.setFitHeight(60);
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
