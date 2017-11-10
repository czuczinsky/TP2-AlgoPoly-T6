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
	
	@Test
	public void test04JugadorGaneTresVecesElQuiniYOtroJugadorUnaVez() {
		Jugador jugador1 = new Jugador("1", 0);
		Jugador jugador2 = new Jugador("2", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador1);
		quini6.ocupar(jugador1);
		quini6.ocupar(jugador2);
		quini6.ocupar(jugador1);
		
		assertTrue(jugador1.getDinero() == 80000 && jugador2.getDinero() == 50000);
	}

	@Test
	public void test05TresJugadoresGananElQuini6() {
		Jugador jugador1 = new Jugador("1", 0);
		Jugador jugador2 = new Jugador("2", 1000);
		Jugador jugador3 = new Jugador("3", 50000);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador1);
		quini6.ocupar(jugador3);
		quini6.ocupar(jugador2);
		
		assertTrue(jugador1.getDinero() == 50000 && jugador2.getDinero() == 51000 && jugador3.getDinero() == 100000);
	}
}
