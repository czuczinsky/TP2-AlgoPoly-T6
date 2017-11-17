package modelo;

public class Avance extends DesplazamientoDinamico{

	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void mover(Jugador jugador, int cantidadDeCasilleros, Dados dados) {
		this.tablero.avanzar(jugador,cantidadDeCasilleros,dados);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador, Dados dados) {
		return dados.getSuma()-2;
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador,Dados dados) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
}
