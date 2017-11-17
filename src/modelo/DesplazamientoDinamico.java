package modelo;

public abstract class DesplazamientoDinamico extends  Casillero{
	
	protected Tablero tablero;


	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero=tablero;
	}
	
	@Override
	public void ocupar(Jugador jugador, Dados dados) {

		int cantidadDeCasilleros;
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe2a6(jugador,dados);
		}
		else if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
			cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe7a10(jugador,dados);
		}	
		else cantidadDeCasilleros=this.cantidadDeCasillerosAMoverDe11a12(jugador,dados);

		this.mover(jugador,cantidadDeCasilleros,dados);
	}
	
	abstract public void mover(Jugador jugador, int cantidadDeCasilleros, Dados dados);
	
	abstract public int cantidadDeCasillerosAMoverDe2a6(Jugador jugador, Dados dados);
	
	abstract public int cantidadDeCasillerosAMoverDe11a12(Jugador jugador,Dados dados);
	
	public int cantidadDeCasillerosAMoverDe7a10(Jugador jugador, Dados dados) {
		return jugador.getDinero()%(dados.getSuma());
	}
	
}
