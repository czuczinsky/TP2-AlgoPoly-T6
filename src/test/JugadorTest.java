package test;


import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	@Test
	public void test01DecrementarDinero() {
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		jugador1.decrementarDinero(5000);
		Assert.assertEquals(95000 , jugador1.getDinero());
		}
}
