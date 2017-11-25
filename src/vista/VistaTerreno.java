package vista;

import javax.swing.JOptionPane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Terreno;

public class VistaTerreno extends VistaRectangulo implements Dibujable {

	public VistaTerreno(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y, double ancho, double alto) {
		super(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public static VistaTerreno Instancia(AlgoPoly algoPoly, Casillero casillero, StackPane pane, double x, double y,
			double ancho, double alto) {
		return new VistaTerreno(algoPoly, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		Jugador propietario;
		Terreno terreno = (Terreno) this.getCasillero();
		if (terreno.tienePropietario()) {
			propietario = terreno.getPropietario();
			this.pintar(propietario);
		} else
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
		super.dibujar();
		this.ponerBotones();
	}

	private void ponerBotones() {
		// TODO cambiar puedeEdificarCasa por version dependiente del turno
		if (((Terreno) this.getCasillero()).puedeEdificarCasa())
			this.ponerBotonConstruir();
	}
}
