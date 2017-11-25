package modelo;

import java.util.ArrayList;

public class Turno {

	private ArrayList<Jugador> jugadores;
	private int posicionActual;

	public Turno(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		posicionActual = 0;
	}

	public void avanzar() {
		// TODO ver que pasa si se elimina jugador actual
		if (posicionActual < (jugadores.size() - 1))
			posicionActual++;
		else
			posicionActual = 0;
	}

	public Jugador getActual() {
		// TODO ver que pasa si se elimina jugador actual
		return jugadores.get(posicionActual);
	}
}
