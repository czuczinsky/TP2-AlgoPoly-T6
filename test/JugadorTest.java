package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.Dados;
import modelo.Grupo;
import modelo.Jugador;
import modelo.Salida;
import modelo.SinDineroException;
import modelo.Terreno;

public class JugadorTest {

	@Test
	public void test00SiUnJugadorCompraUnTerrenoDeberiaSerElNuevoPropietario() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
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
	public void test03SiUnJugadorCompraDosTerrenosYConstruyeDosCasasEnUnoDeberiaTenerCuatroPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Jugador jugador = new Jugador("Test", 100000);
		terreno.venderA(jugador);
		terreno2.venderA(jugador);
		terreno.construirCasa();
		terreno.construirCasa();
		Assert.assertEquals(4 , jugador.cantPropiedades());
	}
	
	@Test (expected = SinDineroException.class)
	public void test04DecrementarMontoAJugadorSinDinero() {
		Jugador jugador = new Jugador("Azul", 0);
		jugador.decrementarDinero(100);
	}
	
	@Test
	public void test05JugadorPuedeMoverse() {
		Salida salida = new Salida();
		Jugador jugador = new Jugador("Azul", 0);
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		jugador.moverA(salida, dados);
		
		assertTrue(jugador.puedoMoverse());
	}
	
	@Test
	public void test05JugadorNoPuedeMoverse() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador("Azul", 0);
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		jugador.moverA(carcel, dados);
		
		assertFalse(jugador.puedoMoverse());
	}
	
	@Test
	public void test06JugadorQuiebraDeberiaDisvincularSusPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
		jugador1.quiebra();
		assertEquals(0, jugador1.cantPropiedades());
	}

}
