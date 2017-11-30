package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.Jugador;
import modelo.PropietarioYaExistenteException;

public class CompaniaTest {

	@Test
	public void test01SiJugadorCaeEnCasilleroQuePerteceACompaniaEdesurYLaCompraSuDineroDeberiaDecrementarse3500() {
		Jugador propietario = new Jugador("Jugador x", 200000);
		Grupo grupo = new Grupo();
		Compania compania = new Compania("EDESUR", 35000, grupo, 500, 1000);

		Dados dados = new Dados();
		dados.setNumeros(3, 4);

		compania.venderA(propietario);
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

		compania.venderA(propietario);
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

		compania1.venderA(propietario);
		compania2.venderA(propietario);
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

		compania1.venderA(propietario);
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

		compania1.venderA(propietario);
		compania2.venderA(propietario);
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

		tren.venderA(propietario);
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

		tren.venderA(propietario);
		subte.venderA(propietario);
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

		edesur.venderA(propietario);
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

		edesur.venderA(propietario);
		aysa.venderA(propietario);
		edesur.ocupar(ocupante, dados);

		Assert.assertEquals(200000 - 35000 - 30000 + (3 + 4) * 1000, propietario.getDinero());
		Assert.assertEquals(100000 - (3 + 4) * 1000, ocupante.getDinero());
	}
	
	@Test
	public void test10Jugador1CuentaConEdesurYLoVendeDeberiaCobrarEl15PorcientoMenosDeTodoLoQueVende() {
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		
		edesur.venderA(jugador1);
		edesur.vender();
		
		Assert.assertEquals(100000 - 35000+ (35000*(100-15)/100), jugador1.getDinero());
	}
	
	@Test
	public void test11Jugador1CuentaConEdesurYLoVendeYLoCompraJugador2SiCaeJugador1EnEdesurSeLeDebeDescontar500PorDadosYSumarEseMontoAlJugador2() {
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		Jugador jugador2 = new Jugador("Jugador2", 100000);
		
		Dados dados = new Dados();
		dados.setNumeros(3, 4);
		
		edesur.venderA(jugador1);
		edesur.vender();
		edesur.venderA(jugador2);
		edesur.ocupar(jugador1, dados);
		
		Assert.assertEquals(100000 - 35000+ (35000*(100-15)/100)-(500*7), jugador1.getDinero());
		Assert.assertEquals(100000 - 35000+ +(500*7), jugador2.getDinero());
	}
	
	@Test
	public void test12ObtenerAlquilerDeCompaniaSinDuenioDeberiaDevolverCero() {
		Dados dados = new Dados();
		dados.setNumeros(2, 2);
		Jugador jugador = new Jugador("Azul", 100000);
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		
		assertEquals(0,edesur.getAlquiler(jugador, dados));
	}
	
	@Test
	public void test13ObtenerAlquilerDeCompaniaEdesurConDuenioDeberiaDevolver500LoQueDicenLosDados() {
		Dados dados = new Dados();
		dados.setNumeros(2, 2);
		Jugador jugador = new Jugador("Azul", 100000);
		Jugador propietario = new Jugador("Jugador 1", 200000);
		
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		
		edesur.venderA(propietario);
		
		assertEquals(500 * 4, edesur.getAlquiler(jugador, dados));
	}
	
	@Test
	public void test14DuenioObtieneAlquilerDeSuCompaniaDeberiaDevolverCero() {
		Dados dados = new Dados();
		dados.setNumeros(2, 2);
		Jugador propietario = new Jugador("Jugador 1", 200000);
		
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		
		edesur.venderA(propietario);
		
		assertEquals(0, edesur.getAlquiler(propietario, dados));
	}
	
	@Test
	public void test15ObtenerAlquilerDeCompaniaEdesurAysaConDuenioDeberiaDevolver1000LoQueDicenLosDados() {
		Dados dados = new Dados();
		dados.setNumeros(2, 2);
		Jugador jugador = new Jugador("Azul", 100000);
		Jugador propietario = new Jugador("Jugador 1", 200000);
		
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Compania aysa = new Compania("AYSA", 30000, edesurAysa, 300, 500);
		
		edesur.venderA(propietario);
		aysa.venderA(propietario);
		
		assertEquals(1000 * 4, edesur.getAlquiler(jugador, dados));
	}
	
	@Test (expected = PropietarioYaExistenteException.class)
	public void test63SiUnJugadorQuiereComprarUnTerrenoQueYaTienePropietarioDeberiaDarPropietarioYaExistenteException() {
		Dados dados = new Dados();
		Jugador jugador1 = new Jugador("Azul", 100000);
		Jugador jugador2 = new Jugador("Rojo", 100000);
		Grupo edesurAysa = new Grupo();
		Compania edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		
		edesur.venderA(jugador1);
		edesur.venderA(jugador2);
	}
}
