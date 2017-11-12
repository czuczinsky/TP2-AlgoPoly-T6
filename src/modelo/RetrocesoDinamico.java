package modelo;

public class RetrocesoDinamico implements Casillero {

	private Tablero tablero;

	
	public RetrocesoDinamico(Tablero tablero) {
		this.tablero = tablero;
	}
	
	
	public void retrocederConDadosEntre2y6(Jugador jugador) {
		Dados dados=Dados.getDados();
		
		if((dados.getSuma()>=2)&&(dados.getSuma()<=6)) {
			
				for (int i =0;i<(dados.getSuma()-jugador.cantPropiedades());i++)
				
					this.tablero.retroceder(jugador);
		}
	}
	
	
	public void retrocederConDados11o12(Jugador jugador) {
		Dados dados=Dados.getDados();
		
		if ((dados.getSuma()==11)||(dados.getSuma()==12)) {
			
			for (int i =0;i<(dados.getSuma()-2);i++)
				
				this.tablero.retroceder(jugador);
		}
	}
		
	public void retrocederConDadosEntre7y10(Jugador jugador) {
		Dados dados=Dados.getDados();
		
		if ((dados.getSuma()>=7)&&(dados.getSuma()<=10)) {
			
			int cantidad=((jugador.getDinero())%(dados.getSuma()));
			for (int i =0;i<cantidad;i++)
				
				this.tablero.retroceder(jugador);
		}
	}
	
	
	@Override
	public void ocupar(Jugador jugador) {
		
		this.retrocederConDadosEntre2y6(jugador);
		
		this.retrocederConDadosEntre7y10(jugador);
	
		this.retrocederConDados11o12(jugador);
	}
}