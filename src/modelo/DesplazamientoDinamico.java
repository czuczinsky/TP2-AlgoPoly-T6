package modelo;

public abstract class DesplazamientoDinamico implements Casillero {
	
	public Tablero tablero;

	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void ocupar(Jugador jugador){
		
		Dados dados=Dados.getDados();
		Posicionador posicionador=new Posicionador();
		
			if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			
				if ((jugador.getPosicion()) instanceof Avance){
						int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
						((Avance)jugador.getPosicion()).avanzarJugador(jugador,cantidadPosiciones);
				}
				
				if ((jugador.getPosicion())instanceof Retroceso){

					int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
					((Retroceso) jugador.getPosicion()).retrocederJugador(jugador,cantidadPosiciones);
				}
			}
			
			if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
				
				if ((jugador.getPosicion()) instanceof Avance){
		
					int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
					((Avance)jugador.getPosicion()).avanzarJugador(jugador,cantidadPosiciones);
				}
				
				if ((jugador.getPosicion()) instanceof Retroceso){
			
					int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
					((Retroceso) jugador.getPosicion()).retrocederJugador(jugador,cantidadPosiciones);
				}
				
			}
		
			
			if ((dados.getSuma()==11)||(dados.getSuma()==12)) {
				
				if ((jugador.getPosicion()) instanceof Avance){
					
					int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
					((Avance)jugador.getPosicion()).avanzarJugador(jugador,cantidadPosiciones);
				}
				
				if ((jugador.getPosicion()) instanceof Retroceso){
			
					int cantidadPosiciones=posicionador.posicionDelJugador(jugador,dados);
					((Retroceso) jugador.getPosicion()).retrocederJugador(jugador,cantidadPosiciones);	
				}
		
			}
	
	}
}
