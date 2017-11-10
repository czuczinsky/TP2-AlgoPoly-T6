package modelo;

import java.util.ArrayList;

public class Carcel extends Casillero {
	ArrayList<Jugador> prisioneros=new ArrayList<Jugador>();
	int turno=0;
	
	@Override
	public void ocupar(Jugador jugador) {
		this.prisioneros.add(jugador);
	}
	
	public int cantidadDePrisioneros() {
		return prisioneros.size();
	}
	
	private void actualizarPrisioneros() {
		if (this.turno>3) {
			this.prisioneros.clear();
		}
	}
	
	public boolean puedeMoverse(Jugador jugador) {
		boolean puedeMoverse=true;
		this.turno=turno+1;
		this.actualizarPrisioneros();
		
		for (Jugador prisionero:prisioneros) {
			if(jugador.equals(prisionero)) {
				puedeMoverse=false;
			}
		}
		return puedeMoverse;
	}
	
	private boolean verificarSiPuedePagar(Jugador jugador) {
		boolean puedePagar=false;
		
		if (this.turno>1) {
			puedePagar=true;	
		}
		return puedePagar;
	}
	
	public void cobrarFianza(Jugador jugador) {
		int dineroDisponible=jugador.getDinero();
		boolean puedePagar=this.verificarSiPuedePagar(jugador);
		
		if ((dineroDisponible>45000) && (puedePagar)){
			this.prisioneros.remove(jugador);
			jugador.decrementarDinero(45000);
		}
//		else {
//			throw new PagoDeFianzaNoHabilitadoException();
//		}
	}

}
