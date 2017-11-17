package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dados;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;

public class ImpuestoDeLujoTest {

	@Test
	public void test01DineroDelJugadorSeDecrementaEnUn10PorCientoSiCaeEnImpuestoDeLujo() {
		Dados dados=new Dados();
		Jugador jugador=new Jugador("Pepa",100000);
		ImpuestoDeLujo impuestoDeLujo=new ImpuestoDeLujo();
		
		impuestoDeLujo.ocupar(jugador,dados);
		
		Assert.assertEquals(jugador.getDinero(), 90000);	
	}
}
