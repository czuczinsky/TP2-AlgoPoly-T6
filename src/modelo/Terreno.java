package modelo;

import java.util.ArrayList;

public class Terreno extends Agrupable {

	private String nombre;
	private int precio;
	private Grupo grupo;
	private Jugador propietario;
	private int costoEdificarCasa;
	private int costoEdificarHotel;
	private int valorAlquiler;
	private int valorAlquiler1raCasa;
	private int valorAlquiler2daCasa;
	private int valorAlquilerHotel;

	private ArrayList<Construccion> casas = new ArrayList<Construccion>();
	private ArrayList<Construccion> hoteles = new ArrayList<Construccion>();

	public Terreno(String nombre, Grupo provincia, int precio, int alquiler, int alquiler1Casa, int alquiler2Casas,
			int alquilerHotel, int costoEdificarCasa, int costoEdificarHotel) {
		this.nombre = nombre;
		this.precio = precio;
		this.grupo = provincia;
		provincia.agregar(this);
		this.valorAlquiler = alquiler;
		this.valorAlquiler1raCasa = alquiler1Casa - alquiler;
		this.valorAlquiler2daCasa = alquiler2Casas - alquiler1Casa;
		this.valorAlquilerHotel = alquilerHotel - alquiler;
		this.costoEdificarCasa = costoEdificarCasa;
		this.costoEdificarHotel = costoEdificarHotel;
	}
	
	public void agregarA(Jugador jugador) {
		jugador.agregarTerreno(this);
	}
	
	public int precioTotalDeVenta() {
		int precioTotal=this.precio;
		for (Construccion casa : casas)
			precioTotal=precioTotal+casa.getprecio();
		for (Construccion hotel : hoteles)
			precioTotal=precioTotal+hotel.getprecio();
		
		return precioTotal;
	}

	public void eliminarEdificaciones() {
		this.casas.clear();
		this.hoteles.clear();
	}
	
	public void cobrarA(Jugador jugador, Dados dados) {
		this.cobrarAlquilerTerrenoA(jugador);
		for (Construccion casa : casas)
			casa.cobrarAlquilerA(jugador);
		for (Construccion hotel : hoteles)
			hotel.cobrarAlquilerA(jugador);
	}

	private void cobrarAlquilerTerrenoA(Jugador jugador) {
		jugador.decrementarDinero(valorAlquiler);
		propietario.incrementarDinero(valorAlquiler);
	}

	public void construirCasa() {
		// lanzar exception si no se puede construir
		if (this.puedeEdificarCasa()) {
			Construccion casaNueva;
			if (casas.size() == 0) {
				casaNueva = new Construccion(propietario, costoEdificarCasa, valorAlquiler1raCasa);
			} else {
				casaNueva = new Construccion(propietario, costoEdificarCasa, valorAlquiler2daCasa);
			}
			this.casas.add(casaNueva);
			propietario.decrementarDinero(costoEdificarCasa);
		}
	}

	public void construirHotel() {
		// lanzar exception si no se puede construir
		if (this.puedeEdificarHotel()) {
			Construccion hotelNuevo = new Construccion(propietario, costoEdificarHotel, valorAlquilerHotel);
			this.hoteles.add(hotelNuevo);
			this.casas.clear();
			propietario.decrementarDinero(costoEdificarHotel);
		}
	}

	private boolean puedeEdificarCasa() {
		return(grupo.mismoPropietario() && hoteles.isEmpty() && casas.size() < 2
				&& propietario.getDinero() >= costoEdificarCasa);
	}

	private boolean puedeEdificarHotel() {

		return(grupo.mismoPropietario() && hoteles.isEmpty() && grupo.esMultiple() && grupo.estaCompleto()
				&& propietario.getDinero() >= costoEdificarHotel);
	}

	public int cantPropiedades() {
		return 1 + casas.size() + hoteles.size();
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
	
	public boolean estaCompleto() {
		return (casas.size() == 2);
	}
	
	public String getNombre() {
		return nombre;
	}

}
