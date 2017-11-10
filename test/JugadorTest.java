package test;

import static org.junit.Assert.*;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	@Test
	public void test01DecrementarDinero() {
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		jugador1.decrementarDinero(5000);
		assertEquals(95000 , jugador1.getDinero());
		}
	
	@Test
	public void test02IncrementarDinero() {
		Jugador jugador = new Jugador("Test",0);
		jugador.incrementarDinero(1000);
		assertEquals(1000,jugador.getDinero());
	}
}
