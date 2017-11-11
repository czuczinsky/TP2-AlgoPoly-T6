package modelo;

public class AvanceDinamico extends Casillero {

	private Dados dados;
	private Tablero tablero;

	public AvanceDinamico(Dados dados, Tablero tablero) {
		this.dados = dados;
		this.tablero = tablero;
	}

	@Override
	public void ocupar(Jugador jugador) {
		for (int i = 0;i<dados.getSuma();i++) {
			tablero.avanzar(jugador);
		}
	}
	
}
