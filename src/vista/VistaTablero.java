package vista;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.AlgoPoly;
import modelo.Casillero;

public class VistaTablero {

	private ArrayList<VistaCasillero> vistaCasilleros;
	private double ancho;
	private double alto;
	private GridPane pane;
	private double separacion;
	private int porLinea;

	public VistaTablero(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, GridPane pane) {
		this.ancho = 850;
		this.alto = 600;
		this.separacion = 10;

		this.pane = pane;

		vistaCasilleros = new ArrayList<VistaCasillero>();
		ArrayList<Casillero> casilleros = algoPoly.getTablero().getCasilleros();
		int cantidad = casilleros.size();
		this.porLinea = cantidad / 4;
		double anchoCasillero = this.ancho / (porLinea + 1);
		double altoCasillero = this.alto / (porLinea + 1);
		int x;
		int y;

		int i = 0;
		for (Casillero casillero : casilleros) {
			if (i < porLinea) {
				x = porLinea - i;
				y = porLinea;
			} else if (i < porLinea * 2) {
				x = 0;
				y = porLinea - (i - porLinea);
			} else if (i < porLinea * 3) {
				x = i - 2 * porLinea;
				y = 0;
			} else {
				x = porLinea;
				y = i - 3 * porLinea;
			}
			vistaCasilleros.add(new VistaCasillero(algoPoly, contenedorPrincipal, casillero, pane, x, y,
					anchoCasillero - separacion, altoCasillero - separacion));
			i++;
		}

	}

	public void dibujar() {
		this.clean();
		for (VistaCasillero vistaCasillero : vistaCasilleros)
			vistaCasillero.dibujar();
	}

	public void clean() {
		pane.setHgap(this.separacion);
		pane.setVgap(this.separacion);

		Rectangle fondo = new Rectangle(0, 0, ancho, alto);
		fondo.setFill(Color.CHARTREUSE.desaturate());
		this.pane.add(fondo, 0, 0, porLinea + 1, porLinea + 1);

		 Image image = new Image("file:src/vista/imagenes/AlgoPolyLogo.png");
		 ImageView imageView = new ImageView();
		 imageView.setImage(image);
		 this.pane.add(imageView, 0, 0, porLinea + 1, porLinea + 1);
		 imageView.setTranslateX((ancho - image.getWidth()) / 2);
	}

	public void update() {
		this.dibujar();
	}

}
