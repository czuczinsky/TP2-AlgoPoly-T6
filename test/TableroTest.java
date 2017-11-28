package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Dados;
import modelo.Grupo;
import modelo.ImpuestoAlLujo;
import modelo.Jugador;
import modelo.Quini6;
import modelo.Salida;
import modelo.Tablero;
import modelo.Terreno;

public class TableroTest {

	@Test
	public void test01AvanzarJugador() {
		Dados dados=new Dados();
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("Jugador", 0);
		jugador.moverA(salida,dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.avanzar(jugador,1,dados);
		
		assertEquals(quini6, jugador.getPosicion());
	}
	
	@Test
	public void test02AvanzarJugadorCuandoLlegoAlFinalDelTablero() {
		Dados dados=new Dados();
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("Jugador", 0);
		jugador.moverA(quini6,dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.avanzar(jugador,1,dados);
		
		assertEquals(salida, jugador.getPosicion());
	}
	
	@Test
	public void test03RetrocederJugador() {
		Dados dados=new Dados();
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("Jugador", 0);
		jugador.moverA(quini6,dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.retroceder(jugador,1,dados);
		
		assertEquals(salida, jugador.getPosicion());
	}
	
	@Test
	public void test04RetrocederJugadorCuandoLlegoAlFinalDelTablero() {
		Dados dados=new Dados();
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("Jugador", 0);
		jugador.moverA(salida,dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.retroceder(jugador,1,dados);
		
		assertEquals(quini6, jugador.getPosicion());
	}

	@Test
	public void test05JugadorConDineroPuedePagarElAlquilerDeberiaPoderMover() {
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		Jugador jugador2 = new Jugador("Jugador2", 100000);
		jugador1.moverA(salida, dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.agregarCasillero(terreno1);
		terreno1.venderA(jugador2);
		
		assertTrue(tablero.puedeMover(jugador1,dados));
	}
	
	@Test
	public void test06JugadorSinDineroNoPuedePagarElAlquilerNoDeberiaPoderMover() {
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador("Jugador1", 0);
		Jugador jugador2 = new Jugador("Jugador2", 100000);
		jugador1.moverA(salida, dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.agregarCasillero(terreno1);
		terreno1.venderA(jugador2);
		
		assertFalse(tablero.puedeMover(jugador1,dados));
	}
	
	@Test
	public void test07JugadorDuenioSinDineroDeberiaPoderMover() {
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador("Jugador1", 20000);
		jugador1.moverA(salida, dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.agregarCasillero(terreno1);
		terreno1.venderA(jugador1);
		
		assertTrue(tablero.puedeMover(jugador1,dados));
	}
	
	@Test
	public void test08JugadorCaeEnCasilleroSinAlquilerDeberiaPoderMover() {
		Dados dados = new Dados();
		dados.setNumeros(1, 1);
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		ImpuestoAlLujo impAlLujo = new ImpuestoAlLujo();
		Tablero tablero = new Tablero();
		Jugador jugador1 = new Jugador("Jugador1", 0);
		jugador1.moverA(salida, dados);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.agregarCasillero(impAlLujo);
		
		assertTrue(tablero.puedeMover(jugador1,dados));
	}
}
