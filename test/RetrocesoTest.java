package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Avance;
import modelo.Carcel;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;
import modelo.Policia;
import modelo.Quini6;
import modelo.Retroceso;
import modelo.Salida;
import modelo.Tablero;
import modelo.Terreno;

public class RetrocesoTest {

	@Test
	public void test01JugadorCaeEnRetrocesoDinamicoSacando3EnLosDadosAvanzaAPolicia() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		
		Salida salida=new Salida();
		tablero.agregarCasillero(salida);
		Quini6 quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		Compania edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		Avance avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		Compania subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		Compania aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		Compania tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		Terreno neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		Retroceso retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		Terreno tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(1,2);
		
		retroceso.ocupar(jugador);
		
		assertEquals(policia, jugador.getPosicion());
		
		
	}
	
	@Test
	public void test02JugadorCaeEnRetrocesoDinamicoSacando12EnLosDadosRetrocedeASubte() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		
		Salida salida=new Salida();
		tablero.agregarCasillero(salida);
		Quini6 quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		Compania edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		Avance avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		Compania subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		Compania aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		Compania tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		Terreno neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		Retroceso retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		Terreno tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(6,6);
		
		retroceso.ocupar(jugador);
		
		assertEquals(subte, jugador.getPosicion());
		
		
	}
	
	@Test
	public void test03JugadorCaeEnRetrocesoDinamicoSacando11EnLosDadosAvanzaACordobaNorte() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		
		Salida salida=new Salida();
		tablero.agregarCasillero(salida);
		Quini6 quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		Compania edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		Avance avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		Compania subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		Compania aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		Compania tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		Terreno neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		Retroceso retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		Terreno tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(5,6);
		
		retroceso.ocupar(jugador);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
	}
	
	@Test
	public void test04JugadorCaeEnRetrocesoDinamicoSacando10EnLosDadosYNoRetrocedeNingunaPosicion() {
		Jugador jugador = new Jugador("Jugador", 100000);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		
		Salida salida=new Salida();
		tablero.agregarCasillero(salida);
		Quini6 quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		Compania edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		Avance avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		Compania subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		Compania aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		Compania tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		Terreno neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		Retroceso retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		Terreno tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(5,5);
		
		retroceso.ocupar(jugador);
		
		assertEquals(retroceso, jugador.getPosicion());
	}
	
	@Test
	public void test05JugadorCaeEnRetrocesoDinamicoSacando9EnLosDadosYRetrocedeASaltaNorte() {
		Jugador jugador = new Jugador("Jugador", 77000);
		Dados dados = Dados.getDados();
		Tablero tablero = new Tablero();
		
		Salida salida=new Salida();
		tablero.agregarCasillero(salida);
		Quini6 quini=new Quini6();
		tablero.agregarCasillero(quini);
		Grupo grupo=new Grupo();
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		tablero.agregarCasillero(bsAsSur);
		Compania edesur=new Compania("Edesur", 35000,grupo, 500, 1000);
		tablero.agregarCasillero(edesur);
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		tablero.agregarCasillero(cordobaSur);
		Avance avance=new Avance(tablero);
		tablero.agregarCasillero(avance);
		Compania subte=new Compania("Subte", 40000,grupo, 600, 1100);
		tablero.agregarCasillero(subte);
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		tablero.agregarCasillero(cordobaNorte);
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		Terreno santaFe=new Terreno("SantaFe",grupo, 15000, 1500, 3500, 4000, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		Compania aysa=new Compania("Aysa", 30000,grupo, 300, 500);
		tablero.agregarCasillero(aysa);
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaNorte);
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		tablero.agregarCasillero(saltaSur);
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		Compania tren=new Compania("Tren", 38000,grupo, 450, 800);
		tablero.agregarCasillero(tren);
		Terreno neuquen=new Terreno("Neuquen",grupo, 17000, 1800, 3800, 4800, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		Retroceso retroceso=new Retroceso(tablero);
		tablero.agregarCasillero(retroceso);
		Terreno tucuman=new Terreno("Tucuman",grupo, 2500, 7000, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(5,4);
		
		retroceso.ocupar(jugador);
		
		assertEquals(saltaNorte, jugador.getPosicion());
	}

}
