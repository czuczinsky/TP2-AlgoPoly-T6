package modelo;

public class Jugador {
	private String nombre;
	private int dinero;
	
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

}
