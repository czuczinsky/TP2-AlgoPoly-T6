package modelo;

import java.util.ArrayList;

public class Carcel implements Casillero {
	
private ArrayList<Prisionero> prisioneros=new ArrayList<Prisionero>();
	
	@Override
	public void ocupar(Jugador jugador) {
		Prisionero nuevoPrisionero= new Prisionero(jugador);
		this.prisioneros.add(nuevoPrisionero);
	}
	
	public int cantidadDePrisioneros() {
		return prisioneros.size();
	}
	
	public boolean puedeMoverse(Jugador jugador) {

		Prisionero prisionero=this.obtenerPrisionero(jugador);
		boolean puedeMoverse=prisionero.fianzaPagada();
		
		if (prisionero.getTurno()>=4) {
			this.prisioneros.remove(prisionero);
			puedeMoverse=true;
		}
		else {
			prisionero.incrementarTurno();
		}
		return puedeMoverse;	
	}
	
	public void cobrarFianza(Jugador jugador) {
		
		Prisionero prisionero=this.obtenerPrisionero(jugador);
		
		if ((prisionero.tieneSuficienteDinero(45000)) && (prisionero.getTurno()>1)){
			this.prisioneros.remove(prisionero);
			jugador.decrementarDinero(45000);
		}
//		else {
//			throw new PagoDeFianzaNoHabilitadoException();
//		}
	}
	
	private Prisionero obtenerPrisionero(Jugador jugador) {
		
		Prisionero prisioneroBuscado=new Prisionero();
		for (Prisionero prisionero:prisioneros) {
			if(prisionero.esIgualA(jugador)) {
				prisioneroBuscado=prisionero;
			}
		}
		return prisioneroBuscado;
	}
}
