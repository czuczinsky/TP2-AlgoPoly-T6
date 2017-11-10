package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Quini6;

public class Quini6Test {

	@Test
	public void test01JugadorCaePorPrimeraVezEnQuini6AumentaSuDineroEn50Mil() {
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador);
		
		assertEquals(50000,jugador.getDinero());
	}
	
	@Test
	public void test02JugadorCaePorSegundaVezEnQuini6AumentaSuDineroEn30Mil() {
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador);
		quini6.ocupar(jugador);
		
		assertEquals(80000,jugador.getDinero());
	}
	
	@Test
	public void test03JugadorCaePorTerceraVezEnQuini6NoAumentaSuDinero() {
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador);
		quini6.ocupar(jugador);
		quini6.ocupar(jugador);
		
		assertEquals(80000,jugador.getDinero());
	}

}
