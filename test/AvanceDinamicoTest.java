package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AvanceDinamico;
import modelo.Dados;

import modelo.Jugador;
import modelo.Tablero;

public class AvanceDinamicoTest {

	@Test
	public void test01JugadorCaeEnAvanceDinamicoSacando2EnLosDadosNoAvanza() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		AvanceDinamico avanceDinamico = new AvanceDinamico(tablero);
		jugador.moverA(avanceDinamico);
		dados.setNumeros(1,1);
		avanceDinamico.ocupar(jugador);
		
		assertEquals(avanceDinamico, jugador.getPosicion());
	}
	
	
}
