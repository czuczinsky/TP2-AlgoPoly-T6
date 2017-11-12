package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;
import modelo.Policia;

public class PoliciaTest{

	@Test
	public void test01SiJugadorCaeEnCasilleroPoliciaLaNuevaPosicionDelJugadorEsLaCarcel() {
		
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador);
		
		Assert.assertEquals(jugador.getPosicion(),carcel);
	}

	@Test
	public void test02JugadorNoEstaEnImpuestoAlLujoSiCaeEnPolicia() {
		
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		ImpuestoDeLujo impuestoAlLujo=new ImpuestoDeLujo();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador);
		
		Assert.assertNotSame(jugador.getPosicion(),impuestoAlLujo);
	}
}
