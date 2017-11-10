package modelo;

public class Jugador {
	private String nombre;
	private int dinero;
	private int quini6;
	
	public Jugador(String nombre, int dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
	}

	
	public void decrementarDinero(int monto) {
		this.dinero-=monto;
	}


	public int getDinero() {
		return dinero;
	}


	public void incrementarDinero(int monto) {
		this.dinero += monto;
	}


	public boolean ganoQuini6(int numeroDeVictoria) {
		return (this.quini6 == numeroDeVictoria);
	}


	public void incrementarQuini6() {
		this.quini6 += 1;
	}

}
