package modelo;

public class Compania extends Agrupable {
	private int multiplicadorSimple;
	private int multiplicadorMultiple;
	public Dados dados = new Dados();

	public Compania(String nombre, int precio, Grupo grupo, int multiplicadorSimple, int multiplicadorMultiple) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setGrupo(grupo);
		this.multiplicadorSimple = multiplicadorSimple;
		this.multiplicadorMultiple = multiplicadorMultiple;
		grupo.agregar(this);
	}

	public void cobrarA(Jugador jugador, Dados dados) {
		if (this.getGrupo().esMultiple() && this.getGrupo().mismoPropietario()) {
			jugador.decrementarDinero(multiplicadorMultiple * dados.getSuma());
			this.getPropietario().incrementarDinero(multiplicadorMultiple * dados.getSuma());
		} else {
			jugador.decrementarDinero(multiplicadorSimple * dados.getSuma());
			this.getPropietario().incrementarDinero(multiplicadorSimple * dados.getSuma());
		}
	}

	public int precioTotalDeVenta() {
		return this.getPrecio();
	}

	public boolean estaCompleto() {
		return false;
	}
}
