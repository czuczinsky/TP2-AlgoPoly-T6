package test;

import org.junit.Assert;
import org.junit.Test;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.Jugador;

public class CompaniaTest {

	@Test
	public void test01SiJugadorCaeEnCasilleroQuePerteceACompaniaEdesurYLaCompraSuDineroDeberiaDecrementarse3500() {
		Jugador propietario = new Jugador("Jugador x", 200000);
		Grupo grupo = new Grupo();
		Compania compania = new Compania("EDESUR", 35000, grupo, 500, 1000);

		Dados dados = Dados.getDados();
		dados.setNumeros(3, 4);

		compania.comprar(propietario);
		Assert.assertEquals(200000 - 35000, propietario.getDinero());
	}

	@Test
	public void test02OSiUnJugadorCaeEnCompaniaEdesurQueTieneDuenioSeLeDeberiaDescontar500VecesMasLoQueDicenLosDadosDeSuDinero() {
		Jugador propietario = new Jugador("Jugador x", 200000);
		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Grupo grupo = new Grupo();
		Compania compania = new Compania("EDESUR", 35000, grupo, 500, 1000);

		Dados dados = Dados.getDados();
		dados.setNumeros(3, 4);

		compania.comprar(propietario);
		compania.ocupar(jugador1);
		//Assert.assertEquals(200000 - 35000 + (3 + 4) * 500, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 500, jugador1.getDinero());
	}

	@Test
	public void test03SiUnJugadorCaeEnCompaniaEdesurConDuenioYAdemasTambienEsDuenioDeAysaDeberiaDescontar1000VecesMasLoQueDicenLosDadosDeSuDinero() {
		Jugador propietario = new Jugador("Jugador x", 200000);
		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);
		Compania compania2 = new Compania("AYSA", 30000, grupo, 300, 500);

		Dados dados = Dados.getDados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania2.comprar(propietario);
		compania1.ocupar(jugador1);
		//Assert.assertEquals(200000 - 35000 - 30000 + (3 + 4) * 1000, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 1000, jugador1.getDinero());
	}
	
	@Test
	public void test04SiUnJugadorCaeEnCompaniaEdesurYEsElPropietarioNoSeLeDeberiaDescontarNada() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);

		Dados dados = Dados.getDados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania1.ocupar(propietario);
		
		Assert.assertEquals(200000-35000, propietario.getDinero());
	}
	
	@Test
	public void test05SiUnJugadorCompraEdesurYAysaYLuegoCaeEnEseCasilleroNoSeLeDeberianCobrarExtras() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);
		Compania compania2 = new Compania("AYSA", 30000, grupo, 300, 500);

		Dados dados = Dados.getDados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania2.comprar(propietario);
		compania1.ocupar(propietario);
		
		Assert.assertEquals(200000-35000-30000, propietario.getDinero());
	}
}
