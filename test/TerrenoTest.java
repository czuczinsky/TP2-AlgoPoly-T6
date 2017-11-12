package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class TerrenoTest {

	@Test
	public void test01Comprar() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		Assert.assertEquals(100000 , jugador1.getDinero());
		terreno1.comprar(jugador1);
		Assert.assertEquals(jugador1 , terreno1.getPropietario());
		Assert.assertEquals(80000 , jugador1.getDinero());
	}

	@Test
	public void test02EdificarUnaCasaTerrenoSimple() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.edificar();
		Assert.assertEquals(100000-20000-5000 , jugador1.getDinero());
	}

	@Test
	public void test03EdificarDosCasasTerrenoSimple() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.edificar();
		terreno1.edificar();
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
	}

	@Test
	public void test04EdificarDosMasDosCasas() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 25000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.comprar(jugador1);
		terrenoSur.comprar(jugador1);
		terrenoNorte.edificar(); // primera casa
		terrenoNorte.edificar(); // segunda casa
		terrenoSur.edificar(); // primera casa
		terrenoSur.edificar(); // segunda casa
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500, jugador1.getDinero());
	}

	@Test
	public void test05EdificarUnHotel() {
		Grupo provincia1 = new Grupo();
		Terreno terrenoNorte = new Terreno("Terreno Norte", provincia1, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Terreno terrenoSur = new Terreno("Terreno Sur", provincia1, 25000, 2500, 3500, 3800, 5500, 5500, 8500);

		Jugador jugador1 = new Jugador("Jugador 1", 100000);
		terrenoNorte.comprar(jugador1);
		terrenoSur.comprar(jugador1);
		terrenoNorte.edificar(); // primera casa
		terrenoNorte.edificar(); // segunda casa
		terrenoSur.edificar(); // primera casa
		terrenoSur.edificar(); // segunda casa
		terrenoNorte.edificar(); // hotel
		Assert.assertEquals(100000 - 20000 - 25000 - 5000 - 5000 - 5500 - 5500 - 8000, jugador1.getDinero());
	}

	@Test
	public void test06IntentarEdificarHotelTerrenoSimple() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.edificar(); // primera casa
		terreno1.edificar(); // segunda casa
		terreno1.edificar(); // hotel?
		Assert.assertEquals(100000-20000-5000-5000 , jugador1.getDinero());
	}

	@Test
	public void test06CantidadPropieaddes() {
		Grupo provincia1 = new Grupo();
		Terreno terreno1 = new Terreno("Terreno 1", provincia1,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
				
		Jugador jugador1 = new Jugador("Jugador 1",100000);
		terreno1.comprar(jugador1);
		terreno1.edificar(); // primera casa
		terreno1.edificar(); // segunda casa
		Assert.assertEquals(3 , terreno1.cantPropiedades());
	}

	// TODO tests de casos en que ya no se puede edificar
}
