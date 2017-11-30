package vista;

import eventos.BotonComprarHandler;
import eventos.BotonConstruirCasaHandler;
import eventos.BotonConstruirHotelHandler;
import eventos.BotonFianzaHandler;
import eventos.BotonVenderHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
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
	private int x;
	private int y;
	private double ancho;
	private double alto;
	private GridPane pane;

	public VistaRectangulo(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero,
			GridPane pane, int x, int y, double ancho, double alto) {
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
		this.pane.add(fondo, x, y);
	}

	public void pintar(Jugador propietario) {
		Rectangle fondo = new Rectangle(0, 0, ancho, alto);
		if (propietario.getNombre().equals("Rojo"))
			fondo.setFill(Color.RED);
		if (propietario.getNombre().equals("Verde"))
			fondo.setFill(Color.GREEN);
		if (propietario.getNombre().equals("Azul"))
			fondo.setFill(Color.BLUE);
		this.pane.add(fondo, x, y);
	}

	public void etiquetar(String etiqueta, Color color) {
		Text text = new Text(etiqueta);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		text.setFill(color);
		this.pane.add(text, x, y);
		text.setTranslateX(10);
		text.setTranslateY(alto / 2 - 5);
	}

	public void ponerImagen(String sImagen) {
		Image image = new Image(sImagen);
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		this.pane.add(imageView, x, y);
		imageView.setTranslateX(10);
		imageView.setTranslateY(0);
	}

	public Casillero getCasillero() {
		return casillero;
	}

	private void setIcono(ImageView icono) {
		icono.setFitWidth(40);
		icono.setFitHeight(40);
		icono.setPreserveRatio(true);
		icono.setSmooth(true);
		this.pane.add(icono, this.x, this.y);
	}
	
	public void ponerBotonComprar() {
		ImageView iconoComprar = new ImageView("file:src/vista/imagenes/changuito.png");
		setIcono(iconoComprar);
		iconoComprar.setTranslateX(2);
		iconoComprar.setTranslateY(-22);
		iconoComprar.setOnMouseClicked(
				new BotonComprarHandler(this.algoPoly, (Agrupable) this.casillero, this.contenedorPrincipal));
	}

	public void ponerBotonVender() {
		ImageView iconoVender = new ImageView("file:src/vista/imagenes/vender.png");
		setIcono(iconoVender);
		iconoVender.setTranslateX(88);
		iconoVender.setTranslateY(-30);
		iconoVender.setOnMouseClicked(new BotonVenderHandler((Agrupable) this.casillero, this.contenedorPrincipal));
	}

	public void ponerBotonPagarFianza() {
		ImageView iconoFianza = new ImageView("file:src/vista/imagenes/fianza.png");
		setIcono(iconoFianza);
		iconoFianza.setTranslateY(-22);
		iconoFianza.setOnMouseClicked(
				new BotonFianzaHandler(this.algoPoly, (Carcel) this.casillero, this.contenedorPrincipal));
	}

	public void ponerBotonConstruirCasa() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirCasa.png");
		setIcono(iconoConstruir);
		iconoConstruir.setTranslateX(2);
		iconoConstruir.setTranslateY(-22);
		iconoConstruir.setOnMouseClicked(new BotonConstruirCasaHandler((Terreno) this.casillero, this.contenedorPrincipal));
	}

	public void ponerBotonConstruirHotel() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirHotel.png");
		setIcono(iconoConstruir);
		iconoConstruir.setTranslateX(2);
		iconoConstruir.setTranslateY(-22);
		iconoConstruir.setOnMouseClicked(new BotonConstruirHotelHandler((Terreno) this.casillero, this.contenedorPrincipal));
	}

	public void ponerBotonInfo(String texto, String titulo) {
		ImageView iconoInfo = new ImageView("file:src/vista/imagenes/info.png");
		setIcono(iconoInfo);
		iconoInfo.setTranslateX(96);
		iconoInfo.setTranslateY(28);
		iconoInfo.setOnMouseClicked(e -> {
			Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
			dialogoAlerta.setTitle(titulo);
			dialogoAlerta.setHeaderText(null);
			dialogoAlerta.setContentText(texto);
			dialogoAlerta.initStyle(StageStyle.UTILITY);
			dialogoAlerta.showAndWait();
		});
	}

	public void ponerCasa(int i) {
		ImageView iconoCasa = new ImageView("file:src/vista/imagenes/casa.png");
		this.pane.add(iconoCasa, x, y);
		iconoCasa.setTranslateX(28 + i * 40);

	}

	public void ponerHotel() {
		ImageView iconoCasa = new ImageView("file:src/vista/imagenes/hotel.png");
		this.pane.add(iconoCasa, x, y);
		iconoCasa.setTranslateX(40);

	}

	public void ponerFichasJugador() {
		double offset = 15;
		Image image;
		ImageView imageView;
		for (Jugador jugador : algoPoly.getJugadores()) {
			imageView = new ImageView();
			if (casillero.equals(jugador.getPosicion())) {
				imageView = new ImageView();
				image = new Image("file:src/vista/imagenes/ficharoja.png");
				imageView.setTranslateX(50 + offset);
				if (jugador.getNombre().equals("Verde")) {
					image = new Image("file:src/vista/imagenes/fichaverde.png");
					imageView.setTranslateX(50);
				}
				if (jugador.getNombre().equals("Azul")) {
					image = new Image("file:src/vista/imagenes/fichaazul.png");
					imageView.setTranslateX(50 - offset);
				}
				imageView.setImage(image);
				imageView.setFitWidth(60);
				imageView.setFitHeight(60);
				imageView.setPreserveRatio(true);
				imageView.setSmooth(true);
				this.pane.add(imageView, x, y);
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
