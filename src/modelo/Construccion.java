package modelo;

public class Construccion {

	private Jugador propietario;
	private int precio;
	private int alquiler;

	public Construccion(Jugador propietario, int precio, int alquiler) {
		this.propietario = propietario;
		this.precio = precio;
		this.alquiler = alquiler;
	}

	public int getprecio() {
		return this.precio;
	}

	public void cobrarAlquilerA(Jugador jugador) {
		jugador.decrementarDinero(alquiler);
		propietario.incrementarDinero(alquiler);
	}

	public int getAlquiler() {
		return this.alquiler;
	}
}
