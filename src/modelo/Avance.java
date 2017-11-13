package modelo;

public class Avance extends DesplazamientoDinamico {


	public Avance(Tablero tablero) {
		super(tablero);
	}

	public void avanzar(Jugador jugador){
		Dados dados=Dados.getDados();
		int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
		for (int i =0;i<cantidadPosiciones;i++) {
			this.tablero.avanzar(jugador);
		}
	}
}
