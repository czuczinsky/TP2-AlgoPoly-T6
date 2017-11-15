package modelo;

public abstract class DesplazamientoDinamico implements Casillero{
	
	public Tablero tablero;
	private Dados dados=Dados.getDados();

	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero=tablero;
	}
	
	@Override
	public void ocupar(Jugador jugador) {

		int cantidadDeCasilleros;
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe2a6(jugador);
		}
		else if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
			cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe7a10(jugador);
		}	
		else cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe11a12(jugador);

		this.mover(jugador,cantidadDeCasilleros);
	}
	
	abstract public void mover(Jugador jugador, int cantidadDeCasilleros);
	
	abstract public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador);
	
	abstract public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador);
	
	public int cantidadDeCasillerosAMoverDe7a10(Jugador jugador) {
		return jugador.getDinero()%(dados.getSuma());
	}
	
}
