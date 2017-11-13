package modelo;

public abstract class DesplazamientoDinamico implements Casillero{
	
	public Tablero tablero;

	public DesplazamientoDinamico(Tablero tablero) {
		this.tablero=tablero;
	}
	
    abstract public void moverDel2al6(Jugador jugador);
	
	abstract public void moverDel11al12(Jugador jugador);
	
	abstract public void moverDel7al10(Jugador jugador);

	@Override
	public void ocupar(Jugador jugador) {
		
		Dados dados=Dados.getDados();
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			this.moverDel2al6(jugador);
		}
		
		else if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
			this.moverDel7al10(jugador);
		}
			
		else this.moverDel11al12(jugador);	
	}

}
