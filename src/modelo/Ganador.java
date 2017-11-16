package modelo;

public class Ganador {
	private Jugador jugador;
	private int victorias;
	private final int primerVictoria = 50000;
	private final int segundaVictoria = 30000;
	
	public Ganador(Jugador jugador) {
		this.jugador = jugador;
		this.victorias = 0;
	}

	public boolean esIgualA(Jugador jugador) {
		return (this.jugador == jugador);
	}
	
	public void pagar() {
		if (this.victorias == 0) {
			this.jugador.incrementarDinero(this.primerVictoria);
		} else if (this.victorias == 1){
			this.jugador.incrementarDinero(this.segundaVictoria);
		}
		this.victorias += 1;
	}
}
