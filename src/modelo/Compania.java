package modelo;

public class Compania extends Agrupable {
	private String nombre;
	private int precio;
	private Grupo grupo;
	private int multiplicadorSimple;
	private int multiplicadorMultiple;
	private Jugador propietario;
	public Dados dados=new Dados();

	public Compania(String nombre, int precio, Grupo grupo, int multiplicadorSimple, int multiplicadorMultiple) {
		this.nombre = nombre;
		this.precio = precio;
		this.grupo = grupo;
		this.multiplicadorSimple = multiplicadorSimple;
		this.multiplicadorMultiple = multiplicadorMultiple;
		grupo.agregar(this);
	}

	public void venderA(Jugador jugador) {
		// TODO si ya tiene duenio lanzar exception
		if (!this.tienePropietario()) {
		this.propietario = jugador;
		jugador.decrementarDinero(precio);
		}
	}

	public void cobrarA(Jugador jugador, Dados dados) {
		
		if (grupo.esMultiple() && grupo.mismoPropietario()) {
			jugador.decrementarDinero(multiplicadorMultiple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorMultiple * dados.getSuma());
		} else {
			jugador.decrementarDinero(multiplicadorSimple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorSimple * dados.getSuma());
		}	
	}
	
	private boolean tienePropietario() {
		return this.propietario!=null;
	}

	public boolean estaCompleto() {
		return false;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public Jugador getPropietario() {
		return propietario;
	}
}
