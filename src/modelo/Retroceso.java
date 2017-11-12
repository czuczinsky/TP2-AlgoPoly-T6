package modelo;

public class Retroceso extends DesplazamientoDinamico {
	
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}

	public void retrocederJugador(Jugador jugador,int posiciones){
		
		for (int i =0;i<posiciones;i++)
			
			this.tablero.retroceder(jugador);


	}
}