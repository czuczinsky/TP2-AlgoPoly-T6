package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}
	
	public void mover(Jugador jugador, int cantidadDeCasilleros,Dados dados) {
		this.tablero.retroceder(jugador,cantidadDeCasilleros,dados);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador, Dados dados) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador,Dados dados) {
		return dados.getSuma()-2;
	}

}
