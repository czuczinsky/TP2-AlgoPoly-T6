package test;

import org.junit.Assert;
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
		terreno1.comprar(jugador1);
		Assert.assertEquals(80000 , jugador1.getDinero());
	}
	
	@Test
	public void test02SiUnJugadorCompraUnTerrenoDeberiaSerElNuevoPropietario() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		terreno1.comprar(jugador1);
		Assert.assertEquals(jugador1 , terreno1.getPropietario());
	}
	
	@Test
	public void test03SiUnJugadorCompraUnTerrenoYConstruyeUnaCasaDeberiaDecrementarSuDineroPorElPrecioDelTerrenoMasLaCasa() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1);
		Assert.assertEquals(100000-20000-5000 , jugador1.getDinero());
	}

	@Test
	public void test04SiUnJugadorConstruyeDosCasasSeDeberiaDecrementarSuDineroPorElPrecioDelTerrenoMasLasDosCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1);
		terreno1.construirCasa(jugador1);
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
	}

	@Test
	public void test05SiCompraAmbasZonasDeUnaProvinciaYConstruyeElMaxDeCasasEnCadaUnaSeDeberiaDescontarElPrecioDeLosTerrenosMasCuatroCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 25000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.comprar(jugador1);
		terrenoSur.comprar(jugador1);
		terrenoNorte.construirCasa(jugador1); // primera casa
		terrenoNorte.construirCasa(jugador1); // segunda casa
		terrenoSur.construirCasa(jugador1); // primera casa
		terrenoSur.construirCasa(jugador1); // segunda casa
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500, jugador1.getDinero());
	}

	@Test
	public void test06SiUnJugadorEdificaUnHotelEnUnaProvinciaQueTieneZonaNorteYSurSeLeDeberiaDescontarElPrecioCorrespondiente() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 15000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 10000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.comprar(jugador1);
		terrenoSur.comprar(jugador1);
		terrenoNorte.construirCasa(jugador1); // primera casa
		terrenoNorte.construirCasa(jugador1); // segunda casa
		terrenoSur.construirCasa(jugador1); // primera casa
		terrenoSur.construirCasa(jugador1); // segunda casa
		terrenoNorte.construirHotel(jugador1); // hotel
		Assert.assertEquals(100000 - 10000 - 15000 - 5000 - 5000 - 5500 - 5500 - 8000, jugador1.getDinero());
	}
	
	@Test
	public void test07SiUnJugadorQuiereEdificarUnHotelPeroNoLeAlcanzaElDineroNoSeLeDeberiaDescontarElPrecioDelHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 15000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 15000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 51000);
		terrenoNorte.comprar(jugador1);
		terrenoSur.comprar(jugador1);
		terrenoNorte.construirCasa(jugador1); // primera casa
		terrenoNorte.construirCasa(jugador1); // segunda casa
		terrenoSur.construirCasa(jugador1); // primera casa
		terrenoSur.construirCasa(jugador1); // segunda casa
		terrenoNorte.construirHotel(jugador1); // hotel
		Assert.assertEquals(51000 - 15000 - 15000 - 5000 - 5000 - 5500 - 5500, jugador1.getDinero());
	}

	@Test
	public void test08SiUnJugadorIntentaConstruirUnHotelEnUnaProvinciaQueNoTieneZonaNorteYSurNoSeLeDeberiaDescontarElPrecioDelHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1); // primera casa
		terreno1.construirCasa(jugador1); // segunda casa
		terreno1.construirHotel(jugador1); // hotel?
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
	}

	@Test
	public void test09SiUnJugadorCompraUnTerrenoYConstruyeDosCasasDeberiaTenerTresPropiedades() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1); // primera casa
		terreno1.construirCasa(jugador1); // segunda casa
		Assert.assertEquals(3 , terreno1.cantPropiedades());
	}
	
	@Test
	public void test10SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYNoEsElSeLeDeberiaDescontarElAlquilerDelTerreno() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.comprar(jugador1);
		terreno1.ocupar(jugador2);
		
		Assert.assertEquals(100000-2000 , jugador2.getDinero());
	}
	
	@Test
	public void test11SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnaCasaSeLeDeberiaDescontarElAlquilerDeUnaCasa() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1); // primera casa
		terreno1.ocupar(jugador2);
		
		Assert.assertEquals(100000-3000 , jugador2.getDinero());
	}
	
	@Test
	public void test12SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYDosCasasSeLeDeberiaDescontarElAlquilerDeDosCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.comprar(jugador1);
		terreno1.construirCasa(jugador1); // primera casa
		terreno1.construirCasa(jugador1); // segunda casa
		terreno1.ocupar(jugador2);
		
		Assert.assertEquals(100000-3500 , jugador2.getDinero());
	}
	
	@Test
	public void test13SiUnJugadorCaeEnUnTerrenoQueTienePropietarioYUnHotelSeLeDeberiaDescontarElAlquilerDelHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",200000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.comprar(jugador1);
		terreno2.comprar(jugador1);
		terreno1.construirCasa(jugador1);
		terreno1.construirCasa(jugador1);
		terreno2.construirCasa(jugador1);
		terreno2.construirCasa(jugador1);
		terreno1.construirHotel(jugador1);
		terreno1.ocupar(jugador2);
		
		Assert.assertEquals(100000-5000 , jugador2.getDinero());
	}

	@Test
	public void test143SiUnJugadorCaeEnUnTerrenoMultipleQueTienePropietarioY2CasasSeLeDeberiaDescontarElAlquilerDelas2Casas() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno terreno2 = new Terreno("Terreno 2", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Jugador jugador2 = new Jugador("Jugador 2",100000);
		terreno1.comprar(jugador1);
		terreno2.comprar(jugador1);
		terreno1.construirCasa(jugador1);
		terreno1.construirCasa(jugador1);
		terreno1.ocupar(jugador2);
		
		Assert.assertEquals(100000-3500 , jugador2.getDinero());
	}
	// TODO tests de casos en que ya no se puede edificar
}
