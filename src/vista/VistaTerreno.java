package vista;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Terreno;

public class VistaTerreno extends VistaRectangulo implements Dibujable {

	public VistaTerreno(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal, Casillero casillero, GridPane pane,
			int x, int y, double ancho, double alto) {
		super(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public static VistaTerreno Instancia(AlgoPoly algoPoly, ContenedorPrincipal contenedorPrincipal,
			Casillero casillero, GridPane pane, int x, int y, double ancho, double alto) {
		return new VistaTerreno(algoPoly, contenedorPrincipal, casillero, pane, x, y, ancho, alto);
	}

	public void dibujar() {
		Jugador propietario;
		Terreno terreno = (Terreno) this.getCasillero();
		if (terreno.tienePropietario()) {
			propietario = terreno.getPropietario();
			this.pintar(propietario);
		} else
			this.pintar(Color.GAINSBORO);

		if (terreno.getNombre() == "Bs.As. SUR") {
			this.ponerImagen("file:src/vista/imagenes/bsas.png");
			this.etiquetar("Bs.As. SUR", Color.BLACK);
		}
		if (terreno.getNombre() == "Bs.As. NORTE") {
			this.ponerImagen("file:src/vista/imagenes/bsas.png");
			this.etiquetar("Bs.As. NORTE", Color.BLACK);
		}
		if (terreno.getNombre() == "CORDOBA SUR") {
			this.ponerImagen("file:src/vista/imagenes/cordoba.png");
			this.etiquetar("CORDOBA SUR", Color.BLACK);
		}
		if (terreno.getNombre() == "CORDOBA NORTE") {
			this.ponerImagen("file:src/vista/imagenes/cordoba.png");
			this.etiquetar("CORDOBA NORTE", Color.BLACK);
		}

		if (terreno.getNombre() == "SALTA SUR") {
			this.ponerImagen("file:src/vista/imagenes/salta.png");
			this.etiquetar("SALTA SUR", Color.BLACK);
		}
		if (terreno.getNombre() == "SALTA NORTE") {
			this.ponerImagen("file:src/vista/imagenes/salta.png");
			this.etiquetar("SALTA NORTE", Color.BLACK);
		}
		if (terreno.getNombre() == "NEUQUEN") {
			this.ponerImagen("file:src/vista/imagenes/neuquen.png");
			this.etiquetar("NEUQUEN", Color.BLACK);
		}
		if (terreno.getNombre() == "TUCUMAN") {
			this.ponerImagen("file:src/vista/imagenes/tucuman.png");
			this.etiquetar("TUCUMAN", Color.BLACK);
		}
		if (terreno.getNombre() == "SANTA FE") {
			this.ponerImagen("file:src/vista/imagenes/santafe.png");
			this.etiquetar("SANTA FE", Color.BLACK);
			this.ponerBotones();
		}
		this.ponerConstrucciones();
		super.dibujar();
		this.ponerBotones();
	}

	private void ponerConstrucciones() {
		for (int i = 0; i < ((Terreno) this.getCasillero()).cantCasas(); i++)
			this.ponerCasa(i);
		if (((Terreno) this.getCasillero()).cantHoteles() == 1)
			this.ponerHotel();
	}

	private void ponerBotones() {
		Terreno terreno = (Terreno) this.getCasillero();
		if (terreno.puedeComprarsePor(this.getAlgoPoly().getJugadorActual()))
			this.ponerBotonComprar();
		if (terreno.puedeVendersePor(this.getAlgoPoly().getJugadorActual()))
			this.ponerBotonVender();
		if (this.getAlgoPoly().puedoEdificarCasa(terreno))
			this.ponerBotonConstruirCasa();
		if (this.getAlgoPoly().puedoEdificarHotel(terreno))
			this.ponerBotonConstruirHotel();
		String txtInfo = "Terreno: $" + String.valueOf(terreno.getPrecio());
		txtInfo += "\nCasa: $" + String.valueOf(terreno.getCostoEdificarCasa());
		if (terreno.getCostoEdificarHotel() > 0)
			txtInfo += "\nHotel: $" + String.valueOf(terreno.getCostoEdificarHotel());
		this.ponerBotonInfo(txtInfo, "Precios");
	}
}
