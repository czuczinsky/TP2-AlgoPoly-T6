package modelo;

public class Avance extends DesplazamientoDinamico {

	private Tablero tablero;

	public Avance(Tablero tablero) {
		super(tablero);
	}

	
	public void avanzar(Jugador jugador){
		Posicionador posicionador=new Posicionador();
		Dados dados=Dados.getDados();
		int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
		for (int i =0;i<cantidadPosiciones;i++)
			
			this.tablero.avanzar(jugador);
	}
	
//	@Override
//	public void ocupar(Jugador jugador) {
//		Dados dados = Dados.getDados();
//		for (int i = 0;i<dados.getSuma()-2;i++) {
//			this.tablero.avanzar(jugador);
//		}
//	}
}
