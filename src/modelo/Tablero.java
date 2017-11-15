package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tablero {
	
	private ArrayList<Casillero> casilleros;

	public Tablero() {
		this.casilleros = new ArrayList<Casillero>();
	}

	public void avanzar(Jugador jugador, int cantidad) {
		Casillero casilleroAnterior=jugador.getPosicion();
		
		for (int i=0 ; i < cantidad ; i++) {
			Casillero posicionJugador = jugador.getPosicion();
			ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(posicionJugador)+1);
			if (iterador.hasNext()) {
				jugador.moverA(iterador.next());
			} else {
				jugador.moverA(this.casilleros.get(0));
			}
		}
		
		if (casilleroAnterior != jugador.getPosicion()){
			jugador.getPosicion().ocupar(jugador);
		}
	}
	
	public void agregarCasillero(Casillero casillero) {
		this.casilleros.add(casillero);
	}
	

	public void retroceder(Jugador jugador, int cantidad) {
		Casillero casilleroAnterior=jugador.getPosicion();
		
		for (int i=0 ; i < cantidad ; i++) {
			Casillero posicionJugador = jugador.getPosicion();
			ListIterator<Casillero> iterador = this.casilleros.listIterator(this.casilleros.indexOf(posicionJugador));
			
			if (iterador.hasPrevious()) {
				jugador.moverA(iterador.previous());
			} 
			else {
				jugador.moverA(this.casilleros.get(this.casilleros.size()-1));
			}
		}
		if (casilleroAnterior != jugador.getPosicion()){
			jugador.getPosicion().ocupar(jugador);
		}
	}
}
