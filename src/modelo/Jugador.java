package modelo;

import java.util.ArrayList;

public class Jugador {
//	private String nombre;
	private int dinero;
	private Casillero posicion;
	private ArrayList<Terreno> terrenos = new ArrayList<Terreno>();

	
	public Jugador(String nombre, int dinero) {
//		this.nombre = nombre;
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
		this.dinero-=monto;
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
	
	public void agregarTerreno(Terreno terreno) {
		this.terrenos.add(terreno);
	}

	public int cantPropiedades() {
		int cantidad = 0;
		
		for (Terreno terreno : terrenos) {
			cantidad += terreno.cantPropiedades(); 
		}
		
	return cantidad;
	}
}
