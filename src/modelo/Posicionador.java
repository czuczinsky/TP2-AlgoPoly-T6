package modelo;

public class Posicionador {

	public int posicion1Jugador(Jugador jugador,Dados dados){
		
		return(dados.getSuma()-2);
		
	}
	
	public int posicion2Jugador(Jugador jugador,Dados dados){
		
		return(dados.getSuma()-jugador.cantPropiedades());
		
	}
	
	public int posicion3Jugador(Jugador jugador,Dados dados){
		
		return((jugador.getDinero())%(dados.getSuma()));
	}

}
