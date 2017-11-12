package modelo;

public class Terreno implements Casillero, Agrupable {
	
	private String nombre;
	private int precio;
	private Grupo grupo;
	private int alquiler;
	private int alquiler1Casa;
	private int alquiler2Casas;
	private int alquilerHotel;
	private Jugador propietario;
	private int costoEdificarCasa;
	private int costoEdificarHotel;
	private int cantCasas;
	private int cantHoteles;

	public Terreno (String nombre, Grupo provincia, int precio, int alquiler,
			int alquiler1Casa, int alquiler2Casas, int alquilerHotel,
			int costoEdificarCasa, int costoEdificarHotel) {
		this.nombre = nombre;
		this.precio = precio;
		this.grupo = provincia;
		provincia.agregar(this);
		this.alquiler = alquiler;
		this.alquiler1Casa = alquiler1Casa;
		this.alquiler2Casas = alquiler2Casas;
		this.alquilerHotel = alquilerHotel;
		this.costoEdificarCasa = costoEdificarCasa;
		this.costoEdificarHotel = costoEdificarHotel;
		this.cantCasas = 0;
		this.cantHoteles = 0;
	}
	
	public void comprar(Jugador jugador) {
		// TODO ver que se hace si ya tiene duenio
		this.propietario = jugador;
		jugador.decrementarDinero(precio);
		jugador.agregarTerreno(this);
	}

	public Jugador getPropietario() {
		return propietario;
	}
	
	public void edificar() {
		if (grupo.mismoPropietario()) {
			if (cantHoteles == 0 && (cantCasas == 0 || cantCasas == 1)) {
				propietario.decrementarDinero(costoEdificarCasa);
				cantCasas++;
			} else {
				if (this.grupo.esMultiple()) {
					if (cantHoteles == 0) {
						propietario.decrementarDinero(costoEdificarHotel);
						cantCasas = 0;
						cantHoteles++;
					}
				}
			}
		}
	}

	@Override
	public void ocupar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	public int cantPropiedades() {
		return (1 + cantCasas + cantHoteles);
	}

}
