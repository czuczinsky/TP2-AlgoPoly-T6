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
	public void test02GanadorSeLePagaPorPrimeraVez() {
		this.ganador.pagar();
		
		assertEquals(50000, this.jugador.getDinero());
	}
	
	@Test
	public void test03GanadorSeLePagaPorSegundaVez() {
		this.ganador.pagar();
		this.ganador.pagar();
		
		assertEquals(80000,this.jugador.getDinero());
	}
	
	@Test
	public void test04GanadorSeLePagaPorTerceraVez() {
		this.ganador.pagar();
		this.ganador.pagar();
		this.ganador.pagar();
		
		assertEquals(80000, this.jugador.getDinero());
	}
}
