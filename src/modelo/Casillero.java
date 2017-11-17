package modelo;

public abstract class Casillero {
	
	public abstract void ocupar(Jugador jugador);
	
	public boolean puedeMoverse(Jugador jugador) {
		return true;
	}
	
	public void avanzarTurnoDe(Jugador jugador) {
		
	}
}
