package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dados;
import modelo.ImpuestoAlLujo;
import modelo.Jugador;

public class ImpuestoDeLujoTest {

	@Test
	public void test01DineroDelJugadorSeDecrementaEnUn10PorCientoSiCaeEnImpuestoDeLujo() {
		Dados dados=new Dados();
		Jugador jugador=new Jugador("Pepa",100000);
		ImpuestoAlLujo impuestoDeLujo=new ImpuestoAlLujo();
		
		impuestoDeLujo.ocupar(jugador,dados);
		
		Assert.assertEquals(jugador.getDinero(), 90000);	
	}
}
