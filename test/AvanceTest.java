package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Agrupable;
import modelo.Avance;
import modelo.Carcel;
import modelo.Casillero;
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

public class AvanceTest {

	private Tablero tablero;
	private Dados dados;
	private Salida salida;
	private Quini6 quini;
	private Terreno bsAsSur;
	private Compania edesur;
	private Terreno bsAsNorte;
	private Carcel carcel;
	private Terreno cordobaSur;
	private Avance avance;
	private Compania subte;
	private Terreno cordobaNorte;
	private ImpuestoAlLujo impuesto;
	private Terreno santaFe;
	private Compania aysa;
	private Terreno saltaNorte;
	private Terreno saltaSur;
	private Policia policia;
	private Compania tren;
	private Terreno neuquen;
	private Retroceso retroceso;
	private Terreno tucuman;
	
	
	@Before
	public void setUp() throws Exception {
		//dados = Dados.getDados();
		
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
	public void test01JugadorCaeEnAvanceSiSaca2EnLosDadosNoDeberiaAvanzarNingunCasillero() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados=new Dados();
		dados.setNumeros(1,1);
		jugador.moverA(avance,dados);
		
		assertEquals(avance, jugador.getPosicion());
	}
	
	@Test
	public void test02JugadorCaeEnAvanceSiSaca3EnLosDadosDeberiaAvanzarUnCasillero() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados=new Dados();
		dados.setNumeros(1,2);
		jugador.moverA(avance,dados);
		
		assertEquals(subte, jugador.getPosicion());	
	}
	
	@Test
	public void test03JugadorCaeEnAvanceSiSaca4EnLosDadosDeberiaAvanzarDosCasilleros() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados=new Dados();
		dados.setNumeros(3,1);
		jugador.moverA(avance,dados);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test04JugadorCaeEnAvanceSiSaca5EnLosDadosDeberiaAvanzarTresCasilleros() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados=new Dados();
		dados.setNumeros(3,2);
		jugador.moverA(avance,dados);
		
		assertEquals(impuesto, jugador.getPosicion());
	}
	
	@Test
	public void test05JugadorCaeEnAvanceSiSaca6EnLosDadosDeberiaAvanzarCuatroCasilleros() {
		Jugador jugador = new Jugador("Jugador", 0);
		Dados dados=new Dados();
		dados.setNumeros(5,1);
		jugador.moverA(avance,dados);
		
		assertEquals(santaFe, jugador.getPosicion());
	}
	
	@Test
	public void test06JugadorCaeEnAvanceSiSaca7EnLosDadosDeberiaAvanzarCincoCasilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,2);
		jugador.moverA(avance,dados);
		
		assertEquals(aysa, jugador.getPosicion());
	}
	
	@Test
	public void test07JugadorCaeEnAvanceSiSaca8EnLosDadosNoDeberiaAvanzarNingunCasillero() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,3);
		jugador.moverA(avance,dados);
		
		assertEquals(avance, jugador.getPosicion());
	}
	
	@Test
	public void test08JugadorCaeEnAvanceSiSaca9EnLosDadosDeberiaAvanzarUnCasillero() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,4);
		jugador.moverA(avance,dados);
		
		assertEquals(subte, jugador.getPosicion());
	}
	
	@Test
	public void test09JugadorCaeEnAvanceSiSaca10EnLosDadosDeberiaAvanzarDosCasilleros() {
		Jugador jugador = new Jugador("Jugador", 100002);
		Dados dados=new Dados();
		dados.setNumeros(5,5);
		jugador.moverA(avance,dados);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test10JugadorQueTieneDosPropiedadesSiCaeEnAvanceYSaca11EnLosDadosDeberiaAvanzarNueveCasilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		jugador.agregarTerreno(bsAsNorte);
		jugador.agregarTerreno(cordobaNorte);
		dados.setNumeros(5,6);
		jugador.moverA(avance,dados);

		
		assertEquals(tren, jugador.getPosicion());
	}
	
	@Test
	public void test11JugadorQueTieneDosPropiedadesSiCaeEnAvanceYSaca12EnLosDadosDeberiaAvanzarDiezCasilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		jugador.agregarTerreno(bsAsNorte);
		jugador.agregarTerreno(cordobaNorte);
		Dados dados=new Dados();
		dados.setNumeros(6,6);
		jugador.moverA(avance,dados);
		
		assertEquals(neuquen, jugador.getPosicion());
	}
	
	@Test
	public void test12JugadorCaeEnAvanceYSaca11EnLosDadosDeberiaAvanzarAlCasilleroRetrocesoYRetrocederNueveCasilleros() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados=new Dados();
		dados.setNumeros(5,6);
		jugador.moverA(avance,dados);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test13JugadorPropietarioDeDosTerrenos2CasasYUnHotelCaeEnAvanceDinamicoSaca11EnLosDadosDeberiaAvanzar6PosicionesASaltaNorte() {
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
		
		bsAsNorte.construirCasa();
		bsAsNorte.construirCasa();
		bsAsNorte.construirHotel();
		Dados dados=new Dados();
		dados.setNumeros(5,6);
		jugadora.moverA(avance,dados);
		
		assertEquals(saltaNorte, jugadora.getPosicion());
	}
	
	@Test
	public void test14JugadorPropietarioDeDosTerrenosY2CasasYUnHotelCaeEnAvanceDinamicoSaca12EnLosDadosDeberiaCaerEnPoliciaEIrALaCarcel() {
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
		dados.setNumeros(6,6);
		jugadora.moverA(avance,dados);
	
		assertEquals(carcel, jugadora.getPosicion());
	}
}
