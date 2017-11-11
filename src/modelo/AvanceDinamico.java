package modelo;

public class AvanceDinamico implements Casillero {

	private Tablero tablero;

	public AvanceDinamico(Tablero tablero) {
		this.tablero = tablero;
	}

	@Override
	public void ocupar(Jugador jugador) {
		Dados dados = Dados.getDados();
		for (int i = 0;i<dados.getSuma()-2;i++) {
			this.tablero.avanzar(jugador);
		}
	}
	
}
