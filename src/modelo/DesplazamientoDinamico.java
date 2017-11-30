package modelo;

import java.util.HashMap;

public abstract class DesplazamientoDinamico extends Casillero {

	protected Tablero tablero;

	public HashMap<Integer, EstrategiaDesplazamiento> desplazamientosPosibles;

	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero = tablero;
		this.desplazamientosPosibles = new HashMap<Integer, EstrategiaDesplazamiento>();
	}

	@Override
	public void ocupar(Jugador jugador, Dados dados) {

		int numeroDados = dados.getSuma();
		this.cargarEstrategias(jugador, dados);
		EstrategiaDesplazamiento unaEstrategia = this.desplazamientosPosibles.get(numeroDados);
		int cantidadDeCasilleros = unaEstrategia.getCantidadADesplazar(jugador, dados);

		this.mover(jugador, cantidadDeCasilleros, dados);
	}

	abstract public void mover(Jugador jugador, int cantidadDeCasilleros, Dados dados);

	abstract public void cargarEstrategias(Jugador jugador, Dados dados);

}
