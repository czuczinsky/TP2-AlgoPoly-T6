package modelo;

public class Estrategia2 extends EstrategiaDesplazamiento {

	public Estrategia2(Jugador jugador, Dados dados) {
		super(jugador, dados);
	}

	@Override
	public int getCantidadADesplazar(Jugador jugador, Dados dados) {

		return (jugador.getDinero() % dados.getSuma());
	}
}
