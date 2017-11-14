package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}
	
	public void mover(Jugador jugador, int cantidadDeCasilleros) {
		this.tablero.retroceder(jugador,cantidadDeCasilleros);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Dados dados,Jugador jugador) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Dados dados,Jugador jugador) {
		return dados.getSuma()-2;
	}

}
