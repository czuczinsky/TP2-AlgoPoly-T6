package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}

	public void moverDel2al6(Jugador jugador,Dados dados) {
		this.tablero.retroceder(jugador,dados.getSuma()-jugador.cantPropiedades(),this);
	}
	
	public void moverDel7al10(Jugador jugador,Dados dados) {
			this.tablero.retroceder(jugador,jugador.getDinero()%(dados.getSuma()),this);
	}

	public void moverDel11al12(Jugador jugador, Dados dados) {
			this.tablero.retroceder(jugador,dados.getSuma()-2,this);
	}

}
