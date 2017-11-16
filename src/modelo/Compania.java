package modelo;

public class Compania implements Casillero, Agrupable {
//	private String nombre;
	private int precio;
	private Grupo grupo;
	private int multiplicadorSimple;
	private int multiplicadorMultiple;
	private Jugador propietario;

	public Compania(String nombre, int precio, Grupo grupo, int multiplicadorSimple, int multiplicadorMultiple) {
//		this.nombre = nombre;
		this.precio = precio;
		this.grupo = grupo;
		this.multiplicadorSimple = multiplicadorSimple;
		this.multiplicadorMultiple = multiplicadorMultiple;
		grupo.agregar(this);
	}

	public void comprar(Jugador jugador) {
		// TODO si ya tiene duenio lanzar exception
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
		
		if (this.tienePropietario()&& !jugador.equals(propietario)){
			
			if (grupo.esMultiple() && grupo.mismoPropietario()) {
				jugador.decrementarDinero(multiplicadorMultiple * dados.getSuma());
				propietario.incrementarDinero(multiplicadorMultiple * dados.getSuma());
			} else {
				jugador.decrementarDinero(multiplicadorSimple * dados.getSuma());
				propietario.incrementarDinero(multiplicadorSimple * dados.getSuma());
			}
		}
	}
	
	private boolean tienePropietario() {
		return this.propietario!=null;
	}

}
