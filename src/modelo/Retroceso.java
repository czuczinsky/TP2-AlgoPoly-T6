package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	private Dados dados =Dados.getDados();
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}
	
	public void mover(Jugador jugador, int cantidadDeCasilleros) {
		this.tablero.retroceder(jugador,cantidadDeCasilleros);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador) {
		return dados.getSuma()-2;
	}

}
