package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.Jugador;
import modelo.Turno;

public class TurnoTest {

	ArrayList<Jugador> jugadores;
	private Jugador jugadorRojo;
	private Jugador jugadorVerde;
	private Jugador jugadorAzul;
	private Turno turno;

	@Before
	public void setUp() throws Exception {
		this.jugadores = new ArrayList<Jugador>();
		this.jugadorRojo = new Jugador("Rojo", 100000);
		this.jugadorVerde = new Jugador("Verde", 100000);
		this.jugadorAzul = new Jugador("Azul", 100000);
		this.jugadores.add(jugadorRojo);
		this.jugadores.add(jugadorVerde);
		this.jugadores.add(jugadorAzul);
		this.turno = new Turno(jugadores);
	}

	@Test
	public void test01PosicionInicial() {
		assertEquals(jugadorRojo, turno.getActual());
	}

	@Test
	public void test02Avanzar1Vez() {
		turno.avanzar();
		assertEquals(jugadorVerde, turno.getActual());
	}

	@Test
	public void test03Avanzar2Veces() {
		turno.avanzar();
		turno.avanzar();
		assertEquals(jugadorAzul, turno.getActual());
	}

	@Test
	public void test04Avanzar3Veces() {
		turno.avanzar();
		turno.avanzar();
		turno.avanzar();
		assertEquals(jugadorRojo, turno.getActual());
	}

	@Test
	public void test05Avanzar4Veces() {
		turno.avanzar();
		turno.avanzar();
		turno.avanzar();
		turno.avanzar();
		assertEquals(jugadorVerde, turno.getActual());
	}

}
