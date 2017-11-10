package modelo;

public class Terreno extends Casillero {

	private int precio;
	private Provincia provincia;
	private int alquiler;
	private int alquiler1Casa;
	private int alquiler2Casas;
	private int alquilerHotel;
	private Jugador propietario;

	public Terreno (String nombre, Provincia provincia, int precio, int alquiler,
			int alquiler1Casa, int alquiler2Casas, int alquilerHotel,
			int construirCasa, int ConstruirHotel) {
		this.nombre = nombre;
		this.provincia = provincia;
		provincia.agregarTerreno(this);
		this.alquiler = alquiler;
		this.alquiler1Casa = alquiler1Casa;
		this.alquiler2Casas = alquiler2Casas;
		this.alquilerHotel = alquilerHotel;
	}
	
	public void comprar(Jugador jugador) {
		// TODO ver que se hace si tiene dueño
		this.propietario = jugador;
		jugador.decrementarDinero(precio);
	}

}
