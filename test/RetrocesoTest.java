package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Agrupable;
import modelo.Avance;
import modelo.Carcel;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.ImpuestoAlLujo;
import modelo.Jugador;
import modelo.Policia;
import modelo.Quini6;
import modelo.Retroceso;
import modelo.Salida;
import modelo.Tablero;
import modelo.Terreno;

public class RetrocesoTest {

	private Tablero tablero;
	private Salida salida;
	private Quini6 quini;
	private Agrupable bsAsSur;
	private Agrupable edesur;
	private Agrupable bsAsNorte;
	private Carcel carcel;
	private Agrupable cordobaSur;
	private Avance avance;
	private Agrupable subte;
	private Agrupable cordobaNorte;
	private ImpuestoAlLujo impuesto;
	private Agrupable santaFe;
	private Agrupable aysa;
	private Agrupable saltaNorte;
	private Agrupable saltaSur;
	private Policia policia;
	private Agrupable tren;
	private Agrupable neuquen;
	private Retroceso retroceso;
	private Agrupable tucuman;
	

	@Before
	public void setUp() throws Exception {
		tablero = new Tablero();
		
		salida=new Salida();
		tablero.agregarCasillero(salida);
		quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		impuesto=new ImpuestoAlLujo();
		tablero.agregarCasillero(impuesto);
		santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
	}
	
	@Test
	public void test01JugadorQueTieneUnaPropiedadSiSaca2EnLosDadosDeberiaRetroceder1Casillero() {
		Jugador jugador = new Jugador("Jugador", 100000);
		jugador.agregarTerreno(neuquen);
		Dados dados=new Dados();
		dados.setNumeros(1,1);
		jugador.moverA(retroceso,dados);

		assertEquals(neuquen, jugador.getPosicion());	
	}
	
	@Test
	public void test02JugadorCaeEnRetrocesoDinamicoSacando3EnLosDadosDeberiaRetroceder3CasillerosAPolicia() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(1,2);
		jugador.moverA(retroceso,dados);
		
		assertEquals(carcel, jugador.getPosicion());	
	}
	
	@Test
	public void test03JugadorQueTieneUnaPropiedadSiSaca4EnLosDadosDeberiaRetroceder3Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		jugador.agregarTerreno(neuquen);
		Dados dados=new Dados();
		dados.setNumeros(3,1);
		jugador.moverA(retroceso,dados);
		
		assertEquals(carcel, jugador.getPosicion());	
	}
	
	@Test
	public void test04JugadorQueTieneTresPropiedadesSiSaca5EnLosDadosDeberiaRetroceder2Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		jugador.agregarTerreno(neuquen);
		jugador.agregarTerreno(bsAsNorte);
		jugador.agregarTerreno(santaFe);
		Dados dados=new Dados();
		dados.setNumeros(4,1);
		jugador.moverA(retroceso,dados);
		
		assertEquals(tren, jugador.getPosicion());	
	}
	
	@Test
	public void test05JugadorQueTieneUnaPropiedadSiSaca6EnLosDadosDeberiaRetroceder5Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		jugador.agregarTerreno(neuquen);
		Dados dados=new Dados();
		dados.setNumeros(4,2);
		jugador.moverA(retroceso,dados);
		
		assertEquals(saltaNorte, jugador.getPosicion());	
	}
	
	@Test
	public void test06JugadorQueCaeEnRetrocesoSiSaca7EnLosDadosDeberiaRetroceder5Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(4,3);
		jugador.moverA(retroceso,dados);
		
		assertEquals(saltaNorte, jugador.getPosicion());	
	}
	
	@Test
	public void test06JugadorQueCaeEnRetrocesoSiSaca8EnLosDadosNoDeberiaRetrocederNingunCasillero() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,3);
		jugador.moverA(retroceso,dados);
		
		assertEquals(retroceso, jugador.getPosicion());	
	}
	
	@Test
	public void test08JugadorCaeEnRetrocesoDinamicoSacando9EnLosDadosYRetrocedeASaltaNorte() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,4);
		jugador.moverA(retroceso,dados);
		
		assertEquals(neuquen, jugador.getPosicion());
	}
	
	@Test
	public void test09JugadorCaeEnRetrocesoDinamicoSacando10EnLosDadosYNoRetrocedeNingunaPosicion() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,5);
		jugador.moverA(retroceso,dados);
		
		assertEquals(retroceso, jugador.getPosicion());
	}
	
	@Test
	public void test10JugadorCaeEnRetrocesoDinamicoSacando11EnLosDadosRetrocede9Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,6);
		jugador.moverA(retroceso,dados);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test11JugadorCaeEnRetrocesoDinamicoSacando12EnLosDadosRetrocede10Casilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(6,6);
		jugador.moverA(retroceso,dados);
		
		assertEquals(subte, jugador.getPosicion());	
	}	

	@Test
	public void test12JugadorPropietarioDeDosTerrenos2CasasYUnHotelCaeEnARetrocesoDinamicoSaca6EnLosDadosDeberiaRetroceder1PosicionANeuquen() {
		Grupo bsAs = new Grupo();
		Terreno bsAsSur = new Terreno("BsAsSur", bsAs,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno bsAsNorte = new Terreno("BsAsNorte", bsAs,
			25000 , 2500 , 3500 , 4000 , 6000 , 5500 , 9000);
				
		Jugador jugadora = new Jugador("Maria",100000);
		bsAsSur.venderA(jugadora);
		bsAsNorte.venderA(jugadora);
		
		bsAsSur.construirCasa(); // primera casa
		bsAsSur.construirCasa(); // segunda casa
		
		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		bsAsNorte.construirHotel();
		Dados dados=new Dados();
		dados.setNumeros(5,1);
		jugadora.moverA(retroceso,dados);
		
		
		
		assertEquals(neuquen, jugadora.getPosicion());
	}
	
	@Test
	public void test13JugadorPropietarioDeDosTerrenosY2CasasYUnHotelCaeEnRetroesoDinamicoSaca4EnLosDadosNoDeberiaRetrocederNingunaPosicion() {
		Grupo bsAs = new Grupo();
		Terreno bsAsSur = new Terreno("BsAsSur", bsAs,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		Terreno bsAsNorte = new Terreno("BsAsNorte", bsAs,
			25000 , 2500 , 3500 , 4000 , 6000 , 5500 , 9000);
				
		Jugador jugadora = new Jugador("Maria",100000);
		bsAsSur.venderA(jugadora);
		bsAsNorte.venderA(jugadora);
		
		bsAsSur.construirCasa(); 
		bsAsSur.construirCasa();
		Dados dados=new Dados();
		dados.setNumeros(1,3);
		jugadora.moverA(retroceso,dados);
		
		
		
		assertEquals(retroceso, jugadora.getPosicion());
	}
	
	@Test
	public void test14JugadorPropietarioDeTresTerrenosYUnaCasaCaeEnRetrocesoYSaca5EnLosDadosDeberiaRetroceder1PosicionANeuquen() {
		Grupo grupo = new Grupo();
		Terreno bsAsSur = new Terreno("BsAsSur", grupo,
				20000 , 2000 , 3000 , 3500 , 5000 , 5000 , 8000);
		
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
				
		Jugador jugadora = new Jugador("Maria",100000);
		bsAsSur.venderA(jugadora);
		santaFe.venderA(jugadora);
		saltaSur.venderA(jugadora);
		
		santaFe.construirCasa();
		
		Dados dados=new Dados();
		dados.setNumeros(4,1);
		jugadora.moverA(retroceso,dados);
		
		assertEquals(neuquen, jugadora.getPosicion());
	}


}
