package vista;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
		// TODO mejorar
		imageView.setTranslateX(10);
		imageView.setTranslateY(0);
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
		this.pane.add(iconoComprar, x, y);
		iconoComprar.setTranslateX(2);
		iconoComprar.setTranslateY(-22);
		// iconoComprar.setOnMouseClicked(new BotonComprarHandler(this.algoPoly,
		// this.contenedorPrincipal));
		iconoComprar.setOnMouseClicked(e -> {
			// TODO mover a Control.
			this.algoPoly.comprarAgrupagle();

			URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();

			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonVender() {
		ImageView iconoComprar = new ImageView("file:src/vista/imagenes/vender.png");
		iconoComprar.setFitWidth(40);
		iconoComprar.setFitHeight(40);
		iconoComprar.setPreserveRatio(true);
		iconoComprar.setSmooth(true);
		this.pane.add(iconoComprar, x, y);
		iconoComprar.setTranslateX(88);
		iconoComprar.setTranslateY(-30);
		iconoComprar.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Agrupable) casillero).vender();

			URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();

			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonPagarFianza() {
		ImageView iconoFianza = new ImageView("file:src/vista/imagenes/fianza.png");
		iconoFianza.setFitWidth(60);
		iconoFianza.setFitHeight(60);
		iconoFianza.setPreserveRatio(true);
		iconoFianza.setSmooth(true);
		this.pane.add(iconoFianza, x, y);
		iconoFianza.setTranslateX(-6);
		iconoFianza.setTranslateY(-22);
		iconoFianza.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Carcel) casillero).cobrarFianza(algoPoly.getJugadorActual());

			URL url = getClass().getResource("/vista/sonidos/CASHREG.WAV");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();

			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonConstruirCasa() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirCasa.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.add(iconoConstruir, x, y);
		iconoConstruir.setTranslateX(2);
		iconoConstruir.setTranslateY(-22);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control.
			((Terreno) casillero).construirCasa();

			URL url = getClass().getResource("/vista/sonidos/CONSTRUIR.WAV");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();

			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonConstruirHotel() {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/construirHotel.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.add(iconoConstruir, x, y);
		iconoConstruir.setTranslateX(2);
		iconoConstruir.setTranslateY(-22);
		iconoConstruir.setOnMouseClicked(e -> {
			// TODO mover a Control
			((Terreno) casillero).construirHotel();

			URL url = getClass().getResource("/vista/sonidos/CONSTRUIR2.WAV");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();

			contenedorPrincipal.refrescar();
		});
	}

	public void ponerBotonInfo(String texto, String titulo) {
		ImageView iconoConstruir = new ImageView("file:src/vista/imagenes/info.png");
		iconoConstruir.setFitWidth(40);
		iconoConstruir.setFitHeight(40);
		iconoConstruir.setPreserveRatio(true);
		iconoConstruir.setSmooth(true);
		this.pane.add(iconoConstruir, x, y);
		iconoConstruir.setTranslateX(96);
		iconoConstruir.setTranslateY(28);
		iconoConstruir.setOnMouseClicked(e -> {
			JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
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
