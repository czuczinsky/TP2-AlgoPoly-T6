package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class TerrenoTest {

	@Test
	public void test01SiUnJugadorCompraUnTerrenoSuDineroSeDeberiaDecrementarPorElPrecioDelTerreno() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Assert.assertEquals(100000, jugador1.getDinero());
		terreno1.venderA(jugador1);
		Assert.assertEquals(80000, jugador1.getDinero());
	}

	@Test
	public void test02SiUnJugadorCompraUnTerrenoDeberiaSerElNuevoPropietario() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Assert.assertEquals(100000, jugador1.getDinero());
		terreno1.venderA(jugador1);
		Assert.assertEquals(jugador1, terreno1.getPropietario());
	}

	@Test
	public void test03SiUnJugadorCompraUnTerrenoYConstruyeUnaCasaDeberiaDecrementarSuDineroPorElPrecioDelTerrenoMasLaCasa() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa();
		Assert.assertEquals(100000 - 20000 - 5000, jugador1.getDinero());
	}

	@Test
	public void test04SiUnJugadorConstruyeDosCasasSeDeberiaDecrementarSuDineroPorElPrecioDeLosTerrenoMasLasDosCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		Assert.assertEquals(100000 - 20000 - 20000 - 5000 - 5000, jugador1.getDinero());
	}

	@Test
	public void test05SiCompraAmbasZonasDeUnaProvinciaYConstruyeElMaxDeCasasEnCadaUnaSeDeberiaDescontarElPrecioDeLosTerrenosMasCuatroCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 25000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.venderA(jugador1);
		terrenoSur.venderA(jugador1);
		terrenoNorte.construirCasa(); // primera casa
		terrenoNorte.construirCasa(); // segunda casa
		terrenoSur.construirCasa(); // primera casa
		terrenoSur.construirCasa(); // segunda casa
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500, jugador1.getDinero());
	}

	@Test
	public void test06SiUnJugadorEdificaUnHotelEnUnaProvinciaQueTieneZonaNorteYSurSeLeDeberiaDescontarElPrecioCorrespondiente() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 15000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 10000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.venderA(jugador1);
		terrenoSur.venderA(jugador1);
		terrenoNorte.construirCasa(); // primera casa
		terrenoNorte.construirCasa(); // segunda casa
		terrenoSur.construirCasa(); // primera casa
		terrenoSur.construirCasa(); // segunda casa
		terrenoNorte.construirHotel(); // hotel
		Assert.assertEquals(100000 - 10000 - 15000 - 5000 - 5000 - 5500 - 5500 - 8000, jugador1.getDinero());
	}

	@Test
	public void test07SiUnJugadorQuiereEdificarUnHotelPeroNoLeAlcanzaElDineroNoSeLeDeberiaDescontarElPrecioDelHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 15000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 15000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 51000);
		terrenoNorte.venderA(jugador1);
		terrenoSur.venderA(jugador1);
		terrenoNorte.construirCasa(); // primera casa
		terrenoNorte.construirCasa(); // segunda casa
		terrenoSur.construirCasa(); // primera casa
		terrenoSur.construirCasa(); // segunda casa
		terrenoNorte.construirHotel(); // hotel
		Assert.assertEquals(51000 - 15000 - 15000 - 5000 - 5000 - 5500 - 5500, jugador1.getDinero());
	}

	@Test
	public void test08SiUnJugadorIntentaConstruirUnHotelEnUnaProvinciaQueNoTieneZonaNorteYSurNoSeLeDeberiaDescontarElPrecioDelHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirHotel(); // hotel?
		Assert.assertEquals(100000 - 20000 - 5000, jugador1.getDinero());
	}

	@Test
	public void test09SiUnJugadorCompraDosTerrenosYConstruyeDosCasasEnUnoEsteDeberiaTenerTresPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirCasa(); // segunda casa
		Assert.assertEquals(3, terreno1.cantPropiedades());
	}

	@Test
	public void test10SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYNoEsElSeLeDeberiaDescontarElAlquilerDelTerreno() {
		Dados dados = new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Jugador jugador2 = new Jugador("Jugador 2", 100000);
		terreno1.venderA(jugador1);
		terreno1.ocupar(jugador2, dados);

		Assert.assertEquals(100000 - 2000, jugador2.getDinero());
	}

	@Test
	public void test11SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnaCasaSeLeDeberiaDescontarElAlquilerDeUnaCasa() {
		Dados dados = new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Jugador jugador2 = new Jugador("Jugador 2", 100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.ocupar(jugador2, dados);

		Assert.assertEquals(100000 - 3000, jugador2.getDinero());
	}

	@Test
	public void test12SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYDosCasasSeLeDeberiaDescontarElAlquilerDeDosCasas() {
		Dados dados = new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Jugador jugador2 = new Jugador("Jugador 2", 100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirCasa(); // segunda casa
		terreno1.ocupar(jugador2, dados);

		Assert.assertEquals(100000 - 3500, jugador2.getDinero());
	}

	@Test
	public void test13SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnHotelSeLeDeberiaDescontarElAlquilerDelHotel() {
		Dados dados = new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 200000);
		Jugador jugador2 = new Jugador("Jugador 2", 100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		terreno2.construirCasa();
		terreno2.construirCasa();
		terreno1.construirHotel();
		terreno1.ocupar(jugador2, dados);

		Assert.assertEquals(100000 - 5000, jugador2.getDinero());
	}

	@Test
	public void test14SiUnJugadorCaeEnUnTerrenoMultipleQueTienePropietarioY2CasasSeLeDeberiaDescontarElAlquilerDelas2Casas() {
		Dados dados = new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Jugador jugador2 = new Jugador("Jugador 2", 100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		terreno1.ocupar(jugador2, dados);

		Assert.assertEquals(100000 - 3500, jugador2.getDinero());
	}

	@Test
	public void test15SiUnJugadorCompraBuenosAiresSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		bsAsSur.venderA(jugador1);
		Assert.assertEquals(80000, jugador1.getDinero());
	}

	@Test
	public void test16SiUnJugadorCompraBuenosAiresNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		Assert.assertEquals(100000, jugador1.getDinero());
		bsAsNorte.venderA(jugador1);
		Assert.assertEquals(75000, jugador1.getDinero());
	}

	@Test
	public void test17SiUnJugadorCompraCordobaSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn18Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(82000, jugador1.getDinero());
	}

	@Test
	public void test18SiUnJugadorCompraCordobaNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(80000, jugador1.getDinero());
	}

	@Test
	public void test19SiUnJugadorCompraSantaFeYNoTieneDuenioSuDineroSeDeberiaDecrementarEn15Mil() {
		Grupo staFe = new Grupo();
		Terreno santaFe = new Terreno("Santa Fe", staFe, 15000, 1500, 3500, 0, 0, 4000, 0);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		santaFe.venderA(jugador1);
		Assert.assertEquals(85000, jugador1.getDinero());
	}

	@Test
	public void test20SiUnJugadorCompraSaltaNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaNorte = new Terreno("Salta Norte", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		saltaNorte.venderA(jugador1);
		Assert.assertEquals(77000, jugador1.getDinero());
	}

	@Test
	public void test21SiUnJugadorCompraSaltaSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("Salta Sur", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		saltaSur.venderA(jugador1);
		Assert.assertEquals(77000, jugador1.getDinero());
	}

	@Test
	public void test22SiUnJugadorCompraNeuquenYNoTieneDuenioSuDineroSeDeberiaDecrementarEn17Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen = new Terreno("Neuquen", nquen, 17000, 1800, 3800, 4800, 0, 4800, 0);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(83000, jugador1.getDinero());
	}

	@Test
	public void test23SiUnJugadorCompraTucumanYNoTieneDuenioSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen = new Terreno("Neuquen", nquen, 25000, 2500, 4500, 0, 0, 7000, 0);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(75000, jugador1.getDinero());
	}

	@Test
	public void test24JugadorQueEsPropietarioDeBsAsSurYNorteSiConstruyeUnaCasaEnElSurSuDineroDeberiaDecrementarseEn5000() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		bsAsSur.venderA(jugador1);
		bsAsNorte.venderA(jugador1);
		Assert.assertEquals(55000, jugador1.getDinero());
		bsAsSur.construirCasa();

		Assert.assertEquals(55000 - 5000, jugador1.getDinero());
	}

	@Test
	public void test25JugadorQueEsPropietarioDeBsAsSurYNorteConUnaCasaEnCadaUnaSiContrincanteCaeEnElSurSuDineroSeDecrementaEn3Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados = new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador juan = new Jugador("Juan", 100000);
		bsAsSur.venderA(juan);
		bsAsNorte.venderA(juan);
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Jugador carlos = new Jugador("Carlos", 13000);

		bsAsSur.ocupar(carlos, dados);

		Assert.assertEquals(13000 - 3000, carlos.getDinero());
	}

	@Test
	public void test26JugadorQueEsPropietarioDeBsAsSurYNorteConUnaCasaEnCadaUnaSiContrincanteCaeEnElSurSuDineroSeDecrementaEn3Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados = new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador maria = new Jugador("Maria", 100000);
		bsAsSur.venderA(maria);
		bsAsNorte.venderA(maria);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Jugador laura = new Jugador("Laura", 13000);

		bsAsNorte.ocupar(laura, dados);

		Assert.assertEquals(13000 - 3500, laura.getDinero());
	}

	@Test
	public void test27JugadorQueEsPropietarioDeBsAsSurYNorteYTiene3CasasCuandoConstruyeUnHotelSuDineroNoDeberiaDecrementarse() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador lucas = new Jugador("Lucas", 100000);
		bsAsSur.venderA(lucas);
		bsAsNorte.venderA(lucas);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500, lucas.getDinero());
		bsAsNorte.construirHotel();
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500, lucas.getDinero());

	}

	@Test
	public void test28JugadorQueEsPropietarioDeBsAsSurYNorteYTiene4CasasCuandoConstruyeUnHotelEnElSurSuDineroDeberiaDecrementarse8Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador pablo = new Jugador("Pablo", 100000);
		bsAsSur.venderA(pablo);
		bsAsNorte.venderA(pablo);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500, pablo.getDinero());
		bsAsSur.construirHotel();
		Assert.assertEquals(34000 - 8000, pablo.getDinero());

	}

	@Test
	public void test29JugadorQueEsPropietarioDeBsAsSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn5Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados = new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires, 20000, 2000, 3000, 3500, 5000, 5000, 8000);

		Terreno bsAsNorte = new Terreno("Buenos Aires Norte", buenosAires, 25000, 2500, 3500, 4000, 6000, 5500, 9000);

		Jugador maria = new Jugador("Maria", 100000);
		bsAsSur.venderA(maria);
		bsAsNorte.venderA(maria);

		bsAsSur.construirCasa();
		bsAsSur.construirCasa();

		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500, maria.getDinero());
		bsAsSur.construirHotel();
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500 - 8000, maria.getDinero());
		Jugador laura = new Jugador("Laura", 100000);

		bsAsSur.ocupar(laura, dados);

		Assert.assertEquals(100000 - 5000, laura.getDinero());
	}

	@Test
	public void test30JugadorQueEsPropietarioDeCordobaSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn3Mil() {
		Grupo cordoba = new Grupo();
		Dados dados = new Dados();
		Terreno cordobaSur = new Terreno("Cordoba Sur", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);

		Terreno cordobaNorte = new Terreno("Cordoba Norte", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);

		Jugador lucia = new Jugador("Lucia", 100000);
		cordobaSur.venderA(lucia);
		cordobaNorte.venderA(lucia);

		cordobaSur.construirCasa();
		cordobaSur.construirCasa();

		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();

		cordobaSur.construirHotel();

		Jugador laura = new Jugador("Laura", 100000);

		cordobaSur.ocupar(laura, dados);

		Assert.assertEquals(100000 - 3000, laura.getDinero());
	}

	@Test
	public void test31JugadorQueEsPropietarioDeSaltaSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn5500() {
		Grupo salta = new Grupo();
		Dados dados = new Dados();
		Terreno saltaSur = new Terreno("Salta Sur", salta, 23000, 2000, 3500, 3850, 5500, 4500, 7500);

		Terreno saltaNorte = new Terreno("Salta Norte", salta, 23000, 2000, 3500, 3850, 5500, 4500, 7500);

		Jugador lucia = new Jugador("Lucia", 100000);
		saltaSur.venderA(lucia);
		saltaNorte.venderA(lucia);

		saltaSur.construirCasa();
		saltaSur.construirCasa();

		saltaNorte.construirCasa();
		saltaNorte.construirCasa();

		saltaSur.construirHotel();

		Jugador laura = new Jugador("Laura", 100000);

		saltaSur.ocupar(laura, dados);

		Assert.assertEquals(100000 - 5500, laura.getDinero());
	}

	@Test
	public void test32JugadorQueEsPropietarioDeSantaFeYConstruyeUnaCasaSeLeDeberiaDecrementarSuDineroEn4Mil() {
		Grupo staFe = new Grupo();
		Terreno santaFe = new Terreno("Salta Sur", staFe, 15000, 1500, 3500, 0, 0, 4000, 0);

		Jugador lucia = new Jugador("Lucia", 100000);
		santaFe.venderA(lucia);
		Assert.assertEquals(100000 - 15000, lucia.getDinero());
		santaFe.construirCasa();

		Assert.assertEquals(85000 - 4000, lucia.getDinero());
	}

	// 2da Entrega 10

	@Test
	public void test33JugadorCaeEnBsAsSurConUnaCasaDecrementarSuDineroEn3Mil() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasSur.construirCasa();
		bsasSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 + 3000, propietario.getDinero());
		Assert.assertEquals(100000 - 3000, ocupante.getDinero());
	}

	@Test
	public void test34JugadorCaeEnBsAsSurConDosCasasDecrementarSuDineroEn3500() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasSur.construirCasa();
		bsasSur.construirCasa();
		bsasSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 + 3500, propietario.getDinero());
		Assert.assertEquals(100000 - 3500, ocupante.getDinero());
	}

	@Test
	public void test35JugadorCaeEnBsAsSurConUnHotelDecrementarSuDineroEn5Mil() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasSur.construirCasa();
		bsasSur.construirCasa();
		bsasNorte.construirCasa();
		bsasNorte.construirCasa();
		bsasSur.construirHotel();
		bsasSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500 - 8000 + 5000, propietario.getDinero());
		Assert.assertEquals(100000 - 5000, ocupante.getDinero());
	}

	@Test
	public void test36JugadorCaeEnBsAsNorteConUnaCasaDecrementarSuDineroEn3Mil() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasNorte.construirCasa();
		bsasNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5500 + 3500, propietario.getDinero());
		Assert.assertEquals(100000 - 3500, ocupante.getDinero());
	}

	@Test
	public void test37JugadorCaeEnBsAsNorteConDosCasasDecrementarSuDineroEn4Mil() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasNorte.construirCasa();
		bsasNorte.construirCasa();
		bsasNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5500 - 5500 + 4000, propietario.getDinero());
		Assert.assertEquals(100000 - 4000, ocupante.getDinero());
	}

	@Test
	public void test38JugadorCaeEnBsAsNorteConUnHotelDecrementarSuDineroEn6Mil() {
		Dados dados = new Dados();
		Grupo bsas = new Grupo();
		Terreno bsasSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno bsasNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		bsasSur.venderA(propietario);
		bsasNorte.venderA(propietario);
		bsasSur.construirCasa();
		bsasSur.construirCasa();
		bsasNorte.construirCasa();
		bsasNorte.construirCasa();
		bsasNorte.construirHotel();
		bsasNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500 - 9000 + 6000, propietario.getDinero());
		Assert.assertEquals(100000 - 6000, ocupante.getDinero());
	}

	@Test
	public void test39JugadorCaeEnCordobaSurConUnaCasaDecrementarSuDineroEn1500() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaSur.construirCasa();
		cordobaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2000 + 1500, propietario.getDinero());
		Assert.assertEquals(100000 - 1500, ocupante.getDinero());
	}

	@Test
	public void test40JugadorCaeEnCordobaSurConDosCasasDecrementarSuDineroEn2500() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2000 - 2000 + 2500, propietario.getDinero());
		Assert.assertEquals(100000 - 2500, ocupante.getDinero());
	}

	@Test
	public void test41JugadorCaeEnCordobaSurConUnHotelDecrementarSuDineroEn3Mil() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaSur.construirHotel();
		cordobaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2000 - 2000 - 2200 - 2200 - 3000 + 3000, propietario.getDinero());
		Assert.assertEquals(100000 - 3000, ocupante.getDinero());
	}

	@Test
	public void test42JugadorCaeEnCordobaNorteConUnaCasaDecrementarSuDineroEn1800() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaNorte.construirCasa();
		cordobaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2200 + 1800, propietario.getDinero());
		Assert.assertEquals(100000 - 1800, ocupante.getDinero());
	}

	@Test
	public void test43JugadorCaeEnCordobaNorteConDosCasasDecrementarSuDineroEn2900() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2200 - 2200 + 2900, propietario.getDinero());
		Assert.assertEquals(100000 - 2900, ocupante.getDinero());
	}

	@Test
	public void test44JugadorCaeEnCordobaNorteConUnHotelDecrementarSuDineroEn3500() {
		Dados dados = new Dados();
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Terreno cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		cordobaSur.venderA(propietario);
		cordobaNorte.venderA(propietario);
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
		cordobaNorte.construirHotel();
		cordobaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 18000 - 20000 - 2000 - 2000 - 2200 - 2200 - 3500 + 3500, propietario.getDinero());
		Assert.assertEquals(100000 - 3500, ocupante.getDinero());
	}

	@Test
	public void test45JugadorCaeEnSaltaSurConUnaCasaDecrementarSuDineroEn3250() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaSur.construirCasa();
		saltaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 + 3250, propietario.getDinero());
		Assert.assertEquals(100000 - 3250, ocupante.getDinero());
	}

	@Test
	public void test46JugadorCaeEnSaltaSurConDosCasasDecrementarSuDineroEn3850() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 - 4500 + 3850, propietario.getDinero());
		Assert.assertEquals(100000 - 3850, ocupante.getDinero());
	}

	@Test
	public void test47JugadorCaeEnSaltaSurConUnHotelDecrementarSuDineroEn5500() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaSur.construirHotel();
		saltaSur.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 - 4500 - 4500 - 4500 - 7500 + 5500, propietario.getDinero());
		Assert.assertEquals(100000 - 5500, ocupante.getDinero());
	}

	@Test
	public void test48JugadorCaeEnSaltaNorteConUnaCasaDecrementarSuDineroEn3250() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaNorte.construirCasa();
		saltaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 + 3250, propietario.getDinero());
		Assert.assertEquals(100000 - 3250, ocupante.getDinero());
	}

	@Test
	public void test49JugadorCaeEnSaltaNorteConDosCasasDecrementarSuDineroEn3850() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 - 4500 + 3850, propietario.getDinero());
		Assert.assertEquals(100000 - 3850, ocupante.getDinero());
	}

	@Test
	public void test50JugadorCaeEnSaltaNorteConUnHotelDecrementarSuDineroEn5500() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		saltaSur.venderA(propietario);
		saltaNorte.venderA(propietario);
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirHotel();
		saltaNorte.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 23000 - 23000 - 4500 - 4500 - 4500 - 4500 - 7500 + 5500, propietario.getDinero());
		Assert.assertEquals(100000 - 5500, ocupante.getDinero());
	}

	@Test
	public void test51JugadorCaeEnSantaFeConUnaCasaDecrementarSuDineroEn3500() {
		Dados dados = new Dados();
		Terreno santaFe = new Terreno("SANTA FE", new Grupo(), 15000, 1500, 3500, 0, 0, 4000, 0);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		santaFe.venderA(propietario);
		santaFe.construirCasa();
		santaFe.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 15000 - 4000 + 3500, propietario.getDinero());
		Assert.assertEquals(100000 - 3500, ocupante.getDinero());
	}

	@Test
	public void test52JugadorCaeEnNeuquenConUnaCasaDecrementarSuDineroEn3800() {
		Dados dados = new Dados();
		Terreno neuquen = new Terreno("NEUQUEN", new Grupo(), 17000, 1800, 3800, 0, 0, 4800, 0);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		neuquen.venderA(propietario);
		neuquen.construirCasa();
		neuquen.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 17000 - 4800 + 3800, propietario.getDinero());
		Assert.assertEquals(100000 - 3800, ocupante.getDinero());
	}

	@Test
	public void test53JugadorCaeEnTucumanConUnaCasaDecrementarSuDineroEn4500() {
		Dados dados = new Dados();
		Terreno tucuman = new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);
		Jugador propietario = new Jugador("Propietario", 100000);
		Jugador ocupante = new Jugador("Ocupante", 100000);
		tucuman.venderA(propietario);
		tucuman.construirCasa();
		tucuman.ocupar(ocupante, dados);
		Assert.assertEquals(100000 - 25000 - 7000 + 4500, propietario.getDinero());
		Assert.assertEquals(100000 - 4500, ocupante.getDinero());
	}

	@Test
	public void test54Jugador1CuentaConTucumanYLoVendeDeberiaCobrarEl15PorcientoMenosDeLaSumaDeTodoLoQueVende() {
		Terreno tucuman = new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		tucuman.venderA(jugador1);
		tucuman.construirCasa();
		tucuman.vender();

		Assert.assertEquals(100000 - 25000 - 7000 + ((25000 + 7000) * (100 - 15) / 100), jugador1.getDinero());
	}

	@Test
	public void test55Jugador1CuentaConTucumanYLoVendeYJugador2CompraTucumanSiCaeJugador1EnTucumanSeLeDebeDescontarElPrecioDeAlquilerYSumarEsePrecioAlJugador2() {
		Dados dados = new Dados();
		Terreno tucuman = new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		Jugador jugador2 = new Jugador("Jugador2", 100000);
		tucuman.venderA(jugador1);
		tucuman.construirCasa();
		tucuman.vender();
		tucuman.venderA(jugador2);
		tucuman.ocupar(jugador1, dados);

		Assert.assertEquals(100000 - 25000 - 7000 + ((25000 + 7000) * (100 - 15) / 100) - 2500, jugador1.getDinero());
		Assert.assertEquals(100000 - 25000 + 2500, jugador2.getDinero());
	}

	@Test
	public void test56Jugador1CuentaConSaltaNorteConUnHotelYLoVendeDeberiaCobrarEl15PorcientoMenosDeLaSumaDeTodoLoQueVende() {
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador jugador1 = new Jugador("Jugador1", 100000);

		saltaSur.venderA(jugador1);
		saltaNorte.venderA(jugador1);
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirHotel();
		saltaNorte.vender();

		Assert.assertEquals(
				100000 - 23000 - 23000 - 4500 - 4500 - 4500 - 4500 - 7500 + ((23000 + 7500) * (100 - 15) / 100),
				jugador1.getDinero());

	}

	@Test
	public void test56Jugador1CuentaConSaltaNorteYLoVendeYJugador2CompraSaltaNorteSiCaeJugador1EnSaltaNorteSeLeDebeDescontarElPrecioDeAlquilerYSumarEsePrecioAlJugador2() {
		Dados dados = new Dados();
		Grupo salta = new Grupo();
		Terreno saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Terreno saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Jugador jugador1 = new Jugador("Jugador1", 100000);
		Jugador jugador2 = new Jugador("Jugador2", 100000);

		saltaSur.venderA(jugador1);
		saltaNorte.venderA(jugador1);
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		saltaNorte.construirHotel();
		saltaNorte.vender();

		saltaNorte.venderA(jugador2);
		saltaNorte.ocupar(jugador1, dados);

		Assert.assertEquals(
				100000 - 23000 - 23000 - 4500 - 4500 - 4500 - 4500 - 7500 + ((23000 + 7500) * (100 - 15) / 100) - 2000,
				jugador1.getDinero());
		Assert.assertEquals(100000 - 23000 + 2000, jugador2.getDinero());
	}

}