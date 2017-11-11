package test;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.ImpLujo;
import modelo.Jugador;
import modelo.Policia;

public class PoliciaTest{

	@Test
	public void test01JugadorEstaEnLaCarcelSiCaeEnCasilleroPolicia() {
		
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador);
		
		Assert.assertEquals(jugador.getPosicion(),carcel);
	}

	@Test
	public void test01JugadorNoEstaEnImpuestoAlLujoSiCaeEnPolicia() {
		
		Jugador jugador=new Jugador("Pepe",100000);
		Carcel carcel=new Carcel();
		ImpLujo impuestoAlLujo=new ImpLujo();
		Policia casilleroPolicia=new Policia(carcel);
		
		casilleroPolicia.ocupar(jugador);
		
		Assert.assertNotSame(jugador.getPosicion(),impuestoAlLujo);
	}
}
