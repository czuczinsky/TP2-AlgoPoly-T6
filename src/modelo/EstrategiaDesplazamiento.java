package modelo;

public abstract class EstrategiaDesplazamiento {
	Jugador jugador;
	Dados dados;
	
	public EstrategiaDesplazamiento(Jugador jugador,Dados dados){
			this.jugador=jugador;
			this.dados=dados;
	}

	public abstract int getCantidadADesplazar(Jugador jugador, Dados dados);
}
