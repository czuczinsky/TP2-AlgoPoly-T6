package modelo;

public abstract class DesplazamientoDinamico implements Casillero {
	
	public Tablero tablero;
	public Posicionador posicionador;

	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero = tablero;
		posicionador=new Posicionador();
	}
	
	public void ocupar(Jugador jugador){
		
		Dados dados=Dados.getDados();
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			
				if ((jugador.getPosicion()) instanceof Avance){
					((Avance) jugador.getPosicion()).avanzar(jugador);
				}
				if ((jugador.getPosicion())instanceof Retroceso){
					((Retroceso) jugador.getPosicion()).retroceder(jugador);
				}
		}
			
		if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
				
				if ((jugador.getPosicion()) instanceof Avance){
					((Avance) jugador.getPosicion()).avanzar(jugador);
				}
				if ((jugador.getPosicion()) instanceof Retroceso){
					((Retroceso) jugador.getPosicion()).retroceder(jugador);
				}
		}
			
		if ((dados.getSuma()==11)||(dados.getSuma()==12)) {
				if ((jugador.getPosicion()) instanceof Avance){
					((Avance) jugador.getPosicion()).avanzar(jugador);
				}
				if ((jugador.getPosicion()) instanceof Retroceso){
					((Retroceso) jugador.getPosicion()).retroceder(jugador);
				}
		}
	}
}
