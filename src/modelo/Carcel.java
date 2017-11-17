package modelo;

import java.util.ArrayList;

public class Carcel extends Casillero {
	
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
		boolean puedeMoverse=true;
	
		if (this.existePrisionero(jugador)) {
			Prisionero prisionero=this.obtenerPrisionero(jugador);
			if(!prisionero.cumplioLaCondena()) {
				puedeMoverse=false;
			}
			else prisioneros.remove(prisionero);
		}
		return puedeMoverse;	
	}
	
	public void cobrarFianza(Jugador jugador) {
		
		Prisionero prisionero=this.obtenerPrisionero(jugador);
		
		if (prisionero.puedePagarFianza(45000)){
			this.prisioneros.remove(prisionero);
			jugador.decrementarDinero(45000);
		}
//		else {
//			throw new PagoDeFianzaNoHabilitadoException();
//		}
	}
	
	private Prisionero obtenerPrisionero(Jugador jugador) {
		for (Prisionero prisionero:prisioneros) {
			if(prisionero.esIgualA(jugador)) {	
				return prisionero;
			}
		}
		return null;
	}
	
	private boolean existePrisionero(Jugador jugador) {
		for (Prisionero prisionero:prisioneros) {
			if(prisionero.esIgualA(jugador)) {
				return true;
			}
		}
		return false; 
	}
}
