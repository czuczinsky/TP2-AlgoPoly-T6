package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AvanceDinamico;
import modelo.Carcel;
import modelo.Compania;
import modelo.Dados;
import modelo.Grupo;
import modelo.ImpuestoDeLujo;
import modelo.Jugador;
import modelo.Policia;
import modelo.Quini6;
import modelo.RetrocesoDinamico;
import modelo.Salida;
import modelo.Tablero;
import modelo.Terreno;

public class RetrocesoDinamicoTest {

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
		
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsSur);
		
		Compania edesur=new Compania("Edesur", 0,grupo, 0, 0);
		tablero.agregarCasillero(edesur);
		
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsNorte);
		
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaSur);
		
		AvanceDinamico avance=new AvanceDinamico(tablero);
		tablero.agregarCasillero(avance);
		
		Compania subte=new Compania("Subte", 0,grupo, 0, 0);
		tablero.agregarCasillero(subte);
		
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaNorte);
		
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		
		Terreno santaFe=new Terreno("SantaFe",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		
		Compania aysa=new Compania("Aysa", 0,grupo, 0, 0);
		tablero.agregarCasillero(aysa);
		
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaNorte);
		
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaSur);
		
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		
		Compania tren=new Compania("Tren", 0,grupo, 0, 0);
		tablero.agregarCasillero(tren);
		
		Terreno neuquen=new Terreno("Neuquen",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		
		RetrocesoDinamico retroceso=new RetrocesoDinamico(tablero);
		tablero.agregarCasillero(retroceso);
		
		Terreno tucuman=new Terreno("Tucuman",grupo, 0, 0, 0, 0, 0, 0, 0);
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
		
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsSur);
		
		Compania edesur=new Compania("Edesur", 0,grupo, 0, 0);
		tablero.agregarCasillero(edesur);
		
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsNorte);
		
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaSur);
		
		AvanceDinamico avance=new AvanceDinamico(tablero);
		tablero.agregarCasillero(avance);
		
		Compania subte=new Compania("Subte", 0,grupo, 0, 0);
		tablero.agregarCasillero(subte);
		
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaNorte);
		
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		
		Terreno santaFe=new Terreno("SantaFe",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		
		Compania aysa=new Compania("Aysa", 0,grupo, 0, 0);
		tablero.agregarCasillero(aysa);
		
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaNorte);
		
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaSur);
		
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		
		Compania tren=new Compania("Tren", 0,grupo, 0, 0);
		tablero.agregarCasillero(tren);
		
		Terreno neuquen=new Terreno("Neuquen",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		
		RetrocesoDinamico retroceso=new RetrocesoDinamico(tablero);
		tablero.agregarCasillero(retroceso);
		
		Terreno tucuman=new Terreno("Tucuman",grupo, 0, 0, 0, 0, 0, 0, 0);
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
		
		Terreno bsAsSur=new Terreno("BsAsSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsSur);
		
		Compania edesur=new Compania("Edesur", 0,grupo, 0, 0);
		tablero.agregarCasillero(edesur);
		
		Terreno bsAsNorte=new Terreno("BsAsNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(bsAsNorte);
		
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		
		Terreno cordobaSur=new Terreno("CordobaSur", grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaSur);
		
		AvanceDinamico avance=new AvanceDinamico(tablero);
		tablero.agregarCasillero(avance);
		
		Compania subte=new Compania("Subte", 0,grupo, 0, 0);
		tablero.agregarCasillero(subte);
		
		Terreno cordobaNorte=new Terreno("CordobaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(cordobaNorte);
		
		ImpuestoDeLujo impuesto=new ImpuestoDeLujo();
		tablero.agregarCasillero(impuesto);
		
		Terreno santaFe=new Terreno("SantaFe",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(santaFe);
		
		Compania aysa=new Compania("Aysa", 0,grupo, 0, 0);
		tablero.agregarCasillero(aysa);
		
		Terreno saltaNorte=new Terreno("SaltaNorte",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaNorte);
		
		Terreno saltaSur=new Terreno("SaltaSur",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(saltaSur);
		
		Policia policia=new Policia(carcel);
		tablero.agregarCasillero(policia);
		
		Compania tren=new Compania("Tren", 0,grupo, 0, 0);
		tablero.agregarCasillero(tren);
		
		Terreno neuquen=new Terreno("Neuquen",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(neuquen);
		
		RetrocesoDinamico retroceso=new RetrocesoDinamico(tablero);
		tablero.agregarCasillero(retroceso);
		
		Terreno tucuman=new Terreno("Tucuman",grupo, 0, 0, 0, 0, 0, 0, 0);
		tablero.agregarCasillero(tucuman);
		
		
		jugador.moverA(retroceso);
		
		dados.setNumeros(5,6);
		
		retroceso.ocupar(jugador);
		
		assertEquals(cordobaNorte, jugador.getPosicion());
		
		
	}

}
