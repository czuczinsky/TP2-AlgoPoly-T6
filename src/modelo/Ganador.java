package modelo;

public class Ganador {
	Jugador jugador;
	int victorias;
	
	public Ganador(Jugador jugador) {
		this.jugador = jugador;
		this.victorias = 0;
	}

	public boolean esIgualA(Jugador jugador) {
		return (this.jugador == jugador);
	}

	public void incrementarVictorias() {
		this.victorias += 1;
	}

	public boolean vecesQueGano(int cantidadDeVeces) {
		return (this.victorias == cantidadDeVeces);
	}
}
