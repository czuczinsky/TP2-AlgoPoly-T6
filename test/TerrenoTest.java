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
	public void test15SiUnJugadorCompraBuenosAiresSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur",buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		bsAsSur.venderA(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test16SiUnJugadorCompraBuenosAiresNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsNorte = new Terreno("Buenos Aires Norte",buenosAires,
				25000 , 2500 , 3500 , 4000 , 6000 , 5500 , 9000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		bsAsNorte.venderA(jugador1);
		Assert.assertEquals(75000 , jugador1.getDinero());
	}
	
	@Test
	public void test17SiUnJugadorCompraCordobaSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn18Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur",cordoba,
				18000 , 1000 , 1500 , 2500 , 3000 , 2000 , 3000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(82000 , jugador1.getDinero());
	}
	
	@Test
	public void test18SiUnJugadorCompraCordobaNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn20Mil() {
		Grupo cordoba = new Grupo();
		Terreno cordobaSur = new Terreno("Cordoba Sur",cordoba,
				20000 , 1300 , 1800 , 2900 , 3500 , 2200 , 3500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		cordobaSur.venderA(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test19SiUnJugadorCompraSantaFeYNoTieneDuenioSuDineroSeDeberiaDecrementarEn15Mil() {
		Grupo staFe = new Grupo();
		Terreno santaFe= new Terreno("Santa Fe",staFe,
				15000 , 1500 , 3500 , 0 , 0 , 4000 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		santaFe.venderA(jugador1);
		Assert.assertEquals(85000 , jugador1.getDinero());
	}
	
	@Test
	public void test20SiUnJugadorCompraSaltaNorteYNoTieneDuenioSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaNorte= new Terreno("Salta Norte",salta,
				23000 , 2000 , 3250 , 3850 , 5500 , 4500 , 7500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		saltaNorte.venderA(jugador1);
		Assert.assertEquals(77000 , jugador1.getDinero());
	}
	@Test
	public void test21SiUnJugadorCompraSaltaSurYNoTieneDuenioSuDineroSeDeberiaDecrementarEn23Mil() {
		Grupo salta = new Grupo();
		Terreno saltaSur= new Terreno("Salta Sur",salta,
				23000 , 2000 , 3250 , 3850 , 5500 , 4500 , 7500);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		saltaSur.venderA(jugador1);
		Assert.assertEquals(77000 , jugador1.getDinero());
	}
	
	@Test
	public void test22SiUnJugadorCompraNeuquenYNoTieneDuenioSuDineroSeDeberiaDecrementarEn17Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen= new Terreno("Neuquen",nquen,
				17000 , 1800 , 3800 , 4800 , 0 , 4800 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(83000 , jugador1.getDinero());
	}
	
	@Test
	public void test23SiUnJugadorCompraTucumanYNoTieneDuenioSuDineroSeDeberiaDecrementarEn25Mil() {
		Grupo nquen = new Grupo();
		Terreno neuquen= new Terreno("Neuquen",nquen,
				25000 , 2500 ,4500 ,0 , 0 , 7000 , 0);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		neuquen.venderA(jugador1);
		Assert.assertEquals(75000 , jugador1.getDinero());
	}
	
	@Test
	public void test24JugadorQueEsPropietarioDeBsAsSurYNorteSiConstruyeUnaCasaEnElSurSuDineroDeberiaDecrementarseEn5000() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		bsAsSur.venderA(jugador1);
		bsAsNorte.venderA(jugador1);
		Assert.assertEquals(55000 , jugador1.getDinero());
		bsAsSur.construirCasa();
	
		Assert.assertEquals( 55000-5000, jugador1.getDinero());
	}
	@Test
	public void test25JugadorQueEsPropietarioDeBsAsSurYNorteConUnaCasaEnCadaUnaSiContrincanteCaeEnElSurSuDineroSeDecrementaEn3Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados=new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador juan = new Jugador("Juan",100000);
		bsAsSur.venderA(juan);
		bsAsNorte.venderA(juan);
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Jugador carlos=new Jugador ("Carlos",13000);
		
		bsAsSur.ocupar(carlos, dados);
	
		Assert.assertEquals( 13000-3000, carlos.getDinero());
	}
	
	@Test
	public void test26JugadorQueEsPropietarioDeBsAsSurYNorteConUnaCasaEnCadaUnaSiContrincanteCaeEnElSurSuDineroSeDecrementaEn3Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados=new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador maria = new Jugador("Maria",100000);
		bsAsSur.venderA(maria);
		bsAsNorte.venderA(maria);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Jugador laura=new Jugador ("Laura",13000);
		
		bsAsNorte.ocupar(laura, dados);
	
		Assert.assertEquals( 13000-3500, laura.getDinero());
	}
	@Test
	public void test27JugadorQueEsPropietarioDeBsAsSurYNorteYTiene3CasasCuandoConstruyeUnHotelSuDineroNoDeberiaDecrementarse() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador lucas= new Jugador("Lucas",100000);
		bsAsSur.venderA(lucas);
		bsAsNorte.venderA(lucas);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals( 100000-20000-25000-5000-5000-5500, lucas.getDinero());
		bsAsNorte.construirHotel();
		Assert.assertEquals( 100000-20000-25000-5000-5000-5500, lucas.getDinero());

	}
	
	@Test
	public void test28JugadorQueEsPropietarioDeBsAsSurYNorteYTiene4CasasCuandoConstruyeUnHotelEnElSurSuDineroDeberiaDecrementarse8Mil() {
		Grupo buenosAires = new Grupo();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador pablo= new Jugador("Pablo",100000);
		bsAsSur.venderA(pablo);
		bsAsNorte.venderA(pablo);
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals( 100000-20000-25000-5000-5000-5500-5500, pablo.getDinero());
		bsAsSur.construirHotel();
		Assert.assertEquals(34000 -8000, pablo.getDinero());

	}
	
	@Test
	public void test29JugadorQueEsPropietarioDeBsAsSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn5Mil() {
		Grupo buenosAires = new Grupo();
		Dados dados=new Dados();
		Terreno bsAsSur = new Terreno("Buenos Aires Sur", buenosAires,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno bsAsNorte=new Terreno("Buenos Aires Norte", buenosAires, 
				25000 , 2500 , 3500 , 4000 , 6000, 5500 , 9000);
				
		Jugador maria = new Jugador("Maria",100000);
		bsAsSur.venderA(maria);
		bsAsNorte.venderA(maria);
		
		bsAsSur.construirCasa();
		bsAsSur.construirCasa();
		
		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		Assert.assertEquals( 100000-20000-25000-5000-5000-5500-5500, maria.getDinero());
		bsAsSur.construirHotel();
		Assert.assertEquals( 100000-20000-25000-5000-5000-5500-5500-8000, maria.getDinero());
		Jugador laura=new Jugador ("Laura",100000);
		
		bsAsSur.ocupar(laura, dados);
	
		Assert.assertEquals(100000-5000, laura.getDinero());
	}
	@Test
	public void test30JugadorQueEsPropietarioDeCordobaSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn3Mil() {
		Grupo cordoba = new Grupo();
		Dados dados=new Dados();
		Terreno cordobaSur = new Terreno("Cordoba Sur", cordoba,
				18000 , 1000 , 1500 , 2500 , 3000 , 2000 , 3000);
		
		Terreno cordobaNorte=new Terreno("Cordoba Norte", cordoba, 
				20000 , 1300 , 1800 , 2900 , 3500, 2200 , 3500);
				
		Jugador lucia = new Jugador("Lucia",100000);
		cordobaSur.venderA(lucia);
		cordobaNorte.venderA(lucia);
		
		cordobaSur.construirCasa();
		cordobaSur.construirCasa();
		
		cordobaNorte.construirCasa();
		cordobaNorte.construirCasa();
	
		cordobaSur.construirHotel();
		
		Jugador laura=new Jugador ("Laura",100000);
		
		cordobaSur.ocupar(laura, dados);
	
		Assert.assertEquals(100000-3000, laura.getDinero());
	}
	
	@Test
	public void test31JugadorQueEsPropietarioDeSaltaSurYNorteYTiene4CasasCuandoConstruyeUnHotelCuandoCaeUnContricanteDeberiaDecrementarseAEsteSuDineroEn5500() {
		Grupo salta = new Grupo();
		Dados dados=new Dados();
		Terreno saltaSur = new Terreno("Salta Sur", salta,
				23000 , 2000 , 3500 , 3850 , 5500 , 4500 , 7500);
		
		Terreno saltaNorte=new Terreno("Salta Norte", salta, 
				23000 , 2000 , 3500 , 3850 , 5500 , 4500 , 7500);
				
		Jugador lucia = new Jugador("Lucia",100000);
		saltaSur.venderA(lucia);
		saltaNorte.venderA(lucia);
		
		saltaSur.construirCasa();
		saltaSur.construirCasa();
		
		saltaNorte.construirCasa();
		saltaNorte.construirCasa();
		
		saltaSur.construirHotel();
		
		Jugador laura=new Jugador ("Laura",100000);
		
		saltaSur.ocupar(laura, dados);
	
		Assert.assertEquals(100000-5500, laura.getDinero());
	}
	
	@Test
	public void test32JugadorQueEsPropietarioDeSantaFeYConstruyeUnaCasaSeLeDeberiaDecrementarSuDineroEn4Mil() {
		Grupo staFe = new Grupo();
		Terreno santaFe = new Terreno("Salta Sur", staFe,
				15000 , 1500 , 3500 , 0 , 0 , 4000 , 0);
				
		Jugador lucia = new Jugador("Lucia",100000);
		santaFe.venderA(lucia);
		Assert.assertEquals(100000-15000, lucia.getDinero());
		santaFe.construirCasa();
	
		Assert.assertEquals(85000-4000, lucia.getDinero());
	}

	// TODO tests de casos en que ya no se puede edificar
}
