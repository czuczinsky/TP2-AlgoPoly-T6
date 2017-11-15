package modelo;

public class Avance extends DesplazamientoDinamico{
	
	private Dados dados =Dados.getDados();

	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void mover(Jugador jugador, int cantidadDeCasilleros) {
		this.tablero.avanzar(jugador,cantidadDeCasilleros);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador) {
		return dados.getSuma()-2;
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
}
