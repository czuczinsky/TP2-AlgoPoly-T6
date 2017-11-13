package modelo;

public class Retroceso extends DesplazamientoDinamico {
	
	
	public Retroceso(Tablero tablero) {
		super(tablero);
	}
	
	public void retroceder(Jugador jugador){
		Posicionador posicionador=new Posicionador();
		Dados dados=Dados.getDados();
		int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
		for (int i =0;i<cantidadPosiciones;i++)
			
			this.tablero.retroceder(jugador);


	}
}