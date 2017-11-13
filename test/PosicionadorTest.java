package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Avance;
import modelo.Carcel;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;
import modelo.Policia;
import modelo.Posicionador;
import modelo.Quini6;
import modelo.Retroceso;
import modelo.Salida;
import modelo.Tablero;
import modelo.Terreno;

public class PosicionadorTest {
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
	private ImpuestoDeLujo impuesto;
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
		dados = Dados.getDados();
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
		impuesto=new ImpuestoDeLujo();
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
	public void test01JugadorSinPropiedadesQueCaeEnAvanceDinamicoYSaca2EnLosDadosNoDeberiaAvanzar() {
		Posicionador posicionador=new Posicionador();
		Jugador jugador=new Jugador("Ana",100000);
		jugador.moverA(avance);
		
		dados.setNumeros(1,1);
		
		avance.ocupar(jugador);
		
		int posicion=posicionador.posicionDelJugador(jugador, dados);
		
		assertEquals(posicion,0);
		
	}

	@Test
	public void test03JugadorCon5000PesosQueCaeEnAvanceDinamicoYSaca7EnLosDadosDeberiaAvanzar2Posiciones() {
		Posicionador posicionador=new Posicionador();
		Jugador jugador=new Jugador("Ana",5000);
		jugador.moverA(avance);
		avance.ocupar(jugador);
		dados.setNumeros(5,2);
		int posicion=posicionador.posicionDelJugador(jugador, dados);

		assertEquals(posicion,2);
		
	}
	
	@Test
	public void test04JugadorCon5000PesosQueCaeEnRetrocesoDinamicoYSaca7EnLosDadosDeberiaRetroceder2Posiciones() {
		Posicionador posicionador=new Posicionador();
		Jugador jugador=new Jugador("Ana",5000);
		jugador.moverA(retroceso);
		retroceso.ocupar(jugador);
		dados.setNumeros(5,2);
		int posicion=posicionador.posicionDelJugador(jugador, dados);

		assertEquals(posicion,2);
		
	}
	
	@Test
	public void test05JugadorCon5000PesosQueCaeEnRetrocesoDinamicoYSaca10EnLosDadosNoDeberiaRetroceder() {
		Posicionador posicionador=new Posicionador();
		Jugador jugador=new Jugador("Ana",5000);
		jugador.moverA(retroceso);
		retroceso.ocupar(jugador);
		dados.setNumeros(5,5);
		int posicion=posicionador.posicionDelJugador(jugador, dados);

		assertEquals(posicion,0);
		
	}
	@Test
	public void test06JugadorCon5000PesosQueCaeEnAvanceDinamicoYSaca10EnLosDadosNoDeberiaAvanzar() {
		Posicionador posicionador=new Posicionador();
		Jugador jugador=new Jugador("Ana",5000);
		jugador.moverA(avance);
		avance.ocupar(jugador);
		dados.setNumeros(5,5);
		int posicion=posicionador.posicionDelJugador(jugador, dados);

		assertEquals(posicion,0);
		
	}
	
	@Test
		public void test07JugadorCon3PropiedadesQueCaeEnAvanceDinamicoYSaca11EnLosDadosDeberiaAvanzar8Posiciones() {
			Posicionador posicionador=new Posicionador();
			Jugador jugador=new Jugador("Ana",100000);
			jugador.agregarTerreno(santaFe);
			jugador.agregarTerreno(neuquen);
			jugador.agregarTerreno(tucuman);
			jugador.moverA(avance);
			avance.ocupar(jugador);
			dados.setNumeros(5,6);
			
			int posicion=posicionador.posicionDelJugador(jugador, dados);
			
			assertEquals(posicion,8);
			
		}
	
	
}
