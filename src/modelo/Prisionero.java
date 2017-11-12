package modelo;

public class Prisionero {
	Jugador jugador;
	int turno;
	
	public Prisionero(Jugador jugador) {
		this.jugador=jugador;
		this.turno=1;	
	}
	
	public boolean esIgualA (Jugador jugador) {
		return (this.jugador.equals(jugador));
	}
	
	public void incrementarTurno() {
		this.turno+=1;
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	public boolean tieneSuficienteDinero(int dinero) {
		return (jugador.getDinero()>=dinero);
	}
	
}
