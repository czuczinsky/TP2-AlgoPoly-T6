package modelo;

public class Avance extends DesplazamientoDinamico{
	
	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void moverDel2al6(Jugador jugador, Dados dados) {
		this.tablero.avanzar(jugador,dados.getSuma()-2,this);
	}
	
	public void moverDel7al10(Jugador jugador,Dados dados) {
		this.tablero.avanzar(jugador,(jugador.getDinero())%(dados.getSuma()),this);
	}

	public void moverDel11al12(Jugador jugador, Dados dados) {
			this.tablero.avanzar(jugador,(dados.getSuma()-jugador.cantPropiedades()),this);
	}	

}
