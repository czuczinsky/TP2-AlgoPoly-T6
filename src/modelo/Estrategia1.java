package modelo;

public class Estrategia1 extends EstrategiaDesplazamiento {

	public Estrategia1(Jugador jugador, Dados dados) {
		super(jugador, dados);
	}

	@Override
	public int getCantidadADesplazar(Jugador jugador, Dados dados) {

		return (dados.getSuma() - 2);
	}
}
