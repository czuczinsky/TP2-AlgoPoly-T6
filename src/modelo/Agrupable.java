package modelo;

public abstract class Agrupable extends Casillero {

	private String nombre;
	private int precio;
	private Grupo grupo;
	private Jugador propietario;

	public abstract boolean estaCompleto();

	public abstract void cobrarA(Jugador jugador, Dados dados);

	public abstract int precioTotalDeVenta();

	public void ocupar(Jugador jugador, Dados dados) {
		if (this.tienePropietario() && !jugador.equals(this.getPropietario())) {
			this.cobrarA(jugador, dados);
		}
	}

	public void venderA(Jugador jugador) {
		if (!this.tienePropietario()) {
			this.setPropietario(jugador);
			jugador.decrementarDinero(this.getPrecio());
			this.agregarA(jugador);
		}
		else throw new PropietarioYaExistenteException();
	}

	public void vender() {
		Jugador propietario = this.getPropietario();
		propietario.eliminarTerreno(this);
		int montoACobrar = this.precioTotalDeVenta();
		montoACobrar = (int) (montoACobrar * (double) (100 - 15) / 100);
		propietario.incrementarDinero(montoACobrar);
		this.setPropietario(null);
		this.eliminarEdificaciones();
	}

	public boolean tienePropietario() {
		return this.getPropietario() != null;
	}

	public void agregarA(Jugador jugador) {
	}

	public void eliminarEdificaciones() {
	}

	public int cantPropiedades() {
		return 0;
	}

	public Jugador getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public boolean puedeComprarsePor(Jugador jugadorActual) {
		return (!tienePropietario() && jugadorActual.getPosicion() == this && jugadorActual.getDinero() >= this.precio);
	}

	public boolean puedeVendersePor(Jugador jugadorActual) {
		if (!tienePropietario())
			return false;
		return (this.getPropietario() == jugadorActual);
	}
	
	@Override
	public abstract int getAlquiler(Jugador jugador, Dados dados);
}
