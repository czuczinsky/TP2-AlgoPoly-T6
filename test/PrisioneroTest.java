package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Prisionero;

public class PrisioneroTest {
	
	@Test
	public void testpuedePagarFianzaDeberiaDarFalseSiSeLePasaUnMontoMayorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		assertEquals(false,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testPuedePagarFianzaDeberiaDarTrueSiSeLePasaUnMontoIgualAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",45000);
		Prisionero prisionero=new Prisionero(jugador);
		prisionero.cumplioLaCondena();
		
		assertEquals(true,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testTieneSuficienteDineroDeberiaDarTrueSiSeLePasaUnMontoMenorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",100000);
		Prisionero prisionero=new Prisionero(jugador);
		prisionero.cumplioLaCondena();
		
		assertEquals(true,prisionero.puedePagarFianza(45000));
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
