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
	
	public boolean cumplioLaCondena() {
		boolean cumplioCondena=true;
		if (!(this.turno>=4)){
			cumplioCondena=false;
			this.incrementarTurno();
		}
		return cumplioCondena;
	}
	
	public boolean puedePagarFianza(int dineroAPagar) {
		return (this.turno>1 && jugador.getDinero()>=dineroAPagar);
	}
	
	private void incrementarTurno() {
		this.turno+=1;
	}
	
}
