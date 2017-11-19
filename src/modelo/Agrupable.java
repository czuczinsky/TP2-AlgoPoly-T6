package modelo;

public abstract class Agrupable extends Casillero {
	

	public abstract Jugador getPropietario();
	public abstract boolean estaCompleto();
	public abstract void cobrarA(Jugador jugador, Dados dados);
	
	public void ocupar(Jugador jugador, Dados dados) {
		if (this.tienePropietario()&& !jugador.equals(this.getPropietario())){
			this.cobrarA(jugador,dados);
		}
	}
	
	private boolean tienePropietario() {
			return this.getPropietario()!=null;
		}
	
	public int cantPropiedades() {
		return 0;
	}
}
