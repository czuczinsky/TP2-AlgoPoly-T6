package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Prisionero;

public class PrisioneroTest {

	@Test
	public void testSiAgregoUnJugadorComoPrisioneroDeberiaTenerComoTurnoUnUno() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(1,prisionero.getTurno());
	}
	
	@Test
	public void testTieneSuficienteDineroDeberiaDarFalseSiSeLePasaUnMontoMayorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(false,prisionero.tieneSuficienteDinero(45000));
	}
	
	@Test
	public void testTieneSuficienteDineroDeberiaDarTrueSiSeLePasaUnMontoIgualAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",45000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(true,prisionero.tieneSuficienteDinero(45000));
	}
	
	@Test
	public void testTieneSuficienteDineroDeberiaDarTrueSiSeLePasaUnMontoMenorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",100000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(true,prisionero.tieneSuficienteDinero(45000));
	}
	
	@Test
	public void testEsIgualADeberiaDevolverTrueSiSeLePasaUnJugadorIgualAlQueTieneElPrisionero() {
		Jugador jugador=new Jugador("carlos",45000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(true,prisionero.esIgualA(jugador));
	}
	
	@Test
	public void testEsIgualADeberiaDevolverFalseSiSeLePasaUnJugadorDistintoAlQueTieneElPrisionero() {
		Jugador jugador1=new Jugador("carlos",45000);
		Jugador jugador2=new Jugador("carlos",45000);
		Prisionero prisionero=new Prisionero(jugador1);
		
		assertEquals(false,prisionero.esIgualA(jugador2));
	}


}
