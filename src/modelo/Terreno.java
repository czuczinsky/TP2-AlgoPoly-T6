package modelo;

import java.util.ArrayList;

public class Terreno extends Agrupable {
	private int costoEdificarCasa;
	private int costoEdificarHotel;
	private int valorAlquiler;
	private int valorAlquiler1raCasa;
	private int valorAlquiler2daCasa;
	private int valorAlquilerHotel;

	private ArrayList<Construccion> casas = new ArrayList<Construccion>();
	private ArrayList<Construccion> hoteles = new ArrayList<Construccion>();

	public Terreno(String nombre, Grupo grupo, int precio, int alquiler, int alquiler1Casa, int alquiler2Casas,
			int alquilerHotel, int costoEdificarCasa, int costoEdificarHotel) {
		this.setNombre(nombre);
		this.setPrecio(precio);
		this.setGrupo(grupo);
		grupo.agregar(this);
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
		int precioTotal = this.getPrecio();
		for (Construccion casa : casas)
			precioTotal = precioTotal + casa.getprecio();
		for (Construccion hotel : hoteles)
			precioTotal = precioTotal + hotel.getprecio();
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
		this.getPropietario().incrementarDinero(valorAlquiler);
	}

	public void construirCasa() {
		// lanzar exception si no se puede construir
		if (this.puedeEdificarCasa()) {
			Construccion casaNueva;
			if (casas.size() == 0) {
				casaNueva = new Construccion(this.getPropietario(), costoEdificarCasa, valorAlquiler1raCasa);
			} else {
				casaNueva = new Construccion(this.getPropietario(), costoEdificarCasa, valorAlquiler2daCasa);
			}
			this.casas.add(casaNueva);
			this.getPropietario().decrementarDinero(costoEdificarCasa);
		}
	}

	public void construirHotel() {
		// lanzar exception si no se puede construir
		if (this.puedeEdificarHotel()) {
			Construccion hotelNuevo = new Construccion(this.getPropietario(), costoEdificarHotel, valorAlquilerHotel);
			this.hoteles.add(hotelNuevo);
			this.casas.clear();
			this.getPropietario().decrementarDinero(costoEdificarHotel);
		}
	}

	public boolean puedeEdificarCasa() {
		if (!this.tienePropietario())
			return false;
		if (this.getGrupo().esMultiple())
			return (this.getGrupo().mismoPropietario() && hoteles.isEmpty() && casas.size() < 2
					&& this.getPropietario().getDinero() >= costoEdificarCasa);
		return (casas.size() < 1 && this.getPropietario().getDinero() >= costoEdificarCasa);
	}

	public boolean puedeEdificarCasa(Jugador jugador) {
		if (jugador != getPropietario())
			return false;
		else
			return (puedeEdificarCasa());
	}

	private boolean puedeEdificarHotel() {
		return (this.getGrupo().mismoPropietario() && hoteles.isEmpty() && this.getGrupo().esMultiple()
				&& this.getGrupo().estaCompleto() && this.getPropietario().getDinero() >= costoEdificarHotel);
	}

	public boolean puedeEdificarHotel(Jugador jugador) {
		if (jugador != getPropietario())
			return false;
		else
			return (puedeEdificarHotel());
	}

	public int cantPropiedades() {
		return 1 + casas.size() + hoteles.size();
	}

	public int cantCasas() {
		return casas.size();
	}

	public int cantHoteles() {
		return hoteles.size();
	}

	public boolean estaCompleto() {
		return (casas.size() == 2 || hoteles.size() == 1);
	}
	
	public int getCostoEdificarCasa() {
		return costoEdificarCasa;
	}

	public int getCostoEdificarHotel() {
		return costoEdificarHotel;
	}
}
