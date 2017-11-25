package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.Casillero;
import modelo.Terreno;

public class VistaTerreno extends VistaRectangulo implements Dibujable {

	public VistaTerreno(Casillero casillero, StackPane pane, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, pane, canvas, x, y, ancho, alto);
	}

	public static VistaTerreno Instancia(Casillero casillero, StackPane pane, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaTerreno(casillero, pane, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		Terreno terreno = (Terreno) this.getCasillero();
		if (terreno.tienePropietario())
			if (terreno.getPropietario().getNombre().equals("Rojo"))

				this.pintar(Color.RED);
			else if (terreno.getPropietario().getNombre().equals("Verde"))
				this.pintar(Color.GREEN);
			else if (terreno.getPropietario().getNombre().equals("Azul"))
				this.pintar(Color.BLUE);
			else
				this.pintar(Color.GAINSBORO);
		else
			this.pintar(Color.GAINSBORO);

		if (this.getCasillero().getNombre() == "Bs.As. SUR") {
			this.ponerImagen("file:src/vista/imagenes/bsas.png");
			this.etiquetar("Bs.As. SUR", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "Bs.As. NORTE") {
			this.ponerImagen("file:src/vista/imagenes/bsas.png");
			this.etiquetar("Bs.As. NORTE", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "CORDOBA SUR") {
			this.ponerImagen("file:src/vista/imagenes/cordoba.png");
			this.etiquetar("CORDOBA SUR", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "CORDOBA NORTE") {
			this.ponerImagen("file:src/vista/imagenes/cordoba.png");
			this.etiquetar("CORDOBA NORTE", Color.BLACK);
		}

		if (this.getCasillero().getNombre() == "SALTA SUR") {
			this.ponerImagen("file:src/vista/imagenes/salta.png");
			this.etiquetar("SALTA SUR", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "SALTA NORTE") {
			this.ponerImagen("file:src/vista/imagenes/salta.png");
			this.etiquetar("SALTA NORTE", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "NEUQUEN") {
			this.ponerImagen("file:src/vista/imagenes/neuquen.png");
			this.etiquetar("NEUQUEN", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "TUCUMAN") {
			this.ponerImagen("file:src/vista/imagenes/tucuman.png");
			this.etiquetar("TUCUMAN", Color.BLACK);
		}
		if (this.getCasillero().getNombre() == "SANTA FE") {
			this.ponerImagen("file:src/vista/imagenes/santafe.png");
			this.etiquetar("SANTA FE", Color.BLACK);
			this.ponerBotones();
		}
		this.ponerBotones();
	}

	private void ponerBotones() {
		super.ponerBotonConstruir();
	}
}
