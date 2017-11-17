package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tablero {
	
	private ArrayList<Casillero> casilleros;

	public Tablero() {
		this.casilleros = new ArrayList<Casillero>();
	}

	public void avanzar(Jugador jugador, int cantidad) {
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
		jugador.moverA(casilleroAMover);
	}
	
	public void agregarCasillero(Casillero casillero) {
		this.casilleros.add(casillero);
	}
	

	public void retroceder(Jugador jugador, int cantidad) {
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
		jugador.moverA(casilleroAMover);
	}

	public ArrayList<Casillero> getCasilleros() {
		return casilleros;
	}
}
