package modelo;

import java.util.ArrayList;

public class Quini6 implements Casillero {
	private ArrayList<Ganador> ganadores;
	
	public Quini6() {
		this.ganadores = new ArrayList<Ganador>();
	}
	
	@Override
	public void ocupar(Jugador jugador) {
		Ganador ganador = this.obtenerGanador(jugador);
		if (ganador == null) {
			ganador = new Ganador(jugador);
			this.ganadores.add(ganador);
			jugador.incrementarDinero(50000);
		} else {
			if (ganador.vecesQueGano(1)) {
				jugador.incrementarDinero(30000);
			}
		}
		ganador.incrementarVictorias();
	}
	
	private Ganador obtenerGanador(Jugador jugador) {
		for (Ganador ganadorActual:ganadores) {
			if(ganadorActual.esIgualA(jugador)) {
				return ganadorActual;
			}
		}
		return null;
	}
	
//	private boolean existeGanador(Jugador jugador) {
//		for (Ganador ganadorActual:ganadores) {
//			if(ganadorActual.esIgualA(jugador)) {
//				return true;
//			}
//		}
//		return false; 
//	}
}
