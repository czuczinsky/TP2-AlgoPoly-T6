package modelo;

import java.util.ArrayList;

public class Jugador {
	private String nombre;
	private int dinero;
	private Casillero posicion;
	private ArrayList<Agrupable> terrenos = new ArrayList<Agrupable>();

	
	public Jugador(String nombre, int dinero) {
		this.nombre = nombre;
		this.dinero = dinero;
		this.posicion= new Salida();
	}

	public int getDinero() {
		return dinero;
	}

	public void incrementarDinero(int monto) {
		this.dinero += monto;
	}
	
	public void decrementarDinero(int monto) {
		if (monto <= this.dinero) {
			this.dinero-=monto;
		} else {
			throw new SinDineroException();
		}
	}
	
	public void moverA(Casillero unCasillero, Dados dados) {
		if (this.posicion!=unCasillero) {
		this.posicion=unCasillero;
		this.posicion.ocupar(this,dados);
		}
	}

	public Casillero getPosicion() {
		return (this.posicion);
	}
	
	public void agregarTerreno(Agrupable terreno) {
		this.terrenos.add(terreno);
	}

	public int cantPropiedades() {
		int cantidad = 0;
		
		for (Agrupable terreno : terrenos) {
			cantidad += terreno.cantPropiedades(); 
		}
		
	return cantidad;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean puedoMoverse() {
		return this.posicion.puedeMoverse(this);
	}

	public void quiebra() {
		for (Agrupable terrenoActual:this.terrenos) {
			terrenoActual.setPropietario(null);
		}
		this.terrenos.clear();
	}
}
