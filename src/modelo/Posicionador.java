package modelo;

public class Posicionador {

	public int posicionDelJugador(Jugador jugador,Dados dados){
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			
				if ((jugador.getPosicion()) instanceof Avance){
								return(dados.getSuma()-2);
				}
				
				if ((jugador.getPosicion())instanceof Retroceso){
					return(dados.getSuma()-jugador.cantPropiedades());
		
				}
			}
			
			if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
				
				return((jugador.getDinero())%(dados.getSuma()));
				
			}
		
			
			if ((dados.getSuma()==11)||(dados.getSuma()==12)) {
				
				if ((jugador.getPosicion()) instanceof Avance){
							
					return(dados.getSuma()-jugador.cantPropiedades());
				}
				
				if ((jugador.getPosicion()) instanceof Retroceso){
					return(dados.getSuma()-2);
				}
		
			}
			return 0;
	
	}
	
	
	
	
}