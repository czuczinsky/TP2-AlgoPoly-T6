package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.*;

public class TerrenoTest {


	@Test
	public void test01SiUnJugadorCompraUnTerrenoSuDineroSeDeberiaDecrementarPorElPrecioDelTerreno() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		terreno1.venderA(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test02SiUnJugadorCompraUnTerrenoDeberiaSerElNuevoPropietario() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		terreno1.venderA(jugador1);
		Assert.assertEquals(jugador1 , terreno1.getPropietario());
	}
	
	@Test
	public void test03SiUnJugadorCompraUnTerrenoYConstruyeUnaCasaDeberiaDecrementarSuDineroPorElPrecioDelTerrenoMasLaCasa() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa();
		Assert.assertEquals(100000-20000-5000 , jugador1.getDinero());
	}

	@Test
	public void test04SiUnJugadorConstruyeDosCasasSeDeberiaDecrementarSuDineroPorElPrecioDelTerrenoMasLasDosCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
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
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirCasa(); // segunda casa
		terreno1.construirHotel(); // hotel?
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
	}

	@Test
	public void test09SiUnJugadorCompraUnTerrenoYConstruyeDosCasasDeberiaTenerTresPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirCasa(); // segunda casa
		Assert.assertEquals(3 , terreno1.cantPropiedades());
	}
	
	@Test
	public void test10SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYNoEsElSeLeDeberiaDescontarElAlquilerDelTerreno() {
		Dados dados=new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.venderA(jugador1);
		terreno1.ocupar(jugador2,dados);
		
		Assert.assertEquals(100000-2000 , jugador2.getDinero());
	}
	
	@Test
	public void test11SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnaCasaSeLeDeberiaDescontarElAlquilerDeUnaCasa() {
		Dados dados=new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.ocupar(jugador2,dados);
		
		Assert.assertEquals(100000-3000 , jugador2.getDinero());
	}
	
	@Test
	public void test12SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYDosCasasSeLeDeberiaDescontarElAlquilerDeDosCasas() {
		Dados dados=new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.venderA(jugador1);
		terreno1.construirCasa(); // primera casa
		terreno1.construirCasa(); // segunda casa
		terreno1.ocupar(jugador2,dados);
		
		Assert.assertEquals(100000-3500 , jugador2.getDinero());
	}
	
	@Test
	public void test13SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnHotelSeLeDeberiaDescontarElAlquilerDelHotel() {
		Dados dados=new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",200000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		terreno2.construirCasa();
		terreno2.construirCasa();
		terreno1.construirHotel();
		terreno1.ocupar(jugador2,dados);
		
		Assert.assertEquals(100000-5000 , jugador2.getDinero());
	}

	@Test
	public void test14SiUnJugadorCaeEnUnTerrenoMultipleQueTienePropietarioY2CasasSeLeDeberiaDescontarElAlquilerDelas2Casas() {
		Dados dados=new Dados();
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.venderA(jugador1);
		terreno2.venderA(jugador1);
		terreno1.construirCasa();
		terreno1.construirCasa();
		terreno1.ocupar(jugador2,dados);
		
		Assert.assertEquals(100000-3500 , jugador2.getDinero());
	}
	
	@Test
	public void test15SiUnJugadorCompraBuenosAiresSurYNoTieneDueñoSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur",buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		bsAsSur.venderA(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test16SiUnJugadorCompraBuenosAiresNorteYNoTieneDueñoSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsNorte = new Terreno("Buenos Aires Norte",buenosAires,
				25000 , 2500 , 3500 , 4000 , 6000 , 5500 , 9000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		bsAsNorte.venderA(jugador1);
		Assert.assertEquals(75000 , jugador1.getDinero());
	}
	
	@Test
	public void test17SiUnJugadorCompraCordobaSurYNoTieneDueñoSuDineroSeDeberiaDecrementarEn18Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur",cordoba,
				18000 , 1000 , 1500 , 2500 , 3000 , 2000 , 3000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(82000 , jugador1.getDinero());
	}
	
	@Test
	public void test18SiUnJugadorCompraCordobaNorteYNoTieneDueñoSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur",cordoba,
				20000 , 1300 , 1800 , 2900 , 3500 , 2200 , 3500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test19SiUnJugadorCompraSantaFeYNoTieneDueñoSuDineroSeDeberiaDecrementarEn15Mil() {
		Grupo staFe = new Grupo();
		Terreno santaFe= new Terreno("Santa Fe",staFe,
				15000 , 1500 , 3500 , 0 , 0 , 4000 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		santaFe.venderA(jugador1);
		Assert.assertEquals(85000 , jugador1.getDinero());
	}
	
	@Test
	public void test20SiUnJugadorCompraSaltaNorteYNoTieneDueñoSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaNorte= new Terreno("Salta Norte",salta,
				23000 , 2000 , 3250 , 3850 , 5500 , 4500 , 7500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		saltaNorte.venderA(jugador1);
		Assert.assertEquals(77000 , jugador1.getDinero());
	}
	@Test
	public void test21SiUnJugadorCompraSaltaSurYNoTieneDueñoSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaSur= new Terreno("Salta Sur",salta,
				23000 , 2000 , 3250 , 3850 , 5500 , 4500 , 7500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		saltaSur.venderA(jugador1);
		Assert.assertEquals(77000 , jugador1.getDinero());
	}
	
	@Test
	public void test22SiUnJugadorCompraNeuquenYNoTieneDueñoSuDineroSeDeberiaDecrementarEn17Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen= new Terreno("Neuquen",nquen,
				17000 , 1800 , 3800 , 4800 , 0 , 4800 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(83000 , jugador1.getDinero());
	}
	
	@Test
	public void test23SiUnJugadorCompraTucumanYNoTieneDueñoSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen= new Terreno("Neuquen",nquen,
				25000 , 2500 ,4500 ,0 , 0 , 7000 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(75000 , jugador1.getDinero());
	}
	// TODO tests de casos en que ya no se puede edificar
}
