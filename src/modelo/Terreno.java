package modelo;

import java.util.ArrayList;

public class Terreno implements Casillero, Agrupable {
	
//	private String nombre;
	private int precio;
	private Grupo grupo;
	private Jugador propietario;
	private int costoEdificarCasa;
	private int costoEdificarHotel;
	private ArrayList<Construccion> casas = new ArrayList<Construccion>();
	private ArrayList<Construccion> hoteles = new ArrayList<Construccion>();
	private ArrayList<Integer> preciosDeAlquiler = new ArrayList<Integer>();

	public Terreno(String nombre, Grupo provincia, int precio, int alquiler,
			int alquiler1Casa, int alquiler2Casas, int alquilerHotel, int costoEdificarCasa, int costoEdificarHotel) {
//		this.nombre = nombre;
		this.precio = precio;
		this.grupo = provincia;
		provincia.agregar(this);
		this.preciosDeAlquiler.add(alquiler);
		this.preciosDeAlquiler.add(alquiler1Casa);
		this.preciosDeAlquiler.add(alquiler2Casas);
		this.preciosDeAlquiler.add(alquilerHotel);
		this.costoEdificarCasa= costoEdificarCasa;
		this.costoEdificarHotel= costoEdificarHotel;
	}
	
	@Override
	public void ocupar(Jugador jugador) {
		
		if(this.tienePropietario() && !jugador.equals(propietario)) {
			int costoDeAlquiler=this.calcularCostoDeAlquiler(jugador);
			jugador.decrementarDinero(costoDeAlquiler);
			propietario.incrementarDinero(costoDeAlquiler);
		}
	}
	
	private int calcularCostoDeAlquiler(Jugador jugador) {
		int costoDeAlquiler=this.preciosDeAlquiler.get(0);
		
		if (this.hoteles.isEmpty()) {
			if(!this.casas.isEmpty()) {
				costoDeAlquiler=this.preciosDeAlquiler.get(this.casas.size());
			}
		}
		else costoDeAlquiler=this.preciosDeAlquiler.get(3);
		
		return costoDeAlquiler;
	}
	
	public void comprar(Jugador jugador) {
		if (!this.tienePropietario()) {// si ya tiene duenio lanzar exception
			this.propietario = jugador;
			jugador.decrementarDinero(precio);
			jugador.agregarTerreno(this);
		}
	}
	
	public void construirCasa(Jugador jugador) {
		//lanzar exception si no se puede construir
		if (this.puedeEdificar(jugador)) {
			Construccion casaNueva=new Construccion(costoEdificarCasa);
			this.casas.add(casaNueva);
			propietario.decrementarDinero(costoEdificarCasa);
		}
	}
	
	public void construirHotel(Jugador jugador) {
		//lanzar exception si no se puede construir
		if (this.puedeEdificar(jugador)) {
			Construccion hotelNuevo=new Construccion(costoEdificarHotel);
			this.hoteles.add(hotelNuevo);
			this.casas.clear();
			propietario.decrementarDinero(costoEdificarHotel);
		}
	}
	
	private boolean puedeEdificar(Jugador jugador) {
		boolean puedeEdificar=false;
		
		if (grupo.mismoPropietario(jugador)&& hoteles.isEmpty()) {
			if (grupo.esMultiple() && casas.size()==2 && jugador.getDinero()>=costoEdificarHotel) {
				puedeEdificar=true;
			}
			else if (casas.size()<2 && jugador.getDinero()>=costoEdificarCasa) {
					puedeEdificar=true;
			}
		}
		return puedeEdificar;
	}

	public int cantPropiedades() {
		return (1 + casas.size() + hoteles.size());
	}
	
	private boolean tienePropietario() {
		return this.propietario!=null;
	}

	public Jugador getPropietario() {
		return propietario;
	}
}
