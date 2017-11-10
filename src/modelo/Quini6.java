package modelo;

import java.util.ArrayList;

public class Quini6 extends Casillero {

	private ArrayList<Jugador> jugadores;
	private ArrayList<Integer> quinisGanados;
	
	public Quini6() {
		this.jugadores = new ArrayList<Jugador>();
		this.quinisGanados = new ArrayList<Integer>();
	}
	
	@Override
	public void ocupar(Jugador jugador) {
		if (jugadores.contains(jugador)) {
			int indexJugador = this.jugadores.indexOf(jugador);
			int quinisGanadosDelJugador = this.quinisGanados.get(indexJugador); 
			if ( quinisGanadosDelJugador == 1) {
				jugador.incrementarDinero(30000);
			}
			quinisGanados.set(indexJugador, quinisGanadosDelJugador + 1);
		} else {
			jugador.incrementarDinero(50000);
			this.jugadores.add(jugador);
			int quinisGanadosDeJugador = 1;
			this.quinisGanados.add(quinisGanadosDeJugador);
		}
	}
	
}
