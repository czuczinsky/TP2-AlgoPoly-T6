package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Carcel implements Casillero {
	
	private ArrayList<Jugador> prisioneros=new ArrayList<Jugador>();
	private ArrayList<Integer> turnos=new ArrayList<Integer>();
	
	@Override
	public void ocupar(Jugador jugador) {
		this.prisioneros.add(jugador);
		int turnoInicial=1;
		this.turnos.add(turnoInicial);
	}
	
	public int cantidadDePrisioneros() {
		return prisioneros.size();
	}
	
	private void actualizarTurnoJugador(Jugador jugador) {
		
		int indexJugador = this.prisioneros.indexOf(jugador);
		int turnoActual=this.turnos.get(indexJugador);
		this.turnos.set(indexJugador, turnoActual+1);	
	}
	
	private void actualizarPrisioneros() {
		
		Iterator<Integer> turnosIter = turnos.iterator();
		while (turnosIter.hasNext()) {
			Integer turno = turnosIter.next();
			if (turno>3) {
				int indexJugador = this.turnos.indexOf(turno);
				this.prisioneros.remove(indexJugador);
				turnosIter.remove();
			}
		}
	}
	
	public boolean puedeMoverse(Jugador jugador) {
		boolean puedeMoverse=true;
		this.actualizarPrisioneros();
		
		for (Jugador prisionero:prisioneros) {
			if(jugador.equals(prisionero)) {
				puedeMoverse=false;
				this.actualizarTurnoJugador(jugador);
			}
		}
		return puedeMoverse;	
	}
	
	private boolean verificarSiPuedePagar(Jugador jugador) {
		boolean puedePagar=false;
		
		int indiceJugador=this.prisioneros.indexOf(jugador);
		int turno=this.turnos.get(indiceJugador);
		
		if (turno>1) {
			puedePagar=true;	
		}
		return puedePagar;
	}
	
	public void cobrarFianza(Jugador jugador) {
		
		int dineroDisponible=jugador.getDinero();
		boolean puedePagar=this.verificarSiPuedePagar(jugador);
		
		if ((dineroDisponible>45000) && (puedePagar)){
			int indicePrisionero=this.prisioneros.indexOf(jugador);
			this.turnos.remove(indicePrisionero);
			this.prisioneros.remove(jugador);
			jugador.decrementarDinero(45000);
		}
//		else {
//			throw new PagoDeFianzaNoHabilitadoException();
//		}
	}

}
