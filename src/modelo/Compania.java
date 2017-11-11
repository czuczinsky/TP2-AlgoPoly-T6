package modelo;

public class Compania implements Casillero, Agrupable {
	private String nombre;
	private int precio;
	private Grupo grupo;
	private int multiplicadorSimple;
	private int multiplicadorMultiple;
	private Jugador propietario;

	public Compania(String nombre, int precio, Grupo grupo, int multiplicadorSimpe, int multiplicadorMultiple) {
		this.nombre = nombre;
		this.precio = precio;
		this.grupo = grupo;
		this.multiplicadorSimple = multiplicadorSimpe;
		this.multiplicadorMultiple = multiplicadorMultiple;
		grupo.agregar(this);
	}

	public void comprar(Jugador jugador) {
		// TODO ver que se hace si ya tiene duenio
		this.propietario = jugador;
		jugador.decrementarDinero(precio);
	}

	@Override
	public Jugador getPropietario() {
		return propietario;
	}

	
	@Override
	public void ocupar(Jugador jugador) {
		Dados dados = Dados.getDados();
		if (grupo.esMultiple() && grupo.mismoPropietario()) {
			jugador.decrementarDinero(multiplicadorMultiple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorMultiple * dados.getSuma());
		} else {
			jugador.decrementarDinero(multiplicadorSimple * dados.getSuma());
			propietario.incrementarDinero(multiplicadorSimple * dados.getSuma());
		}
	}

}
