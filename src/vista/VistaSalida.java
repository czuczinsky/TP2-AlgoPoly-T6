package vista;

import javafx.scene.canvas.Canvas;
import modelo.Casillero;

public class VistaSalida extends VistaRectangulo implements Dibujable {

	public VistaSalida(Casillero casillero, Canvas canvas, double x, double y, double ancho, double alto) {
		super(casillero, canvas, x, y, ancho, alto);
	}

	public static VistaSalida Instancia(Casillero casillero, Canvas canvas, double x, double y, double ancho,
			double alto) {
		return new VistaSalida(casillero, canvas, x, y, ancho, alto);
	}

	public void dibujar() {
		this.ponerImagen("file:src/vista/imagenes/salida.png");
	}
}
