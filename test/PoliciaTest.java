package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.Dados;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;
import modelo.Policia;

public class PoliciaTest{

	@Test
	public void test01SiJugadorCaeEnCasilleroPoliciaLaNuevaPosicionDelJugadorEsLaCarcel() {
		Dados dados=new Dados();
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador,dados);
		
		Assert.assertEquals(jugador.getPosicion(),carcel);
	}

	@Test
	public void test02JugadorNoEstaEnImpuestoAlLujoSiCaeEnPolicia() {
		Dados dados=new Dados();
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		ImpuestoDeLujo impuestoAlLujo=new ImpuestoDeLujo();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador,dados);
		
		Assert.assertNotSame(jugador.getPosicion(),impuestoAlLujo);
	}
}
