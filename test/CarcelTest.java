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
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador,dados);
		
		assertEquals(1,carcel.cantidadDePrisioneros());	
	}
	
	@Test
	public void test03SiUnJugadorCaeEnLaCarcelNoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador,dados);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void test04SiAgregoUnJugadorALaCarcelEnElSegundoTurnoNoPuedeMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));	
	}
	
	@Test
	public void test05SiAgregoUnJugadorALaCarcelEnElTercerTurnoNoPuedeMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test06SiAgregoUnJugadorALaCarcelEnElCuartoTurnoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test07UnJugadorNoDeberiaPoderPagarLaFianzaEnElPrimerTurno() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",10000);
		int dineroInicial=jugador.getDinero();
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial,jugador.getDinero());
	}
	
	@Test
	public void test08JugadorDeberiaPoderPagarLaFianzaEnElSegundoTurno() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		int dineroInicial=jugador.getDinero();
		;
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial-45000,jugador.getDinero());
	}
	
	@Test
	public void test09JugadorDeberiaPoderPagarLaFianzaEnElTercerTurno() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		int dineroInicial=jugador.getDinero();
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(dineroInicial-45000,jugador.getDinero());
	}
	
	@Test
	public void test10SiElJugadorPagaLaFianzaEnElSegundoTurnoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test11SiElJugadorPagaLaFianzaEnElTercerTurnoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100000);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(true,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test12SiElJugadorQuierePagarLaFianzaEnElSegundoTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}
	
	@Test
	public void test13SiElJugadorQuierePagarLaFianzaEnElTercerTurnoPeroNoTieneDineroSuficienteNoDeberiaPoderMoverse() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador=new Jugador("carlos",100);
		
		carcel.ocupar(jugador,dados);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.avanzarTurnoDe(jugador);
		carcel.cobrarFianza(jugador);
		
		assertEquals(false,carcel.puedeMoverse(jugador));
	}

	@Test
	public void test14SiCaeMasDeUnJugadorALaCarcelSaleSolamenteElQueYaPasoTresTurnosAdentroDeLaCarcel() {
		Dados dados=new Dados();
		Carcel carcel=new Carcel();
		Jugador jugador1=new Jugador("carlos",100);
		Jugador jugador2=new Jugador("pedro",100);
		
		carcel.ocupar(jugador1,dados);
		carcel.ocupar(jugador2,dados);
		
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
