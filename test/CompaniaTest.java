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

		Dados dados = new Dados();
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

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		compania.comprar(propietario);
		compania.ocupar(jugador1, dados);
		// Assert.assertEquals(200000 - 35000 + (3 + 4) * 500, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 500, jugador1.getDinero());
	}

	@Test
	public void test03SiUnJugadorCaeEnCompaniaEdesurConDuenioYAdemasTambienEsDuenioDeAysaDeberiaDescontar1000VecesMasLoQueDicenLosDadosDeSuDinero() {
		Jugador propietario = new Jugador("Jugador x", 200000);
		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);
		Compania compania2 = new Compania("AYSA", 30000, grupo, 300, 500);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania2.comprar(propietario);
		compania1.ocupar(jugador1, dados);
		// Assert.assertEquals(200000 - 35000 - 30000 + (3 + 4) * 1000,
		// propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 1000, jugador1.getDinero());
	}

	@Test
	public void test04SiUnJugadorCaeEnCompaniaEdesurYEsElPropietarioNoSeLeDeberiaDescontarNada() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania1.ocupar(propietario, dados);

		Assert.assertEquals(200000 - 35000, propietario.getDinero());
	}

	@Test
	public void test05SiUnJugadorCompraEdesurYAysaYLuegoCaeEnEseCasilleroNoSeLeDeberianCobrarExtras() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Grupo grupo = new Grupo();
		Compania compania1 = new Compania("EDESUR", 35000, grupo, 500, 1000);
		Compania compania2 = new Compania("AYSA", 30000, grupo, 300, 500);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		compania1.comprar(propietario);
		compania2.comprar(propietario);
		compania1.ocupar(propietario, dados);

		Assert.assertEquals(200000 - 35000 - 30000, propietario.getDinero());
	}

	// 2da Entrega 11

	@Test
	public void test06JugadorCaeEnTrenPropiedadDeOtroJugadorNoDuenioDeSuteDeberiaDescontar450porDados() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Jugador ocupante = new Jugador("Jugador 1", 100000);
		Grupo subteTren = new Grupo();
		Compania tren = new Compania("TREN", 38000, subteTren, 450, 800);
//		Compania subte = new Compania("SUBTE", 40000, subteTren, 600, 1100);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		tren.comprar(propietario);
		tren.ocupar(ocupante, dados);

		Assert.assertEquals(200000 - 38000 + (3 + 4) * 450, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 450, ocupante.getDinero());
	}

	// 2da Entrega 12

	@Test
	public void test07JugadorCaeEnTrenPropiedadDeOtroJugadorTambienDuenioDeSuteDeberiaDescontar800porDados() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Jugador ocupante = new Jugador("Jugador 1", 100000);
		Grupo subteTren = new Grupo();
		Compania tren = new Compania("TREN", 38000, subteTren, 450, 800);
		Compania subte = new Compania("SUBTE", 40000, subteTren, 600, 1100);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		tren.comprar(propietario);
		subte.comprar(propietario);
		tren.ocupar(ocupante, dados);

		Assert.assertEquals(200000 - 38000 - 40000 + (3 + 4) * 800, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 800, ocupante.getDinero());
	}

	// 2da Entrega 16

	@Test
	public void test08JugadorCaeEnEdesurPropiedadDeOtroJugadorNoDuenioDeAysaDeberiaDescontar500porDados() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Jugador ocupante = new Jugador("Jugador 1", 100000);
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
//		Compania aysa = new Compania("AYSA", 30000, edesurAysa, 300, 500);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		edesur.comprar(propietario);
		edesur.ocupar(ocupante, dados);

		Assert.assertEquals(200000 - 35000 + (3 + 4) * 500, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 500, ocupante.getDinero());
	}

	// 2da Entrega 17

	@Test
	public void test09JugadorCaeEnEdesurPropiedadDeOtroJugadorTambienDuenioDeAysaDeberiaDescontar1000porDados() {
		Jugador propietario = new Jugador("Jugador 1", 200000);
		Jugador ocupante = new Jugador("Jugador 1", 100000);
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Compania aysa = new Compania("AYSA", 30000, edesurAysa, 300, 500);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		edesur.comprar(propietario);
		aysa.comprar(propietario);
		edesur.ocupar(ocupante, dados);

		Assert.assertEquals(200000 - 35000 - 30000 + (3 + 4) * 1000, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 1000, ocupante.getDinero());
	}
}
