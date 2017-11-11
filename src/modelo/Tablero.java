package modelo;

import java.util.ArrayList;
import java.util.ListIterator;

public class Tablero {
	
	private ArrayList<Casillero> casilleros;

	public Tablero() {
		this.casilleros = new ArrayList<Casillero>();
	}

	public void avanzar(Jugador jugador) {
		Casillero posicionJugador = jugador.getPosicion();
		ListIterator<Casillero> iterador = casilleros.listIterator(casilleros.indexOf(posicionJugador) + 1);
		jugador.moverA(iterador.next());
	}
	
	public void agregarCasillero(Casillero casillero) {
		this.casilleros.add(casillero);
	}
}
