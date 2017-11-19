package modelo;

public abstract class Agrupable extends Casillero {

	public abstract Jugador getPropietario();
	public abstract int getPrecio();
	public abstract void setPropietario(Jugador jugador);
	public abstract boolean estaCompleto();
	public abstract void cobrarA(Jugador jugador, Dados dados);
	
	public void ocupar(Jugador jugador, Dados dados) {
		if (this.tienePropietario()&& !jugador.equals(this.getPropietario())){
			this.cobrarA(jugador,dados);
		}
	}
	
	public void venderA(Jugador jugador) {
		if (!this.tienePropietario()) {// si ya tiene duenio lanzar exception
			this.setPropietario(jugador);
			jugador.decrementarDinero(this.getPrecio());
			this.agregarA(jugador);
		}
	}
	
	private boolean tienePropietario() {
			return this.getPropietario()!=null;
		}
	
	public int cantPropiedades() {
		return 0;
	}
	
	public void agregarA(Jugador jugador) {
	}
}
