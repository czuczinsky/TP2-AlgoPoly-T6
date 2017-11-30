package test;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.*;

public class DadosTest {

	@Test
	public void test01Tirar() {
		Dados dados=new Dados();
		for (int i = 0; i < 1000; i++) {
			dados.tirar();
			assertTrue(dados.getDado1() >= 1);
			assertTrue(dados.getDado2() >= 1);
			assertTrue(dados.getSuma() >= 2);
			assertTrue(dados.getDado1() <= 6);
			assertTrue(dados.getDado2() <= 6);
			assertTrue(dados.getSuma() <= 12);
		}
	}
}
