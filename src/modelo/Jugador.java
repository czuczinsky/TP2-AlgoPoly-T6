package modelo;

public class Jugador {
	private String nombre;
	private int dinero;
	Casillero posicion;
	
	public Jugador(String nombre, int dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		this.posicion= new Salida();
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
	
	public void moverA(Casillero unCasillero) {
		posicion=unCasillero;
		
	}

	public Casillero getPosicion() {
		return (this.posicion);
	}

}
