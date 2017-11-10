package modelo;

public class Quini6 extends Casillero {

	@Override
	public void ocupar(Jugador jugador) {
		if (jugador.ganoQuini6(0)) {
			jugador.incrementarDinero(50000);
		} else if (jugador.ganoQuini6(1)) {
			jugador.incrementarDinero(30000);
		}
		jugador.incrementarQuini6();
	}
}
