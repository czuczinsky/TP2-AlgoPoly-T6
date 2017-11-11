package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Quini6;
import modelo.Salida;
import modelo.Tablero;

public class TableroTest {

	@Test
	public void test01AvanzarJugador() {
		Salida salida = new Salida();
		Quini6 quini6 = new Quini6();
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("Jugador", 0);
		jugador.moverA(salida);
		
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quini6);
		tablero.avanzar(jugador);
		
		assertEquals(quini6, jugador.getPosicion());
	}

}
