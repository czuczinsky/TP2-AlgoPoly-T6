package modelo;

public class Estrategia3 extends EstrategiaDesplazamiento{

	public Estrategia3(Jugador jugador, Dados dados) {
		super(jugador, dados);
	}

	@Override
	public int getCantidadADesplazar(Jugador jugador, Dados dados) {

		
		return(dados.getSuma()-jugador.cantPropiedades());
	}

}
