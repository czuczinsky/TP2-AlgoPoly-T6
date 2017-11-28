package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tablero {
	
	private ArrayList<Casillero> casilleros;

	public Tablero() {
		this.casilleros = new ArrayList<Casillero>();
	}

	public void avanzar(Jugador jugador, int cantidad,Dados dados) {
		Casillero casilleroAMover=jugador.getPosicion();
		
		for (int i=0 ; i < cantidad ; i++) {
			ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(casilleroAMover)+1);
			if (iterador.hasNext()) {
				casilleroAMover=iterador.next();
			} 
			else {
				casilleroAMover=this.casilleros.get(0);
			}
		}
		jugador.moverA(casilleroAMover,dados);
	}
	
	public void agregarCasillero(Casillero casillero) {
		this.casilleros.add(casillero);
	}
	

	public void retroceder(Jugador jugador, int cantidad,Dados dados) {
		Casillero casilleroAMover=jugador.getPosicion();
		
		for (int i=0 ; i < cantidad ; i++) {
			ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(casilleroAMover));
			if (iterador.hasPrevious()) {
				casilleroAMover=iterador.previous();
			} 
			else {
				casilleroAMover=this.casilleros.get(this.casilleros.size()-1);
			}
		}
		jugador.moverA(casilleroAMover,dados);
	}

	public ArrayList<Casillero> getCasilleros() {
		return casilleros;
	}

	public boolean puedeMover(Jugador jugador, Dados dados) {
		ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(jugador.getPosicion()));
		Casillero nuevaPosicion = null;
		for (int i=0 ; i <= dados.getSuma() ; i++) {
			if (iterador.hasNext()) {
				nuevaPosicion = iterador.next();
			} 
			else {
				iterador = this.casilleros.listIterator();
				nuevaPosicion = iterador.next();
			}
		}
		return (nuevaPosicion.getAlquiler(jugador, dados) <= jugador.getDinero());
	}
}
