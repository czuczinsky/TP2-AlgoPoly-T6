package modelo;

public class Avance extends DesplazamientoDinamico{
	
	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void mover(Jugador jugador, int cantidadDeCasilleros) {
		this.tablero.avanzar(jugador,cantidadDeCasilleros,this);
	}
	
	public int cantidadDeCasillerosAMoverDe2a6(Dados dados,Jugador jugador) {
		return dados.getSuma()-2;
	}
	
	public int cantidadDeCasillerosAMoverDe11a12(Dados dados,Jugador jugador) {
		return dados.getSuma()-jugador.cantPropiedades();
	}
	
}
