package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Grupo;
import modelo.Jugador;
import modelo.Terreno;

public class JugadorTest {

	@Test
	public void test00SiUnJugadorCompraUnTerrenoDeberiaSerElNuevoPropietario() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		Assert.assertEquals(jugador1 , terreno1.getPropietario());
	}
	
	@Test
	public void test01DecrementarDinero() {
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		jugador1.decrementarDinero(5000);
		assertEquals(95000 , jugador1.getDinero());
		}
	
	@Test
	public void test02IncrementarDinero() {
		Jugador jugador = new Jugador("Test",0);
		jugador.incrementarDinero(1000);
		assertEquals(1000,jugador.getDinero());
	}

	@Test
	public void test03SiUnJugadorCompraUnTerrenoYLeConstruyeDosCasasDeberiaTenerTresPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Jugador jugador = new Jugador("Test", 100000);
		terreno.comprar(jugador);
		terreno.construirCasa();
		terreno.construirCasa();
		Assert.assertEquals(3 , jugador.cantPropiedades());
	}
	

}
