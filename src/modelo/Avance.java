package modelo;

public class Avance extends DesplazamientoDinamico {

	private Tablero tablero;

	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void avanzarJugador(Jugador jugador,int posiciones){
		
		for (int i =0;i<posiciones;i++)
			
			this.tablero.avanzar(jugador);


	}
}
