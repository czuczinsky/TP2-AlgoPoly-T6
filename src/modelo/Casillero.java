package modelo;

public abstract class Casillero {
	protected String nombre;

	public void ocupar(Jugador jugador) {
		throw new RuntimeException();
	}
}
