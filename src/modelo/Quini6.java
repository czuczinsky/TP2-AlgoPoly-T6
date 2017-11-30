package modelo;

import java.util.ArrayList;

public class Quini6 extends Casillero {
	private ArrayList<Ganador> ganadores;

	public Quini6() {
		this.ganadores = new ArrayList<Ganador>();
	}

	@Override
	public void ocupar(Jugador jugador, Dados dados) {
		Ganador ganador = this.obtenerGanador(jugador);
		ganador.pagar();
	}

	private Ganador obtenerGanador(Jugador jugador) {
		for (Ganador ganadorActual : ganadores) {
			if (ganadorActual.esIgualA(jugador)) {
				return ganadorActual;
			}
		}
		Ganador ganadorNuevo = new Ganador(jugador);
		this.ganadores.add(ganadorNuevo);
		return ganadorNuevo;
	}
}
