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

	public void cobrarA(Jugador jugador, Dados dados) {
		
		if (grupo.esMultiple() && grupo.mismoPropietario()) {
			jugador.decrementarDinero(multiplicadorMultiple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorMultiple * dados.getSuma());
		} else {
			jugador.decrementarDinero(multiplicadorSimple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorSimple * dados.getSuma());
		}	
	}

	public boolean estaCompleto() {
		return false;
	}

	public String getNombre() {
		return nombre;
	}
	public Jugador getPropietario() {
		return propietario;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public void setPropietario(Jugador jugador) {
		this.propietario=jugador;
	}
}
