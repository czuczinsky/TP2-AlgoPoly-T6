package modelo;

public class ImpuestoDeLujo implements Casillero {
	
	public void ocupar(Jugador jugador){
		
		int monto=jugador.getDinero();
		monto=(int) (monto*(double)10/100);
		jugador.decrementarDinero(monto);
		
	}
}
