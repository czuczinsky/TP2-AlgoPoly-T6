package modelo;

public class Policia extends Casillero {
	
	private Carcel carcel;
	
	public Policia(Carcel carcel){
		this.carcel=carcel;
		
	}
	
	public void ocupar(Jugador jugador, Dados dados) {
	
		jugador.moverA(carcel,dados);
	}
}
