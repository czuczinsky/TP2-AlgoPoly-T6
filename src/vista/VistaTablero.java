package vista;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaTablero {

	ArrayList<VistaCasillero> vistaCasilleros;
	double ancho;
	double alto;
	StackPane pane;

	public VistaTablero(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, StackPane pane) {
		this.ancho = 850;
		this.alto = 600;
		double separacion = 10;

		this.pane = pane;

		vistaCasilleros = new ArrayList<VistaCasillero>();
		ArrayList<Casillero> casilleros = algoPoly.getTablero().getCasilleros();
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

			vistaCasilleros.add(new VistaCasillero(algoPoly, contenedorPrincipal, casillero, pane, x + separacion / 2,
					y + separacion / 2, anchoCasillero - separacion, altoCasillero - separacion));
			i++;
		}

	}

	public void dibujar() {
		this.clean();
		for (VistaCasillero vistaCasillero : vistaCasilleros)
			vistaCasillero.dibujar();
	}

	public void clean() {
		Rectangle fondo = new Rectangle(0, 0, ancho, alto);
		fondo.setFill(Color.CHARTREUSE.desaturate());
		this.pane.getChildren().add(fondo);

		Image image = new Image("file:src/vista/imagenes/AlgoPolyLogo.png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		this.pane.getChildren().add(imageView);
		imageView.setTranslateX((ancho - image.getWidth()) / 2);
		imageView.setTranslateY((alto - image.getHeight()) / 2);
	}

	public void update() {
		this.dibujar();
	}

}
