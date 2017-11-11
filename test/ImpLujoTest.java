package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.ImpLujo;
import modelo.Jugador;

public class ImpLujoTest {

	@Test
	public void test01DineroDelJugadorSeDecrementaEnUn10PorCientoSiCaeEnImpuestoDeLujo() {
		Jugador jugador=new Jugador("Pepa",100000);
		ImpLujo impuestoDeLujo=new ImpLujo();
		
		impuestoDeLujo.ocupar(jugador);
		
		Assert.assertEquals(jugador.getDinero(), 90000);	
	}
}
