package modelo;

public class Retroceso extends DesplazamientoDinamico{
	
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}
	
	public void mover(Jugador jugador, int cantidadDeCasilleros,Dados dados) {
		this.tablero.retroceder(jugador,cantidadDeCasilleros,dados);
	}

	public void cargarEstrategias(Jugador jugador, Dados dados) {
		Estrategia3 estrategia3=new Estrategia3(jugador,dados);
		this.desplazamientosPosibles.put(2,estrategia3);
		this.desplazamientosPosibles.put(3,estrategia3);
		this.desplazamientosPosibles.put(4,estrategia3);
		this.desplazamientosPosibles.put(5,estrategia3);
		this.desplazamientosPosibles.put(6,estrategia3);
		Estrategia2 estrategia2=new Estrategia2(jugador,dados);
		this.desplazamientosPosibles.put(7,estrategia2);
		this.desplazamientosPosibles.put(8,estrategia2);
		this.desplazamientosPosibles.put(9,estrategia2);
		this.desplazamientosPosibles.put(10,estrategia2);
		Estrategia1 estrategia1=new Estrategia1(jugador,dados);
		this.desplazamientosPosibles.put(11,estrategia1);
		this.desplazamientosPosibles.put(12,estrategia1);
		
	}

}
