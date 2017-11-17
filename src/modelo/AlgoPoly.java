package modelo;

public class AlgoPoly {
	Tablero tablero;
	Dados dados;
	
	public AlgoPoly() {
		this.tablero = new Tablero();
//<<<<<<< HEAD
	
//=======
		this.armarTablero();
//>>>>>>> branch 'master' of https://github.com/czuczinsky/TP2-AlgoPoly-T6.git
	}

	public void armarTablero() {

		tablero.agregarCasillero(new Salida());
		tablero.agregarCasillero(new Quini6());
		Grupo bsas = new Grupo();
		tablero.agregarCasillero(new Terreno("Bs.As. Sur", bsas, 20000, 2000, 3000, 3500, 5000, 5000, 8000));
		Grupo edesurAysa = new Grupo();
		tablero.agregarCasillero(new Compania("Edesur", 35000, edesurAysa, 500, 1000));
		tablero.agregarCasillero(new Terreno("Bs.As. Norte", bsas, 25000, 2500, 3500, 4000, 6000, 5500, 9000));
		Carcel carcel = new Carcel();
		tablero.agregarCasillero(carcel);
		Grupo cordoba = new Grupo();
		tablero.agregarCasillero(new Terreno("Cordoba Sur", cordoba, 18000, 1000, 1500, 2500, 3000, 2000, 3000));
		tablero.agregarCasillero(new Avance(tablero));
		Grupo subteTren = new Grupo();
		tablero.agregarCasillero(new Compania("Subte", 40000, subteTren, 600, 1100));
		tablero.agregarCasillero(new Terreno("Cordoba Norte", cordoba, 20000, 1300, 1800, 2900, 3500, 2200, 3500));
		tablero.agregarCasillero(new ImpuestoDeLujo());
		Grupo santaFe = new Grupo();
		tablero.agregarCasillero(new Terreno("Santa Fe", santaFe, 15000, 1500, 3500, 4000, 0, 0, 0));
		tablero.agregarCasillero(new Compania("Aysa", 30000, edesurAysa, 300, 500));
		Grupo salta = new Grupo();
		tablero.agregarCasillero(new Terreno("SaltaNorte", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500));
		tablero.agregarCasillero(new Terreno("SaltaSur", salta, 23000, 2000, 3250, 3850, 5500, 4500, 7500));
		tablero.agregarCasillero(new Policia(carcel));
		tablero.agregarCasillero(new Compania("Tren", 38000, subteTren, 450, 800));
		tablero.agregarCasillero(new Terreno("Neuquen", new Grupo(), 17000, 1800, 3800, 4800, 0, 0, 0));
		tablero.agregarCasillero(new Retroceso(tablero));
		tablero.agregarCasillero(new Terreno("Tucuman", new Grupo(), 2500, 7000, 0, 0, 0, 0, 0));

	}
//<<<<<<< HEAD
	

//=======

	public Tablero getTablero() {
		return tablero;
	}
//>>>>>>> branch 'master' of https://github.com/czuczinsky/TP2-AlgoPoly-T6.git
}
