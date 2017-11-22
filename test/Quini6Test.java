package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Dados;
import modelo.Jugador;
import modelo.Quini6;

public class Quini6Test {

	@Test
	public void test01JugadorCaePorPrimeraVezEnQuini6AumentaSuDineroEn50Mil() {
		Dados dados=new Dados();
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador,dados);
		
		assertEquals(50000,jugador.getDinero());
	}
	
	@Test
	public void test02JugadorCaePorSegundaVezEnQuini6AumentaSuDineroEn30Mil() {
		Dados dados=new Dados();
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador,dados);
		quini6.ocupar(jugador,dados);
		
		assertEquals(80000,jugador.getDinero());
	}
	
	@Test
	public void test03JugadorCaePorTerceraVezEnQuini6NoAumentaSuDinero() {
		Dados dados=new Dados();
		Jugador jugador = new Jugador("Test", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador,dados);
		quini6.ocupar(jugador,dados);
		quini6.ocupar(jugador,dados);
		
		assertEquals(80000,jugador.getDinero());
	}
	
	@Test
	public void test04JugadorGaneTresVecesElQuiniYOtroJugadorUnaVez() {
		Dados dados=new Dados();
		Jugador jugador1 = new Jugador("1", 0);
		Jugador jugador2 = new Jugador("2", 0);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador1,dados);
		quini6.ocupar(jugador1,dados);
		quini6.ocupar(jugador2,dados);
		quini6.ocupar(jugador1,dados);
		
		assertEquals(80000,jugador1.getDinero());
		assertEquals(50000,jugador2.getDinero());
	}

	@Test
	public void test05TresJugadoresGananElQuini6() {
		Dados dados=new Dados();
		Jugador jugador1 = new Jugador("1", 0);
		Jugador jugador2 = new Jugador("2", 1000);
		Jugador jugador3 = new Jugador("3", 50000);
		Quini6 quini6 = new Quini6();
		
		quini6.ocupar(jugador1,dados);
		quini6.ocupar(jugador3,dados);
		quini6.ocupar(jugador2,dados);
		
		assertEquals(50000,jugador1.getDinero());
		assertEquals(51000,jugador2.getDinero());
		assertEquals(100000,jugador3.getDinero());
	}
}
