package modelo;

public abstract class Casillero {
	
	public abstract void ocupar(Jugador jugador, Dados dados);
	
	public boolean puedeMoverse(Jugador jugador) {
		return true;
	}
	
	public void avanzarTurnoDe(Jugador jugador) {
	}
	
	public int getAlquiler(Jugador jugador, Dados dados) {
		return 0;
	}
}
