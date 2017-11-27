package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Turno {

	private ArrayList<Jugador> jugadores;
	private ListIterator<Jugador> iterador;
	private Jugador jugadorActual;
	private boolean vuelveAJugar;

	public Turno(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.iterador = this.jugadores.listIterator();
		this.jugadorActual = this.iterador.next();
		this.iterador.previous();
		this.vuelveAJugar = false;
	}

	public Jugador siguienteJugador(Dados dados) {
		if (dados.getDado1() != dados.getDado2() || !this.vuelveAJugar) {
			if (!this.iterador.hasNext()) {
				iterador = this.jugadores.listIterator();
			}
			this.jugadorActual = this.iterador.next();
			this.vuelveAJugar = true;
		} else {
			this.vuelveAJugar = false;
		}
		return this.jugadorActual;
	}

	public Jugador getJugadorActual() {
		return this.jugadorActual;
	}
	
	public void borrar() {
		iterador.remove();
	}
}
