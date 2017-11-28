package modelo;

import java.util.ArrayList;

public class AlgoPoly {
	private Tablero tablero;
	private Dados dados;
	private Turno turno;
	private ArrayList<Jugador> jugadores;
	private boolean dadosTirados;

	public AlgoPoly() {
		this.tablero = new Tablero();
		this.jugadores = new ArrayList<Jugador>();
		this.armarTableroYJugadores();
		this.dados = new Dados();
		this.turno = new Turno(jugadores);
		this.turno.siguienteJugador(this.dados);
		this.dadosTirados = false;
	}

	public void armarTableroYJugadores() {
		Grupo bsas = new Grupo();
		Grupo edesurAysa = new Grupo();
		Grupo cordoba = new Grupo();
		Grupo subteTren = new Grupo();
		Grupo salta = new Grupo();
		Agrupable bsAsSur = new Terreno("Bs.As. SUR", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Agrupable edesur = new Compania("EDESUR", 35000, edesurAysa, 500, 1000);
		Agrupable bsAsNorte = new Terreno("Bs.As. NORTE", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Agrupable cordobaSur = new Terreno("CORDOBA SUR", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000);
		Agrupable subte = new Compania("SUBTE", 40000, subteTren, 600, 1100);
		Agrupable cordobaNorte = new Terreno("CORDOBA NORTE", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500);
		Agrupable santaFe = new Terreno("SANTA FE", new Grupo(), 15000, 1500, 3500, 0, 0, 4000, 0);
		Agrupable aysa = new Compania("AYSA", 30000, edesurAysa, 300, 500);
		Agrupable saltaNorte = new Terreno("SALTA NORTE", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable saltaSur = new Terreno("SALTA SUR", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500);
		Agrupable tren = new Compania("TREN", 38000, subteTren, 450, 800);
		Agrupable neuquen = new Terreno("NEUQUEN", new Grupo(), 17000, 1800, 3800, 0, 0, 4800, 0);
		Agrupable tucuman = new Terreno("TUCUMAN", new Grupo(), 25000, 2500, 4500, 0, 0, 7000, 0);

		Salida salida = new Salida();
		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(new Quini6());
		tablero.agregarCasillero(bsAsSur);
		tablero.agregarCasillero(edesur);
		tablero.agregarCasillero(bsAsNorte);
		Carcel carcel = new Carcel();
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
		if (turno.getJugadorActual().getPosicion().puedeMoverse(turno.getJugadorActual())) {
			try {
				tablero.avanzar(turno.getJugadorActual(), dados.getSuma(), dados);
			} catch (SinDineroException e) {
				turno.borrar();
			}
		}
		turno.getJugadorActual().getPosicion().avanzarTurnoDe(turno.getJugadorActual());
		turno.siguienteJugador(dados);
		this.dadosTirados = false;
	}

	public void tirarDados() {
		dados.tirar();
		dadosTirados = true;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public Dados getDados() {
		return dados;
	}

	public Jugador getJugadorActual() {
		return this.turno.getJugadorActual();
	}

	/*public boolean puedeMover() {
		return (this.dadosTirados && this.turno.getJugadorActual().puedoMoverse());
	}

	public boolean puedeTirarDados() {
		return (this.turno.getJugadorActual().puedoMoverse() && !this.dadosTirados);
	}

	public boolean debePasarTurno() {
		return !this.turno.getJugadorActual().puedoMoverse();
	}*/

	
// para prueba /////////////////////////////////
	public boolean puedeMover() {
		return true;
	}
	public boolean puedeTirarDados() {
		return true;
	}

	public boolean debePasarTurno() {
		return false;
	}

}
