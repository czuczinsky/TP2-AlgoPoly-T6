package modelo;

import java.util.ArrayList;

public class AlgoPoly {
	Tablero tablero;
	Dados dados;
	Turno turno;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();


	public AlgoPoly() {
		this.tablero = new Tablero();
		this.armarTableroYJugadores();
		this.dados = new Dados();
		this.turno = new Turno(jugadores);

		// TODO SACAR!!! llamada para inicializar en un estado que permita probar la
		// Vista
		armarEstadoInicialTrucho();
	}

	private void armarEstadoInicialTrucho() {
		//TODO Sacar este metodo
		tablero.avanzar(jugadores.get(0), 2, dados); // mueve jugador Rojo a bsasSur
		tablero.avanzar(jugadores.get(1), 3, dados); // mueve jugador Verde a Edesur
		tablero.avanzar(jugadores.get(2), 8, dados); // mueve jugador Azul a subte

		((Terreno) tablero.getCasilleros().get(2)).venderA(jugadores.get(0)); // bsasSur a jugador Rojo
		((Terreno) tablero.getCasilleros().get(4)).venderA(jugadores.get(0)); // bsasNorte a jugador Rojo
		((Terreno) tablero.getCasilleros().get(6)).venderA(jugadores.get(1)); // CordobaSur a jugador Verde
		((Compania) tablero.getCasilleros().get(8)).venderA(jugadores.get(2)); // CordobaSur a jugador Azul
		((Terreno) tablero.getCasilleros().get(11)).venderA(jugadores.get(2)); // SantaFe a jugador Azul
		((Terreno) tablero.getCasilleros().get(17)).venderA(jugadores.get(1)); // Neuquen a jugador Verde
	}

	public void armarTableroYJugadores() {
		Grupo bsas = new Grupo();
		Grupo edesurAysa = new Grupo();
		Grupo cordoba = new Grupo();
		Grupo subteTren = new Grupo();
		Grupo salta = new Grupo();
		Agrupable bsAsSur=new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Agrupable edesur=new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Agrupable bsAsNorte=new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Agrupable cordobaSur=new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Agrupable subte=new Compania("SUBTE", 40000, subteTren, 600, 1100);
		Agrupable cordobaNorte=new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Agrupable santaFe=new Terreno("SANTA FE", new Grupo(), 15000, 1500, 3500, 0, 0, 4000, 0);
		Agrupable aysa=new Compania("AYSA", 30000, edesurAysa, 300, 500);
		Agrupable saltaNorte=new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable saltaSur=new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable tren=new Compania("TREN", 38000, subteTren, 450, 800);
		Agrupable neuquen=new Terreno("NEUQUEN", new Grupo(), 17000, 1800, 3800, 0, 0, 4800, 0);
		Agrupable tucuman=new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);

		Salida salida = new Salida();
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(new Quini6());
		tablero.agregarCasillero(bsAsSur);
		tablero.agregarCasillero(edesur);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel=new Carcel();
		tablero.agregarCasillero(carcel);
		tablero.agregarCasillero(cordobaSur);
		tablero.agregarCasillero(new Avance(tablero));
		tablero.agregarCasillero(subte);
		tablero.agregarCasillero(cordobaNorte);
		tablero.agregarCasillero(new ImpuestoAlLujo());
		tablero.agregarCasillero(santaFe);
		tablero.agregarCasillero(aysa);
		tablero.agregarCasillero(saltaNorte);
		tablero.agregarCasillero(saltaSur);
		tablero.agregarCasillero(new Policia(carcel));
		tablero.agregarCasillero(tren);
		tablero.agregarCasillero(neuquen);
		tablero.agregarCasillero(new Retroceso(tablero));
		tablero.agregarCasillero(tucuman);

		
		jugadores.add(new Jugador("Rojo", 100000));
		jugadores.add(new Jugador("Verde", 100000));
		jugadores.add(new Jugador("Azul", 100000));

		for (Jugador jugador : this.jugadores)
			jugador.moverA(salida, dados);
		
	}
	
	public void mover() {
		if (turno.getJugadorActual().getPosicion().puedeMoverse(turno.getJugadorActual()))
			tablero.avanzar(turno.getJugadorActual(), dados.getSuma(), dados);
		turno.getJugadorActual().getPosicion().avanzarTurnoDe(turno.getJugadorActual());
		turno.siguienteJugador(dados);
	}

	public void tirarDados() {
		dados.tirar();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public Turno getTurno() {
		return turno;
	}

	public Dados getDados() {
		return dados;
	}
}
