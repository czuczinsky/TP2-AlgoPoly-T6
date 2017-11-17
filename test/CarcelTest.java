package test;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;

public class CarcelTest {

	@Test
	public void test01AlCrearLaCarcelNoDeberiaTenerNingunPrisionero() {
		
		Carcel carcel=new Carcel();
		
		assertEquals(0,carcel.cantidadDePrisioneros());
	}
	
	@Test
	public void test02SiAgregoUnJugadorALaCarcelDeberiaTenerUnPrisionero() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		
		assertEquals(1,carcel.cantidadDePrisioneros());	
	}
	
	@Test
	public void test03SiUnJugadorCaeEnLaCarcelNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void test04SiAgregoUnJugadorALaCarcelEnElSegundoTurnoNoPuedeMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void test05SiAgregoUnJugadorALaCarcelEnElTercerTurnoNoPuedeMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test06SiAgregoUnJugadorALaCarcelEnElCuartoTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test07UnJugadorNoDeberiaPoderPagarLaFianzaEnElPrimerTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		int dineroInicial=jugador.getDinero();
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial,jugador.getDinero());
	}
	
	@Test
	public void test08JugadorDeberiaPoderPagarLaFianzaEnElSegundoTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		int dineroInicial=jugador.getDinero();
		;
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial-45000,jugador.getDinero());
	}
	
	@Test
	public void test09JugadorDeberiaPoderPagarLaFianzaEnElTercerTurno() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		int dineroInicial=jugador.getDinero();
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial-45000,jugador.getDinero());
	}
	
	@Test
	public void test10SiElJugadorPagaLaFianzaEnElSegundoTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test11SiElJugadorPagaLaFianzaEnElTercerTurnoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test12SiElJugadorQuierePagarLaFianzaEnElSegundoTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test13SiElJugadorQuierePagarLaFianzaEnElTercerTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}

	@Test
	public void test14SiCaeMasDeUnJugadorALaCarcelSaleSolamenteElQueYaPasoTresTurnosAdentroDeLaCarcel() {
		
		Carcel carcel=new Carcel();
		Jugador jugador1=new Jugador("carlos",100);
		Jugador jugador2=new Jugador("pedro",100);
		
		carcel.ocupar(jugador1);
		carcel.ocupar(jugador2);
		
		carcel.avanzarTurnoDe(jugador1);
		carcel.avanzarTurnoDe(jugador2);
		carcel.avanzarTurnoDe(jugador1);
		carcel.avanzarTurnoDe(jugador1);
		carcel.avanzarTurnoDe(jugador1);
		carcel.avanzarTurnoDe(jugador1);
		
		
		assertEquals(true,carcel.puedeMoverse(jugador1));
		assertEquals(false,carcel.puedeMoverse(jugador2));
		
	}
}
