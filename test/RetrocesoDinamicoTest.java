package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AvanceDinamico;
import modelo.Dados;
import modelo.Jugador;
import modelo.RetrocesoDinamico;
import modelo.Tablero;

public class RetrocesoDinamicoTest {

	@Test
	public void test01JugadorCaeEnRetrocesoDinamicoSacando12EnLosDadosAvanza10() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico(tablero);
		jugador.moverA(retrocesoDinamico);
		dados.setNumeros(7,5);
		retrocesoDinamico.ocupar(jugador);
		
		assertEquals(retrocesoDinamico, jugador.getPosicion());
	}

}
