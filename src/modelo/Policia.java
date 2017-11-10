package modelo;

public class Policia extends Casillero {
	
	Carcel carcel;
	
	public Policia(Carcel carcel){
		this.carcel=carcel;
		
	}
	
	public void ocupar(Jugador jugador) {
	
		jugador.moverA(carcel);
	}

}
