package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tablero {
	
	private ArrayList<Casillero> casilleros;

	public Tablero() {
		this.casilleros = new ArrayList<Casillero>();
	}

	public void avanzar(Jugador jugador, int cantidad,Dados dados) {
		Casillero casilleroAMover = this.getSiguienteCasillero(jugador, cantidad);
		jugador.moverA(casilleroAMover,dados);
	}
	
	public void agregarCasillero(Casillero casillero) {
		this.casilleros.add(casillero);
	}
	

	public void retroceder(Jugador jugador, int cantidad,Dados dados) {
		Casillero casilleroAMover = this.getAnteriorCasillero(jugador, cantidad);
		jugador.moverA(casilleroAMover,dados);
	}

	public ArrayList<Casillero> getCasilleros() {
		return casilleros;
	}

	public boolean puedeMover(Jugador jugador, Dados dados) {
		Casillero nuevaPosicion = this.getSiguienteCasillero(jugador, dados.getSuma());
		return (nuevaPosicion.getAlquiler(jugador, dados) <= jugador.getDinero());
	}

	public Casillero getSiguienteCasillero(Jugador jugador, int cantidad) {
		ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(jugador.getPosicion()));
		Casillero nuevaPosicion = null;
		for (int i=0 ; i <= cantidad ; i++) {
			if (iterador.hasNext()) {
				nuevaPosicion = iterador.next();
			} 
			else {
				iterador = this.casilleros.listIterator();
				nuevaPosicion = iterador.next();
			}
		}
		return nuevaPosicion;
	}

	public Casillero getAnteriorCasillero(Jugador jugador, int cantidad) {
		ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(jugador.getPosicion())+1);
		Casillero nuevaPosicion = null;
		for (int i=0 ; i <= cantidad ; i++) {
			if (iterador.hasPrevious()) {
				nuevaPosicion = iterador.previous();
			} 
			else {
				nuevaPosicion = this.casilleros.get(this.casilleros.size()-1);
			}
		}
		return nuevaPosicion;
	}
}
