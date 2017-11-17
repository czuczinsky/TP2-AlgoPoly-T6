package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Prisionero;

public class PrisioneroTest {
	
	@Test
	public void testCumplioLaCondenaDeberiaDarFalseSiPasoSoloUnTurno() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		
		assertEquals(false,prisionero.cumplioLaCondena());
	}
	
	@Test
	public void testCumplioLaCondenaDeberiaDarFalseSiPasaronTresTurnos() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
		assertEquals(false,prisionero.cumplioLaCondena());
	}
	
	@Test
	public void testCumplioLaCondenaDeberiaDarTrueSiPasaronMasDeTresTurnos() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
		assertEquals(true,prisionero.cumplioLaCondena());
	}
	
	@Test
	public void testpuedePagarFianzaDeberiaDarFalseSiPasoUnTurno() {
		Jugador jugador=new Jugador("carlos",100000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		
		assertEquals(false,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testpuedePagarFianzaDeberiaDarTrueSiPasoMasDeUnTurno() {
		Jugador jugador=new Jugador("carlos",100000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
		assertEquals(true,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testpuedePagarFianzaDeberiaDarFalseSiSeLePasaUnMontoMayorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",1000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
		assertEquals(false,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testPuedePagarFianzaDeberiaDarTrueSiSeLePasaUnMontoIgualAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",45000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
		assertEquals(true,prisionero.puedePagarFianza(45000));
	}
	
	@Test
	public void testTieneSuficienteDineroDeberiaDarTrueSiSeLePasaUnMontoMenorAlQueTieneElJugador() {
		Jugador jugador=new Jugador("carlos",100000);
		Prisionero prisionero=new Prisionero(jugador);
		
		prisionero.incrementarTurno();
		prisionero.incrementarTurno();
		
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
