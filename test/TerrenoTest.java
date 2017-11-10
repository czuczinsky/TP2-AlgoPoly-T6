package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class TerrenoTest {

	@Test
	public void test01Comprar() {
		Provincia provincia1 = new Provincia();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		terreno1.comprar(jugador1);
		Assert.assertEquals(jugador1 , terreno1.getPropietario());
		Assert.assertEquals(80000 , jugador1.getDinero());
	}

}
