package test;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;

public class CarcelTest {

	@Test
	public void testAlCrearLaCarcelNoDeberiaTenerNingunPrisionero() {
		
		Carcel carcel=new Carcel();
		
		assertEquals(0,carcel.cantidadDePrisioneros());
	}
	
	@Test
	public void testSiAgregoUnJugadorALaCarcelDeberiaTenerUnPrisionero() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		
		assertEquals(1,carcel.cantidadDePrisioneros());	
	}
	
	@Test
	public void testSiUnJugadorCaeEnLaCarcelNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void testSiAgregoUnJugadorALaCarcelEnElSegundoTurnoNoPuedeMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void testSiAgregoUnJugadorALaCarcelEnElTercerTurnoNoPuedeMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void testSiAgregoUnJugadorALaCarcelEnElCuartoTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void testUnJugadorNoDeberiaPoderPagarLaFianzaEnElPrimerTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		int dineroInicial=jugador.getDinero();
		carcel.cobrarFianza(jugador);
		int dineroFinal=jugador.getDinero();
		
		assertEquals(dineroInicial,dineroFinal);
	}
	
	@Test
	public void testJugadorDeberiaPoderPagarLaFianzaEnElSegundoTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		int dineroInicial=jugador.getDinero();
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		int dineroFinal=jugador.getDinero();
		
		assertEquals(dineroInicial-45000,dineroFinal);
	}
	
	@Test
	public void testJugadorDeberiaPoderPagarLaFianzaEnElTercerTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		int dineroInicial=jugador.getDinero();
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		int dineroFinal=jugador.getDinero();
		
		assertEquals(dineroInicial-45000,dineroFinal);
	}
	
	@Test
	public void testSiElJugadorPagaLaFianzaEnElSegundoTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void testSiElJugadorPagaLaFianzaEnElTercerTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void testSiElJugadorQuierePagarLaFianzaEnElSegundoTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void testSiElJugadorQuierePagarLaFianzaEnElTercerTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador);
		carcel.puedeMoverse(jugador);
		carcel.puedeMoverse(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}

	@Test
	public void testSiCaeMasDeUnJugadorALaCarcelSaleSolamenteElQueYaPasoTresTurnosAdentroDeLaCarcel() {
		
		Carcel carcel=new Carcel();
		Jugador jugador1=new Jugador("carlos",100);
		Jugador jugador2=new Jugador("pedro",100);
		
		carcel.ocupar(jugador1);
		carcel.puedeMoverse(jugador1);
		carcel.puedeMoverse(jugador1);
		carcel.ocupar(jugador2);
		carcel.puedeMoverse(jugador2);	
		carcel.puedeMoverse(jugador1);
		
		assertEquals(true,carcel.puedeMoverse(jugador1));
		assertEquals(false,carcel.puedeMoverse(jugador2));
		
	}
}
