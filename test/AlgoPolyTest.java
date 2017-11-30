package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modelo.Agrupable;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Dados;
import modelo.Jugador;

public class AlgoPolyTest {

	@Test
	public void test01TirarLosDados() {
		AlgoPoly algoPoly = new AlgoPoly();
		algoPoly.tirarDados();
		Dados dados = algoPoly.getDados();
		assertTrue(dados.getDado1() >= 1);
		assertTrue(dados.getDado2() >= 1);
		assertTrue(dados.getSuma() >= 2);
		assertTrue(dados.getDado1() <= 6);
		assertTrue(dados.getDado2() <= 6);
		assertTrue(dados.getSuma() <= 12);
	}
	
	@Test
	public void test02MoverJugadorQueNoSeEncuentraEnLaCarcel() {
		AlgoPoly algoPoly = new AlgoPoly();
		Jugador jugador = algoPoly.getJugadorActual();
		algoPoly.getDados().setNumeros(2, 2);
		algoPoly.mover();
		Casillero bsasZonaNorte = algoPoly.getTablero().getCasilleros().get(4);
		assertEquals(bsasZonaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test03MoverJugadorQueSeEncuentraEnLaCarcel() {
		AlgoPoly algoPoly = new AlgoPoly();
		Jugador jugador = algoPoly.getJugadorActual();
		Casillero carcel = algoPoly.getTablero().getCasilleros().get(5);
		Dados dados = algoPoly.getDados();
		algoPoly.getTablero().avanzar(jugador, 5, dados);
		dados.setNumeros(4, 5);
		algoPoly.mover();
		assertEquals(carcel, jugador.getPosicion());
	}
	
	@Test
	public void test04JugadorSinPropiedadesPierdeDeberiaSerEliminadoDelJuego() {
		AlgoPoly algoPoly = new AlgoPoly();
		Dados dados = algoPoly.getDados();
		ArrayList<Casillero> casilleros = algoPoly.getTablero().getCasilleros();
		ArrayList<Jugador> jugadores = algoPoly.getJugadores();
		Jugador jRojo = jugadores.get(0);
		jRojo.decrementarDinero(100000);
		Jugador jVerde = jugadores.get(1);
		Agrupable bsasNorte = (Agrupable) casilleros.get(4);
		bsasNorte.venderA(jVerde);
		algoPoly.tirarDados();
		dados.setNumeros(1, 3);
		
		assertTrue(algoPoly.vaAPerder());
		algoPoly.quebrarJugador();
		assertEquals(2, algoPoly.getJugadores().size());
	}
	
	
}
