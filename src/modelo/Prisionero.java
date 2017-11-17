package modelo;

public class Prisionero {
	private Jugador jugador;
	private int turno;
	
	public Prisionero(Jugador jugador) {
		this.jugador=jugador;
		this.turno=0;
	}
	
	public boolean esIgualA (Jugador jugador) {
		return (this.jugador.equals(jugador));
	}
	
	public boolean cumplioLaCondena() {
		return (turno>=4);
	}

	public boolean puedePagarFianza(int dineroAPagar) {
		return (turno>1 && jugador.getDinero()>=dineroAPagar);
	}
	
	public void incrementarTurno() {
		this.turno+=1;
	}
	
}
