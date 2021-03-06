package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.Dados;
import modelo.Jugador;
import modelo.Turno;

public class TurnoTest {

	private ArrayList<Jugador> jugadores;
	private Jugador jugadorRojo;
	private Jugador jugadorVerde;
	private Jugador jugadorAzul;
	private Turno turno;
	private Dados dados;

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
		this.dados = new Dados();
	}

	@Test
	public void test01TurnoDelPrimerJugador() {
		assertEquals(jugadorRojo, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test02TurnoDelSegundoJugador() {
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		assertEquals(jugadorVerde, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test03TurnoDelTercerJugador() {
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		assertEquals(jugadorAzul, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test04VuelveElTurnoAlPrimerJugador() {
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		turno.siguienteJugador(this.dados);
		dados.setNumeros(2, 3);
		assertEquals(jugadorRojo, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test05JugadorVuelveAJugarPorSacarDobles() {
		turno.siguienteJugador(dados);
		dados.setNumeros(2, 2);
		assertEquals(jugadorRojo, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test06JugadorSacaDosVecesDoblesNoVuelveAJugar() {
		turno.siguienteJugador(dados);
		dados.setNumeros(2, 2);
		turno.siguienteJugador(dados);
		dados.setNumeros(6, 6);
		assertEquals(jugadorVerde, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test07DosJugadoresConsecutivosSacanDobles() {
		turno.siguienteJugador(dados);
		dados.setNumeros(2, 2);
		turno.siguienteJugador(dados);
		dados.setNumeros(6, 6);
		turno.siguienteJugador(dados);
		dados.setNumeros(5, 5);
		assertEquals(jugadorVerde, turno.siguienteJugador(this.dados));
	}

	@Test
	public void test08JugadorActual() {
		assertEquals(jugadorRojo, turno.siguienteJugador(this.dados));
		assertEquals(jugadorRojo, turno.getJugadorActual());
	}

	@Test
	public void test09BorrarJugadorRojo() {
		dados.setNumeros(1, 2);
		assertEquals(jugadorRojo, turno.siguienteJugador(dados));
		turno.borrar();
		assertEquals(2, jugadores.size());
	}

	@Test
	public void test10BorrarJugadorVerde() {
		dados.setNumeros(1, 2);
		turno.siguienteJugador(dados);
		assertEquals(jugadorVerde, turno.siguienteJugador(dados));
		turno.borrar();
		assertEquals(2, jugadores.size());
	}

	@Test
	public void test11BorrarJugadorAzul() {
		dados.setNumeros(1, 3);
		turno.siguienteJugador(dados);
		turno.siguienteJugador(dados);
		assertEquals(jugadorAzul, turno.siguienteJugador(dados));
		turno.borrar();
		assertEquals(2, jugadores.size());
	}

	@Test
	public void test12BorrarJugadorQueSacoDobles() {
		dados.setNumeros(2, 2);
		assertEquals(jugadorRojo, turno.siguienteJugador(dados));
		turno.borrar();
		assertEquals(jugadorVerde, turno.siguienteJugador(dados));
	}
}