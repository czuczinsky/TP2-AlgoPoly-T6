package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Ganador;
import modelo.Jugador;

public class GanadorTest {

	private Jugador jugador;
	private Ganador ganador;

	@Before
	public void setUp() throws Exception {
		jugador = new Jugador("Jugador", 0);
		ganador = new Ganador(jugador);
	}
	
	@Test
	public void test01JugadorEsGanador() {
		assertTrue(this.ganador.esIgualA(this.jugador));
	}

	@Test
	public void test02GanadorIncrementaUnaVictorias() {
		ganador.incrementarVictorias();
		assertTrue(this.ganador.vecesQueGano(1));
	}
	
	@Test
	public void test03GanadorIncrementaCincoVictorias() {
		for (int i=1; i<=5 ; i++) {
			ganador.incrementarVictorias();
		}
		assertTrue(this.ganador.vecesQueGano(5));
	}
}
