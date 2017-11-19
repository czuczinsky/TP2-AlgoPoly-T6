package modelo;

public abstract class Agrupable extends Casillero {

	public abstract Jugador getPropietario();
	public abstract void setPropietario(Jugador jugador);
	public abstract int getPrecio();
	public abstract boolean estaCompleto();
	public abstract void cobrarA(Jugador jugador, Dados dados);
	public abstract int precioTotalDeVenta();
	
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
	
	public void vender() {
	
		Jugador propietario=this.getPropietario();
		int montoACobrar=this.precioTotalDeVenta();
		montoACobrar=(int) (montoACobrar*(double)(100-15)/100);
		propietario.incrementarDinero(montoACobrar);
		this.setPropietario(null);
		this.eliminarEdificaciones();
	}
	
	private boolean tienePropietario() {
			return this.getPropietario()!=null;
	}
	
	public void agregarA(Jugador jugador) {
	}
	
	public void eliminarEdificaciones() {
	}
	
	public int cantPropiedades() {
		return 0;
	}
}
